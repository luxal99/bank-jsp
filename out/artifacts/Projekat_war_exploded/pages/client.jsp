<%@ page import="example.util.HashPassword" %>
<%@ page import="example.service.ClientService" %>
<%@ page import="example.service.ClientServiceImpl" %>
<%@ page import="example.entity.Client" %>
<%@ page import="com.sun.xml.bind.v2.model.core.ID" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.select.Elements" %>
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

        request.setAttribute("clinet", client);


    %>
    <div class=" header-menu">
        <div class="row">
            <div class="col-sm text-left" style="padding-top: .5em;padding-bottom: .5em">
                <img src="https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/1280px-Starling_Bank_Logo.svg.png?alt=media&token=260dc062-b7a4-432a-8c0c-bd4c5c542687"
                     width="100px" class="img-fluid">
            </div>
            <div class="col-sm text-right">
                <button type="button" class="profile-btn" data-toggle="modal" data-target="#exampleModal"><h4><i
                        class="fa fa-user"></i> Profile</h4></button>
                <button type="button" class="profile-btn" data-toggle="modal" data-target="#clientInfoModel"><h4><i
                        class="fa fa-user"></i> Client information</h4></button>
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
                                    <h4>Your username <br> <span>${clinet.userList.get(0).username}</span></h4>
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
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab">
                        <h1>Overview</h1>
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

    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">User information</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/Projekat_war_exploded/client/user" method="post">

                        <div class="form-group">
                            <label for="exampleInputEmail1">Username</label>
                            <input type="text" name="username" class="form-control"
                                   value="${clinet.userList.get(0).username}" id="exampleInputEmail1"
                                   aria-describedby="emailHelp" placeholder="Enter email">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                                else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Current password</label>
                            <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                                   placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">New password</label>
                            <input type="password" name="newPassword" class="form-control" id="exampleInputPassword1"
                                   placeholder="Password">
                        </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="clientInfoModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Client information</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="post" action="/Projekat_war_exploded/client">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Telephone</label>
                            <input type="text" name="telephone" class="form-control" value="${clinet.telephone}"
                                   id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                                else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Email</label>
                            <input type="text" name="email" class="form-control" id="exampleInputPassword1"
                                   placeholder="Password">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Email</label>
                            <input value="${clinet.idClient}" type="hidden" name="idClient" class="form-control"
                                   id="exampleInputPassword1" placeholder="Password">
                        </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>
