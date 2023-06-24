package com.geekster.URLHitCounter.beanManager;

import com.geekster.URLHitCounter.model.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class beanManager {

    @Bean
    List<User> getInitialisedList()
    {
        User inituser=new User("Shubham",0);

        List<User>initList=new ArrayList<>();
        initList.add(inituser);
        return initList;

    }



}
