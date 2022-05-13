package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Admins implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Username;
    private String Password;

    public static Admins scannedAdmin(AdminsDataReader admin){
        int id;
        String username;
        String password;
        id = admin.getId();
        username = admin.getUsername();
        password = admin.getPassword();
        return new Admins(id, username, password);
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
        final Admins other = (Admins) obj;
        if (this.id != other.id) {
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

    public Admins(int id, String username, String password) {
        if (id<0) throw new RuntimeException();
        this.id = id;
        this.Username = username;
        this.Password = password;
    }

    public Admins()
    {

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
        return "Admin{" + "id=" + id + ", username=" + Username + ", password=" + Password + '}';
    }
}
