package model.converter;

import model.Note;

public class ConverterNote implements Converter {
    String spliterator;

    public ConverterNote() {
        this.spliterator = ",";
    }

    public ConverterNote(String spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public String convert(Note note) {
        return note.getId() + spliterator +
                note.getHeader() + spliterator +
                note.getText();
    }

    @Override
    public Note convert(String str) {
        String[] elements = str.split(spliterator);
        return new Note(Integer.getInteger(elements[0]), elements[1], elements[2]);
    }
}
