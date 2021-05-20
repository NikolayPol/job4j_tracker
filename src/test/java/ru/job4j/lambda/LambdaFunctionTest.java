package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LambdaFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapason(5, 8, x -> (double) (2 * x + 1));
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapason(0, 4, x -> (double) (x * x + 1));
        List<Double> expected = Arrays.asList(1D, 2D, 5D, 10D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenLinearResults() {
        LambdaFunction function = new LambdaFunction();
        List<Double> result = function.diapason(0, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1D, 2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}