class Circle {

    private final Point p;
    private final double radius;

    Circle(Point p, double radius) {
        this.p = p;
        this.radius = radius;
    }

    boolean containInCircle(Point point) {
        return this.p.distanceTo(point) <= this.radius;
    }

    @Override
    public String toString() {
        return String.format("circle of radius %.1f centered at " + p.toString(),this.radius);
    }
}
