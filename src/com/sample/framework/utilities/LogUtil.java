package com.sample.framework.utilities;

import com.sample.framework.config.Settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    //file format for the log name
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
    String fileNameFormat = date.format(formatter);
    //create log file
    private BufferedWriter bufferedWriter = null;


    public void createLogFile() {
        try {
            File dir = new File(Settings.LogPath);
            if (!dir.exists()) {
                dir.mkdir();
                //create file
                File logFile = new File(dir + "/" + fileNameFormat + ".log");
                FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
                bufferedWriter = new BufferedWriter(fileWriter);
            }
        } catch (Exception e) {

        }
    }

    //write message within the log file
    public void write(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.close();
        } catch (Exception e) {

        }
    }
}
