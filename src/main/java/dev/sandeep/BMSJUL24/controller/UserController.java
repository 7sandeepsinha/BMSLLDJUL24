package dev.sandeep.BMSJUL24.controller;

import dev.sandeep.BMSJUL24.dto.UserLoginRespDTO;
import dev.sandeep.BMSJUL24.dto.UserSignUpReqDTO;
import dev.sandeep.BMSJUL24.mapper.UserMapperUtil;
import dev.sandeep.BMSJUL24.model.User;
import dev.sandeep.BMSJUL24.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserSignUpReqDTO userReqDTO) {
        // User savedUser = userService.createUser(userReqDTO);  // cant pass DTO directly here
        // return savedUser; // cant return the model directly
        // we need something that converts -> DTO to MODEL || MODEL -> DTO
        User user = UserMapperUtil.dtoToModel(userReqDTO);
        User savedUser = userService.createUser(user);
        UserLoginRespDTO respDTO = UserMapperUtil.modelToDto(savedUser);
        return ResponseEntity.ok(respDTO);
    }
}
