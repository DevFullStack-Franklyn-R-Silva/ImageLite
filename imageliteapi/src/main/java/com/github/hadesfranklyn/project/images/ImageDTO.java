package com.github.hadesfranklyn.project.images;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageDTO {

	private String url;
	private String name;
	private String extension;
	private Long size;
	private LocalDate uploadDate;
}
