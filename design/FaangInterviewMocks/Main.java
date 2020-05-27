package LeetCode.design.FaangInterviewMocks;

import java.util.List;

class Main {
    public static void main (String[] args) throws Exception
    {
        Solution  solution = new Solution();
        String[] adv = new String[]{
                // advanced:
                "telegram:	@bogdangr	; InterviewPerDay:	2	;	Fri: 11-16; Sat: 6-16; Sun: 6-16; Mon: 12-16; Tue: 12-16; Wed: 12-16; Thu: 12-16;	",
                "telegram:	@abdujabbor1987	; InterviewPerDay:	1	;	Fri: 19-21; Sat: 19-21; Sun: 19-21; Mon: 19-21; Tue: 19-21; Wed: 19-21; Thu: -;  	",
                "telegram:	@notelninho	; InterviewPerDay:	1	;	 Fri: -; Sat: -; Sun: -; Mon: 9-13; Tue: 9-13; Wed: 9-13; Thu: 9-13;	",
                "telegram:	@pavlo_andriiesh	; InterviewPerDay:	3	;	 Fri: -; Sat: -; Sun: -; Mon: 9-18; Tue: 9-18; Wed: 9-18; Thu: 9-18;	",
                "telegram:	@kurmanbay	; InterviewPerDay:	3	;	Fri: 6-19; Sat: 6-19; Sun: 6-19; Mon: 6-19; Tue: 6-19; Wed: 6-19; Thu: 6-19;	",
                "telegram:	@the_real_chupacabra	; InterviewPerDay:	1	;	Fri: -; Sat: 19-0; Sun: 0-2; Mon: -; Tue: -; Wed: 22-0; Thu: -;	",
                "telegram:	@boooiv	; InterviewPerDay:	1	;	Fri: -; Sat: -; Sun: -; Mon: 10-15; Tue: 10-15; Wed: 10-15; Thu: 10-15;	",
                "telegram:	sergeygonta	; InterviewPerDay:	1	;	Fri: 20-22; Sat: 10-22; Sun: 10-22; Mon: 20-22; Tue: 20-22; Wed: 20-22; Thu: 20-22;	",
                "telegram:	@Dan783	; InterviewPerDay:	1	;	Fri: 13-22; Sat: 13-22; Sun: 13-22; Mon: 13-22; Tue: 13-22; Wed:13-22; Thu: 13-22;	",
                "telegram:	levrun1	; InterviewPerDay:	1	;	Fri: -; Sat: -; Sun: -; Mon: 18-22; Tue: 18-22; Wed: -; Thu: 18-22;	",
                "telegram:	@mag_o_med	; InterviewPerDay:	1	;	Fri: 11-18; Sat: 11-18; Sun:11-18; Mon: -; Tue: -; Wed: 10-18; Thu: 10-18;	",
                "telegram:	@pavel_rodionov	; InterviewPerDay:	1	;	Fri: 10-21; Sat: 10-14, 18-20; Sun: 10-14, 18-20; Mon: -; Tue: -; Wed: 18-22; Thu: 18-22;	",
                "telegram:	@mr_omti	; InterviewPerDay:	1	;	Fri: -; Sat: 22-0; Sun: -; Mon: -; Tue: 22-0; Wed: -; Thu: -;	",
                "telegram:	@emil_dev	; InterviewPerDay:	1	;	Fri: 14-15; Sat: 10-11; Sun: 10-11; Mon: 14-15; Tue: 14-15; Wed: 14-15; Thu: 14-15;	",
                "telegram:	@looseend	; InterviewPerDay:	3	;	Fri: 10-21; Sat:10-21; Sun: 14-21; Mon: 17-21; Tue: 11-12,17-21; Wed: 11-12,16-18; Thu: 11-12,17-21;	",
                "telegram:	@maxwellhays	; InterviewPerDay:	1	;	Fri: 8-10, 19-0; Sat: 10-0; Sun: 10-0; Mon: 8-10, 19-0; Tue: 8-10, 19-0; Wed: 8-10, 19-0; Thu: 8-10, 19-0;	",
                "telegram:	@reallity_not_found	; InterviewPerDay:	1	;	Fri: 17-20; Sat: 9-11, 17-20; Sun: 9-11, 17-20; Mon: -; Tue: 17-20; Wed: 17-20; Thu: 17-20;	",
                "telegram:	@kletkavrubashku	; InterviewPerDay:	1	;	Fri: 19-0; Sat: 15-0; Sun: 17-0; Mon: 22-0; Tue: -; Wed: 15-19; Thu: -;	",
        };

        String[] beginners = new String[]{
                "telegram:	@kiri11squid	; InterviewPerDay:	1	;	Fri: 11-22; Sat: 13-22; Sun: 13-22; Mon: 18-22; Tue: -; Wed: 19-22; Thu: -;	",
                "telegram:	@ajoodar	; InterviewPerDay:	1	;	Fri: 18-19; Sat: 17-19; Sun: 16-18; Mon: -; Tue: 18-19; Wed: -; Thu: 18-19;	",
                "telegram:	@ganqqwerty	; InterviewPerDay:	1	;	Fri: 12-13, 19-22; Sat: 10-13; Sun: 10-14; Mon: 12-13, 20-21; Tue: 12-13, 20-21; Wed: 12-13, 20-21; Thu: 12-13, 20-21;	",
                "telegram:	@OllyVas	; InterviewPerDay:	1	;	Fri: 11-16; Sat: 11-16; Sun: 9-16; Mon: 11-17; Tue: 11-16; Wed: 11-17; Thu: 11-16;	",
                "telegram:	@trisch_me	; InterviewPerDay:	1	;	Fri: 11-13, 15-18; Sat: -; Sun: -; Mon: 11-13, 15-18; Tue: 11-13, 15-18; Wed: 11-13, 15-18; Thu: 11-13, 15-18;	",
                "telegram:	@evgeniy_sibagatullin	; InterviewPerDay:	1	;	Fri: 18-21; Sat: 09-13; Sun: 09-13; Mon: 18-21; Tue: 18-21; Wed: 18-21; Thu: 18-21;	",
                "telegram:	@yaroslav_is	; InterviewPerDay:	1	;	Fri: 12-17;Sat: 12-16; Sun: 12-14; Mon: -; Tue: -; Wed: -; Thu: -;	",
                "telegram:	@alexeydemin	; InterviewPerDay:	1	;	Fri: 17-0; Sat: 17-0; Sun: 17-0; Mon: 17-0; Tue: 20-0; Wed: 22-0; Thu: 20-0;	",
                "telegram:	ps_at_telegram	; InterviewPerDay:	2	;	Fri: 0-4, 18-20; 22-0; Sat: 0-4, 18-20; Sun: 18-20; Mon: 23-0; Tue: 0-4, 19-0; Wed: 0-4, 18-0; Thu:0-4, 10-20, 22-0;	",
                "telegram:	@PoligonF	; InterviewPerDay:	2	;	Fri: 12-21; Sat: 12-21; Sun: 12-21; Mon: 12-21; Tue: 12-21; Wed: 12-21; Thu: 12-21;	",
                "telegram:	shvetsiya	; InterviewPerDay:	1	;	Fri: 19-23; Sat: -; Sun: -; Mon: 19-22; Tue: 19-22; Wed: 19-22; Thu: 19-22;	",
                "telegram:	aleksandr_melnichnikov	; InterviewPerDay:	2	;	Fri: -; Sat: 12-23; Sun: 12-23; Mon: -; Tue: -; Wed: -; Thu: -;	",
                "telegram:	@chvrn	; InterviewPerDay:	1	;	Fri: -; Sat: 18-20; Sun: 13-18; Mon: -; Tue: -; Wed: -; Thu: -;	",
                "telegram:	@Igorbulyga	; InterviewPerDay:	1	;	Fri: -; Sat: -; Sun: -; Mon: 18-21; Tue: 18-21; Wed: 18-21; Thu: -;	",
                "telegram:	@yestemir	; InterviewPerDay:	1	;	Fri: -; Sat: -; Sun: -; Mon: 12-14; Tue: -; Wed: 12-14; Thu: -;	",
                "telegram:	@ryspekb	; InterviewPerDay:	1	;	Fri: -; Sat: 13-18; Sun: 13-18; Mon: -; Tue: -; Wed: -; Thu: -;	",
                "telegram:	alexanch 	; InterviewPerDay:	2	;	Fri: 17-18; Sat: -; Sun: -; Mon: 19-21; Tue: 19-21; Wed: 19-21; Thu: 19-21;	",
                "telegram:	@nik0norov	; InterviewPerDay:	1	;	Fri: 2-5, 14-19; Sat: -; Sun: 11-17; Mon: 2-5, 14-19; Tue: 2-5, 14-19; Wed: 2-5, 14-19; Thu: 2-5, 14-19;	",
                "telegram:	@capomafiosoken	; InterviewPerDay:	2	;	Fri: 17-20; Sat: 7-10; Sun: 7-10; Mon: 17-20; Tue: 17-20; Wed: 17-20; Thu: 17-20;	",
                "telegram:	@volyx	; InterviewPerDay:	1	;	Fri: 17-21; Sat: -; Sun: -; Mon: 17-21; Tue: -; Wed: 17-21; Thu: -;	",
                "telegram:	@hagman	; InterviewPerDay:	1	;	Fri: -; Sat: 10-16; Sun: 10-16; Mon: 18-20; Tue: 18-20; Wed: 16-20; Thu: 16-20;	",
                "telegram:	@pasharemba	; InterviewPerDay:	2	;	Fri: 15-17, 20-23; Sat: 1-3, 15-16; Sun: 1-3, 15-16; Mon: 1-3, 15-17, 20-23; Tue: 1-3, 15-17, 20-23; Wed: 1-3, 15-17, 20-23; Thu: 1-3, 15-17, 20-23;",
                "telegram:	@darhonbek	; InterviewPerDay:	1	;	Fri: -; Sat: 16-22; Sun: 16-22; Mon: -; Tue: -; Wed: -; Thu: -;	",
                "telegram:	@evheniy_hlushko	; InterviewPerDay:	1	;	Fri: -; Sat: -; Sun: -; Mon: 19-21; Tue: 19-21; Wed: 19-21; Thu: -;	",
                "telegram:	@korintant	; InterviewPerDay:	3	;	 Fri: 14-20; Sat: -; Sun: -; Mon: -; Tue: -; Wed: 17-20; Thu: 15-20;	",
                "telegram:	@tjwguy	; InterviewPerDay:	2	;	Fri:-; Sat:-; Sun:-; Mon: 17-21; Tue: 17-21; Wed: 17-21; Thu: 17-21;	",
                "telegram:	@zham_rys	; InterviewPerDay:	2	;	Fri: -; Sat:15-18, 20-0; Sun: 10-0; Mon: -; Tue: -; Wed: -; Thu: -;	",
                "telegram:	@ivor06	; InterviewPerDay:	1	;	Fri: 17-0; Sat: 10-0; Sun: 10-0; Mon: -; Tue: 17-0; Wed: 17-0; Thu: 17-0;	",
                "telegram:	@AntonRodin	; InterviewPerDay:	1	;	Fri: 13-15; Sat: -; Sun: -; Mon: 13-15; Tue: 13-15; Wed: 13-15; Thu: 13-15;	",
                "telegram:	@baibolatovads	; InterviewPerDay:	2	;	Fri: 13-15; Sat: 11-13; Sun: 12-14; Mon: -; Tue: -; Wed: 14-16;  Thu:  13-15;	",
                "telegram:	@JuliaSamartseva	; InterviewPerDay:	1	;	Fri: 9-12, 15-17; Sat: 9-12; Sun: -; Mon: 9-11, 14-16; Tue: 12-16; Wed: 9-15; Thu: -;	",
                "telegram:	@rosepetal2013	; InterviewPerDay:	1	;	Fri: -; Sat: 19-22; Sun: 19-22; Mon: -; Tue: -; Wed: -; Thu: -;	",
                "telegram:	@AlexanderVlassov	; InterviewPerDay:	3	;	Fri: 9-20; Sat:  9-20; Sun: 9-20; Mon: 13-20; Tue: 9-20; Wed: 9-20; Thu: 9-20;	",
                "telegram:	@slisnychyi	; InterviewPerDay:	1	;	Fri: -; Sat: 14-16; Sun: 14-16; Mon: -; Tue: 18-20; Wed: -; Thu: 18-20;	",
                "telegram:	@mikhail_1234	; InterviewPerDay:	1	;	Fri: 17-20; Sat: 12-20; Sun: 12-20; Mon: 17-20; Tue: 17-20; Wed: 17-20; Thu: 17-20;	",
                "telegram:	@calciotore	; InterviewPerDay:	2	;	 Fri: -; Sat: -; Sun: -; Mon: -; Tue: -; Wed: 17-22; Thu: 17-22;	",
                "telegram:	@zubrabubra	; InterviewPerDay:	1	;	 Fri: -; Sat: -; Sun: -; Mon: -; Tue: -; Wed: 15-17; Thu: 15-17;	",
                "telegram:	@djenton	; InterviewPerDay:	1	;	Fri: 16-19; Sat: 9-18; Sun: 9-18; Mon: 16-19; Tue: -; Wed: 16-19; Thu: 16-19;	",
                "telegram:	@sainnr	; InterviewPerDay:	2	;	Fri: 21-23; Sat: 16-19; Sun: -; Mon: 18-23; Tue: 18-23; Wed: 20-23; Thu: 18-23;	",
        };

        List<Timetable> timetableCandidates = solution.generateTimetableCandidates(beginners);
        //List<Timetable> timetableCandidates = solution.generateTimetableCandidates(adv);
        timetableCandidates.sort((a, b) -> b.score - a.score);
        for(int i=0; i<timetableCandidates.size(); i++) {
            timetableCandidates.get(i).printToFile("candidate" + (i+1) + ".txt");
        }
    }
}

