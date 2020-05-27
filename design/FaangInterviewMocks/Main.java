package LeetCode.design.FaangInterviewMocks;

import java.util.List;

class Main {
    public static void main (String[] args) throws Exception
    {
        Solution  solution = new Solution();
        String[] adv = new String[]{
                // advanced:
                "telegram:	@my_telegram	; InterviewPerDay:	2	;	Fri: 11-16; Sat: 6-16; Sun: 6-16; Mon: 12-16; Tue: 12-16; Wed: 12-16; Thu: 12-16;	",

        };

        String[] beginners = new String[]{
                "telegram:	@my_telegram1	; InterviewPerDay:	2	;	Fri: 11-16; Sat: 6-16; Sun: 6-16; Mon: 12-16; Tue: 12-16; Wed: 12-16; Thu: 12-16;	",
        };

        List<Timetable> timetableCandidates = solution.generateTimetableCandidates(beginners);
        //List<Timetable> timetableCandidates = solution.generateTimetableCandidates(adv);
        timetableCandidates.sort((a, b) -> b.score - a.score);
        for(int i=0; i<timetableCandidates.size(); i++) {
            timetableCandidates.get(i).printToFile("candidate" + (i+1) + ".txt");
        }
    }
}

