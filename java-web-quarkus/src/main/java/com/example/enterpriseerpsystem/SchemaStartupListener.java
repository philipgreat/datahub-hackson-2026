
package com.example.enterpriseerpsystem;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class SchemaStartupListener {
    private static final Logger log = LoggerFactory.getLogger(SchemaStartupListener.class);

    void onStart(@Observes StartupEvent ev) {
        log.info("SchemaStartupListener skipped for this version of teaql.");
    }
}