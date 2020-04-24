package example.servlet;

import example.entity.Client;
import example.service.ClientService;
import example.service.ClientServiceImpl;
import org.hibernate.Session;

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
        client.setMail(req.getParameter("mail"));


        ClientService clientService = new ClientServiceImpl();
        clientService.save(client);
        resp.sendRedirect(req.getContextPath()+ "/pages/dashboard.jsp");
    }
}
