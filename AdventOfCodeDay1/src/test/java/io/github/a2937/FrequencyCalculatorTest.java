package io.github.a2937;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import io.github.a2937.day1.FrequencyCalculator;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

/** 
* FrequencyCalculator Tester. 
* 
* @author Aaron Cottrill
* @since <pre>Dec 1, 2018</pre> 
* @version 1.0 
*/ 
public class FrequencyCalculatorTest { 

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

@Before
public void before() throws Exception
{
} 

@After
public void after() throws Exception
{
} 

/** 
 *
 * Method: readValuesFromFile(String fileLocation)
 * This method returns a string of all the contents in
 * a file. Each line is separated by a new line character defined as
 * '\n'.
*/ 
@Test
public void testReadValuesFromFile() throws Exception
{

    //ClassLoader classLoader = getClass().getClassLoader();
    //File file = new File(classLoader.getResource("input.txt").getFile());
    //System.out.println(file.getAbsolutePath());

    File file = createTmpFileFromResource(temporaryFolder,"input.txt");

    String fileContents = FrequencyCalculator.readValuesFromFile(file.getAbsolutePath());

    Assert.assertNotEquals(fileContents,null);
    Assert.assertFalse(fileContents.isEmpty());
    Assert.assertTrue(fileContents.contains("\n"));

}

/*
 * This method builds out a file to look for, as one cannot be loaded directly from resources.
 */
private static File createTmpFileFromResource(TemporaryFolder folder, String classLoaderResource)
{
    try
    {
        URL resource = Resources.getResource(classLoaderResource);
        File tmpFile = folder.newFile();
        Resources.asByteSource(resource).copyTo(Files.asByteSink(tmpFile));
        return tmpFile;
    } catch (IOException e)
    {
        e.printStackTrace();
    }
    return null;
}

/** 
 *
 * Method: calculateFrequency(String input, char separator)
 * The method takes a series of numbers with a separator and
 * adds them together.
 * This test includes the three examples provided as part of
 * the adventure of code.
 * Each example includes a space in between them,
 * since it has the potential to present an problem.
*/ 
@Test
public void testCalculateFrequency() throws Exception
{
    Assert.assertEquals(FrequencyCalculator.calculateFrequency("+1, +1, +1",','),3);
    Assert.assertEquals(FrequencyCalculator.calculateFrequency("+1, +1, -2",','),0);
    Assert.assertEquals(FrequencyCalculator.calculateFrequency("-1, -2, -3",','),-6);
} 

/** 
 *
 * Method: findDuplicatedFrequency(String input, char separator)
 * This method takes a series of numbers and combines them over and over
 * to the last known value again until the same sum appears twice. It initially
 * starts at zero.
 * This test includes the three examples provided. Each example
 * includes a space in between them, since it has the potential to
 * present an actual problem.
*/ 
@Test
public void testFindDuplicatedFrequency() throws Exception
{
    Assert.assertEquals(FrequencyCalculator.findDuplicatedFrequency("+1, -1",','),0);
    Assert.assertEquals(FrequencyCalculator.findDuplicatedFrequency("+3, +3, +4, -2, -4",','),10);
    Assert.assertEquals(FrequencyCalculator.findDuplicatedFrequency("-6, +3, +8, +5, -6",','),5);
    Assert.assertEquals(FrequencyCalculator.findDuplicatedFrequency("+7, +7, -2, -7, -4",','),14);
} 


} 
