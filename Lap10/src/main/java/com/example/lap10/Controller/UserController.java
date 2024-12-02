package com.example.lap10.Controller;

import com.example.lap10.Model.User;
import com.example.lap10.Repository.UserRepository;
import com.example.lap10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody@Valid User user, Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());

        }

        userService.addUser(user);
        return ResponseEntity.ok().body("added successfully");
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id , @RequestBody@Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
       Boolean oldUser = userService.updateUser(id, user);
        if(oldUser){
            return ResponseEntity.ok().body("updated successfully");
        }
        return ResponseEntity.badRequest().body("updated id failed");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Boolean oldUser = userService.deleteUser(id);
        if(oldUser){
            return ResponseEntity.ok().body("deleted successfully");
        }
        return ResponseEntity.badRequest().body(" user not found ");
    }


}
