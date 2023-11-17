package com.diwakar.poc.cassandramultiplekeyspaceconnector.repo.space2;

import com.diwakar.poc.cassandramultiplekeyspaceconnector.model.space2.Employee2;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpSpace2Repo extends CassandraRepository<Employee2, Integer> {
}
