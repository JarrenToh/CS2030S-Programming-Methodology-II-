class Loader {
    private final int identifier;
    private final Cruise cruise;

    Loader(int identifier, Cruise cruise) {
        this.identifier = identifier;
        this.cruise = cruise;
    }

    int getIdentifier() {
        return this.identifier;
    }

    int getNextAvailableTime() {
        return cruise.getServiceCompletionTime();
    }

    boolean canServe(Cruise nextCruise) {

        return nextCruise.getArrivalTime() >= this.getNextAvailableTime();
    }

    Loader serve(Cruise nextCruise) {
        if (this.canServe(nextCruise)) {
            return new Loader(this.identifier, nextCruise);
        }
        return new Loader(this.identifier, this.cruise);
    }

    @Override
    public String toString() {
        return String.format("Loader %d serving " + this.cruise.toString(), this.identifier);
    }

}
