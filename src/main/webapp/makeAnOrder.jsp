<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <div class="wrapper">
                <form action="/tracks/controller?command=createOrder">
                    <p>
                      <label for="payment" class="payment"> Payment method </label>
                      <select id="payment" name="payment">
                        <option value="VISA">VISA</option>
                        <option value="Webmoney">WebMoney</option>
                        <option value="IQ">IQ</option>
                      </select>
                    </p>

                    <p>
                      <label for="category" class="category"> Payment method </label>
                      <select id="category" name="category">
                          <option value="pop">Pop</option>
                          <option value="rock">Rock</option>
                          <option value="hip-hop">Hip-Hop</option>
                          <option value="rap">Rap</option>
                          <option value="house">House</option>
                          <option value="atmosphere">Atmosphere</option>
                          <option value="relax">Relax</option>
                          <option value="intro">Intro</option>
                          <option value="rington">Rington</option>
                          <option value="trance">Trance</option>
                          <option value="new school">New School</option>
                      </select>
                    </p>

                    <p>
                       <label for="duration" class="duration"> Payment method </label>
                       <input type="number" id="duration" name="duration"/>
                    </p>

                    <p>
                       <label for="comment" class="comment"> Payment method </label>
                       <textarea id="comment" name="comment" cols="40" rows="5"></textarea>
                    </p>

                    <p class="search button">
                       <input type="hidden" name="command" value="preOrder"/>
                       <input type="submit" value="&x1F50D;" />
                    </p>



                </form>
            </div>
        </main>


    </div>
    <script src="resources/js/script.js"></script>
    </body>

</html>