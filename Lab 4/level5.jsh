Booking findBestBooking(Request request, Driver[] drivers) {
    
    Booking bestBooking = new Booking(drivers[0], request); 
    
    for (int i = 1; i < drivers.length; i++) {
        
        Booking currentBooking = new Booking(drivers[i], request);

        if (bestBooking.compareTo(currentBooking) > 0) {
                bestBooking = currentBooking;
            }
        }
    return bestBooking;
 }
