package org.buildozers.videogames;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/video-games")
@RequiredArgsConstructor
public class VideoGamesResource {

    private final VideoGameRepository videoGameRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VideoGame> findAll() {
        return videoGameRepository.findAll().list();
    }
}
