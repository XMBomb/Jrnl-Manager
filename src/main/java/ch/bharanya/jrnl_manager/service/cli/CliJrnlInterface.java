package ch.bharanya.jrnl_manager.service.cli;

import ch.bharanya.jrnl_manager.conf.Config;
import ch.bharanya.jrnl_manager.parser.JrnlEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by XMBomb on 21.01.2017.
 */
public class CliJrnlInterface implements IJrnlInterface {

    public CliJrnlInterface(){


    }

    private void initProcess(){
        Process process = null;
        try {
            process = new ProcessBuilder(
                    Config.getDefault().getStringProperty("jrnlCommand")
            ).start();
        } catch (IOException e) {
            // TODO
        }
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;


        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addEntry(JrnlEntry jrnlEntry) {
        exportJrnlToJson();
    }

    public void exportJrnlToJson(){

    }
}
