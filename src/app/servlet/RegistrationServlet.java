package app.servlet;

import app.entity.Account;
import app.entity.Client;
import app.entity.User;
import app.entity.UserType;
import app.service.dao.AccountService;
import app.service.dao.UserService;
import app.service.dao.UserTypeService;
import app.service.impl.AccountServiceImpl;
import app.service.impl.ClientServiceImpl;
import app.service.impl.UserServiceImpl;
import app.service.impl.UserTypeServiceImpl;
import app.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = new Client();
        client.setName(req.getParameter("name"));
        client.setLastname(req.getParameter("lastname"));
        client.setTelephone(req.getParameter("telephone"));
        client.setMail(req.getParameter("email"));


        ClientServiceImpl<Client> clientService = new ClientServiceImpl<Client>(Client.class);
        Client savedClient = clientService.save(client);

        UserTypeService userTypeService = new UserTypeServiceImpl();
        UserType userType = userTypeService.findById(Integer.valueOf(req.getParameter("userType")));

        User user = new User();
        user.setUsername(req.getParameter("username"));

        String hashedPassword = HashPassword.encrypt(req.getParameter("password"));

        user.setPassword(hashedPassword);
        user.setIdUserType(userType);
        user.setIdClient(savedClient);

        UserService userService = new UserServiceImpl();
        userService.save(user);

        Account account = new Account();
        account.setIdClient(savedClient);
        account.setAccountNumber(req.getParameter("accountNumber"));

        AccountService accountService = new AccountServiceImpl();
        accountService.save(account);

        resp.sendRedirect(req.getContextPath() + "/pages/dashboard.jsp");
    }
}
