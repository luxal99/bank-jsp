<%@ page import="app.entity.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="app.entity.UserType" %>
<%@ page import="app.entity.Account" %>
<%@ page import="app.entity.Bank" %>
<%@ page import="app.util.HashPassword" %>
<%@ page import="app.service.dao.AccountService" %>
<%@ page import="app.service.impl.ClientServiceImpl" %>
<%@ page import="app.service.impl.BankServiceImpl" %>
<%@ page import="app.service.impl.AccountServiceImpl" %>
<%@ page import="app.service.impl.UserTypeServiceImpl" %>
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

    <%
        Cookie[] cookies = request.getCookies();
        Cookie idCookie = new Cookie("idBank", "");

        boolean haveId = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("idBank")) {
                haveId = true;
                idCookie.setValue(cookie.getValue());
            }
        }

        if (!haveId) {
            response.sendRedirect(request.getContextPath());
        } else {
            BankServiceImpl<Bank> bankService = new BankServiceImpl<Bank>(Bank.class);
            Bank bank = bankService.findById(Integer.valueOf(HashPassword.decrypt(idCookie.getValue())));
            request.setAttribute("bankAccount", bank.getAccountList().get(0));
        }


    %>

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
        <div class="text-right" style="padding-top: 1em;padding-left: 1em">
            <h3>Bank account ${bankAccount.accountNumber}</h3>
            <h3>${bankAccount.balance}</h3>
        </div>
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <div class="container">
                    <h2 class="text-center">Modal Example</h2>
                    <!-- Trigger the modal with a button -->
                    <button type="button" class="open-btn" data-toggle="modal" data-target="#myModal">Create user
                    </button>

                    <!-- Modal -->


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
                            ClientServiceImpl<Client> clientService = new ClientServiceImpl<Client>(Client.class);
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

                <button type="button" class="open-btn" data-toggle="modal" data-target="#addAccountModal">Create
                    account
                </button>

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
                <button class="pay-btn" type="button" data-toggle="modal" data-target="#payUpModal">Pay up</button>
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


                        <form method="post" action="${pageContext.request.contextPath}/admin/account">
                            <input class="form-control" type="text" name="amount" value="${account.balance}"/>
                            <input class="form-control" type="hidden" name="accountNumber"
                                   value="${account.accountNumber}"/>
                            <input class="form-control" type="hidden" name="clientAccountNumber"
                                   value="${account.accountNumber}"/>
                            <input class="form-control" type="hidden" name="currentAccountNumber"
                                   value="${bankAccount.accountNumber}"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" name="payUp" class="btn btn-primary">Save changes</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="addAccountModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Create account</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <form method="post" action="dashboard.jsp">
                            <input type="text" name="accountNumber" class="form-control"
                                   aria-describedby="emailHelp"><br>

                            <select name="clientListPos" class="form-control form-control-lg">
                                <% for (int i = 0; i < clientList.size(); i += 1) { %>

                                <option value="<%= i %>"><%=clientList.get(i).getName() + " " + clientList.get(i).getLastname() + " " + clientList.get(i).getMail() %>
                                </option>

                                <% }

                                %>
                            </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" name="createAccount" class="btn btn-primary">Save changes</button>

                        </form>
                    </div>
                </div>
            </div>

            <%
                if (request.getParameter("createAccount") != null) {
                    Client client = clientList.get(Integer.valueOf(request.getParameter("clientListPos")));
                    Account account = new Account();
                    account.setAccountNumber(request.getParameter("accountNumber"));
                    account.setBalance(0.0);
                    account.setIdClient(client);

                    accountService.save(account);
                }

            %>

        </div>


        <%-- Create user modal--%>
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Modal Header</h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="${pageContext.request.contextPath}/admin/registration">

                            <div class="col-sm">
                                <h3>Client information</h3>
                                <div style="height: 1px;background-color: #e1e1e1"></div>

                                <div class="row" style="margin-top: 1em">
                                    <div class="col-sm">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Name</label>
                                            <input type="text" class="form-control" name="name"
                                                   aria-describedby="emailHelp">
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Lastname</label>
                                            <input type="text" name="lastname" class="form-control">
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
                                    UserTypeServiceImpl<UserType> userTypeService = new UserTypeServiceImpl<UserType>(UserType.class);
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
    </div>
</div>

</body>
</html>
