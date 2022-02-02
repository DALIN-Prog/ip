package dazz;

import java.util.List;

import dazz.exception.InvalidTaskIndexException;
import dazz.task.Task;

/**
 *
 */
public class TaskList {
    protected List<Task> taskList;

    /**
     *
     * @param tasks
     */
    public TaskList(List<Task> tasks) {
        this.taskList = tasks;
    }

    /**
     *
     * @param task
     */
    public void add(Task task) {
        taskList.add(task);
    }

    /**
     *
     * @param position
     * @throws InvalidTaskIndexException
     */
    public void mark(int position) throws InvalidTaskIndexException {
        if (position > this.getSize()) {
            throw new InvalidTaskIndexException();
        } else {
            this.getTask(position).setDone();
        }
    }

    /**
     *
     * @param position
     * @throws InvalidTaskIndexException
     */
    public void unmark(int position) throws InvalidTaskIndexException {
        if (position > this.getSize()) {
            throw new InvalidTaskIndexException();
        } else {
            this.getTask(position).setUndone();
        }
    }

    /**
     *
     * @param position
     * @throws InvalidTaskIndexException
     */
    public void delete(int position) throws InvalidTaskIndexException {
        if (position > this.getSize()) {
            throw new InvalidTaskIndexException();
        } else {
            this.taskList.remove(--position);
        }
    }

    /**
     *
     * @param position
     * @return Task
     * @throws InvalidTaskIndexException
     */
    public Task getTask(int position) throws InvalidTaskIndexException {
        if (position > this.getSize()) {
            throw new InvalidTaskIndexException();
        } else {
            return this.taskList.get(--position);
        }
    }

    /**
     *
     * @return
     */
    public void list() {
        taskList.forEach(x -> System.out.println("\t" + x));
    }

    public int getSize() {
        return taskList.size();
    }

    /**
     *
     * @return
     */
    public List<Task> getTaskList() {
        return this.taskList;
    }

}
