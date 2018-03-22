package com.fib.service;


import com.fib.model.FibonacciSequence;

/**
 * Service interface defining methods to perform operations related to Fibonacci series.
 *
 * Created by aseem on 22/03/18.
 */
public interface FibSequenceService {

    /**
     * Method to generate a fibonacci series of a given input size (numElements)
     *
     * @param numElements
     * @return {@link FibonacciSequence}
     */
    FibonacciSequence generateFibonacciSequence(final int numElements);

    /**
     * Prints fibonacci sequence as a String on the console
     *
     * @param {{@link FibonacciSequence} sequence
     */
    void printFibonacciSequence(FibonacciSequence sequence);
}
