package task03;
class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
class Triangle{
    Point A, B, C;
    Triangle(Point A, Point B, Point C) {
        if ((Math.abs((A.x - C.x) * (B.y - C.y) - (B.x - C.x) * (A.y - C.y)))/2 <= 0)
            throw new IllegalArgumentException("Трикутника не існує");
        this.A = A;
        this.B = B;
        this.C = C;
    }
    double area() {
        return (Math.abs((A.x - C.x) * (B.y - C.y) - (B.x - C.x) * (A.y - C.y)))/2;
    }
    Point centroid() {
        double centroidX = (A.x + B.x + C.x) / 3.0;
        double centroidY = (A.y + B.y + C.y) / 3.0;
        return new Point(centroidX, centroidY);
    }
}
public class task03 {
    public static void main(String[] args) {
        Point trA = new Point(1, 1);
        Point trB = new Point(0, 0);
        Point trC = new Point(3, 3);
        Triangle triangle = new Triangle(trA, trB, trC);
        System.out.println("Площа трикутника: " + triangle.area());
        System.out.println("Центр трикутника: (" + triangle.centroid().x + "; " + triangle.centroid().y + ")");
    }
}