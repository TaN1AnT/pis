<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Profile</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/hostel/'">Home</button>
     </div>

         <p>user name = "${user.username()}" </p>
    <h1>Order a room</h1>
    <form action="/app/hostel/" method="post">
                                          <div visible="hidden">
                                              <input type="hidden" name="command" value="addOrder">
                                          </div>
                                          <input name="places" type="text" placeholder="Enter number of places" required>
                                        <select id="class_" name="class_" >
                                        <c:forEach var="class_" items="${requestScope.classes}">
                                                  <option value="${class_.id()}"> ${class_.name()} </option>
                                        </c:forEach>
                                            </select>
                                          <button type="submit">Order</button>

                             </form>
    <h1>My rooms</h1>
    <c:forEach var="room" items="${requestScope.rooms}">
                    <p>room id = "${room.id()}" </p>
                    <p>number = "${room.number()}" </p>
                    <p>places = "${room.places()}" </p>
                    <p>class = "${room.class_()}" </p>
    <hr>
    </c:forEach>
    </body>
</html>