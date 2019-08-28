package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 职位类型
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public class Tb_position_type extends Model<Tb_position_type> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pt_id", type = IdType.AUTO)
    private Integer pt_id;
    /**
     * 职位名称
     */
    private String pt_name;
    /**
     * 添加时间
     */
    private Date pt_time;
    /**
     * 状态1使用，0不使用
     */
    private Integer pt_state;


    public Integer getPt_id() {
        return pt_id;
    }

    public void setPt_id(Integer pt_id) {
        this.pt_id = pt_id;
    }

    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public Date getPt_time() {
        return pt_time;
    }

    public void setPt_time(Date pt_time) {
        this.pt_time = pt_time;
    }

    public Integer getPt_state() {
        return pt_state;
    }

    public void setPt_state(Integer pt_state) {
        this.pt_state = pt_state;
    }

    @Override
    protected Serializable pkVal() {
        return this.pt_id;
    }

    @Override
    public String toString() {
        return "Tb_position_type{" +
        ", pt_id=" + pt_id +
        ", pt_name=" + pt_name +
        ", pt_time=" + pt_time +
        ", pt_state=" + pt_state +
        "}";
    }
}
