package com.github.hadesfranklyn.project.infra.repository;

import static com.github.hadesfranklyn.project.infra.repository.specs.GenericSpecs.conjunction;
import static com.github.hadesfranklyn.project.infra.repository.specs.ImageSpecs.extensionEqual;
import static com.github.hadesfranklyn.project.infra.repository.specs.ImageSpecs.nameLike;
import static com.github.hadesfranklyn.project.infra.repository.specs.ImageSpecs.tagsLike;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.github.hadesfranklyn.project.domain.entity.Image;
import com.github.hadesfranklyn.project.domain.enums.ImageExtension;

@Repository
public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

	/**
	 * 
	 * @param extension
	 * @param query
	 * @return
	 * 
	 *         SELECT * FROM IMAGE WHERE 1 = 1 AND EXTENSION = 'PNG' AND ( NAME LIKE
	 *         'QUERY'OR TAGS LIKE 'QUERY' )
	 */
	default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {
		// SELECT * FROM IMAGE WHERE 1 = 1
		Specification<Image> spec = where(conjunction());

		if (extension != null) {
			// AND EXTENSION = 'PNG'AND
			spec = spec.and(extensionEqual(extension));
		}

		if (StringUtils.hasText(query)) {
			// AND ( NAME LIKE 'QUERY'OR TAGS LIKE 'QUERY' )
			spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
		}

		return findAll(spec);
	}
}
