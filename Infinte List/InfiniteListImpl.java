import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.Optional;
import java.util.ArrayList;

class InfiniteListImpl<T> implements InfiniteList<T> {

    private final Lazy<T> head;
    private final Supplier<InfiniteList<T>> tail;

    private InfiniteListImpl(Lazy<T> head, Supplier<InfiniteList<T>> tail) {

        this.head = head;
        this.tail = tail;
    }


    static <T> InfiniteList<T> generate(Supplier<? extends T> s) {

        Lazy<T> newHead = Lazy.<T>of(s);
        Supplier<InfiniteList<T>> newTail = () -> InfiniteList.<T>generate(s);
        return new InfiniteListImpl<T>(newHead,newTail);
    }

    static <T> InfiniteList<T> iterate(T seed, UnaryOperator<T> next) {

        Lazy<T> newHead = Lazy.<T>of(() -> seed);
        Supplier<InfiniteList<T>> newTail = 
            () -> InfiniteList.<T>iterate(next.apply(seed), next);
        return new InfiniteListImpl<T>(newHead, newTail); 
    }

    public <R> InfiniteList<R> map(Function<? super T, ? extends R> mapper) {

        Lazy<R> newHead = this.head.map(mapper);
        Supplier<InfiniteList<R>> newTail = 
            () -> InfiniteListImpl.this.tail.get().map(mapper);
        return new InfiniteListImpl<R>(newHead, newTail);

    }

    public InfiniteList<T> filter(Predicate<? super T> predicate) {

        Lazy<T> newHead = this.head.filter(predicate);
        Supplier<InfiniteList<T>> newTail = 
            () -> InfiniteListImpl.this.tail.get().filter(predicate);
        return new InfiniteListImpl<T>(newHead, newTail);


    }

    public InfiniteList<T> limit(long n) {

        if (n == 1) {

            return new InfiniteListImpl<T>(this.head, () -> 
                    (InfiniteListImpl.this.head.get().equals(Optional.empty())) ? 
                    InfiniteListImpl.this.tail.get().limit(1) : 
                    new EmptyList<>());


        } else if (n > 0) {

            return new InfiniteListImpl<T>(this.head, () ->
                    (InfiniteListImpl.this.head.get().equals(Optional.empty())) ? 
                    InfiniteListImpl.this.tail.get().limit(n) : 
                    InfiniteListImpl.this.tail.get().limit(n - 1));

        } else {

            return new EmptyList<>();

        }

    }

    public InfiniteList<T> takeWhile(Predicate<? super T> predicate) {

        Lazy<T> newHead = this.head.filter(predicate);

        return new InfiniteListImpl<T>(newHead, () -> {

            Supplier<InfiniteList<T>> theTail = () -> 
                InfiniteListImpl.this.tail.get().takeWhile(predicate);
            if (InfiniteListImpl.this.head.get().equals(Optional.empty())) { 
                return theTail.get(); 
            } else { 
                if (newHead.get().equals(Optional.empty())) {
                    return new EmptyList<>();
                }            

                return theTail.get();
            }
        });
    }

    public boolean isEmpty() {

        return false;
    }

    public Object[] toArray() {

        ArrayList<T> heads = new ArrayList<T>();
        InfiniteListImpl<T> current = this;
        InfiniteList<T> currentTail = current.tail.get();

        while (currentTail instanceof InfiniteListImpl) {

            current.head.get().ifPresent(x -> heads.add(x));
            current = (InfiniteListImpl<T>) currentTail;
            currentTail = current.tail.get();

        } 

        current.head.get().ifPresent(x -> heads.add(x));

        return heads.toArray();
    }

    public long count() {


        ArrayList<T> heads = new ArrayList<T>();
        InfiniteListImpl<T> current = this;
        InfiniteList<T> currentTail = current.tail.get();

        while (currentTail instanceof InfiniteListImpl) {

            current.head.get().ifPresent(x -> heads.add(x));
            current = (InfiniteListImpl<T>) currentTail;
            currentTail = current.tail.get();

        } 

        current.head.get().ifPresent(x -> heads.add(x));

        return (long) heads.size();
    }

    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator) {

        ArrayList<T> heads = new ArrayList<T>();
        InfiniteListImpl<T> current = this;
        InfiniteList<T> currentTail = current.tail.get();

        while (currentTail instanceof InfiniteListImpl) {

            current.head.get().ifPresent(x -> heads.add(x));
            current = (InfiniteListImpl<T>) currentTail;
            currentTail = current.tail.get();

        } 

        current.head.get().ifPresent(x -> heads.add(x));

        U output = identity;

        for (int i = 0; i < this.count(); i++) {

            output = accumulator.apply(output,heads.get(i));           
        }

        return output;
    }

    public void forEach(Consumer<? super T> action) {

        //ArrayList<T> heads = new ArrayList<T>();
        InfiniteListImpl<T> current = this;
        current.head.get().ifPresent(x -> action.accept(x));
        InfiniteList<T> currentTail = current.tail.get();

        if (currentTail instanceof InfiniteListImpl) {

            currentTail.forEach(action);
        }

        //while (currentTail instanceof InfiniteListImpl) {

        //    current.head.get().ifPresent(x -> action.accept(x));
        //    current = (InfiniteListImpl<T>) currentTail;
        //    currentTail = current.tail.get();

        //} 

        //current.head.get().ifPresent(x -> action.accept(x));


        //for (int i = 0; i < this.count(); i++) {

        //    action.accept(heads.get(i));           
        //}

    }


    public InfiniteList<T> peek() {

        System.out.printf("%s",this.head.get().map(x -> x.toString() + "\n").orElseGet(() -> ""));
        //Lazy<T> newHead = this.tail.get().head;
        //Supplier<InfiniteListImpl<T>> newTail = this.tail.get().tail;
        //return new InfiniteListImpl<T>(newHead, newTail);
        return this.tail.get();
    }
}
