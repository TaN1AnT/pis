<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hostel</title>
</head>
<body>
<div>
    <h1>Hostel</h1>
</div>

<div>
    <div>
        <button onclick="location.href='/app/hostel/?command=login'">Login</button>
        <button onclick="location.href='/app/hostel/?command=register'">Register</button>
        <c:if test = "${sessionScope.admin == true}">
            <button onclick="location.href='/app/hostel/?command=usersList'">Users</button>
        </c:if>
            <button onclick="location.href='/app/hostel/?command=ordersList'">Orders</button>
                    <button onclick="location.href='/app/hostel/?command=roomsList'">Rooms</button>

        <c:if test = "${sessionScope.registered == true}">
                                    <button onclick="location.href='/app/hostel/?command=commandProfile'">Profile</button>
                        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                    <button onclick="location.href='/app/hostel/?command=logOut'">LogOut</button>
        </c:if>

    </div>
</div>
</body>
</html>