package com.github.hadesfranklyn.project.images;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.hadesfranklyn.project.domain.entity.Image;
import com.github.hadesfranklyn.project.domain.service.ImageService;
import com.github.hadesfranklyn.project.infra.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

	private final ImageRepository repository;
	
	@Override
	@Transactional
	public Image save(Image image) {
		return repository.save(image);
	}

}
