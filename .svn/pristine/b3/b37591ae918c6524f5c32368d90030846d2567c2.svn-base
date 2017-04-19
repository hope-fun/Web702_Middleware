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
 *  就醬玩 SDK
 */
var login = lwsdk.login;
var pay = lwsdk.pay;
lwsdk.login = extendsLogin;
lwsdk.pay = extendsPay;
var flag = false;
var onLogin = null;
var _callback = null; (function() {
	lwsdk.account.game = lwsdk.game;
	lwsdk.account.channel = lwsdk.channel;
	HttpRequest(lwsdk.URL.GAME, "POST", JSON.stringify(lwsdk.account),
	function(xmlHttp) {
		if (xmlHttp.status == 200) {
			var res = JSON.parse(xmlHttp.responseText);
			clientId = res.factoryServiceId;
			console.log("----------" + clientId);
			window.h5playAsyncInit = function() {
//				console.log('111111111111111');
				H5PLAYSDK.init({
					client_id: clientId,
				});
				//                      console.log("zhujun: chu shi hua hui diao ! ");
				if (onLogin != null) {
					//                      	console.log("zhujun: chu shi hua chi, wei tuo diao yong login ! ");
					onLogin(_callback);
				}
				flag = true;
			};

			(function(d, id) {
				var js, hjs = d.getElementsByTagName('script')[0];
				if (d.getElementById(id)) {
					return;
				}
//				js = d.createElement('script');
//				js.id = id;
//				js.setAttribute("data-main", "http://h5play.com.tw/sdk/main");
//				js.src = "http://h5play.com.tw/sdk/require.min.js";
				if (lwsdk.account.game == 11) {
					js = d.createElement('script');
					js.id = id;
					js.setAttribute("data-main", "http://test.h5play.com.tw/sdk/main");
					js.src = "http://test.h5play.com.tw/sdk/require.min.js";
				} else{
					js = d.createElement('script');
					js.id = id;
					js.setAttribute("data-main", "http://h5play.com.tw/sdk/main");
					js.src = "http://h5play.com.tw/sdk/require.min.js";
				}
				hjs.parentNode.insertBefore(js, hjs);
			} (document, 'h5play-jssdk'));
		}
	});
})()

function extendsLogin(callback) {
	_callback = callback;
	//相關JS SDK接口呼叫必須置放於此處
//	console.log('33333333333333');
	onLogin = function(_bCallback) {
		// console.log("zhujun: chu shi hua chi, wei tuo diao yong login ! ");
		H5PLAYSDK.getLoginStatus({
			token: ""
		},
		function(response) {
			console.log(response);
			if(response==10001 || response=="10001") return;
			lwsdk.account.game = lwsdk.game;
			lwsdk.account.channel = lwsdk.channel;
			lwsdk.account.auth.identifier = response.user.account; // 用户ID
			// lwsdk.account.auth.identifier = '123';// 用户ID
			lwsdk.account.auth.credential = "";
			console.log("123" + response);
			lwsdk.account.extra = {
				"account": response.user.account,
				"token": response.user.token,
				//"account":'123',
				//"token" : '456',
			};
			console.log("-----" + lwsdk.account.extra.token);
			login.apply(lwsdk, [_bCallback]);
			console.log(response);
		});

	};

	if (flag) {
//		console.log("zhujun: chu shi hua zao , zheng chan diao yong login !  ");
		onLogin(_callback);
	}
}

function extendsPay(item, callback) {
	lwsdk.order.game = lwsdk.game;
	lwsdk.order.channel = lwsdk.channel;
	lwsdk.order.item = item;
	lwsdk.order.openId = lwsdk.account.auth.identifier;
	console.log("-----" + lwsdk.account.auth.identifier);
//	receipt_data 
	HttpRequest(lwsdk.URL.PAY + "create", "POST", JSON.stringify(lwsdk.order),
	function(xmlHttp) {
		if (xmlHttp.status == 200) {
			var res = JSON.parse(xmlHttp.responseText);
			console.log(res.orderId);
			H5PLAYSDK.pay.purchase({
				token: lwsdk.account.extra.token,
				//用戶資料接口得到的 token
				server_id: "1",
				product_id: lwsdk.order.item.id,
				//商品ID
				quantity: lwsdk.order.item.count,
				//商品数量
				notify_url: "actcis.h5play.com.tw/api/pay/callback/8",
				payload: res.orderId
			},
			function(response) {

				lwsdk.account.extra = {
					"payment_url": response.payment.payment_url,
					"transaction_id": response.payment.transaction_id //
				};
				location.href = response.payment.payment_url; //跳转带支付地址
				console.log(response);
			});
		}
	});
}
