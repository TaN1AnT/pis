<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head><title>Register</title></head>
<body>
<div>
        <button onclick="location.href='/app/hostel'">Home</button>
    </div>
<form action="/app/hostel/" method="post">
    <div class="container">
        <h1>Register</h1>
        <div visible="hidden">
        <input type="hidden" name="command" value="commandRegister">
        </div>

        <p>Please fill in this form to create an account.</p>
        <hr>
        <c:if test = "${unique == false}">
                 <p>User already exists!<p>
        </c:if>
        <label><b>UserName</b></label>
        <input name="username" type="text" placeholder="Enter UserName" value="${username}" required>
        <label><b>Password</b></label>
        <input name="password" type="text" placeholder="Enter Password" value="${password}" required>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href='/app/hostel/?command=login'>Sign in</a></p>
    </div>
</form>
</body>
</html>