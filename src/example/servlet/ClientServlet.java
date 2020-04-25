package example.servlet;

import example.entity.Client;
import example.service.ClientService;
import example.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientService clientService = new ClientServiceImpl();
        Client client = clientService.findClientById(Integer.valueOf(req.getParameter("idClient")));

        client.setMail(req.getParameter("email"));
        client.setTelephone(req.getParameter("telephone"));

        clientService.updateClient(client);
    }
}
