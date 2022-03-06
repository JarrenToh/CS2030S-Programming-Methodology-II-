Circle createUnitCircle(Point p, Point q) {
    Point midPoint = p.midPoint(q);
    double pToMidPoint = p.distanceTo(midPoint);
    double d = Math.sqrt(Math.pow(1.0,2) - Math.pow(pToMidPoint,2)); 
    return new Circle (midPoint.moveTo(p.angleTo(q) + (Math.PI/2),d),1.0);
}

int findMaxDiscCoverage(Point[] points){

    int maxDiscCoverage = 0;

    for (int i = 0; i < points.length - 1; i ++){
        for (int j = i + 1; j < points.length; j ++){

            Circle unitCircle = createUnitCircle(points[i],points[j]);
            int currentMaxDiscCoverage = 0;

            for (Point p : points){
                if (unitCircle.containInCircle(p)){
                    currentMaxDiscCoverage++;    
                }
            }

            if (currentMaxDiscCoverage > maxDiscCoverage){
                maxDiscCoverage = currentMaxDiscCoverage;
            }

        } 
    }

    return maxDiscCoverage;

}
