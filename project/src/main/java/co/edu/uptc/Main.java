package co.edu.uptc;

import co.edu.uptc.controller.FileController;
import co.edu.uptc.util.FilePersistence;

public class Main {
    public static void main(String[] args) {

        FilePersistence<String> fp = new FilePersistence<>("Archivo");
        FileController fc = new FileController(fp);

        System.out.println(fc.read());
    }
}