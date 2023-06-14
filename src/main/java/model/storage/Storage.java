package model.storage;

import model.AbstractNote;

import java.util.List;

public interface Storage {
    List<AbstractNote> getAllNotes();
    AbstractNote getNote(int id) throws Exception;
    void createNote(AbstractNote note);
    AbstractNote updateNote(AbstractNote note);
    AbstractNote removeNote(AbstractNote note);
    int getLastId();
}
