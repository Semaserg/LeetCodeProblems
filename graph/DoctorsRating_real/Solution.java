package LeetCode.graph.DoctorsRating_real;

import javax.print.Doc;
import java.util.*;

/*
Doctor has name, rating, list of related doctors
Print top N related doctors except given one!!!! (top by rating)
Search doctors recursively among relative-of-relative doctors.
Order in the result set is no matter, N most rated doctors.
If N>total amount of doctors - print all you can found except given.
*/
public class Solution {
    public List<Doctor> getTopDoctorsBFS(Doctor doctor, int topCounter) {
        List<Doctor> result = new ArrayList<>();
        if (doctor == null || doctor.relatedDoctors == null || doctor.relatedDoctors.size() == 0) {
            return result;
        }

        // Min heap
        PriorityQueue<Doctor> heap = new PriorityQueue<Doctor>((a,b) -> {
            if (a.rating == b.rating) return 0;
            return (a.rating - b.rating) > 0 ? 1 : -1;
        });

        Set<String> visited = new HashSet<>(); // we can use set of Doctors here, just add good hash function to Doctor class
        visited.add(doctor.name);
        Queue<Doctor> queue = new LinkedList<>();
        queue.add(doctor);

        while (!queue.isEmpty()) {
            Doctor current = queue.poll();

            if (current != doctor) { // exclude given doctor
                heap.add(current);
                // doctor with the smallest rating in the top of the heap, so we can remove this record
                if (heap.size() > topCounter) heap.poll();
            }
            for (Doctor d : current.relatedDoctors) {
                if (!visited.contains(d.name)) {
                    visited.add(d.name);
                    queue.add(d);
                }
            }
        }
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }

    public List<Doctor> getTopDoctorsDFS(Doctor doctor, int topCounter) {
        List<Doctor> result = new ArrayList<>();
        if (doctor == null || doctor.relatedDoctors == null || doctor.relatedDoctors.size() == 0) {
            return result;
        }

        // Min heap
        PriorityQueue<Doctor> heap = new PriorityQueue<Doctor>((a,b) -> {
            if (a.rating == b.rating) return 0;
            return (a.rating - b.rating) > 0 ? 1 : -1;
        });

        Set<String> visited = new HashSet<>(); // we can use set of Doctors here, just add good hash function to Doctor class

        dfsUtil(doctor, doctor, topCounter, heap, visited);

        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }

    private void dfsUtil(Doctor start, Doctor current, int topCounter, PriorityQueue<Doctor> heap, Set<String> visited) {
        visited.add(current.name);
        if (current != start) { // start need to be excludaed
            heap.add(current);
            // doctor with the smallest rating in the top of the heap, so we can remove this record
            if (heap.size() > topCounter) heap.poll();
        }
        for (Doctor d : current.relatedDoctors) {
            if (!visited.contains(d.name)) {
                dfsUtil(start, d, topCounter, heap, visited);
            }
        }
    }
}