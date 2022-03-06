class Request {

    private final int distance;
    private final int numberOfPassengers;   
    private final int time;

    Request(int distance, int numberOfPassengers, int time) {

        this.distance = distance;
        this.numberOfPassengers = numberOfPassengers;
        this.time = time;

    }

    int getDistance() {

        return this.distance;

    }

    int getNumberOfPassengers() {

        return this.numberOfPassengers;

    }

    int getTime() {

        return this.time;

    }

    @Override
    public String toString() {
        return String.format("%dkm for %dpax @ %dhrs", 
                this.distance, this.numberOfPassengers, this.time);
    }
}
