package dazz.command;

import java.time.LocalDateTime;

import dazz.Storage;
import dazz.TaskList;
import dazz.Ui;
import dazz.task.Event;

public class EventCommand extends Command {
    private Event event;

    public EventCommand(String description, LocalDateTime dateTime) {
        this.event = new Event(description, dateTime);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.add(this.event);
//        ui.showAdd(event, taskList);
        String message = ui.messageForAdd(event, taskList);
        storage.updateList(taskList);
        return message;
    }

}
