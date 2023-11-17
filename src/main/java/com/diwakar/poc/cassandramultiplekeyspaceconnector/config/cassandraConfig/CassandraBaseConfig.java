package com.diwakar.poc.cassandramultiplekeyspaceconnector.config.cassandraConfig;


import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.session.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;

@Configuration
public abstract class CassandraBaseConfig extends AbstractCassandraConfiguration {

    @Value("${spring.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.cassandra.port}")
    private int port;

    @Value("${spring.cassandra.local-datacenter}")
    private String datacenter;

    @Value("${spring.cassandra.username}")
    protected String username;

    @Value("${spring.cassandra.password}")
    protected String password;

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getLocalDataCenter() {
        return datacenter;
    }

    @Bean
    @ConditionalOnMissingBean
    public CassandraTemplate cassandraTemplate(CqlSession session, CassandraConverter converter) throws Exception {
        return new CassandraTemplate(session, converter);
    }

}