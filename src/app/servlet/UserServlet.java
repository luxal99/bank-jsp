package app.servlet;

import app.entity.User;
import app.service.impl.UserServiceImpl;
import app.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl<User> userService = new UserServiceImpl<User>(User.class);

        User user = userService.findByUsername(req.getParameter("username"));
        if (HashPassword.decrypt(user.getPassword()).equals(req.getParameter("password"))) {
            String hashedPassword = HashPassword.encrypt(req.getParameter("newPassword"));
            user.setPassword(hashedPassword);
        }
        userService.update(user);

        resp.sendRedirect(req.getContextPath());

    }
}
