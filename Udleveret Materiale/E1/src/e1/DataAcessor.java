/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Wulff
 */
public class DataAcessor {
    private final String FileName;
    private File fil;

    /**
     * Constructor for the class, used to assign the current database.
     *
     * @param FileName The File to pull data from.
     *
     */
    public DataAcessor(String FileName) {
        fil = new File(FileName);
        this.FileName = FileName;
    }

    /**
     * Method for retrieving all entries in the current selected txt document.
     * Will not return blank entries
     *
     * @throws delfinen.data.DataException
     */

    public List<String> getEntries() throws DataException {
        String line = null;
        List<String> Output = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            while ((line = reader.readLine()) != null) {
                if (!line.equals("")) {
                    Output.add(line);
                }
            }
            return Output;
        } catch (IOException e) {
//            throw new DataException();
            return Output;
        }
    }

    /**
     * Method for searching for keywords in the database. Searches the database
     * for all entries with containing the query.
     *
     * For more precise searches, knowledge of the data structure is required.
     *
     * @param query The wanted Query.
     * @return machingEntries All entries that contains the query.
     * @throws DataException
     *
     */

    public List<String> searchEntries(String query) throws DataException {
        String line = null;
        List<String> matchingEntries = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            System.out.println(query);
            while ((line = reader.readLine()) != null) {
                if (line.matches(query)) {
                    matchingEntries.add(line);
                } else if (line.contains(query)) {
                    matchingEntries.add(line);
                }
            }
            return matchingEntries;
        } catch (IOException e) {
//            throw new DataException();
            if (matchingEntries.isEmpty()) {
                return (this.getEntries());
            } else {
                return matchingEntries;
            }
        }
    }

    /**
     * Method for adding a new entry to the currently selected file. New entry
     * is always appended, and will appear last in the database.
     *
     * @param obj The object to add to the database
     * @throws DataException
     *
     */
    
    public void newDataEntry(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, true));
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void append(String in) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, true));
            writer.write(in+",");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public void append(String in,int i) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, true));
            writer.write(in);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    public void addEntry(String obj) throws DataException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, fil.exists()));
            writer.newLine();
            writer.write(obj);
            writer.close();
        } catch (IOException e) {
            throw new DataException();
        }
    }

    /**
     * Method for editing an entry in the database. Works by finding the object
     * to change, and then we writing the file to match the new signature. Takes
     * 2 parameters, both of string type.
     *
     * @param old The entry to change.
     * @param N The changed entry.
     * @throws DataException
     *
     */

    public void editEntry(String old, String N) throws DataException {
        try {
            List<String> newFile = getEntries();
            String lines = "";
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName)); //Append when file exists, make when false
            for (String string : newFile) {
                if (string.length()>7 && string.contains(old.substring(3, old.length()-3))) { //changed equals -> contains to handle compmembers
                    lines += N + "\r\n";
                } else {
                    lines += string + "\r\n";
                }
            }
            writer.write(lines);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new DataException();
        }
    }
}
