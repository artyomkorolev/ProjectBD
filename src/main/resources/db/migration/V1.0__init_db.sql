
create table staff
(
    id           serial primary key,
    full_name    varchar not null,
    phone_number varchar not null unique
);

create table proc_room
(
    id   serial primary key,
    number int not null
);

create table proc
(
    id        serial primary key,
    name      varchar not null,
    price     int not null,
    staff_id int,
    proc_room_id int,
    foreign key (staff_id) references staff(id) on delete cascade,
    foreign key (proc_room_id) references proc_room(id) on delete cascade
);
create table living_room
(
    id serial primary key,
    number int not null,
    price int not null,
    status boolean not null
);
create table client
(
    id serial     primary key,
    full_name     varchar not null,
    phone_number  varchar not null unique,
    address varchar not null,
    living_room_id int,
    foreign key (living_room_id) references living_room(id) on delete cascade
);

create table client_proc
(
    client_id int,
    proc_id  int,
    count int,
    primary key (client_id,proc_id),
    foreign key (client_id) references client(id) on delete cascade,
    foreign key (proc_id) references proc(id) on delete cascade
);

CREATE OR REPLACE FUNCTION set_living_room_status()
RETURNS TRIGGER AS $$
BEGIN
UPDATE living_room
SET status = true
WHERE id = NEW.living_room_id;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_insert_client
AFTER INSERT
ON client
FOR EACH ROW
EXECUTE FUNCTION set_living_room_status();