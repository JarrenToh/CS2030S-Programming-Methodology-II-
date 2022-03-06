class Cruise {

    private final String identifier;
    private final int arrivalTime;
    private final int numOfLoader;
    private final int serviceTime;
    private static final int perHundred = 100;
    private static final int perHourMinute = 60;

    Cruise(String identifier, int arrivalTime, int numOfLoader, int serviceTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.numOfLoader = numOfLoader;
        this.serviceTime = serviceTime;
    }

    int getServiceCompletionTime() {
        return this.getArrivalTime() + this.serviceTime;
    }

    int getArrivalTime() {
        return Math.floorDiv(this.arrivalTime, perHundred) * perHourMinute 
            + this.arrivalTime % perHundred;
    }

    int getNumOfLoadersRequired() {
        return this.numOfLoader;
    }

    @Override
    public String toString() {
        return String.format("%s@%04d",this.identifier,this.arrivalTime);
    }

}
