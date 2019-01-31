package com.spring.base.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 百度鹰眼
 * 添加百度鹰眼entity等
 * 2017年2月25日下午12:37:28
 * @author lcx
 *
 */
public class BaiduEagleEyeEntity {
	private static String key = "WLwfrOa8jwi8uh7GwT5hodRa5caXIxiw";//可用，对应ak
    private static String service_id = "134674";
	/**
	 * 上传entity
	 * @param empId
	 * @return
	 * @throws IOException
	 */
	public static String BaiduEagleEyeEntityAdd(String empId) throws IOException { 
//      String url = String .format("http://api.map.baidu.com/trace/v2/entity/add?"
//      		+ "ak=%s&service_id=%s&entity_name=%s", key,service_id,empId);
      String url = "http://api.map.baidu.com/trace/v2/entity/add";
//      System.out.println("url:"+url);
//      URL myURL = null; 
//      URLConnection httpsConn = null; 
//      try { 
//          myURL = new URL(url); 
//      } catch (MalformedURLException e) { 
//          e.printStackTrace(); 
//      } 
//   // 打开url连接
//   		HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
//   		
//   		// 设置url请求方式 ‘get’ 或者 ‘post’
//   		connection.setRequestMethod("GET");
//
//   		// 发送
//   		InputStream is =connection.getInputStream();
//   		//转换返回值
//   		String returnStr = convertStreamToString(is);
//   		System.out.println("returnStr:"+returnStr);
      Map<String,Object> mapJson = new HashMap<String, Object>();
      mapJson.put("entity_name", empId);
      mapJson.put("service_id", service_id);
      mapJson.put("ak", key);
//      JSONObject jsonObj = new JSONObject(mapJson);
//      String returnStr = postHTTP(url, jsonObj.toString());
      String values = createLinkString(mapJson);
      System.out.println("values:"+values);
      String returnStr = sendPost(url,values);
      System.out.println("returnStr:"+returnStr);
//   		Map map = Global.toMap(returnStr);
   		
//      if(map.get("status").toString().equals("0")){
//			Map result = Global.toMap(map.get("result").toString());
//			Map addressComponent = Global.toMap(result.get("addressComponent").toString());
//			city = addressComponent.get("city").toString();
//		}else{
//			return city; 
//		}
//      return city; 
   		return null;
  } 

	public static String BaiduEagleEyeTrackAddpoint(String entity_name,
			Object lat, Object lng, String coord_type, Long loc_time)
			throws IOException {
		loc_time = loc_time/1000;
		String url = "http://api.map.baidu.com/trace/v2/track/addpoint";
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("entity_name", entity_name);
		mapJson.put("service_id", service_id);
		mapJson.put("ak", key);
		mapJson.put("latitude", lat);
		mapJson.put("longitude", lng);
		mapJson.put("coord_type", coord_type);
		mapJson.put("loc_time", loc_time);
		String values = createLinkString(mapJson);
		System.out.println("values:" + values);
		String returnStr = sendPost(url, values);
		System.out.println("returnStr:" + returnStr);
		return null;
	}

	public static String createLinkString(Map<String, Object> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key).toString();

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
	public static String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {    
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
	/**
	 * 发送HttpPost请求
	 * 
	 * @param strURL
	 *            服务地址
	 * @param params
	 *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
	 * @return 成功:返回json字符串<br/>
	 */
	public static String postHTTP(String strURL, String params) {
		System.out.println("strURL:"+strURL);
		System.out.println("params:"+params);
		try {
			URL url = new URL(strURL);// 创建连接
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // 设置请求方式
			connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
			connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.append(params);
			out.flush();
			out.close();
			// 读取响应
			int length = (int) connection.getContentLength();// 获取长度
			InputStream is = connection.getInputStream();
			if (length != -1) {
				byte[] data = new byte[length];
				byte[] temp = new byte[512];
				int readLen = 0;
				int destPos = 0;
				while ((readLen = is.read(temp)) > 0) {
					System.arraycopy(temp, 0, data, destPos, readLen);
					destPos += readLen;
				}
				String result = new String(data, "UTF-8"); // utf-8编码
				System.out.println("result:"+result);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error"; // 自定义错误信息
	}
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
	public static void main(String[] args) throws Exception{
		BaiduEagleEyeEntityAdd("27");
		//发送 POST 请求
//        String sr=sendPost("http://api.map.baidu.com/trace/v2/entity/add", "ak=WLwfrOa8jwi8uh7GwT5hodRa5caXIxiw&service_id=134674&entity_name=24");
//        System.out.println(sr);
	}
}
