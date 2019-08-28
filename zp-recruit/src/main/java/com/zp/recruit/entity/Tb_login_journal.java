package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 登录日志
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public class Tb_login_journal extends Model<Tb_login_journal> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "lj_id", type = IdType.AUTO)
    private Integer lj_id;
    /**
     * 登录时间
     */
    private Date lj_logintime;
    /**
     * 登录用户
     */
    private Integer u_id;


    public Integer getLj_id() {
        return lj_id;
    }

    public void setLj_id(Integer lj_id) {
        this.lj_id = lj_id;
    }

    public Date getLj_logintime() {
        return lj_logintime;
    }

    public void setLj_logintime(Date lj_logintime) {
        this.lj_logintime = lj_logintime;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.lj_id;
    }

    @Override
    public String toString() {
        return "Tb_login_journal{" +
        ", lj_id=" + lj_id +
        ", lj_logintime=" + lj_logintime +
        ", u_id=" + u_id +
        "}";
    }
}
