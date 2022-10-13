package com.example.vuesp.service;

import com.example.vuesp.controller.dto.UserDTO;
import com.example.vuesp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周wz
 * @since 2022-06-07
 */

public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
