package com.ccqstark.small.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccqstark.small.common.CommonResult;
import com.ccqstark.small.dto.LoginParam;
import com.ccqstark.small.dto.RegisterParam;
import com.ccqstark.small.model.User;
import com.ccqstark.small.service.Impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.tools.java.CompilerError;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public CommonResult<User> Login(@RequestBody LoginParam loginParam, HttpSession session) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginParam.getUsername())
                .eq("password", loginParam.getPassword());

        User user = userService.getOne(queryWrapper);

        if (user != null) {
            // session生存时间设置为24小时
            session.setMaxInactiveInterval(24 * 3600);
            session.setAttribute("user", user);
            // 登录成功，返回user_id
            user.setPassword(null);
            return CommonResult.success(user);
        }

        return CommonResult.failed("用户名或密码不正确");
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public CommonResult<String> register(@RequestBody RegisterParam registerParam) {

        if (!registerParam.getPassword().equals(registerParam.getRe_password())) {
            return CommonResult.failed("两次密码不一致");
        }

        User newUser = new User(0, registerParam.getUsername(), registerParam.getPassword(), registerParam.getRole());
        userService.save(newUser);

        return CommonResult.success("注册成功");
    }


    @ApiOperation("登出")
    @PostMapping("/logout")
    public CommonResult<String> logout(HttpSession session) {
        session.invalidate();
        return CommonResult.success("登出成功");
    }


    @ApiOperation("测试session是否存在")
    @GetMapping("/test_session")
    public boolean test(HttpSession session) {
        return session.isNew();
    }


}
