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
 * 快速登录
 */
var login = lwsdk.login;
var pay   = lwsdk.pay;

lwsdk.login = extendsLogin;
lwsdk.pay 	= extendsPay;

function extendsLogin(callback) {
	lwsdk.account.game = lwsdk.game;
	lwsdk.account.channel = lwsdk.channel;
	lwsdk.account.auth.identifier = localStorage.getItem("uuid") != null ? localStorage.getItem("uuid") : (function(){var uuid = guid();localStorage.setItem("uuid", uuid);return uuid;})();
	lwsdk.account.auth.credential = "";
	lwsdk.account.auth.identityType = "ACCOUNT_AUTH_TYPE_QUICK";
	login.apply(lwsdk,[callback]);
}

function extendsPay(item, callback) {
	lwsdk.order.game = lwsdk.game;
	lwsdk.order.channel = lwsdk.channel;
	lwsdk.order.item = item;
	pay.apply(lwsdk,[callback]);
}
