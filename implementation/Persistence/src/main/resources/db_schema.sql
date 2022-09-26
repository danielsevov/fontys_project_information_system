/**
  Central database schema for the business application.
 */
create table if not exists airport
(
    id       int generated always as identity primary key,
    name     text not null,
    location text not null,
    unique (name, location)
);

comment on table airport is 'Airport table for keeping track of an airport with a name and location.';

create table if not exists airplane
(
    id                  int generated always as identity primary key,
    max_capacity        int  not null default 0,
    registration_number text not null unique
);

comment on table airplane is 'Airplane table for storing the max. capacity of an airplane along with its reg. number.';

create table if not exists flight
(
    id                 int generated always as identity primary key,
    departure_datetime timestamp                    not null,
    arrival_datetime   timestamp                    not null,
    departure_airport  int references airport (id)  not null,
    arrival_airport    int references airport (id)  not null,
    plane              int references airplane (id) not null,
    price              real                         not null default 0,
    check ( departure_airport != flight.arrival_airport )
);

comment on table flight is 'Flight table for keeping track of departures and arrivals with a base price and plane.';


create table if not exists customer
(
    id         int generated always as identity primary key,
    name       text not null,
    email      text not null,
    birth_date date not null
);

create table if not exists booking
(
    id       int generated always as identity primary key,
    customer int references customer (id) not null
);

comment on table booking is 'Booking table, which serves as aggregation point for multiple tickets.';


create table if not exists ticket_type
(
    id         int generated always as identity primary key,
    name       text unique not null,
    multiplier real        not null check ( multiplier > 0 )
);

comment on table ticket_type is 'Ticket type table with a name and a price multiplier.';

create table if not exists ticket
(
    id          int generated always as identity primary key,
    flight      int references flight (id)      not null,
    customer    int references customer (id)    not null,
    seat_number text                            not null,
    booking     int references booking (id)     not null,
    ticket_type int references ticket_type (id) not null,
    price       real                            not null default 0
);

comment on table ticket is 'Ticket table that stores the associated flight and relevant information.';


create table if not exists ticket_option
(
    id    int generated always as identity primary key,
    name  text not null,
    price int  not null
);

comment on table ticket_option is 'Ticket option table with a name and price for an option.';

create table if not exists booked_option
(
    id            int generated always as identity primary key,
    ticket        int references ticket (id)        not null,
    ticket_option int references ticket_option (id) not null
);

comment on table booked_option is 'Booked option table, which serves as aggregation point for a ticket and an option.';

create table if not exists daily_discount
(
    id         int generated always as identity primary key,
    day        text not null,
    multiplier real not null check ( multiplier > 0 )
);

comment on table daily_discount is 'Daily discount table, which represents a flight discount for a day of the week.';

