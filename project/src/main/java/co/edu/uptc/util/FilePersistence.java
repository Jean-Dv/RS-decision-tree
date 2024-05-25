package co.edu.uptc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class FilePersistence<T> {
    private File file;
    private CSVReader csvReader;
    private static final String filePath = "project\\src\\main\\java\\co\\edu\\uptc\\files\\";
    private static final String fileExtension = ".csv";
    private String fileName;

    public FilePersistence(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() {
        file = new File(this.fileName);
        StringBuilder result = new StringBuilder();

        try {
            csvReader = new CSVReader(new FileReader(filePath + file + fileExtension));
            String[] nextLine = null;
            while ((nextLine = csvReader.readNext()) != null) {
                result.append(String.join(" , ", nextLine)).append("\n");
            }
            csvReader.close();
            return result.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
