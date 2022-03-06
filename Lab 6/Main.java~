import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfRecord = sc.nextInt();
        Roster storeRecord = new Roster("AY2122");
        //storeRecord.put(new Student("Jack")
        //.put(new Module("CS1231").put(new Assessment("Test", "A-"))));
        //storeRecord.put(new Student("Jill")
        //.put(new Module("CS1231").put(new Assessment("Test", "B"))));
        //System.out.println("1st check : " + storeRecord.get("Jack"));

        for (int i = 0; i < numberOfRecord; i++) {

            sc.nextLine();
            String id = sc.next().trim();
            String module = sc.next().trim();
            String assessment = sc.next().trim();
            String grade = sc.next().trim();

            //System.out.println("\nid : " + id + "\nmodule : " + module +
            //"\nassessment : " + assessment + "\ngrade : " + grade);

            Assessment newAssessment = new Assessment(assessment,grade);
            Student newStudent = storeRecord.presentInList(id);
            Module newModule = newStudent.presentInList(module);

            //System.out.println(String.format("newAssessment : %s 
            //\nnewStudent : %s \nnewModule : %s",newAssessment ,newStudent, newModule));


            //System.out.println("Before adding : " + storeRecord);
            //System.out.println("CHECK : ID -> " + id + " --> " + storeRecord.get(id));
            newModule.put(newAssessment);
            newStudent.put(newModule);
            storeRecord.put(newStudent);

            //System.out.println("After adding : " + storeRecord +
            //"\nCHECK : ID -> " + id + " --> " + storeRecord.get(id));
            //System.out.println("After adding : " + storeRecord +
            //"\nCHECK : ID -> " + id + " --> " + storeRecord.get(id));
            //System.out.println(storeRecord.get("Jill") instanceof Student);
            //System.out.println(storeRecord.get("Jill").get("CS1231").getClass());


            //scLine.close();
        }

        //System.out.println("RECORRRDDD : " + storeRecord);
        while (sc.hasNextLine()) {

            String currentLine = sc.nextLine();
            Scanner scLine = new Scanner(currentLine);

            while (scLine.hasNext()) {

                String id = scLine.next();
                String module = scLine.next();
                String assessment = scLine.next();
                System.out.println(storeRecord.getGrade(id, module, assessment));

            }

            //scLine.close();

        }

    }
}
