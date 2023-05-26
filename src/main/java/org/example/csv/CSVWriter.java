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

    public void write(String data) {
        try {
            FileWriter csvWriter = new FileWriter("auditlog.csv", true);
            BufferedWriter writer = new BufferedWriter(csvWriter);
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
