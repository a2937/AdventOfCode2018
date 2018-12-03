package io.github.a2937.day1;

import java.util.Scanner;

public class Day1Driver
{
    private static Scanner scanner = new Scanner(System.in);
    private static final boolean isGraphical = true;

    public static void main(String[] args)
    {
        if(!isGraphical)
        {

            boolean keepRunning = false;
            do {
                System.out.println("Welcome to a summation program.");

                int option = promptForOptionType();
                if(option == 1)
                {
                    System.out.println("Please type the values you want summed. Remember to have a comma in between them.");
                    scanner.nextLine();
                    String values = scanner.nextLine();
                    System.out.println("The sum of these values is " + FrequencyCalculator.calculateFrequency(values,','));
                    System.out.println("Generating extra info. Please be patient as may take a few minutes.");
                    System.out.println("If these values were added together over and over again until the same sum would be found twice, the result would be " );
                    System.out.println(FrequencyCalculator.findDuplicatedFrequency(values,','));
                }
                else if(option == 2)
                {
                    System.out.println("Type the complete path to a file where on each line is a value that you want summed.");
                    String filePath = scanner.nextLine();
                    String values = FileReader.readValuesFromFile(filePath);
                    System.out.println("The sum of these values is " + FrequencyCalculator.calculateFrequency(values,'\n'));
                    System.out.println("Generating extra info. Please be patient as may take a few minutes.");
                    System.out.println("If these values were added together over and over again until another sum was found, that sum would be " +
                            FrequencyCalculator.findDuplicatedFrequency(values,'\n'));
                }
                System.out.println("Type 1 on the next and hit enter if you want to repeat the program. Otherwise type any other number on that line.");
                int value = scanner.nextInt();
                scanner.nextLine();
                keepRunning = value == 1;
            }
            while(keepRunning);
            System.out.println("Now exiting the program...");
            System.exit(0);
        }
        else
        {
            DayOneMainWindow frame = new DayOneMainWindow();
            frame.setVisible(true);
        }

    }


    private static int promptForOptionType()
    {
        System.out.println("Available options: \n 1)Typing a series of comma separated values.\n 2)Load values from a file");
        System.out.println("Enter your response on the next line then hit enter: ");
        int option = -1;
        char input = scanner.next().charAt(0);
        if(Character.isDigit(input))
        {
            option = Integer.parseInt(Character.toString(input));
            if(option == 1 || option == 2)
            {
                return option;
            }
        }
        boolean stillIncorrect = true;

        do
            {
            scanner.nextLine();
            System.out.println("Incorrect choice possible values include 1 or 2\n Please try again: ");
            input = scanner.next().charAt(0);
            if(Character.isDigit(input) )
            {
                option = Integer.parseInt(Character.toString(input));
                if(option == 1 || option == 2)
                {
                    stillIncorrect = false;

                }
            }
            else
            {
                System.out.println("Incorrect choice possible values include 1 or 2\n Please try again: ");
            }
        }
        while(stillIncorrect);
        return option;
    }

}

