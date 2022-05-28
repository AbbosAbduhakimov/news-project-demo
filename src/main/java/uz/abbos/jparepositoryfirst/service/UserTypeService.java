package uz.abbos.jparepositoryfirst.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.abbos.jparepositoryfirst.entity.UserType;
import uz.abbos.jparepositoryfirst.exception.BadRequestException;
import uz.abbos.jparepositoryfirst.repository.UserTypeRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;


    public UserType getByID(Integer id) {
        Optional<UserType> optional = userTypeRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequestException("usertype not found");
        }
        return optional.get();
    }

    public UserType createUserType(UserType userType) {
        userType.setCreatedAt(LocalDateTime.now());
        userType.setStatus(true);
        userTypeRepository.save(userType);
        return userType;
    }

    @Transactional
    public boolean updateUserType(UserType userType, Integer id) {
        UserType utype = getByID(id);
        utype.setUpdatedAt(LocalDateTime.now());
        utype.setName(userType.getName());
        return true;
    }

    public boolean deleteUserType(Integer id){
        try {
            UserType userType = getByID(id);
            userTypeRepository.delete(userType);
            return true;
        }
        catch (Exception e){
            throw new IllegalArgumentException("usertype not found");
        }
    }
}
