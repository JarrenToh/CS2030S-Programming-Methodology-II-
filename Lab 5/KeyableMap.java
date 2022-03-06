import java.util.Map;
import java.util.HashMap;

class KeyableMap<V extends Keyable> implements Keyable {

    private final Map<String,V> keyableMap;
    private final String key;

    KeyableMap(String key) {

        this.key = key;
        this.keyableMap = new HashMap<String,V>();
    }

    V get(String key) {

        return this.keyableMap.get(key);
    }

    KeyableMap<V> put(V item) {

        this.keyableMap.put(item.getKey(),item);
        //System.out.println("\n Checking: " + this.keyableMap);
        return this;
    }

    @Override
    public String getKey() {

        return this.key;
    }

    Map<String,V> getValue() {

        return this.keyableMap;
    }

    @Override
    public String toString() {

        //System.out.println("\n string Check :" + this.getValue()); 
        int counter = 0;
        String output = this.getKey() + ": {";
        for (Map.Entry<String, V> e: this.getValue().entrySet()) {

            output += e.getValue();
            counter += 1;

            if (counter < this.getValue().size()) {

                output += ", ";
            }
        }

        output += "}";
        return output;
    }

}
