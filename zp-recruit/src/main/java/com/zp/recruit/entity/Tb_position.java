package com.zp.recruit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 职位
 * </p>
 *
 * @author Tz
 * @since 2019-09-02
 */
public class Tb_position extends Model<Tb_position> {

    private static final long serialVersionUID = 1L;

	@TableId(value="p_id", type= IdType.AUTO)
	private Integer p_id;
    /**
     * 职位名称
     */
	private String p_name;
    /**
     * 薪资空为面议
     */
	private String p_moneg;
    /**
     * 职位类型ID
     */
	private Integer pt_id;
    /**
     * 职位地点ID
     */
	private Integer w_id;
    /**
     * 职位描述
     */
	private String p_position_describe;
    /**
     * 发布时间
     */
	private Date p_time;
    /**
     * 职位状态1启用，0停用
     */
	private Integer p_state;
    /**
     * 职位图片
     */
	private String p_url;


	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_moneg() {
		return p_moneg;
	}

	public void setP_moneg(String p_moneg) {
		this.p_moneg = p_moneg;
	}

	public Integer getPt_id() {
		return pt_id;
	}

	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public String getP_position_describe() {
		return p_position_describe;
	}

	public void setP_position_describe(String p_position_describe) {
		this.p_position_describe = p_position_describe;
	}

	public Date getP_time() {
		return p_time;
	}

	public void setP_time(Date p_time) {
		this.p_time = p_time;
	}

	public Integer getP_state() {
		return p_state;
	}

	public void setP_state(Integer p_state) {
		this.p_state = p_state;
	}

	public String getP_url() {
		return p_url;
	}

	public void setP_url(String p_url) {
		this.p_url = p_url;
	}

	@Override
	protected Serializable pkVal() {
		return this.p_id;
	}

	@Override
	public String toString() {
		return "Tb_position{" +
			", p_id=" + p_id +
			", p_name=" + p_name +
			", p_moneg=" + p_moneg +
			", pt_id=" + pt_id +
			", w_id=" + w_id +
			", p_position_describe=" + p_position_describe +
			", p_time=" + p_time +
			", p_state=" + p_state +
			", p_url=" + p_url +
			"}";
	}
}
