package wm2.hw1.hw1.specifications;

import org.springframework.data.jpa.domain.Specification;
import wm2.hw1.hw1.model.Movie;

public class MovieSpecifications {
    public static Specification<Movie> filterBy(String field, String value) {
        return (root, query, criteriaBuilder) -> {
            if (field.equals("name")) {
                return criteriaBuilder.like(root.get("name"), "%" + value + "%");
            } else if (field.equals("country")) {
                return criteriaBuilder.like(root.get("country"), "%" + value + "%");
            } else if (field.equals("wins")) {
                return criteriaBuilder.equal(root.get("wins"), value);
            }
            return null;
        };
    }
}
