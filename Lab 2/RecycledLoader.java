class RecycledLoader extends Loader {

    private final int identifier;
    private final Cruise cruise;
    private final int downtime = 60;

    RecycledLoader(int identifier, Cruise cruise) {
        super(identifier,cruise);
        this.identifier = identifier;
        this.cruise = cruise;
    }

    @Override
    int getNextAvailableTime() {
        return cruise.getServiceCompletionTime() + downtime;
    }

    @Override
    RecycledLoader serve(Cruise nextCruise) {
        if (this.canServe(nextCruise)) {
            return new RecycledLoader(this.identifier, nextCruise);
        }
        return new RecycledLoader(this.identifier, this.cruise);
    }


    @Override
    public String toString() {
        return "Recycled " + super.toString();
    }

}
