package view;

import model.User;

public class UserPage {

    /**
     * handles the request for the user web page
     * @param user
     * @return
     */
    public String getUserPage(User user){

        String output = "<h2>Welcome:</h2>\n" +
                "<h3>"+user.getMail()+"</h3>\n" +
                "<ul>\n" +
                "<li> Sign up date:" + user.getSign_up_date() + "</li>\n" +
                "<li> Last sign in date:" + user.getLast_sign_in() + "</li>\n" +
                "<li> Last access date:" + user.getLast_access() + "</li>\n" +
                "</ul>\n" +
                "<form action='WebApp' method='POST'>\n" +
                "<input type='submit' name='form_btn' value='update'>\n" +
                "<input type='submit' name='form_btn' value='sign-out'>\n" +
                "<input type='submit' name='form_btn' value='delete-account'>\n" +
                "</form>";
        return output;

    }
}
