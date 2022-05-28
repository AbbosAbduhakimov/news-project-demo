package uz.abbos.jparepositoryfirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abbos.jparepositoryfirst.entity.UserType;


public interface UserTypeRepository extends JpaRepository<UserType,Integer> {
}
