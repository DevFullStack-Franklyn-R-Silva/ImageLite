package com.github.hadesfranklyn.project.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.hadesfranklyn.project.domain.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String>{

}
