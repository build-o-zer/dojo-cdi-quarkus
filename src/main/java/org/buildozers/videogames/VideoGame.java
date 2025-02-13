package org.buildozers.videogames;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// JPA
@Entity

// Lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class VideoGame {

    @Id
    @GeneratedValue
    @Getter
    long id;

    @Getter @Setter
    String title;

    @Getter @Setter
    LocalDate releaseDate;

    @Getter @Setter
    BigDecimal price;

    @Version
    long version;

}
