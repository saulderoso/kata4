/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Mail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sauld
 */

public class MailListReader {

    public static List<Mail> read(String fileName) {
        List<Mail> mails = new ArrayList<>();
        
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
                String line = reader.readLine();
                
                while (line != null) {
                    if (Mail.isMail(line)) {
                        mails.add(new Mail(line));
                    }
                    
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mails;
    }
}