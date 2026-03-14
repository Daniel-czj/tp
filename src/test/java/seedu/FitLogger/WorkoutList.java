package seedu.FitLogger;

import java.time.LocalDate;
import java.util.ArrayList;

public class WorkoutList {
    protected ArrayList<Workout> workouts;

    public WorkoutList() {
        workouts = new ArrayList<>();
    }

    public void addRunWorkout(String description, LocalDate date, double distance, double duration) {
        workouts.add(new RunWorkout(description, date, distance, duration));
    }

    public void addStrengthWorkout(String description, double weight, int sets, int reps, LocalDate date) {
        workouts.add(new StrengthWorkout(description, weight, sets, reps, date));
    }

    //give the actual index in the array for now, not the index in the list (i.e. minus 1 then pass in)
    public void deleteWorkout(int workoutToRemove) {
        workouts.remove(workoutToRemove);
    }
}
