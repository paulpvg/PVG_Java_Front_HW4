package org.example;

public class Triangle {

    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Double areaTriangle() throws NotTriangleException {

        if((sideA >= (sideB + sideC)) || (sideB >= (sideA + sideC)) || (sideC >= (sideA + sideB))) {
            throw new NotTriangleException();
        }
        else{
            double halfP = (double) (sideA + sideB + sideC) / 2;
            return Math.sqrt(halfP * (halfP - sideA) * (halfP - sideB) * (halfP - sideC));
        }
    }

    @Override
    public String toString() {
        return "Треугольник должен имееть следующие введенные стороны: " + "a = " + sideA + ", b = " + sideB + ", c = " + sideC;
    }
}
