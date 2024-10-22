package uth.edu.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.backend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
