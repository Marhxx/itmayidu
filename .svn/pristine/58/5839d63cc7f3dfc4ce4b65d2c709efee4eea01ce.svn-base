<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.p:BEFORE {
	content: "(" attr(href) ")";
}

.shortselect {
	background: #fafdfe;
	height: 28px;
	width: 180px;
	line-height: 28px;
	border: 1px solid #9bc0dd;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}

.select {
	width: 80px;
	height: 24px;
	background: #fafdfe;
	border: none;
}

#sleHid {
	display: block;
	width: 60px;
	overflow: hidden;
}

#sleBG {
	width: 78px;
	height: 24px;
	border: #61AC36 1px solid;
	border-right: none;
	background: url("static/down.png") #fff no-repeat 62px 1px;
	display: block;
}
</style>
</head>
<body>

	/*消息列表*/
	<form
		action="message/messageList?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		账号id:<input type="text" name="tmId" style="text-align: center;"><br>
		<!--  消息类型:<input type="text" name="type" style="text-align: center;"><br> -->
		page(第几页):<input type="text" name="page" style="text-align: center;"><br>
		pageSize(每页数量):<input type="text" name="pageSize"
			style="text-align: center;"><br> <input type="submit" />
	</form>
	<br> /*删除消息*/
	<form
		action="message/delMessage?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		接收人ID:<input type="text" name="tmId" style="text-align: center;"><br>
		messageId消息id:<input type="text" name="messageId"
			style="text-align: center;">多个以，拼接<br> <input
			type="submit" />
	</form>
	<br> /*消息详情*/
	<form
		action="message/messageDetail?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		消息id:<input type="text" name="messageId" style="text-align: center;">
		<input type="submit" />
	</form>
	<br> /*获取验证码*/
	<form
		action="vcode/get?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		手机号:<input type="text" name="phone" style="text-align: center;"><br>
		验证码类型: 1：注册2：忘记密码,登录,切换绑定旧手机号3:切换绑定新手机号 <input type="text" name="type"
			style="text-align: center;"><br> <input type="submit" />
	</form>
	<br> /*验证验证码*/
	<form
		action="tbMemberInfo/check?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		手机号:<input type="text" name="loginUser" style="text-align: center;"><br>
		验证码 <input type="text" name="vcode" style="text-align: center;"><br>
		<input type="submit" />
	</form>
	<br>
	<br> /*资讯列表*/
	<form
		action="information/list?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		分类id:<input type="text" name="cataId" style="text-align: center;"><br>
		page(第几页):<input type="text" name="page" style="text-align: center;"><br>
		pageSize(每页数量):<input type="text" name="pageSize"
			style="text-align: center;"><br> <input type="submit" />
	</form>
	<br> /*资讯详情*/
	<form
		action="information/detail?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		快报id:<input type="text" name="tiId" style="text-align: center;">
		<input type="submit" />
	</form>
	<br> /*版本更新*/
	<form
		action="version/app?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		type:<input type="text" name="type" style="text-align: center;">
		<input type="submit" />
	</form>
	<br> /*数据字典*/
	<form
		action="words/list?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		twcode(01：银行 02：年龄):<input type="text" name="twcode"
			style="text-align: center;"> <input type="submit" />
	</form>
	<br> /*省列表*/
	<form
		action="region/provice/list?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		<input type="submit" />
	</form>
	<br> /*市列表*/
	<form
		action="region/city/list?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		省ID:<input type="text" name="pid" style="text-align: center;">
		<input type="submit" />
	</form>
	<br> /*区列表*/
	<form
		action="region/county/list?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		市ID:<input type="text" name="cid" style="text-align: center;">
		<input type="submit" />
	</form>
	<br> /*根据城市名称或城市id获取城市*/
	<form
		action="region/search_city?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		市ID:<input type="text" name="cid" style="text-align: center;"><br>
		市名称:<input type="text" name="name" style="text-align: center;"><br>
		<input type="submit" />
	</form>
	<br> /*上传文件*/
	<form
		action="add_file?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post" enctype="multipart/form-data">
		文件（包括音频，图片等）:<input type="file" name="file"
			style="text-align: center;"> <input type="submit" />
	</form>
	<!-- <br> /*上传文件至阿里云服务器*/
	<form action="add_file_aliyun?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1" method="post" enctype="multipart/form-data">
		文件（包括音频，图片等）:<input type="file" name="uploadFile" style="text-align: center;"> 
		<input type="submit" />
	</form> -->
	<br> /*广告列表*/
	<form
		action="advertise/list?key=z1zkey&code=MTJCNDgyOTIxOTk4QjUzQzM2QTlFN0ZFMzY0MDNEMjQ=&requestCode=-1"
		method="post">
		广告板块id:<input type="text" name="tacCataId" style="text-align: center;"><br>
		page(第几页):<input type="text" name="page" style="text-align: center;"><br>
		pageSize(每页数量):<input type="text" name="pageSize"
			style="text-align: center;"><br> <input type="submit" />
	</form>
	</html>