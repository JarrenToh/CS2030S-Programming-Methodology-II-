void serveCruises(Cruise[] cruises) {

    Loader[] loaders = new Loader[9*30];
    int noOfLoadersAvailable = 0;

    for (int cruise = 0; cruise < cruises.length; cruise++) {

        for (int numOfLoader = 0; numOfLoader < cruises[cruise].getNumOfLoadersRequired(); numOfLoader++) {

            int i = 0;

            for (int loadersAvailable = 0; loadersAvailable <
                    noOfLoadersAvailable; loadersAvailable++) {

                if (loaders[loadersAvailable].canServe(cruises[cruise])) {
                    loaders[loadersAvailable] = loaders[loadersAvailable].serve(cruises[cruise]);
                    System.out.println(loaders[loadersAvailable]);
                    i++;
                    break;
                }
            }
            if (i == 0) {
                System.out.println(loaders[noOfLoadersAvailable] = new
                        Loader(noOfLoadersAvailable + 1, cruises[cruise]));
                noOfLoadersAvailable++;
            }
        }
    }
}
