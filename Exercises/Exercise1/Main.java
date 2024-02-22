public class Main {

    //region properties
    private static final String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Harry", "Irvine", "James",
            "Katherine", "Larry", "Mia", "Nathan", "Olivia", "Peter", "Quinn", "Rachel", "Samuel", "Tina"};
    //endregion

    public static void main(String[] args) {
        //region calling methods
        Session session = new Session(20);

        for (int i = 0; i <= 9; i++) {
            FullTimeStudent objFullTimeStudent = new FullTimeStudent(studentNames[i], (int) (Math.random() * 101), (int) (Math.random() * 101));
            for (int j = 0; j < 15; j++) {
                objFullTimeStudent.addQuizScore(j, (int) (Math.random() * 16));
            }
            session.addStudent(objFullTimeStudent, i);
        }

        for (int i = 0; i < 10; i++) {
            PartTimeStudent objPartTimeStudent = new PartTimeStudent(studentNames[i + 10]);
            for (int j = 0; j < 15; j++) {
                objPartTimeStudent.addQuizScore(j, (int) (Math.random() * 16)); // Range: 0 to 15
            }
            session.addStudent(objPartTimeStudent, i + 10);
        }

        session.printStudentDetails();
        session.printStudentNames(StudentType.FULL_TIME);
        session.printStudentNames(StudentType.PART_TIME);
        session.printFullTimeStudentExamScores();
        //endregion
    }
}