package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 用户投递简历表
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public class Tb_delivery_resume extends Model<Tb_delivery_resume> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer d_id;
    /**
     * 用户ID
     */
    private Integer u_id;
    /**
     * 微简历ID
     */
    private Integer m_id;
    /**
     * 投递时间
     */
    private Date d_time;
    /**
     * 职位ID
     */
    private Integer p_id;
    /**
     * 状态0投递成功，1被查看,2邀面试
     */
    private Integer d_state;


    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Date getD_time() {
        return d_time;
    }

    public void setD_time(Date d_time) {
        this.d_time = d_time;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getD_state() {
        return d_state;
    }

    public void setD_state(Integer d_state) {
        this.d_state = d_state;
    }

    @Override
    protected Serializable pkVal() {
        return this.d_id;
    }

    @Override
    public String toString() {
        return "Tb_delivery_resume{" +
        ", d_id=" + d_id +
        ", u_id=" + u_id +
        ", m_id=" + m_id +
        ", d_time=" + d_time +
        ", p_id=" + p_id +
        ", d_state=" + d_state +
        "}";
    }
}
