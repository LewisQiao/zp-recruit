package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class Loginjournal extends Model<Loginjournal>{

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

    private Date time;
    public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

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
		return "Loginjournal [lj_id=" + lj_id + ", lj_logintime=" + lj_logintime + ", u_id=" + u_id + ", time=" + time
				+ "]";
	}
}
