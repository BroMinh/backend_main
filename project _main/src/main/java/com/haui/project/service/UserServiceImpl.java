package com.haui.project.service;

import com.haui.project.entity.User;
import com.haui.project.exeption.NotFoundException;
import com.haui.project.model.dto.UserDto;
import com.haui.project.model.mapper.UserMapper;
import com.haui.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{
    private static ArrayList<User> users = new ArrayList<User>();
    @Autowired
    private UserRepository userRepository;

//    static{
//        users.add(new User(1L,"admin","picture1.jpg","admin@gmail.com","123456"));
//        users.add(new User(2L, "Hà Như Ý","picture2.jpg","nhuy@gmail.com","123456"));
//        users.add(new User(3L, "Nguyễn Văn Sang","picture3.jpg", "vansang@gmail.com","123456"));
//        users.add((new User(4L,"Phạm Thu Thủy","picture4.jpg", "thuthuy@gmail.com","123456")));
//    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        for(User user:userRepository.findAll()){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User không tồn tại trong hệ thống"));
        return UserMapper.toUserDto(user);
    }

    public String unAccent(String s){
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCOMBINING_DIACRITICAL_MARKS}");
        return pattern.matcher(temp).replaceAll("");
    }
    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for(User user:userRepository.findAll()){
            if(user.getUserName().toLowerCase().contains(keyword.toLowerCase())
                    || unAccent(user.getUserName()).toLowerCase().contains(unAccent(keyword.toLowerCase()))){
                result.add(UserMapper.toUserDto(user));
            }else {
                throw new NotFoundException("Không có user cần tìm kiếm!");
            }
        }
        return result;
    }

    @Override
    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    @Override
    public boolean deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new NotFoundException("User không tồn tại trong hệ thống");
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User updateUser(Long id, User upUser) {
        return userRepository.findById(id).map(user -> {
            user.setUserName(upUser.getUserName());
                user.setUserImage(upUser.getUserImage());
                user.setUserEmail(upUser.getUserEmail());
                user.setUserPass(upUser.getUserPass());
                return  userRepository.save(user);
        }).orElseThrow(() -> new NotFoundException("User không tồn tại trong hệ thống"));
    }
}
