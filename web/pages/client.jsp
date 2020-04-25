<%@ page import="example.util.HashPassword" %>
<%@ page import="example.service.ClientService" %>
<%@ page import="example.service.ClientServiceImpl" %>
<%@ page import="example.entity.Client" %>
<%@ page import="com.sun.xml.bind.v2.model.core.ID" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/css/client.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="../assets/node_modules/font-awesome/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <%
        Cookie[] cookies = request.getCookies();
        Cookie idCookie = new Cookie("id", "");

        boolean haveId = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                haveId = true;
                idCookie.setValue(cookie.getValue());
            }
        }

        if (!haveId) {
            response.sendRedirect(request.getContextPath());
        }

        ClientService clientService = new ClientServiceImpl();
        Client client = clientService.findClientById(Integer.valueOf(HashPassword.decrypt(idCookie.getValue())));

        request.setAttribute("clinet",client);


    %>
    <div class=" header-menu">
        <div class="row">
            <div class="col-sm text-left" style="padding-top: .5em;padding-bottom: .5em">
                <img src="https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/1280px-Starling_Bank_Logo.svg.png?alt=media&token=260dc062-b7a4-432a-8c0c-bd4c5c542687"
                     width="100px" class="img-fluid">
            </div>
            <div class="col-sm text-right">
                <h4><i class="fa fa-user"></i> Profile</h4>
            </div>
        </div>
    </div>

    <div class="content-container">
        <div class="row">
            <div class="col-sm-3 menu">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab"
                       aria-controls="v-pills-home" aria-selected="true">Clients</a>
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab"
                       aria-controls="v-pills-profile" aria-selected="false">Accounts</a>
                    <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab"
                       aria-controls="v-pills-messages" aria-selected="false">Transaction</a>
                    <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab"
                       aria-controls="v-pills-settings" aria-selected="false">Settings</a>
                </div>
            </div>
            <div class="col-sm-1"></div>
            <div class="col-sm-8">
                <div class="client-info-div">
                    <div class="row">
                        <div class="col-3">
                            <h4>Hello, <span><%=client.getName()%></span></h4>

                        </div>
                        <div class="col-9 text-right">
                            <div class="row">
                                <div class="col">
                                    <h4 >Your username <br> <span>${clinet.userList.get(0).username}</span></h4>
                                </div>
                                <div class="col">
                                    <h4>Your client id <br> <span>${clinet.idClient}</span></h4>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div style="height: 1px;background-color: #eee"></div>
                </div>

                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-messages-tab">


                    </div>
                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab"></div>
                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab"></div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
                         aria-labelledby="v-pills-settings-tab"></div>
                </div>
            </div>
        </div>
    </div>


</div>


</body>
</html>
