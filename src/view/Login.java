package view;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="login",urlPatterns = {"/login"})
public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(req.getParameter("username").equals("antoine") && req.getParameter("password").equals("thery") ){
            //redirect to process page
            RequestDispatcher dispatch = req.getRequestDispatcher("/process");
            dispatch.forward(req,response);
        }else{
            try(PrintWriter out = response.getWriter()){
                out.println("<h1 color='red'>Incorrect credentials </h1>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //section to print out content in the page
        try(PrintWriter out = response.getWriter()){
            out.println("<form action='login' method='POST'>");
            out.println("Username : <input type='text' name='username'/>");
            out.println("Password : <input type'text' name='password'/>");
            out.println("<input type='submit' value='Log in' />");
            out.println("</form>");
        }
    }
}
