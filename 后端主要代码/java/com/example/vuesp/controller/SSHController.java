package com.example.vuesp.controller;

import com.example.vuesp.common.Result;
import com.example.vuesp.service.SSHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class SSHController {


    @Qualifier("SSHServiceImpl")
    @Autowired
    public SSHService sshService;

    @RequestMapping("/pass")
    @ResponseBody
    public Result pass() throws IOException {
        System.out.println("内容:" + sshService.pass());
        return Result.success(sshService.pass());
    }

    @RequestMapping("/jdk")
    @ResponseBody
    public Result jdk() throws IOException {
        System.out.println("内容:" + sshService.jdk());
        return Result.success(sshService.jdk());
    }

    @RequestMapping("/hadoop")
    @ResponseBody
    public Result hadoop() throws IOException {
        System.out.println("内容:" + sshService.hadoop());
        return Result.success(sshService.hadoop());
    }
    @RequestMapping("/zookeeper")
    @ResponseBody
    public Result zookeeper() throws IOException {
        System.out.println("内容:" + sshService.zookeeper());
        return Result.success(sshService.zookeeper());
    }

    @RequestMapping("/zy")
    @ResponseBody
    public Result zy() throws IOException {
        System.out.println("内容:" + sshService.zy());
        return Result.success(sshService.zy());
    }
    @RequestMapping("/kafka")
    @ResponseBody
    public Result kafka() throws IOException {
        System.out.println("内容:" + sshService.kafka());
        return Result.success(sshService.kafka());
    }
    @RequestMapping("/jps")
    @ResponseBody
    public Result jps() throws IOException {

        System.out.println("内容:" + sshService.jps());
        return Result.success(sshService.jps());
    }
}
