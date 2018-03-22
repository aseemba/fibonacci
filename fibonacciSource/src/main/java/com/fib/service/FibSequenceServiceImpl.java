package com.fib.service;

import com.fib.model.FibonacciSequence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by aseem on 22/03/18.
 */
public class FibSequenceServiceImpl implements FibSequenceService {

    private static final int RESULTS_MAP_MAX_SIZE = 3;

    private Map<Integer, BigDecimal> fibonacciResultsMap;

    private List<BigDecimal> fibonacciSequenceElements;

    public FibSequenceServiceImpl() {

        /**
         * Construct a {@link LinkedHashMap} which will remove the eldest entry when max size of 3 is reached.
         * This will help in not running into space problems while generating list since this map is mainly used for
         * memoization and we only require a maximum of last 3 entries to determine the next element in the list.
         */
        this.fibonacciResultsMap = new LinkedHashMap<Integer, BigDecimal>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > RESULTS_MAP_MAX_SIZE;
            }
        };

        this.fibonacciSequenceElements = new ArrayList<>();
    }

    @Override
    public FibonacciSequence generateFibonacciSequence(int numElements) {
        BigDecimal fibSeqElement;

        // Iteratively memoize and add previous 2 elements of the series to get the next element till the
        // number of elements requested
        for (int i=0; i<numElements; i++) {
            if (i < 2) {
                fibSeqElement = BigDecimal.valueOf(i);
            } else {
                fibSeqElement = fibonacciResultsMap.get(i-1).add(fibonacciResultsMap.get(i-2));
            }

            // Put into map for memoization and determining the next element in the series.
            fibonacciResultsMap.put(i, fibSeqElement);

            fibonacciSequenceElements.add(fibSeqElement);
        }

        return new FibonacciSequence().withSequenceElements(fibonacciSequenceElements);
    }

    @Override
    public void printFibonacciSequence(FibonacciSequence sequence) {
        // Outputs a String of all elements in the sequence
        System.out.println(sequence.getSequenceElements()
                .stream()
                .map(e -> e.toString())
                .collect(Collectors.joining(" "))
        );
    }
}
