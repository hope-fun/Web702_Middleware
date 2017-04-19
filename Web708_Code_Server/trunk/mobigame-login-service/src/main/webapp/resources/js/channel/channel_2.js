/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
/**
 * 9G SDK
 * WebSite <a href="http://www.9g.com/">9G游戏</a>
 */
var login = lwsdk.login;
var pay   = lwsdk.pay;
var uid   = null;

var LOGIN_URL = "http://wx.9g.com/open/userinfo?token="; // url+token

lwsdk.login = extendsLogin;
lwsdk.pay 	= extendsPay;

function extendsLogin(callback) {
	var token = getUrlParam("token");
	HttpRequest(LOGIN_URL+token, "GET", null, function(xmlHttp){
		lwsdk.account.game = lwsdk.game;
		lwsdk.account.channel = lwsdk.channel;
		lwsdk.account.auth.identifier = uid = JSON.parse(xmlHttp.responseText).uid;
		lwsdk.account.auth.credential = "";
		login.apply(lwsdk,[callback]);
	});
}

function extendsPay(item, callback) {
	lwsdk.order.game = lwsdk.game;
	lwsdk.order.channel = lwsdk.channel;
	lwsdk.order.item = item;
	HttpRequest(lwsdk.URL.PAY+"create", "POST", JSON.stringify(lwsdk.order), function(xmlHttp) {
		if (xmlHttp.status == 200) {
			console.log("Pay Success...");
			var res = JSON.parse(xmlHttp.responseText);
			var data = {
	            action: "pay",
	            orderid: res.orderId,
	            money: item.price * 100,	//item.price*100, 9G货币单位为分
	            product: item.name,
	            spid: res.spid,
	            sign: res.sign,
	            uid: uid,
	            token: getUrlParam("token")
	        };
	        // 发起支付请求
	        window.parent.postMessage(data, "*");
	        // 响应支付回调
	        window.addEventListener("message",function(e) {
	            if(e.data.action == "pay:callback") {
	                if(e.data.status == 1) {
	                    //alert("支付成功：订单号" + e.data.orderid + "金额" + e.data.money);
	                    //alert("充值成功，即将为您刷新游戏。");
                		window.location.reload();
	                } else {
	                    alert("充值失敗，请联系客服。订单号：" + e.data.orderid);
	                }
	            } else if(e.data.action == "pay:cancel") {
	                alert("支付已取消");
	            }
	        });
	    }
	});
	console.log("Extends Pay Function...");
}
