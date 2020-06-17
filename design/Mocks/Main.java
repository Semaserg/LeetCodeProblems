package LeetCode.design.Mocks;

import java.util.List;

class Main {
    public static void main (String[] args) throws Exception
    {
        Solution  solution = new Solution();
        String[] adv = new String[]{
                "telegram:	@user1	; InterviewPerDay:	1	;	Fri: 15-18; Sat: 15-18; Sun: 15-18; Mon: 15-18; Tue: 15-18; Wed: 15-18; Thu: 15-18;	",
                "telegram:	@user2	; InterviewPerDay:	1	;	Fri: -; Sat: -; Sun: 18-0; Mon: -; Tue: 18-19; Wed: 18-19; Thu: 18-19;	",
                "telegram:	@user3	; InterviewPerDay:	2	;	Fri: 11-20; Sat: 11-20; Sun: 11-20; Mon: 11-20; Tue: 11-13, 14-20; Wed: 11-20; Thu: 11-20;	",
        };

        String[] beginners = new String[]{
                "telegram:	@user4	; InterviewPerDay:	1	;	Fri: -; Sat:18-19; Sun: 18-19; Mon: 16-17; Tue: -; Wed: -; Thu: -;	",
                "telegram:	@user5	; InterviewPerDay:	2	;	Fri:17-21;Sat:17-21;Sun:17-21;Mon:17-21;Tue:17-21;Wed:17-21;Thu:17-21;	",
        };

        List<Timetable> timetableCandidates = solution.generateTimetableCandidates(beginners);
        //List<Timetable> timetableCandidates = solution.generateTimetableCandidates(adv);
        timetableCandidates.sort((a, b) -> b.score - a.score);
        for(int i=0; i<timetableCandidates.size(); i++) {
            timetableCandidates.get(i).printToFile("candidate" + (i+1) + ".txt");
        }
    }
}

