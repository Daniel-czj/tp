package seedu.FitLogger;

public class FitLogger {
    private Ui ui;
    private Parser parser;
    private Storage storage;
    private WorkoutList workouts;

    public FitLogger() {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage(); // temp: please change
        workouts = new WorkoutList(); // temp: please change
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String command = ui.readCommand();

            //later change this line to `Command c = parser.parse(command);` then parser calls based on keyword
            String[] workoutInfo = parser.parse(command);

            //later remove this line after u change the line above
            Command c = new ExitCommand(storage, workouts);
            
            c.execute(ui);
            isExit = c.isExit();
        }
        ui.showGoodbye();
    }

    public static void main(String[] args) {
        new FitLogger().run();
    }
}
