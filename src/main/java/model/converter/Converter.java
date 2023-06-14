package model.converter;

import model.Note;

public interface Converter {
    String convert(Note note);
    Note convert(String str);
}
