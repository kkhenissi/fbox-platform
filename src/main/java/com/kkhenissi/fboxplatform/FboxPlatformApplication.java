package com.kkhenissi.fboxplatform;

import com.kkhenissi.fboxplatform.dao.CategoryRepository;
import com.kkhenissi.fboxplatform.dao.ItemRepository;
import com.kkhenissi.fboxplatform.entities.Category;
import com.kkhenissi.fboxplatform.entities.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Stream;

@SpringBootApplication
public class FboxPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(FboxPlatformApplication.class, args);
	}



	@Bean
	CommandLineRunner start(CategoryRepository categoryRepository, ItemRepository itemRepository) {
		return args -> {
			categoryRepository.deleteAll();
			Stream.of("C1 Computer","C2 Printer").forEach(c->{
				categoryRepository.save(new Category(c.split(" " )[0],c.split(" ")[1],"Category of ...","",new ArrayList<>()));
			});
			categoryRepository.findAll().forEach(System.out::println);

			itemRepository.deleteAll();
			Category c1 = categoryRepository.findById("C1").get();
			Stream.of("P1","P2","P3","P4").forEach(name ->{
				Item itm = itemRepository.save(new Item(null,"","",Math.random()*1000,Math.random()*700,"on Sale", new Date(),new Date(),c1));
				c1.getItems().add(itm);
				categoryRepository.save(c1);
			});
			Category c2 = categoryRepository.findById("C2").get();
			Stream.of("P4","P5","P6","P7").forEach(name ->{
				itemRepository.save(new Item(null,"","",Math.random()*1000,Math.random()*700,"on Sale", new Date(),new Date(),c1));
			});
		};
	}

}
