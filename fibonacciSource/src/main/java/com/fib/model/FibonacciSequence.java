package com.fib.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Model to encapsulate details related to a fibonacci sequence
 *
 * Created by aseem on 22/03/18.
 */
public class FibonacciSequence {
    private List<BigDecimal> sequenceElements;

    public List<BigDecimal> getSequenceElements() {
        return sequenceElements;
    }

    public void setSequenceElements(List<BigDecimal> sequenceElements) {
        this.sequenceElements = sequenceElements;
    }

    public FibonacciSequence withSequenceElements(List<BigDecimal> sequenceElements) {
        this.sequenceElements = sequenceElements;
        return this;
    }
}
