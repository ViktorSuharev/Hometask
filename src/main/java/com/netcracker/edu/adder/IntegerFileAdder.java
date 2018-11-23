package com.netcracker.edu.adder;

/**
 * Class is responsible for adding 2 files with integers line by line and saving a result to another file
 * If at least one of input files does not exist, throw appropriate exception with
 * If output file already exists, rewrite content of it
 * If there are some rows cannot be converted to integer, throw appropriate exception
 * If rows counts of input files are not equal, assume nonexistent rows shall be completed by zeros
 * If result of sum operation is not in [INTEGER_MIN; INTEGER_MAX) half-open interval throw appropriate exception
 *
 * Expected file format: each line contains one integer
 * e.g. input files: input1.txt, input2.txt; output file: output.txt
 *
 * input1.txt   input2.txt      output.txt
 * 1            4               5
 * 2            5               7
 * 3            6               9
 *
 * input1.txt   input2.txt      output.txt
 * 1            4               5
 * 2            5               7
 * 3            6               9
 * 11                           11
 *
 *
 * Additional requirements:
 * Large files which size exceeded free heap space shall be operated successfully
 * Unit testing shall cover positive and negative cases
 *
 */
public class IntegerFileAdder implements Adder {

    private final String pathToInputFile1;
    private final String pathToInputFile2;
    private final String pathToOutputFile;

    /**
     * Default constructor
     * @param pathToInputFile1 absolute path to first file
     * @param pathToInputFile2 absolute path to second file
     * @param pathToOutputFile absolute path to output file
     */
    public IntegerFileAdder(String pathToInputFile1, String pathToInputFile2, String pathToOutputFile) {
        this.pathToInputFile1 = pathToInputFile1;
        this.pathToInputFile2 = pathToInputFile2;
        this.pathToOutputFile = pathToOutputFile;
    }

    /**
     * Method adds integer content of 2 input files line by line and saves result to output file or throws exception
     * @throws Exception
     */
    public void add() throws Exception {
        // implement me
    }
}
