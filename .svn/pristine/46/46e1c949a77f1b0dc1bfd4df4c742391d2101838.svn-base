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
import java.util.LinkedHashMap;
import java.util.Map;

import com.spring.base.utils.Global;

public class GetAddressByBaidu { 
    
  /** 
  * @param addr 
  * 查询的地址 
  * @return 
  * @throws IOException 
  */
  /*public String getCoordinate(String lng,String lat) throws IOException { 
//      String lng = null;//经度
//      String lat = null;//纬度
      String city = ""; 
      String key = "f247cdb592eb43ebac6ccd27f796e2d2";
//      String key = "E4805d16520de693a3fe707cdc962045";
      String sn = null;
//      try { 
//          address = java.net.URLEncoder.encode(addr, "UTF-8");
//          city = java.net.URLEncoder.encode(city, "UTF-8");
//      }catch (UnsupportedEncodingException e1) { 
//          e1.printStackTrace(); 
//      } 
//      String key = "f247cdb592eb43ebac6ccd27f796e2d2"; 
      //http://api.map.baidu.com/geocoder?address=地址&output=输出格式类型&key=用户密钥&city=城市名
//      String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s&city=%s", address, key, city);
//      String url = String .format("http://api.map.baidu.com/geocoder/v2/?ak=E4805d16520de693a3fe707cdc962045&callback=renderReverse&location=%s&output=json&pois=1",lat+lng);
      String url = String .format("http://api.map.baidu.com/geocoder?output=json&" +  
                "location=%s,%s&key=%s",  
                lat, lng, key);
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
                  if(count==11){
//                  	System.out.println("len:"+data.length());
//                  	System.out.println("data:"+data);
                  	String[] strDate = data.split(":");
                  	if(strDate.length!=2){
                  		return null; 
                  	}
                  	city = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
                      count++;
                  }else{
                      count++;
                  }
              } 
          } 
      } catch (IOException e) { 
          e.printStackTrace(); 
      } finally {
          if(insr!=null){
              insr.close();
          }
          if(br!=null){
              br.close();
          }
      }
      city = city.replaceAll("\"", "");
      return city; 
  } */
	public String getCoordinate(String lng,String lat,String ak) throws IOException { 
//      String lng = null;//经度
//      String lat = null;//纬度
      String city = ""; 
//      String key = "f247cdb592eb43ebac6ccd27f796e2d2";
//      String key = "E4805d16520de693a3fe707cdc962045";
//      String key = "Vw2VB2ImD3yLgXnedmMW8lWZ";//可用，对应ak
      String key = ak;//可用，对应ak
      String sn = null;
//      try { 
//          address = java.net.URLEncoder.encode(addr, "UTF-8");
//          city = java.net.URLEncoder.encode(city, "UTF-8");
//      }catch (UnsupportedEncodingException e1) { 
//          e1.printStackTrace(); 
//      } 
//      String key = "f247cdb592eb43ebac6ccd27f796e2d2"; 
      //http://api.map.baidu.com/geocoder?address=地址&output=输出格式类型&key=用户密钥&city=城市名
//      String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s&city=%s", address, key, city);
//      String url = String .format("http://api.map.baidu.com/geocoder/v2/?ak=E4805d16520de693a3fe707cdc962045&callback=renderReverse&location=%s&output=json&pois=1",lat+lng);
//      String url = String .format("http://api.map.baidu.com/geocoder?output=json&" +  
//                "location=%s,%s&key=%s",  
//                lat, lng, key);
      //http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location=39.983424,116.322987&output=json&pois=1&ak=您的ak
      String url = String .format("http://api.map.baidu.com/geocoder/v2/?"
      		+ "location=%s&output=json&ak=%s", lat+","+lng, key);
      URL myURL = null; 
      URLConnection httpsConn = null; 
      try { 
          myURL = new URL(url); 
      } catch (MalformedURLException e) { 
          e.printStackTrace(); 
      } 
      /*{
    	    "status":0,
    	    "result":{
    	        "location":{
    	            "lng":120.07519899999993,
    	            "lat":30.318903016550095
    	        },
    	        "formatted_address":"浙江省杭州市西湖区振华路262",
    	        "business":"",
    	        "addressComponent":{
    	            "country":"中国",
    	            "country_code":0,
    	            "province":"浙江省",
    	            "city":"杭州市",
    	            "district":"西湖区",
    	            "adcode":"330106",
    	            "street":"振华路",
    	            "street_number":"262",
    	            "direction":"北",
    	            "distance":"60"
    	        },
    	        "pois":[

    	        ],
    	        "poiRegions":[
    	            {
    	                "direction_desc":"内",
    	                "name":"西港·新界东区",
    	                "tag":"公司企业"
    	            }
    	        ],
    	        "sematic_description":"西港·新界东区内,西港新界B区东94米",
    	        "cityCode":179
    	    }
    	}*/
   // 打开url连接
   		HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
   		
   		// 设置url请求方式 ‘get’ 或者 ‘post’
   		connection.setRequestMethod("GET");

   		// 发送
   		InputStream is =connection.getInputStream();
   		//转换返回值
   		String returnStr = convertStreamToString(is);
   		System.out.println("returnStr:"+returnStr);
   		Map map = Global.toMap(returnStr);
      if(map.get("status").toString().equals("0")){
			Map result = Global.toMap(map.get("result").toString());
			Map addressComponent = Global.toMap(result.get("addressComponent").toString());
			city = addressComponent.get("city").toString();
		}else{
			return city; 
		}
      return city; 
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
//      GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
//      Object[] o = getLatAndLngByBaidu.getCoordinate("西港新界","杭州市");
//      System.out.println(o[0]);//经度
//      System.out.println(o[1]);//纬度
	  GetAddressByBaidu getAddressByBaidu = new GetAddressByBaidu();
//	  Object[] o = getAddressByBaidu.getCoordinate("120.075199","30.318903");
//	  System.out.println(o[0]);//地址
	  String strCity = getAddressByBaidu.getCoordinate("120.06485976234953","30.30653954613663","aa");
	  System.out.println(strCity);//城市
  }

}
