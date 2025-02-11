package com.example.journal.journalApp.service;

import com.example.journal.journalApp.repository.UserEntryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserEntryRepository userEntryRepository;

    @Test
    public void testFindByUsername(){
        assertNotNull(userEntryRepository.findByUserName("vaibhavy"));
    }
}
