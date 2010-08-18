<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>eID Applet Authentication Demo (requires a secure smart card reader)</title>
</head>
<body>
<h1>eID Applet Authentication Demo (requires a secure smart card reader)</h1>
<script src="https://www.java.com/js/deployJava.js"></script>
<script>
	var attributes = {
		code :'be.fedict.eid.applet.Applet.class',
		archive :'eid-applet.jar',
		width :600,
		height :300
	};
	var parameters = {
		TargetPage :'authn-secure-reader-result.jsp',
		AppletService :'applet-service-authn-secure-reader',
		BackgroundColor :'#ffffff',
		Language : 'en'
	};
	var version = '1.5';
	deployJava.runApplet(attributes, parameters, version);
</script>
</body>
</html>