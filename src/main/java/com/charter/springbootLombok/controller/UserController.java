package com.charter.springbootLombok.controller;

import com.charter.springbootLombok.model.User;
import com.charter.springbootLombok.service.UserService;
import javassist.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping("/users")
        public ResponseEntity<List<User>> getAllUsers() {
            return new ResponseEntity<>(userService.listAllUser(), HttpStatus.OK);
        }

        @GetMapping("/users/{id}")
        public ResponseEntity <User> gUserById(@PathVariable(value = "id") Long userId) throws NotFoundException{
            User user = userService.findUser(userId);
            if(user == null)
                throw new NotFoundException("User not found for this id : " + userId);
            return ResponseEntity.ok().body(user);
        }

        @PostMapping("/users")
        public User createUser( @Valid @RequestBody User user) {
            return userService.saveUser(user);
        }

        @PutMapping("/users/{id}")
        public ResponseEntity <User> updateUser(@PathVariable(value = "id") Long userId,@Valid @RequestBody User userDetails) throws NotFoundException {
            User user = userService.findUser(userId);
            if(user == null)
                throw new NotFoundException("User not found for this id : " + userId);
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setAge(userDetails.getAge());
            final User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        }

        @DeleteMapping("/users/{id}")
        public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws NotFoundException {
            User user = userService.findUser(userId);
            if(user == null)
                throw new NotFoundException("User not found for this id : " + userId);
            userService.deleteUser(user);
            Map <String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
}
