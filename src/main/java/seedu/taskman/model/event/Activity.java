package seedu.taskman.model.event;

import seedu.taskman.model.tag.UniqueTagList;

import java.util.Objects;
import java.util.Optional;

/**
 * Wrapper for both ReadOnlyEvent and ReadOnlyTask
 */
public class Activity implements ReadOnlyEvent{

    public enum ActivityType {EVENT, TASK};

    private ReadOnlyEvent activity;
    private ActivityType type;

    public Activity(ReadOnlyEvent event){
        activity = event;
        type = ActivityType.EVENT;
    }

    public Activity(ReadOnlyTask task){
        activity = task;
        type = ActivityType.TASK;
    }

    public Activity(Activity source){
        switch (source.getType()){
            case TASK:
                this.activity = new Task((ReadOnlyTask) source.activity);
                break;
            case EVENT:
            default:
                this.activity = new Event(source.getEvent());
        }
        type = source.getType();
    }

    public ActivityType getType(){
        return type;
    }

    public Optional<ReadOnlyTask> getTask(){
        if(type != ActivityType.TASK){
            return Optional.empty();
        }
        return Optional.of((ReadOnlyTask) activity);
    }

    public ReadOnlyEvent getEvent(){
        return activity;
    }

    public Optional<Status> getStatus() {
        switch(type){
            case TASK:
                return Optional.ofNullable(((ReadOnlyTask)activity).getStatus());
            case EVENT:
            default:
                return null;
        }
    }

    public Optional<Deadline> getDeadline() {
        switch(type){
            case TASK:
                return ((ReadOnlyTask)activity).getDeadline();
            case EVENT:
            default:
                return Optional.empty();
        }
    }

    @Override
    public Title getTitle() {
        return activity.getTitle();
    }

    @Override
    public Optional<Frequency> getFrequency() {
        return activity.getFrequency();
    }

    @Override
    public Optional<Schedule> getSchedule() {
        return activity.getSchedule();
    }

    @Override
    public UniqueTagList getTags() {
        return activity.getTags();
    }

    public boolean isSameStateAs(Activity other){
        if(type != other.type) return false;

        switch(type){
            case TASK:
                return ((ReadOnlyTask)activity).isSameStateAs((ReadOnlyTask)other.activity);
            case EVENT:
            default:
                return activity.isSameStateAs(other.activity);
        }
    }

    @Override
    public boolean equals(Object other){
        return other == this // short circuit if same object
                || (other instanceof Activity // instanceof handles nulls
                && this.isSameStateAs((Activity) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(
                getTitle(),
                getDeadline(),
                getStatus(),
                getFrequency(),
                getSchedule(),
                getTags()
        );
    }

    @Override
    public String getAsText() {
        return activity.getAsText();
    }

}
