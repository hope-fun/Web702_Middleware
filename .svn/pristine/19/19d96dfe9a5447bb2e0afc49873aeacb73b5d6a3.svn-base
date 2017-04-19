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
 * Play68 SDK
 * WebSite <a href="http://www.play68.com//">68微游戏</a>
 */
loadjs("http://static.play68.com/js/play68_sdk.js", null);
var login = lwsdk.login;
var pay   = lwsdk.pay;
lwsdk.login = extendsLogin;
lwsdk.pay 	= extendsPay;

function extendsLogin(callback) {
	var openId = getUrlParam("openid");//获取68分配的用户ID
		lwsdk.account.game = lwsdk.game;
		lwsdk.account.channel = lwsdk.channel;
		lwsdk.account.auth.identifier = openId;//将用户ID给identifier
		lwsdk.account.auth.credential = "";
		login.apply(lwsdk,[callback]);
}

function extendsPay(item, callback) {
	lwsdk.order.game = lwsdk.game;
	lwsdk.order.channel = lwsdk.channel;
	lwsdk.order.item = item;
	lwsdk.order.openId = lwsdk.account.auth.identifier;
	HttpRequest(lwsdk.URL.PAY+"create", "POST", JSON.stringify(lwsdk.order), function(xmlHttp) {
		if (xmlHttp.status == 200) {
			var res = JSON.parse(xmlHttp.responseText);
			Play68.pay(item.id + "_" + res.orderId, item.name,item.price,item.count,"",res.skey);
			Play68.onpaysucc(function() {
				window.location.reload();
			});
		}
	});
	console.log("Extends Pay Function...");
}
