package LeetCode.graph.DoctorsRating_real;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Doctor alex = new Doctor("alex", 3.3f, new Doctor[]{});
        Doctor boris = new Doctor("boris", 7.3f, new Doctor[]{alex});
        Doctor cory = new Doctor("cory", 3.3f, new Doctor[]{boris});
        Doctor david = new Doctor("david", 4.1354f, new Doctor[]{boris, alex, cory});
        Doctor eddy = new Doctor("eddy", 3.933f, new Doctor[]{alex, cory});
        Doctor freddie = new Doctor("freddie", 9.58765f, new Doctor[]{eddy, cory, david, boris, alex});

        System.out.println("BFS");
        List<Doctor> topDoctorsBFS = s.getTopDoctorsBFS(freddie, 10);
        for(Doctor doc : topDoctorsBFS) {
            System.out.println(doc);
        }

        System.out.println("DFS");
        List<Doctor> topDoctorsDFS = s.getTopDoctorsDFS(freddie, 3);
        for(Doctor doc : topDoctorsDFS) {
            System.out.println(doc);
        }
    }
}


