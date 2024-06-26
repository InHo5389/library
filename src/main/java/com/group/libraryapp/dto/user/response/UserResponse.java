package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.Person;

public class UserResponse {
    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }



    public UserResponse(long id, Person user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }
    public UserResponse( Person user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
