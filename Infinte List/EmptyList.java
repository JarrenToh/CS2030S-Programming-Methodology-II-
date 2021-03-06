import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.Optional;

class EmptyList<T> implements InfiniteList<T> {


    public <R> InfiniteList<R> map(Function<? super T, ? extends R> mapper) {

        return new EmptyList<R>();

    }

    public InfiniteList<T> filter(Predicate<? super T> predicate) {

        return this;


    }

    public InfiniteList<T> limit(long n) {

        return this;       

    }

    public boolean isEmpty() {

        return true;
    }

    public InfiniteList<T> takeWhile(Predicate<? super T> predicate) {

        return this;
    }

    public Object[] toArray() {

        return new Object[0];
    }

    public long count() {

        return 0;
    }

    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator) {

        return identity;
    }
    
    public void forEach(Consumer<? super T> action) {
    
    }

    public EmptyList<T> peek() {

        //System.out.printf("%s",this.head.get().map(x -> x.toString() + "\n").orElse(""));
        //Lazy<T> newHead = this.tail.get().head;
        //Supplier<InfiniteListImpl<T>> newTail = this.tail.get().tail;
        //return new InfiniteListImpl<T>(newHead, newTail);
        return this;
    }
} 
