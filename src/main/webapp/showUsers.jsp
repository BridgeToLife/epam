<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<html>
<head>
	<title><c:out value = "${user.getFirstName()} ${user.getLastName()}"/></title>
	<link rel="stylesheet" href="resources/css/style.css"/>
        <link rel="stylesheet" href="resources/css/scroll.css"/>
        <link rel="stylesheet" href="resources/css/content.css"/>
        <link rel="stylesheet" href="resources/css/search.css"/>


</head>
    <body>

    <div class="container">
        <jsp:include page="/includes/head.jsp"/>
        <main>

            <div class="search">

                <form action="/tracks/controller?command=findUser">
                    <p>
                       <label for="usernameInput" class="usernameLabel"> User name </label>
                       <input type="text" id="usernameInput" name="firstname" placeholder="Ilya"/>
                    </p>

                    <p>
                       <label for="usernameInput" class="usernameLabel"> User surname </label>
                       <input type="text" id="usernameInput" name="lastname" placeholder="Vorobyov"/>
                    </p>

                    <p class="search button">
                       <input type="hidden" name="command" value="findUser"/>
                       <input type="submit" value="START" />
                    </p>

                </form>
            </div>

            <div class="scrollMenu">

               <c:forEach var="user" items="${userList}" varStatus="loop">
                   <div class="scroll" id="order${loop.index}">
                       <p>NAME: ${user.getFirstName()} ${user.getLastName()}</p>
                       <p>ORDERS: ${user.getOrderNumber()}</p>
                       <p>EMAIL: ${user.getLogin()}</p>
                       <p>BONUS: ${user.getBonusPoints()}</p>

                       <p class="button" id="book"><a href="/tracks/controller?orderId=${order.getId()}&command=bookOrder">Get</a></p>
                       </div>

                    </c:forEach>

            </div>


        </main>

        <jsp:include page="/includes/footer.jsp"/>
    </div>
    <script src="resources/js/module.js"></script>
    <script src="resources/js/script.js"></script>
    </body>

</html>