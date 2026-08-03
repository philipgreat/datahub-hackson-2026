
package com.example.paymentservice;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import javax.sql.DataSource;

import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.SimpleEntityMetaFactory;
import io.teaql.provider.jdbc.JdbcSqlExecutor;

import io.micronaut.runtime.Micronaut;

@Factory
public class App {

    public static void main(String[] args) {
        Micronaut.run(App.class, args);
    }

    @Singleton
    public EntityMetaFactory entityMetaFactory() {
        SimpleEntityMetaFactory factory = new SimpleEntityMetaFactory();
        new EntityMetaRegistry().assemble(factory);
        return factory;
    }

    @Singleton
    public JdbcSqlExecutor jdbcSqlExecutor(DataSource dataSource) {
        return new JdbcSqlExecutor(dataSource);
    }

    @Singleton
    public io.teaql.core.DataServiceExecutor dataServiceExecutor(JdbcSqlExecutor executor) {
        return new io.teaql.dataservice.sql.SqlDataServiceExecutor("default", executor);
    }

    @Singleton
    public io.teaql.core.DataServiceRegistry dataServiceRegistry(io.teaql.core.DataServiceExecutor dataServiceExecutor) {
        io.teaql.runtime.DefaultDataServiceRegistry registry = new io.teaql.runtime.DefaultDataServiceRegistry();
        registry.register("default", dataServiceExecutor);
        return registry;
    }
}