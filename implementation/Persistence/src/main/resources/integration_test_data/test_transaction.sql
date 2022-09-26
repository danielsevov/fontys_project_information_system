begin work;

truncate employees restart identity cascade;
truncate departments restart identity cascade;
truncate companies restart identity cascade;
truncate truckplans restart identity cascade;
truncate trucks restart identity cascade;

insert into departments (name, description, email)
values ('sales', 'loud mouths', 'info@example.com');

insert into employees (lastname, firstname, email, departmentid, dob)
values ('Puk', 'Piet', 'p.puk@vanderheiden.nl', 1, '1993-03-17');

insert into trucks (plate)
values ('Vroooom');

insert into truckplans(truckid, plan)
values (1, '[2019-05-05T19:30,2019-05-06T8:30)');

commit;

table employees;
table departments;
table companies;
table trucks;
table truckplans;

