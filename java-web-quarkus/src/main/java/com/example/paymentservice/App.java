
package com.example.paymentservice;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import javax.sql.DataSource;

import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.SimpleEntityMetaFactory;
import io.teaql.provider.jdbc.JdbcSqlExecutor;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class App {

    public static void main(String... args) {
        Quarkus.run(args);
    }

    @Produces
    @ApplicationScoped
    public EntityMetaFactory entityMetaFactory() {
        SimpleEntityMetaFactory factory = new SimpleEntityMetaFactory();
        new EntityMetaRegistry().assemble(factory);
        return factory;
    }

    @Produces
    @ApplicationScoped
    public JdbcSqlExecutor jdbcSqlExecutor(DataSource dataSource) {
        return new JdbcSqlExecutor(dataSource);
    }

    @Produces
    @ApplicationScoped
    public io.teaql.core.DataServiceExecutor dataServiceExecutor(JdbcSqlExecutor executor) {
        return new io.teaql.dataservice.sql.SqlDataServiceExecutor("default", executor);
    }

    @Produces
    @ApplicationScoped
    public io.teaql.core.DataServiceRegistry dataServiceRegistry(io.teaql.core.DataServiceExecutor dataServiceExecutor) {
        io.teaql.runtime.DefaultDataServiceRegistry registry = new io.teaql.runtime.DefaultDataServiceRegistry();
        registry.register("default", dataServiceExecutor);
        return registry;
    }
}