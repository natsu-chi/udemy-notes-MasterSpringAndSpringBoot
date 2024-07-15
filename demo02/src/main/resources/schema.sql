create table course (
    id bigint not null,
    course_name varchar(255) not null,
    course_code varchar(255) not null,
    primary key (id)
);

create table person_detail (
   id bigint not null,
   name varchar(255) not null,
   blood_type enum('A', 'B', 'O', 'AB') not null,
   primary key (id)
);

create table review (
    id bigint not null,
    reviewer_id int not null,
    content varchar(255),
    primary key (id),
    foreign key (reviewer_id) references person_detail(id)
);