package org.buildozers.videogames;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VideoGameRepository implements PanacheRepository<VideoGame> {
    // Additional query methods can be defined here if needed
}