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
 * IOS
 */
var login = lwsdk.login;
var pay   = lwsdk.pay;
var finishLoading = lwsdk.finishLoading;
var leaderBoard = lwsdk.leaderBoard;
var updateOrder = lwsdk.updateOrder;
var updateCallback;

lwsdk.login = extendsLogin;
lwsdk.pay 	= extendsPay;
lwsdk.finishLoading = extendsFinishLoading;
lwsdk.leaderBoard = extendsLeaderBoard;
lwsdk.updateOrder = extendsUpdateOrder;

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
	updateCallback = callback;
	var func = function(xmlHttp) {
		var res = JSON.parse(xmlHttp.responseText);
		onPurchase(res.orderId,item.id);
	};
	pay.apply(lwsdk,[func]);
}

function extendsFinishLoading() {
	location.href = "uniwebview://FinishLoading";
	finishLoading.apply(lwsdk);
}

function extendsLeaderBoard(key, value) {
	location.href = "uniwebview://LeaderBoard?" + key + "=" + value;
	leaderBoard.apply(lwsdk);
}

function extendsUpdateOrder(orderId, openOrderId) {
	lwsdk.orderStatus.orderId = orderId;
	lwsdk.orderStatus.openOrderId = openOrderId;
	updateOrder.apply(lwsdk,[updateCallback]);
}

// Send purchase message to unity
function onPurchase (orderId, purchaseId){
	location.href = "uniwebview://Purchase?orderId=" + orderId + "&purchaseId=" + purchaseId;
}

// Receive purchase response from unity
function PurchaseCallBackFromUnity(orderId, openOrderId){
	lwsdk.updateOrder(orderId, openOrderId);
}
