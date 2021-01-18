package com.dqk.test.generator;

import java.io.Serializable;
import java.math.BigInteger;

public class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 新增时间 */
	protected String createDate;
	/** 更新时间 */
	protected String updateDate;
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public static final String sys0AddUser = "s0AddUsr";
	public static final String sys0UpdUser = "s0UpdUsr";
	public static final String sys0DelUser = "s0DelUsr";
	public static final String sys0DelState = "s0DelMark";

	protected BigInteger s0AddUsr;
	protected BigInteger s0UpdUsr;
	protected BigInteger s0DelUsr;
	protected String s0AddTime;
	protected String s0UpdTime;
	protected String s0DelTime;
	protected  Integer s0DelMark;


	public BigInteger getS0AddUsr() {
		return s0AddUsr;
	}

	public void setS0AddUsr(BigInteger s0AddUsr) {
		this.s0AddUsr = s0AddUsr;
	}

	public BigInteger getS0UpdUsr() {
		return s0UpdUsr;
	}

	public void setS0UpdUsr(BigInteger s0UpdUsr) {
		this.s0UpdUsr = s0UpdUsr;
	}

	public BigInteger getS0DelUsr() {
		return s0DelUsr;
	}

	public void setS0DelUsr(BigInteger s0DelUsr) {
		this.s0DelUsr = s0DelUsr;
	}

	public String getS0AddTime() {
		return s0AddTime;
	}

	public void setS0AddTime(String s0AddTime) {
		this.s0AddTime = s0AddTime;
	}

	public String getS0UpdTime() {
		return s0UpdTime;
	}

	public void setS0UpdTime(String s0UpdTime) {
		this.s0UpdTime = s0UpdTime;
	}

	public String getS0DelTime() {
		return s0DelTime;
	}

	public void setS0DelTime(String s0DelTime) {
		this.s0DelTime = s0DelTime;
	}

	public Integer getS0DelMark() {
		return s0DelMark;
	}

	public void setS0DelMark(Integer s0DelMark) {
		this.s0DelMark = s0DelMark;
	}

	public static class DeleteMark {
		public static final Integer weishanchu = 0;
		public static final Integer yishanchu = 1;
		private static final java.util.Map<Integer, String> MAP = new java.util.HashMap<Integer, String>();
		static {
			MAP.put(weishanchu, "未删除");
			MAP.put(yishanchu, "已删除");
		}
	}

	public static java.util.Map<Integer, String> getDeleteMark_MAP() {
		return DeleteMark.MAP;
	}

	public String getS0DelMark_DICT() {
		return DeleteMark.MAP.get(getS0DelMark());
	}

	public enum DeleteMarkEnum{
		weishanchu(0,"未删除"),
		yishanchu(1,"已删除"),
		;
		private java.lang.Integer value;
		private String desc;

		DeleteMarkEnum(java.lang.Integer value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public java.lang.Integer getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}

	}
}
