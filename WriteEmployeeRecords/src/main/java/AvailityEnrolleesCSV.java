import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AvailityEnrolleesCSV {


    public static void main(String[] args) throws IOException {


        Path path = Path.of("enrollmentList.csv");

        //Read through the files and sort out by Insurance Company or can also Sort by last Name
        Files.lines(path)
                .skip(1)
                .map(AvailityEnrolleesCSV::getEmployee)

                //we can add filter by Version
                .filter(employee -> "Geico".equalsIgnoreCase(employee.getInsurance()))
                .forEach(System.out::println);
    }


        private static EmployeeModel getEmployee(String line){
            String[] fields = line.split(",");

            if(fields.length !=5){
                throw new RuntimeException("Invalid line in CSV File " + line);
            }
            return new EmployeeModel((fields[0]), fields[1], fields[2],
                                    Integer.parseInt(fields[3]), fields[4]);
        }

    }


