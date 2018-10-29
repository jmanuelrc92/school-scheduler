:- begin_tests(groupTeacherRules).
:- use_module(library(rules)).

/* Schedule: [[Group, Hour, Teacher]|_] */
test(findGroupsTeacherSchedule):-
	not(findGroupsTeacherSchedule('John', 7, [['Group1', 8, 'Peter'], ['Group2', 8, 'John'], ['Group3', 7, 'William']])),
	findGroupsTeacherSchedule('John', 7, [['Group1', 8, 'Peter'], ['Group2', 8, 'John'], ['Group3', 7, 'John']]).

test(addGroupTeacher):-
	addGroupTeacher(['Group4', 9, 'Peter'], [['Group1', 8, 'Peter'], ['Group2', 8, 'John'], ['Group3', 7, 'William']]),
	addGroupTeacher(['Group1', 9, 'Peter'], []).

:- end_tests(groupTeacherRules).