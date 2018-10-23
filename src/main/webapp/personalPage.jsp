<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<html>
<head>
	<title><c:out value = "${user.getFirstName()} ${user.getLastName()}"/></title>
	<link rel="stylesheet" href="resources/css/style.css"/>
	<link rel="stylesheet" href="resources/css/content.css"/>

</head>
    <body>

    <div class="container">
        <jsp:include page="/includes/head.jsp"/>

        <main>
            <div class="image"><img class="profileImage" src="resources/img/profile.png" alt="PHOTO"/></div>
            <div class="personalInfo">
                <div id="username">
                    <c:out value="${user.getFirstName()} ${user.getLastName()}"/>
                </div>
                <ul>
                    <li>
                        <p>
                            <fmt:message key="cabinet.phone"/>
                            <c:out value=":"/>
                            <c:out value="${user.getPhoneNumber()}"/>
                        </p>
                    </li>
                    <li>
                        <p>
                            <fmt:message key="cabinet.email"/>
                            <c:out value=":"/>
                            <c:out value="${user.getLogin()}"/>
                        </p>
                    </li>
                    <li>
                        <p>
                            <fmt:message key="cabinet.bonus"/>
                            <c:out value=":"/>
                            <c:out value="${user.getBonusPoints()}"/>
                        </p>
                    </li>
                </ul>
            </div>
            <div class="tracks">TRACKS</div>
        </main>

    <jsp:include page="/includes/footer.jsp"/>
    </div>

    <script src="resources/js/script.js"></script>
    </body>

</html>