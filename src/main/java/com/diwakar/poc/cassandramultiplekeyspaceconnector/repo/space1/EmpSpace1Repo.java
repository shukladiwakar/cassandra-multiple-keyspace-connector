package com.diwakar.poc.cassandramultiplekeyspaceconnector.repo.space1;

import com.diwakar.poc.cassandramultiplekeyspaceconnector.model.space1.Employee1;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpSpace1Repo extends CassandraRepository<Employee1, Integer> {
}
