package uz.abbos.jparepositoryfirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abbos.jparepositoryfirst.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
