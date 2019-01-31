package com.spring.base.util;

import java.util.Date;
import java.util.Map;









import org.json.JSONObject;
import com.spring.base.utils.StringUtil;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.Style;
import com.tencent.xinge.TimeInterval;
import com.tencent.xinge.XingeApp;
import com.xiaomi.xmpush.server.Result;

public class XGPushUtil {
	//安卓 维修端
	public static final long ANDROID_APP_KEY = 2100189464;
	public static final String ANDROID_ACCESS_KEY = "A7S6T2MQ6R2Z";
	public static final String ANDROID_SECRET_KEY = "e6eaa63d1eca94a3c960100c42f07031";
	//安卓1 派工端
	public static final long ANDROID_APP_KEY1 = 2100250529;
	public static final String ANDROID_ACCESS_KEY1 = "A8IM5QWZ737W";
	public static final String ANDROID_SECRET_KEY1 = "49961467a311d41d6362a421c9d59a6c";
	// 安卓3工单确认（用报修端的） 客户端
	public static final long ANDROID_APP_KEY2 = 2100189465;
	public static final String ANDROID_ACCESS_KEY2 = "A1LRM647LI5T";
	public static final String ANDROID_SECRET_KEY2 = "536ad8efd3260ba6da474d3f34d1c13f";
	
	//IOS
	public static final long IOS_APP_KEY = 2200241740L;
	public static final String IOS_ACCESS_KEY = "IY3YU9791NDC";
	public static final String IOS_SECRET_KEY = "bfa539afb351f83075b1363a63397cdc";
	//IOS维修端
	public static final long IOS_APP_KEY1 = 2200241748L;
	public static final String IOS_ACCESS_KEY1 = "I5ER5F22YK7H";
	public static final String IOS_SECRET_KEY1 = "f9c98ee1a8011e7adbbb857d030fa4fd";
	//IOS派工端
	public static final long IOS_APP_KEY2 = 2200251810L;
	public static final String IOS_ACCESS_KEY2 = "I399M9C7BHXM";
	public static final String IOS_SECRET_KEY2 = "6356561b36bc8c8c62d66bf35f1a86c3";
	
	static XingeApp androidXinge,androidXinge1,androidXinge2,iosXinge,iosXinge1,iosXinge2;
	static{
		androidXinge = new XingeApp(ANDROID_APP_KEY, ANDROID_SECRET_KEY);
		androidXinge1 = new XingeApp(ANDROID_APP_KEY1, ANDROID_SECRET_KEY1);
		androidXinge2 = new XingeApp(ANDROID_APP_KEY2, ANDROID_SECRET_KEY2);
		iosXinge = new XingeApp(IOS_APP_KEY, IOS_SECRET_KEY);
		iosXinge1 = new XingeApp(IOS_APP_KEY1, IOS_SECRET_KEY1);
		iosXinge2 = new XingeApp(IOS_APP_KEY2, IOS_SECRET_KEY2);
	}

	/**
	 * 下发IOS单个账号 客户端
	 * @param custom
	 * @param account
	 * @param content
	 * @return
	 */
	public static JSONObject pushSingleAccountIOS(Map<String, Object> custom,String account,String content) {
		MessageIOS message = new MessageIOS();
		message.setExpireTime(86400);
		message.setAlert(content);
		message.setBadge(1);
		message.setSound("beep.wav");
		TimeInterval acceptTime1 = new TimeInterval(0,0,23,59);
		message.addAcceptTime(acceptTime1);
		message.setCustom(custom);
//		XingeApp iosXinge = new XingeApp(IOS_APP_KEY, IOS_SECRET_KEY);
//		JSONObject ret = iosXinge.pushSingleAccount(0, account, message, XingeApp.IOSENV_DEV);
		JSONObject ret = iosXinge.pushSingleAccount(0, account, message, XingeApp.IOSENV_PROD);//生产
		return (ret);
	}
	
	/**
	 * 下发IOS单个账号 维修端
	 * @param custom
	 * @param account
	 * @param content
	 * @return
	 */
	public static JSONObject pushSingleAccountIOS1(Map<String, Object> custom,String account,String content) {
		MessageIOS message = new MessageIOS();
		message.setExpireTime(86400);
		message.setAlert(content);
		message.setBadge(1);
		message.setSound("beep.wav");
		TimeInterval acceptTime1 = new TimeInterval(0,0,23,59);
		message.addAcceptTime(acceptTime1);
		message.setCustom(custom);
//			XingeApp iosXinge = new XingeApp(IOS_APP_KEY, IOS_SECRET_KEY);
//			JSONObject ret = iosXinge1.pushSingleAccount(0, account, message, XingeApp.IOSENV_DEV);
		JSONObject ret = iosXinge1.pushSingleAccount(0, account, message, XingeApp.IOSENV_PROD);//生产
		return (ret);
	}
	
	/**
	 * 下发IOS单个账号 派工端
	 * @param custom
	 * @param account
	 * @param content
	 * @return
	 */
	public static JSONObject pushSingleAccountIOS2(Map<String, Object> custom,String account,String content) {
		MessageIOS message = new MessageIOS();
		message.setExpireTime(86400);
		message.setAlert(content);
		message.setBadge(1);
		message.setSound("beep.wav");
		TimeInterval acceptTime1 = new TimeInterval(0,0,23,59);
		message.addAcceptTime(acceptTime1);
		message.setCustom(custom);
//			XingeApp iosXinge = new XingeApp(IOS_APP_KEY, IOS_SECRET_KEY);
//			JSONObject ret = iosXinge2.pushSingleAccount(0, account, message, XingeApp.IOSENV_DEV);
		JSONObject ret = iosXinge2.pushSingleAccount(0, account, message, XingeApp.IOSENV_PROD);//生产
		return (ret);
	}
	
	//下发IOS多个账号
	/*public static JSONObject pushAccountListIOS(List<String> accountList,String content) {
		MessageIOS message = new MessageIOS();
		message.setExpireTime(86400);
		message.setAlert(content);
		message.setBadge(1);
		message.setSound("beep.wav");
		JSONObject ret = iosXinge.pushAccountList(0, accountList, message, XingeApp.IOSENV_DEV);
//		JSONObject ret = iosXinge.pushAccountList(0, accountList, message, XingeApp.IOSENV_PROD);//开发
		return (ret);
	}*/
	
	//下发安卓单个账号
	public static JSONObject pushSingleAccount(String account,String title,String content,Map<String, Object> custom) {
		int notificationId = (int) (Math.random() * 10000);
		custom.put("notificationId", String.valueOf(notificationId));
		Message message = new Message();
		message.setTitle(title);
		message.setType(Message.TYPE_NOTIFICATION);
		Style m_style = new Style(0,1,1,1,1);
		m_style.setSmallIcon("ic_launcher_s");
		m_style.setIconRes("ic_launcher_n");
		message.setStyle(m_style);
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_ACTIVITY);
//		action.setActivity("cn.orange.maintenance.MessageDetailActivity");
		message.setAction(action);
		message.setCustom(custom);
		message.setContent(content);
		//极光
//		JpushClientUtil.sendTo(title, title, content, String.valueOf(notificationId), account);
		try {
			Result result = XiaoMiPush.sendMessageToAlias(content, title, content, account,String.valueOf(notificationId));
			System.out.println("result->" + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject ret = androidXinge.pushSingleAccount(0, account, message);
		return (ret);
	}
	/**
	 * 派工端
	 * @param account
	 * @param title
	 * @param content
	 * @param custom
	 * @return
	 */
	public static JSONObject pushSingleAccount1(String account,String title,String content,Map<String, Object> custom) {
		
		Message message = new Message();
		message.setTitle(title);
		message.setType(Message.TYPE_NOTIFICATION);
		Style m_style = new Style(0,1,1,1,1);
		m_style.setSmallIcon("ic_launcher_s");
		m_style.setIconRes("ic_launcher_n");
		message.setStyle(m_style);
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_ACTIVITY);
//		action.setActivity("cn.orange.maintenance.MessageDetailActivity");
		message.setAction(action);
		message.setCustom(custom);
		message.setContent(content);
		
		JSONObject ret = androidXinge1.pushSingleAccount(0, account, message);
		return (ret);
	}
	
	/**
	 * 客户端
	 * @param account
	 * @param title
	 * @param content
	 * @param custom
	 * @return
	 */
	public static JSONObject pushSingleAccount2(String account,String title,String content,Map<String, Object> custom) {
		
		Message message = new Message();
		message.setTitle(title);
		message.setType(Message.TYPE_NOTIFICATION);
		Style m_style = new Style(0,1,1,1,1);
		m_style.setSmallIcon("ic_launcher_s");
		m_style.setIconRes("ic_launcher_n");
		message.setStyle(m_style);
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_ACTIVITY);
//		action.setActivity("cn.orange.maintenance.MessageDetailActivity");
		message.setAction(action);
		message.setCustom(custom);
		message.setContent(content);
		
		JSONObject ret = androidXinge2.pushSingleAccount(0, account, message);
		return (ret);
	}
	
	//下发多个账号
/*	public static JSONObject pushAccountList(String title,String content,List<String> accountList,Map<String, Object> custom) {
		
		Message message = new Message();
		message.setTitle(title);
		message.setType(Message.TYPE_NOTIFICATION);
		Style m_style = new Style(0,1,1,1,1);
		m_style.setSmallIcon("ic_launcher_s");
		m_style.setIconRes("ic_launcher_n");
		message.setStyle(m_style);
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_ACTIVITY);
		//action.setActivity("com.renrun.wdzl.activity.MainActivity");
		message.setAction(action);
		message.setType(Message.TYPE_NOTIFICATION);
		message.setCustom(custom);
		message.setContent(content);
		
		JSONObject ret = androidXinge.pushAccountList(0, accountList, message);
		return (ret);
	}*/
	
	//下发所有设备
	public static void pushAllDevice(String content,Map<String, Object> custom)
	{
		TimeInterval acceptTime = new TimeInterval(0,0,23,59);
		Message message = new Message();
		message.setTitle("小棉袄");
		message.setType(Message.TYPE_NOTIFICATION);
		Style m_style = new Style(0,1,1,1,1);
		m_style.setSmallIcon("ic_launcher_s");
		m_style.setIconRes("ic_launcher_n");
		message.setStyle(m_style);
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_ACTIVITY);
//		action.setActivity("com.huajian.xiaomianao.activity.MyMessageDetailActivity");
		message.setAction(action);
		message.setCustom(custom);
		message.setContent(content);
		JSONObject retAndroid = androidXinge.pushAllDevice(0, message);
		System.out.println(retAndroid);
		
//		MessageIOS messageIos = new MessageIOS();
//		messageIos.setExpireTime(86400);
//		messageIos.setAlert(content);
//		messageIos.setBadge(0);
//		messageIos.setSound("beep.wav");
//		messageIos.addAcceptTime(acceptTime);
//		messageIos.setCustom(custom);
//		JSONObject retIos = iosXinge.pushAllDevice(0, messageIos, XingeApp.IOSENV_DEV);
//		JSONObject retIos = iosXinge.pushAllDevice(0, messageIos, XingeApp.IOSENV_PROD);//生产
//		System.out.println(retIos);
	}

	public static void main(String[] args) {
		//XGPushUtil.pushAllDevice("上的发生发送", null);
		
		//发单个安卓
//		JSONObject obj = XGPushUtil.pushSingleAccount("53", "兔子售后", "推送啊啊啊啊啊啊",null);
//		JSONObject obj = XGPushUtil.pushSingleAccount("8F57C12F06912DC0FD51F8B150A8064A", "!!!", "!!!",null);
		
//		XGPushUtil.pushAllDevice("收到了吗!!!",null);		
//		
//		System.out.println(obj);	
		
		//发单个IOS
//		XGPushUtil.pushSingleAccountIOS(null, "15556531599", "没有");	
		System.out.println(XGPushUtil.pushSingleAccountIOS(null, "08", "推送测试中"+StringUtil.formatDate(new Date())));
	}
}
