package com.spring.common.dao.impl;

import com.spring.base.dao.impl.BaseDaoMysqlImpl;
import com.spring.base.service.BaseService;
import com.spring.common.dao.ChinaStreetDao;
import com.spring.common.entity.ChinaStreet;
import org.springframework.stereotype.Repository;

/**
 * Created by lcx on 2017/3/31.
 */
@Repository
public class ChinaStreetDaoImpl extends BaseDaoMysqlImpl<ChinaStreet,Long> implements ChinaStreetDao{
    public ChinaStreetDaoImpl() {
        super(ChinaStreet.class);
    }
}
