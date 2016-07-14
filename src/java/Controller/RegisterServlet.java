
package Controller;

import Model.Ppl;
import Model.PplDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alroy
 */
public class RegisterServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            HttpSession s=request.getSession();
            Ppl p=new Ppl();
            String ID = request.getParameter("id");
            String password = request.getParameter("pass");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            
            p.setId(ID);
            p.setPassword(password);
            p.setFirstname(fname);
            p.setLastname(lname);
            p.setEmail(email);
            
            s.setAttribute("Register", p);
            PplDAO pdao= new PplDAO();
            pdao.createAccount(p);
            
            response.sendRedirect("Login.jsp");
        }
        finally{
            
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
