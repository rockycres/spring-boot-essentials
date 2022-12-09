package com.example.springessentials.repository;

import com.example.springessentials.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime,Integer> {

    List<Anime> findByName(String name);

}
