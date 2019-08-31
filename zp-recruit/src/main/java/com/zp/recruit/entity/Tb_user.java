package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Tz
 * @since 2019-08-30
 */
public class Tb_user extends Model<Tb_user> {

    private static final long serialVersionUID = 1L;

	@TableId(value="u_id", type= IdType.AUTO)
	private Integer u_id;
    /**
     *  用户名
     */
	private String u_name;
    /**
     * 用户头像
     */
	private String u_photo;
    /**
     * 用户唯一标识
     */
	private String u_open_id;
    /**
     * 登录时间
     */
	private Date u_login_time;
    /**
     * 1正常,0禁止使用
     */
	private Integer u_state;


	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_photo() {
		return u_photo;
	}

	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}

	public String getU_open_id() {
		return u_open_id;
	}

	public void setU_open_id(String u_open_id) {
		this.u_open_id = u_open_id;
	}

	public Date getU_login_time() {
		return u_login_time;
	}

	public void setU_login_time(Date u_login_time) {
		this.u_login_time = u_login_time;
	}

	public Integer getU_state() {
		return u_state;
	}

	public void setU_state(Integer u_state) {
		this.u_state = u_state;
	}

	@Override
	protected Serializable pkVal() {
		return this.u_id;
	}

	@Override
	public String toString() {
		return "Tb_user{" +
			", u_id=" + u_id +
			", u_name=" + u_name +
			", u_photo=" + u_photo +
			", u_open_id=" + u_open_id +
			", u_login_time=" + u_login_time +
			", u_state=" + u_state +
			"}";
	}
}
