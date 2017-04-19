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
 * 群黑
 */
var login = lwsdk.login;
var pay = lwsdk.pay;

lwsdk.login = extendsLogin;
lwsdk.pay = extendsPay;

function extendsLogin(callback) {
	lwsdk.account.game = lwsdk.game;
	lwsdk.account.channel = lwsdk.channel;
	lwsdk.account.auth.identifier = getUrlParam('username'); // 用户ID
	lwsdk.account.auth.credential = "";
	lwsdk.account.extra = {
		"username" : getUrlParam('username'),
		"serverid" : getUrlParam('serverid'),
		"time" : getUrlParam('time'),
		"isadult" : getUrlParam('isadult'),
		"uimg" : getUrlParam('uimg'),
		"nname" : getUrlParam('nname'),
		"unid" : getUrlParam('unid'),
		"flag" : getUrlParam('flag')
	};
	login.apply(lwsdk, [ callback ]);
}

function extendsPay(item, callback) {
	lwsdk.order.game = lwsdk.game;
	lwsdk.order.channel = lwsdk.channel;
	lwsdk.order.item = item;
	lwsdk.order.openId = lwsdk.account.auth.identifier;

	console.log("-----" + lwsdk.account.auth.identifier);
	HttpRequest(lwsdk.URL.PAY + "create", "POST", JSON.stringify(lwsdk.order),
			function(xmlHttp) {
				if (xmlHttp.status == 200) {
					var res = JSON.parse(xmlHttp.responseText);
				}
			});
	pay.apply(lwsdk, [ callback ]);
}
