package com.spring.api.config;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;
import com.xiaomi.xmpush.server.TargetedMessage;
/**
 * 跑男端小米推送
 * @author Administrator
 *
 */
public class MiPushUtil2 {

	public static String APP_SECRET_KEY = "CvVleiHGkJ1TSKMNYvig6Q==";
	public static String MY_PACKAGE_NAME = "com.hjtech.feifei.male";
	
	public static void main(String[] args) {
		MiPushUtil2 mpUtil=new MiPushUtil2();
		try {
			mpUtil.sendMessages(""+"", "", "您有一条新的消息", "");
			System.out.println("推送成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("推送失败");
		}
	}
	
	
	private Result sendMessage(String regId) throws Exception {
	     Constants.useOfficial();
	     Sender sender = new Sender(APP_SECRET_KEY);
	     String messagePayload= "This is a message";
	     String title = "notification title";
	     String description = "notification description";
	     Message message = new Message.Builder()
	                .title(title)
	                .description(description).payload(messagePayload)
	                .restrictedPackageName(MY_PACKAGE_NAME)
	                .notifyType(1)     // 使用默认提示音提�?
	                .build();
	     Result result = sender.send(message, regId, 0); //根据regID，发送消息到指定设备上，不重试�??
	     return result;
	}
	
	
	
	/**
	 * 发送消息的，根据会员id
	 * @param userId
	 * @param messagePayload1
	 * @param title1
	 * @param description1
	 * @return
	 * @throws Exception
	 */
	public Result sendMessages(String userId,String messagePayload1,String title1,String description1) throws Exception {
	     Constants.useOfficial();
	     Sender sender = new Sender(APP_SECRET_KEY);
	     List<TargetedMessage> messages = new ArrayList<TargetedMessage>();
	     TargetedMessage targetedMessage1 = new TargetedMessage();
	     targetedMessage1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, userId);
	     Message message1 = new Message.Builder()
	                .title(title1)
	                .description(description1).payload(messagePayload1)
	                .restrictedPackageName(MY_PACKAGE_NAME)
	                .notifyType(1)     // 使用默认提示音提�?
	                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_LAUNCHER_ACTIVITY)
	                .build();
	     targetedMessage1.setMessage(message1);
	     messages.add(targetedMessage1);
	     Result result = sender.send(messages, 0); //根据alias，发送消息到指定设备上，不重试�??
	     return result;
	}

	/**
	 * 发送消息的，根据会员id
	 * @param userId
	 * @param messagePayload1
	 * @param title1
	 * @param description1
	 * @return
	 * @throws Exception
	 */
	public Result sendMessagesSkip(String userId,String messagePayload1,String title1,String description1) throws Exception {
	     Constants.useOfficial();
	     Sender sender = new Sender(APP_SECRET_KEY);
	     List<TargetedMessage> messages = new ArrayList<TargetedMessage>();
	     TargetedMessage targetedMessage1 = new TargetedMessage();
	     targetedMessage1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, userId);
	     Message message1 = new Message.Builder()
	                .title(title1)
	                .description(description1).payload(messagePayload1)
	                .restrictedPackageName(MY_PACKAGE_NAME)
	                .notifyType(1)     // 使用默认提示音提�?
	                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT,Constants.NOTIFY_ACTIVITY)
	                .extra(Constants.EXTRA_PARAM_INTENT_URI,"intent:#Intent;component=com.hjtech.feifei.male/.main.activity.MainActivity;end")
	                .build();
	     targetedMessage1.setMessage(message1);
	     messages.add(targetedMessage1);
	     Result result = sender.send(messages, 0); //根据alias，发送消息到指定设备上，不重试�??
	     return result;
	}
	
	
	public Result sendMessagesTouChuan(String userId,String messagePayload1,String title1,String description1) throws Exception {
	     Constants.useOfficial();
	     Sender sender = new Sender(APP_SECRET_KEY);
	     List<TargetedMessage> messages = new ArrayList<TargetedMessage>();
	     TargetedMessage targetedMessage1 = new TargetedMessage();
	     targetedMessage1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, userId);
	     Message message1 = new Message.Builder()
	                .title(title1)
	                .description(description1).payload(messagePayload1)
	                .restrictedPackageName(MY_PACKAGE_NAME)
	                .notifyType(1)     // 使用默认提示音提�?
	                .passThrough(1)
	                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT,Constants.NOTIFY_ACTIVITY)
	                .extra(Constants.EXTRA_PARAM_INTENT_URI,"intent:#Intent;component=com.hjtech.feifei.male/.main.activity.MainActivity;end")
	                .build();
	     targetedMessage1.setMessage(message1);
	     messages.add(targetedMessage1);
	     Result result = sender.send(messages, 0); //根据alias，发送消息到指定设备上，不重试�??
	     return result;
	}
	
	
	private Message buildMessage() throws Exception {
	    String PACKAGENAME = "com.xiaomi.mipushdemo";
	    String messagePayload = "This is a message";
	    String title = "notification title";
	    String description = "notification description";
	    Message message = new Message.Builder()
	            .title(title)
	            .description(description).payload(messagePayload)
	            .restrictedPackageName(MY_PACKAGE_NAME)
	            .passThrough(0)  //消息使用通知栏方式
	            .notifyType(1)
	            .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_LAUNCHER_ACTIVITY)
	            .build();
	    return message;
	}

	private void sendMessageToAlias() throws Exception {
	     Constants.useOfficial();
	     Sender sender = new Sender(APP_SECRET_KEY);
	     String messagePayload = "This is a message";
	     String title = "notification title";
	     String description = "notification description";
	     String alias = "testAlias";    //alias非空白，不能包含逗号，长度小�?128�?
	     Message message = new Message.Builder()
	                .title(title)
	                .description(description).payload(messagePayload)
	                .restrictedPackageName(MY_PACKAGE_NAME)
	                .notifyType(1)     // 使用默认提示音提�?
	                .build();
	     sender.sendToAlias(message, alias, 0); //根据alias，发送消息到指定设备上，不重试�??
	}

	private void sendMessageToAliases() throws Exception {
	     Constants.useOfficial();
	     Sender sender = new Sender(APP_SECRET_KEY);
	     String messagePayload = "This is a message";
	     String title = "notification title";
	     String description = "notification description";
	     List<String> aliasList = new ArrayList<String>();
	     aliasList.add("testAlias1");  //alias非空白，不能包含逗号，长度小�?128�?
	     aliasList.add("testAlias2");  //alias非空白，不能包含逗号，长度小�?128�?
	     aliasList.add("testAlias3");  //alias非空白，不能包含逗号，长度小�?128�?
	     Message message = new Message.Builder()
	                .title(title)
	                .description(description).payload(messagePayload)
	                .restrictedPackageName(MY_PACKAGE_NAME)
	                .notifyType(1)     // 使用默认提示音提�?
	                .build();
	     sender.sendToAlias(message, aliasList, 0); //根据aliasList，发送消息到指定设备上，不重试�??
	}

	private void sendBroadcast() throws Exception {
	     Constants.useOfficial();
	     Sender sender = new Sender(APP_SECRET_KEY);
	     String messagePayload = "This is a message";
	     String title = "notification title";
	     String description = "notification description";
	     String topic = "testTopic";
	     Message message = new Message.Builder()
	                .title(title)
	                .description(description).payload(messagePayload)
	                .restrictedPackageName(MY_PACKAGE_NAME)
	                .notifyType(1)     // 使用默认提示音提�?
	                .build();
	     sender.broadcast(message, topic, 0); //根据topic，发送消息到指定�?组设备上，不重试�?
	}
	

}
