<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Users</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/hostel/'">Home</button>
     </div>
     <form action="/app/shop/" method="post">
                       <div visible="hidden">
                           <input type="hidden" name="command" value="deleteUser">
                       </div>

                       <label><b>Delete user by id</b></label>
                       <input name="user_id" type="text" placeholder="Enter id" required>
                       <button type="submit">Delete</button>

          </form>

    <c:forEach var="user" items="${requestScope.users}">
                    <p>user id = "${user.id()}" </p>
                    <p>user name = "${user.username()}" </p>
    <hr>
    </c:forEach>
</body>
</html>