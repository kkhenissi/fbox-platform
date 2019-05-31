package com.kkhenissi.fboxplatform.dao;

import com.kkhenissi.fboxplatform.entities.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends MongoRepository<Item, String> {
}
