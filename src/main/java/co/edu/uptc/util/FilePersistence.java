package co.edu.uptc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import co.edu.uptc.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePersistence<T> {

    private static final String filePath = "src/main/resources/";
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

    public List<String[]> readFile(String fileName) {
        file = new File(filePath + fileName + fileExtension);
        CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(false).build();

        try {
            csvReader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).withCSVParser(parser).build();
            List<String[]> lines = new ArrayList<>();
            lines = csvReader.readAll();
            csvReader.close();
            return lines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String[] userToCSVLine(User user) {
        return new String[] { user.getName(), user.getLastName(), user.getNationality(), user.getGender() };
    }
}
