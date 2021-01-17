package com.dqk.test.generator;

import java.io.Serializable;

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
}
