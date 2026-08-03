
package com.example.paymentservice;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class SchemaStartupListener {
    private static final Logger log = LoggerFactory.getLogger(SchemaStartupListener.class);

    @EventListener
    void onStart(StartupEvent event) {
        log.info("SchemaStartupListener skipped for this version of teaql.");
    }
}