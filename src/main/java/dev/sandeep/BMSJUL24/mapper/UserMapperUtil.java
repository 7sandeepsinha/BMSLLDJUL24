package dev.sandeep.BMSJUL24.mapper;

import dev.sandeep.BMSJUL24.dto.UserLoginRespDTO;
import dev.sandeep.BMSJUL24.dto.UserSignUpReqDTO;
import dev.sandeep.BMSJUL24.model.User;

public class UserMapperUtil {

    public static User dtoToModel(UserSignUpReqDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserLoginRespDTO modelToDto(User user){
        UserLoginRespDTO dto = new UserLoginRespDTO();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }
}
