package views;

import controllers.NoteController;
import model.Note;

import java.util.Scanner;

public class ViewNote {
    private final NoteController noteController;
    private final Scanner scanner = new Scanner(System.in);

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        String help = """
                Команды:
                create - создать заметку
                read - показать заметку
                all - показать все заметки
                edit - изменить записку
                remove - удалить записку
                exit - выход""";
        while (true) {
            System.out.print("Ввод: ");
            String userCommand = scanner.nextLine().toLowerCase();
            if (userCommand.equals("exit")) {
                return;
            }
            switch (userCommand) {
                case "create":
                    createNote();
                    break;
                case "read":
                    readNote();
                    break;
                case "all":
                    showAllNotes();
                    break;
                case "edit":
                    updateNote();
                    break;
                case "remove":
                    removeNote();
                    break;
                default:
                    System.out.println(help);
            }
        }
    }

    private void createNote() {
        int id = noteController.getLastId() + 1;
        System.out.print("Заголовок: ");
        String header = scanner.nextLine();
        System.out.print("Текст: ");
        String text = scanner.nextLine();
        noteController.saveNote(new Note(id, header, text));
    }

    private void readNote() {
        System.out.println("read note");
    }

    private void showAllNotes() {
        System.out.println("read all notes");
    }

    private void updateNote() {
        System.out.println("update note");
    }

    private void removeNote() {
        System.out.println("remove note");
    }
}
