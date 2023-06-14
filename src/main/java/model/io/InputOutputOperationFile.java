package model.io;

import model.io.InputOutputOperation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutputOperationFile implements InputOutputOperation {
    String filePath;

    public InputOutputOperationFile(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public List<String> read() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    @Override
    public void write(List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line: lines) {
                writer.write(line);
                writer.append('\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
