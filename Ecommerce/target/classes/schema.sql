create table book 
(
	id integer not null,
	title varchar(255) not null,
	author varchar(255) not null,
	description varchar(255) not null,
	primary key(id)
);

create table products 
(
	id integer not null,
	price double not null,
	name varchar(50) not null,
	primary key(id)
);
