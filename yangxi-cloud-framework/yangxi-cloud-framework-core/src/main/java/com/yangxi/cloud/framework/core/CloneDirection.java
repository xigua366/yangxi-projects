package com.yangxi.cloud.framework.core;

/**
 * 克隆方向
 * @author yangxi
 *
 */
public enum CloneDirection {

	/**
	 * 正向克隆：从Request->DTO，DTO->DO
	 */
	FORWARD(1),
	/**
	 * 反向克隆：从DO->DTO，DTO->VO
	 */
	OPPOSITE(2);

	private Integer code;

	CloneDirection(Integer code){
		this.code = code;
	}
	
}