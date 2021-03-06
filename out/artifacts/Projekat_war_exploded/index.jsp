<%@ page import="app.service.impl.AccountServiceImpl" %>
<%@ page import="app.util.HashPassword" %>
<%@ page import="app.service.impl.TransactionServiceImpl" %>
<%@ page import="app.entity.Transaction" %>
<%@ page import="app.service.impl.BankServiceImpl" %>
<%@ page import="app.entity.Bank" %><%--
  Created by IntelliJ IDEA.
  User: luxal
  Date: 4/24/20
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="assets/css/index.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <title>$Title$</title>
</head>
<body>
<div>
    <div class="container login-container">
        <div class="row">
            <div class="col-sm " style="padding: 0 !important;">
                <div class="left-col">
                    <div class="container">
                        <h1 class="text-center" style="color: #fff;padding-top: 25%">Welcome</h1>
                        <h4 class="text-center">Lorem Ipsum is simply dummy text of the printing and typesetting
                            industry.</h4>
                    </div>
                </div>
            </div>
            <div class="col-sm" style="padding-top: 5em">
                <div>
                    <form method="post" action="${pageContext.request.contextPath}/admin/login">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Username</label>
                            <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                                else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                        </div>
                        <div class="form-group form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Check me out</label>
                        </div>
                        <button type="submit" class=" login-btn">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
