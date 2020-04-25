package example.servlet;

import com.sun.net.httpserver.HttpsServer;
import example.entity.Account;
import example.service.AccountService;
import example.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        resp.sendRedirect(req.getContextPath() + "/pages/dashboard.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        accountService.payUp(req.getParameter("accountNumber"), Double.valueOf(req.getParameter("amount")));
        resp.sendRedirect(req.getContextPath() + "/pages/dashboard.jsp");
    }
}
