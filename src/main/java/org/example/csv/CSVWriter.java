package org.example.csv;

import java.io.*;

public class CSVWriter {
    private static CSVWriter single_instance = null;
    private static CSVWriterThread writeTask;
    private CSVWriter() {
        writeTask = new CSVWriterThread();
        startTask();
    }

    public String escapeAndQuote(String content) {
        return content.replace(",", "\\u002C").replace("\"", "\\u0022");
    }
    public void write(String data) {
        writeTask.addWrite(data);
    }

    private static void startTask(){
        writeTask.start();
    }
    public static void endTask(){
        writeTask.interrupt();
    }
    public static synchronized CSVWriter getInstance() throws FileNotFoundException {
        if (single_instance == null)
            single_instance = new CSVWriter();

        return single_instance;
    }
}
