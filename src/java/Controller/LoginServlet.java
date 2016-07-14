
package Controller;

//import Model.Files;
//import Model.FilesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Ppl;
import Model.Login;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import Model.PplDAO;
//import java.util.ArrayList;

/**
 *
 * @author Alroy
 */
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
            HttpSession s=request.getSession();
            Login l=new Login();
            String loginID = request.getParameter("id");
            String password = request.getParameter("passwd");
            l.setLoginID(loginID);
            l.setPassword(password);
            s.setAttribute("Login", l);
            
            //out.println("Login page ");       /*Testing purposes*/
            //out.println(l.getLoginID());
            //out.println(l.getPassword());
            
            PplDAO pdao = new PplDAO();
            //FilesDAO fdao = new FilesDAO();
            boolean b = pdao.checkLogin(l);
            if(b){
                Ppl p = new Ppl();
                p = pdao.findPersonByID(loginID);
                
                /*
                ArrayList<Files> addlist = new ArrayList<Files>();
                addlist = (ArrayList<Files>) fdao.getFiles(loginID);
                int count = addlist.size();
                */
                
                s.setAttribute("person", p);
                //s.setAttribute("count", count);
                response.sendRedirect("ProfileServlet");
            }
            else{
                request.setAttribute("errormsg","You have entered incorrect password");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.include(request, response);
            }
        }
        finally{
            out.close();
        }
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
