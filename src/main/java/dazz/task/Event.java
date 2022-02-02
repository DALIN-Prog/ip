package dazz.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that is an event.
 */
public class Event extends Task {
    private static final String TYPE = "E";
    private final LocalDateTime dateTime;

    /**
     * Constructs an <code>Event</code> task and is not completed by default.
     * @param description Description of the event
     * @param date Date of the event
     */
    public Event(String description, LocalDateTime date) {
        super(description);
        this.dateTime = date;
    }

    /**
     * Constructs an <code>Event</code> task and is completed depending on <code>isDone</code>.
     * @param description Description of the event
     * @param isDone Done or undone.
     * @param date Date of the event
     */
    public Event(String description, boolean isDone, LocalDateTime date) {
        super(description, isDone);
        this.dateTime = date;
    }

    /**
     * Gets the date and time of the task.
     * @return Date and time of the task.
     */
    public String getDateTimeFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd MMM yyyy, hh:mma]");
        return this.dateTime.format(formatter);
    }

    /**
     * Reformats the task to be stored in a text file.
     * @return Text that would be stored as in a file.
     */
    @Override
    public String writeToFile() {
        return TYPE + " === " + super.writeToFile() + " === " + this.getDateTimeFormat();
    }

    /**
     * String representation of the event task.
     * @return String representation of the event task.
     */
    @Override
    public String toString() {
        return "[" + TYPE + "]" + super.toString() + " (by: " + this.getDateTimeFormat() + ")";
    }
}
