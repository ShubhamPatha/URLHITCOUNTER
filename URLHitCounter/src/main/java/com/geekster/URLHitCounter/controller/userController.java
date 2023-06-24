package com.geekster.URLHitCounter.controller;

import com.geekster.URLHitCounter.model.User;
import com.geekster.URLHitCounter.service.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class userController {
    @Autowired
    userService userService;


@GetMapping("api/v1/visitor-count-app/username")
    List<User> getAlluser()
    {
        return userService.getAllUsers();

    }

@PostMapping("api/v1/visitor-count-app/add")

   public String adduserName(@Valid @RequestBody User users)
{
    return userService.createUserName(users);
}






    @GetMapping("api/v1/visitor-count-app/username/{userName}/count")
    Integer getuserCount(@Valid @PathVariable String userName)
    {

        return userService.getUserCount(userName);

    }
    @GetMapping("count")
    Integer gettotalCount()
    {
        return userService.gettotalCount();

    }









}
