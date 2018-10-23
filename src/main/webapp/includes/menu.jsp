<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

 <aside>
                <c:if test="${user.getRole() == 'ADMIN'}">
                  <ul>
                    <li><p><a href="personalPage.jsp">My page</a></p></li>
                    <li><p><a href="/client/getOrders.jsp">Look</a></p></li>
                    <li><p><a href="/client/myOrders.jsp">My orders</a></p></li>
                  </ul>
                </c:if>

                <c:if test="${user.getRole() == 'USER'}">
                  <ul>
                    <li><p><a href="personalPage.jsp">My page</a></p></li>
                    <li><p><a href="/client/getOrders.jsp">Make an order</a></p></li>
                    <li><p><a href="/client/myOrders.jsp">My orders</a></p></li>
                  </ul>
                </c:if>

                <c:if test="${user.getRole() == 'PRODUCER'}">
                  <ul>
                    <li><p><a href="personalPage.jsp">My page</a></p></li>
                    <li><p><a href="/client/getOrders.jsp">Make an order</a></p></li>
                    <li><p><a href="/client/myOrders.jsp">My orders</a></p></li>
                  </ul>
                </c:if>
</aside>