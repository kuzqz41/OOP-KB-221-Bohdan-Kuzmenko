abstract class Figure {
    abstract double area();
    abstract Point centroid();
    public abstract String toString();
}
class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
class Triangle extends Figure {
    Point A, B, C;
    Triangle(Point A, Point B, Point C) {
        if ((Math.abs((A.x - C.x) * (B.y - C.y) - (B.x - C.x) * (A.y - C.y)))/2 <= 0)
            throw new IllegalArgumentException("Трикутника не існує");
        this.A = A;
        this.B = B;
        this.C = C;
    }
    @Override
    double area() {
        return (Math.abs((A.x - C.x) * (B.y - C.y) - (B.x - C.x) * (A.y - C.y)))/2;
    }
    @Override
    Point centroid() {
        double centroidX = (A.x + B.x + C.x) / 3.0;
        double centroidY = (A.y + B.y + C.y) / 3.0;
        return new Point(centroidX, centroidY);
    }
    @Override
    public String toString() {
        return ("Трикутник[A(" + A.x + ";" + A.y + ") B(" + B.x + ";" + B.y + ") C(" + C.x + ";" + C.y + ")]");
    }
}
class Quadrilateral extends Figure {
    Point A, B, C, D;
    Quadrilateral(Point A, Point B, Point C, Point D) {
        if ((Math.abs((A.x - C.x) * (B.y - C.y) - (B.x - C.x) * (A.y - C.y)))/2 <= 0 ||
        (Math.abs((B.x - D.x) * (C.y - D.y) - (C.x - D.x) * (B.y - D.y)))/2 <= 0 ||
        (Math.abs((C.x - A.x) * (D.y - A.y) - (D.x - A.x) * (C.y - A.y)))/2 <= 0 ||
        (Math.abs((D.x - B.x) * (A.y - B.y) - (A.x - B.x) * (D.y - B.y)))/2 <= 0)
            throw new IllegalArgumentException("Чотирикутника не існує");
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }
    @Override
    double area() {
        return ((Math.abs((A.x - C.x) * (B.y - C.y) - (B.x - C.x) * (A.y - C.y)))/2 + (Math.abs((C.x - A.x) * (D.y - A.y) - (D.x - A.x) * (C.y - A.y)))/2);
    }
    @Override
    Point centroid() {
        double cx = (A.x + B.x + C.x + D.x) / 4;
        double cy = (A.y + B.y + C.y + D.y) / 4;
        return new Point(cx, cy);
    }
    @Override
    public String toString() {
        return ("Чотирикутник[A(" + A.x + ";" + A.y + ") B(" + B.x + ";" + B.y + ") C(" + C.x + ";" + C.y + ") D(" + D.x + ";" + D.y + ")]");
    }
}
class Circle extends Figure {
    Point center;
    double radius;
    Circle(Point center, double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Кола не існує");

        this.center = center;
        this.radius = radius;
    }
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    @Override
    Point centroid() {
        return center;
    }
    @Override
    public String toString() {
        return ("Коло[(" + center.x + ";" + center.y + ") Радіус " + radius + "]");
    }
}
public class Main {
    public static void main(String[] args) {
        Point trA = new Point(1, 2);
        Point trB = new Point(4, 5);
        Point trC = new Point(2, 7);
        Triangle triangle = new Triangle(trA, trB, trC);
        System.out.println("Площа трикутника: " + triangle.area());
        System.out.println("Центр трикутника: " + triangle.centroid().x + ", " + triangle.centroid().y);
        System.out.println(triangle);
        Point qdA = new Point(2, 3);
        Point qdB = new Point(5, 7);
        Point qdC = new Point(8, 4);
        Point qdD = new Point(4, 1);
        Quadrilateral quadrilateral = new Quadrilateral(qdA, qdB, qdC, qdD);
        System.out.println("Площа чотирикутника: " + quadrilateral.area());
        System.out.println("Центр чотирикутника: " + quadrilateral.centroid().x + ", " + quadrilateral.centroid().y);
        System.out.println(quadrilateral);
        Point cr = new Point(3, 2);
        double rd = 5;
        Circle circle = new Circle(cr, rd);
        System.out.println("Площа кола: " + circle.area());
        System.out.println("Центр кола: " + circle.centroid().x + ", " + circle.centroid().y);
        System.out.println(circle);
    }
}