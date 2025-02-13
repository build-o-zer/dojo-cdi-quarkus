package org.buildozers.examples;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

public class SystemPropertyProducer {

    @Produces
    @SystemProperty
    public static String getProperty(InjectionPoint ip) {

        SystemProperty annotation = ip.getAnnotated().getAnnotation(SystemProperty.class);
        String value = annotation.value();
        return "NO-VALUE".equals(value) ? "NO-VALUE" : System.getProperty(value);
    }
}
