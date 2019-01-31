package com.spring.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.spring.base.utils.Global;


  
/** 
 * 根据城市，详细地址获取经纬度
* 获取经纬度
* 
* @author jueyue 返回格式：Map<String,Object> map map.put("status", 
* reader.nextString());//状态 map.put("result", list);//查询结果 
* list<map<String,String>> 
* 密钥:f247cdb592eb43ebac6ccd27f796e2d2 
*/
public class GetLatAndLngByBaidu { 
      
    /** 
    * @param addr 
    * 查询的地址 
    * @return 
    * @throws IOException 
    */
    /*public Object[] getCoordinate(String addr,String city) throws IOException { 
        String lng = null;//经度
        String lat = null;//纬度
        String address = null; 
//        String key = "f247cdb592eb43ebac6ccd27f796e2d2";//可用，对应key
//        String key = "E4805d16520de693a3fe707cdc962045";
        String key = "Vw2VB2ImD3yLgXnedmMW8lWZ";//可用，对应ak
        String sn = null;
        try { 
//        	Map paramsMap = new LinkedHashMap<String, String>();
//        	paramsMap.put("address", addr);
//    		paramsMap.put("output", "json");
//    		paramsMap.put("ak", key);
//    		SnCalByBaidu snCalByBaidu = new SnCalByBaidu();
//    		// 调用下面的toQueryString方法，对LinkedHashMap内所有value作utf8编码，拼接返回结果address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
//    		String paramsStr = snCalByBaidu.toQueryString(paramsMap);
//    		System.out.println("paramsStr->"+paramsStr);
//    		// 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk得到/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
//    		String wholeStr = new String("/geocoder/v2/?" + paramsStr + key);
//
//    		// 对上面wholeStr再作utf8编码
//    		String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
//
//    		// 调用下面的MD5方法得到最后的sn签名7de5a22212ffaa9e326444c75a58f9a0
//    		System.out.println(snCalByBaidu.MD5(tempStr));
//    		sn = snCalByBaidu.MD5(tempStr);
            address = java.net.URLEncoder.encode(addr, "UTF-8");
            city = java.net.URLEncoder.encode(city, "UTF-8");
        }catch (UnsupportedEncodingException e1) { 
            e1.printStackTrace(); 
        } 
//        String key = "f247cdb592eb43ebac6ccd27f796e2d2"; 
        //http://api.map.baidu.com/geocoder?address=地址&output=输出格式类型&key=用户密钥&city=城市名
//        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s&city=%s", address, key, city);
//        String url = String .format("http://api.map.baidu.com/geocoder/v2/?"
//        		+ "address=%s&output=json&ak=%s&callback=showLocation&city=%s", address, key, city);
//        String url = String .format("http://api.map.baidu.com/geocoder/v2/?"
//        		+ "address=%s&output=json&ak=%s&city=%s", address, key, city);
        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&ak=%s&city=%s&sn=%s", address, key, city,sn);
//        System.out.println("url->"+url);
        URL myURL = null; 
        URLConnection httpsConn = null; 
        
        try { 
            myURL = new URL(url); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } 
        InputStreamReader insr = null;
        BufferedReader br = null;
        try { 
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理 
            if (httpsConn != null) { 
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8"); 
                br = new BufferedReader(insr); 
                String data = null; 
                int count = 1;
                while((data= br.readLine())!=null){ 
                	System.out.println("date:"+data);
                    if(count==5){
//                    	System.out.println("len:"+data.length());
//                    	System.out.println("data:"+data);
                    	String[] strDate = data.split(":");
                    	if(strDate.length!=2){
                    		return new Object[]{0.0,0.0}; 
                    	}
                        lng = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
                        count++;
                    }else if(count==6){
                        lat = data.substring(data.indexOf(":")+1);//纬度
                        count++;
                    }else{
                        count++;
                    }
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
            return new Object[]{0.0,0.0}; 
        } finally {
            if(insr!=null){
                insr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new Object[]{lng,lat}; 
    } */
  
	public Object[] getCoordinate(String addr,String city) throws IOException { 
        String lng = null;//经度
        String lat = null;//纬度
        String address = null; 
//        String key = "f247cdb592eb43ebac6ccd27f796e2d2";
//        String key = "E4805d16520de693a3fe707cdc962045";
//        String key = "Vw2VB2ImD3yLgXnedmMW8lWZ";//可用，对应ak
        String key = "WLwfrOa8jwi8uh7GwT5hodRa5caXIxiw";//可用，对应ak
        
        String sn = null;
        try { 
//        	Map paramsMap = new LinkedHashMap<String, String>();
//        	paramsMap.put("address", addr);
//    		paramsMap.put("output", "json");
//    		paramsMap.put("ak", key);
//    		SnCalByBaidu snCalByBaidu = new SnCalByBaidu();
//    		// 调用下面的toQueryString方法，对LinkedHashMap内所有value作utf8编码，拼接返回结果address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
//    		String paramsStr = snCalByBaidu.toQueryString(paramsMap);
//    		System.out.println("paramsStr->"+paramsStr);
//    		// 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk得到/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
//    		String wholeStr = new String("/geocoder/v2/?" + paramsStr + key);
//
//    		// 对上面wholeStr再作utf8编码
//    		String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
//
//    		// 调用下面的MD5方法得到最后的sn签名7de5a22212ffaa9e326444c75a58f9a0
//    		System.out.println(snCalByBaidu.MD5(tempStr));
//    		sn = snCalByBaidu.MD5(tempStr);
            address = java.net.URLEncoder.encode(addr, "UTF-8");
            city = java.net.URLEncoder.encode(city, "UTF-8");
        }catch (UnsupportedEncodingException e1) { 
            e1.printStackTrace(); 
        } 
//        String key = "f247cdb592eb43ebac6ccd27f796e2d2"; 
        //http://api.map.baidu.com/geocoder?address=地址&output=输出格式类型&key=用户密钥&city=城市名
//        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s&city=%s", address, key, city);
//        String url = String .format("http://api.map.baidu.com/geocoder/v2/?"
//        		+ "address=%s&output=json&ak=%s&callback=showLocation&city=%s", address, key, city);
        String url = String .format("http://api.map.baidu.com/geocoder/v2/?"
        		+ "address=%s&output=json&ak=%s&city=%s&ret_coordtype=gcj02ll", address, key, city);
//        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&ak=%s&city=%s&sn=%s", address, key, city,sn);
//        System.out.println("url->"+url);
        URL myURL = null; 
        URLConnection httpsConn = null; 
        
        try { 
            myURL = new URL(url); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } 

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
		
		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("GET");

		// 发送
		InputStream is =connection.getInputStream();
		//转换返回值
		String returnStr = convertStreamToString(is);
		System.out.println("returnStr->"+returnStr);
		Map map = Global.toMap(returnStr);
		/*
		 * {"status":0,"result":
		 * {"location":
		 * {"lng":120.0751994277086,"lat":30.318902836431158},
		 * "precise":0,"confidence":60,"level":"地产小区"}
		 * }
		 */
		if(map.get("status").toString().equals("0")){
			Map result = Global.toMap(map.get("result").toString());
			Map location = Global.toMap(result.get("location").toString());
			lng = location.get("lng").toString();
			lat = location.get("lat").toString();
		}else{
			return new Object[]{0.0,0.0}; 
		}
        return new Object[]{lng,lat}; 
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
    public static void main(String[] args) throws IOException {
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        Object[] o = getLatAndLngByBaidu.getCoordinate("西港新界","杭州市");
        System.out.println(o[0]);//经度
        System.out.println(o[1]);//纬度
    }
  
}