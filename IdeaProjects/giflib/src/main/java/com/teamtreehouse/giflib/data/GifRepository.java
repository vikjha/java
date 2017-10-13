package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Gif;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("giphy", 2, LocalDate.of(2016,10,30), "Testing0", true),
            new Gif("giphy1", 2, LocalDate.of(2016,9,15), "Testing1", false),
            new Gif("giphy2", 2, LocalDate.of(2015,2,13), "Testing2", true),
            new Gif("giphy3", 2, LocalDate.of(2010,2,13), "Testing3", false),
            new Gif("giphy4", 2, LocalDate.of(2017,7,23), "Testing4", true),
            new Gif("android-explosion", 1, LocalDate.of(2016,10,30), "Ben Jakuben", true),
            new Gif("ben-and-mike", 1, LocalDate.of(2016,9,15), "Craig Dennis", false),
            new Gif("book-dominos", 1, LocalDate.of(2015,2,13), "Ada Lovelace", true),
            new Gif("compiler-bot", 1, LocalDate.of(2010,2,13), "Grace Hopper", false),
            new Gif("cowboy-coder", 1, LocalDate.of(2017,7,23), "Marissa Mayer", true)
    );

    public Gif findByName(String name){
        for(Gif gif: ALL_GIFS){
            if(gif.getName().equals(name)){
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id){ // for the category controller
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS){
            if(gif.getCategoryId() == id){
                gifs.add(gif);
            }
        }
        return gifs;
    }

    //for-each loop
    public List<Gif> findByFavoriteMark() {
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if(gif.isFavorite()) {
                gifs.add(gif);
            }
        }
        return gifs;
    }

    /*stream
    public List<Gif> findByFavoriteMark() {
       return ALL_GIFS
                .stream()
                .filter(Gif::isFavorite)
                .collect(Collectors.toList());
    }*/

    //for-each loop
    public List<Gif> findIfContains(String query){
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS){
            if(gif.getName().toLowerCase().contains(query.trim().toLowerCase())){
                gifs.add(gif);
            }
        }
        return gifs;
    }

    /*or stream
    public List<Gif> findBySearch(String search) {
        return ALL_GIFS
                .stream()
                .filter(e-> e.getName().toLowerCase().contains(search))
                .collect(Collectors.toList());
    }*/

}

