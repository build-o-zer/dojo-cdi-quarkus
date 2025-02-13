package org.buildozers.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.buildozers.videogames.VideoGameRepository;

import java.util.List;

@ApplicationScoped
public class DemoClass {

    @SystemProperty("java.version")
    @Getter
    String javaVersion;

    @SystemProperty("java.vendor.version")
    @Getter
    String javaVendorVersion;

    //@AllSystemProperties
    List<String> allProperties;

}
