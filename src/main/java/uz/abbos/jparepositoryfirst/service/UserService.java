package uz.abbos.jparepositoryfirst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.abbos.jparepositoryfirst.entity.User;
import uz.abbos.jparepositoryfirst.exception.BadRequestException;
import uz.abbos.jparepositoryfirst.repository.UserRepository;
import uz.abbos.jparepositoryfirst.repository.UserSecondRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSecondRepository userSecondRepository;

    public User getUser(Integer id) {
     return check(id);
    }

//    @Modifying
//    @Query("update User user set user.id = :id")
    public boolean updateUser(User user, Integer id) {
        try {
            User u = getUser(id);
            u.setUserTypeID(user.getUserTypeID());
            u.setName(user.getName());
            u.setSurname(user.getSurname());
            u.setPassword(user.getPassword());
            u.setContact(user.getContact());
            userRepository.save(u);
            return true;
        }
        catch (Exception e){
            throw new BadRequestException("user not found");
        }
    }

    public User createUser(User user) {
        user.setStatus(true);
        userRepository.save(user);
        return user;
    }

    public boolean deleteUser(Integer id) {
        try {
            User user = getUser(id);
            userRepository.delete(user);
            return true;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("user not found");
        }
    }

    public User byName(String name) {
        Optional<User> optional= Optional.ofNullable(userSecondRepository.findByName(name));
        if (optional.isEmpty()){
            throw new IllegalArgumentException("user not found");
        }
        return optional.get();

    }

    public User check(Integer id){
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("user not found");
        }
        return optional.get();
    }
}
