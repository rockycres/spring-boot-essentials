package com.example.springessentials.service;

import com.example.springessentials.model.Anime;
import com.example.springessentials.repository.AnimeRepository;
import com.example.springessentials.util.AtuUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    private final AtuUtils utils;

    public Page<Anime> listAll(Pageable pageable){
        return animeRepository.findAll(pageable);
    }

    public List<Anime> listAll(){
        return animeRepository.findAll();
    }


    @Transactional
    public Anime save(Anime anime) {
        Anime save = animeRepository.save(anime);
        return save;
    }

    public void delete(int id) {
        animeRepository.delete(utils.findAnimeOrThrowNotFound(id,animeRepository));
    }

    public void update(Anime anime) {
        animeRepository.save(anime);
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findById(int id){
        return utils.findAnimeOrThrowNotFound(id,animeRepository);
    }

}
