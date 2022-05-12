package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Firstname;
    private String Lastname;
    private String Username;
    private String Password;

    public static Users scannedUser(UsersDataReader usr){
        int id;
        String firstname;
        String lastname;
        String username;
        String password;
        id = usr.getId();
        firstname = usr.getFirstname();
        lastname = usr.getLastname();
        username = usr.getUsername();
        password = usr.getPassword();
        return new Users(id, firstname, lastname, username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Firstname, other.Firstname)) {
            return false;
        }
        if (!Objects.equals(this.Lastname, other.Lastname)) {
            return false;
        }
        if (!Objects.equals(this.Username, other.Username)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        return true;
    }

    /*@Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.Firstname);
        hash = 11 * hash + Objects.hashCode(this.Lastname);
        hash = 11 * hash + Objects.hashCode(this.Username);
        hash = 11 * hash + Objects.hashCode(this.Password);
        return hash;
    }*/

    public Users(int id, String firstname, String lastname, String username, String password) {
        if (id<0) throw new RuntimeException();
        this.id = id;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Username = username;
        this.Password = password;
    }

    public Users()
    {

    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstname=" + Firstname + ", lastname=" + Lastname + ", username=" + Username + ", password=" + Password + '}';
    }
}
