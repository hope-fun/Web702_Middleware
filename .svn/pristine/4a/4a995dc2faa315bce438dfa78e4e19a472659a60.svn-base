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
 * Y5平台
 */
var login = lwsdk.login;
var pay   = lwsdk.pay;
lwsdk.login = extendsLogin;
lwsdk.pay 	= extendsPay;

flag = false;
onLogin = null;
_callback = null;

//function GetQueryString(name)
//{
//     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
//     var r = window.location.search.substr(1).match(reg);
//     if(r!=null)return  unescape(r[2]); return null;
//}

(function() {
	lwsdk.account.game = lwsdk.game;
	lwsdk.account.channel = lwsdk.channel;
	HttpRequest(lwsdk.URL.GAME, "POST", JSON.stringify(lwsdk.account),
	function(xmlHttp) {
		if (xmlHttp.status == 200) {
			var res = JSON.parse(xmlHttp.responseText);
			key = res.key;
			console.log("---------------------"+key);
			
			(function(tag, app_id, element_id){
				var new_element, tag_element = document.getElementsByTagName(tag)[0];
				if(document.getElementById(element_id)) return;
				new_element = document.createElement(tag);
				new_element.id = element_id;
				new_element.src = 'https://api.wakool.net/sdk' + '?app_id=' + app_id + '&v=' + Date.now();
				tag_element.parentNode.insertBefore(new_element, tag_element);
			}('script', getUrlParam('app_id'), 'wakool-jssdk'));
			
			window.wakoolAsyncInit = function(wakool){
				window.wakoolSetup = {
					'sign': getUrlParam('sign'),
					'app_id': getUrlParam('app_id')
				};
				
				wakool.addEventListener(wakool.EVENT_BROWSER_PURCHASE_VERIFY_VALID, function(event){
					console.log('succes');
//					…儲值成功…
					window.location.reload();
				});
				wakool.addEventListener(wakool.EVENT_BROWSER_PURCHASE_VERIFY_INVALID, function(event){
					console.log('error');
//					…儲值失敗…
				});
				
				//…註冊 SDK 事件監聽…
				window.wakool = wakool;
				if (onLogin != null) {
					onLogin(_callback);
				}
				flag = true;
				return wakool;
			}
			
		}
	});
	
})()


function extendsLogin(callback) {
	_callback = callback;
	onLogin = function(_bCallback) {
		wakool.login(function(result){
			if(result){
				console.log("login succes");
				//…登入成功…
//				lwsdk.account.game = lwsdk.game;
//				lwsdk.account.channel = lwsdk.channel;
				lwsdk.account.auth.identifier = result.id; // 用户ID
				lwsdk.account.auth.credential = "";
				lwsdk.account.extra = {
					"uid" : result.id, 			 // 平台uid
					"nickName" : result.nickname,	 // 平台nick_name
					"login_key":  getUrlParam('login_key'),
					"app_id": 	getUrlParam('app_id'),
					"user_id": 	getUrlParam('user_id'),
					"sign": 	getUrlParam('sign'),
					"key"	: key
				};
				login.apply(lwsdk,[_bCallback]);
				console.log(result);
			}else{
				//…登入失敗…
				console.log("login error");
			}
		});
	}
	
	if (flag) {
		onLogin(_callback);
	}
}

function extendsPay(item, callback) {
	lwsdk.order.game = lwsdk.game;
	lwsdk.order.channel = lwsdk.channel;
	lwsdk.order.item = item;
	lwsdk.order.openId = lwsdk.account.auth.identifier;
	
	var product;
	if(lwsdk.order.game == 7){
		product = "net.wakool.luckywings.lyftd.item_" + lwsdk.order.item.id;
	}else if(lwsdk.order.game == 8){
		product = "net.wakool.luckywings.cyg.item_" + lwsdk.order.item.price + "0";
	}
	
	console.log("-----" + lwsdk.account.auth.identifier);
	HttpRequest(lwsdk.URL.PAY + "create", "POST", JSON.stringify(lwsdk.order),
			function(xmlHttp) {
				if (xmlHttp.status == 200) {
					var res = JSON.parse(xmlHttp.responseText);
					console.log(res.orderId);
					product_id = product;
					server_id = "1";
					character_id = res.orderId;
					params = res.orderId;
					wakool.purchase(product_id, server_id, character_id, params);
				}
			});
	pay.apply(lwsdk,[callback]);
}
