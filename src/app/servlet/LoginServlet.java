package app.servlet;

import app.entity.User;
import app.service.impl.UserServiceImpl;
import app.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            UserServiceImpl<User> userService = new UserServiceImpl<User>(User.class);
            User user = userService.findByUsername(req.getParameter("username"));
            String password = HashPassword.decrypt(user.getPassword());
            assert password != null;
            if (user.getIdBank() != null && password.equals(req.getParameter("password"))) {

                Cookie cookie = new Cookie("idBank", HashPassword.encrypt(String.valueOf(user.getIdBank().getIdBank())));
                cookie.setPath(req.getContextPath() + "/pages/dashboard.jsp");
                resp.addCookie(cookie);
                resp.sendRedirect(req.getContextPath() + "/pages/dashboard.jsp");

            } else if (user.getIdClient() != null && password.equals(req.getParameter("password"))) {

                Cookie cookie = new Cookie("id", HashPassword.encrypt(String.valueOf(user.getIdClient().getIdClient())));
                cookie.setPath(req.getContextPath() + "/pages/client.jsp");
                resp.addCookie(cookie);

                resp.sendRedirect(req.getContextPath() + "/pages/client.jsp");
            } else {
                resp.sendRedirect(req.getContextPath());
            }


        } catch (Exception ex) {
            resp.sendRedirect("/pages/error.jsp");
        }
    }
}
