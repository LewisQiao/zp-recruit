package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 招聘类型管理
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public class Tb_recruit_type extends Model<Tb_recruit_type> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer r_id;
    /**
     * 类型名称
     */
    private String r_name;
    /**
     * 添加时间
     */
    private Date r_time;
    /**
     * 1使用，0不使用
     */
    private Integer r_state;


    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    public Integer getR_state() {
        return r_state;
    }

    public void setR_state(Integer r_state) {
        this.r_state = r_state;
    }

    @Override
    protected Serializable pkVal() {
        return this.r_id;
    }

    @Override
    public String toString() {
        return "Tb_recruit_type{" +
        ", r_id=" + r_id +
        ", r_name=" + r_name +
        ", r_time=" + r_time +
        ", r_state=" + r_state +
        "}";
    }
}
