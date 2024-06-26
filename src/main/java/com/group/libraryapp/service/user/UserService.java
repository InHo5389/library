package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.Person;
import com.group.libraryapp.domain.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        Person user = userRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException());

        user.updateName(request.getName());
    }

    @Transactional
    public void deleteUser(String name){
        Person user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }

    @Transactional
    public void saveUser(UserCreateRequest request){
        userRepository.save(new Person(request.getName(), request.getAge()));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }
}
