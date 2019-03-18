package view;

import model.User;

public class SignOut {
    public String getSignOutPage(User user){
        String s = "<h2> "+ user.getMail() + " Signed out </h2>";
        return s;
    }
}
