package com.youfan.repository.controller;

import com.youfan.repository.vo.R;
import com.youfan.repository.domain.TbUser;
import com.youfan.repository.service.TbUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

    @Resource
    private TbUserService userService;

    @GetMapping("list")
    public R<List<TbUser>> list() {
        return R.ok(userService.list());
    }

    @PostMapping("saveOrUpdate")
    public R<Void> saveOrUpdate(@RequestBody TbUser user) {
        userService.saveOrUpdate(user);
        return R.ok();
    }

    @DeleteMapping("del/{id}")
    public R<Void> delUser(@PathVariable Integer id) {
        userService.removeById(id);
        return R.ok();
    }

    @PostMapping("login")
    public R<TbUser> login(@RequestBody TbUser loginUser, HttpSession session) {
        TbUser user = userService
                .query()
                .eq(TbUser.COL_USERNAME, loginUser.getUsername())
                .eq(TbUser.COL_PASSWORD, loginUser.getPassword())
                .one();
        if (Objects.nonNull(user)) {
            // 密码在传输过程中不公开
            user.setPassword("******");
            return R.ok(user);
        } else {
            return R.fail("用户名或密码错误，请重新登录！");
        }
    }

    @GetMapping("get/{id}")
    public R<TbUser> getUser(@PathVariable Integer id) {
        return R.ok(userService.getById(id));
    }

    @PostMapping("findPwd")
    public R<String> findPwd(@RequestBody TbUser user) {
        user = userService
                .query()
                .eq(TbUser.COL_USERNAME, user.getUsername())
                .eq(TbUser.COL_EMAIL, user.getEmail())
                .one();
        if (Objects.nonNull(user)) {
            return R.ok(user.getPassword());
        } else
            return R.fail("用户信息错误，找回密码失败！");
    }
}
