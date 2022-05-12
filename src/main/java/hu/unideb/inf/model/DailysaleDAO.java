package hu.unideb.inf.model;

import java.util.List;

public interface DailysaleDAO extends AutoCloseable{
    public void saveDailysale(Dailysale a);
    public void updateDailysale(Dailysale a);
    public List<Dailysale> getDailysale();
}
