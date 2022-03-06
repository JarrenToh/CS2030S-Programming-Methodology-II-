import java.util.Map;
import java.util.HashMap;

class Student extends KeyableMap<Module> {

    Student(String name) {

        super(name);
    }

    Module presentInList(String key) {

        return super.get(key) == null ? new Module(key) : super.get(key);
    }



    @Override
    Student put(Module module) {

        super.put(module);
        return this;
    }
}
