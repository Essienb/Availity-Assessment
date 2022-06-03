import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ArrayUtils.toArray;


public class SeparateEnrolleesByInsuranceCompany {

    public static void main(String[] args) throws IOException {

        SortedListOfEntities();
    }

    public static void SortedListOfEntities() {

        String searchThroughInsuranceCompany = "Geico";
        List<String[]> sortingthroughList = new ArrayList<>();
        try {

            String filepath = "enrollmentList.csv";
            CSVReader reader = new CSVReader(new FileReader(filepath));

            sortingthroughList = reader.readAll();
//        System.out.println(sortingthroughList.size());
            reader.close();

            int i = 1;
            for (String[] word : sortingthroughList) {
                String textLine = Arrays.toString(word).replaceAll("\\[|\\]", "");
//                System.out.println(textLine);
                if (textLine.contains(searchThroughInsuranceCompany)) {
//                    System.out.println("Insurance Company found" + i);

                    System.out.println(textLine);

            //Stored separated Enrollees details in a Separate CSV file
            String newFile = "enrolleesByInsurance.csv";
            FileWriter fw = new FileWriter(newFile, true);
            BufferedWriter br = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(br);

            pw.println(textLine);

            pw.close();


                } else {
//                 System.out.println("No Record found in the file");
                }
                i++;
            }

        } catch (IOException ex) {
            ex.printStackTrace();

        } catch (CsvException e) {
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}




