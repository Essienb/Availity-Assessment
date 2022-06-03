package main;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvailityEnrollmentFiles {


    public static void main(String[] args) {
        String filepath = "enrollmentList.csv";
        String searchThroughInsuranceCompany = "Geico";

        String[] data = new String[10];

        data = (readRecord(searchThroughInsuranceCompany, filepath));

        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
//        System.out.println(data[3]);
//        System.out.println(data[4]);


    }


    public static String[] readRecord(String searchThroughInsuranceCompany, String filepath) {

        ArrayList<String> records = new ArrayList<String>();

        boolean found = false;
        String UserId = "";
        String FirstName = "";
        String LastName = "";
        String Version = "";
        String Insurance = "";
        String record = "";

        try {
            Scanner x;
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                Insurance = x.next();
                if (Insurance.equals(searchThroughInsuranceCompany)) {
                    UserId = x.next();
                    FirstName = x.next();
                    LastName = x.next();
                    Version = x.next();

                    record = UserId + "," + FirstName + "," + LastName + ","
                            + Version + "," + Insurance;
                    records.add(record);
                    found = true;

                } else
                {
                    x.next();
                    x.next();

                }
            }
            if (!found) {
                System.out.println("No records found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
//            arrayIndexOutOfBoundsException.printStackTrace();
//
//        }

        String[] recordsArray = new String[records.size()];
        records.toArray(recordsArray);
        return recordsArray;
    }


}

//
//    public static <insurance> void findByInsuranceCompany(int i, String insurance) {
//        String fileName = "enrollmentList.csv";
//        String line = "";
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(fileName));
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                for (String index : values) {
//                    System.out.printf("%-10s", index);
//                }
//                System.out.println();
//
//
//                int s = values.length;
//                String record = "";
//                List<String> records = new ArrayList<>();
//                for (i = 0; i < s; i++) {
//                    record = values[i];
//                    records.add(record);
//                }
//                System.out.println("Insurance: " + records);
//            }
//
//            JOptionPane.showMessageDialog(null,
//                    "This is the Record saved in the file");
//
//        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null,
//                    "No Record found in the file");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }