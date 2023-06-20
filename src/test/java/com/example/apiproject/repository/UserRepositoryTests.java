package com.example.apiproject.repository;

import com.example.delombok.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Slf4j
public class UserRepositoryTests {

    private com.example.delombok.repository.UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testFindAll() {
        log.info(Arrays.toString(userRepository.findAll().toArray()));
    }
}
