package model;

public class Note extends AbstractNote{
    public Note(int id, String header, String text) {
        super(id, header, text);
    }

    @Override
    public String toString() {
        return String.format("model.Note{id: %d, header: %s, text: %s}", id, header, text);
    }

}
