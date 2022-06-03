import com.opencsv.CSVWriter;

import javax.swing.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class CreatesEmployeeRecordsInCSVFile {

    public static void main(String[] args) {


        saveEmployeesRecord();
    }


    public static void saveEmployeesRecord() {

        try{
            //Create the CSV file dynamically and save Employee data into it using opencsv library
            String filepath = "enrollmentList.csv";

            CSVWriter writer = new CSVWriter(new FileWriter(filepath), ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"UserId","FirstName",
                    "LastName", "Version", "Insurance"});
            data.add(new String[]{"123","Essien",
                    "Bassey", "9", "Progressive"});
            data.add(new String[]{"124","Essien",
                    "Bassey", "5", "Geico"});
            data.add(new String[]{"125","Essien",
                    "Bassey", "3", "National"});
            data.add(new String[]{"126","Essien",
                    "Bassey", "5", "Progressive"});
            data.add(new String[]{"127","Alfredo",
                    "Bassey", "5", "Geico"});

           writer.writeAll(data);

           System.out.println("Records Updated successfully");
           writer.close();

            JOptionPane.showMessageDialog(null,
                    "Record saved");
        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null,
                    "Records not Saved");
        }
    }

}