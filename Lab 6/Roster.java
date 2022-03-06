import java.util.Optional;

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

        return super.get(key).orElse(new Student(key));

    }


    String getGrade(String id, String moduleCode, String assessment) {

        Optional<Keyable> optionalResult = this.get(id)
            .flatMap(x -> x.get(moduleCode))
            .flatMap(x -> x.get(assessment));

        Optional<String> optionalString = optionalResult
            .map(x -> { 
                Assessment y = (Assessment) x; 
                return y.getGrade(); 
            });

        //System.out.println(optionalResult);

        //System.out.println(optionalString);
        //return "OK";

        return optionalString
            .orElse(String.format("No such record: %s %s %s", id, moduleCode, assessment));

    }
}
