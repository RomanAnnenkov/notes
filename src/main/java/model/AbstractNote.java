package model;

import java.util.Objects;

public abstract class AbstractNote {
    protected int id;
    protected String header;
    protected String text;

    public AbstractNote(int id, String header, String text) {
        this.id = id;
        this.header = header;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractNote that = (AbstractNote) o;
        return id == that.id && Objects.equals(header, that.header) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, header, text);
    }
}
