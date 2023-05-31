package com.haui.project.service;

//import com.haui.project.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//}
import com.haui.project.entity.User;
import com.haui.project.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();
    public UserDto getUserById(Long id);
    public List<UserDto> searchUser(String keyword);
    public User createUser(User newUser);
    public boolean deleteUser(Long id);
    public User updateUser(Long id, User upUser);

}