/**
 * 
 */
package com.spring.base.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * @Description:业务场景:springTemplate返回的map对象key字段与数据库相同,此mapper映射成驼峰式命名
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2018年1月25日
 * @Version:1.1.0
 */
public class CamelCaseMapper implements RowMapper {
	
	/**
     * 下划线格式字符串转换为驼峰格式字符串
     * 
     * @param param
     * @return
     */
	public final char UNDERLINE = '_';
    public  String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> ormMap=new HashMap<>();
		//获取返回数据对象
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		for (int index = 1; index <= columnCount; index++) {
			String column = JdbcUtils.lookupColumnName(rsmd, index);
			ormMap.put(underlineToCamel(column),rs.getObject(column));
		}
		return ormMap;
	}
	
}
