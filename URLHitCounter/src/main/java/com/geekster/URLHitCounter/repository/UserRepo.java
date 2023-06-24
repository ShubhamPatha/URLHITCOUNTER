package com.geekster.URLHitCounter.repository;

import com.geekster.URLHitCounter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    Integer URLHITCount=0;
    public void updateHitCount() {
URLHITCount++;
    }
    public int printCount() {
        return URLHITCount;
    }

    @Autowired
    private List<User> userList;

    public List<User> getusers()
    {
        return userList;
    }



}
