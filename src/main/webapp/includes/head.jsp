<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<header>

      <fmt:setLocale value = "${locale}" scope="session"/>
      <fmt:setBundle basename = "com.epam.tracks.src.main.resources.Message" var = "lang"/>

    <div class="logo">
        <a href="home.jsp"><img class="graphiclogo" src="resources/img/logo.png" alt="logo"/></a>
    </div>
    <nav class="top_nav" id="top_nav_menu">

        <c:if test="${user.getRole()  == 'USER'}">
            <a href="personalPage.jsp">
                <fmt:message key="locale.home"/>
            </a>

            <a href="controller?command=showOrders">
                <fmt:message key="locale.orders"/>
            </a>
            <a href="makeAnOrder.jsp">
                <fmt:message key="locale.makeAnOrder"/>
            </a>

            <a id="menu" href="#" class="icon">&#9776;</a>
        </c:if>

        <c:if test="${user.getRole() == 'ADMIN'}">
             <a href="personalPage.jsp">
                <fmt:message key="locale.home"/>
             </a>

             <a href="controller?command=showOrders">
                <fmt:message key="locale.orders"/>
             </a>

             <a href="controller?command=showUsers">
                <fmt:message key="locale.listOfUsers"/>
             </a>

             <a href="userList.jsp">
                <fmt:message key="locale.createLabel"/>
             </a>

             <a id="menu" href="#" class="icon">&#9776;</a>
        </c:if>

        <c:if test="${user.getRole() == 'PRODUCER'}">
             <a href="personalPage.jsp">
                <fmt:message key="locale.home"/>
             </a>

             <a href="controller?command=showOrders">
                <fmt:message key="locale.orders"/>
             </a>

             <a href="controller?command=createLabel">
                <fmt:message key="locale.createLabel"/>
             </a>

             <a id="menu" href="#" class="icon">&#9776;</a>
        </c:if>

    </nav>
</header>