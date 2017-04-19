/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
if (!net) var net = {};
if (!net.luckywings) net.luckywings = {};
net.luckywings.Account = function() {
	this.game = null;
	this.channel = null;
	this.auth = {
		"identifier"   : null,
		"credential"   : null,
		"identityType" : "ACCOUNT_AUTH_TYPE_CHANNEL"
	};
	this.extra = {};
};
net.luckywings.Config  = function() {
	this.game = null;
	this.channel = null;
};
net.luckywings.Order   = function() {
	this.item = {
		"id"       : null,
		"name"     : null,
		"price"    : null,
		"count"    : null,
		"currency" : null
	};
	this.game = null;
	this.channel = null;
	this.openId = null;
};
net.luckywings.OrderStatus = function() {
	this.orderId = null;
	this.openOrderId = null;
};
var lwsdk = new lwsdk();
function lwsdk() {
	this.URL = {
//		PAY   : "http://webapp.hoperun.com:7070/mobigame/pay/pay/",
//		LOGIN : "http://webapp.hoperun.com:7070/mobigame/login/account/login",
//		JSPATH: "http://webapp.hoperun.com:7070/mobigame/resources/js/channel/"
//		PAY   : "http://10.20.20.39:8080/mobigame-pay-service/mobiapi/1/pay/",
//		LOGIN : "http://10.20.20.39:8080/mobigame-login-service/mobiapi/1/account/login",
//		JSPATH: "http://10.20.20.39:8080/mobigame-login-service/resources/js/channel/"
		PAY	  : "http://www.luckywings.net/api/pay/",
		LOGIN : "http://www.luckywings.net/api/account/login",
		GAME  : "http://www.luckywings.net/api/account/info",
		JSPATH: "http://www.luckywings.net/sdk/js/1/channel/"
//		PAY	  : "http://mgcis.h5play.com.tw/api/pay/",
//		LOGIN : "http://mgcis.h5play.com.tw/api/account/login",
//		GAME  : "http://mgcis.h5play.com.tw/api/account/getServiceId",
//		JSPATH: "http://mgcis.h5play.com.tw/sdk/js/1/channel/"
	};
	with(net.luckywings) {
		this.account = new Account();
		this.order   = new Order();
		this.config  = new Config();
		this.orderStatus = new OrderStatus();
	}
	this.game 	 = null;	// Game Code
	this.channel = null;	// Channel ID
	this.token   = null;	// User Token

	this.init = function(c,callback) {
		this.config  = c;
		this.game    = (this.config && this.config.game) ? this.config.game : getGameCode();
		this.channel = (this.config && this.config.channel) ? this.config.channel : getChannel();
		this.loadjs(callback);
	};
	this.loadjs = function(callback) {
		loadjs(this.URL.JSPATH + "channel_" + this.channel + ".js", function(){
				loadjscomplete(callback);
			});
	};
	this.login = function(callback) {
		console.log("Main Login Function...");
		var self = this;
		HttpRequest(this.URL.LOGIN, "POST", JSON.stringify(this.account), function(xmlHttp) {
			self.token = xmlHttp.getResponseHeader("User-Token");
			if (xmlHttp.status == 200) {
				if (callback != null) callback();
				console.log("Login Success...");
			}
		});
	};
	this.pay = function(callback) {
		console.log("Main Pay Function...");
		HttpRequest(this.URL.PAY+"create", "POST", JSON.stringify(this.order), function(xmlHttp) {
			if (xmlHttp.status == 200) {
				if (callback != null) callback(xmlHttp);
				console.log("Pay Success...");
			}
		});
	};
	this.finishLoading = function() {
		console.log("Finish Loading...");
	};
	this.leaderBoard = function() {
		console.log("Leader Board...");
	};
	this.updateOrder = function(callback) {
		HttpRequest(this.URL.PAY+"update", "POST", JSON.stringify(this.orderStatus), function(xmlHttp) {
			if (xmlHttp.status == 200) {
				if (callback != null) callback();
				console.log("Update Order Success...");
			}
		});
	};
}

function HttpRequest(url, type, data, callback) {
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200 && callback != null)
			callback(xmlHttp);
	};
	xmlHttp.open(type, url, true); // true for asynchronous
	if (lwsdk.token != null) {
		xmlHttp.setRequestHeader("User-Token", lwsdk.token);
	}
	xmlHttp.send(data);
}

function loadjs(filename, callback) {
	var script = document.createElement('script');
	script.setAttribute("type", "text/javascript");
	script.setAttribute("src", filename);
	if (typeof script != "undefined") {
		document.getElementsByTagName("head")[0].appendChild(script);
	}
	script.onload = script.onreadystatechange = function(_, isAbort) {
		if (isAbort || !script.readyState || /loaded|complete/.test(script.readyState)) {
			script.onload = script.onreadystatechange = null;
			script = undefined;
			if (!isAbort) {
				if (callback) callback();
			}
		}
	};
}

function loadjscomplete(callback) {
	if(callback != null) callback();
	console.log("Load Channel JS Complete...");
}

var getUrlParam = function(name) {
	var url = document.location.href;
	if (!name) {
		return '';
	}
	url = url || location.search;
	name = name.replace(/(?=[\\^$*+?.():|{}])/, '\\');
	var reg = new RegExp('(?:[?&]|^)' + name + '=([^?&#]*)', 'i');
	var match = url.match(reg);
	return !match ? '' : match[1];
};

var guid = function() {
	function s4() {
		return Math.floor((1 + Math.random()) * 0x10000).toString(16)
				.substring(1);
	}
	return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4()
			+ s4() + s4();
};

var getChannel = function() {
	return getUrlParam("channel") == "" ? "888" : getUrlParam("channel");
};

var getGameCode = function() {
	var url = document.location.href;
	return url.match(/game[\/](\S*)[?]/)[1];
};
