package com.netcracker.edu.adder;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class IntegerFileAdderTest {
    private final ClassLoader CLASS_LOADER = getClass().getClassLoader();
    private Adder adder;

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundTest() throws Exception {
        adder = new IntegerFileAdder("in.txt", "snd.txt", "out");
        adder.add();
    }

    @Test
    public void addSameFileTest() throws Exception {
        String inputPath = CLASS_LOADER.getResource("test1/input.txt").getFile();
        String outputPath = CLASS_LOADER.getResource("test1/output.txt").getFile();
        String expectedFilePath = CLASS_LOADER.getResource("test1/expected.txt").getFile();

        checkSimilarity(inputPath, inputPath, outputPath, expectedFilePath);
    }

    @Test
    public void filesOfDifferentSizeTest() throws Exception {
        String inputPath1 = CLASS_LOADER.getResource("test2/input1.txt").getFile();
        String inputPath2 = CLASS_LOADER.getResource("test2/input2.txt").getFile();
        String outputPath = CLASS_LOADER.getResource("test2/output.txt").getFile();
        String expectedFilePath = CLASS_LOADER.getResource("test2/expected.txt").getFile();

        checkSimilarity(inputPath1, inputPath2, outputPath, expectedFilePath);
    }

    @Test
    public void oneOfFilesIsEmptyTest() throws Exception{
        String inputPath1 = CLASS_LOADER.getResource("test3/input1.txt").getFile();
        String inputPath2 = CLASS_LOADER.getResource("test3/input2.txt").getFile();
        String outputPath = CLASS_LOADER.getResource("test3/output.txt").getFile();
        String expectedFilePath = CLASS_LOADER.getResource("test3/expected.txt").getFile();

        checkSimilarity(inputPath1, inputPath2, outputPath, expectedFilePath);
    }

    @Test
    public void noOutputFileTest() throws Exception {
        String inputPath1 = CLASS_LOADER.getResource("test4/input.txt").getFile();
        String outputPath = System.getProperty("user.dir") + "\\target\\test-classes\\test4\\output.txt";
        String expectedFilePath = CLASS_LOADER.getResource("test4/expected.txt").getFile();

        checkSimilarity(inputPath1, inputPath1, outputPath, expectedFilePath);
    }

    @Test(expected = NumberFormatException.class)
    public void fileWithSymbolsTest() throws Exception {
        String inputPath1 = CLASS_LOADER.getResource("test5/input1.txt").getFile();
        String inputPath2 = CLASS_LOADER.getResource("test5/input2.txt").getFile();
        String outputPath = CLASS_LOADER.getResource("test5/output.txt").getFile();
        String expectedFilePath = CLASS_LOADER.getResource("test5/expected.txt").getFile();

        checkSimilarity(inputPath1, inputPath2, outputPath, expectedFilePath);
    }

    private static String readFileToString(String filePath) throws IOException {
        File file = new File(filePath);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine());
                fileContents.append(System.lineSeparator());
            }
        }

        return fileContents.toString();
    }

    private void checkSimilarity(String firstInput, String secondInput,
                                 String output, String expected) throws Exception {
        adder = new IntegerFileAdder(firstInput, secondInput, output);
        adder.add();

        String expectedData = readFileToString(expected);
        String actualData = readFileToString(output);
        assertEquals(expectedData, actualData);
    }
}