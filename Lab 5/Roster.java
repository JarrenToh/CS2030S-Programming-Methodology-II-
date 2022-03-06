class Roster extends KeyableMap<Student> {

    Roster(String key) {

        super(key);
    }

    @Override
    Roster put(Student student) {

        super.put(student);
        return this;
    }


    Student presentInList(String key) {

        return super.get(key) == null ? new Student(key) : super.get(key);

    }


    String getGrade(String id, String moduleCode, String assessment) {

        String[] searchOptions = new String[]{id, moduleCode, assessment};

        KeyableMap<?> result = this;


        //System.out.println(result);

        for (int i = 0; i < searchOptions.length - 1; i++) {

            result = (KeyableMap<?>) result.get(searchOptions[i]);

            if (result == null) {

                return String.format("No such record: %s %s %s", id, moduleCode, assessment);
            }
        }

        Assessment assessmentOutput = (Assessment) 
            result.get(searchOptions[searchOptions.length - 1]);


        if (assessmentOutput == null) {

            return String.format("No such record: %s %s %s", id, moduleCode, assessment);
        }

        return assessmentOutput.getGrade();

    }


}
