package org.example.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVWriter {
    private static CSVWriter single_instance = null;
    private CSVWriter() {
    }
    public static synchronized CSVWriter getInstance() throws FileNotFoundException {
        if (single_instance == null)
            single_instance = new CSVWriter();

        return single_instance;
    }

    public void write(String data) throws FileNotFoundException {
        File auditLog = new File("auditlog.csv");
        PrintWriter csvWriter = new PrintWriter(auditLog);
        csvWriter.write(data + '\n');
        csvWriter.close();
    }
}
