package com.spring.base.util;

import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;

/**
 * 小米推送
 *
 * 2017年5月23日下午2:25:11
 * 
 * @author lcx
 *
 */
public class XiaoMiPush {
	static String AppKey = "5291758218386";
	static String AppSecret = "zCnn5qGsZuIW9nT+Jhq6lA==";
	static String MY_PACKAGE_NAME = "com.hjtech.rabbit.express";// 应用包名物业版

	static String AppKey1 = "5401758391071";
	static String AppSecret1 = "r47F9uTcY1w4QWbjksXy9g==";
	static String MY_PACKAGE_NAME1 = "com.hjtech.rabbit.bussiniss";// 应用包名商户版


	static String AppKey2 = "5241758275827";
	static String AppSecret2 = "GkPU1j5614MrfTBM5qPpAA==";
	static String MY_PACKAGE_NAME2 = "com.hjtech.rabbitpaotui";// 应用包名跑腿端


	static String AppKey3 = "5981758241504";
	static String AppSecret3 = "W1OE4S2zOlCxU0aprIOOeA==";
	static String MY_PACKAGE_NAME3 = "com.hjtech.rabbitaftersale";// 应用包名服务版


	// private void sendMessage() throws Exception {
	// Constants.useOfficial();
	// Sender sender = new Sender("5401757924489");
	// String AppKey = "5401757924489";
	// String AppSecret = "E8jpNFhEl6+cx5/gorJM1Q==";
	// String regId = "E8jpNFhEl6+cx5/gorJM1Q==";
	// String PACKAGENAME = "cn.orange.dispatch";
	// String messagePayload = "This is a message";
	// String title = "notification title";
	// String description = "notification description";
	// Message message = new Message.Builder()
	// .title(title)
	// .description(description).payload(messagePayload)
	// .restrictedPackageName(PACKAGENAME)
	// .notifyType(1) // 使用默认提示音提示
	// .build();
	// Result result = sender.send(message, regId, 3);
	// Log.v("Server response: ", "MessageId: " + result.getMessageId()
	// + " ErrorCode: " + result.getErrorCode().toString()
	// + " Reason: " + result.getReason());
	// }
	// private static Message buildMessage() throws Exception {
	// String PACKAGENAME = "cn.orange.dispatch";
	// String messagePayload = "This is a message";
	// Message message = new Message.Builder()
	// .payload(messagePayload)
	// .restrictedPackageName(PACKAGENAME)//设置app的包名packageName,
	// packageName必须和开发者网站上申请的结果一致
	// .passThrough(0) // 消息使用透传方式 0表示通知栏消息(默认是通知栏消息)
	// .notifyType(1) // 使用默认提示音提示
	// .build();
	// return message;
	// }

	/**
	 * 
	 * @param messagePayload
	 *            设置要发送的消息内容payload, 不允许全是空白字符, 长度小于4K, 一个中英文字符均计算为1(透传消息回传给APP,
	 *            为必填字段, 非透传消息可选)
	 * @param title
	 *            设置在通知栏展示的通知的标题, 不允许全是空白字符, 长度小于16, 一个中英文字符均计算为1(通知栏消息必填)
	 * @param description
	 *            设置在通知栏展示的通知描述, 不允许全是空白字符, 长度小于128, 一个中英文字符均计算为1(通知栏消息必填)
	 * @param useraccount
	 *            根据account, 发送消息到指定account上, account不允许全是空白字符, 不能包含逗号, 长度小于128,
	 *            中英文均以一个计算
	 * @return
	 * @throws Exception
	 */
	public static Result sendMessageToUserAccount(String messagePayload,
			String title, String description, String useraccount)
			throws Exception {
		Constants.useOfficial();
		String APP_SECRET_KEY = AppSecret;
		Sender sender = new Sender(APP_SECRET_KEY);
		// String messagePayload = “This is a message”;
		// String title = “notification title”;
		// String description = “notification description”;
		// String useraccount = “testUserAccount”; //useraccount非空白, 不能包含逗号,
		// 长度小于128
		Message message = new Message.Builder().title(title)
				.description(description).payload(messagePayload)
				.restrictedPackageName(MY_PACKAGE_NAME)
				.passThrough(0)
				// 消息使用透传方式 0表示通知栏消息(默认是通知栏消息)
				.notifyType(1)
				// 使用默认提示音提示
				.extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT,
						Constants.NOTIFY_LAUNCHER_ACTIVITY).build();
		return sender.sendToUserAccount(message, useraccount, 3); // 根据useraccount,
																	// 发送消息到指定设备上
	}
	/**
	 * 物业版
	 * @param messagePayload
	 * @param title
	 * @param description
	 * @param alias
	 * @param notificationId
	 * @throws Exception
	 */
	public static Result sendMessageToAlias(String messagePayload, String title,
			String description, String alias,String notificationId) throws Exception {
		Constants.useOfficial();
		Sender sender = new Sender(AppSecret);
		// alias非空白, 不能包含逗号, 长度小于128
		Message message = new Message.Builder().title(title)
				.description(description).payload(messagePayload)
				.restrictedPackageName(MY_PACKAGE_NAME)
				.notifyType(1)
				// 使用默认提示音提示
				// 开启/关闭(1/0)
//				.extra(Constants.EXTRA_PARAM_NOTIFY_FOREGROUND, "0")
				.extra("notificationId", notificationId).build();
		return sender.sendToAlias(message, alias, 3); // 根据alias, 发送消息到指定设备上
	}

	/**
	 * 商户版
	 * @param messagePayload
	 * @param title
	 * @param description
	 * @param alias
	 * @param notificationId
	 * @return
	 * @throws Exception
	 */
	public static Result sendMessageToAlias1(String messagePayload, String title,
											String description, String alias,String notificationId) throws Exception {
		Constants.useOfficial();
		Sender sender = new Sender(AppSecret1);
		// alias非空白, 不能包含逗号, 长度小于128
		Message message = new Message.Builder().title(title)
				.description(description).payload(messagePayload)
				.restrictedPackageName(MY_PACKAGE_NAME1)
				.notifyType(1)
				// 使用默认提示音提示
				// 开启/关闭(1/0)
//				.extra(Constants.EXTRA_PARAM_NOTIFY_FOREGROUND, "0")
				.extra("notificationId", notificationId).build();
		return sender.sendToAlias(message, alias, 3); // 根据alias, 发送消息到指定设备上
	}

	/**
	 * 跑腿端
	 * @param messagePayload
	 * @param title
	 * @param description
	 * @param alias
	 * @param notificationId
	 * @return
	 * @throws Exception
	 */
	public static Result sendMessageToAlias2(String messagePayload, String title,
											 String description, String alias,String notificationId) throws Exception {
		Constants.useOfficial();
		Sender sender = new Sender(AppSecret2);
		// alias非空白, 不能包含逗号, 长度小于128
		Message message = new Message.Builder().title(title)
				.description(description).payload(messagePayload)
				.restrictedPackageName(MY_PACKAGE_NAME2)
				.notifyType(1)
				// 使用默认提示音提示
				// 开启/关闭(1/0)
//				.extra(Constants.EXTRA_PARAM_NOTIFY_FOREGROUND, "0")
				.extra("notificationId", notificationId).build();
		return sender.sendToAlias(message, alias, 3); // 根据alias, 发送消息到指定设备上
	}

	/**
	 * 服务版
	 * @param messagePayload
	 * @param title
	 * @param description
	 * @param alias
	 * @param notificationId
	 * @return
	 * @throws Exception
	 */
	public static Result sendMessageToAlias3(String messagePayload, String title,
											 String description, String alias,String notificationId) throws Exception {
		Constants.useOfficial();
		Sender sender = new Sender(AppSecret3);
		// alias非空白, 不能包含逗号, 长度小于128
		Message message = new Message.Builder().title(title)
				.description(description).payload(messagePayload)
				.restrictedPackageName(MY_PACKAGE_NAME3)
				.notifyType(1)
				// 使用默认提示音提示
				// 开启/关闭(1/0)
//				.extra(Constants.EXTRA_PARAM_NOTIFY_FOREGROUND, "0")
				.extra("notificationId", notificationId).build();
		return sender.sendToAlias(message, alias, 3); // 根据alias, 发送消息到指定设备上
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(XiaoMiPush.buildMessage());
		// System.out.println(XiaoMiPush.sendMessageToUserAccount("This is a message","notification title","description","166"));
		Result result = XiaoMiPush
				.sendMessageToUserAccount("This is a message",
						"notification title", "description", "166");
		System.out.println("MessageId: " + result.getMessageId()
				+ " ErrorCode: " + result.getErrorCode().toString()
				+ " Reason: " + result.getReason());
		// "Server response: ", "MessageId: " + result.getMessageId()
		// + " ErrorCode: " + result.getErrorCode().toString()
		// + " Reason: " + result.getReason()
	}
}
