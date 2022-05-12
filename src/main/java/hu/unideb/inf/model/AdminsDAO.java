package hu.unideb.inf.model;

import java.util.List;

public interface AdminsDAO extends AutoCloseable{
    public void saveAdmin(Admins a);
    public List<Admins> getAdmin();
}
