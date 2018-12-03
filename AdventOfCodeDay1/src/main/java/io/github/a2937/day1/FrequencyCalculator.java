package io.github.a2937.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A frequency calculator as described in Day 1 of the
 * Advent of Code 2018. This class deals with net summation.
 */
public class FrequencyCalculator
{

    private FrequencyCalculator()
    {
        throw new IllegalStateException("Utility class");
    }



    /**
     * Calculate the combined frequency
     * in accordance with the problem, where the initial charge
     * is zero.
     *
     * @param input     the input
     * @param separator the separator for the values
     * @return the net charge
     */
    public static int calculateFrequency(String input, char separator)
    {
        int netCharge = 0;
        String[] charges = input.split(Character.toString(separator));
        for (String str: charges)
        {
            if(str.contains("+"))
            {
                str = str.substring(1);
            }
            else if(str.contains(" "))
            {
                str = str.replace(" ", "");
            }
            try
            {
                int newCharge = Integer.parseInt(str);
                netCharge += newCharge;
            }
            catch(NumberFormatException nfse)
            {
                netCharge += 0;
                System.err.println(str + " was not parsable.");
            }
        }
        return netCharge;
    }

    /**
     * A method that returns the first charge on the device that
     * duplicates. It will loop through the inputs until a
     * second occurrence of a net charge is found.
     *
     * @param input     the input
     * @param separator the separator for the values
     * @return the duplicated net charge
     */
    public static int findDuplicatedFrequency(String input, char separator)
    {
        int netCharge = 0;
        String[] charges = input.split(Character.toString(separator));
        Map<Integer,Integer> frequencyCount = new HashMap<>();
        //First integer is the number itself, second number is the occurrence count.
        frequencyCount.put(0,1);
        do
        {
            for (String str: charges)
            {
                if(str.contains("+"))
                {
                    str = str.substring(1);
                }
                else if(str.contains(" "))
                {
                    str = str.replace(" ", "");
                }
                try
                {
                    int newCharge = Integer.parseInt(str);
                    netCharge += newCharge;
                    if(frequencyCount.containsKey(netCharge))
                    {
                        frequencyCount.put(netCharge, frequencyCount.get(netCharge) + 1);
                        if(frequencyCount.get(netCharge) == 2)
                        {
                            return netCharge;
                        }
                    }
                    else
                    {
                        frequencyCount.put(netCharge,1);
                    }
                }
                catch(NumberFormatException nfse)
                {
                    netCharge += 0;
                    System.err.println(str + " was not parsable.");
                }
            }
        }
        while(true);
    }
}
