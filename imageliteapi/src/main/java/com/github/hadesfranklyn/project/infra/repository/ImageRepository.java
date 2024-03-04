package com.github.hadesfranklyn.project.infra.repository;

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
		Specification<Image> conjunction = (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();

		Specification<Image> spec = Specification.where(conjunction);

		if (extension != null) {
			// AND EXTENSION = 'PNG'AND
			Specification<Image> extensionEqual = (root, q, cb) -> cb.equal(root.get("extension"), extension);
			spec = spec.and(extensionEqual);
		}

		if (StringUtils.hasText(query)) {
			// AND ( NAME LIKE 'QUERY'OR TAGS LIKE 'QUERY' )
			Specification<Image> nameLike = (root, q, cb) -> cb.like(cb.upper(root.get("name")),
					"%" + query.toUpperCase() + "%");
			Specification<Image> tagsLike = (root, q, cb) -> cb.like(cb.upper(root.get("tags")),
					"%" + query.toUpperCase() + "%");

			Specification<Image> nameOrTagsLike = Specification.anyOf(nameLike, tagsLike);

			spec = spec.and(nameOrTagsLike);
		}

		return findAll(spec);
	}
}
