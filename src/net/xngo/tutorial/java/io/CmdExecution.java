package net.xngo.tutorial.java.io;

import java.io.IOException;

public class CmdExecution
{

  public static void main(String[] args)
  {
    // Get the appropriate command depending on the operating system.
    String os_name = System.getProperty("os.name");
    String cmdLine[];
    if(os_name.indexOf("Windows")!=-1)
      cmdLine= new String[] {"cmd", "/C", "dir > .\\test_out.txt"};
    else
      cmdLine= new String[] {"/bin/sh", "-c", "ls > ./test_out.txt"};
    
    
    try
    {
      
      // Print what will be run.
      System.out.println("Running: ");
      System.out.print("\t");
      for(String str: cmdLine)
        System.out.print(str+" ");
      System.out.println();
      
      
      // Execute the command.
      Process process = Runtime.getRuntime().exec(cmdLine); 
      
      
      /*
      // Get console output.
      BufferedReader in = new BufferedReader(  
                          new InputStreamReader(process.getInputStream()));  
      String line = null;  
      while ((line = in.readLine()) != null)
      {  
          System.out.println(line);  
      }       


      try { process.waitFor(); } catch(InterruptedException ex){ ex.printStackTrace(); } // Wait for the process to terminate.
      process.exitValue();
      */

    }
    catch(IOException ex)
    {
      ex.printStackTrace();
    }

  }

}