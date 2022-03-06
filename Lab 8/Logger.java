import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

class Logger<T> {

    private final Supplier<T> supplierValue;
    private final ArrayList<Supplier<?>> logValues;
    private Optional<T> cache;

    //private Logger(Supplier<T> supplierValue) {

    //    this.supplierValue = supplierValue;
    //    this.logValues = new ArrayList<String>();
    //    this.logValues.add(supplierValue.get().toString());

    //}

    private Logger(Supplier<T> supplierValue, ArrayList<Supplier<?>> logValues) {

        this.supplierValue = supplierValue;
        this.logValues = logValues;
        this.cache = Optional.<T>empty();
    }

    //Scope of U is within the method
    static <U> Logger<U> of(U value) {

        Optional<U> optionalValue = Optional.<U>ofNullable(value);

        if (optionalValue.isEmpty()) {

            throw new IllegalArgumentException("argument cannot be null");

        } else if (value instanceof Logger) {

            throw new IllegalArgumentException("already a Logger");

        }


        ArrayList<Supplier<?>> updatedLogValues = new ArrayList<Supplier<?>>();

        updatedLogValues.add(() -> value);

        return new Logger<U>(() -> value, updatedLogValues);

    }

    //Scope of U is within the method
    static <U> Logger<U> of(Supplier<U> value, ArrayList<Supplier<?>> logValues) {

        //Optional<U> optionalValue = Optional.<U>ofNullable(this.getValue());

        //if (optionalValue.isEmpty()) {

        //    throw new IllegalArgumentException("argument cannot be null");

        //} else if (value instanceof Logger) {

        //    throw new IllegalArgumentException("already a Logger");

        //}

        return new Logger<U>(value, logValues);

    }



    <U> Logger<U> map(Function<? super T, ? extends U> mapper) {

        Supplier<U> supplierValue = new Supplier<U>() {

            @Override
            public U get() {

                //System.out.println("I went here");
                U mappedValue = mapper.apply(Logger.this.getValue());

                return mappedValue;
            }
        };

        ArrayList<Supplier<?>> updatedLogValues = new ArrayList<Supplier<?>>();

        for (int i = 0; i < Logger.this.logValues.size(); i++) {

            updatedLogValues.add(Logger.this.logValues.get(i));

        }

        updatedLogValues.add(supplierValue);



        return Logger.<U>of(supplierValue, updatedLogValues);

    }

    <U> Logger<U> flatMap(Function<? super T, ? extends Logger<? extends U>> mapper) {

        Logger<? extends U> mappedLogger = mapper.apply(Logger.this.getValue());

        ArrayList<Supplier<?>> logsOfMappedLogger = mappedLogger.getLogValues();

        ArrayList<Supplier<?>> updatedLogValues = new ArrayList<Supplier<?>>();

        for (int i = 0; i < this.logValues.size(); i++) {

            updatedLogValues.add(this.logValues.get(i));

        }

        for (int i = 1; i < logsOfMappedLogger.size(); i++) {


            updatedLogValues.add(logsOfMappedLogger.get(i));

        }


        return Logger.<U>of(() -> mappedLogger.getValue(), updatedLogValues);

    }

    @Override
    public boolean equals(Object obj) {

        boolean logValueEqual = true;
        if (obj instanceof Logger) {


            ArrayList<Supplier<?>> objectLogValue = ((Logger<?>) obj).getLogValues();

            if (objectLogValue.size() != this.logValues.size()) {

                logValueEqual = false;

            } else {

                for (int i = 0; i < this.logValues.size(); i++) {

                    if (!(this.logValues.get(i).get()).equals(objectLogValue.get(i).get())) {

                        logValueEqual = false;
                    }
                }
            }
        }

        return obj instanceof Logger 
            && ((Logger) obj).getValue().equals(this.getValue()) 
            && logValueEqual;
    }

    <U> T getValue() {

        T v = this.cache.orElseGet(this.supplierValue);
        this.cache = Optional.<T>of(v);
        return v;
    }

    <U> ArrayList<Supplier<?>> getLogValues() {

        return this.logValues;
    }

    Logger<T> test(Predicate<? super T> pred, Logger<T> trueLogger, Logger<T> falseLogger) {

        if (pred.test(Logger.this.getValue())) {

            return trueLogger;
        }

        return falseLogger;
    }

    @Override
    public String toString() {

        T value = this.getValue();
        //System.out.println(String.format("Logger[%s]",value));
        String output = String.format("Logger[%s]",value);
        //System.out.println(output);
        int logSize = this.logValues.size();

        String previousString = this.logValues.get(0).get().toString(); 
        for (int i = 1; i < logSize - 1; i++) {

            String currentString = this.logValues.get(i).get().toString();

            output += "\n" + previousString + " -> " + currentString;        

            previousString = currentString;
        }

        if (logSize > 1) {
            output += "\n" + this.logValues.get(logSize - 2)
                .get().toString() + " -> " + value.toString();  
            //System.out.println(this.logValues);
        }
        return output;

    }
}
