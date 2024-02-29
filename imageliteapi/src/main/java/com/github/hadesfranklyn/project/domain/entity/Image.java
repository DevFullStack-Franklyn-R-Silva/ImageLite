package com.github.hadesfranklyn.project.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.github.hadesfranklyn.project.domain.enums.ImageExtension;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_image")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column
	private String name;

	@Column
	private Long size;

	@Column
	@Enumerated(EnumType.STRING)
	private ImageExtension extension;

	@Column
	@CreatedDate
	private LocalDateTime uploadDate;

	@Column
	private String tags;

	@Column
	@Lob
	private byte[] file;

	public String getFileName() {
		//flowers.PNG
		return getName().concat(".").concat(getExtension().name());
	}
}
