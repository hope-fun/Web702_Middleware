<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags'%> 
<c:if test="${empty header['requestType']}">
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<c:set var="clientType">
	<security:authentication property="clientType" />
</c:set>
<c:set var="clientWidth">
	<security:authentication property="clientWidth" />
</c:set>
<c:if test="${empty clientType or '' eq clientType}">
<!--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />-->
<meta name="viewport" content="width=720, user-scalable=no" />
</c:if>
<c:if test="${'android' eq clientType}">
	<c:if test="${clientWidth > 0}">
	<meta name="viewport" content="width=720, initial-scale=${clientWidth/720}; maximum-scale=${clientWidth/720}; minimum-scale=${clientWidth/720};" />
	</c:if>
	<c:if test="${clientWidth == 0}">
	<meta name="viewport" content="width=720" />
	</c:if>
</c:if>
<c:if test="${'ios' eq clientType}">
<!--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />-->
<meta name="viewport" content="width=720, user-scalable=no" />
</c:if>

<title>时之空</title>

<link rel="stylesheet" type="text/css" href="<p:fullurl value="/resources/css/main.css"/>">
<link rel="stylesheet" type="text/css" href="<p:fullurl value="/resources/css/color.css"/>">
<link rel="stylesheet" type="text/css" href="<p:fullurl value="/resources/css/animation.css"/>">
<link rel="stylesheet" type="text/css" href="<p:fullurl value="/resources/css/popup.css"/>">

<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/third-party/jq.mobi/jq.mobi.min.js"/>"></script>

<!-- include touch.js on desktop browsers only -->
<script type="text/javascript">
	var isShowMenu = '<tiles:insertAttribute name="isShowMenu" ignore="true" />';
	var canBack = '<tiles:insertAttribute name="canBack" ignore="true" />';
	window.innerWidth = 720;
	
	if (!((window.DocumentTouch && document instanceof DocumentTouch) || 'ontouchstart' in window)) {
		var script = document.createElement("script");

		script.src = "<p:fullurl value="/resources/third-party/jq.mobi/plugins/jq.desktopBrowsers.js"/>";
		var tag = $("head").append(script);
		if (!$.os.ie) {
			//	$.os.desktop=true;
			//	$.feat.nativeTouchScroll=true;
		}
	}
	
	//Override ajax method
	var $ajax = $.ajax;
	$.ajax = function(opts) {
		opts = opts || {};
		opts.headers = opts.headers || { "requestType": "ajax" };
		$ajax(opts);
	};
</script>

<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/third-party/jq.mobi/plugins/jq.css3animate.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/third-party/jq.mobi/plugins/jq.popup.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/third-party/jq.mobi/plugins/jq.form.plugin.js"/>"></script>

<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/js/common/processbar.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/js/common/ajax.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/js/common/popup.js" />"></script>
<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/js/common/interface.js" />"></script>
<script type="text/javascript" charset="utf-8" src="<p:fullurl value="/resources/js/common/clickTone.js" />"></script>
</head>
<body>
	<div id="top" class="panel" data-header="none" data-footer="none" selected="true">
		<tiles:insertAttribute name="body" ignore="true" />
	</div>
	<div id="_shadow_bg" class="bg-shadow"></div>
</body>
</html>
</c:if>
<c:if test="${not empty header['requestType'] or header['requestType'] == 'ajax' }">
	<tiles:insertAttribute name="body" ignore="true" />
</c:if>
