package view;

public class Login{
    public Login(){}

    /**
     * Simple class to handle the display of the login/sign-up page
     * @return String containing the html code that can then be sent out to the user
     */
    public String getLoginPage(){
        String pageCode = "<form action='WebApp' method='POST'> \n" +
                "Username : <input type='text' name='username'/>\n"+
                "Password : <input type'password' name='password'/>\n" +
                "Password : <input type'password' name='confirm-password'/>\n" +
                "<input type='submit' name='form_btn' value='Log-in' />\n" +
                "<input type='submit' name='form_btn' value='Sign-up' />\n" +
                "</form>";

        return pageCode;
    }
}