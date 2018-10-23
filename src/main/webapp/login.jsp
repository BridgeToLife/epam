<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Login</title>
	<link href="resources/css/login.css" rel="stylesheet">
</head>

<body>

    <div id="wrapper">
        <div id="login" class="animate form">
            <form action="/tracks/controller?command=login">

                <h1>Log in</h1>

                <c:if test="${not validation}">
                    <p>
                        <c:out value="Check your password or login"/>
                    </p>
                </c:if>
                <p>
                    <label for="username" class="username"> Your email </label>
                    <input type="text" id="username" name="login" required="required"  placeholder="myemail@.ru"/>
                </p>

                <p>
                    <label for="password" class="password"> Your password </label>
                    <input type="password" id="password" name="password" required="required"  placeholder="1Hrt .T-2" />
                </p>


                <p class="login button">
                        <input type="hidden" name="command" value="login"/>
                        <input type="submit" value="Login" />
                </p>

            </form>
        </div>

    </div>

</body>

</html>