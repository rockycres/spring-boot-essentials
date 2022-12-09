package com.example.springessentials.controller;

import com.example.springessentials.model.Anime;
import com.example.springessentials.service.AnimeService;
import com.example.springessentials.util.AtuUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("anime")
@Slf4j
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;


    @GetMapping("/list")
    public ResponseEntity<Page<Anime>> listAll(Pageable pageable){
        return new ResponseEntity<>(animeService.listAll(pageable), OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Anime>> listAll(){
        return new ResponseEntity<>(animeService.listAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable int id){
            return ResponseEntity.ok(animeService.findById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<Anime>> findByName(@RequestParam(value = "name") String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody @Valid Anime anime){
        return  ResponseEntity.ok(animeService.save(anime));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        animeService.delete(id);
        return  new ResponseEntity<>(NO_CONTENT);
    }


    @PutMapping
    public ResponseEntity<Anime> update(Anime anime){
        animeService.update(anime);
        return  new ResponseEntity<>(NO_CONTENT);
    }


}
