package hu.unideb.inf.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAdminDAO implements AdminsDAO{

    private List<Admins> admins = null;

    public FileAdminDAO(){
        try (FileInputStream fis = new FileInputStream("admins.ser");
             ObjectInputStream ois = new ObjectInputStream(fis);){
            admins = (List<Admins>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            admins = new ArrayList<>();
        }
    }


    private void serialize(){
        try (FileOutputStream fos = new FileOutputStream("admins.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(admins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAdmin(Admins a) {
        if (!admins.contains(a)) admins.add(a);
        serialize();
    }

    @Override
    public List<Admins> getAdmin() {
        return admins;
    }

    @Override
    public void close() throws Exception {
        serialize();
    }
}
