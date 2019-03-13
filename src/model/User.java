package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * The order entity class. Exercise 3.
 * <p>
 * <i>Under construction.</i>
 *
 * @author Jean-Michel Busca
 */
@Entity
@Table(name = "users")
// "order" is a SQL keyword and therefore cannot be used as a table name,
// hence the use of the @Table annotation to change the name of the table
public class User {

    //
    // INSTANCE FIELDS
    //
    @Id
    @GeneratedValue
    private int id;
    private String mail;
    private String password;

    private Date sign_up_date;
    private Date last_sign_in;
    private Date last_access;

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;

        this.sign_up_date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSign_up_date() {
        return sign_up_date;
    }

    public void setSign_up_date(Date sign_up_date) {
        this.sign_up_date = sign_up_date;
    }

    public Date getLast_sign_in() {
        return last_sign_in;
    }

    public void setLast_sign_in(Date last_sign_in) {
        this.last_sign_in = last_sign_in;
    }

    public Date getLast_access() {
        return last_access;
    }

    public void setLast_access(Date last_access) {
        this.last_access = last_access;
    }
}
