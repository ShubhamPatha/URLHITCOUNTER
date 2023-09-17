# URLHITCOUNTER

## FRAMEWORK AND LANGUAGE USED
* JAVA 17
* MAVEN
* SPRINGBOOT 3.1.1
<!-- Headings -->   
## DATA FLOW



  ### CONFIGURATION
  ```
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
```


 ### CONTROLLER
  ``` 
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
```


 ### MODEL
  ``` 

package com.geekster.URLHitCounter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


    private String userName;
    private Integer userCount;
}
```

### REPO
  ``` 
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

```


### SERVICE
  ``` 

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



```


### MAIN
  ``` 

package com.geekster.URLHitCounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlHitCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlHitCounterApplication.class, args);
	}

}
```


 ### POM
  ```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.geekster</groupId>
	<artifactId>URLHitCounter</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>URLHitCounter</name>
	<description>demo for url counter</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```
## DATA STRUCTURE USED
* LIST 
* STRING
* LOCAL DATE
* INTEGER
* USER

# PROJECT SUMMARY

## Restaurant Management System Has been created with the following attribute
URL Hit counter , It is counting the number of time URL being hit

<!-- Headings -->   
# Author
SHUBHAM PATHAK
 <!-- UL -->
* Twitter <!-- Links -->
[@ShubhamPathak]( https://twitter.com/Shubham15022000)
* Github  <!-- Links -->
[@ShubhamPathak]( https://github.com/ShubhamPatha)
<!-- Headings -->   
