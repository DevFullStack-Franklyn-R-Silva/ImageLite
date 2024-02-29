package com.github.hadesfranklyn.project.images;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/images")
@CrossOrigin("*")
@Slf4j
public class ImagesController {

	@PostMapping
	public ResponseEntity<?> save(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("tags") List<String> tags) {
		log.info("Imagem recebida: name: {}, size: {} ", file.getOriginalFilename(), file.getSize());
		log.info("Nome defenido para a imagem: {}", name);
		log.info("Tags: {}", tags);
		return ResponseEntity.ok().build();
	}
}
