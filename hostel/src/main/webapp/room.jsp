<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Free rooms</title></head>
     <body>
     <h1>Free Rooms</h1>
     <div>
          <button onclick="location.href='/app/hostel/'">Home</button>
     </div>

    <c:forEach var="room" items="${requestScope.rooms}">
                    <p>room id = "${room.id()}" </p>
                    <p>number = "${room.number()}" </p>
                    <p>places = "${room.places()}" </p>
                    <p>class = "${room.class_()}" </p>
    <hr>
    </c:forEach>
</body>
</html>