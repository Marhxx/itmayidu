package com.spring.base.utils;

public class CalDistance {
	public static void main(String[] args) {
		GetDistance(120.315524, 30.411691, 120.06875, 30.308574);
	}

	private static double EARTH_RADIUS = 6378.137;// 地球半径

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static double GetDistance(double lat1, double lng1, double lat2,
			double lng2) {
		 double radLat1 = rad(lat1);
		 double radLat2 = rad(lat2);
		 double a = radLat1 - radLat2;
		 double b = rad(lng1) - rad(lng2);
		 double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
		 Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
//		 System.out.println(s);
//		 double s1 = EARTH_RADIUS*2 *
//		 Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
//		 Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
//		 System.out.println("s1:"+s1);
		 s = s * EARTH_RADIUS;
		 s = Math.round(s * 1000);
//		 s1 = Math.round(s1 * 1000);
		 System.out.println("s->:"+s);
//		 System.out.println(s1);
		 return s;
//		double radLat1 = rad(lat1);
//		double radLat2 = rad(lat2);
//		double difference = radLat1 - radLat2;
//		double mdifference = rad(lng1) - rad(lng2);
//		double distance = 2 * Math.asin(Math.sqrt(Math.pow(
//				Math.sin(difference / 2), 2)
//				+ Math.cos(radLat1)
//				* Math.cos(radLat2)
//				* Math.pow(Math.sin(mdifference / 2), 2)));
//		distance = distance * EARTH_RADIUS;
//		distance = Math.round(distance * 10000) / 10000;
//		System.out.println("distance:" + distance);
//		return distance;
	}
}
