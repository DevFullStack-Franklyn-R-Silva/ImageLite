package com.github.hadesfranklyn.project.domain.service;

import java.util.Optional;

import com.github.hadesfranklyn.project.domain.entity.Image;

public interface ImageService {
	Image save(Image image);
	
	Optional<Image> getById(String id);
}
