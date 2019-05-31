package com.kkhenissi.fboxplatform.dao;

import com.kkhenissi.fboxplatform.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface CategoryRepository extends MongoRepository<Category, String> {
}
