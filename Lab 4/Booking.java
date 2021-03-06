class Booking {

    private final Driver driver;
    private final Request request;
    private final Fare[] services;
    private static final double centsToDollar = 100.0;

    Booking(Driver driver, Request request) {

        this.driver = driver;
        this.request = request;
        this.services = this.driver.getServices();

    }

    int selectedService() {

        int choosenService = 0;
        for (int i = 1; i < this.services.length; i++) {

            int bestServiceFare = this.services[choosenService].computeFare(this.request);
            int currentServiceFare = this.services[i].computeFare(this.request);

            if (currentServiceFare < bestServiceFare) {

                choosenService = i;

            }
        }

        return choosenService;
    }

    int bookingWaitingTime() {

        return this.driver.getWaitingTime();
    }

    double computedFare() {

        return this.services[this.selectedService()].computeFare(this.request) / centsToDollar;

    }

    int compareTo(Booking anotherBooking) {

        double currentBookingFare = this.computedFare();
        double anotherBookingFare = anotherBooking.computedFare();

        if (currentBookingFare == anotherBookingFare) {

            if (this.bookingWaitingTime() < anotherBooking.bookingWaitingTime()) {

                return -1;

            }

            return 0;

        }

        return (int) (currentBookingFare - anotherBookingFare);

    }

    @Override
    public String toString() {

        return String.format("$%.2f using %s (%s)",this.computedFare(), 
                this.driver.toString(), this.services[this.selectedService()]);
    }
}
