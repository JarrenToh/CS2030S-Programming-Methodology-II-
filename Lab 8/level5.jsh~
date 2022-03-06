
Logger<Integer> add(Logger<Integer> a, int b) {

    return a.map(x -> x + b);

}

Logger<Integer> sum(int n) {

    if (n == 0) {

        return Logger.<Integer>of(0);

    } else {

        return add(sum(n - 1), n);

    }
}

Logger<Integer> f(int n) {

    Logger<Integer> nLogger = Logger.<Integer>of(n);

    while (nLogger.getValue() > 1) {
        nLogger = nLogger.test(x -> x % 2 == 0, nLogger.map(x -> x / 2),
                nLogger.map(x -> 3 * x).map(x -> x + 1));
    }
    return nLogger;
}

