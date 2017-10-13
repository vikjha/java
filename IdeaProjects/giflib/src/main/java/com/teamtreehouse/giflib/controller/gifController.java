package com.teamtreehouse.giflib.controller;


import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller //
public class gifController {//adding a method to handle all requests to homepage

    @Autowired //"DI"-Dependency Injection-- Spring can initialize fields as long as it can find a spring component for the same class for the field
    private GifRepository gifRepository;



    @RequestMapping(value = "/")//maps specific URI request to java method
    //@ResponseBody //indicates the string we are using should be the response w/o any further processing (now that we are using thymeleaf we get rid of response body)
    public String listGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";//to tell thymeleaf which view to use return the name of the html template excluding the extension so home.html-->"home"
    }




    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif= gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap) {
        List<Gif> gifs = gifRepository.findByFavoriteMark();
        modelMap.put("gifs", gifs);
        return "favorites";
    }

    @RequestMapping("/search")
    public String listSearch(@RequestParam String q, ModelMap modelMap){
        List<Gif> allGifs = gifRepository.findIfContains(q);
        modelMap.put("gifs", allGifs);
        return "favorites";
    }


}






