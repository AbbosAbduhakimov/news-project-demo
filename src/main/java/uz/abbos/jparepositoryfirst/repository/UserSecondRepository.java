package uz.abbos.jparepositoryfirst.repository;

import org.springframework.data.repository.CrudRepository;
import uz.abbos.jparepositoryfirst.entity.User;

public interface UserSecondRepository  extends CrudRepository<User,Integer> {
    User findByName(String name);
}
