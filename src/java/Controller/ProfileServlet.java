
package Controller;

import Model.Files;
import Model.FilesDAO;
import Model.Ppl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alroy
 */
public class ProfileServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        HttpSession s = request.getSession(false);
        if(s != null){
            Ppl p = new Ppl();
            p = (Ppl)s.getAttribute("person");
            FilesDAO fdao = new FilesDAO();
            ArrayList<Files> addlist = new ArrayList<Files>();
            addlist = (ArrayList<Files>) fdao.getFiles(p.getId());
            int count = addlist.size();
            float size = 0;
            for(int i = 0; i < count; i++){
                size += addlist.get(i).getSize();
            }
            //out.print("Size: " + count);
            //for(int i = 0; i < count; i++){
              //  request.setAttribute("file"+count, addlist.get(i).getFilename());
            //}
            size = size/1024;
            if(size > 2000){
                request.setAttribute("warn", "Buy more space");
            }
            
            ArrayList<Files> addlist1 = new ArrayList<Files>();
            addlist1 = (ArrayList<Files>) fdao.getShareFiles(p.getId());
            
            request.setAttribute("fname", p.getFirstname());
            request.setAttribute("lname", p.getLastname());
            request.setAttribute("id", p.getId());
            request.setAttribute("count", count);
            request.setAttribute("addlist", addlist);
            request.setAttribute("addlist1", addlist1);
            request.setAttribute("size", size);
            getServletContext().getRequestDispatcher("/Profile.jsp").forward(request, response);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
