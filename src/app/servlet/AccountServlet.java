package app.servlet;

import app.entity.Account;
import app.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/account")
public class AccountServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            AccountServiceImpl accountService = new AccountServiceImpl(Account.class);
            Account senderAccount = accountService.findByAccountNumber(req.getParameter("currentAccountNumber"));
            Account receiverAccount = accountService.findByAccountNumber(req.getParameter("clientAccountNumber"));

        try {
            accountService.transfer(req.getParameter("accountNumber"), Double.valueOf(req.getParameter("amount")), senderAccount, receiverAccount);
            resp.sendRedirect("/pages/client.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
