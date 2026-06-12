package Task2;

public class Triangle implements Figure {

    private double sideA;
    private double sideB;
    private double sideC;
    private double heightToA;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, double heightToA, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.heightToA = heightToA;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return sideA * heightToA / 2;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}