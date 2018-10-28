CREATE TABLE classrooms (
	classroom_name VARCHAR(5),
	capacity INT
);

CREATE TABLE assignments (
	assignment_name VARCHAR(50)
);

CREATE TABLE teachers (
	teacher_key VARCHAR(10),
	first_hour INT,
	last_hour INT
);

CREATE TABLE assignments_teachers (
	teacher_id INT REFERENCES teachers(row_id),
	assignment_id INT REFERENCES assignments(row_id)
);

CREATE TABLE groups (
	group_name VARCHAR(10),
	group_size INT,
	assignmet_id INT REFERENCES assignments(row_id),
	teacher_id INT REFERENCES teachers(row_id),
	classroom_id INT REFERENCES classrooms(row_id),
	hour INT
);