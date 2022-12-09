package com.example.springessentials.util;

import com.example.springessentials.model.Anime;

public class AnimeCreatorUtil{

    public static Anime createAnimeToBeSaved(){
        return Anime.builder().name("Santhosh Sekar").build();
    }

    public static Anime createValidAnimal(){
        return Anime.builder().name("Santhosh Sekar ss").id(1).build();
    }

    public static Anime createValidUpdatedAnimal(){
        return Anime.builder().name("Santhosh Sekar ss  2").id(1).build();
    }

}
