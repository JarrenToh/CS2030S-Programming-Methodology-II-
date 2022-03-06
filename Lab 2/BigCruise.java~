class BigCruise extends Cruise {
    
    private static final double loaderPer40Length = 40;
    private static final double loaderPer50Passenger = 50;

    BigCruise(String identifier, int arrivalTime, int lengthOfCruise, int numOfPassengers) {
        
        super(identifier, arrivalTime, (int) Math.ceil(lengthOfCruise / loaderPer40Length),
                (int) Math.ceil(numOfPassengers / loaderPer50Passenger));

    } 
}
