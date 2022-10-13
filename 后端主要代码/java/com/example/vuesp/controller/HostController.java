package com.example.vuesp.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vuesp.common.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.example.vuesp.service.IHostService;
import com.example.vuesp.entity.Host;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周wz
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/host")
public class HostController {

    @Resource
    private IHostService hostService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Host host) {
        hostService.saveOrUpdate(host);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        hostService.removeById(id);
        return Result.success();
    }

//    @PostMapping("/del/batch")
//    public Result deleteBatch(@RequestBody List<Integer> ids) {
//        hostService.removeByIds(ids);
//        return Result.success();
//    }

    @GetMapping
    public Result findAll() {
        return Result.success(hostService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(hostService.getById(id));
    }

    @GetMapping("/page")
    public Page<Host> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String hostname) {

        QueryWrapper<Host> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (!"".equals(hostname)) {
            queryWrapper.like("hostname", hostname);
        }

        return hostService.page(new Page<>(pageNum,pageSize),queryWrapper);
    }

}

