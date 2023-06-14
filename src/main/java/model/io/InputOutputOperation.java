package model.io;

import java.util.List;

public interface InputOutputOperation {
    List<String> read();
    void write(List<String> lines);
}
