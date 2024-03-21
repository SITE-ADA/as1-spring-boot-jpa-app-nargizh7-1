package wm2.hw1.hw1.repository;

import wm2.hw1.hw1.model.Director;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DirectorRepository extends JpaRepository<Director, Long>, JpaSpecificationExecutor<Director> {
    Iterable<Director> findByFirstNameAndLastName(String firstName, String lastName);
    Iterable<Director> findByFirstNameOrLastName(String firstName, String lastName);
}
