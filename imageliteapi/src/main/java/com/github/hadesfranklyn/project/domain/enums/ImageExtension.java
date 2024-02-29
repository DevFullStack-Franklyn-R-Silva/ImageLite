package com.github.hadesfranklyn.project.domain.enums;

import java.util.Arrays;

import org.springframework.http.MediaType;

public enum ImageExtension {
	PNG(MediaType.IMAGE_PNG), GIF(MediaType.IMAGE_GIF), JPEG(MediaType.IMAGE_JPEG);

	private MediaType mediaType;

	private ImageExtension(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public static ImageExtension valueOf(MediaType mediaType) {
		return Arrays.stream(values()).filter(ie -> ie.mediaType
				.equals(mediaType)).findFirst().orElse(null);
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

}
