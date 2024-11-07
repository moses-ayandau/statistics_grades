
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grades {
    static  int max =0;
    static  int min =Integer.MAX_VALUE;
    static double average = 0.0;
    static int sum = 0;
    static int[] rangeArray = new int[5];
    static int maxBar = 0;


    static List<Integer> convertToGradeArrays(String input){
        List<Integer> grades = new ArrayList<>();
        String[] stringValues = input.split(" ");
        for(String v: stringValues){
            grades.add(Integer.parseInt(v));
        }
        
        return grades;

    }

    static void calculateStats(List<Integer> arrayList){
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

    static  int[] gradeRangeArray(List<Integer> arrIntegers){
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
       static int returnMaxBarToBeDrawn(int[] stats){
        for (int count : stats) {
            if (count > maxBar) {
                maxBar = count;
            }
        }
        return maxBar;
       }
       static void drawBarPattern(int[] statRange, int max){
        for (int row = max; row > 0; row--) {
            System.out.print(row+"   \t");
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
        List<Integer> vGrades = convertToGradeArrays(inputValues);
        System.out.println(vGrades);
        calculateStats(vGrades);
        System.out.printf("Max: "+max +"%nMin :"+min + "%nAverage :"+ average +"\n");
        String[] ranges = {"0-20", "21-40", "41-60", "61-80", "81-100"};
        
        int[] returnedArrayRange =  gradeRangeArray(vGrades);
        int maxValueBar = returnMaxBarToBeDrawn(returnedArrayRange);
        System.out.println("Display of the graph");
        drawBarPattern(returnedArrayRange, maxValueBar);
        drawDownDisplay(ranges);

    }
}
