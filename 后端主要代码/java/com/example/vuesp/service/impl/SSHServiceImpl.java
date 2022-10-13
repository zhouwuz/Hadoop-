package com.example.vuesp.service.impl;



import java.io.IOException;
import java.io.InputStream;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import com.example.vuesp.service.SSHService;
import com.example.vuesp.entity.SSHEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author bq8023
 * @Date 21/5/9 19:57
 * @Version 1.0
 */
@Service
public class SSHServiceImpl implements SSHService {
    private Connection connect;


    @Resource(name = "ssh1")
    private SSHEntity sshEntity;
    /**
     * 连接服务器并 执行shell脚本
     *
     * @param sshEntity ssh连接信息
     * @param shell     shell语句
     * @return shell执行结果
     * @throws IOException 读写异常
     */
    @Override
    public StringBuilder exec(SSHEntity sshEntity, String shell) throws IOException {
        InputStream inputStream = null;
        StringBuilder result = new StringBuilder();
        try {
            // 认证登录信息
            if (this.login(sshEntity)) {
                // 登陆成功则打开一个会话
                Session session = connect.openSession();
                session.execCommand(shell);
                inputStream = session.getStdout();
                result = this.processStdout(inputStream);
                connect.close();
            }
        } finally {
            if (null != inputStream) {
                inputStream.close();
            }
        }
        return result;
    }

    private boolean login(SSHEntity sshEntity) {
        connect = new Connection(sshEntity.getHost(), sshEntity.getPort());
        try {
            connect.connect();
            return connect.authenticateWithPassword(sshEntity.getUser(), sshEntity.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private StringBuilder processStdout(InputStream in) {
        byte[] buf = new byte[1024];
        StringBuilder builder = new StringBuilder();
        try {
            int length;
            while ((length = in.read(buf)) != -1) {
                builder.append(new String(buf, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    @Override
    public StringBuilder pass() throws IOException {
        return this.exec(sshEntity, "/root/home/key.sh");
    }
    @Override
    public StringBuilder jdk() throws IOException {
        return this.exec(sshEntity, "/root/home/jdk.sh");
    }


    @Override
    public StringBuilder hadoop() throws IOException {
        return this.exec(sshEntity, "/home/xaingmu/1.had/3hadoop.sh");
    }
    @Override
    public StringBuilder zookeeper() throws IOException {
        return this.exec(sshEntity, "/usr/bin/zkstart.sh");
    }
    @Override
    public StringBuilder kafka() throws IOException {
        return this.exec(sshEntity, "/usr/bin/start-kafka-cluster.sh");
    }

    @Override
    public StringBuilder zy() throws IOException {
        return this.exec(sshEntity, "/root/home/apache-zookeeper-3.6.0-bin/bin/status-zkall.sh");
    }
    @Override
    public StringBuilder jps() throws IOException {
        return this.exec(sshEntity, "/root/home/jdk.sh");
    }
}
