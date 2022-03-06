class PrivateCar extends Driver {

    private final Fare[] services = new Fare[2];
    private static final int justRide = 0;
    private static final int shareARide = 1;


    PrivateCar(String licensePlateNumber, int waitingTime) {

        super(licensePlateNumber, waitingTime);
        this.services[justRide] = new JustRide();
        this.services[shareARide] = new ShareARide();

    }

    Fare[] getServices() {

        return this.services;

    }


    @Override
    public String toString() {

        return super.toString() + "PrivateCar";

    }
}
