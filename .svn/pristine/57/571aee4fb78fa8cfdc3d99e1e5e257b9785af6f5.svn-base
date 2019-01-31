package com.spring.base.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.kisso.common.encrypt.SaltEncoder;
import com.google.gson.Gson;
import com.spring.common.entity.DrivingBaiduEntity;
import com.spring.common.entity.RidingBaiduEntity;
import com.spring.common.entity.TransitBaiduEntity;

public class StringUtil{
	private static final Log log = LogFactory.getLog(StringUtil.class);

	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
	private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat sdf6 = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private static SimpleDateFormat sdf7 = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdf8 = new SimpleDateFormat(
			"yyyy-MM-dd 00:00:00");

	public static String formatDate(Date date) {
		if (date != null) {
			return sdf.format(date);
		}
		return "";
	}

	public static String formatDate2(Date date) {
		return sdf2.format(date);
	}

	public static String formatDate3(Date date) {
		return sdf3.format(date);
	}

	public static String formatDate4(Date date) {
		return sdf4.format(date);
	}

	public static String formatDate5(Date date) {
		return sdf5.format(date);
	}

	public static String formatDate6(Date date) {
		return sdf6.format(date);
	}

	public static String formatDate7(Date date) {
		return sdf7.format(date);
	}

	public static Boolean passwordVerification(String strString) {
		
		String regExp = "^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{6,16}$"; 
		if (!strString.matches(regExp)) {
			return false;
		}
		return true;
	}


	
	public static String formatDate8(Date date) {
		return sdf3.format(date) + " 00:00:00";
	}

	public static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * @notes 字符串转化为十六进制字符串
	 * @param bytes
	 * @return String
	 */
	public static String toHexString(String strString) {
		byte[] bytes = strString.getBytes();
		char[] chars = new char[bytes.length * 2];

		for (int i = 0; i < bytes.length; i++) {
			int b = bytes[i];
			chars[i * 2] = StringUtil.hexDigits[(b & 0xF0) >> 4];
			chars[i * 2 + 1] = StringUtil.hexDigits[b & 0x0F];
		}

		return new String(chars);
	}

	/**
	 * @notes 十六进制字符串转化为字符串
	 * @param str
	 * @return byte[]
	 */
	public static String hexToString(String str) {
		int length = str.length() / 2;
		byte[] bytes = new byte[length];
		byte[] source = str.getBytes();

		for (int i = 0; i < bytes.length; ++i) {
			byte bh = Byte.decode(
					"0x" + new String(new byte[] { source[i * 2] }))
					.byteValue();
			bh = (byte) (bh << 4);
			byte bl = Byte.decode(
					"0x" + new String(new byte[] { source[i * 2 + 1] }))
					.byteValue();
			bytes[i] = (byte) (bh ^ bl);
		}

		return new String(bytes);
	}

//	/**
//	 * 取源客户端IP
//	 * 
//	 * @param request
//	 * @return
//	 */
//	public static String getIpAddr() {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		String ip = request.getHeader("x-forwarded-for");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}
//		return ip;
//	}

//	/**
//	 * Ajax数据写入客户端
//	 */
//	public static String SendAjaxToIE(String strContent) {
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = null;
//
//		try {
//			out = response.getWriter();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		out.print(strContent);
//
//		out.flush();
//		out.close();
//
//		return null;
//	}

//	/**
//	 * String数据写入客户端
//	 */
//	public static String SendStringToIE(String strContent) {
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setCharacterEncoding("gbk");
//		PrintWriter out = null;
//
//		try {
//			out = response.getWriter();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		out.print(strContent);
//
//		out.flush();
//		out.close();
//
//		return null;
//	}

//	public static String SendAlertToIE(String string, String strUrl) {
//		String strAlert = "<script>";
//		strAlert += "alert(\"" + string + "\");";
//		if (strUrl != null)
//			strAlert += "window.location.href=\"" + strUrl + "\"";
//		strAlert += "</script>";
//		return SendStringToIE(strAlert);
//	}
//
//	public static String SendScriptToIE(String string) {
//		String strAlert = "<script>";
//		strAlert += string;
//		strAlert += "</script>";
//		return SendStringToIE(strAlert);
//	}
//
//	public static String SendRedirectToIE(String strUrl) {
//		HttpServletResponse response = ServletActionContext.getResponse();
//		try {
//			response.sendRedirect(strUrl);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	public static String toHml(String content) {
		if (content != null && !"".equals(content)) {
			content = content.replaceAll("&amp;", "&");
			content = content.replaceAll("&lt;", "<");
			content = content.replaceAll("&gt;", ">");
			content = content.replaceAll("&quot;", "'");
			content = content.replaceAll("&acute;", "'");
			//content = content.replaceAll("\\r\\n", "&xrl");
			//content = content.replaceAll(";", "\\n\\t");
			return content;
		} else {
			return "";
		}
	}

	public static String htmlToString(String content) {
		if (content != null && !"".equals(content)) {
			content = content.replaceAll("&", "&amp;");
			content = content.replaceAll("<", "&lt;");
			content = content.replaceAll(">", "&gt;");
			content = content.replaceAll("\"", "&quot;");
			content = content.replaceAll("'", "&acute;");
			// content = content.replaceAll("\\r\\n", "&xrl");
			content = content.replaceAll("\\n\\t","");
			content = content.replaceAll("\\n","");
			return content;

		} else {
			return "";
		}
	}

	public static String parseUrl(String url) {
		if (url != null && !url.equals("")) {
			url = url.replaceAll("\\\\", "\\/");
		}
		return url;
	}

	/****************** 加密某个字符到另外一种字符 ************************/
	/*
	 * 不可逆加密
	 */
	public static String Analysis(String strLoginId) {

		if (strLoginId == null || strLoginId.equals(""))
			return "Error";
		Long lId = Long.parseLong(strLoginId);
		strLoginId = "";
		strLoginId += lId * 256355;
		byte[] loginBytes = strLoginId.getBytes();
		int iByteLen = loginBytes.length;
		for (int i = 0; i < iByteLen; i++) {
			loginBytes[i] += getKeyByte(iByteLen + i);
			// loginBytes[i]+=getKeyByte((int)lId+i);
		}

		String retString = "";
		for (int i = 0; i < iByteLen; i++) {
			retString += Math.abs(loginBytes[i]);
		}

		return retString;
	}

	/**
	 * 密钥
	 */
	static byte[] AKEY_BYTES = ("?1.,][=-0v9*87gj2_*^" + "^3~[]~g~8|5U#D$CV+0."
			+ "c6nn#%5gf((25-261c>>").getBytes();

	public static byte getKeyByte(int pos) {
		int keyLent = AKEY_BYTES.length;
		return AKEY_BYTES[pos % keyLent];
	}

	/****************** 加密某个字符到另外一种字符结束 ************************/

	/****************
	 * MD5加密
	 * 
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		if (str == null) {
			return "";
		}
		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}
	
	/** 
     * 将double格式化为指定小数位的String，不足小数位用0补全 
     * 
     * @param v     需要格式化的数字 
     * @param scale 小数点后保留几位 
     * @return 
     */  
	public static String roundByScale(double v, int scale) {  
        if (scale < 0) {  
            throw new IllegalArgumentException(  
                    "The   scale   must   be   a   positive   integer   or   zero");  
        }  
        if(scale == 0){  
            return new DecimalFormat("0").format(v);  
        }  
        String formatStr = "0.";  
        for(int i=0;i<scale;i++){  
            formatStr = formatStr + "0";  
        }  
        return new DecimalFormat(formatStr).format(v);  
    }  

	public static String dayStart() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return sdf.format(cal.getTime());
	}

	public static String dayEnd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return sdf.format(cal.getTime());
	}

	public static String DateToString(java.util.Date date, String DataFormat) {
		String dateStr = "";
		if (date == null)
			date = new Date(); // 如果取不到时间，就用当前时间
		try {
			SimpleDateFormat DF = new SimpleDateFormat(DataFormat);
			dateStr = DF.format(date);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return dateStr;
	}

	/**
	 * 字符串类型日期获取星期
	 * 
	 * @author jisuhua
	 * @date 2014-1-11 下午2:35:49
	 * @email jisuhua@ty057.com
	 * @param strDate
	 *            例如：2014-01-02 14:14:14
	 * @param DataFormat
	 *            例如：yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String stringToWeek(String strDate, String DataFormat) {
		String week = "";
		Calendar c = Calendar.getInstance();
		Date date1 = StringToDate(strDate, DataFormat);
		c.setTime(date1); // 当时间set 进calendar 里面
		int i = c.get(Calendar.DAY_OF_WEEK); // 取星期
		int weekCount = i - 1;
		if (weekCount == 0) {
			week = "星期日";
		} else if (weekCount == 1) {
			week = "星期一";
		} else if (weekCount == 2) {
			week = "星期二";
		} else if (weekCount == 3) {
			week = "星期三";
		} else if (weekCount == 4) {
			week = "星期四";
		} else if (weekCount == 5) {
			week = "星期五";
		} else {
			week = "星期六";
		}
		return week;
	}

	public static Date StringToDate(String strDate, String DataFormat) {
		Date date = null;
		SimpleDateFormat DF = new SimpleDateFormat(DataFormat);
		try {
			date = DF.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 产生一个指定范围内的随机数
	 * 
	 * @param iMax
	 * @return
	 */
	public static int getRandInt(int iMax) {
		return (int) (Math.random() * 900 + 100);
	}

	/**
	 * 产生指定长度的随机数
	 * 
	 * @param len
	 * @return
	 */
	public static String getRandomForLen(int len) {
		String str = "";
		Random ran = new Random();
		for (int i = 0; i < len; i++) {
			str += ran.nextInt(9);
		}
		return str;
	}

	/**
	 * 将指定数据集合转化为JSON字符串
	 * 
	 * @param data
	 * @return
	 */
	public static String arrayToJsonString(List<Map> data) {
		if (data == null) {
			return "[]";
		}
		StringBuffer str = new StringBuffer();
		str.append("[");
		for (int i = 0; i < data.size(); i++) {
			if (i != 0) {
				str.append(",");
			}
			str.append(mapToJsonString(data.get(i)));
		}
		str.append("]");
		return str.toString();
	}

	/**
	 * 把Map转化为JSON格式字符串
	 * 
	 * @param map
	 * @return
	 */
	public static String mapToJsonString(Map map) {
		if (map == null) {
			return "";
		}
		StringBuffer str = new StringBuffer();
		str.append("{");
		Iterator keys = map.keySet().iterator();
		String tempStr = "";
		while (keys.hasNext()) {
			Object key = keys.next();
			tempStr += "'" + key + "':'" + map.get(key) + "',";
		}
		if (!"".equals(tempStr)) {
			tempStr = tempStr.substring(0, tempStr.length() - 1);
		}
		str.append(tempStr);
		str.append("}");
		return str.toString();
	}

	// 判断是否是有效的日期
	public static boolean checkDate(String ds) {
		try {
			String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
			Pattern p = Pattern.compile(eL);
			Matcher m = p.matcher(ds);

			boolean b = m.matches();
			if (b) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	// 判断是否是有效的手机号码
	public static boolean checkMobile(String mobile) {
		try {
			String eL = "^1[3456789]\\d{9}$";
			//String eL = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
			Pattern p = Pattern.compile(eL);
			Matcher m = p.matcher(mobile);

			boolean b = m.matches();
			System.out.println(b);
			if (b) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param line
	 * @return
	 */
	@SuppressWarnings("unused")
	public static boolean checkEmail(String email) {
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(email);
		return m.find();
	}

	// 过滤特殊字符
	public static String stringFilter(String str) {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		try {
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			return m.replaceAll("").trim();
		} catch (Exception e) {
			return "";
		}
	}

	public static String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		String after = m.replaceAll("");

		return after;
	}

	public static String replaceBlank2(String str) {
		Pattern p = Pattern.compile("\\r|\n");
		Matcher m = p.matcher(str);
		String after = m.replaceAll("");

		return after;
	}

	// 验证是否为数字
	public static boolean isNumber(String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("[0-9]*");
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 验证字符串是否是double类型
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str)
	{
	   try
	   {
	      Double.parseDouble(str);
	      return true;
	   }
	   catch(NumberFormatException ex){}
	   return false;
	}
	/**
	 * 将一个字符串转化为输入流
	 */
	public static InputStream getStringStream(String sInputString,
			String ecodeing) {
		if (sInputString != null && !sInputString.trim().equals("")) {
			try {
				ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(
						sInputString.getBytes(ecodeing));
				return tInputStringStream;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public static boolean isEmptyNull(String string) {
		if (string == null || "".equalsIgnoreCase(string.trim())
				|| "null".equalsIgnoreCase(string)||"".equals(string)) {
			return true;
		}
		return false;
	}

	/**
	 * 过滤‘null’字符
	 * 
	 * @author zhoujing
	 * @datetime 2014-2-14下午3:04:10
	 * @param str
	 * @return
	 */
	public static String strFilterNull(String str) {
		if (!isEmptyNull(str)) {
			return str;
		}
		return "";
	}
	/**
	 * 信鸽推送中将位数为1的帐号前添加0
	 * @param string
	 * @return
	 */
	public static String XGPushID(String str) {
		if(str.length()==1){
			str = "0"+str;
		}
		return str;
	}
	/**
	 * author lx
	 * @datetime 2014-2-27
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零 要用到正则表达式
	 */
	public static String digitUppercase(double n) {
		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };
		String head = n < 0 ? "负" : "";
		n = Math.abs(n);
		String s = "";
		for (int i = 0; i < fraction.length; i++) {
			s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i])
					.replaceAll("(零.)+", "");
		}
		if (s.length() < 1) {
			s = "整";
		}
		int integerPart = (int) Math.floor(n);
		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String p = "";
			for (int j = 0; j < unit[1].length && n > 0; j++) {
				p = digit[integerPart % 10] + unit[1][j] + p;
				integerPart = integerPart / 10;
			}
			s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i]
					+ s;
		}
		return head
				+ s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "")
						.replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
	}
	/**
	 * 高德坐标转百度坐标
	 * @param gd_lon
	 * @param gd_lat
	 * @return
	 */
	public static double[] gaoDeToBaidu(Double gd_lon, Double gd_lat) {
		if(gd_lon==null){
			gd_lon=0.0;
		}
		if(gd_lat==null){
			gd_lat=0.0;
		}
	    double[] bd_lat_lon = new double[2];
	    double PI = 3.14159265358979324 * 3000.0 / 180.0;
	    double x = gd_lon, y = gd_lat;
	    double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * PI);
	    double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * PI);
	    bd_lat_lon[0] = z * Math.cos(theta) + 0.0065;
	    bd_lat_lon[1] = z * Math.sin(theta) + 0.006;
	    return bd_lat_lon;
	}
	/**
	 * 加密
	 * @param account
	 * @param password
	 * @return
	 */
	public static String md5SaltEncode(String account,String password) {
		return SaltEncoder.md5SaltEncode(account, password);
	}
	/**
	 * 验证密码是否正确
	 * @param account
	 * @param password 密码
	 * @param Md5SaltPass 加密后的密码
	 * @return
	 */
	public static boolean md5SaltValid(String account,String password,String Md5SaltPass){
		return SaltEncoder.md5SaltValid(account, Md5SaltPass, password);
	}
	/**
	 * 取源客户端IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	/**
	* 获取ip地址
	* 
	* @param request
	* @return
	*/
	public static String getIpAddr(HttpServletRequest request) {
	String ip = request.getHeader("X-Forwarded-For");
	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	ip = request.getHeader("Proxy-Client-IP");
	}
	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	ip = request.getHeader("WL-Proxy-Client-IP");
	}
	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	ip = request.getHeader("HTTP_CLIENT_IP");
	}
	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	}
	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	ip = request.getRemoteAddr();
	}
	return ip;
	}

	/**
	 * 生成随机字符串
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		/*
		 * String content = "<?xml version=\"1.0\" encoding=\"gb2312\"?>"+
		 * "<PBXX>"+ "<sYSBM>12</sYSBM>"+ "<sSBSJ>2014-01-11 12:12:12</sSBSJ>"+
		 * "<sXBSJ>2014-01-11 12:12:12</sXBSJ>"+ "<sPBRQ>2014-01-11</sPBRQ>"+
		 * "<sBCBM>123</sBCBM>"+ "<sPBLSH>321</sPBLSH>"+ "</PBXX>";
		 * 
		 * 
		 * System.out.println(hosp_api("Wsj_yy_cxsl",content,"1"));
		 * 
		 * 
		 * Date date1 = StringToDate("2014-01-14 14:14:14",
		 * "yyyy-MM-dd HH:mm:ss"); System.out.println(date1);
		 * System.out.println(DateToString(date1, "MM-dd"));
		 */

		/*
		 * System.out.println(stringToWeek("2014-01-22", "yyyy-MM-dd"));
		 * 
		 * URL url = new URL("http://mzb.51gh.net/wsjyyjk/yyjk.asmx?wsdl");
		 * QName qName = new QName("Wsj_yy_cxsl"); Service service = new
		 * Service(url, qName); Call call = service.createCall();
		 * 
		 * call.setUsername(); call.setPassword();
		 * 
		 * Object result = call.invoke(new Object[]{"参数1"，"参数2"});
		 */

		// System.out.println(stringToWeek("01-13", "MM-dd"));

		// String strWorkTime = "08001100";
		// System.out.println(strWorkTime.substring(0, 2) + ":"
		// + strWorkTime.substring(2, 4) + ":00");
		// System.out.println(strWorkTime.substring(4, 6) + ":"
		// + strWorkTime.substring(6, 8) + ":00");
//		System.out.println(digitUppercase(0.53));
		/*try {
//			Client client = new Client(new URL("http://121.40.188.122:6080/smsWs/sms.ws?wsdl"));
//			Object[] o = client.invoke("sendSMS", new Object[]{"tuzi","e10adc3949ba59abbe56e057f20f883e","18368085192","您有一条新的维修工单，请尽快确认。"+"【兔子快跑】","106575259144","zjcmcc"});
//			System.out.println("短信发送："+o[0].toString());
			System.out.println(md5SaltEncode("15901290001", "123456"));
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 根据百度API获取经纬度
	 * @param address  地址名称
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static Double[] getLonAndLatByAddress(String address,String ak) throws UnsupportedEncodingException{
		Double[] result=new Double[2];
		address=URLEncoder.encode((String)address,"UTF-8");
		//String url = "http://api.map.baidu.com/geocoder/v2/?address=%E6%B5%99%E6%B1%9F%E7%9C%81%E6%9D%AD%E5%B7%9E%E5%B8%82%E8%A5%BF%E6%B8%AF%E6%96%B0%E7%95%8C&output=json&ak=twdmI8e6jxz6XozOzE77hC81wNGgnkhC&sn=9a28fa886736d9aef397103918fc74ab";
		String url = "http://api.map.baidu.com/geocoder/v2/?address="+address+"&output=json&ak="+ak;
		try {
			String json = loadJSON(url);
			JSONObject obj = JSONObject.parseObject(json);
			System.out.println("obj:"+obj);
			if (obj.get("status").toString().equals("0")) {
				double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
				double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
				result[0]=lng;
				result[1]=lat;
				return result;
			} else {
				return null;
				// LogUtil.debug("未找到相匹配的经纬度！");
				// System.out.println("未找到相匹配的经纬度！");
			}
		} catch (Exception e) {
			return null;
			// LogUtil.error("未找到相匹配的经纬度，请检查地址");
		}
	}
	
	
	/**
	 * 根据百度地图获取大约时间
	 * @param origins
	 * @param destinations
	 * @param type 1:驾车2:骑行3:公交车
	 * @return
	 */
	public static String getPredictTime(String origins,String destinations,String ak,String type) {
		Map<String, Double> map = new HashMap<String, Double>();
		String typeCode="";
		String strType="";
		if("1".equals(type)){
			strType="driving";
		}
		if("2".equals(type)){
			strType="riding";
			typeCode="&riding_type=1";
		}
		if("3".equals(type)){
			strType="transit";
			typeCode="&tactics_incity=4&tactics_intercity=0&page_size=1&page_index=1";
		}
		if(!"1".equals(type)&&!"2".equals(type)&&!"3".equals(type)){
			return "101";
		}
		System.out.println("origins:"+origins);
		System.out.println("destinations:"+destinations);
		String url = "http://api.map.baidu.com/direction/v2/"+strType+"?origin="+origins+"&destination="+destinations+"&output=json&ak="+ak+typeCode;
		//String url="http://api.map.baidu.com/direction/v2/driving?origin=30.294609,120.149066&destination=30.31885,120.074767&output=json&ak=twdmI8e6jxz6XozOzE77hC81wNGgnkhC";
		try {
			System.out.println("url:"+url);
			String json = loadJSON(url);
			System.out.println("json:"+json);
			if("3".equals(type)){
				TransitBaiduEntity  t=new Gson().fromJson(json, TransitBaiduEntity.class);
				if (t.getStatus()==0) {
					String result=Integer.valueOf(t.getResult().getRoutes().get(0).getDuration()).toString();
					return result;
				} else {
					return t.getMessage();
				}
			}
			if("2".equals(type)){
				RidingBaiduEntity  t=new Gson().fromJson(json, RidingBaiduEntity.class);
				if (t.getStatus()==0) {
					String result=Integer.valueOf(t.getResult().getRoutes().get(0).getDuration()).toString();
					return result;
				} else {
					return t.getMessage();
				}
			}
			if("1".equals(type)){
				DrivingBaiduEntity  t=new Gson().fromJson(json, DrivingBaiduEntity.class);
				System.out.println("t:"+t);
				if (t.getStatus()==0) {
					String result=Integer.valueOf(t.getResult().getRoutes().get(0).getDuration()).toString();
					return result;
				} else {
					return t.getMessage();
				}
			}
			return "数据异常";
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "服务器繁忙";
		}
	}
	
	public static String loadJSON(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return json.toString();
	}
	
	public static double getDecimal(double num) {
		if (Double.isNaN(num)) {
			return 0;
		}
		BigDecimal bd = new BigDecimal(num);
		num = bd.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
		return num;
	}
	/**
	 * Map转换成Xml
	 * @param map
	 * @return
	 */
	public static String map2Xmlstring(Map map){
		StringBuffer sb = new StringBuffer("");
		sb.append("<xml>");

		Set<String> set = map.keySet();
		for(Iterator<String> it=set.iterator(); it.hasNext();){
			String key = it.next();
			Object value = map.get(key);
			sb.append("<").append(key).append(">");
			sb.append(value);
			sb.append("</").append(key).append(">");
		}
		sb.append("</xml>");
		System.out.println(sb.toString());
		return sb.toString();
	}
}

