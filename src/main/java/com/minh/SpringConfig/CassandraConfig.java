package com.minh.SpringConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;

import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		// TODO Auto-generated method stub
		return "abderrahmen";
	}

	public String getContactPoints() {
		return "localhost";
	}

	@Override
	public String getLocalDataCenter() {
		return "datacenter1";
	}

	@Bean
	@Primary
	public CqlSessionFactoryBean cqlSessionFactoryBean() {
		CqlSessionFactoryBean session = new CqlSessionFactoryBean();
		session.setContactPoints(getContactPoints());
		session.setKeyspaceName(getKeyspaceName());
		session.setLocalDatacenter(getLocalDataCenter());
		return session;
	}

	@Bean
	@Primary
	public SessionFactoryFactoryBean sessionFactory(CqlSession session, CassandraConverter converter) {
		SessionFactoryFactoryBean sessionFactory = new SessionFactoryFactoryBean();
		sessionFactory.setSession(session);
		sessionFactory.setConverter(converter);
		sessionFactory.setSchemaAction(SchemaAction.NONE);
		return sessionFactory;
	}

	@SuppressWarnings("deprecation")
	@Bean
	@Primary
	public CassandraMappingContext mappingContext(CqlSession cqlSession) {

		CassandraMappingContext mappingContext = new CassandraMappingContext();
		mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cqlSession));
		return mappingContext;
	}

	@Bean
	@Primary
	public CassandraConverter converter(CassandraMappingContext mappingContext) {
		return new MappingCassandraConverter(mappingContext);
	}

	@Bean
	public CassandraOperations cassandraTemplate(SessionFactory sessionFactory, CassandraConverter converter) {
		return new CassandraTemplate(sessionFactory, converter);
	}
}
