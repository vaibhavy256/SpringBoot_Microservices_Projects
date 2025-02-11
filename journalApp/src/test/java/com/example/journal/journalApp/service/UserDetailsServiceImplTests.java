package com.example.journal.journalApp.service;

import com.example.journal.journalApp.entity.User;
import com.example.journal.journalApp.repository.UserEntryRepository;
import com.mongodb.assertions.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.mockito.Mockito.when;

public class UserDetailsServiceImplTests {
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserEntryRepository userEntryRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadByUsernameTest(){
        when(userEntryRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("vaibhav").password("sdhfusdfjsf").roles(Collections.singletonList("USER")).build());
        UserDetails user=userDetailsService.loadUserByUsername("vaibhav");
        Assertions.assertNotNull(user);
    }
}
