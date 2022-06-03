import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SortedEnrolleesByLastName {

    public static void main(String[] args) throws IOException, CsvException {


        SortedSet<String> sortByLastName = new TreeSet<>();
        List<String> lastName = new ArrayList<>();
        HashSet<String> newList = new HashSet<>();
        ArrayList<Integer> sortedByVersion = new ArrayList<>();



        for (var sortedList : Files.readAllLines(Paths.get("enrolleesByInsurance.csv"))) {
//            String textLine = sortedList.replace("\\[|\\]", "");
            sortByLastName.add(sortedList);
        }

        //Duplicates are removed using Hashset
        for(var charRemoved : sortByLastName){
            newList.add(charRemoved);
//            System.out.println("Sort By first and Last names: " + newList);

        }

        for (String newArrangedList : newList) {
            String enrollees = newArrangedList;
            lastName.add(enrollees);

        }
        System.out.println("Sort By first and Last names and duplicates removed: ");
        for(int i = 0; i<lastName.size(); i++){
            System.out.println(lastName.get(i));
        }

    }


}
