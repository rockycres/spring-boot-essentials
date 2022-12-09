package com.example.springessentials.repository;

import com.example.springessentials.model.Anime;
import com.example.springessentials.util.AnimeCreatorUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@DataJpaTest
@DisplayName("Anime Repo Tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save creates anime when successful")
    public void save_PersistAnime_WhenSuccessful(){
        Anime anime = AnimeCreatorUtil.createAnimeToBeSaved();
        Anime saveAnime = this.animeRepository.save(anime);
        Assertions.assertThat(saveAnime.getId()).isNotNull();
        Assertions.assertThat(saveAnime.getName()).isNotNull();
        Assertions.assertThat(saveAnime.getName()).isEqualTo(anime.getName());

    }

    @Test
    @DisplayName("updates anime when successful")
    public void update_PersistAnime_WhenSuccessful(){
        Anime anime = AnimeCreatorUtil.createAnimeToBeSaved();
        Anime saveAnime = this.animeRepository.save(anime);
        saveAnime.setName("updated Name");
        Anime updatedAnime = this.animeRepository.save(saveAnime);
        Assertions.assertThat(saveAnime.getId()).isNotNull();
        Assertions.assertThat(saveAnime.getName()).isNotNull();
        Assertions.assertThat(saveAnime.getName()).isEqualTo(updatedAnime.getName());

    }

    @Test
    @DisplayName("deletes removes anime when successful")
    public void delete_PersistAnime_WhenSuccessful(){
        Anime anime = AnimeCreatorUtil.createAnimeToBeSaved();
        Anime saveAnime = this.animeRepository.save(anime);

        this.animeRepository.delete(saveAnime);

        Optional<Anime> animalOptional = this.animeRepository.findById(saveAnime.getId());

        Assertions.assertThat(animalOptional.isEmpty()).isTrue();
    }



}
