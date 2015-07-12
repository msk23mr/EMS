<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h2>ログイン画面</h2>

<s:form action="login">
<s:textfield key="employeeBean.id"></s:textfield>
<s:textfield key="employeeBean.password"></s:textfield>
<s:submit key="submit"></s:submit>
</s:form>

</body>
</html>