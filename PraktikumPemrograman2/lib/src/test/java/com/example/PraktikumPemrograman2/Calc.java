package com.example.PraktikumPemrograman2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import JUnit.Calculator;

public class Calc {
    @Test
    void test() {
        assertEquals(4, new Calculator().add(2, 2));
    }
}
