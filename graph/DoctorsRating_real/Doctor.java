package LeetCode.graph.DoctorsRating_real;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    public String name;
    public float rating;
    public List<Doctor> relatedDoctors;

    Doctor(String name, float rating, Doctor[] doctors) {
        this.name = name;
        this.rating = rating;
        this.relatedDoctors = new ArrayList<>();
        for (Doctor doc : doctors) {
            this.relatedDoctors.add(doc);
        }
    }

    @Override
    public String toString() {
        return String.format("%1$s %2$f", this.name, this.rating);
    }

}
