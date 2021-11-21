package org.example;

public class NotTriangleException extends Exception{
    public NotTriangleException(){
        super("Треугольника с такими сторонами не существует");
    }
}
