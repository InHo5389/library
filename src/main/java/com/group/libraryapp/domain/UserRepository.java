package com.group.libraryapp.domain;

import com.group.libraryapp.domain.user.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Person,Long> {

    Optional<Person> findByName(String name);

}
