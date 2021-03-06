package seedu.taskman.model.event;

import com.google.common.base.Objects;
import seedu.taskman.commons.exceptions.IllegalValueException;

//@@author A0139019E
public class Status {
    public static final String COMPLETE = "complete";
    public static final String INCOMPLETE = "incomplete";
    public static final String YES = "y";
    public static final String NO = "n";

    public final Boolean completed;

    public Status() {
        completed = false;
    }

    public Status(String booleanString) throws IllegalValueException {
        booleanString = booleanString.trim().toLowerCase();
        if (!booleanString.matches("("+ COMPLETE +")|("+ INCOMPLETE +")|("+YES+")|("+NO+")")) {
            throw new IllegalValueException("Status should be 'complete','incomplete', 'y' or 'n'");
        }
        completed = booleanString.equals(COMPLETE) ||
                    booleanString.equals(YES);
    }

    @Override
    public String toString() {
        return completed ? "Completed" : "Incomplete";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equal(completed, status.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(completed);
    }
}
