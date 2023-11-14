
create table staff
(
    id           serial primary key,
    phone_number varchar not null unique,

    full_name    varchar not null
);
create table procedure
(
    id        serial primary key,
    name      varchar not null,
    staff_id  int not null ,
    foreign key (staff_id) references staff (id)
);


create table procedure_room
(
    id        serial primary key,
    name      varchar not null ,
    caparity  int not null
);

create table client
(
    id serial     primary key,

    full_name     varchar not null,
    gender        varchar not null,
    date_of_birth date not null,
    adress        varchar not null,
    phone_number  varchar not null unique
);

create table living_room
(
    id serial primary key,
    number    int not null,
    floor     int not null,
    type      varchar not null
);

create table room_occupancy
(
    living_room_id  int,
    client_id       int,
    start_occupancy date not null,
    end_occupancy   date not null,
    primary key (living_room_id,client_id)
);

create table client_procedure
(
    client_id     int,
    procedure_id  int,
    primary key (client_id,procedure_id)
);

create table procedure_procedure_room
(
    procedure_id      int,
    procedure_room_id int,
    start_procedure   time not null,
    end_procedure     time not null,
    primary key (procedure_id,procedure_room_id)
);