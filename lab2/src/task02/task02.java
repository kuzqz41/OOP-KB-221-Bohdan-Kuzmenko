package task02;
class Point {
    double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}
class Segment {
    Point A, B;
    public Segment(Point A, Point B){
        this.A = A;
        this.B = B;
    }
    public double length() {
        return Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2));
    }
    public Point middle() {
        double cx = (A.x + B.x) / 2;
        double cy = (A.y + B.y) / 2;
        return new Point(cx, cy);
    }
    public Point intersection(Segment another){
        double x1 = A.x, y1 = A.y;
        double x2 = B.x, y2 = B.y;
        double x3 = another.A.x, y3 = another.A.y;
        double x4 = another.B.x, y4 = another.B.y;
        double znm = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (znm == 0) {
            return null;
        }
        double intersectX = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / znm;
        double intersectY = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / znm;
        if (intersectX >= Math.min(x1, x2) && intersectX <= Math.max(x1, x2) &&
                intersectY >= Math.min(y1, y2) && intersectY <= Math.max(y1, y2) &&
                intersectX >= Math.min(x3, x4) && intersectX <= Math.max(x3, x4) &&
                intersectY >= Math.min(y3, y4) && intersectY <= Math.max(y3, y4)) {
            return new Point(intersectX, intersectY);
        } else {
            return null;
        }
    }
}
public class task02 {
    public static void main(String[] args) {
        Point ln1A = new Point(0, 0);
        Point ln1B = new Point(3, 3);
        Point ln2A = new Point(1, 0);
        Point ln2B = new Point(4, 3);
        Segment ln1 = new Segment(ln1A, ln1B);
        Segment ln2 = new Segment(ln2A, ln2B);
        System.out.println("Довжина відрізка: " + ln1.length());
        System.out.println("Середня точка відрізка: (" + ln1.middle().x + ";" + ln1.middle().y + ")");
        if (ln1.intersection(ln2) != null) {
            System.out.println("Точка перетину відрізків: (" + ln1.intersection(ln2).x + ";" + ln1.intersection(ln2).y + ")");
        } else {
            System.out.println("Відрізки не перетинаються або збігаються.");
        }
    }
}