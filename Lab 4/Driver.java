abstract class Driver {

    private final String licensePlateNumber;
    private final int waitingTime;

    Driver(String licensePlateNumber, int waitingTime) {

        this.licensePlateNumber = licensePlateNumber;
        this.waitingTime = waitingTime;

    }

    abstract Fare[] getServices();

    String getPlateNumber() {

        return this.licensePlateNumber;

    }

    int getWaitingTime() {

        return this.waitingTime;

    }

    @Override
    public String toString() {

        return String.format("%s (%d mins away) ", 
                this.licensePlateNumber, this.waitingTime);

    }
}
