//Earlier in Section 4, the options in IntelliJ to add unambiguous imports on the fly and Optimise imports
//on the fly were selected.

//Enabling these will make Intellij add and/or remove import statements as required.

//The import line below is what Intellij will add or remove as needed with the options selected.

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int currentYear = 2023;
        String usersDateOfBirth = "1999";

        //To access the static method in the class, "Integer" below, you do it in the format seen below
        //Integer.parseInt Integer is the class and parseInt is the static method being called.

        int dateOfBirth = Integer.parseInt(usersDateOfBirth);

        System.out.println("Age = " + (currentYear - dateOfBirth));

        //Can do the same with double:

        String usersAgeWithPartialYear = "22.5";
        double ageWithPartialYear = Double.parseDouble(usersAgeWithPartialYear);
        System.out.println("The user says he's " + usersAgeWithPartialYear);

        //Numeric values within strings often comes from an input file, a console, or some kind of user interface.

        //Options for reading data from console:

        //System.in: can read input from the console or terminal, harder to use for beginners.

        //System.console: Java's solution for easier support for reading a single line and prompting user for
        //information. Easy to use, but doesn't work with IDEs because these environments disable it.

        //Command Line Arguments: This is calling the Java program and specifying data in the call. Commonly used
        //but doesn't let us create an interactive application in a loop in Java.

        //Scanner: Built as a common way to read input, either using System.in or a file. For beginners, it's much
        //easier to understand than the bare bones System.in.


        //************************************************
        //More scanner work below for methods.

        //Added try statement to handle exception for getting input from console (Throws error because it's in an IDE).

        try {
            System.out.println(getInputFromConsole(2023));
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(2023));
        }

        //**************************************************

    }

    public static String getInputFromConsole(int currentYear){

        String name = System.console().readLine("Hi, what's your name? ");
        System.out.println("Hi " + name + ", Thanks for taking the course!");

        String dateOfBirth = System.console().readLine("What year were you born? ");

        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";
    }

    public static String getInputFromScanner(int currentYear){

        //Scanner = class from java.util. scanner = variable name for object instantiation. (= new Scanner) =
        //instantiation of object (Called Scanner) from class Scanner. (System.in) = argument passed into object.

        //"new" not needed for String class, since Java lets String class to be used as a literal (String is special)

        //We can use primitive types and Strings using methods from this scanner below.

        Scanner scanner = new Scanner(System.in);

        //Code below copied from getInputFromConsole method above to be used in getInputFromScanner method

        //The Scanner class has a method called nextLine() that doesn't support a prompt being passed in, unlike below:
        //String name = System.console().readLine("Hi, what's your name? ");
        //In that case, we need to split the prompt from the reading of the data when using the scanner.

        System.out.println("Hi, what's your name?");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + ", Thanks for taking the course!");

        //We do the same in the example below as well:

        //String dateOfBirth = System.console().readLine("What year were you born? ");

        System.out.println("What year were you born?");

        //Boolean and int created for age validation
        //Do while useful for initial prompt, leading into verification.

        boolean validDOB = false;
        int age = 0;

        do {
            System.out.println("Enter a year of birth >= " + (currentYear - 125) + " and <= " + (currentYear));
            try {
                age = checkData(currentYear, scanner.nextLine()); // Getting age can be done by a call to the validation method.
                validDOB = age < 0 ? false : true;                // This passes what the user enters as an argument to checkData method
            } catch (NumberFormatException badUserData){          // Try statement used to check for characters entered/
                System.out.println("Characters not allowed");     // handle an exception created in Java.
            }                                                     // Variable needs to be created in catch in general,
            } while(!validDOB);                                   // but is useful to access info about the exception.

        return "So you are " + age + " years old";

    }

    //*******************************************************************

    // The Scanner class is described as a simple text scanner, which can parse primitive types and strings.
    //To use the Scanner class, we have to create an instance of Scanner.
    //This means we're creating an object of type Scanner.
    //We'll use the key word new to do that.

    //The new keyword is used in what Java calls a Class Instance Creation Expression.
    //In its simplest form, it's the word new, followed by the class name, and empty parentheses:

    // ClassName variableName = new ClassName();

    //Often in many cases, we can pass parameters in the parentheses, as we saw with methods.

    // Class variableName = new ClassName(argument1, argument2);

    //And we saw that we could do this with the String class, passing text in the parentheses.

    //For reading input from the console or terminal, we instantiate a scanner object using new, followed by the
    //Scanner class name, and passing in System.in, in the parentheses:

    //Scanner sc = new Scanner(System.in);

    //For reading input from a file, we instantiate a scanner object using new, again with the Scanner class name,
    //but pass a File object, in the parentheses:

    //Scanner sc = new Scanner(new File("nameOfFileSystem"));

    //File is another class provided by Java, for reading and writing files.

    //IMPORT STATEMENT:

    //The import statement lets us use classes from other people's code.
    //In this case, Java provides a library of code, which uses the Scanner class, in a library called java.util:

    // import Java.util.Scanner;

    //***********************************************
    //New method being used to validate age range entered for scanner method:

    public static int checkData(int currentYear, String dateOfBirth){

        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if((dob < minimumYear) || (dob > currentYear)){

            return -1;

        }

        return (currentYear - dob);

    }

}
