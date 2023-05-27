package com.example.apiproject.initializer;

import com.example.apiproject.access.User;
import com.example.apiproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 数据库初始化
 */
@Component
public class DataSourceInitializer implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(User.builder().name("user").password("61259cdf-9cb1-4981-b926-35ebe0906c29").build());
        userRepository.save(User.builder().name("user1").password("123").build());
    }
}

