package example.servlet;

import example.entity.Account;
import example.entity.Client;
import example.entity.User;
import example.entity.UserType;
import example.service.*;
import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/registration")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = new Client();
        client.setName(req.getParameter("name"));
        client.setLastname(req.getParameter("lastname"));
        client.setTelephone(req.getParameter("telephone"));
        client.setMail(req.getParameter("email"));


        ClientService clientService = new ClientServiceImpl();
        Client savedClient = clientService.save(client);

        UserTypeService userTypeService = new UserTypeServiceImpl();
        UserType userType = userTypeService.findById(Integer.valueOf(req.getParameter("userType")));

        User user = new User();
        user.setUsername(req.getParameter("username"));

        BCryptPasswordEncoder bCryptPasswordEncoder  = new BCryptPasswordEncoder();
        user.setPassword(req.getParameter("password"));
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
