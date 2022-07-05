<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Login</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/hostel/'">Home</button>
     </div>
<form action="/app/hostel/" method="post">
    <div class="container">
        <div visible="hidden">
                <input type="hidden" name="command" value="commandLogin">
         </div>
        <h1>Login</h1>
        <p>Please fill in this form to login in your account.</p>
        <hr>
        <c:if test = "${incorrect == true}">
                         <p>Incorrect username or password!<p>
                </c:if>
        <label><b>UserName</b></label>
        <input name="username" type="text" placeholder="Enter UserName" required>

        <label><b>Password</b></label>
        <input name="password" type="password" placeholder="Enter Password" required>
        <hr>

        <button type="submit" class="registerbtn">Login</button>
    </div>
    <div class="container signin">
            <p>Dont have an account? <a href='/app/hostel/?command=register'>Register</a>.</p>
        </div>

</form>
</body>
</html>