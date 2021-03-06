class NormalCab extends Driver {

    private final Fare[] services = new Fare[2];
    private static final int justRide = 0;
    private static final int takeACab = 1;


    NormalCab(String licensePlateNumber, int waitingTime) {

        super(licensePlateNumber, waitingTime);
        this.services[justRide] = new JustRide();
        this.services[takeACab] = new TakeACab();

    }

    Fare[] getServices() {

        return this.services;

    }


    @Override
    public String toString() {

        return super.toString() + "NormalCab";

    }
}
