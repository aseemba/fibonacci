package com.fib.main;

import com.fib.service.FibSequenceService;
import com.fib.service.FibSequenceServiceImpl;

public class FibonacciSequenceMain {

    public static void main(String[] args) {
        // Validate one and only one input is accepted by the program which is the size of sequence to be generated.
        if(args.length != 1) {
            System.err.print("Invalid input. \nUsage: java -jar FibonacciSequenceMain <size_of_sequence> \n" +
                    "Example: java -jar FibonacciSequenceMain 100");
            System.exit(0);
        }

        int numElements = 0;

        // Validate the input passed to the program is a positive integer only, output error if otherwise.
        if (args[0].chars().allMatch(Character::isDigit)) {
            numElements = Integer.valueOf(args[0]);
        } else {
            System.err.print("Invalid input. \nEnter an integer value for <size_of_sequence>\n" +
                    "Usage: java -jar FibonacciSequenceMain <size_of_sequence> \n" +
                    "Example: java -jar FibonacciSequenceMain 100");
            System.exit(0);
        }

        FibSequenceService sequenceService = new FibSequenceServiceImpl();

        // Generate and print fibonacci series for a given size passed by the user.
        sequenceService.printFibonacciSequence(sequenceService.generateFibonacciSequence(numElements));
    }
}
