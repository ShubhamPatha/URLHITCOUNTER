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
