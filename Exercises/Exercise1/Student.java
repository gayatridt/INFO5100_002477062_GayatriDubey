class Student {
    //region properties
    private String studentName;
    private int[] quizScores = new int[15];
    //endregion

    //region constructor
    public Student(String name) {
        this.studentName = name;
    }
    //endregion

    //region methods
    public String getName() {
        return studentName;
    }

    public int[] getQuizScores() {
        return quizScores;
    }

    public void addQuizScore(int quizIndex, int score) {
        quizScores[quizIndex] = score;
    }
    //endregion
}