import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class TwoDArrays {

    static String[][] generateMarks(String[] studentArray, String[] assignArray) {

        // create the 2D array.
        String[][] studentMarks = new String[studentArray.length + 1][assignArray.length + 1];

        // Set the counter.
        int counter1 = 0;

        // Set name as the 0,0 position.
        studentMarks[0][0] = "Name";

        // For loop that sets the assignments in position on column 0.
        for (int position = 0; position < assignArray.length; position++) {
            studentMarks[0][position + 1] = assignArray[position];
        }

        // For loop that sets the student names in position.
        for (String student : studentArray) {
            studentMarks[counter1 + 1][0] = student;

            // This for loop positions the student marks.
            for (int counter2 = 0; counter2 < assignArray.length; counter2++) {
                int randomNum = (int) Math.round(Math.random() * 10 + 75);
                studentMarks[counter1 + 1][counter2 + 1] = String.valueOf(randomNum);
            }
            // add to the counter every time this loop goes through.
            counter1++;
        }
        // Return the 2D loop.
        return studentMarks;
    }
    /**
    * This is the main method.
    *
    * @param args //
    * @throws Exception //
    */
    public static void main(String[] args) throws IOException {

        // Create and import the student, assignment, output file.
        final File students = new File("students.txt");
        final File assignments = new File("assignments.txt");
        final FileWriter output = new FileWriter("output.csv");

        // Create the scanners.
        final Scanner scStudents = new Scanner(students);
        final Scanner scAssignments = new Scanner(assignments);

        // Create the array lists.
        final ArrayList<String> studentList = new ArrayList<>();
        final ArrayList<String> assignmentList = new ArrayList<>();

        // Use this string to fill the arrayList.
        String str1;
        String str2;

        // This loop adds to the list.
        while (scStudents.hasNextLine()) {
            str1 = scStudents.nextLine();
            studentList.add(str1);
        }

        // Create the array.
        final String[] studentArray = new String[studentList.size()];

        // This loop adds to the list.
        while (scAssignments.hasNextLine()) {
            str2 = scAssignments.nextLine();
            assignmentList.add(str2);
        }

        // Create the array.
        final String[] assignArray = new String[assignmentList.size()];

        // Initialize counter.
        int counter = 0;

        // Adds the elements from the arrayList to the array.
        for (String number : studentList) {
            studentArray[counter] = number;
            counter++;
        }

        // Initialize the counter.
        int counter2 = 0;

        // Adds the elements from the arrayList to the array.
        for (String number2 : assignmentList) {
            assignArray[counter2] = number2;
            counter2++;
        }

        // Call the generate marks function.
        final String[][] marks = generateMarks(studentArray, assignArray);

        // This loop displays the 2D array.
        for (String[] mark : marks) {
            for (String s : mark) {
                output.write(s + ", ");
            }
            output.write("\n");
        }

        output.close();
    }
}
