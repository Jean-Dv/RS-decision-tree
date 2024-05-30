package co.edu.uptc.util;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import co.edu.uptc.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePersistence<T> {

    private static final String filePath = "src\\main\\resources\\";
    private static final String fileExtension = ".csv";
    private File file;
    private ICSVWriter csvWriter;
    private CSVReader csvReader;

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

    public String[] readFile(String fileName) {
        file = new File(filePath + fileName + fileExtension);

        try {
            csvReader = new CSVReader(new FileReader(file));
            List<String> lines = new ArrayList<>();
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                lines.add(String.join(",", nextLine));
            }
            csvReader.close();
            return lines.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String[] userToCSVLine(User user) {
        return new String[] { user.getName(), user.getLastName(), user.getNationality(), user.getGender() };
    }
}
