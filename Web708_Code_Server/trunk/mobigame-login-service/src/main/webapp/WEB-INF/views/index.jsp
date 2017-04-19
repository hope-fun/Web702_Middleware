<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="format-detection" content="telephone=no" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,minimal-ui">
<title></title>
</head>
<body>
	<script>
		var channelUrl = document.location.href;
		var mwsdk = new mwsdk()
		function mwsdk() {
			this.url = "http://localhost:8080/mobigame-login-service/mobiapi/1/account/getGmaeUrl";
			// 			this.url = "http://http://ih5hi.com/getGmaeUrl";
			this.mw = {
				game : getUrlParam('game'),
				channel : getUrlParam('channel')
			}
		};

		//获取url中的参数
		function getUrlParam(name) {
			if (!name) {
				return '';
			}
			channelUrl = channelUrl || location.search;
			name = name.replace(/(?=[\\^$*+?.():|{}])/, '\\');
			var reg = new RegExp('(?:[?&]|^)' + name + '=([^?&#]*)', 'i');
			var match = channelUrl.match(reg);
			return !match ? '' : match[1];
		};
		//发送请求
		function HttpRequest(url, type, data, callback) {
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200
						&& callback != null)
					callback(xmlHttp);
			};
			xmlHttp.open(type, url, true); // true for asynchronous
			xmlHttp.send(data);
		}

		//获取游戏地址和渠道登陆参数
		function gameaccount() {
			//var gameUrl = 'http://luckywings.net/game/h008';
			var gameUrl;
			HttpRequest(mwsdk.url, "POST", JSON.stringify(mwsdk.mw), function(
					xmlHttp) {
				if (xmlHttp.status == 200) {
					var res = JSON.parse(xmlHttp.responseText);
					gameUrl = res.game.gameUrl;
				}
			});
			var strmv = 'game=' + getUrlParam('game') + '&'
			var par = channelUrl.substr(channelUrl.indexOf(strmv)
					+ strmv.length);
			return gameUrl + '?' + par;
		}

		window.location.href = gameaccount();
	</script>
</body>
</html>
