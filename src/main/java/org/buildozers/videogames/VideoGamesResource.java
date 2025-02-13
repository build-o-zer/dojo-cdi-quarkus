package org.buildozers.videogames;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.buildozers.examples.DemoClass;

@Path("/video-games")
@RequiredArgsConstructor
public class VideoGamesResource {

    private final VideoGameRepository videoGameRepository;
    private final DemoClass demoClass;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<VideoGame> findAll() {
        return videoGameRepository.findAll().list();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/java-version")
    public List<String> getJavaVersion() {
        return List.of(demoClass.getJavaVersion(), demoClass.getJavaVendorVersion());
    }
}
