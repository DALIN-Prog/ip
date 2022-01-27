import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ui {
    private final Scanner scanner;
    private final String HORIZONTAL_LINE = "\t____________________________________________________________";
    private final String LOGO = "\t  ____       _       _____   _____\n" +
            "\t |  _\"\\  U  /\"\\  u  |\"_  / u |\"_  / u\n" +
            "\t/| | | |  \\/ _ \\/   U / / /  U / / /\n" +
            "\tU| |_| |\\ / ___ \\   \\/ /_   \\/ /_\n" +
            "\t |____/ u/_/   \\_\\  /____|  /____|\n" +
            "\t  |||_    \\\\    >>  _//<<,- _//<<,-\n" +
            "\t (__)_)  (__)  (__)(__) (_/(__) (_/";

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println(HORIZONTAL_LINE + "\n\tHello from\n" + LOGO + "\n\n"
                + "\tGood day!\n\tWhat can I do for you?\n" + HORIZONTAL_LINE);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public void showExit() {
        System.out.println("\tBye. Hope to see you again soon!");
    }

    public void showAdd(Task task, TaskList taskList) {
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t  " + task);
        System.out.println("\tNow you have " + taskList.getSize() + " tasks in the list.");
    }

    public void showError(String errorMessage) {
        System.out.println("\t" + errorMessage);
    }

    public void showMark(Task task) {
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t  " + task);
    }

    public void showUnmark(Task task) {
        System.out.println("\tOK, I've unmarked this task as not done yet:");
        System.out.println("\t  " + task);
    }

    public void showDelete(Task task) {
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t  " + task);
    }

    public void showList(TaskList taskList) {
        System.out.println("\tHere are the tasks in your list:");
        if (taskList.getSize() == 0) {
            System.out.println("\tYou have no task in your list.");
        } else {
            for (int i = 0; i < taskList.getSize(); i++) {
                Task task = taskList.getTaskList().get(i);
                System.out.println("\t" + (i + 1) + ". " + task);
            }
        }
    }

    public void showDefault() {
        System.out.println("\t" + ErrorType.INVALID_COMMAND.getErrorMessage());
    }

    public static LocalDateTime toLocalDateTime(String date) throws InvalidDateFormatException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy HHmm]" +
                    "[dd/MM/yyyy HHmm]" +
                    "[dd MMM yyyy, hh:mma]");
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException();
        }
    }
}
