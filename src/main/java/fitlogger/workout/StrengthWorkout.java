package fitlogger.workout;

import fitlogger.exception.FitLoggerException;

import java.time.LocalDate;

/**
 * Represents a strength-based workout logged by the user.
 */
public class StrengthWorkout extends Workout {
    private double weight;
    private int sets;
    private int reps;

    /**
     * Creates a new StrengthWorkout with the specified details.
     *
     * @param description The name of the exercise (e.g., "Bench Press").
     * @param weight      The weight lifted in kilograms.
     * @param sets        The number of sets completed.
     * @param reps        The number of repetitions per set.
     * @param date        The date the workout was completed.
     * @throws FitLoggerException if description is blank, if weight is not finite
     *                            and non-negative, or if sets/reps are not positive.
     */
    public StrengthWorkout(String description, double weight, int sets, int reps, LocalDate date)
            throws FitLoggerException {
        super(description, date);
        setWeight(weight);
        setSets(sets);
        setReps(reps);
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Updates the weight in kilograms.
     *
     * @param weight New weight value, must be 0 or greater.
     * @throws FitLoggerException if weight is not finite or negative.
     */
    public void setWeight(double weight) throws FitLoggerException {
        if (!Double.isFinite(weight) || weight < 0) {
            throw new FitLoggerException("Weight cannot be negative.");
        }
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    /**
     * Updates the number of sets.
     *
     * @param sets New sets value, must be greater than 0.
     * @throws FitLoggerException if sets is not positive.
     */
    public void setSets(int sets) throws FitLoggerException {
        if (sets <= 0) {
            throw new FitLoggerException("Sets must be a positive integer.");
        }
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    /**
     * Updates the number of reps.
     *
     * @param reps New reps value, must be greater than 0.
     * @throws FitLoggerException if reps is not positive.
     */
    public void setReps(int reps) throws FitLoggerException {
        if (reps <= 0) {
            throw new FitLoggerException("Reps must be a positive integer.");
        }
        this.reps = reps;
    }

    /**
     * Formats the workout details into a string for saving to a text file.
     *
     * <p>Format: {@code L | <description> | <date> | <weight> | <sets> | <reps>}
     *
     * @return A formatted string suitable for local storage.
     */
    @Override
    public String toFileFormat() {
        // e.g., L | Bench Press | 2026-03-13 | 80.5 | 3 | 8
        return "L | " + description + " | " + date + " | " + weight + " | " + sets + " | " + reps;
    }

    /**
     * Returns the string representation of the workout for the user interface.
     *
     * @return A formatted string displaying the workout details.
     */
    @Override
    public String toString() {
        return "[Lift] " + super.toString() + " (" + weight + "kg, " + sets + " sets of " + reps + " reps)";
    }
}
