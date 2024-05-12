package task01;
class Point {
    double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}
class Line {
    double k, b;
    public Line(double k, double b){
        this.k = k;
        this.b = b;
    }
    public Point intersection(Line B){
        double x = ((this.b-B.b)/(-(this.k-B.k)));
        double y = this.k*x + this.b;
        if (Double.isInfinite(x) || Double.isNaN(x) || Double.isInfinite(y) || Double.isNaN(y)) {
            return null;
        }
        return new Point(x, y);
    }
}
public class task01 {
    public static void main(String[] args) {
        Line line1 = new Line(1, 1);
        Line line2 = new Line(-1, 3);
        Point intpoint = line1.intersection(line2);
        if (intpoint == null)
            System.out.println("Лінії збігаються або не перетинаються");
        else
            System.out.println("(" + intpoint.x + ";" + intpoint.y + ")");
    }
}