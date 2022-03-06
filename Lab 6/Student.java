import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

class Student extends KeyableMap<Module> {

    Student(String name) {

        super(name);
    }

    Module presentInList(String key) {

        return super.get(key).orElse(new Module(key));
    }



    @Override
    Student put(Module module) {

        super.put(module);
        return this;
    }
}
