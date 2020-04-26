<%@ page import="example.entity.Client" %>
<%@ page import="example.service.ClientService" %>
<%@ page import="example.service.ClientServiceImpl" %>
<%@ page import="example.util.HashPassword" %>
<%@ page import="example.entity.Account" %>
<%@ page import="example.service.AccountService" %>
<%@ page import="example.service.AccountServiceImpl" %>
<%@ page import="example.dto.TransactionDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
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

    <%--
        Provera da li postoji hash u obliku AES 256 hash-a
    --%>
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
            <div class="col-sm-2 menu">
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
            <div class="col-sm-9">

                <%--
                    Podesavanje default naloga koji ce biti prikazan
                --%>
                <%
                    Account defaultAccount = new Account();
                    if (request.getParameter("changeAccount") == null) {
                        defaultAccount = client.getAccountList().get(0);

                        request.setAttribute("currentAccount", defaultAccount);
                    } else {
                        AccountService accountService = new AccountServiceImpl();
                        defaultAccount = accountService.findById(Integer.valueOf(request.getParameter("idAccount")));
                        request.setAttribute("currentAccount", defaultAccount);
                    }

                %>

                <%

                    List<TransactionDTO> transactionDTOList = new ArrayList<TransactionDTO>();
                    for (int i = 0; i < defaultAccount.getAccountTransactionList().size(); i++) {
                        for (int j = 0; j < defaultAccount.getAccountTransactionList().get(j).getIdTransaction().getAccountTransactionList().size(); j++) {

                            TransactionDTO transactionDTO = new TransactionDTO();

                            if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction().getTitle().equals("payout") &&
                                    defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdAccount() != defaultAccount.getIdAccount()
                            ) {

                                transactionDTO.setAccount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount());
                                transactionDTO.setDate(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getDate());
                                transactionDTO.setAmount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAmount());

                                defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction().setTitle("payup");
                                transactionDTO.setTypeOfTransaction(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction());

                                if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank() != null) {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank().getTitle());

                                } else {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getName() + " " +
                                            defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getLastname());

                                }
                                transactionDTOList.add(transactionDTO);


                            } else if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction().getTitle().equals("payup")
                                    && defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdAccount() != defaultAccount.getIdAccount()
                            ) {

                                transactionDTO.setAccount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount());
                                transactionDTO.setDate(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getDate());
                                transactionDTO.setAmount(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAmount());

                                if (defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank() != null) {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdBank().getTitle());

                                } else {
                                    transactionDTO.setSubject(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getName() + " " +
                                            defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdAccount().getIdClient().getLastname());

                                }

                                defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction().setTitle("payout");
                                transactionDTO.setTypeOfTransaction(defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAccountTransactionList().get(j).getIdTypeTransaction());
                                transactionDTOList.add(transactionDTO);
                            }


                        }

                    }
                %>
                <div class="client-info-div">
                    <div class="row">
                        <div class="col-4">
                            <h4>Hello, <span><%=client.getName()%></span></h4>
                            <h4>Account number <span style="color: #7530FF">${currentAccount.accountNumber}</span></h4>
                        </div>
                        <div class="col-8 text-right">
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
                        <div class="row">

                            <div class="col-4 account-col">

                                <h4>Balance </h4>
                                <h1 class="balance-h1">${currentAccount.balance}</h1>
                            </div>
                            <div class="col  transaction-col">
                                <table class="table text-right">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Account Number</th>
                                        <th scope="col">Client</th>
                                        <th scope="col">Client</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <%--
                                     Prikaz poslednje tri transakcije
                                     --%>

                                    <% for (int i = defaultAccount.getAccountTransactionList().size() - 1; i > defaultAccount.getAccountTransactionList().size() - 5; i--) { %>

                                    <tr>
                                        <td><%= defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getIdTransaction() %>
                                        </td>
                                        <td><%= defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getDate() %>
                                        </td>
                                        <td class="<%=defaultAccount.getAccountTransactionList().get(i).getIdTypeTransaction().getTitle()%>"><%= defaultAccount.getAccountTransactionList().get(i).getIdTransaction().getAmount() %>
                                        </td>
                                        <td><%= defaultAccount.getAccountTransactionList().get(i).getIdTypeTransaction().getTitle() %>
                                        </td>

                                    </tr>
                                    <% }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <h3 style="margin-left: 2em;margin-top: 2em">Send money</h3>
                        <div class="row transfer-row">

                            <div style="height: 1px;background-color: #eee"></div>

                            <div class="col transfer-col" style="margin-left: 2em;margin-right: 2em">
                                <div style="padding: 1em 2em 2em 1em">
                                    <h5>Current account <span
                                            style="font-weight: bold">${currentAccount.accountNumber}</span></h5>

                                    <form method="post" action="/Projekat_war_exploded/admin/account">
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                            <span style="background-color: #7530FF;color: #fff" class="input-group-text"
                                                  id="basic-addon1"><i class="fa fa-address-card"></i></span>
                                            </div>
                                            <input style="background-color: #eee;border: 1px solid #eee;border-radius: 5px;"
                                                   type="text" name="clientAccountNumber" class="form-control"
                                                   placeholder="Account number"
                                                   aria-label="Username" aria-describedby="basic-addon1">
                                            <input type="hidden" name="currentAccountNumber"
                                                   value="${currentAccount.accountNumber}">
                                        </div>

                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                            <span style="background-color: #7530FF;color: #fff" class="input-group-text"
                                                  id="basic-addon2">$</span>
                                            </div>
                                            <input style="background-color: #eee;border: 1px solid #eee;border-radius: 5px;"
                                                   type="text" name="amount" class="form-control"
                                                   placeholder="Account number"
                                                   aria-label="Username" aria-describedby="basic-addon1"><br>

                                        </div>


                                        <div>
                                            <button type="submit" class="transfer-btn">Send</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col"></div>
                        </div>

                    </div>
                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab">


                        <table class="table text-right">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Account Number</th>
                                <th scope="col">Client</th>
                                <th scope="col">Handle</th>
                            </tr>
                            </thead>
                            <tbody>


                            <% for (Account account : client.getAccountList()) { %>

                            <tr>
                                <td><%= account.getIdAccount() %>
                                </td>
                                <td><%= account.getAccountNumber() %>
                                </td>
                                <td><%= account.getBalance() %>
                                </td>
                                <td>
                                    <form method="get" action="client.jsp">
                                        <button class="open-btn" type="submit" name="changeAccount">Change account
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
                    </div>
                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab">

                        <%

                        %>
                        <table class="table text-right">
                            <thead>
                            <tr>
                                <th scope="col">Date</th>
                                <th scope="col">Amount</th>
                                <th scope="col">User</th>
                                <th scope="col">Account number</th>
                            </tr>
                            </thead>
                            <tbody>


                            <% for (TransactionDTO transactionDTO : transactionDTOList) { %>

                            <tr>
                                <td><%= transactionDTO.getDate() %>
                                </td>
                                <td class="<%=transactionDTO.getTypeOfTransaction().getTitle()%>"><%= transactionDTO.getAmount()%>
                                </td>
                                <td><%=transactionDTO.getSubject()%>
                                </td>
                                <td><%= transactionDTO.getAccount().getAccountNumber()%>
                                </td>

                            </tr>
                            <% }
                            %>
                            </tbody>
                        </table>

                    </div>
                    <div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
                         aria-labelledby="v-pills-settings-tab"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">User information</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/Projekat_war_exploded/client/user" method="post">

                        <div class="form-group">
                            <label for="exampleInputEmail1">Username</label>
                            <input type="text" name="username" class="form-control"
                                   value="${clinet.userList.get(0).username}"
                                   aria-describedby="emailHelp" placeholder="Enter email">
                            <small class="form-text text-muted">We'll never share your email with anyone
                                else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Current password</label>
                            <input type="password" name="password" class="form-control"
                                   placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">New password</label>
                            <input type="password" name="newPassword" class="form-control"
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
                            <input type="text" name="email" class="form-control"
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
