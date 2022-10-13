package com.example.vuesp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author 周wz
 * @since 2022-06-08
 */
@Getter
@Setter
  @TableName("sys_host")
@ApiModel(value = "Host对象", description = "")
public class Host implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("序号")
        private Integer id;

      @ApiModelProperty("主机名")
      private String hostname;

      @ApiModelProperty("IP")
      private String ip;

      @ApiModelProperty("节点")
      private String role;

      @ApiModelProperty("主机密码")
      private String password;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Host{" +
            "id=" + id +
            ", hostname='" + hostname + '\'' +
            ", ip='" + ip + '\'' +
            ", role='" + role + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
