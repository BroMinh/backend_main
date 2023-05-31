package com.haui.project.model.mapper;

import com.haui.project.entity.User;
import com.haui.project.model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setUser_id(user.getUserId());
        tmp.setUser_name(user.getUserName());
        tmp.setUser_image(user.getUserImage());
        tmp.setUser_email(user.getUserEmail());

        return tmp;
    }

}
