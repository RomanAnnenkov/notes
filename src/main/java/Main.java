import controllers.NoteController;
import model.converter.ConverterNote;
import model.io.InputOutputOperation;
import model.io.InputOutputOperationFile;
import model.storage.Storage;
import model.storage.StorageFile;
import views.ViewNote;

public class Main {
    public static void main(String[] args) {
        InputOutputOperation file = new InputOutputOperationFile("notes.txt");
        Storage storage = new StorageFile(file, new ConverterNote());
        ViewNote viewNote = new ViewNote(new NoteController(storage));
        viewNote.run();
    }
}
