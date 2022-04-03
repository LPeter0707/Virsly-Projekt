package hu.unideb.inf.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserDAO implements UsersDAO{

    private List<Users> users = null;

    public FileUserDAO(){
        try (FileInputStream fis = new FileInputStream("users.ser");
             ObjectInputStream ois = new ObjectInputStream(fis);){
            users = (List<Users>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
    }


    private void serialize(){
        try (FileOutputStream fos = new FileOutputStream("users.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(Users a) {
        if (!users.contains(a)) users.add(a);
        serialize();
    }

    @Override
    public List<Users> getUser() {
        return users;
    }

    @Override
    public void close() throws Exception {
        serialize();
    }
}
