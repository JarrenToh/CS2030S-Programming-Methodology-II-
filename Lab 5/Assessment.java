class Assessment implements Keyable {

    private final String assessment;
    private final String grade;

    Assessment(String assessment, String grade) {

        this.assessment = assessment;
        this.grade = grade;
    }

    @Override
    public String getKey() {

        return this.assessment;
    }

    String getGrade() {

        return this.grade;
    }

    @Override
    public String toString() {

        return "{" + this.assessment + ": " + this.grade + "}"; 
    }
}
