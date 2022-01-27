public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws InvalidTaskIndexException {
        taskList.unmark(this.index);
        ui.showUnmark(taskList.getTask(this.index));
        storage.updateList(taskList);
    }
}
