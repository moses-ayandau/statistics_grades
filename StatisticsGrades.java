
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
    static int[] rangeArray = new int[5];
    static int maxBar = 0;



    // Convert the input string of grade enter by the user to ArrayList
    static List<Integer> convertStringInputToArrayzList(String input){
        List<Integer> grades = new ArrayList<>();
        String[] stringValues = input.split(" ");
        for(String v: stringValues){
            grades.add(Integer.parseInt(v));
        }
        
        return grades;

    }

    //Calculate the maximum, minimum and average score of the grades
    static void calculateMaxMinAverageScore(List<Integer> arrayList){
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
        for(int v: arrIntegers){
            if (v >= 81 && v <= 100) {
                rangeArray[4]++;
            } else if (v >= 61 && v <= 80) {
                rangeArray[3]++;
            } else if (v >= 41 && v <= 60) {
                rangeArray[2]++;
            } else if (v >= 21 && v <= 40) {
                rangeArray[1]++;
            } else if (v >= 0 && v <= 20) {
                rangeArray[0]++;
            }
        }
        return rangeArray;
    }
        //Get the maximum range value that will be used to draw the graph
       static int returnMaxBarToBeDrawn(int[] stats){
        for (int count : stats) {
            if (count > maxBar) {
                maxBar = count;
            }
        }
        return maxBar;
       }
       // Draw bar graph patten depending on the maximum range value
       static void drawBarPattern(int[] statRange, int max){
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
        for (String range : stringRange) {
            System.out.print("  " + range + "  ");
       }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the values for the grades separated by spaces");
        String inputValues = sc.nextLine();
        System.out.println(inputValues);
        List<Integer> vGrades = convertStringInputToArrayzList(inputValues);
        System.out.println(vGrades);
        calculateMaxMinAverageScore(vGrades);
        System.out.printf("Max: "+max +"%nMin :"+min + "%nAverage :"+ average +"\n");
        String[] ranges = {"0-20", "21-40", "41-60", "61-80", "81-100"};
        
        int[] returnedArrayRange =  getScoreRangeStats(vGrades);
        int maxValueBar = returnMaxBarToBeDrawn(returnedArrayRange);
        System.out.println("Display of the graph");
        drawBarPattern(returnedArrayRange, maxValueBar);
        drawDownDisplay(ranges);
        sc.close();

    }
}
