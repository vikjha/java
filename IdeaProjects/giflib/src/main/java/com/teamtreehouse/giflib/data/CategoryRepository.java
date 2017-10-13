package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Coder Gifs"),
            new Category(2, "South Park Gifs"),
            new Category(3, "Game of Throne Gifs")
    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category findByID(int id){
        for(Category category: ALL_CATEGORIES){
            if(category.getId() == id){
                return category;

            }
        }
        return null;
    }
}
