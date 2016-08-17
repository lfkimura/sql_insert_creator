package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import factory.SqlInsertFactory;

public class SqlCreator {

    private static String insertFields = "database.csv";

    public static void main(String[] args) {
        String fieldsFile = insertFields;
        if (args.length > 0 && args[0] != null && !args[0].isEmpty())
            fieldsFile = args[0];
        BufferedReader br = null;

        try {

            String sCurrentLine;
            br = new BufferedReader(new FileReader(fieldsFile));
            StringWriter writer = new StringWriter();
            // reading data
            br.readLine();
            while ((sCurrentLine = br.readLine()) != null) {
                String insertLine = SqlInsertFactory.createInsert(sCurrentLine) + "\n";
                writer.write(insertLine);
            }
            FileWriter fw = new FileWriter("insert_table.sql");
            fw.write(writer.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
