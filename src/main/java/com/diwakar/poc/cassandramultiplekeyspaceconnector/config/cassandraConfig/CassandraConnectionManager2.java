package com.diwakar.poc.cassandramultiplekeyspaceconnector.config.cassandraConfig;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.net.InetSocketAddress;


@Configuration
@EnableCassandraRepositories(basePackages = "com.diwakar.poc.cassandramultiplekeyspaceconnector.repo.space2", cassandraTemplateRef = "space2Template")
public class CassandraConnectionManager2 extends CassandraBaseConfig {

    @Value("${spring.space2.keyspace.name}")
    private String keyspace;

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.diwakar.poc.cassandramultiplekeyspaceconnector.model.space2"};
    }

    public CqlSession session() {
        return CqlSession.builder().withLocalDatacenter(getLocalDataCenter())
                .addContactPoint(InetSocketAddress.createUnresolved(getContactPoints(), getPort()))
                .withAuthCredentials(username, password)
                .withKeyspace(getKeyspaceName()).build();
    }

    @Override
    @Primary
    @Bean(name = "space2Template")
    public CassandraAdminTemplate cassandraTemplate() {
        return new CassandraAdminTemplate(session());
    }
}
