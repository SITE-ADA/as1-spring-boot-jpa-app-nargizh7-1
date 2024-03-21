package wm2.hw1.hw1.specifications;

import org.springframework.data.jpa.domain.Specification;
import wm2.hw1.hw1.model.Director;

public class DirectorSpecifications {
    public static Specification<Director> filterBy(String field, String value) {
        return (root, query, criteriaBuilder) -> {
            if (field.equals("firstName")) {
                return criteriaBuilder.like(root.get("firstName"), "%" + value + "%");
            } else if (field.equals("lastName")) {
                return criteriaBuilder.like(root.get("lastName"), "%" + value + "%");
            }
            return null;
        };
    }
}
