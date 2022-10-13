package com.example.vuesp.config;


import com.example.vuesp.entity.SSHEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置各服务器ssh连接信息
 *
 * @Author bq8023
 * @Date 21/5/9 20:44
 * @Version 1.0
 */

@Configuration
public class SSHConfig {

    @Bean(name = "ssh1")
    @ConfigurationProperties(prefix = "ssh1")
    public SSHEntity sshEntity3() {
        return new SSHEntity();
    }

    @Bean(name = "ssh2")
    @ConfigurationProperties(prefix = "ssh2")
    public SSHEntity sshEntity4() {
        return new SSHEntity();
    }

}
