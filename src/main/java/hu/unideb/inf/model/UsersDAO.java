package hu.unideb.inf.model;

import java.util.List;

public interface UsersDAO extends AutoCloseable{
    public void saveUser(Users a);
    public List<Users> getUser();
}
