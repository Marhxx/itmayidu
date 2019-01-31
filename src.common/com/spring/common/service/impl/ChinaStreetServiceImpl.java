package com.spring.common.service.impl;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.ChinaStreetDao;
import com.spring.common.entity.ChinaStreet;
import com.spring.common.service.ChinaStreetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lcx on 2017/3/31.
 */
@Service
public class ChinaStreetServiceImpl extends BaseServiceImpl<ChinaStreet,Long> implements ChinaStreetService{
    @Autowired
    ChinaStreetDao chinaStreetDao;

    @Override
    public BaseDao<ChinaStreet, Long> getGenericDao() {
        return chinaStreetDao;
    }

    @Override
    public List<Map<String, Object>> findStreet(String oid) {
        StringBuffer sbSql = new StringBuffer();
        sbSql.append("SELECT s.* FROM `china_street` s ");
        sbSql.append("WHERE 1=1 ");
        List<Object> values = new ArrayList<>();
        if(!StringUtils.isBlank(oid)){
            sbSql.append(" AND s.`oid` = ? ");
            values.add(oid);
        }
        return chinaStreetDao.searchForMap(sbSql.toString(), values);
    }
}
