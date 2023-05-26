package org.example.csv;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class CSVWriterThread extends Thread {
    private static ConcurrentLinkedQueue<String> queue;
    public CSVWriterThread(){
        queue = new ConcurrentLinkedQueue<>();
    }

    public void addWrite(String s){
        queue.offer(s);
    }
    @Override
    public void run() {
        while (true)
            if (queue.isEmpty() == false) {
                String data = queue.poll();
                try {
                    FileWriter csvWriter = new FileWriter("auditlog.csv", true);
                    csvWriter.append(data);
                    csvWriter.append("\n");
                    csvWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else{
                if (Thread.interrupted() == true){
                    break;
                }
            }
    }
}
