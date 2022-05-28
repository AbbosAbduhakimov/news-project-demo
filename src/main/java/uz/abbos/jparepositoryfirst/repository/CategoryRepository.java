package uz.abbos.jparepositoryfirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abbos.jparepositoryfirst.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
