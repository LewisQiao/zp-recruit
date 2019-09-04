package com.zp.recruit.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 简历表
 * </p>
 *
 * @author Tz
 * @since 2019-09-02
 */
public class Tb_resume extends Model<Tb_resume> {

    private static final long serialVersionUID = 1L;

	@TableId(value="r_id", type= IdType.AUTO)
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
     * 用户ID
     */
	private Integer u_id;


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

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	@Override
	protected Serializable pkVal() {
		return this.r_id;
	}

	@Override
	public String toString() {
		return "Tb_resume{" +
			", r_id=" + r_id +
			", r_name=" + r_name +
			", r_age=" + r_age +
			", r_sex=" + r_sex +
			", m_myphone=" + m_myphone +
			", r_experience_duration=" + r_experience_duration +
			", r_education=" + r_education +
			", r_self_evaluation=" + r_self_evaluation +
			", r_job_wanted=" + r_job_wanted +
			", r_work_history=" + r_work_history +
			", r_high_school=" + r_high_school +
			", u_id=" + u_id +
			"}";
	}
}
