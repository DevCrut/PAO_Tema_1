package org.example.csv;

import java.io.*;

public class CSVWriter {
    private static CSVWriter single_instance = null;
    private CSVWriter() {
    }
    public static synchronized CSVWriter getInstance() throws FileNotFoundException {
        if (single_instance == null)
            single_instance = new CSVWriter();

        return single_instance;
    }

    public String escapeAndQuote(String content) {
        return content.replace(",", "\\u002C").replace("\"", "\\u0022");
    }

    public void write(String data) {
        try {
            FileWriter csvWriter = new FileWriter("auditlog.csv", true);
            csvWriter.append(data);
            csvWriter.append("\n");
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
