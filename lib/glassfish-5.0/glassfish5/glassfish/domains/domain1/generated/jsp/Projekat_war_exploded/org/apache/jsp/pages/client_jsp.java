package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import example.util.HashPassword;
import example.service.ClientService;
import example.service.ClientServiceImpl;
import example.entity.Client;
import com.sun.xml.bind.v2.model.core.ID;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public final class client_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Title</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/client.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n");
      out.write("          integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/node_modules/font-awesome/css/font-awesome.min.css\">\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"\n");
      out.write("            integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"\n");
      out.write("            integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"\n");
      out.write("            integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div>\n");
      out.write("    ");


        Cookie[] cookies = request.getCookies();
        Cookie idCookie = new Cookie("id", "");

        boolean haveId = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                haveId = true;
                idCookie.setValue(cookie.getValue());
            }
        }

        if (!haveId) {
            response.sendRedirect(request.getContextPath());
        }

        ClientService clientService = new ClientServiceImpl();
        Client client = clientService.findClientById(Integer.valueOf(HashPassword.decrypt(idCookie.getValue())));

        request.setAttribute("clinet",client);


    
      out.write("\n");
      out.write("    <div class=\" header-menu\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm text-left\" style=\"padding-top: .5em;padding-bottom: .5em\">\n");
      out.write("                <img src=\"https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/1280px-Starling_Bank_Logo.svg.png?alt=media&token=260dc062-b7a4-432a-8c0c-bd4c5c542687\"\n");
      out.write("                     width=\"100px\" class=\"img-fluid\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm text-right\">\n");
      out.write("                <button type=\"button\" class=\"profile-btn\" data-toggle=\"modal\" data-target=\"#exampleModal\"><h4><i class=\"fa fa-user\"></i> Profile</h4></button>\n");
      out.write("                <button type=\"button\" class=\"profile-btn\" data-toggle=\"modal\" data-target=\"#clientInfoModel\"><h4><i class=\"fa fa-user\"></i> Client information</h4></button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"content-container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-3 menu\">\n");
      out.write("                <div class=\"nav flex-column nav-pills\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">\n");
      out.write("                    <a class=\"nav-link active\" id=\"v-pills-home-tab\" data-toggle=\"pill\" href=\"#v-pills-home\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-home\" aria-selected=\"true\">Clients</a>\n");
      out.write("                    <a class=\"nav-link\" id=\"v-pills-profile-tab\" data-toggle=\"pill\" href=\"#v-pills-profile\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-profile\" aria-selected=\"false\">Accounts</a>\n");
      out.write("                    <a class=\"nav-link\" id=\"v-pills-messages-tab\" data-toggle=\"pill\" href=\"#v-pills-messages\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-messages\" aria-selected=\"false\">Transaction</a>\n");
      out.write("                    <a class=\"nav-link\" id=\"v-pills-settings-tab\" data-toggle=\"pill\" href=\"#v-pills-settings\" role=\"tab\"\n");
      out.write("                       aria-controls=\"v-pills-settings\" aria-selected=\"false\">Settings</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-1\"></div>\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <div class=\"client-info-div\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-3\">\n");
      out.write("                            <h4>Hello, <span>");
      out.print(client.getName());
      out.write("</span></h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-9 text-right\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h4 >Your username <br> <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.userList.get(0).username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h4>Your client id <br> <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.idClient}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"height: 1px;background-color: #eee\"></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"tab-content\" id=\"v-pills-tabContent\">\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"v-pills-home\" role=\"tabpanel\" aria-labelledby=\"v-pills-messages-tab\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"v-pills-profile\" role=\"tabpanel\"\n");
      out.write("                         aria-labelledby=\"v-pills-messages-tab\"></div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"v-pills-messages\" role=\"tabpanel\"\n");
      out.write("                         aria-labelledby=\"v-pills-messages-tab\"></div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"v-pills-settings\" role=\"tabpanel\"\n");
      out.write("                         aria-labelledby=\"v-pills-settings-tab\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Button trigger modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Modal -->\n");
      out.write("    <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">User information</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form action=\"/Projekat_war_exploded/client/user\" method=\"post\">\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"exampleInputEmail1\">Username</label>\n");
      out.write("                                <input type=\"text\" name=\"username\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.userList.get(0).username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n");
      out.write("                                <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"exampleInputPassword1\">Current password</label>\n");
      out.write("                                <input type=\"password\" name=\"password\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Password\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"exampleInputPassword1\">New password</label>\n");
      out.write("                                <input type=\"password\" name=\"newPassword\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Password\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"modal fade\" id=\"clientInfoModel\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Client information</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form method=\"post\" action=\"/Projekat_war_exploded/client\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"exampleInputEmail1\">Telephone</label>\n");
      out.write("                                <input type=\"text\" name=\"telephone\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.telephone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n");
      out.write("                                <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"exampleInputPassword1\">Email</label>\n");
      out.write("                                <input  type=\"text\" name=\"email\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Password\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"exampleInputPassword1\">Email</label>\n");
      out.write("                            <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clinet.idClient}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  type=\"hidden\" name=\"idClient\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Password\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
