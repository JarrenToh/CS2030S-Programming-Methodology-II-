import java.util.Map;
import java.util.HashMap;

class Module extends KeyableMap<Assessment> {

    Module(String key) {

        super(key);
    }

    @Override
    Module put(Assessment assessment) {

        super.put(assessment);

        return this;
    }
}
