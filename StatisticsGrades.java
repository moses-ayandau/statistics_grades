import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticsGrades {
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static double average = 0.0;
    static int sum = 0;
    static int maxBar = 0;

    // Convert the input string of grades entered by the user to an ArrayList
    static List<Integer> convertStringInputToArrayzList(String input) {
        List<Integer> grades = new ArrayList<>();
        String[] stringValues = input.split(" ");

        try {
            for (String v : stringValues) {
                int convertedInteger = Integer.parseInt(v.trim()); 
                if (convertedInteger >= 0 && convertedInteger <= 100) {
                    grades.add(convertedInteger);
                } else {
                    System.out.println("Please enter grades between 0 and 100.");
                    return new ArrayList<>(); // Return empty list on invalid input
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter only integers separated by spaces.");
            return new ArrayList<>(); // Return empty list on invalid input
        }
        return grades;
    }

    // Calculate the maximum, minimum, and average score of the grades
    static void calculateMaxMinAverageScore(List<Integer> arrayList) {
        if (arrayList.isEmpty()) {
            System.out.println("No valid grades to process.");
            return;
        }
        
        max = 0;
        min = Integer.MAX_VALUE;
        sum = 0;
        
        for (Integer grade : arrayList) {
            if (grade > max) {
                max = grade;
            }
            if (grade < min) {
                min = grade;
            }
            sum += grade;
        }
        average = (double) sum / arrayList.size();
    }

    // Get the stat for each range
    static int[] getScoreRangeStats(List<Integer> arrIntegers) {
        int[] rangeArray = new int[5];

        for (int v : arrIntegers) {
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

    // Get the maximum range value for drawing the graph
    static int returnMaxBarToBeDrawn(int[] stats) {
        maxBar = 0;
        for (int count : stats) {
            if (count > maxBar) {
                maxBar = count;
            }
        }
        return maxBar;
    }

    // Draw the bar graph pattern
    static void drawBarPattern(int[] statRange, int max) {
        for (int row = max; row > 0; row--) {
            System.out.print(row + " >   \t");
            for (int value : statRange) {
                if (value >= row) {
                    System.out.print("#######\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    // Draw the labels beneath the graph
    static void drawDownDisplay(String[] stringRange) {
        System.out.println("     +---------+-------+-------+-------+------+");
        System.out.print(" ");
        for (String range : stringRange) {
            System.out.print(" | " + range + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the values for the grades separated by spaces:");
        
        String inputValues = sc.nextLine();
        List<Integer> vGrades = convertStringInputToArrayzList(inputValues);

        // Check if there are valid grades before proceeding
        if (vGrades.isEmpty()) {
            System.out.println("No valid input provided. Exiting program.");
            sc.close();
            return;
        }

        calculateMaxMinAverageScore(vGrades);
        System.out.printf("The maximum grade: %d%nThe minimum grade: %d%nThe average grade: %.2f%n", max, min, average);

        String[] ranges = {"0-20", "21-40", "41-60", "61-80", "81-100"};
        int[] returnedArrayRange = getScoreRangeStats(vGrades);
        int maxValueBar = returnMaxBarToBeDrawn(returnedArrayRange);

        System.out.println("Display of the graph:");
        drawBarPattern(returnedArrayRange, maxValueBar);
        drawDownDisplay(ranges);

        sc.close();
    }
}
