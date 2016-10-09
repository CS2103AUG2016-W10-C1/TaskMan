package guitests;

import guitests.guihandles.TaskCardHandle;
import seedu.taskman.commons.core.Messages;
import seedu.taskman.logic.commands.AddCommand;
import seedu.taskman.model.event.Activity;
import seedu.taskman.testutil.TestTask;
import seedu.taskman.testutil.TestUtil;

import static org.junit.Assert.assertTrue;

public class AddCommandTest extends TaskManGuiTest {

    //@Test
    public void add() {
        //add one task
        TestTask[] currentList = td.getTypicalTasks();
        TestTask taskToAdd = td.hoon;
        assertAddSuccess(taskToAdd, currentList);
        currentList = TestUtil.addTasksToList(currentList, taskToAdd);

        //add another task
        taskToAdd = td.ida;
        assertAddSuccess(taskToAdd, currentList);
        currentList = TestUtil.addTasksToList(currentList, taskToAdd);

        //add duplicate task
        commandBox.runCommand(td.hoon.getAddCommand());
        Activity[] expectedList = new Activity[currentList.length];
        for(int i = 0; i < expectedList.length; i++){
            expectedList[i] = new Activity(currentList[i]);
        }
        assertResultMessage(AddCommand.MESSAGE_DUPLICATE_PERSON);
        assertTrue(taskListPanel.isListMatching(expectedList));

        //add to empty list
        commandBox.runCommand("clear");
        assertAddSuccess(td.alice);

        //invalid command
        commandBox.runCommand("adds Johnny");
        assertResultMessage(Messages.MESSAGE_UNKNOWN_COMMAND);
    }

    private void assertAddSuccess(TestTask taskToAdd, TestTask... currentList) {
        commandBox.runCommand(taskToAdd.getAddCommand());

        //confirm the new card contains the right data
        TaskCardHandle addedCard = taskListPanel.navigateToTask(taskToAdd.getTitle().title);
        assertMatching(new Activity(taskToAdd), addedCard);

        //confirm the list now contains all previous tasks plus the new task
        TestTask[] expectedList = TestUtil.addTasksToList(currentList, taskToAdd);
        Activity[] expectedActivityList = new Activity[currentList.length];
        for(int i = 0; i < expectedActivityList.length; i++){
            expectedActivityList[i] = new Activity(expectedList[i]);
        }
        assertTrue(taskListPanel.isListMatching(expectedActivityList));
    }

}
