<%@ page import="example.entity.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="example.entity.UserType" %>
<%@ page import="example.service.*" %>
<%@ page import="example.entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <link rel="stylesheet" href="../assets/css/dashboard.css">
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
    <title>Title</title>
</head>
<body>
<div class="row" style="height: 100vh">

    <div class="col-3 menu">
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
    <div class="col-9">
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <div class="container">
                    <h2 class="text-center">Modal Example</h2>
                    <!-- Trigger the modal with a button -->
                    <button type="button" class="open-btn" data-toggle="modal" data-target="#myModal">Open
                        Modal
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Modal Header</h4>
                                </div>
                                <div class="modal-body">
                                    <form method="post" action="/Projekat_war_exploded/admin/registration">

                                        <div class="col-sm">
                                            <h3>Client information</h3>
                                            <div style="height: 1px;background-color: #e1e1e1"></div>

                                            <div class="row" style="margin-top: 1em">
                                                <div class="col-sm">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Name</label>
                                                        <input type="text" class="form-control" name="name"
                                                               id="exampleInputEmail1" aria-describedby="emailHelp">
                                                    </div>
                                                </div>
                                                <div class="col-sm">
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Lastname</label>
                                                        <input type="text" name="lastname" class="form-control"
                                                               id="exampleInputPassword1">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="exampleInputEmail1">E-mail</label>
                                                <input type="email" name="email" class="form-control"
                                                       id="exampleInputEmail1"
                                                       aria-describedby="emailHelp">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputPassword1">Telephone</label>
                                                <input type="text" name="telephone" class="form-control"
                                                       id="exampleInputPassword1">
                                            </div>

                                        </div>
                                        <div class="col-sm">
                                            <h3>User data</h3>
                                            <div style="height: 1px;background-color: #e1e1e1"></div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Username</label>
                                                <input type="text" name="username" class="form-control"
                                                       id="exampleInputEmail1"
                                                       aria-describedby="emailHelp">
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Password</label>
                                                <input type="password" name="password" class="form-control"
                                                       id="exampleInputEmail1"
                                                       aria-describedby="emailHelp">
                                            </div>
                                        </div>
                                        <div class="col-sm">
                                            <h3>Accout data</h3>
                                            <div style="height: 1px;background-color: #e1e1e1"></div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Account number</label>
                                                <input type="text" name="accountNumber" class="form-control"
                                                       id="exampleInputEmail1"
                                                       aria-describedby="emailHelp">
                                            </div>
                                            <%
                                                UserTypeService userTypeService = new UserTypeServiceImpl();
                                                List<UserType> userTypeList = userTypeService.getAll();
                                                request.setAttribute("userTypeList", userTypeList);

                                            %>
                                            <select name="userType" class="form-control form-control-lg">

                                                <% for (int i = 0; i < userTypeList.size(); i += 1) { %>

                                                <option value="<%= userTypeList.get(i).getIdUserType() %>"><%=userTypeList.get(i).getTitle()%>
                                                </option>

                                                <% }

                                                %>
                                            </select>

                                        </div>
                                        <div class="text-center" style="margin-left: 1em;margin-top: 1em">
                                            <button class="btn btn-primary" type="submit">Register</button>
                                        </div>
                                    </form>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            ClientService clientService = new ClientServiceImpl();
                            List<Client> clientList = clientService.getAll();

                        %>


                        <% for (int i = 0; i < clientList.size(); i += 1) { %>

                        <tr>
                            <td><%= clientList.get(i).getName() %>
                            </td>
                            <td><%= clientList.get(i).getLastname() %>
                            </td>
                            <td><%= clientList.get(i).getMail() %>
                            </td>
                            <td><%= clientList.get(i).getTelephone() %>
                            </td>

                        </tr>

                        <% }

                        %>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">

                <%
                    AccountService accountService = new AccountServiceImpl();
                    List<Account> accountList = accountService.getAll();
                %>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Account Number</th>
                        <th scope="col">Client ID</th>
                        <th scope="col">Balance</th>
                        <th scope="col">Client name</th>
                        <th scope="col">Client lastname</th>
                    </tr>
                    </thead>
                    <tbody>


                    <% for (Account account : accountList) { %>

                    <tr>
                        <td><%= account.getIdAccount() %>
                        </td>
                        <td><%= account.getAccountNumber() %>
                        </td>
                        <td><%= account.getIdClient().getIdClient() %>
                        </td>
                        <td><%= account.getBalance() %>
                        </td>
                        <td><%= account.getIdClient().getName() %>
                        </td>
                        <td><%= account.getIdClient().getLastname() %>
                        </td>
                        <td>
                            <form method="get" action="dashboard.jsp">
                                <button class="open-btn" type="submit" name="clientInfo">
                                    Select client
                                </button>
                                <input type="hidden" name="idAccount" value="<%=account.getIdAccount()%>"/>
                            </form>
                        </td>
                        <td></td>

                    </tr>
                    <% }
                    %>
                    </tbody>
                </table>
                <button class="pay-btn" type="button" data-toggle="modal" data-target="#payUpModal">Pay up
                </button>
                <div style="height: 1px;background-color: #eee;margin-top: 1em"></div>
                <h3>Current selected client</h3>
                <%
                    if (request.getParameter("clientInfo") != null) {
                        Account account = accountService.findById(Integer.valueOf(request.getParameter("idAccount")));
                        request.setAttribute("account", account);

                    }
                %>

                <div style="margin-top: 1em">
                    <h3>${account.accountNumber}</h3>
                    <h3>${account.idClient.name}</h3>
                    <h3>${account.idClient.lastname}</h3>
                    <h3>${account.idClient.mail}</h3>
                    <h3>${account.idClient.telephone}</h3>
                </div>

            </div>
            <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                ...
            </div>
            <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                ...
            </div>
        </div>
        <!-- Button trigger modal -->


        <!-- Modal -->
        <div class="modal fade" id="payUpModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h3>Account number: ${account.accountNumber}</h3>

                        <form method="post" action="/Projekat_war_exploded/admin/account">
                            <input class="form-control" type="text" name="amount" value="${account.balance}"/>
                            <input class="form-control" type="hidden" name="accountNumber" value="${account.accountNumber}"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="clientModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h3>${account.idClient.name}</h3>
                        <h3>${account.idClient.lastname}</h3>
                        <h3>${account.idClient.mail}</h3>
                        <h3>${account.idClient.telephone}</h3>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
