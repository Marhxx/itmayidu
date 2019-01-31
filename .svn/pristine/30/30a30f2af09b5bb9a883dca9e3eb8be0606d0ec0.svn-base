package com.spring.api.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
	


import org.json.JSONObject;

import com.spring.base.utils.StringUtil;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.Style;
import com.tencent.xinge.TimeInterval;
import com.tencent.xinge.XingeApp;


public class XGPushUtil {
	//IOS客户端
	public static final long IOS_APP_KEY1 = 2200282200L;
	public static final String IOS_ACCESS_KEY1 = "IF5HG258LY7D";
	public static final String IOS_SECRET_KEY1 = "9deb8a7ae72e79576032355eedb2fc14";
	
	//IOS跑男端
	public static final long IOS_APP_KEY2 = 2200282237L;
	public static final String IOS_ACCESS_KEY2 = "IN4EJ1592EZG";
	public static final String IOS_SECRET_KEY2 = "767d34dd570e717847f2a0d11444c5bf";
	
	static XingeApp iosXinge1,iosXinge2;
	static{
		iosXinge1 = new XingeApp(IOS_APP_KEY1, IOS_SECRET_KEY1);
		iosXinge2 = new XingeApp(IOS_APP_KEY2, IOS_SECRET_KEY2);
	}

	/**
	 * 下发IOS单个账号 接单端
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
		JSONObject ret = iosXinge1.pushSingleAccount(0, account, message, XingeApp.IOSENV_DEV);//生产
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
		JSONObject ret = iosXinge2.pushSingleAccount(0, account, message, XingeApp.IOSENV_DEV);//生产
		return (ret);
	}
	
	protected static JSONObject demoQueryTokensOfAccount() {
        JSONObject ret = iosXinge2.queryTokensOfAccount("419");
        return ret;
    }
	
	 protected static JSONObject demoQueryInfoOfToken() {
        JSONObject ret = iosXinge2.queryInfoOfToken("f71d8d1a9d98f15fe74f28d12ef47eaa86c384d68ed4afe7da3747e82fc5c274");
        return ret;
    }

	//删除某个account绑定的token
    protected static JSONObject demoDeleteTokenOfAccount() {
        JSONObject ret = iosXinge2.deleteTokenOfAccount("419", "57b4afa85eca7db13f198f3ad801cb66fbf782a08e93ccf44ecc0be4e2f69daf");
        return ret;
    }
	
	/**
	 * 单个设备静默通知(iOS7以上)跑男
	 * @return
	 */
    public static JSONObject demoPushSingleDeviceMessageIOS2(Map<String, Object> custom,String account,String content) {
		MessageIOS message = new MessageIOS();
		message.setExpireTime(86400);
		//message.setAlert(content);
		message.setBadge(1);
		message.setCustom(custom);
		//message.setSound("beep.wav");
		message.setType(MessageIOS.TYPE_REMOTE_NOTIFICATION);
		return iosXinge2.pushSingleAccount(0, account, message, XingeApp.IOSENV_DEV);
//        return iosXinge2.pushSingleDevice(account, message, XingeApp.IOSENV_DEV);
	}
    
    public static JSONObject demoPushSingleDeviceMessageIOS1(Map<String, Object> custom,String account,String content) {
		MessageIOS message = new MessageIOS();
		message.setExpireTime(86400);
		//message.setAlert(content);
		message.setBadge(1);
		message.setCustom(custom);
		//message.setSound("beep.wav");
		message.setType(MessageIOS.TYPE_REMOTE_NOTIFICATION);
		return iosXinge1.pushSingleAccount(0, account, message, XingeApp.IOSENV_DEV);
//        return iosXinge2.pushSingleDevice(account, message, XingeApp.IOSENV_DEV);
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
	
	/*//下发所有设备
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
	}*/

	public static void main(String[] args) {
		//XGPushUtil.pushAllDevice("上的发生发送", null);
		
		//发单个安卓
//		JSONObject obj = XGPushUtil.pushSingleAccount("53", "兔子售后", "推送啊啊啊啊啊啊",null);
//		JSONObject obj = XGPushUtil.pushSingleAccount("8F57C12F06912DC0FD51F8B150A8064A", "!!!", "!!!",null);
		
//		XGPushUtil.pushAllDevice("收到了吗!!!",null);		
//		
//		JSONObject obj = XGPushUtil.pushSingleAccount1("192", "兔子", "推送啊啊啊啊啊啊"+StringUtil.formatDate6(new Date()),null);
//		System.out.println(obj);	
		
		//发单个IOS
//		XGPushUtil.pushSingleAccountIOS(null, "15556531599", "没有");	
		//System.out.println(XGPushUtil.pushSingleAccountIOS2(null, "419", "测试推送"+StringUtil.formatDate6(new Date())));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("测试", "测试透传");
		//System.out.println(XGPushUtil.demoPushSingleDeviceMessageIOS(map, "419", "测试透传推送"+StringUtil.formatDate6(new Date())));
		//System.out.println(demoPushSingleDeviceMessageIOS());
		//System.out.println(demoDeleteTokenOfAccount());
	}
}
