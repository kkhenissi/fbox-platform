package com.kkhenissi.fboxplatform.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    private String id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Category{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", photo='" + photo + '\'' +
            '}';
    }

    private String photo;
    @DBRef
    private Collection<Item> items = new ArrayList<>();


}
