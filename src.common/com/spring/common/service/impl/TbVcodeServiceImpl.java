package com.spring.common.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.TbVcodeDao;
import com.spring.common.entity.TbVcode;
import com.spring.common.service.TbVcodeService;


@Service("tbVcodeService")
public class TbVcodeServiceImpl extends BaseServiceImpl<TbVcode, Long>
implements TbVcodeService{
	
	@Autowired
	TbVcodeDao tbVcodeDao;

	@Override
	public BaseDao<TbVcode, Long> getGenericDao() {
		return tbVcodeDao;
	}

	/**
	 * 
	* Title: saveOrUpdate 
	* Description:  保存或更新验证码
	* @param mobile
	* @param code 
	* @see com.spring.api.service.TbVcodeService#saveOrUpdate(java.lang.String, java.lang.String)
	 */
	@Override
	public void saveOrUpdate(String mobile, String code,String type) {
		String sql = "select * from tb_vcode where tv_phone= ? ";
		List<Object> values = new ArrayList<Object>();
		values.add(mobile);
		
		List<TbVcode> list = tbVcodeDao.search(sql, values);
		TbVcode vCode = null;
		if(null != list && list.size() > 0){//有则修改
			vCode = list.get(0);
			vCode.setTvAddDate(new Timestamp(new Date().getTime()));
			vCode.setTvCode(code);
			vCode.setTvPhone(mobile);
			vCode.setTvType(Integer.valueOf(type));
			tbVcodeDao.update(vCode);
		} else {//没有就保存
			vCode = new TbVcode();
			vCode.setTvAddDate(new Timestamp(new Date().getTime()));
			vCode.setTvCode(code);
			vCode.setTvPhone(mobile);
			vCode.setTvType(Integer.valueOf(type));
			tbVcodeDao.save(vCode);
		}
	}

	/**
	 * 
	* Title: checkCode 
	* Description:  验证验证码是否存在或过期
	* @param mobile
	* @param captcha
	* @return 
	* @see com.spring.api.service.TbVcodeService#checkCode(java.lang.String, java.lang.String)
	 */
	@Override
	public int checkCode(String mobile, String captcha, String time) {
		String sql = "SELECT * FROM tb_vcode WHERE tv_phone = ? AND tv_code = ?";
		List<Object> values = new ArrayList<Object>();
		values.add(mobile);
		values.add(captcha);
		List<TbVcode> list = tbVcodeDao.search(sql, values);
		if(null != list && list.size() > 0){
			if(!StringUtils.isBlank(time))
				sql += " AND UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(tv_add_date) <= "+time;
			else
				sql += " AND UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(tv_add_date) <= 300";//默认验证码过期时间
			
			list = tbVcodeDao.search(sql, values);
			if(null != list && list.size() > 0){
				return 1;
			}
			return 0;//过期
		} else {
			return -1;//验证码错误
		}
	}

}
