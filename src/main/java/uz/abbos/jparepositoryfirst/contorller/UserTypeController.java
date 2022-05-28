package uz.abbos.jparepositoryfirst.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import uz.abbos.jparepositoryfirst.entity.UserType;
import uz.abbos.jparepositoryfirst.service.UserTypeService;

@RestController
@RequestMapping("usertype")
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserType(@PathVariable Integer id){
        UserType result = userTypeService.getByID(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<?> createUserType(@RequestBody UserType userType){
        UserType result = userTypeService.createUserType(userType);
        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public ResponseEntity<?> updateUserType(@RequestBody UserType userType,
                                            @RequestParam("id") Integer id){
        boolean result = userTypeService.updateUserType(userType,id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUserType(@PathVariable Integer id){

        boolean result = userTypeService.deleteUserType(id);
        return ResponseEntity.ok(result);
    }

}
