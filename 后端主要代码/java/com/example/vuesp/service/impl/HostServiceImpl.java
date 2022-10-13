package com.example.vuesp.service.impl;

import com.example.vuesp.entity.Host;
import com.example.vuesp.mapper.HostMapper;
import com.example.vuesp.service.IHostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 周wz
 * @since 2022-06-08
 */
@Service
public class HostServiceImpl extends ServiceImpl<HostMapper, Host> implements IHostService {

}
