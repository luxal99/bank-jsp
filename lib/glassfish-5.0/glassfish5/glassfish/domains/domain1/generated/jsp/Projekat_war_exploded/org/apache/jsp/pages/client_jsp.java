package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import example.util.HashPassword;

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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Title</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/client.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n");
      out.write("          integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
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

        try {

            Cookie[] cookies = request.getCookies();
            Cookie idCookie = new Cookie("id", "");


            boolean haveCookie = false;

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    idCookie.setValue(cookie.getValue());
                    haveCookie = true;
                }
            }
            if (!haveCookie) {
                response.sendRedirect(request.getContextPath());
            }

            request.setAttribute("idCookie", idCookie);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath());
        }

    
      out.write("\n");
      out.write("\n");
      out.write("    ");
 Cookie cookie = (Cookie) request.getAttribute("idCookie");
    out.println(HashPassword.decrypt(cookie.getValue()));
    
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\" header-menu\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm text-left\" style=\"padding-top: .5em;padding-bottom: .5em\">\n");
      out.write("                <img src=\"https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/1280px-Starling_Bank_Logo.svg.png?alt=media&token=260dc062-b7a4-432a-8c0c-bd4c5c542687\" width=\"100px\" class=\"img-fluid\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm text-left\">\n");
      out.write("\n");
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
      out.write("            <<div class=\"col-sm-9\">\n");
      out.write("            <div class=\"tab-content\" id=\"v-pills-tabContent\">\n");
      out.write("                <div class=\"tab-pane fade\" id=\"v-pills-home\" role=\"tabpanel\" aria-labelledby=\"v-pills-messages-tab\"></div>\n");
      out.write("                <div class=\"tab-pane fade\" id=\"v-pills-profile\" role=\"tabpanel\" aria-labelledby=\"v-pills-messages-tab\"></div>\n");
      out.write("                <div class=\"tab-pane fade\" id=\"v-pills-messages\" role=\"tabpanel\" aria-labelledby=\"v-pills-messages-tab\"></div>\n");
      out.write("                <div class=\"tab-pane fade\" id=\"v-pills-settings\" role=\"tabpanel\" aria-labelledby=\"v-pills-settings-tab\">\n");
      out.write("                    ...\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
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
