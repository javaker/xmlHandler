CREATE SCHEMA testDB AUTHORIZATION sa;

create table documents
(
	id int auto_increment,
	original_file_name varchar,
	transform_file_name varchar,
	date_receive date,
	original_file_content clob,
	transform_file_content clob,
	constraint documents_pk
		primary key (id)
);


