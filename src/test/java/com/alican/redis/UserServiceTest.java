package com.alican.redis;

import com.alican.redis.entity.User;
import com.alican.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void tryCacheableAnnotations() throws InterruptedException {
        User user = userService.findUserById(1);
        userService.findUserById(1);
        userService.findUserById(2);

        userService.updateUser(user);
        User updatedUser = userService.findUserById(1);

        assertNotEquals(user, updatedUser);

        userService.deleteUser(1);
        updatedUser = userService.findUserById(1);

        assertEquals(user.getName(), updatedUser.getName());
    }

}
