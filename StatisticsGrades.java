
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticsGrades {
    /**
     * class variables declared
     */
    static  int max =0;
    static  int min =Integer.MAX_VALUE;
    static double average = 0.0;
    static int sum = 0;
    static int maxBar = 0;



    // Convert the input string of grade enter by the user to ArrayList
    static List<Integer> convertStringInputToArrayzList(String input){
     /**
      * 1. input : "56 78 87 90 23 12 89 56"
        2. split it into array of strings
        3. stringValues: {"56", "78", "87", "90", "23", "12", "89", "56"}
        4. Converts and adds the array strings into ArrayList of Integers

      */
        List<Integer> grades = new ArrayList<>();
        String[] stringValues = input.split(" ");
       try {
        for(String v: stringValues){
            grades.add(Integer.valueOf(v));
        }
        
       } catch (Exception e) {
        System.out.println("Could not convert to integer arrays. Please check you input and try again!");
       }
        return grades;

    }

    //Calculate the maximum, minimum and average score of the grades
    static void calculateMaxMinAverageScore(List<Integer> arrayList){
        /**
         * 1. Calculates the maximum grade
         * 2. Calculate the minimum grade
         * 3. Calculate the average grade
         */
        for(Integer grade: arrayList){
            if(grade > max){
                max = grade;
            }
            if(grade <min){
                min = grade;
            }
            sum = sum +grade;
        }
        average = sum/arrayList.size();
    }

    //Get the stat for each range e.g 21-40=4
    static  int[] getScoreRangeStats(List<Integer> arrIntegers){
        int[] rangeArray = new int[5];

        for(int v: arrIntegers){
            if (v >= 81 && v <= 100) {
                rangeArray[4]++;
            } else if (v >= 61) {
                rangeArray[3]++;
            } else if (v >= 41) {
                rangeArray[2]++;
            } else if (v >= 21) {
                rangeArray[1]++;
            } else if (v >= 0) {
                rangeArray[0]++;
            }
        }
        return rangeArray;
    }
        //Get the maximum range value that will be used to draw the graph
       static int returnMaxBarToBeDrawn(int[] stats){
        /**
         * return: The maximum range of grades
         */
        for (int count : stats) {
            if (count > maxBar) {
                maxBar = count;
            }
        }
        return maxBar;
       }
       // Draw bar graph patten depending on the maximum range value
       static void drawBarPattern(int[] statRange, int max){
        /**
         * 1. Runs a loop starting from the maximum range of grades
         * 2. Loops through the number of range values
         * 3. Draws bar if it meets the condition of a bar
         */
        for (int row = max; row > 0; row--) {
            System.out.print(row+">   \t");
            for (int i = 0; i < statRange.length; i++) {
                if (statRange[i] >= row) {
                    System.out.print("#######\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
       }
       //Draw a patten beneath the graph
       static void drawDownDisplay(String[] stringRange){

        System.out.println("     +---------+-------+-------+-------+------+");
        System.out.printf(" ");
        for (String range : stringRange) {
            System.out.print(" | " + range + "  ");
       }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the values for the grades separated by spaces");
        String inputValues = sc.nextLine();
        List<Integer> vGrades = convertStringInputToArrayzList(inputValues);
        calculateMaxMinAverageScore(vGrades);
        System.out.printf("The maximum grade: "+max +"%nThe minimum grade :"+min + "%nThe average grade :"+ average +"\n");
        String[] ranges = {"0-20", "21-40", "41-60", "61-80", "81-100"};
        
        int[] returnedArrayRange =  getScoreRangeStats(vGrades);
        int maxValueBar = returnMaxBarToBeDrawn(returnedArrayRange);
        System.out.println("Display of the graph");
        drawBarPattern(returnedArrayRange, maxValueBar);
        drawDownDisplay(ranges);
        sc.close();

    }
}
