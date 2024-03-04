package com.github.hadesfranklyn.project.domain.service;

import java.util.List;
import java.util.Optional;

import com.github.hadesfranklyn.project.domain.entity.Image;
import com.github.hadesfranklyn.project.domain.enums.ImageExtension;

public interface ImageService {
	Image save(Image image);
	
	Optional<Image> getById(String id);
	
	List<Image> search(ImageExtension extension, String  query);
}
