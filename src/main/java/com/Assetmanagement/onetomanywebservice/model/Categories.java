package com.Assetmanagement.onetomanywebservice.model;

import com.Assetmanagement.onetomanywebservice.model.dto.CategoriesDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cart_id")
    private List<Assets> assets = new ArrayList<>();

    public void addItem(Assets assets){
        this.assets.add(assets);
    }

    public void removeItem(Assets assets){
        this.assets.remove(assets);
    }

    public static Categories from(CategoriesDto categoriesDto){
        Categories categories = new Categories();
        categories.setName(categoriesDto.getName());
        return categories;
    }
}
