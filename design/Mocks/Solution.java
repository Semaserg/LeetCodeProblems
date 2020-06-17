package LeetCode.design.Mocks;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int RUNS = 1;// make it 10

    List<Timetable> generateTimetableCandidates(String[] userRecords) {
        List<Timetable> result = new ArrayList<>();
        // users original copy, make a new copy for each timetable candidate
        List<User> users = parseUsers(userRecords);
        for (int i=0; i< RUNS; i++) {
            List<User> usersCopy = freshCopy(users);
            Timetable t = Timetable.generateTimetable(usersCopy);
            result.add(t);
        }
        return result;
    }

    List<User> parseUsers(String[] userRecords) {
        List<User> users = new ArrayList<>();
        for (int i=0; i<userRecords.length; i++) {
            users.add(User.parseUser(i+1, userRecords[i]));
        }
        /*for (User u : users) {
            System.out.println(u.toString());
        }*/
        return users;
    }

    List<User> freshCopy(List<User> users) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.freshCopy());
        }
        // quick check
        assert (users.size() == result.size());
        assert (users.get(0).telegramId.equals(result.get(0).telegramId));
        return result;
    }
}
