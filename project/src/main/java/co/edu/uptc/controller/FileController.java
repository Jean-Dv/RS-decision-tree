package co.edu.uptc.controller;

import co.edu.uptc.util.FilePersistence;

public class FileController {

    private FilePersistence<String> filePersistence;

    public FileController(FilePersistence<String> filePersistence) {
        this.filePersistence = filePersistence;
    }

    public String read() {
        return filePersistence.readFile();
    }
}
