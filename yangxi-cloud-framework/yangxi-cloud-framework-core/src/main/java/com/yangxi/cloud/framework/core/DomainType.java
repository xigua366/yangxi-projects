package com.yangxi.cloud.framework.core;

/**
 * <p>
 * 领域模型对象的类型
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class DomainType {

	/**
	 * 请求入参对象
	 */
	public static final String REQUEST = "Request";
	/**
	 * 查询参数对象
	 */
	public static final String QUERY = "Query";
	/**
	 * VO：Value Object
	 */
	public static final String VO = "VO";
	/**
	 * DTO：Data Transfer Object
	 */
	public static final String DTO = "DTO";
	/**
	 * DO：Data Object
	 */
	public static final String DO = "DO";
	
	private DomainType() {
		
	}
	
}