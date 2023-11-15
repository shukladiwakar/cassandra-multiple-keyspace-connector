package com.diwakar.poc.cassandramultiplekeyspaceconnector.repo.space1;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.CassandraRepository;

@Table("emp_space2")
public class Employee {

    @PrimaryKey
    @Column("emp_id")
    int emp_id;
    @Column("emp_name")
    String emp_name;
    @Column("emp_city")

    String emp_city;
    @Column("emp_sal")

    int emp_sal;
    @Column("emp_phone")

    int emp_phone;
}
