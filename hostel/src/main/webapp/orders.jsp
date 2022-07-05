<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Orders</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/hostel/'">Home</button>
     </div>
     <form action="/app/hostel/" method="post">
                                      <div visible="hidden">
                                          <input type="hidden" name="command" value="confirmOrder">
                                      </div>

                                      <label><b>Confirm order</b></label>
                                      <input name="order_id" type="text" placeholder="Enter order id" required>
                                      <input name="room_id" type="text" placeholder="Enter room id" required>
                                      <button type="submit">Confirm</button>

                         </form>
    <form action="/app/hostel/" method="post">
                       <div visible="hidden">
                           <input type="hidden" name="command" value="deleteOrder">
                       </div>

                       <label><b>Delete order by id</b></label>
                       <input name="order_id" type="text" placeholder="Enter id" required>
                       <button type="submit">Delete</button>

          </form>

    <c:forEach var="order" items="${requestScope.orders}">
                    <p>order id = "${order.id()}" </p>
                    <p>places = "${order.places()}" </p>
                    <p>class = "${order.class_()}" </p>
                    <p>user id = "${order.user_id()}" </p>

    <hr>
    </c:forEach>
</body>
</html>