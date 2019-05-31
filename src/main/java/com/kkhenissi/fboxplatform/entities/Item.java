package com.kkhenissi.fboxplatform.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Item {
    @Id
    private String id;
    private String name;
    private String description;
    private double initialPrice;
    private double currentePrice;
    private String  phase;
    private Date dateUpForSale;
    private Date dateOfSale;
    @DBRef
    private Category category;
}
