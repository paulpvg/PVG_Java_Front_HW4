package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Прямоугольный треуголник Герона")
    public void rightHeronTriangleTest() throws NotTriangleException {
        assertEquals(new Triangle(3,4,5).areaTriangle(), 6.0);
        logger.info("Позитивный тест. Прямоугольный треугольник Герона со сторонами: 3, 4, 5");
    }

    @Test
    @DisplayName("Равнобедренный треугольник Герона")
    public void isoscelesHeronTriangleTest() throws NotTriangleException {
        assertEquals(new Triangle(5,5,8).areaTriangle(), 12.0);
        logger.info("Позитивный тест. Равнобедренный треугольник Герона со сторонами: 5, 5, 8");
    }

    @Test
    @DisplayName("Разносторонний треугольник Герона")
    public void regularHeronTriangleTest() throws NotTriangleException {
        assertEquals(new Triangle(9,10,17).areaTriangle(), 36.0);
        logger.info("Позитивный тест. Разносторонний треугольника Герона со сторонами: 9, 10, 17");
    }

    @Test
    @DisplayName("Равносторонний треугольник")
    public void equilateralTriangleTest() throws NotTriangleException {
        assertEquals(new Triangle(6,6,6).areaTriangle(), 15.588457268119896);
        logger.info("Позитивный тест. Равносторонний треугольник со сторонами: 6, 6, 6");
    }

    @Test
    @DisplayName("Обычный треугольник")
    public void regularTriangleTest() throws NotTriangleException {
        assertEquals(new Triangle(19,4,16).areaTriangle(), 22.99864126421385);
        logger.info("Позитивный тест. Обычный треугольник со сторонами: 19, 4, 16");
    }

    @RepeatedTest(3)
    @DisplayName("Нулевая сторона")
    public void zeroSideTriangleTest(){

        NotTriangleException thrown = assertThrows(
                NotTriangleException.class,
                () -> new Triangle(0, 4, 7).areaTriangle(),
                "Треугольника с такими сторонами не существует"
        );
        assertTrue(thrown.getMessage().contains("Треугольника с такими сторонами не существует"));
        logger.info("Негативный тест. Треугольник с нулевой стороной: 0, 4 ,7");
    }

    @ParameterizedTest
    @ValueSource(ints = {-13, -1024, -256})
    @DisplayName("Отрицательная сторона")
    public void negativeSideTriangleTest(int a){

        NotTriangleException thrown = assertThrows(
                NotTriangleException.class,
                () -> new Triangle(a, 4, 5).areaTriangle(),
                "Треугольника с такими сторонами не существует"
        );
        assertTrue(thrown.getMessage().contains("Треугольника с такими сторонами не существует"));
        logger.info("Негативный тест. Треугольник с отрицательной стороной: " + a + ", 4 , 5");
    }

    @ParameterizedTest
    @CsvSource({"5, 6, 11", "4, 5, 10", "3, 4, 8"})
    @DisplayName("Невозможный треугольник")
    public void impossibleTriangleTest(int a, int b, int c){

        NotTriangleException thrown = assertThrows(
                NotTriangleException.class,
                () -> new Triangle(a, b, c).areaTriangle(),
                "Треугольника с такими сторонами не существует"
        );
        assertTrue(thrown.getMessage().contains("Треугольника с такими сторонами не существует"));
        logger.info("Негативный тест. Треугольник с невозможным сочетанием сторон: " + a + ", " + b + ", " + c);
    }

}
