# How to run this project

### Guides

The following guides illustrate step-by-step process :

1. Install Docker using on you machine .
2. Run the cassandra cluster using the below command

```
 docker run --name cass_c1 -v container-volume -p 9042:9042 cassandra:latest
```

3. Once the server is up . Make sure you are able to connect via 9042 port
4. Initialise the server with below commands

```
create keyspace space1;
create keyspace space2;


// keyspace 1 
use space1;
CREATE TABLE emp_space2
(
    emp_id    int PRIMARY KEY,
    emp_name  text,
    emp_city  text,
    emp_sal   varint,
    emp_phone varint
);

INSERT INTO emp_space1(emp_id, emp_name,  emp_city, emp_sal,emp_phone) values (1, 'diwakar', 'pune', 1111, 212121);
INSERT INTO emp_space1(emp_id, emp_name,  emp_city, emp_sal,emp_phone) values (2, 'vaibhav', 'banglore', 1111, 212121);
INSERT INTO emp_space2(emp_id, emp_name,  emp_city, emp_sal,emp_phone) values (3, 'shubham', 'noida', 1111, 212121);


// keypsace 2

use space2;
CREATE TABLE emp_space2
(
    emp_id    int PRIMARY KEY,
    emp_name  text,
    emp_city  text,
    emp_sal   varint,
    emp_phone varint
);
INSERT INTO emp_space2(emp_id, emp_name,  emp_city, emp_sal,emp_phone) values (1, 'diwakar', 'pune', 1111, 212121);
INSERT INTO emp_space2(emp_id, emp_name,  emp_city, emp_sal,emp_phone) values (2, 'vaibhav', 'banglore', 1111, 212121);
INSERT INTO emp_space2(emp_id, emp_name,  emp_city, emp_sal,emp_phone) values (3, 'shubham', 'noida', 1111, 212121);
```

5. Run the application
6. Use this curl to test the output

```
2023-11-17T20:50:26.710+05:30  INFO 75078 --- [nio-8080-exec-2] c.d.p.c.controller.DummyController       : EMP from space1 [{"emp_id":1,"emp_name":"diwakar","emp_city":"pune","emp_sal":1,"emp_phone":212121},{"emp_id":2,"emp_name":"vaibhav","emp_city":"banglore","emp_sal":1111,"emp_phone":212121},{"emp_id":3,"emp_name":"shubham","emp_city":"noida","emp_sal":1111,"emp_phone":212121}]
2023-11-17T20:50:26.711+05:30  INFO 75078 --- [nio-8080-exec-2] c.d.p.c.controller.DummyController       : EMP from space2 [{"emp_id":1,"emp_name":"diwakar","emp_city":"pune","emp_sal":1111,"emp_phone":212121},{"emp_id":2,"emp_name":"vaibhav","emp_city":"banglore","emp_sal":1111,"emp_phone":212121},{"emp_id":3,"emp_name":"shubham","emp_city":"noida","emp_sal":1111,"emp_phone":212121}]
```