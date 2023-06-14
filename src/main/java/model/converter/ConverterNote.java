package model.converter;

import model.Note;

public class ConverterNote implements Converter {
    String separator;

    public ConverterNote() {
        this.separator = ",";
    }

    public ConverterNote(String separator) {
        this.separator = separator;
    }

    @Override
    public String convert(Note note) {
        return note.getId() + separator +
                note.getHeader() + separator +
                note.getText();
    }

    @Override
    public Note convert(String str) {
        String[] elements = str.split(separator);
        return new Note(Integer.parseInt(elements[0]), elements[1], elements[2]);
    }
}
