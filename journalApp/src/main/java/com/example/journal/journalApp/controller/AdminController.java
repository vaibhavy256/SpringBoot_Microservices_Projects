package com.example.journal.journalApp.controller;

import com.example.journal.journalApp.entity.User;
import com.example.journal.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserEntryService userEntryService;

    @GetMapping("/all")
    public ResponseEntity<?>getAllUsers(){
        List<User>allUsers=userEntryService.getAllUserEntries();
        if(allUsers!=null && !allUsers.isEmpty()){
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/add_admin")
    public ResponseEntity<?>addAdminUser(@RequestBody User user){
        try {
            userEntryService.saveAdmin(user);
            return new ResponseEntity<>(user, HttpStatus.OK) ;
        }
        catch(Exception e){
            return new ResponseEntity<>("Unable to add User",HttpStatus.BAD_REQUEST);
        }

    }
}
