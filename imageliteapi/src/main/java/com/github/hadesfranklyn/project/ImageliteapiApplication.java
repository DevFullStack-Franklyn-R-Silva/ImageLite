package com.github.hadesfranklyn.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.github.hadesfranklyn.project.domain.entity.Image;
import com.github.hadesfranklyn.project.domain.enums.ImageExtension;
import com.github.hadesfranklyn.project.infra.repository.ImageRepository;

@SpringBootApplication
@EnableJpaAuditing
public class ImageliteapiApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ImageRepository repository) {
		return args -> {
			Image image = Image.builder()
					.extension(ImageExtension.PNG)
					.name("myimage")
					.tags("test")
					.size(1000L)
					.build();
			repository.save(image);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ImageliteapiApplication.class, args);
	}

}
