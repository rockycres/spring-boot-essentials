package com.example.springessentials.util;

import com.example.springessentials.exception.ResourceNotFoundException;
import com.example.springessentials.model.Anime;
import com.example.springessentials.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class AtuUtils {

    public String formatLocalDateToDbDateStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

    public Anime findAnimeOrThrowNotFound(int id, AnimeRepository animeRepository){
        return animeRepository.findById(id)
                .orElseThrow(
                    () -> new ResourceNotFoundException("Anime not found"));
    }
}
