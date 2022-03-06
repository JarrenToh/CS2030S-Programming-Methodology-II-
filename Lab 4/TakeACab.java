class TakeACab implements Fare {

    private static final int perKm = 33;
    private static final int bookingFee = 200;

    TakeACab() {

    }

    @Override
    public int computeFare(Request request) {

        int totalFare = 0;
        totalFare += bookingFee;
        totalFare += perKm * request.getDistance();

        return totalFare;
    }

    @Override
    public String toString() {

        return "TakeACab";

    }
}
