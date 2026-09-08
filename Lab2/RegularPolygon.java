package Lab2;

public class RegularPolygon {

    private int n;
    private double side;
    private double x;
    private double y;

    // No-arg constructor
    public RegularPolygon() {
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    // Constructor 2 ตัวแปร
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        x = 0;
        y = 0;
    }

    // Constructor 4 ตัวแปร
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Getter
    public int getN() {
        return n;
    }

    public double getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setter
    public void setN(int n) {
        this.n = n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // หาเส้นรอบรูป
    public double getPerimeter() {
        return n * side;
    }

    // หาพื้นที่
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }

    public static void main(String[] args) {

        RegularPolygon p1 = new RegularPolygon();
        RegularPolygon p2 = new RegularPolygon(6, 4);
        RegularPolygon p3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1");
        System.out.println("Perimeter = " + p1.getPerimeter());
        System.out.println("Area = " + p1.getArea());

        System.out.println();

        System.out.println("Polygon 2");
        System.out.println("Perimeter = " + p2.getPerimeter());
        System.out.println("Area = " + p2.getArea());

        System.out.println();

        System.out.println("Polygon 3");
        System.out.println("Perimeter = " + p3.getPerimeter());
        System.out.println("Area = " + p3.getArea());
    }
}