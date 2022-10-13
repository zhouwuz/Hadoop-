package com.example.vuesp.entity;

import lombok.Data;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author bq8023
 * @Date 21/5/9 19:36
 * @Version 1.0
 */
@Data
public class SSHEntity {
    /**
     * 编码
     */
    private Charset charset = StandardCharsets.UTF_8;
    /**
     * 主机（IP）
     */
    private String host;
    /**
     * 连接端口
     */
    private int port;
    /**
     * 账号
     */
    private String user;
    /**
     * 密码
     */
    private String password;

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SSHEntity{" +
                "charset=" + charset +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
