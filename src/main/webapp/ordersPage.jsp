<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title><c:out value = "${user.getFirstName()} ${user.getLastName()}"/></title>
	<link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="resources/css/scroll.css"/>
    <link rel="stylesheet" href="resources/css/content.css"/>

</head>
    <body>

    <div class="container">
        <jsp:include page="/includes/head.jsp"/>

        <main>
            <div class="scrollMenu">
                        <c:if test="${user.getRole() == 'ADMIN'}">
                            <c:forEach var="order" items="${orders}">
                                <div class="scroll" id="order${loop.index}">
                                  <p>PRICE: ${order.getPrice()}$</p>
                                  <p>STATUS: ${order.getProcessingState()}</p>
                                  <p>DATE: ${order.getDate()}</p>
                                  <p>NAME: ${order.getName()}</p>

                                  <p class="button"><a href="/tracks/controller?orderId=${order.getId()}&command=moreInfoOrder">MORE</a><p>
                                  </div>
                            </c:forEach>
                        </c:if>

                        <c:if test="${user.getRole() == 'USER'}">
                            <c:forEach var="order" items="${orders}" varStatus="loop">
                                <c:if test="${user.getUserId() == order.getUserId()}">
                                     <div class="scroll" id="order${loop.index}">
                                            <p>PRICE: ${order.getPrice()}$</p>
                                            <p>STATUS: ${order.getProcessingState()}</p>
                                            <p>DATE: ${order.getDate()}</p>
                                            <p>NAME: ${order.getName()}</p>

                                            <p class="button"><a href="/tracks/controller?orderId=${order.getId()}&command=rejectOrder">Reject</a><p>
                                     </div>
                                </c:if>
                            </c:forEach>
                        </c:if>


            <c:if test="${user.getRole() == 'PRODUCER'}">
                    <c:forEach var="order" items="${orders}">

                           <div class="scroll" id="order${loop.index}">
                                <p>PRICE: ${order.getPrice()}$</p>
                                <p>STATUS: ${order.getProcessingState()}</p>
                                <p>DATE: ${order.getDate()}</p>
                                <p>NAME: ${order.getName()}</p>
                                <c:if test="${order.getProcessingState() == 'WAITING'}">
                                    <p class="button" id="book"><a href="/tracks/controller?orderId=${order.getId()}&command=bookOrder">Get</a></p>
                                </c:if>

                                <c:if test="${order.getProcessingState() == 'PROCESSED'}">
                                    <c:if test="${user.getUserId() == order.getProducerId()}">
                                        <p class="button" id="book"><a href="/tracks/controller?orderId=${order.getId()}&command=orderReady">Ready</a></p>
                                    </c:if>
                                </c:if>
                           </div>

                </c:forEach>
            </c:if>
        </div>
    </main>


    </div>

    <script src="resources/js/script.js"></script>
    </body>

</html>