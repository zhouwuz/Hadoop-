package com.example.vuesp.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vuesp.common.Constants;
import com.example.vuesp.common.Result;
import com.example.vuesp.controller.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.vuesp.service.IUserService;
import com.example.vuesp.entity.User;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周wz
 * @since 2022-06-07
 */
@RestController
@RequestMapping("/user")
public class UserController {

        @Resource
        private IUserService userService;

        //登录
        @PostMapping("/login")
        public Result login(@RequestBody UserDTO userDTO) {
                String username = userDTO.getUsername();
                String password = userDTO.getPassword();
                if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
                        return Result.error(Constants.CODE_400,"参数错误");
                }
                UserDTO dto = userService.login(userDTO);
                return Result.success(dto);
        }

        //注册
        @PostMapping("/register")
        public Result register(@RequestBody UserDTO userDTO) {
                String username = userDTO.getUsername();
                String password = userDTO.getPassword();
                String name= userDTO.getName();
                String number= userDTO.getNumber();
                String nickname = userDTO.getNickname();
                if (StrUtil.isBlank(username) || StrUtil.isBlank(password) ||StrUtil.isBlank(name)
                        ||StrUtil.isBlank(number)||StrUtil.isBlank(nickname)) {
                        return Result.error(Constants.CODE_400,"参数错误");
                }

                return Result.success(userService.register(userDTO));
        }

        // 新增或者更新
        @PostMapping
        public Result save(@RequestBody User user) {
                return Result.success(userService.saveOrUpdate(user));
                }

        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return userService.removeById(id);
                }

                //批量删除
//        @PostMapping("/del/batch")
//        public boolean deleteBatch(@RequestBody List<Integer> ids) {
//                return userService.removeByIds(ids);
//                }

        //查找所有
        @GetMapping
        public List<User> findAll() {
                return userService.list();
                }

        //查找一个
        @GetMapping("/{id}")
        public User findOne(@PathVariable Integer id) {
                return userService.getById(id);
                }

        //搜索并显示一页
        @GetMapping("/page")
        public Page<User> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String username) {

                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByDesc("id");
                if (!"".equals(username)) {
                        queryWrapper.like("name", username);
                }

                return userService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }

}

