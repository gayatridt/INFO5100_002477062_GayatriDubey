//region imports
import java.text.DecimalFormat;
import java.util.Arrays;
//endregion

//region enum
enum StudentType {
    FULL_TIME,
    PART_TIME
}
//endregion

class Session {
    //region properties
    private Student[] students;
    //endregion

    //region constructor
    public Session(int studentCount) {
        this.students = new Student[studentCount];
    }
    //endregion

    //region methods
    public void addStudent(Student student, int index) {
        students[index] = student;
    }

    public void printStudentDetails() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        for (Student student : students) {
            int[] quizScores = Arrays.copyOf(student.getQuizScores(), student.getQuizScores().length);
            Arrays.sort(quizScores);
            double studentAverage = Arrays.stream(quizScores).average().orElse(0.0);
            studentAverage = Double.parseDouble(decimalFormat.format(studentAverage));

            System.out.println("Student: " + student.getName() +
                    ", Average Quiz Score: " + studentAverage +
                    ", Quiz Scores: " + Arrays.toString(quizScores));
        }
    }

    public void printStudentNames(StudentType studentType) {
        System.out.println(studentType + " Student Names:");
        for (Student student : students) {
            boolean isFullTime = student instanceof FullTimeStudent;
            boolean isPartTime = student instanceof PartTimeStudent;

            if ((studentType == StudentType.FULL_TIME && isFullTime) ||
                    (studentType == StudentType.PART_TIME && isPartTime)) {
                System.out.println(student.getName());
            }
        }
    }

    public void printFullTimeStudentExamScores() {
        System.out.println("FullTime Student Exam Scores:");
        for (Student student : students) {
            if (student instanceof FullTimeStudent objFullTime) {
                System.out.println(objFullTime.getName() +
                " - Exam 1 score: " + objFullTime.getExamScore1() +
                ", Exam 2 score: " + objFullTime.getExamScore2());
            }
        }
    }
    //endregion
}
