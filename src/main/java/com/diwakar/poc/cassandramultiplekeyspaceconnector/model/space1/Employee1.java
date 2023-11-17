package com.diwakar.poc.cassandramultiplekeyspaceconnector.model.space1;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@Table(value = "emp_space1")
@Builder
public class Employee1 implements Serializable {

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
