class FullTimeStudent extends Student {
    //region properties
    private int examScore1;
    private int examScore2;
    //endregion

    //region constructor
    public FullTimeStudent(String name, int examScore1, int examScore2) {
        super(name);
        this.examScore1 = examScore1;
        this.examScore2 = examScore2;
    }
    //endregion

    //region methods
    public int getExamScore1() {
        return examScore1;
    }

    public int getExamScore2() {
        return examScore2;
    }
    //endregion
}