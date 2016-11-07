Please download the SampleData.xml and then rename it to taskMan.xml
Open the directory where TaskMan.jar is, and create a folder called data.
Place taskMan.xml into the data folder.




## Add


1. `add`


This should fail & give an example to the user in the ResultDisplay.


2. `add task1`


Adds a task with only a title `task1`
This should show up in FloatingTask Panel (no deadline defined).
A description of the task will be shown in ResultDisplay.


3. `add task1`


This should fail as tasks cannot have same name in Task Man.


4. `add task2 t/tag1 t/tag!@$`


A new task with tags will be added


5. `add task3 s/today, tomorrow`


This adds a task with name and schedule.
This should show up in both FloatingTask Panel and Schedule Panel.


6. `add task4 s/01-01-16, 3 weeks from now`


Same as above (testing different formats for input)


7. `add task5 s/4pm for 2 hours`


Same as above, but with time & duration instead of time & time


8. `add task6 d/tomorrow s/today, next wednesday 2pm`


Same as above, but with deadline
Thus, this should not show up in FloatingTask Panel but would should show up in Deadline Panel.


9. `Add taskFail d/fish`


This should fail as the deadline format is incorrect.
Some helpful feedback will be shown to guide user in entering a proper datetime.


10. `Add taskFail s/today for orange`


This should fail as the schedule format is incorrect.
Some helpful feedback will be shown to guide user in entering a proper duration


## AddE


11. `adde event1 s/today, next wednesday 2pm d/tomorrow`


This adds an event with title and schedule.
This should show up in the Schedule Panel.


12. `adde event2`


This should fail as schedule is compulsory.
Feedback would shows a generic result with example.


13. `adde`


Should fail as no title & schedule specified, shows generic result like above


## Clear


14. `clear`


Should clear all data from the display


## History


15. `history`


Should show up to 10 past commands


## Undo


16. `undo`


Should undo the clear command


17. `add forUndo1`<br>
`add forUndo2`<br>
`add forUndo3`<br>
`undo 3`


Should undo the 3 add commands above (forUndo1-3 will all be removed)


## Edit


18. `add sign up for swimming classes`<br>
`edit f1 d/next sat 11am`


Now you have to sign up for swimming classes by Saturday morning.


19. `adde buy present for inaba s/today 10am, today 10pm`<br>
`edit s1 buy present for jiayee instead d/9 feb 2017 2359 t/lovely`


Will fail, because an event cannot have a deadline


20. `add buy present for alex s/today 10am, today 10pm`
`edit s1 buy present for jiayee instead d/9 feb 2017 2359 t/lovely`


Will succeed, because a task can have a deadline




## Tags


21. `tags`


Should display list of existing tags in ResultDisplay
Should be sorted alphabetically
Should not show duplicates
Should not show tags that no longer exists in TaskMan


## Select


22. `select s1`


Suppose there is an entry in the SchedulePanel, the first entry will be focused and selected
Should show additional information in ResultDisplay, more so if it is also has a deadline


23. `select d1`


Suppose there is an entry in the DeadlinePanel, the first entry will be focused and selected
Should show additional information in ResultDisplay, more so if it is also has a schedule


24. `select f1`


Suppose there is an entry in the FloatingPanel, the first entry will be focused and selected
Should show additional information in ResultDisplay


## Delete


25. `delete s1`


Suppose there is an entry in the SchedulePanel, the first entry will be deleted from TaskMan
Should show result in ResultDisplay
All 3 panels should be updated, as the the activity can also be listed in the the other panels.


26. `delete d1`


Suppose there is an entry in the DeadlinePanel, the first entry will be deleted from TaskMan
Should show result in ResultDisplay
All 3 panels should be updated, as the the activity can also be listed in the the other panels.


27. `delete f1`


Suppose there is an entry in the FloatingPanel, the first entry will be deleted from TaskMan
Should show result in ResultDisplay
All 3 panels should be updated, as the the activity can also be listed in the the other panels.


## Storageloc


(if on windows)<br>
28a. `storageloc C:/Users/Owner/Desktop/new_task.xml`


(if on ubuntu)<br>
28b. `storageloc /home/user/Desktop/MyTaskManData.xml`
This should notify the user that the storage location has changed


29. `storageloc ./relative_postion.xml`<br>
`exit`


Storage location should be changed to the specified relative position
Exiting will write the file to disk. Open your file browser and see the relative_position.xml created.


30. `storageloc view`
Should show current file location in ResultDisplay


31. `storageloc default`
Should save to default save location as indicated in the ResultDisplay




## List


32. `list`


Should display all activities in all panels, as indicated in the ResultDisplay


33. `list buy`


Should display all activities in all panels, that contains the keyword ‘buy’ in its title, as indicated in the ResultDisplay


34. `list t/important`


Should display all activities in all panels, that has the tag ‘important’, as indicated in the ResultDisplay


35. `list d eliz pris`


Should display all activities in the DeadlinePanel, that has the keyword ‘eliz’ and/or ‘pris’


36. `list s t/important t/bills`


Should display all activities in the SchedulePanel, that has the tag ‘important’ and/or ‘bills’


37. `clear`<br>
`add completeMe`<br>
`complete f1`


Should first clear the list of all activities,
Add a new task, then sets the task to completed
The icon for the task will change. Color should change too.