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
 * @since 2019-08-28
 */
public class AllPosition extends Model<AllPosition> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "p_id", type = IdType.AUTO)
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
    /**
     * 职位图片
     */
	private String p_url;
    public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
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
	public String toString() {
		return "AllPosition [p_id=" + p_id + ", p_name=" + p_name + ", p_moneg=" + p_moneg + ", pt_id=" + pt_id
				+ ", w_id=" + w_id + ", p_position_describe=" + p_position_describe + ", p_time=" + p_time
				+ ", p_state=" + p_state + ", pt_name=" + pt_name + ", pt_time=" + pt_time + ", pt_state=" + pt_state
				+ ", p_url=" + p_url + ", w_name=" + w_name + ", w_time=" + w_time + ", w_state=" + w_state + "]";
	}
	@Override
	protected Serializable pkVal() {
		return this.p_id;
	}

   
}
