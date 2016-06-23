<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
<form action="http://api.ipaynow.cn" METHOD=POST>
功能码：<input type=text name="funcode" value="WP001" readonly/><br>
应用ID:<input type=text name="appId" value="${appId}" readonly/><br>
商户订单号：<input type=text name="mhtOrderNo" value="${mhtOrderNo}" readonly/><br>
商户订单名称：<input type=text name="mhtOrderName" value="${mhtOrderName}" readonly/><br>
币种：<input type=text name="mhtCurrencyType" value="156" readonly/><br>
金额：<input type=text name="mhtOrderAmt" value="${mhtOrderAmt}" readonly/><br>
订单详情：<input type=text name="mhtOrderDetail" value="${mhtOrderDetail}" readonly/><br>
订单类型：<input type=text name="mhtOrderType" value="${mhtOrderType}" readonly/><br>
订单时间：<input type=text name="mhtOrderStartTime" value="${mhtOrderStartTime}" readonly/><br>
后台通知URL：<input type=text name="notifyUrl" value="${notifyUrl}" readonly/><br>
前台通知URL：<input type=text name="frontNotifyUrl" value="${frontNotifyUrl}" readonly/><br>
字符集：<input type=text name="mhtCharset" value="UTF-8" readonly/><br>
设备类型：<input type=text name="deviceType" value="${deviceType}" readonly/><br>
现在支付网关号：<input type=text name="payChannelType" value="${payChannelType}"><br>
商户保留域：<input type=text name="mhtReserved" value="${mhtReserved}"><br>
签名类型：<input type=text name="mhtSignType" value="MD5" readonly/><br>
数字签名：<input type=text name="mhtSignature" value="${mhtSignature}" readonly/><br>

<button type=submit>确认订单</button>
</form>
</body>
</html> 