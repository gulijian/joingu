package com.gulj.app.blog.api.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    @Id
    private Integer sid;

    private String username;

    private String password;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "last_login")
    private String lastLogin;

    private String ip;

    /**
     * (1：账号被禁止，0：正常)
     */
    private String status;

    private String skin;

    /**
     * 性别(1.男，2.女)
     */
    private Byte sex;

    private String email;

    private String number;

    private String phone;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_delete")
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    /**
     * @return sid
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * @param sid
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * @return last_login
     */
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin
     */
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin == null ? null : lastLogin.trim();
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取(1：账号被禁止，0：正常)
     *
     * @return status - (1：账号被禁止，0：正常)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置(1：账号被禁止，0：正常)
     *
     * @param status (1：账号被禁止，0：正常)
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return skin
     */
    public String getSkin() {
        return skin;
    }

    /**
     * @param skin
     */
    public void setSkin(String skin) {
        this.skin = skin == null ? null : skin.trim();
    }

    /**
     * 获取性别(1.男，2.女)
     *
     * @return sex - 性别(1.男，2.女)
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别(1.男，2.女)
     *
     * @param sex 性别(1.男，2.女)
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return is_delete
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}