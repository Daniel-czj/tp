package fitlogger.workout;

import fitlogger.exception.FitLoggerException;

import java.time.LocalDate;

/**
 * Represents an abstract workout in the FitLogger.command.FitLogger application.
 * This class serves as a base for specific workout types and contains
 * shared logic for storing workout description and date.
 */
public abstract class Workout {

    /** The description or name of the workout activity. */
    protected String description;

    /** The date when the workout was performed or is scheduled for. */
    protected LocalDate date;

    /**
     * Initializes a new Workout with a description and date.
     *
     * @param description A short summary of the workout.
     * @param date        The date of the workout.
     * @throws FitLoggerException if description is null or blank.
     */
    public Workout(String description, LocalDate date) throws FitLoggerException {
        setDescription(description);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Updates the workout description.
     *
     * @param description New non-blank description.
     * @throws FitLoggerException if description is null or blank.
     */
    public void setDescription(String description) throws FitLoggerException {
        if (description == null || description.isBlank()) {
            throw new FitLoggerException("Workout name cannot be blank.");
        }
        this.description = description.trim();
    }

    /**
     * Formats the workout data into a standardized string for file storage.
     * Each child class must implement this to ensure its specific data
     * (e.g., distance for runs) is saved correctly.
     *
     * @return A pipe-separated string representing the workout's data.
     */
    public abstract String toFileFormat();

    /**
     * Returns a string representation of the workout for display to the user.
     *
     * @return A formatted string containing description and date.
     */
    @Override
    public String toString() {
        return description + " (Date: " + date + ")";
    }
}
