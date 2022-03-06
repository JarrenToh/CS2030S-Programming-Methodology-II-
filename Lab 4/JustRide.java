class JustRide implements Fare {

    private static final int perKm = 22;
    private static final int peakHourStart = 600;
    private static final int peakHourEnd = 900;
    private static final int surcharge = 500;

    @Override
    public int computeFare(Request request) {
        int totalFare = 0;

        if (request.getTime() >= this.peakHourStart 
                && request.getTime() <= this.peakHourEnd) {
            totalFare += surcharge;
        }

        totalFare += request.getDistance() * this.perKm;

        return totalFare;
    }

    @Override
    public String toString() {
        return "JustRide";
    }
}
