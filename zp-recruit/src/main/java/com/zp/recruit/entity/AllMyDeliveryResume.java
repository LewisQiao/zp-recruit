package com.zp.recruit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;

public class AllMyDeliveryResume extends Model<AllMyDeliveryResume>{
	
	private static final long serialVersionUID = 1L;

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
    
    private Integer r_id;
    /**
     * 名称
     */
	private String r_name;
    /**
     * 年龄
     */
	private Integer r_age;
    /**
     * 1.男。0女
     */
	private Integer r_sex;
    /**
     * 我的电话
     */
	private Integer m_myphone;
    /**
     * 经验时长
     */
	private BigDecimal r_experience_duration;
    /**
     * 学历
     */
	private String r_education;
    /**
     * 自我评价
     */
	private String r_self_evaluation;
    /**
     * 求职期望（期望职位）
     */
	private String r_job_wanted;
    /**
     * 工作经历
     */
	private String r_work_history;
    /**
     * 教育经历（毕业学校）
     */
	private String r_high_school;

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


	public Integer getR_age() {
		return r_age;
	}


	public void setR_age(Integer r_age) {
		this.r_age = r_age;
	}


	public Integer getR_sex() {
		return r_sex;
	}


	public void setR_sex(Integer r_sex) {
		this.r_sex = r_sex;
	}


	public Integer getM_myphone() {
		return m_myphone;
	}


	public void setM_myphone(Integer m_myphone) {
		this.m_myphone = m_myphone;
	}


	public BigDecimal getR_experience_duration() {
		return r_experience_duration;
	}


	public void setR_experience_duration(BigDecimal r_experience_duration) {
		this.r_experience_duration = r_experience_duration;
	}


	public String getR_education() {
		return r_education;
	}


	public void setR_education(String r_education) {
		this.r_education = r_education;
	}


	public String getR_self_evaluation() {
		return r_self_evaluation;
	}


	public void setR_self_evaluation(String r_self_evaluation) {
		this.r_self_evaluation = r_self_evaluation;
	}


	public String getR_job_wanted() {
		return r_job_wanted;
	}


	public void setR_job_wanted(String r_job_wanted) {
		this.r_job_wanted = r_job_wanted;
	}


	public String getR_work_history() {
		return r_work_history;
	}


	public void setR_work_history(String r_work_history) {
		this.r_work_history = r_work_history;
	}


	public String getR_high_school() {
		return r_high_school;
	}


	public void setR_high_school(String r_high_school) {
		this.r_high_school = r_high_school;
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


	@Override
	protected Serializable pkVal() {
		  return this.m_id;
	}


	@Override
	public String toString() {
		return "AllMyDeliveryResume [d_id=" + d_id + ", u_id=" + u_id + ", m_id=" + m_id + ", d_time=" + d_time
				+ ", p_id=" + p_id + ", d_state=" + d_state + ", r_id=" + r_id + ", r_name=" + r_name + ", r_age="
				+ r_age + ", r_sex=" + r_sex + ", m_myphone=" + m_myphone + ", r_experience_duration="
				+ r_experience_duration + ", r_education=" + r_education + ", r_self_evaluation=" + r_self_evaluation
				+ ", r_job_wanted=" + r_job_wanted + ", r_work_history=" + r_work_history + ", r_high_school="
				+ r_high_school + ", p_name=" + p_name + ", p_moneg=" + p_moneg + ", pt_id=" + pt_id + ", w_id=" + w_id
				+ ", p_position_describe=" + p_position_describe + ", p_time=" + p_time + ", p_state=" + p_state + "]";
	}

}
