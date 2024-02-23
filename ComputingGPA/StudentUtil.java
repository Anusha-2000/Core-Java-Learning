package ComputingGPA;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        int n = studentIdList.length;
        double[] gpa = new double[n];

        for(int i = 0; i < n; i++) {
            double total = 0.0;

            for(char score : studentsGrades[i]) {
                switch(score) {
                    case 'A': total += 4; break;
                    case 'B': total += 3; break;
                    case 'C': total += 2; break;
                }
            }

            gpa[i] = total / studentsGrades[i].length;

        }
        return gpa;
    }
    
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        if(lower < 0.0 || higher < 0.0 || lower > higher) {
            return null;
        }

        // invoke calculateGPA
        double[] gpaArray = calculateGPA(studentIdList, studentsGrades);
        
        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
        int size = 0;
        for(double gpa : gpaArray) {
            if(gpa >= lower && gpa <= higher) {
                size++;
            }
        }

        int[] result = new int[size];
        int index = 0;
        for(int i = 0; i < studentIdList.length; i++) {
            int id = studentIdList[i];
            double gpa = gpaArray[i];
            if(gpa >= lower && gpa <= higher) {
                result[index++] = id;
            }
        }
        return result;
    }
    
}
