package views;

import controllers.NoteController;
import model.AbstractNote;
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
                    addNote();
                    break;
                case "read":
                    showNote();
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

    private void addNote() {
        noteController.saveNote(createNote());
    }

    private AbstractNote createNote() {
        int id = noteController.getLastId() + 1;
        System.out.print("Заголовок: ");
        String header = scanner.nextLine();
        System.out.print("Текст: ");
        String text = scanner.nextLine();
        return new Note(id, header, text);
    }

    private AbstractNote readNote() throws Exception {
        return noteController.readNote(getId());
    }

    private int getId() throws Exception {
        System.out.print("Введите id: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception ignored) {
        }
        throw new Exception("Введённый id не число");
    }

    private void showNote() {
        try {
            System.out.println(readNote());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void showAllNotes() {
        for (var note : noteController.readAllNotes()) {
            System.out.println(note);
        }
    }

    private void updateNote() {
        try {
            AbstractNote note = readNote();
            AbstractNote newNote = createNote();
            newNote.setId(note.getId());
            AbstractNote updatedNote = noteController.updateNote(newNote);
            System.out.println("---updated---");
            System.out.println(updatedNote);
            System.out.println("---updated---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeNote() {
        try {
            AbstractNote note = readNote();
            AbstractNote deletedNote = noteController.deleteNote(note);
            System.out.println("---deleted---");
            System.out.println(deletedNote);
            System.out.println("---deleted---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
