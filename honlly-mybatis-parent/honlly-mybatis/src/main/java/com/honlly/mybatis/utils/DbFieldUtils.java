package com.honlly.mybatis.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DbFieldUtils {
	/** 字段类型映射 */
	private static final Map<Integer, Class<? extends Serializable>> fieldTypeMapping;
	/** JAVA类型映射 */
	private static final Map<Class<? extends Serializable>, Integer> fieldClassMapping;
	static {
		Map<Integer, Class<? extends Serializable>> typeMap = new HashMap<Integer, Class<? extends Serializable>>();
		typeMap.put(Types.CHAR, String.class);
		typeMap.put(Types.VARCHAR, String.class);
		typeMap.put(Types.LONGVARCHAR, String.class);
		typeMap.put(Types.NUMERIC, BigDecimal.class);
		typeMap.put(Types.DECIMAL, BigDecimal.class);
		typeMap.put(Types.BIT, Boolean.class);
		typeMap.put(Types.TINYINT, Integer.class);
		typeMap.put(Types.SMALLINT, Integer.class);
		typeMap.put(Types.INTEGER, Integer.class);
		typeMap.put(Types.BIGINT, Long.class);
		typeMap.put(Types.REAL, Float.class);
		typeMap.put(Types.FLOAT, Double.class);
		typeMap.put(Types.DOUBLE, Double.class);
		typeMap.put(Types.DATE, Date.class);
		typeMap.put(Types.TIME, Date.class);
		typeMap.put(Types.TIMESTAMP, Date.class);
		typeMap.put(Types.BINARY, byte[].class);
		typeMap.put(Types.VARBINARY, byte[].class);
		typeMap.put(Types.LONGVARBINARY, byte[].class);
		typeMap.put(Types.BLOB, byte[].class);
		Map<Class<? extends Serializable>, Integer> classMap = new HashMap<Class<? extends Serializable>, Integer>();
		classMap.put(String.class, Types.VARCHAR);
		classMap.put(BigDecimal.class, Types.NUMERIC);
		classMap.put(Boolean.class, Types.BIT);
		classMap.put(Integer.class, Types.INTEGER);
		classMap.put(Long.class, Types.BIGINT);
		classMap.put(Float.class, Types.REAL);
		classMap.put(Double.class, Types.DOUBLE);
		classMap.put(Date.class, Types.DATE);
		classMap.put(byte[].class, Types.BINARY);
		fieldTypeMapping = Collections.unmodifiableMap(typeMap);
		fieldClassMapping = Collections.unmodifiableMap(classMap);
	}

	public static Class<? extends Serializable> getFieldClass(int type) {
		return fieldTypeMapping.get(type);
	}

	public static int getFieldType(Class<? extends Serializable> fieldClass) {
		Integer ret = fieldClassMapping.get(fieldClass);
		if(ret == null) {
			return 0;
		}
		return ret;
	}

}
