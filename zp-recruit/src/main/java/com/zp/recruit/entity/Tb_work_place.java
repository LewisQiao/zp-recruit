package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 工作地点管理
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public class Tb_work_place extends Model<Tb_work_place> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "w_id", type = IdType.AUTO)
    private Integer w_id;
    /**
     * 名称
     */
    private String w_name;
    /**
     * 添加时间
     */
    private Date w_time;
    /**
     * 1启用，0不启用
     */
    private Integer w_state;


    public Integer getW_id() {
        return w_id;
    }

    public void setW_id(Integer w_id) {
        this.w_id = w_id;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public Date getW_time() {
        return w_time;
    }

    public void setW_time(Date w_time) {
        this.w_time = w_time;
    }

    public Integer getW_state() {
        return w_state;
    }

    public void setW_state(Integer w_state) {
        this.w_state = w_state;
    }

    @Override
    protected Serializable pkVal() {
        return this.w_id;
    }

    @Override
    public String toString() {
        return "Tb_work_place{" +
        ", w_id=" + w_id +
        ", w_name=" + w_name +
        ", w_time=" + w_time +
        ", w_state=" + w_state +
        "}";
    }
}
