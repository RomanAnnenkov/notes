package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListNotes<A extends AbstractNote> implements Iterable<A> {
    List<A> list = new ArrayList<>();

    public void addNote(A note) {
        list.add(note);
    }

    public A removeNote(int index) {
        return list.remove(index);
    }

    public A getNote(int index) {
        return list.get(index);
    }

    public void removeAllNotes() {
        list.clear();
    }

    @Override
    public Iterator<A> iterator() {
        return new Iterator<A>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public A next() {
                return list.get(index++);
            }
        };
    }
}
