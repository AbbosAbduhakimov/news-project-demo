package uz.abbos.jparepositoryfirst.contorller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abbos.jparepositoryfirst.entity.User;
import uz.abbos.jparepositoryfirst.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id){
        User result = userService.getUser(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        User result = userService.createUser(user);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user,
                                        @RequestParam("id") Integer id){
        boolean result = userService.updateUser(user,id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        boolean result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/byName")
    public ResponseEntity<?> findName(@RequestParam("name") String name){
        User user = userService.byName(name);
        return ResponseEntity.ok(user);
    }



}
