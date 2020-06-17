package LeetCode.design.Mocks;

public class UserDaySchedule {
    int scheduledInterviewsNumber;
    String shortDayName;
    Slot[] slots = new Slot[24];

    static UserDaySchedule parseDay(String preferableTimeSlots, String dayShort) {
        UserDaySchedule userDaySchedule = new UserDaySchedule(dayShort);
        if (preferableTimeSlots.isEmpty()) {
            return userDaySchedule;
        }
        String[] parts = preferableTimeSlots.replaceAll(" ", "").split(",");
        for (String part : parts) {
            if (part.isEmpty() || part.equals("-")) {
                continue;
            }
            String[] fromTo = part.split("-");
            if (fromTo.length != 2) {
                throw new IllegalArgumentException("Bad day schedule part: "+ part + " in preferableTimeSlots: " + preferableTimeSlots);
            }
            int from = 0;
            int to = 0;
            try {
                from = Integer.parseInt(fromTo[0].startsWith("0") && !fromTo[0].equalsIgnoreCase("0") ?
                        fromTo[0].substring(1, fromTo[0].length()) : fromTo[0]);
                to = Integer.parseInt(fromTo[1].startsWith("0") && !fromTo[1].equalsIgnoreCase("0") ?
                        fromTo[1].substring(1, fromTo[1].length()) : fromTo[1]);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Bad day schedule part, Integer.parseInt exception in preferableTimeSlots: " + preferableTimeSlots);
            }

            // fix the case when time ends on midnight
            if (to == 0) {
                to = 24;
            }
            if (to < 1 || to > 24 || from < 0 || from > 23 || from > to) {
                throw new IllegalArgumentException("Bad from/to in schedule part. from: " + from + "to: " + to+ " in preferableTimeSlots: " + preferableTimeSlots);
            }
            // open slots
            userDaySchedule.bulkStateUpdate(from, to, SlotState.FREE);
        }
        return userDaySchedule;
    }

    UserDaySchedule(String dayShortName) {
        this.shortDayName = dayShortName;
        this.scheduledInterviewsNumber = 0;
        for (int i=0; i<24; i++) {
            this.slots[i] = new Slot(i, SlotState.BLOCKED);
        }
    }

    private UserDaySchedule() {
    }

    // from - included, to - excluded
    void bulkStateUpdate(int from, int to, SlotState state) {
        for (int i=from; i<to; i++) {
            this.slots[i].updateState(state);
        }
    }

    /** scheduledInterviewsNumber is not copied */
    UserDaySchedule freshCopy() {
        UserDaySchedule clone = new UserDaySchedule();
        clone.shortDayName = this.shortDayName;
        clone.scheduledInterviewsNumber = 0;
        for (int i=0; i<24; i++) {
            clone.slots[i] = this.slots[i].freshCopy();
        }
        return clone;
    }

    boolean hasFreeSlots() {
        for (Slot s : slots) {
            if (s.state == SlotState.FREE) return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DAY: "+ shortDayName + "\n");
        for (int i=0; i<24; i++) {
            sb.append(this.slots[i].toString() + "\n");
        }
        return sb.toString();
    }

    public String printDay(boolean printShortVersion) {
        StringBuilder sb = new StringBuilder();
        sb.append(printShortVersion ? "" : shortDayName.toUpperCase() + ": ");
        for (int i=0; i<24; i++) {
            if (this.slots[i].state == SlotState.SCHEDULED) {
                sb.append(this.slots[i].isPrimary ? "Prm " : "");
                sb.append(this.slots[i].time + ":00 " + this.slots[i].opponent.telegramId + "; ");
            }
        }
        sb.append(", "); // end of the day separator
        return sb.toString();
    }
}
