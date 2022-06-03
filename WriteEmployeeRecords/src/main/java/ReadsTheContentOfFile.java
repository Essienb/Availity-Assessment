import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadsTheContentOfFile  {

    public static void main(String[] args) {

        readAFile();
    }

    public static void readAFile() {

        String fileName = "enrollmentList.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                //Sorted output
                br.lines().skip(1).map(String::lines).sorted();

                for (String index : values) {
                    System.out.printf("%-10s", index);

                }
                System.out.println();

            }

            JOptionPane.showMessageDialog(null,
                    "This is the Record saved in the file");

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "No Record found in the file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


