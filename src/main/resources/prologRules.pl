/* ------------------- databaseFacts.pl -------------------*/
/* temporaly here */
firstHour(8).
lastHour(16).

classroomsCapacity('FFA', 30).
classroomsCapacity('FF9', 15).
classroomsCapacity('FFB', 30).
classroomsCapacity('FF8', 15).

teacherSchedule('T001', 8, 13).
teacherSchedule('T002', 8, 13).
teacherSchedule('T002', 15, 20).
teacherSchedule('T003', 13, 20).
teacherSchedule('T004', 8, 13).

noTeacher('WT01').
noClassroom('WC01').

assignmentTeacher(1, 'T001').
assignmentTeacher(2, 'T003').
assignmentTeacher(2, 'T002').
assignmentTeacher(3, 'T004').
assignmentTeacher(4, 'T004').

groupSize('GS011', 30).
groupSize('GS012', 30).
groupSize('GS023', 15).
groupSize('GS022', 30).
groupSize('GS031', 30).
groupSize('GS032', 30).
groupSize('GS013', 15).
groupSize('GS023', 30).
groupSize('GS033', 15).
groupSize('GS014', 30).
groupSize('GS024', 15).
groupSize('GS034', 15).

assignmentGroup(1, 'GS011').
assignmentGroup(1, 'GS012').
assignmentGroup(2, 'GS023').
assignmentGroup(2, 'GS022').
assignmentGroup(3, 'GS031').
assignmentGroup(3, 'GS032').
assignmentGroup(1, 'GS013').
assignmentGroup(2, 'GS023').
assignmentGroup(3, 'GS033').
assignmentGroup(1, 'GS014').
assignmentGroup(2, 'GS024').
assignmentGroup(3, 'GS034').

/* ------------------- /databaseFacts.pl -------------------*/


/* ------------------- utils.pl -------------------*/
/* temporaly here */

/* find if a teacher have a group at given hour of day */
/* Schedule: [[Group, Hour, Teacher]|_] */
/* 2018-06-09 @jmrc */
findGroupsTeacherSchedule(Teacher, Hour, [[_, Hour, Teacher]|_]).

findGroupsTeacherSchedule(Teacher, Hour, [_|RestOfSchedule]):-
	findGroupsTeacherSchedule(Teacher, Hour, RestOfSchedule).
/* /find if a teacher have a group at given hour of day */

/* add a scheduled group to the list */
/* 2018-06-09 @jmrc */
addGroupTeacher(GroupTeacher, [], [GroupTeacher|[]]).

addGroupTeacher(GroupTeacher, [Schedule|RestOfSchedule], [Schedule|NewSchedule]):-
	addGroupTeacher(GroupTeacher, RestOfSchedule, NewSchedule).
/* /add a scheduled group to the list */

/* find if a teacher is available at given hour and if not have a group */
/* 2018-06-09 @jmrc */
isTeacherFree(Teacher, Hour, Schedule):-
	teacherSchedule(Teacher, Entrance, Exit),
	Entrance =< Hour,
	Exit >= Hour,
	\+ findGroupsTeacherSchedule(Teacher, Hour, Schedule).
/* /find if a teacher is available at given hour and if not have a group */

/* find if a given classroom is available at given hour */
/* 2018-06-24 @jmrc */
findGroupsClassroomSchedule(Classroom, Hour, [[_, Hour, Classroom]|_]).

findGroupsClassroomSchedule(Classroom, Hour, [_|RestOfSchedule]):-
	findGroupsClassroomSchedule(Classroom, Hour, RestOfSchedule).
/* /find if a given classroom is available at given hour */

/* find a free classroom at given hour that has the correct size for the group */
/* 2018-06-24 @jmrc */
findFreeClassroom(Group, Hour, Schedule, Classroom):-
	groupSize(Group, Size),
	classroomsCapacity(Classroom, Capacity),
	5 >= Size-Capacity,
	0 =< Size-Capacity,
	\+findGroupsClassroomSchedule(Classroom, Hour, Schedule).
/* /find a free classroom at given hour that has the correct size for the group */

/* ------------------- /utils.pl -------------------*/


/* ------------------- /rules.pl -------------------*/

/* rules that evaluate and assign the classrooms with a teacher */
/* 2018-06-24 @jmrc */
scheduleGroups([], _, FinalSchedule, FinalSchedule).

scheduleGroups([Group|RestOfGroups], CurrentHour, ScheduledGroups, FinalSchedule):-
	assignmentGroup(Assignment, Group),
	assignmentTeacher(Assignment, Teacher),
	isTeacherFree(Teacher, CurrentHour, ScheduledGroups),
	addGroupTeacher([Group, CurrentHour, Teacher], ScheduledGroups, Schedule),
	firstHour(Entrance),
	scheduleGroups(RestOfGroups, Entrance, Schedule, FinalSchedule).

scheduleGroups(Groups, CurrentHour, ScheduledGroups, FinalSchedule):-
	NewHour is CurrentHour + 1,
	lastHour(Exit),
	NewHour =< Exit,
	scheduleGroups(Groups, NewHour, ScheduledGroups, FinalSchedule).

scheduleGroups([Group|RestOfGroups], _, ScheduledGroups, FinalSchedule):-
	noTeacher(Teacher),
	firstHour(Hour),
	addGroupTeacher([Group, Hour, Teacher], ScheduledGroups, Schedule),
	scheduleGroups(RestOfGroups, Hour, Schedule, FinalSchedule).
/* /rules that evaluate and assign the groups with a teacher */

/* rules that evaluate and assign the classrooms to the groups */
/* 2018-06-26 @jmrc */
addGroupClassroom(GroupClassroom, [], [GroupClassroom|[]]).

addGroupClassroom(GroupClassroom, [Schedule|RestOfSchedule], [Schedule|NewSchedule]):-
	addGroupClassroom(GroupClassroom, RestOfSchedule, NewSchedule).

/* Schedule: [[Group, Hour, Teacher]|_] */
scheduleClassrooms([], FinalSchedule, FinalSchedule).

scheduleClassrooms([[Group, Hour, _]|RestOfGroups], ScheduledClassrooms, FinalSchedule):-
	findFreeClassroom(Group, Hour, ScheduledClassrooms, Classroom),
	addGroupClassroom([Group, Hour, Classroom], ScheduledClassrooms, Schedule),
	scheduleClassrooms(RestOfGroups, Schedule, FinalSchedule).

scheduleClassrooms([[Group, Hour, _]|RestOfGroups], ScheduledClassrooms, FinalSchedule):-
	noClassroom(Classroom),
	addGroupClassroom([Group, Hour, Classroom], ScheduledClassrooms, Schedule),
	scheduleClassrooms(RestOfGroups, Schedule, FinalSchedule).
/* /rules that evaluate and assign the classrooms to the groups */

/* facade rule, calls all the rules for evaluation*/
/* 2018-06-26 @jmrc */
schoolScheduler(Groups, ScheduledGroups, ScheduledClassrooms):-
	firstHour(Entrance),
	scheduleGroups(Groups, Entrance, [], ScheduledGroups),
	scheduleClassrooms(ScheduledGroups, [], ScheduledClassrooms).
/* /facade rule, calls all the rules for evaluation*/

/* ------------------- /rules.pl -------------------*/