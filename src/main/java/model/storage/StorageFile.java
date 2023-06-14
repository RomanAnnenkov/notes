package model.storage;

import model.AbstractNote;
import model.Note;
import model.converter.Converter;
import model.io.InputOutputOperation;
import model.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageFile implements Storage {
    InputOutputOperation inputOutputOperation;
    Converter converter;

    public StorageFile(InputOutputOperation inputOutputOperation, Converter converter) {
        this.inputOutputOperation = inputOutputOperation;
        this.converter = converter;
    }

    @Override
    public List<AbstractNote> getAllNotes() {
        List<AbstractNote> listNotes = new ArrayList<>();
        List<String> lines = inputOutputOperation.read();
        for (String line : lines) {
            listNotes.add(converter.convert(line));
        }
        return listNotes;
    }

    @Override
    public AbstractNote getNote(int id) throws Exception {
        List<AbstractNote> listNotes = getAllNotes();
        for (AbstractNote currentNote : listNotes) {
            if (currentNote.getId() == id) {
                return currentNote;
            }
        }
        throw new Exception("запись не найдена");
    }

    @Override
    public void createNote(AbstractNote note) {
        List<AbstractNote> listNotes = getAllNotes();
        listNotes.add(note);
        inputOutputOperation.write(getLines(listNotes));
    }

    private List<String> getLines(List<AbstractNote> notes) {
        List<String> lines = new ArrayList<>();
        for (AbstractNote note : notes) {
            lines.add(converter.convert((Note) note));
        }
        return lines;
    }

    @Override
    public AbstractNote updateNote(AbstractNote note) {
        List<AbstractNote> listNotes = getAllNotes();
        for (AbstractNote currentNote : listNotes) {
            if (currentNote.equals(note)) {
                currentNote.setId(note.getId());
                currentNote.setHeader(note.getHeader());
                currentNote.setText(note.getText());
            }
        }
        inputOutputOperation.write(getLines(listNotes));
        return note;
    }

    @Override
    public AbstractNote removeNote(AbstractNote note) {
        List<AbstractNote> listNotes = getAllNotes();
        int indexForRemove = listNotes.indexOf(note);
        AbstractNote removedNote = listNotes.remove(indexForRemove);
        inputOutputOperation.write(getLines(listNotes));
        return removedNote;
    }

    @Override
    public int getLastId() {
        List<AbstractNote> listNotes = getAllNotes();
        if (listNotes.size() == 0) {
            return 0;
        }
        int lastId = 0;
        for (AbstractNote note: listNotes) {
            int currentId = note.getId();
            if (currentId > lastId) {
                lastId = currentId;
            }
        }
        return lastId;
    }
}
