package com.geekster.URLHitCounter.service;

import com.geekster.URLHitCounter.model.User;
import com.geekster.URLHitCounter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    UserRepo UserRepo;



    public List<User> getAllUsers()
    {
        UserRepo.updateHitCount();

return UserRepo.getusers();
    }

    public String createUserName(User users) {
        UserRepo.updateHitCount();
List<User> originalList=getAllUsers();


originalList.add(users);
        UserRepo.updateHitCount();

return "NEW USER ADDED";
    }

    public Integer getUserCount(String userName) {
        UserRepo.updateHitCount();
        List<User> originalList=getAllUsers();
        int k=0;
        for(User user1: originalList)
        {
            if(user1.getUserName().equals(userName))
            {


                k= user1.getUserCount();
                 user1.setUserCount(k+1);


            }

        }

        return k;
    }

    public Integer gettotalCount() {
        UserRepo.updateHitCount();
        return  UserRepo.printCount();

    }
}
