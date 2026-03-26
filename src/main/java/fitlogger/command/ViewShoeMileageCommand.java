package fitlogger.command;

import fitlogger.profile.UserProfile;
import fitlogger.storage.Storage;
import fitlogger.ui.Ui;
import fitlogger.workout.RunWorkout;
import fitlogger.workout.Workout;
import fitlogger.workoutlist.WorkoutList;

public class ViewShoeMileageCommand extends Command {
    public void execute(Storage storage, WorkoutList workouts, Ui ui, UserProfile profile) {
        double totalMileage = 0;
        for (Workout workout : workouts.getWorkouts()) {
            if (workout instanceof RunWorkout run) {
                totalMileage += run.getDistance();
            }
        }
        ui.showMessage("Your total distance ran is: " + String.format("%.2fkm", totalMileage));
    }
}
