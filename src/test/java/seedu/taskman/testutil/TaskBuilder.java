package seedu.taskman.testutil;

import seedu.taskman.commons.exceptions.IllegalValueException;
import seedu.taskman.model.tag.Tag;
import seedu.taskman.model.event.*;

/**
 *
 */
public class TaskBuilder {

    private TestTask task;

    public TaskBuilder(String title) throws IllegalValueException {
        this.task = new TestTask();
        task.setTitle(new Title(title));
    }

    public TaskBuilder withTags(String... tags) throws IllegalValueException {
        for (String tag : tags) {
            task.getTags().add(new Tag(tag));
        }
        return this;
    }

    public TaskBuilder withDeadline(String deadline) throws IllegalValueException {
        this.task.setDeadline(new Deadline(deadline));
        return this;
    }

    public TaskBuilder withSchedule(String schedule) throws IllegalValueException {
        this.task.setSchedule(new Schedule(schedule));
        return this;
    }

    public TestTask build() {
        return this.task;
    }

}
