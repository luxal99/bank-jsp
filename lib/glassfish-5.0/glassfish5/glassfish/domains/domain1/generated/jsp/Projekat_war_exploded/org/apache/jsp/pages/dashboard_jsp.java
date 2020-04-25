package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import example.entity.Client;
import java.util.List;
import example.entity.UserType;
import example.service.*;
import example.entity.Account;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/dashboard.css\">\n");
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
      out.write("    <title>Title</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"row\" style=\"height: 100vh\">\n");
      out.write("\n");
      out.write("    <div class=\"col-3 menu\">\n");
      out.write("        <div class=\"nav flex-column nav-pills\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">\n");
      out.write("            <a class=\"nav-link active\" id=\"v-pills-home-tab\" data-toggle=\"pill\" href=\"#v-pills-home\" role=\"tab\"\n");
      out.write("               aria-controls=\"v-pills-home\" aria-selected=\"true\">Clients</a>\n");
      out.write("            <a class=\"nav-link\" id=\"v-pills-profile-tab\" data-toggle=\"pill\" href=\"#v-pills-profile\" role=\"tab\"\n");
      out.write("               aria-controls=\"v-pills-profile\" aria-selected=\"false\">Accounts</a>\n");
      out.write("            <a class=\"nav-link\" id=\"v-pills-messages-tab\" data-toggle=\"pill\" href=\"#v-pills-messages\" role=\"tab\"\n");
      out.write("               aria-controls=\"v-pills-messages\" aria-selected=\"false\">Transaction</a>\n");
      out.write("            <a class=\"nav-link\" id=\"v-pills-settings-tab\" data-toggle=\"pill\" href=\"#v-pills-settings\" role=\"tab\"\n");
      out.write("               aria-controls=\"v-pills-settings\" aria-selected=\"false\">Settings</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-9\">\n");
      out.write("        <div class=\"tab-content\" id=\"v-pills-tabContent\">\n");
      out.write("            <div class=\"tab-pane fade show active\" id=\"v-pills-home\" role=\"tabpanel\" aria-labelledby=\"v-pills-home-tab\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <h2 class=\"text-center\">Modal Example</h2>\n");
      out.write("                    <!-- Trigger the modal with a button -->\n");
      out.write("                    <button type=\"button\" class=\"open-btn\" data-toggle=\"modal\" data-target=\"#myModal\">Open\n");
      out.write("                        Modal\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                    <!-- Modal -->\n");
      out.write("                    <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                            <!-- Modal content-->\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                                    <h4 class=\"modal-title\">Modal Header</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <form method=\"post\" action=\"/Projekat_war_exploded/admin/registration\">\n");
      out.write("\n");
      out.write("                                        <div class=\"col-sm\">\n");
      out.write("                                            <h3>Client information</h3>\n");
      out.write("                                            <div style=\"height: 1px;background-color: #e1e1e1\"></div>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\" style=\"margin-top: 1em\">\n");
      out.write("                                                <div class=\"col-sm\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label for=\"exampleInputEmail1\">Name</label>\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" name=\"name\"\n");
      out.write("                                                               id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-sm\">\n");
      out.write("                                                    <div class=\"form-group\">\n");
      out.write("                                                        <label for=\"exampleInputPassword1\">Lastname</label>\n");
      out.write("                                                        <input type=\"text\" name=\"lastname\" class=\"form-control\"\n");
      out.write("                                                               id=\"exampleInputPassword1\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"exampleInputEmail1\">E-mail</label>\n");
      out.write("                                                <input type=\"email\" name=\"email\" class=\"form-control\"\n");
      out.write("                                                       id=\"exampleInputEmail1\"\n");
      out.write("                                                       aria-describedby=\"emailHelp\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"exampleInputPassword1\">Telephone</label>\n");
      out.write("                                                <input type=\"text\" name=\"telephone\" class=\"form-control\"\n");
      out.write("                                                       id=\"exampleInputPassword1\">\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm\">\n");
      out.write("                                            <h3>User data</h3>\n");
      out.write("                                            <div style=\"height: 1px;background-color: #e1e1e1\"></div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"exampleInputEmail1\">Username</label>\n");
      out.write("                                                <input type=\"text\" name=\"username\" class=\"form-control\"\n");
      out.write("                                                       id=\"exampleInputEmail1\"\n");
      out.write("                                                       aria-describedby=\"emailHelp\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <br>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"exampleInputEmail1\">Password</label>\n");
      out.write("                                                <input type=\"password\" name=\"password\" class=\"form-control\"\n");
      out.write("                                                       id=\"exampleInputEmail1\"\n");
      out.write("                                                       aria-describedby=\"emailHelp\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm\">\n");
      out.write("                                            <h3>Accout data</h3>\n");
      out.write("                                            <div style=\"height: 1px;background-color: #e1e1e1\"></div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"exampleInputEmail1\">Account number</label>\n");
      out.write("                                                <input type=\"text\" name=\"accountNumber\" class=\"form-control\"\n");
      out.write("                                                       id=\"exampleInputEmail1\"\n");
      out.write("                                                       aria-describedby=\"emailHelp\">\n");
      out.write("                                            </div>\n");
      out.write("                                            ");

                                                UserTypeService userTypeService = new UserTypeServiceImpl();
                                                List<UserType> userTypeList = userTypeService.getAll();
                                                request.setAttribute("userTypeList", userTypeList);

                                            
      out.write("\n");
      out.write("                                            <select name=\"userType\" class=\"form-control form-control-lg\">\n");
      out.write("\n");
      out.write("                                                ");
 for (int i = 0; i < userTypeList.size(); i += 1) { 
      out.write("\n");
      out.write("\n");
      out.write("                                                <option value=\"");
      out.print( userTypeList.get(i).getIdUserType() );
      out.write('"');
      out.write('>');
      out.print(userTypeList.get(i).getTitle());
      out.write("\n");
      out.write("                                                </option>\n");
      out.write("\n");
      out.write("                                                ");
 }

                                                
      out.write("\n");
      out.write("                                            </select>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"text-center\" style=\"margin-left: 1em;margin-top: 1em\">\n");
      out.write("                                            <button class=\"btn btn-primary\" type=\"submit\">Register</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <table class=\"table\">\n");
      out.write("                        <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th scope=\"col\">#</th>\n");
      out.write("                            <th scope=\"col\">First</th>\n");
      out.write("                            <th scope=\"col\">Last</th>\n");
      out.write("                            <th scope=\"col\">Handle</th>\n");
      out.write("                        </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("\n");
      out.write("                        ");

                            ClientService clientService = new ClientServiceImpl();
                            List<Client> clientList = clientService.getAll();

                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");
 for (int i = 0; i < clientList.size(); i += 1) { 
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print( clientList.get(i).getName() );
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>");
      out.print( clientList.get(i).getLastname() );
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>");
      out.print( clientList.get(i).getMail() );
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>");
      out.print( clientList.get(i).getTelephone() );
      out.write("\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        ");
 }

                        
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"tab-pane fade\" id=\"v-pills-profile\" role=\"tabpanel\" aria-labelledby=\"v-pills-profile-tab\">\n");
      out.write("\n");
      out.write("                ");

                    AccountService accountService = new AccountServiceImpl();
                    List<Account> accountList = accountService.getAll();
                
      out.write("\n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">#</th>\n");
      out.write("                        <th scope=\"col\">Account Number</th>\n");
      out.write("                        <th scope=\"col\">Client ID</th>\n");
      out.write("                        <th scope=\"col\">Balance</th>\n");
      out.write("                        <th scope=\"col\">Client name</th>\n");
      out.write("                        <th scope=\"col\">Client lastname</th>\n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 for (Account account : accountList) { 
      out.write("\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( account.getIdAccount() );
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>");
      out.print( account.getAccountNumber() );
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>");
      out.print( account.getIdClient().getIdClient() );
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>");
      out.print( account.getBalance() );
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>");
      out.print( account.getIdClient().getName() );
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>");
      out.print( account.getIdClient().getLastname() );
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <form method=\"get\" action=\"dashboard.jsp\">\n");
      out.write("                                <button class=\"open-btn\" type=\"submit\" name=\"clientInfo\">\n");
      out.write("                                    Select client\n");
      out.write("                                </button>\n");
      out.write("                                <input type=\"hidden\" name=\"idAccount\" value=\"");
      out.print(account.getIdAccount());
      out.write("\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </td>\n");
      out.write("                        <td></td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
                    
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <button class=\"pay-btn\" type=\"button\" data-toggle=\"modal\" data-target=\"#payUpModal\">Pay up</button>\n");
      out.write("                <div style=\"height: 1px;background-color: #eee;margin-top: 1em\"></div>\n");
      out.write("                <h3>Current selected client</h3>\n");
      out.write("                ");

                    if (request.getParameter("clientInfo") != null) {
                        Account account = accountService.findById(Integer.valueOf(request.getParameter("idAccount")));
                        request.getSession().setAttribute("account", account);

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                <div style=\"margin-top: 1em\">\n");
      out.write("                    <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.accountNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                    <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                    <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.lastname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                    <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.mail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                    <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.telephone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"tab-pane fade\" id=\"v-pills-messages\" role=\"tabpanel\" aria-labelledby=\"v-pills-messages-tab\">\n");
      out.write("                ...\n");
      out.write("            </div>\n");
      out.write("            <div class=\"tab-pane fade\" id=\"v-pills-settings\" role=\"tabpanel\" aria-labelledby=\"v-pills-settings-tab\">\n");
      out.write("                ...\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Button trigger modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Modal -->\n");
      out.write("        <div class=\"modal fade\" id=\"payUpModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\n");
      out.write("             aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modal title</h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <h3>Account number: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.accountNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <form method=\"post\" action=\"/Projekat_war_exploded/admin/account\">\n");
      out.write("                            <input class=\"form-control\" type=\"text\" name=\"amount\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.balance}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                            <input class=\"form-control\" type=\"hidden\" name=\"accountNumber\"\n");
      out.write("                                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.accountNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                            <input class=\"form-control\" type=\"hidden\" name=\"idAccount\"\n");
      out.write("                                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idAccount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        <button type=\"submit\" name=\"payUp\" class=\"btn btn-primary\">Save changes</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"modal fade\" id=\"clientModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\n");
      out.write("             aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modal title</h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                        <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.lastname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                        <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.mail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                        <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.idClient.telephone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
