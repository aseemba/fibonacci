package com.fib.service;

import com.fib.model.FibonacciSequence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by aseem on 22/03/18.
 */
public class FibSequenceServiceImplTest {

    private FibSequenceServiceImpl fibSequenceService;

    @Before
    public void setUp() throws Exception {
        fibSequenceService = new FibSequenceServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        fibSequenceService = null;
    }

    @Test
    public void generateFibonacciSequenceZeroElements() throws Exception {
        FibonacciSequence sequence = fibSequenceService.generateFibonacciSequence(0);
        assertNotNull(sequence);

        // Ensure the list is empty
        assertTrue(sequence.getSequenceElements().isEmpty());
    }

    @Test
    public void generateFibonacciSequenceOneElement() throws Exception {
        FibonacciSequence sequence = fibSequenceService.generateFibonacciSequence(1);
        assertNotNull(sequence);

        // Ensure there is 1 element in the list
        assertEquals(1, sequence.getSequenceElements().size());

        // Ensure the first element is as expected
        assertEquals(BigDecimal.ZERO, sequence.getSequenceElements().get(0));
    }

    @Test
    public void generateFibonacciSequenceTenElement() throws Exception {
        FibonacciSequence sequence = fibSequenceService.generateFibonacciSequence(10);
        assertNotNull(sequence);

        // Ensure there are 10 elements in the list
        assertEquals(10, sequence.getSequenceElements().size());

        // Ensure the first element is as expected
        assertEquals(BigDecimal.ZERO, sequence.getSequenceElements().get(0));

        // Ensure the last element is as expected
        assertEquals(new BigDecimal(34), sequence.getSequenceElements().get(9));
    }

    @Test
    public void printFibonacciSequenceEmptySequence() throws Exception {
        FibonacciSequence sequence = fibSequenceService.generateFibonacciSequence(0);
        fibSequenceService.printFibonacciSequence(sequence);
    }

    @Test
    public void printFibonacciSequence() throws Exception {
        FibonacciSequence sequence = fibSequenceService.generateFibonacciSequence(3);

        // Ensure 3 elements are printed on console as expected
        fibSequenceService.printFibonacciSequence(sequence);
    }
}