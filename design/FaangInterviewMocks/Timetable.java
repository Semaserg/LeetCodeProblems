package LeetCode.design.FaangInterviewMocks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Timetable {
    private final Random random = new Random();
    private final static String path = "C:\\GitHub\\LeetCode\\src\\LeetCode\\design\\FaangInterviewMocks\\Results\\";
    private static final int MAX_INTERVIEWS_PER_DAY  = 2;

    int totalInterviews;
    int sameOpponenetInteviews;
    int score;

    List<User> users;

    static Timetable generateTimetable(List<User> users) {
        Timetable timetable = new Timetable(users);
        timetable.shuffleUsers();
        timetable.scheduleFirstInterviewRound();
        timetable.scheduleSecondInterviewRound();  // TODO: use scheduleFirstInterviewRound in the second round
        timetable.calcSameOpponenetInteviews();
        timetable.calcScore();
        timetable.restoreUsersOrder();
        return timetable;
    }

    private Timetable(List<User> users) {
        this.users = users;
    }

    void shuffleUsers() {
        Collections.shuffle(users);
    }

    void restoreUsersOrder() {
        Collections.sort(users, Comparator.comparingInt(x -> x.id));
    }

    Map<Integer, List<User>> scheduleFirstInterviewRound() {
        // iterate through days 0 (fri) to 6 (thu)
        Map<Integer, List<User>> usersWithNoInterviewScheduled = new HashMap<>();
        for (int dayIndex=0; dayIndex<7; dayIndex++) {
            for (User user : this.users) {
                // skip if 1st interview is already scheduled
                if (user.scheduledInterviews(dayIndex) == 0) { // no interviews scheduled yet
                    // find opponent
                    List<User> opponents = findOpponentsForUser(user, dayIndex, 1);
                    System.out.println(String.format("User %s has %d opponent for %s",
                            user.telegramId, opponents.size(), user.week[dayIndex].shortDayName));
                    // schedule interview with random opponent
                    if (opponents.size() > 0) {
                        User finalOpponent = opponents.get(random.nextInt(opponents.size()));
                        int slotIndex = findCrossSlot(user, finalOpponent, dayIndex);
                        scheduleInterview(user, finalOpponent, dayIndex, slotIndex);
                    } else {
                        List<User> ul = usersWithNoInterviewScheduled.getOrDefault(dayIndex, new ArrayList<>());
                        ul.add(user);
                        usersWithNoInterviewScheduled.put(dayIndex, ul);
                    }
                }
            }
        }
        return usersWithNoInterviewScheduled;
    }

    void scheduleSecondInterviewRound() {
        // iterate through days 0 (fri) to 6 (thu)
        for (int dayIndex=0; dayIndex<7; dayIndex++) {
            for (User user : this.users) {
                // skip users which already have 2 interviews
                if (user.preferableInterviewsPerDay > 1 && // user would like to have more than 1 interview per day
                    user.scheduledInterviews(dayIndex) < 2) { // user has 0 or 1 interviews this day
                    // find opponent
                    List<User> opponents = findOpponentsForUser(user, dayIndex, 2);
                    System.out.println(String.format("User %s has %d opponent for %s",
                            user.telegramId, opponents.size(), user.week[dayIndex].shortDayName));
                    // schedule interview with random opponent
                    if (opponents.size() > 0) {
                        User finalOpponent = opponents.get(random.nextInt(opponents.size()));
                        int slotIndex = findCrossSlot(user, finalOpponent, dayIndex);
                        scheduleInterview(user, finalOpponent, dayIndex, slotIndex);
                    }
                }
            }
        }
    }



    /** dayIndex is 0 to 6: 0 is Friday, 6 - is Thursday */
    List<User> findOpponentsForUser(User user, int dayIndex, int maxInterviewRestriction) {
        List<User> result = new ArrayList<>();
        check(dayIndex >= 0 && dayIndex <= 6, "dayIndex is incorrect");
        for (User candidate : this.users) {
            // do not pick same user as a candidate
            if (candidate == user) {
                continue;
            }
            check (candidate.week[dayIndex].scheduledInterviewsNumber <= candidate.preferableInterviewsPerDay,
                    "scheduledInterviewsNumber > preferableInterviewsPerDay");
            // for 1st round restrict max interview to 1, to schedule each person just one interview
            if (candidate.week[dayIndex].scheduledInterviewsNumber > maxInterviewRestriction) {
                continue;
            }
            // candidate has enough interview for this day for this round
            if (candidate.week[dayIndex].scheduledInterviewsNumber == candidate.preferableInterviewsPerDay ||
                candidate.week[dayIndex].scheduledInterviewsNumber == MAX_INTERVIEWS_PER_DAY) {
                continue;
            }
            // if not the first day, check if user and candidate has an interview a day ago.
            // if yes - do not pick the same opponent 2 days in a row
            if (dayIndex > 0 && hasInterview(user, candidate, dayIndex-1)) {
                continue;
            }
            // if user and candidate already have interview today
            if (hasInterview(user, candidate, dayIndex)) {
                continue;
            }
            // if user and candidate already have interview tomorrow: this is for 2nd round
            if (dayIndex < 6 && hasInterview(user, candidate, dayIndex+1)){
                continue;
            }
            // check time
            int crossSlotIndex = findCrossSlot(user, candidate, dayIndex);
            if (crossSlotIndex >= 0) {
                result.add(candidate);
            }
        }
        return result;
    }

    /** returns -1 if no cross slots*/
    int findCrossSlot(User userA, User userB, int dayIndex) {
        check(userA != null && userB != null && userA != userB, "users are incorrect");
        UserDaySchedule scheduleA = userA.week[dayIndex];
        UserDaySchedule scheduleB = userB.week[dayIndex];
        // grab the first common slot between to users
        for (int i=0; i<24; i++) {
            if (scheduleA.slots[i].state == SlotState.FREE && scheduleB.slots[i].state == SlotState.FREE) {
                return i;
            }
        }
        return -1;
    }

    void scheduleInterview(User userA, User userB, int dayIndex, int slotIndex) {
        check(userA != null && userB != null && userA != userB, "users are incorrect");

        Slot slotA = userA.week[dayIndex].slots[slotIndex];
        Slot slotB = userB.week[dayIndex].slots[slotIndex];
        check(slotA.state == SlotState.FREE && slotB.state == SlotState.FREE, "Not all slots are free");
        boolean isPrimary = random.nextBoolean();

        slotA.state = SlotState.SCHEDULED;
        slotA.opponent = userB;
        slotA.isPrimary = isPrimary;

        slotB.state = SlotState.SCHEDULED;
        slotB.opponent = userA;
        slotB.isPrimary = !isPrimary;

        // just double-check that slot index == time
        check(slotA.time == slotIndex && slotB.time == slotIndex, "time != slotIndex");

        // Make neighbour slots ONHOLD
        holdNeighborSlot(userA.week[dayIndex].slots, slotIndex);
        holdNeighborSlot(userB.week[dayIndex].slots, slotIndex);

        // update total counters
        this.totalInterviews++;
        userA.interviewsTotal++;
        userB.interviewsTotal++;
        // update day interviews counters
        userA.week[dayIndex].scheduledInterviewsNumber++;
        userB.week[dayIndex].scheduledInterviewsNumber++;
    }

    /** makes slots around ONHOLD */
    void holdNeighborSlot(Slot[] slots, int slotIndex) {
        check(slots.length == 24, "slots.length != 24");
        // corner cases when a slot in the beginning of the day or end of the day.
        // not blocking pre/next day slots yet.
        if (slotIndex > 0) {
            check(slots[slotIndex - 1].state != SlotState.SCHEDULED, "Slot is Scheduled instead");
            slots[slotIndex - 1].state = SlotState.ONHOLD;
        }
        if (slotIndex < 23) {
            check(slots[slotIndex + 1].state != SlotState.SCHEDULED, "Slot is Scheduled instead");
            slots[slotIndex + 1].state = SlotState.ONHOLD;
        }
    }

    boolean hasInterview(User userA, User userB, int dayIndex) {
        check(userA != null && userB != null && userA != userB, "users are incorrect");
        check(dayIndex >= 0 && dayIndex <= 6, "dayIndex is incorrect");
        for (int slotIndex = 0; slotIndex < 24; slotIndex++) {
            Slot slot = userA.week[dayIndex].slots[slotIndex];
            if (slot.opponent != null && slot.opponent.telegramId.equals(userB.telegramId)) {
                // just double-check
                check(userB.week[dayIndex].slots[slotIndex].opponent.telegramId.equals(userA.telegramId),
                        "Users bi-directional connection is broken");
                return true;
            }
        }
        return false;
    }

    void calcSameOpponenetInteviews() {
        int total = 0;
        for (User user : this.users) {
            total += user.calcInterviewsWithSameOpponent();
        }
        this.sameOpponenetInteviews = total / 2;
    }

    void calcScore() {
        int timetableScore = this.totalInterviews - this.sameOpponenetInteviews;
        for (User user : this.users) {
            int sameOppontForUser = user.calcInterviewsWithSameOpponent();
            if (user.calcInterviewsWithSameOpponent() == 3) {
                timetableScore = timetableScore - 2;
            } else if (user.calcInterviewsWithSameOpponent() >= 4) {
                timetableScore = timetableScore - 3;
            };

            check(user.preferableInterviewsTotal >= user.interviewsTotal, "interviewsTotal > preferableInterviewsTotal");
            int openDaysForUser = user.preferableInterviewsTotal / user.preferableInterviewsPerDay;
            if (user.interviewsTotal < openDaysForUser) {
                timetableScore = timetableScore - 2;
            }
        }
        this.score = timetableScore;
    }

    // use to print timetable in console
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TIMETABLE: \n");
        for (User u : users) {
            sb.append(u.toString() + "\n");
        }
        return sb.toString();
    }

    public void printToFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append("Total interviews: " + this.totalInterviews + "\n");
        sb.append("Total with same opponent: " + this.sameOpponenetInteviews+ "\n");
        sb.append("Timetable score: " + this.score + "\n");
        for (User user: this.users) {
            sb.append(user.printSchedule(true) + "\n");
        }
        write(sb.toString(), fileName);
    }

    private static void write(String data, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName, true));
            writer.append(data);
            writer.close();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}