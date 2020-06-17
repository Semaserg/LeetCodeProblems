package LeetCode.design.Mocks;

public class Slot {
    int time; //0-23 in PST
    SlotState state;
    User opponent; // TODO: make a test to check that that opponent has this user as opponent.
    boolean isPrimary;

    Slot(int time, SlotState state) {
        this.state = state;
        this.time = time;
    }

    void updateState(SlotState state) {
        this.state = state;
    }

    /** User and isPrimary is not copied */
    Slot freshCopy() {
        return new Slot(this.time, this.state);
    }

    public String toString() {
        return String.format("SLOT: time: %d state: %s", time, state);
    }
}
