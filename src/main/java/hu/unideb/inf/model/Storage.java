package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Storage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Name;
    private Integer Piece;

    public static Storage scannedMaterial(StorageDataReader str){
        int id;
        String name;
        int piece;
        id = str.getId();
        name = str.getName();
        piece = str.getPiece();
        return new Storage(id, name, piece);
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
        final Storage other = (Storage) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Piece, other.Piece)) {
            return false;
        }
        return true;
    }

    public Storage(int id, String name, int piece) {
        if (id<0) throw new RuntimeException();
        this.id = id;
        this.Name = name;
        this.Piece = piece;
    }

    public Storage()
    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPiece() {
        return Piece;
    }

    public void setPiece(int piece) {
        this.Piece = piece;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Storage{" + "id=" + id + ", name=" + Name + ", piece=" + Piece + '}';
    }
}
