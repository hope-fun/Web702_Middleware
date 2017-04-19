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
 * Forgame SDK
 * WebSite <a href="http://h5.91wan.com/">Forgame</a>
 */
loadjs("http://h5.91wan.com/js/7wanwansdk.js");
var login = lwsdk.login;
var pay   = lwsdk.pay;

lwsdk.login = extendsLogin;
lwsdk.pay 	= extendsPay;

function extendsLogin(callback) {
	var gameId = "";
	lwsdk.account.game = lwsdk.game;
	lwsdk.account.channel = lwsdk.channel;
	HttpRequest(lwsdk.URL.GAME, "POST", JSON.stringify(lwsdk.account), function(xmlHttp) {
		if (xmlHttp.status == 200) {
			var res = JSON.parse(xmlHttp.responseText);
			gameId = res.factoryServiceId;
			console.log("----------"+gameId);
			quwanwansdk.getLoginInfo({
				game_id : gameId,
				server_id : 0,
				callFunc : function(response) {
					lwsdk.account.game = lwsdk.game;
					lwsdk.account.channel = lwsdk.channel;
					lwsdk.account.auth.identifier = response.uid;
					lwsdk.account.auth.credential = "";
					lwsdk.account.extra = {
						"uid" : response.uid, 			 // 平台uid
						"sid" : response.sid, 			 // 平台sid
						"userName" : response.user_name, // 平台user_name
						"nickName" : response.nick_name	 // 平台nick_name
					};
					login.apply(lwsdk,[callback]);
				}
			});
		}
	});
}

function extendsPay(item,callback) {
	lwsdk.order.game = lwsdk.game;
	lwsdk.order.channel = lwsdk.channel;
	lwsdk.order.item = item;
	lwsdk.order.openId = lwsdk.account.auth.identifier;
	HttpRequest(lwsdk.URL.PAY+"create", "POST", JSON.stringify(lwsdk.order), function(xmlHttp) {
		if (xmlHttp.status == 200) {
			var res = JSON.parse(xmlHttp.responseText);
			quwanwansdk.pay({
		         "token": res.token,
		         "sign": res.sign,
		         "callFunc": function(status, msg) {
		             if(status == "success") {
		                 console.log("支付成功");
		                 window.location.reload();
		             } else {
		                 console.log("支付失败：" + msg);
		             }
		         }
		     });      
		}
	});
}
