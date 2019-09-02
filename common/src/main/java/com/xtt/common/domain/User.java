package com.xtt.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xuett
 * @Date 2019/9/2 10:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;
    private Integer age;




    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
