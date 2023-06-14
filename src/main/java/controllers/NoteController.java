package controllers;

import model.AbstractNote;
import model.storage.Storage;
import java.util.List;

public class NoteController {
    private Storage storage;

    public NoteController(Storage storage) {
        this.storage = storage;
    }

    public void saveNote(AbstractNote note) {
        storage.createNote(note);
    }

    public AbstractNote readNote(int id) {
        return storage.getNote(id);
    }

    public List<AbstractNote> readAllNotes() {
        return storage.getAllNotes();
    }

    public AbstractNote updateNote(AbstractNote note) {
        return storage.updateNote(note);
    }

    public AbstractNote deleteNote(AbstractNote note) {
        return storage.removeNote(note);
    }

    public int getLastId() {
        return storage.getLastId();
    }
}
