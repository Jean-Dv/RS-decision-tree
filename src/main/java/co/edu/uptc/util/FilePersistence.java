package co.edu.uptc.util;

import java.util.ArrayList;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import co.edu.uptc.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FilePersistence<T> {

    private static final String filePath = "src\\main\\resources\\";
    private static final String fileExtension = ".csv";
    private File file;
    private ICSVWriter csvWriter;

    public boolean saveUsersToCSV(String[] date, String fileName) {
        String fullFilePath = filePath + fileName + fileExtension;
        file = new File(fullFilePath);

        try (FileWriter fileWriter = new FileWriter(fullFilePath, true)) {
            csvWriter = new CSVWriterBuilder(fileWriter)
                    .withQuoteChar(ICSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            String[] userCSV = date;
            csvWriter.writeNext(userCSV);

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }

    }

}
