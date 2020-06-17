package LeetCode.design.Mocks;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    int id; // internal id for sorting
    String telegramId;
    String timeZone; // examples: "UTC+1", "UTC-4"
    int preferableInterviewsPerDay;
    int preferableInterviewsTotal;
    int interviewsTotal;
    UserDaySchedule[] week;

    User(int id, String telegramId, String timeZone, int preferableInterviewsPerDay, UserDaySchedule[] week) {
        this.id = id;
        this.telegramId = telegramId;
        this.timeZone = timeZone;
        this.preferableInterviewsPerDay = preferableInterviewsPerDay;
        this.week = week;
        this.preferableInterviewsTotal = calcPreferableInterviewTotal();
    }

    // userRecord format: telegram: telegramId; InterviewPerDay: 2; Fri: 10-13, 15-18; Sat: 10-13;  Sun: -; Mon: -; Tue: -; Wed: -; Thu: -;
    static User parseUser(int id, String userRecord) {
        String userRecordFormatted = userRecord.trim().toLowerCase();
        String telegram = getDataByPattern(userRecordFormatted, "telegram:");
        String timeZone =  "UTC+2"; //getDataByPattern(userRecordFormatted, "timezone:");
        check(!telegram.isEmpty(), "telegram is empty");

        int interviewsPerDay = Integer.parseInt(getDataByPattern(userRecordFormatted, "interviewperday:"));
        check(interviewsPerDay >= 1 && interviewsPerDay <= 3, "interview per day is not correct");

        UserDaySchedule[] userWeek = new UserDaySchedule[7]; // starts form Friday
        userWeek[0] = UserDaySchedule.parseDay(getDataByPattern(userRecordFormatted, "fri:"), "fri");
        userWeek[1] = UserDaySchedule.parseDay(getDataByPattern(userRecordFormatted, "sat:"), "sat");
        userWeek[2] = UserDaySchedule.parseDay(getDataByPattern(userRecordFormatted, "sun:"), "sun");
        userWeek[3] = UserDaySchedule.parseDay(getDataByPattern(userRecordFormatted, "mon:"), "mon");
        userWeek[4] = UserDaySchedule.parseDay(getDataByPattern(userRecordFormatted, "tue:"), "tue");
        userWeek[5] = UserDaySchedule.parseDay(getDataByPattern(userRecordFormatted, "wed:"), "wed");
        userWeek[6] = UserDaySchedule.parseDay(getDataByPattern(userRecordFormatted, "thu:"), "thu");
        return new User(id, telegram, timeZone, interviewsPerDay, userWeek);
    }

    // TODO: remove this temp check
    static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    static String getDataByPattern(String userRecord, String patternStart) {
        Pattern pattern = Pattern.compile(patternStart + "(.*?);");
        Matcher matcher = pattern.matcher(userRecord);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        throw new IllegalArgumentException(patternStart + " pattern is not found in the user record: " + userRecord);
    }

    int calcPreferableInterviewTotal() {
        int total = 0;
        for(UserDaySchedule schedule : this.week) {
            // if user has open slots this day we assume that he can do max number of interviews
            if (schedule.hasFreeSlots()) {
                total += this.preferableInterviewsPerDay;
            }
        }
        return total;
    }

    /** makes a copy without scheduled interviews */
    User freshCopy() {
        UserDaySchedule[] week = new UserDaySchedule[7];
        for (int i = 0; i<7; i++) {
            week[i] = this.week[i].freshCopy();
        }
        return new User(this.id, this.telegramId, this.timeZone, this.preferableInterviewsPerDay, week);
    }

    public int scheduledInterviews(int dayIndex) {
        return this.week[dayIndex].scheduledInterviewsNumber;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("USER: telegram: %s \n preferableInterviewsPerDay: %d \n",
                this.telegramId, this.preferableInterviewsPerDay));
        for (UserDaySchedule day : this.week) {
            sb.append(day.toString());
        }
        return sb.toString();
    }

    public String printSchedule(boolean printShortVersion) {
        StringBuilder sb = new StringBuilder();
        if (printShortVersion) {
            sb.append(String.format(
                    "%s, PrefPerDay: %d, SameOpp: %d, PrefTotal %d, Total %d, ",
                    this.telegramId, this.preferableInterviewsPerDay, this.calcInterviewsWithSameOpponent(),
                    this.preferableInterviewsTotal, this.interviewsTotal));
        } else {
            sb.append(String.format(
                    "id: %d, telegram: %s, PreferableInterviewsPerDay: %d, SameOpponentTimes: %d, PreferableInterviewsTotal %d, TotalInterviews %d, ",
                    this.id, this.telegramId, this.preferableInterviewsPerDay, this.calcInterviewsWithSameOpponent(),
                    this.preferableInterviewsTotal, this.interviewsTotal));
        }
        for (UserDaySchedule day : this.week) {
            sb.append(day.printDay(printShortVersion));
        }
        return sb.toString();
    }

    public int calcInterviewsWithSameOpponent() {
        Map<User, Integer> hasInterviewWith = new HashMap<>();
        for (int i=0; i<7; i++) {
            Slot[] slots = this.week[i].slots;
            for (Slot s : slots) {
                if (s.state == SlotState.SCHEDULED) {
                    User opponent = s.opponent;
                    // in case of one user has > 2 interviews with the same opponent use map to hold counter.
                    if (hasInterviewWith.containsKey(opponent)) {
                        hasInterviewWith.put(opponent, hasInterviewWith.get(opponent) + 1);
                    } else {
                        hasInterviewWith.put(opponent, 0); // first interview with opponent doesn't count
                    }
                }
            }
        }
        int result = hasInterviewWith.values().parallelStream().reduce(0, Integer::sum);
        // System.out.println("Same interviews for user " + this.telegramId + " = " + result);
        return result;
    }
}
