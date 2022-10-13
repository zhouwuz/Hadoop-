package com.example.vuesp.service;


import com.example.vuesp.entity.SSHEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author bq8023
 * @Date 21/5/9 19:56
 * @Version 1.0
 */
@Service
public interface SSHService {
    /**
     * 连接服务器并 执行shell脚本
     *
     * @param sshEntity ssh连接信息
     * @param shell     shell语句
     * @return shell执行结果
     * @throws IOException 读写异常
     */
    StringBuilder exec(SSHEntity sshEntity, String shell) throws IOException;
    StringBuilder pass() throws IOException;
    StringBuilder jdk() throws IOException;
    StringBuilder hadoop() throws IOException;
    StringBuilder zookeeper() throws IOException;
    StringBuilder zy() throws IOException;
    StringBuilder kafka() throws IOException;
    StringBuilder jps() throws IOException;

}
