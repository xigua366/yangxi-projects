package com.yangxi.cloud.framework.web.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangxi.cloud.framework.core.ObjectMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * json对象转换工具
 *
 * @author yangxi
 */
@Slf4j
public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapperImpl();

	/**
	 * 单个对象转json字符串
	 * @param o
	 * @return
	 */
	public static String object2Json(Object o) {
		if (o == null) {
			return null;
		}

		String s = null;
		try {
			s = mapper.writeValueAsString(o);
		} catch (Exception e) {
			log.error("object to json error", e);
		}
		return s;
	}

	/**
	 * 集合对象批量转json字符串集合
	 * @param objects
	 * @param <T>
	 * @return
	 */
	public static <T> List<String> listObject2ListJson(List<T> objects) {
		if (objects == null) {
			return null;
		}

		List<String> lists = new ArrayList<String>();
		for (T t : objects) {
			lists.add(object2Json(t));
		}

		return lists;
	}

	/**
	 * json字符串集合批量转对象集合
	 * @param jsons
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> listJson2ListObject(List<String> jsons, Class<T> clazz) {
		if (jsons == null) {
			return null;
		}

		List<T> ts = new ArrayList<T>();
		for (String j : jsons) {
			ts.add(json2Object(j, clazz));
		}

		return ts;
	}

	/**
	 * json字符串转指定类型的对象
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T json2Object(String json, Class<T> clazz) {
		if (!StringUtils.hasLength(json)) {
			return null;
		}

		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			log.error("json to object error", e);
		}
		return null;
	}

	/**
	 * json字符串转指定类型的对象
	 * @param json
	 * @param typeReference
	 * @param <T>
	 * @return
	 */
	public static <T> T json2Object(String json, TypeReference<T> typeReference) {
		if (!StringUtils.hasLength(json)) {
			return null;
		}
		try {
			return mapper.readValue(json, typeReference);
		} catch (Exception e) {
			log.error("json to object error", e);
		}
		return null;
	}
}
