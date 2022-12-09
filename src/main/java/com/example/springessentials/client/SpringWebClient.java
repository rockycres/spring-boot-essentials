package com.example.springessentials.client;

import com.example.springessentials.controller.AnimeController;
import com.example.springessentials.model.Anime;
import com.example.springessentials.wrappers.PageableResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
public class SpringWebClient {

    public static void main(String[] args) {
       /* ResponseEntity<Anime> animeResponseEntity = new RestTemplate().getForEntity(
                "http://localhost:8080/anime/list", Anime.class);

        log.info("Response data {}",animeResponseEntity.getBody());

        Anime animeResponse = new RestTemplate().getForObject(
                "http://localhost:8080/anime/list", Anime.class);

        log.info("Response data {}",animeResponse);*/

     /*   ResponseEntity<PageableResponse<Anime>> animeResponseEntityList =  new RestTemplate()
                .exchange(
                "http://localhost:8080/anime/all",
                 HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageableResponse<Anime>>() {});*/

      //  log.info("Response data {}",animeResponseEntityList.getBody());


    }
}
