package example.servlet;

import example.entity.User;
import example.service.UserService;
import example.service.UserServiceImpl;
import example.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        User user = userService.findByUsername(req.getParameter("username"));
        if (HashPassword.decrypt(user.getPassword()).equals(req.getParameter("password"))) {
            user.setPassword(req.getParameter("newPassword"));
        }
        userService.updateUser(user);

        resp.sendRedirect(req.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        User user = userService.findByUsername(req.getParameter("username"));
        if (HashPassword.decrypt(user.getPassword()).equals(req.getParameter("password"))) {
            String hashedPassword = HashPassword.encrypt(req.getParameter("newPassword"));
            user.setPassword(hashedPassword);
        }
        userService.updateUser(user);

        resp.sendRedirect(req.getContextPath());

    }
}
