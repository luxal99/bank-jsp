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

@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{

            UserService userService = new UserServiceImpl();
            User user = userService.findByUsername(req.getParameter("username"));
            if (user.getIdBank() !=null && user.getPassword().equals(HashPassword.encrypt(req.getParameter("password")))){

                resp.sendRedirect(req.getContextPath() + "/pages/dashboard.jsp");
            }
            else{
                resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
            }
        }catch (Exception ex){
            resp.setStatus(404);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
