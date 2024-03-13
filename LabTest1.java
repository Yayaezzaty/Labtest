/*
 * Yaya
 * 13/3/2024 
 */

//import the respective packages
import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

//driver class
public class LabTest1
{
    //Driver method
    public static void main(String[]args) throws IOException
    {
        //Instantiate the object of DecimalFormat
        DecimalFormat dF = new DecimalFormat("0.00");

        try
        {
            //Set the input/output file
            //input file
            BufferedReader inputFile = new BufferedReader(new FileReader("employeeSalaries.txt"));

            //2 output files

            PrintWriter employeeData = new PrintWriter(new FileWriter("employeeData.txt"));
           

            //Declare the variables 
            String inputData = null;
            String employeeName;
            String yearsofservice;
            double annualsalary;

        
            
            //Write the title of the patient details to the employeeData.txt 
            employeeData.println("List all the name of the employee and salary.");

            employeeData.println("\n employeeName\t\t Salary(RM)\t\t Annual salary(RM)");

            employeeData.println("____________________________________________________________");

            //Write the title of the patient details to the withoutDiscount.txt
            employeeData.println("List of employee");
            employeeData.println("\nSalary(RM)\t\t Annual salary(RM)");
            employeeData.println("__________________________________________________________");
            
            double employeeSalary;

            while((inputData = inputFile.readLine()) != null) 
            {
                //INstantiate the object reference of the StringTokenizer

                //to pass the string line (input data) & to set the delimeter
                StringTokenizer sT = new StringTokenizer(inputData,";");

                //to pass the string line &delimeter

                //Break into tokens and assign to the appropriate variables 
                employeeName = sT.nextToken();
    

                //or

                employeeSalary = Double.parseDouble(sT.nextToken());
        

                //String str = sT.nextToken();
                //custQuan = Integer.parseInt(str);

                //To test for the negative number 
                if (employeeSalary <0)  
                    throw new IllegalArgumentException();

                //throw new IllegalArgumentException():

                //Calculate the total price
                annualsalary = employeeSalary +( employeeSalary * 5/100);

                //Intitialize the category to null
                int  Services ;
                if (Services > 5/100)
                {
                    //calculate discount
                    employeeData.println(employeeName + "\t\t"+ dF.format(employeeSalary) +"\t\t\t" );
                }
                else if(Services <= 5/100)
                {
                    employeeData.println(employeeName +"\t\t" + dF.format(employeeSalary));
                }
            }//end of while loop

            //close all the input/output files
            //close all the input/output file
            inputFile.close();
            employeeData.close();
            

        }//end of try block
        catch(FileNotFoundException ex)
        {
            String output = "File not found";
            JOptionPane.showMessageDialog(null, output);
        }//end of catch
        catch(IllegalArgumentException iae)
        {
            String output="Invalid input! The salary must be a positive number";
            JOptionPane.showMessageDialog(null,output);
        }//end of catch
    }//end of main 
}//end of class

                
            
    
    
