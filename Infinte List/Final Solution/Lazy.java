import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.Optional;

class Lazy<T> {

    private final Supplier<? extends T> supplier;
    private Optional<T> cache;
    private boolean computed;
    private boolean caculated;

    private Lazy(Supplier<? extends T> supplier, boolean computed) {

        this.supplier = supplier;
        this.cache = Optional.empty();
        this.computed = computed;
        this.caculated = false;
    }

    static <T> Lazy<T> ofNullable(T v) {

        return new Lazy<T>(() -> v, true);
    }

    static <T> Lazy<T> of(Supplier<? extends T> supplier) {

        return new Lazy<T>(supplier,false);
    }

    Optional<T> get() {

        if (this.caculated) {

            return this.cache;

        } else {
     
            T v = this.cache.orElseGet(this.supplier);
            this.cache = Optional.<T>ofNullable(v);
            this.caculated = true;
            this.computed = true;
            return this.cache;

        }
    }

    public <R> Lazy<R> map(Function<? super T, ? extends R> mapper) {


        Supplier<R> mappedSupplier = new Supplier<R>() {

            @Override
            public R get() {

                T v = Lazy.this.get().orElse(null);
                if (v == null) {

                    return null;
                }

                return mapper.apply(v);
            }

        };

        return Lazy.<R>of(mappedSupplier);
    }

    public Lazy<T> filter(Predicate<? super T> predicate) {


        Supplier<T> filteredSupplier = new Supplier<T>() {

            @Override
            public T get() {

                T v = Lazy.this.get().orElse(null);
                if (v == null) {

                    return null;
                }
                return predicate.test(v) ? v : null;
            }
        };

        return Lazy.<T>of(filteredSupplier);
    }

    T getContent() {

        return this.cache.orElseGet(this.supplier);
    }

    static <T> Lazy<T> empty() {

        return Lazy.<T>of(() -> null);
    }

    boolean isEmpty() {

        return this.computed && this.getContent() == null;

    }

    @Override
    public String toString() {

        if (computed) {

            return String.format("Lazy[%s]",this.supplier.get());
        }

        return "Lazy[?]";
    }

}
