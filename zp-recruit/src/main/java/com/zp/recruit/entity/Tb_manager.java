package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public class Tb_manager extends Model<Tb_manager> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer m_id;
    /**
     * 账号 
     */
    private String m_username;
    /**
     * 密码
     */
    private String m_password;
    /**
     * 登录次数 
     */
    private Integer m_login_count;
    /**
     * 登录时间 
     */
    private Date m_login_time;


    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_username() {
        return m_username;
    }

    public void setM_username(String m_username) {
        this.m_username = m_username;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    public Integer getM_login_count() {
        return m_login_count;
    }

    public void setM_login_count(Integer m_login_count) {
        this.m_login_count = m_login_count;
    }

    public Date getM_login_time() {
        return m_login_time;
    }

    public void setM_login_time(Date m_login_time) {
        this.m_login_time = m_login_time;
    }

    @Override
    protected Serializable pkVal() {
        return this.m_id;
    }

    @Override
    public String toString() {
        return "Tb_manager{" +
        ", m_id=" + m_id +
        ", m_username=" + m_username +
        ", m_password=" + m_password +
        ", m_login_count=" + m_login_count +
        ", m_login_time=" + m_login_time +
        "}";
    }
}
