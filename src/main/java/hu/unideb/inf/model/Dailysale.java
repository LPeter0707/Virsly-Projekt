package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Dailysale implements Serializable {

    public static Dailysale scannedDailysale(DailysaleDataReader dailysale){
        Integer id;
        String name;
        Integer count;
        id = dailysale.getId();
        name = dailysale.getName();
        count = dailysale.getCount();
        return new Dailysale(id, name, count);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Name;
    private Integer Count;

    public Dailysale (Integer id, String name, Integer count)
    {
        this.id = id;
        this.Name = name;
        this.Count = count;
    }

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
        final Dailysale other = (Dailysale) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Count, other.Count)) {
            return false;
        }
        return true;
    }

    public Dailysale (){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public String toString() {
        return "Dailysale{" + "id=" + id + ", name=" + Name + ", count=" + Count +'}';
    }
}
