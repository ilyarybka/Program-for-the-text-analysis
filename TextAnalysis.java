 import java.util.Arrays;
 
  
  public class TextAnalysis {
  
  private String[] data;
  private int[] alphabet;
  private int[] wordsize;
  private int[] wordcount;
  private int limit;
  
  
    public TextAnalysis(int limit, String[] data){ // This constructor assigns our limit and data in our class and creates three integer arrays for calculating
                                                   // letter, words lengths, and sentence length.
      
      this.limit = limit;
      this.data = data;
      alphabet = new int[26];
      wordsize = new int[15];
      wordcount = new int[30];
      
      }
      
    public void display() // This method displays the whole text line by line.
    {
    
        for (int i = 0; i < limit; i++) 
        {
        System.out.println(data[i]);
        }
    
    }
      
    public void letterAnalysis() // This method calculates the number of letters in the whole text, how many there are a letters, b letters, and so on.
    {
    
     for( int i = 0; i < limit; i++)
     {
     
       for( int j = 0; j < data[i].length(); j++)
       {
       
         //if(data[i][j] == 'a')
          // alphabet[0]++;
           
         int letter = data[i].toLowerCase().charAt(j) - 'a';
           
         if(letter >= 0 && letter <= 25)
         {
         
          alphabet[letter]++;
         
         }
         
       }
     
     }
    
    }
    
    
    
      public void wordAnalysis() // This method calculates the number of words and their lengths in the whole text. For example, home many there are words with 2
                                 // letters, 3 letters and so on.
      {
      
      int countword = 0;
      int sentence = 0;
      
        for( int i = 0; i < limit; i++)
         {
           //System.out.printf("i = %d%n%n", i);
           countword = 0;
           //System.out.println(data[i]);
           
         for( int j = 0; j < data[i].length(); j++)
           {
            boolean isdigit = Character.isDigit(data[i].charAt(j));
        
              int letter = data[i].charAt(j);  //int letter = data[i].toLowerCase().charAt(j) - 'a';
             //letter >= 0 && letter < 26
               //Character.isLetter(data[i].charAt(j)) == true
               if((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) // Checking if it is a upper or lowercase Letter
               {
                 countword++;
               }
               
               else if(isdigit == true && data[i].charAt(j + 1) == ' ') // Excluding numbers so that the program will not calculate number as a letter
               {
                 continue;
               }
               
              // System.out.printf("countword = %d%n%n", countword);
               //System.out.printf("j = %d%n%n", j);
             
               if(data[i].charAt(j) == ' ' || j + 1 == data[i].length() || (data[i].charAt(j) == '-' && data[i].charAt(j + 1) == '-'))
               //Increasing wordsize array only when you meet space, end of sentece, and excluding special character '-'.
               {
                 if(countword != 0)
                 {
                     wordsize[countword - 1]++;
                     //System.out.printf("Increasing wordsize[%d] by 1%n", countword - 1);
                     countword = 0;
                     
                 }
                 
               }
               
              
           }
              
              
          }
      
      
     }
     
     
     
     
     public void wordAnalysis(int num) // This method calculates the number of words in each sentence and prints the number of sentences specified by num 
                                       //if it is not greater than limit.
     {
     int countword1 = 0;
     
     if(num < 0 || num > limit )
       {
         System.out.println("Exceeded and cannot produce an analysis on this component.");
       }
     
    else{
     
    
      for( int i = 0; i < num; i++)
         {
           System.out.println(data[i]);
          countword1 = 0;
          //System.out.printf("Sentence %d%n:", i + 1);
          
          for( int j = 0; j < data[i].length(); j++)
         {
        
             //int letter = data[i].toLowerCase().charAt(j) - 'a';
           if(Character.isDigit(data[i].charAt(j)) == true || (Character.isDigit(data[i].charAt(j)) == true && data[i].charAt(j + 1) == ' ')){
             continue;
             }
               
               if((data[i].charAt(j) == ' ' && Character.isDigit(data[i].charAt(j - 1)) == false) || (j + 1 == data[i].length() && Character.isDigit(data[i].charAt(j - 1)) == false))
               {
                 countword1++;
                 //System.out.printf("countword1 = %d%n", countword1);
               }
         
          }
          
          //countword1++;
          wordcount[countword1 - 1]++;
          //System.out.printf("Increasing wordcount[%d] by 1%n", countword1 - 1);
          }
          
       }
     
     }
      
      
      
      public void tableDisplay() // This method displays the table which shows letter count, word lenght occurences, and Sentence Length occurances.
      {
      
      char letter = 'A';
      
      System.out.println("Letter   Count");
      
      for(int i = 0; i < 26; i++)
        {
      
        System.out.printf("%c  %d%n", letter + i, alphabet[i]);
      
        }
      
      System.out.println("---------------------------------");
      
      System.out.println("Word Length   Occurances");
      
        for(int i = 0; i < 15; i++)
        {
          System.out.printf("%d \t\t%d%n", i+1, wordsize[i]);
        }
        
       System.out.println("---------------------------------");
      
       System.out.println("Sentence Length   Occurances");
       
       for(int i = 0; i < 30; i++)
        {
      
          System.out.printf("%d \t\t\t%d%n", i+1, wordcount[i]);
      
        }
      
      }
  
  }
  
