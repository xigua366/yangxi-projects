package com.yangxi.cloud.framework.core;

/**
 * <P>
 * 克隆方向枚举
 * </P>
 *
 * @author yangxi
 * @version 1.0
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