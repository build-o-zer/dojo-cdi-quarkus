package org.buildozers.videogames;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class VideoGameStartup {

    private final VideoGameRepository videoGameRepository;

    public void onStart(@Observes StartupEvent ev) {
        log.info("The application is starting...");
        boolean isEmpty = videoGameRepository.findAll().stream().count() <= 0;
        if (isEmpty) {            
            createVideoGames();
        }
      
    }

    @Transactional
    void createVideoGames() {
        log.info("Creating video games...");
        
        videoGameRepository.persist(VideoGame.builder()
        .title("Super Mario Bros.")
        .releaseDate(java.time.LocalDate.of(1985, 9, 13))
        .price(java.math.BigDecimal.valueOf(59.99))
        .build());

        videoGameRepository.persist(VideoGame.builder()
        .title("The Legend of Zelda")
        .releaseDate(java.time.LocalDate.of(1986, 2, 21))
        .price(java.math.BigDecimal.valueOf(49.99))
        .build());

        videoGameRepository.persist(VideoGame.builder()
        .title("Xenon 2")
        .releaseDate(java.time.LocalDate.of(1989, 9, 1))
        .price(java.math.BigDecimal.valueOf(29.99))
        .build());

        videoGameRepository.persist(VideoGame.builder()
        .title("Speedball")
        .releaseDate(java.time.LocalDate.of(1988, 11, 1))
        .price(java.math.BigDecimal.valueOf(19.99))
        .build());

        log.info("Video games created.");

        videoGameRepository.findAll().stream().forEach(videoGame -> {
            log.info("{}", videoGame);
        });

    }


    public void onStop(@Observes ShutdownEvent ev) {
        System.out.println("The application is stopping...");
    }
    
}
