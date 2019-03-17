package controller;

import model.User;
import model.UserHandler;
import view.Login;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;


/**
 * controller class that will handle incoming requests from a user. This servlet will make calls to the model and view package classes
 * to check the user info and display the correct webpages respectively
 *
 *
 */
@WebServlet(name="webapp",urlPatterns = {"/WebApp"})
public class RequestHandler  extends HttpServlet{

    private UserHandler userhandler;

    public void init(){
        userhandler = new UserHandler();
    }
    // get function that will handle the first request for the login page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //section to print out content in the loginpage
        //later, implement way to check what user wants through get/post params
        try(PrintWriter out = response.getWriter()){
            Login loginPage = new Login();
            out.println(loginPage.getLoginPage());

        }
    }

    /**
     * will parse the various post methods that will be possible in the flow of our webapp
     * @param req request header sent from the client, contains the post parameters that we will be checking here
     * @param response response object where we can input the html code for the response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            Enumeration<String> param_names = req.getParameterNames();
            String param;
            out.println("<ul>");
            while( (param = param_names.nextElement()) != null){
                String param_value = req.getParameter(param);
                out.println("<li>");
                out.println(param + " = " + param_value);
                out.println("</li>");
            }


            //
            if(req.getParameter("form_btn").equals("Log-in") ){
                //handle verifying user
                // check if the user exists in db

            }else{
                if(req.getParameter("form_btn") .equals("Sign-up") ){
                    //handle sign up portion
                    if(! req.getParameter("username").equals("")){
                        if(req.getParameter("password").equals(req.getParameter("confirm-password"))){
                            //then user entered the same password in both inputs, he can be persisted in database
                            User newUser = new User(req.getParameter("username"),req.getParameter("password"));
                            newUser.setSign_up_date(new Date()); //will also store current date
                            if(userhandler.createUser(newUser)){
                                out.println("successfully entered new user");
                            }

                        }else out.println("passwords not matching");
                    }else out.println("please enter a valid email as a username");


                }
            }

        }


    }
}
