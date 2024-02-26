package com.user.service.controller;

import com.user.service.dto.UserInfo;
import com.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public List<UserInfo> create(@RequestBody List<UserInfo> userInfos) {
        return null;
    }

    @GetMapping("/users")
    public List<UserInfo> getUsers(@RequestParam("ids") List<String> ids) {
        return userService.getUsers(ids);
    }

}
