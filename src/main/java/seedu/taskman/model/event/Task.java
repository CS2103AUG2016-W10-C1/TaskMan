package seedu.taskman.model.event;

import seedu.taskman.model.tag.UniqueTagList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Represents a Task in the task man.
 * Guarantees: Title and UniqueTagList are present and not null, field values are validated.
 */
public class Task extends Event implements ReadOnlyTask {

    private Deadline deadline;
    private Status status;

    public Task(@Nonnull Title title, @Nonnull UniqueTagList tags,
                @Nullable Deadline deadline, @Nullable Frequency frequency,
                @Nullable Schedule schedule) {
        super(title, tags, frequency, schedule);
        this.deadline = deadline;
        this.status = new Status("");
    }

    /**
     * Copy constructor
     */
    public Task(@Nonnull ReadOnlyTask source) {
        this(source.getTitle(), source.getTags(), source.getDeadline().orElse(null),
                source.getFrequency().orElse(null), source.getSchedule().orElse(null));
        setStatus(source.getStatus());
    }

    @Override
    public Title getTitle() {
        return super.getTitle();
    }

    @Override
    public Optional<Deadline> getDeadline() {
        return Optional.ofNullable(deadline);
    }

    @Override
	public Status getStatus() {
		return status;
	}

	@Override
	public Optional<Frequency> getFrequency() {
        return super.getFrequency();
	}

	@Override
	public Optional<Schedule> getSchedule() {
        return super.getSchedule();
	}
    
    @Override
    public UniqueTagList getTags() {
        return super.getTags();
    }

    public void setDeadline(Deadline deadline) {
        this.deadline = deadline;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Replaces this task's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        super.setTags(replacement);
    }

    @Override
    public boolean equals(Object other) {
        boolean result = other == this // short circuit if same object
                || (other instanceof Task // instanceof handles nulls
                && this.isSameStateAs((Task) other));

        // TODO: delete this after testing!!!!
        Logger log = Logger.getAnonymousLogger();

        Task other2 = (Task) other;
                log.warning("Title: " + this.getTitle() + " , " + other2.getTitle() + " . " + other2.getTitle().equals(this.getTitle()));
        log.warning("" + other2.getFrequency().equals(this.getFrequency()));
        log.warning("" + other2.getSchedule().equals(this.getSchedule()));
        log.warning("" + other2.getDeadline().equals(this.getDeadline()));
        log.warning("" + other2.getStatus().equals(this.getStatus()));
        return result;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(
                super.getTitle(),
                deadline,
                status,
                super.getFrequency(),
                super.getSchedule(),
                super.getTags()
        );
    }

    @Override
    public String toString() {
        return getAsText();
    }

}
