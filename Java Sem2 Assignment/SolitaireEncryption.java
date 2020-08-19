

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SolitaireEncryption{

	private static Scanner input;

    
    public static void main(String[] args) {
    	try {
    	LinkedList s  = new LinkedList();
    	LinkedList s5 = new LinkedList();                                                                            //For saving the key
    	LinkedList s6 = new LinkedList();                                                                            //For saving the input number that convert from the letter
    	LinkedList s7 = new LinkedList();                                                                            //For saving the character
		LinkedList s8 = new LinkedList();                                                                            //s8 is used to check that if the number are duplicate or equals to 28 inside the deck
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28}; //this is for cheking that if the amount of input number equal to 28 and all of the numbers are not duplicated
		
			
        String mode = args[0];                                                                                       //choose the running mode     
        
    	
    	 int letterAmount= 0;  
	try{

		 String line = args[2];
        
		
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
         
			
			
			if(Character.isLetter(c)) {                                                                              //if the character is letter,the following code will be ran 
			
			 if(Character.toUpperCase(c) == 'A') {s6.addToTail(1); }
			 if(Character.toUpperCase(c) == 'B') {s6.addToTail(2); }
			 if(Character.toUpperCase(c) == 'C') {s6.addToTail(3); }
			 if(Character.toUpperCase(c) == 'D') {s6.addToTail(4); }
			 if(Character.toUpperCase(c) == 'E') {s6.addToTail(5); }
			 if(Character.toUpperCase(c) == 'F') {s6.addToTail(6); }
			 if(Character.toUpperCase(c) == 'G') {s6.addToTail(7); }
			 if(Character.toUpperCase(c) == 'H') {s6.addToTail(8); }
			 if(Character.toUpperCase(c) == 'I') {s6.addToTail(9); }
			 if(Character.toUpperCase(c) == 'J') {s6.addToTail(10); }
			 if(Character.toUpperCase(c) == 'K') {s6.addToTail(11); }
			 if(Character.toUpperCase(c) == 'L') {s6.addToTail(12); }
			 if(Character.toUpperCase(c) == 'M') {s6.addToTail(13); }
			 if(Character.toUpperCase(c) == 'N') {s6.addToTail(14); }
			 if(Character.toUpperCase(c) == 'O') {s6.addToTail(15); }
			 if(Character.toUpperCase(c) == 'P') {s6.addToTail(16); }
			 if(Character.toUpperCase(c) == 'Q') {s6.addToTail(17); }
			 if(Character.toUpperCase(c) == 'R') {s6.addToTail(18); }
			 if(Character.toUpperCase(c) == 'S') {s6.addToTail(19); }
			 if(Character.toUpperCase(c) == 'T') {s6.addToTail(20); }
			 if(Character.toUpperCase(c) == 'U') {s6.addToTail(21); }
			 if(Character.toUpperCase(c) == 'V') {s6.addToTail(22); }
			 if(Character.toUpperCase(c) == 'W') {s6.addToTail(23); }
			 if(Character.toUpperCase(c) == 'X') {s6.addToTail(24); }
			 if(Character.toUpperCase(c) == 'Y') {s6.addToTail(25); }
			 if(Character.toUpperCase(c) == 'Z') {s6.addToTail(26); }
	
			}
			else {                                                                                                  //if the character is not letter,the character will be skipped 
				continue;
			}
			
		if(Character.isWhitespace(c)) {
			continue;
		}
			letterAmount++;
			
		}
		
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Usage: java ReadTextFile <filename>");
		
		}
		catch(Exception e){
				System.out.println("Failed to open file hello.txt");
		}
	
	   
	   char  savingLetter[] = new char[letterAmount];

        if(args.length == 0) {
            System.out.println("File name not specified.");
            System.exit(1);
        }

        try {
            File file = new File(args[1]);                                                                        // this is for recording the number from deck
            input = new Scanner(file);                                                                            // this is for recording the number from deck1
        } catch (IOException ioException) {   
            System.err.println("Cannot open file.");
            System.exit(1);
        }

        while (input.hasNext()) {
            int a = Integer.parseInt(input.next());
            s.addToTail(a);
           s8.addToTail(a);                                                                                      //save for deck
        } 
       
	 
    
			for(int h = 0; h < 28; h++) {                                                                       //For check that if the number are duplicate or equals to 28 inside the deck
				
				for(int f = 0; f < 28; f++ ) {                                                                  //For check that if the number are duplicate or equals to 28 inside the deck
				if((Integer)s8.getItemAt(h) == arr[f]) {
					arr[f] = 0;                                                                                 //if the number from deck can match the current value of h
				}
			}
			}

try {
	
	
	for(int m = 0; m < 28; m++) {
		
		if(arr[m] != 0) {
			throw new ErroException();
		}
	}
	
	
	
	if(s.getCount() < 28 || s.getCount() > 28) {
		 throw new ErroException();}
       for(int a = 1; a <= savingLetter.length; a++) {
    	 
          runKey(a,s,s5,mode,s6,s7,s8);                                                                       //into the method "runkey" to generate the key  encrypt or decrypt  for the input number
         
       }
       if(mode.equals("keygen")) {                                                                            //after operating the method "runkey",if the mode is "keygen".  We will show the information of all the keys that we generated
       System.out.println("Keystream values: " + s5);}                                                        // show all the keys
      
       if(mode.equals("de") || mode.equals("en")) {                                                           //if the mode equals to "de" or "en"      we do not show the process of generation all the keys.oppositely , we will show the process of encrypt or decrypt the key
       for(int h = 0; h < letterAmount; h++) {
       	   
    	
    	   if((Integer)s6.getItemAt(h) == 1){System.out.print("A"); }                                         //according the number of s6, convert the number to letter
    	   if((Integer)s6.getItemAt(h) == 2){System.out.print("B"); }
    	   if((Integer)s6.getItemAt(h) == 3){System.out.print("C"); }
    	   if((Integer)s6.getItemAt(h) == 4){System.out.print("D"); }
    	   if((Integer)s6.getItemAt(h) == 5){System.out.print("E"); }
    	   if((Integer)s6.getItemAt(h) == 6){System.out.print("F"); }
    	   if((Integer)s6.getItemAt(h) == 7){System.out.print("G"); }
    	   if((Integer)s6.getItemAt(h) == 8){System.out.print("H"); }
    	   if((Integer)s6.getItemAt(h) == 9){System.out.print("I"); }
    	   if((Integer)s6.getItemAt(h) == 10){System.out.print("J"); }
    	   if((Integer)s6.getItemAt(h) == 11){System.out.print("K"); }
    	   if((Integer)s6.getItemAt(h) == 12){System.out.print("L"); }
    	   if((Integer)s6.getItemAt(h) == 13){System.out.print("M"); }
    	   if((Integer)s6.getItemAt(h) == 14){System.out.print("N"); }
    	   if((Integer)s6.getItemAt(h) == 15){System.out.print("O"); }
    	   if((Integer)s6.getItemAt(h) == 16){System.out.print("P"); }
    	   if((Integer)s6.getItemAt(h) == 17){System.out.print("Q"); }
    	   if((Integer)s6.getItemAt(h) == 18){System.out.print("R"); }
    	   if((Integer)s6.getItemAt(h) == 19){System.out.print("S"); }
    	   if((Integer)s6.getItemAt(h) == 20){System.out.print("T"); }
    	   if((Integer)s6.getItemAt(h) == 21){System.out.print("U"); }
    	   if((Integer)s6.getItemAt(h) == 22){System.out.print("V"); }
    	   if((Integer)s6.getItemAt(h) == 23){System.out.print("W"); }
    	   if((Integer)s6.getItemAt(h) == 24){System.out.print("X"); }
    	   if((Integer)s6.getItemAt(h) == 25){System.out.print("Y"); }
    	   if((Integer)s6.getItemAt(h) == 26){System.out.print("Z"); }
    	
           System.out.printf( "%10s", s6.getItemAt(h));                                                      //print the the original number of the letter
           System.out.printf( "%10s", s5.getItemAt(h));                                                      //print the key that will be use to calculate with the the original number of the letter
           int i = 0;
           if(mode.equals("en")){
           i =  (Integer)s6.getItemAt(h) + (Integer)s5.getItemAt(h);
           if(i <= 26) {
        	   System.out.printf("%10d", i);                                                                 //print the new number after calculating
           }
       else {
    	   i = i%26;
    	   System.out.printf("%10d", i);                                                                     //print the new number after calculating
        }
		
		
    if(i == 1){System.out.printf("%10s","A"); s7.addToTail('A');}                                           //linked list s7 is used to save the new letter which is converted from the number after calculation 
    if(i == 2){System.out.printf("%10s","B"); s7.addToTail('B');}
    if(i == 3){System.out.printf("%10s","C"); s7.addToTail('C');}
    if(i == 4){System.out.printf("%10s","D"); s7.addToTail('D');}
    if(i == 5){System.out.printf("%10s", "E"); s7.addToTail('E');}
    if(i == 6){System.out.printf("%10s","F"); s7.addToTail('F');}
    if(i == 7){System.out.printf("%10s","G"); s7.addToTail('G');}
    if(i == 8){System.out.printf("%10s","H"); s7.addToTail('H');}
    if(i == 9){System.out.printf("%10s","I"); s7.addToTail('I');}
    if(i == 10){System.out.printf("%10s","J"); s7.addToTail('J');}
    if(i == 11){System.out.printf("%10s","K"); s7.addToTail('K');}
    if(i == 12){System.out.printf("%10s","L"); s7.addToTail('L');}
    if(i == 13){System.out.printf("%10s","M"); s7.addToTail('M');}
    if(i == 14){System.out.printf("%10s","N"); s7.addToTail('N');}
    if(i == 15){System.out.printf("%10s", "O"); s7.addToTail('O');}
    if(i == 16){System.out.printf("%10s","P"); s7.addToTail('P');}
    if(i == 17){System.out.printf("%10s","Q"); s7.addToTail('Q');}
    if(i == 18){System.out.printf("%10s","R"); s7.addToTail('R');}
    if(i == 19){System.out.printf("%10s","S"); s7.addToTail('S');}
    if(i == 20){System.out.printf("%10s","T"); s7.addToTail('T');}
    if(i == 21){System.out.printf("%10s","U"); s7.addToTail('U');}
    if(i == 22){System.out.printf("%10s","V"); s7.addToTail('V');}
    if(i == 23){System.out.printf("%10s","W"); s7.addToTail('W');}
    if(i == 24){System.out.printf("%10s","X"); s7.addToTail('X');}
    if(i == 25){System.out.printf("%10s","Y"); s7.addToTail('Y');}
    if(i == 26){System.out.printf("%10s","Z"); s7.addToTail('Z');}

System.out.println("");

}



           if(mode.equals("de")){
               i =  (Integer)s6.getItemAt(h) - (Integer)s5.getItemAt(h);
               if(i > 0) {
            	   System.out.printf("%10d", i);                                                          //print the new number after calculating
               }
			   else if(i == 0) {
            	   i = 26;
            	   System.out.printf("%10d", i);                                                          //print the new number after calculating
               }
           else {
        	   i = (i+26)%26;
         
          System.out.printf("%10d", i);                                                                   //print the new number after calculating
            }
			
    if(i == 1){System.out.printf("%10s","A"); s7.addToTail('A');}                                         //linked list s7 is used to save the new letter which is converted from the number after calculation
    if(i == 2){System.out.printf("%10s","B"); s7.addToTail('B');}
    if(i == 3){System.out.printf("%10s","C"); s7.addToTail('C');}
    if(i == 4){System.out.printf("%10s","D"); s7.addToTail('D');}
    if(i == 5){System.out.printf("%10s","E"); s7.addToTail('E');}
    if(i == 6){System.out.printf("%10s","F"); s7.addToTail('F');}
    if(i == 7){System.out.printf("%10s","G"); s7.addToTail('G');}
    if(i == 8){System.out.printf("%10s","H"); s7.addToTail('H');}
    if(i == 9){System.out.printf("%10s","I"); s7.addToTail('I');}
    if(i == 10){System.out.printf("%10s","J"); s7.addToTail('J');}
    if(i == 11){System.out.printf("%10s","K"); s7.addToTail('K');}
    if(i == 12){System.out.printf("%10s","L"); s7.addToTail('L');}
    if(i == 13){System.out.printf("%10s","M"); s7.addToTail('M');}
    if(i == 14){System.out.printf("%10s","N"); s7.addToTail('N');}
    if(i == 15){System.out.printf("%10s","O"); s7.addToTail('O');}
    if(i == 16){System.out.printf("%10s","P"); s7.addToTail('P');}
    if(i == 17){System.out.printf("%10s","Q"); s7.addToTail('Q');}
    if(i == 18){System.out.printf("%10s","R"); s7.addToTail('R');}
    if(i == 19){System.out.printf("%10s","S"); s7.addToTail('S');}
    if(i == 20){System.out.printf("%10s","T"); s7.addToTail('T');}
    if(i == 21){System.out.printf("%10s","U"); s7.addToTail('U');}
    if(i == 22){System.out.printf("%10s","V"); s7.addToTail('V');}
    if(i == 23){System.out.printf("%10s","W"); s7.addToTail('W');}
    if(i == 24){System.out.printf("%10s","X"); s7.addToTail('X');}
    if(i == 25){System.out.printf("%10s","Y"); s7.addToTail('Y');}
    if(i == 26){System.out.printf("%10s","Z"); s7.addToTail('Z');}

    System.out.println("");

    }
           
       
           
       }
       
     if(mode.equals("en")){
       System.out.print("Encrypted message: " );                                                         //if we input the mode of "en",then it will show "Encrypted message:"
}

     if(mode.equals("de")){
       System.out.print("Dcrypted message: " );                                                          //if we input the mode of "en",then it will show "Decrypted message:"
}


       if(mode.equals("de") || mode.equals("en")) {
       for(int z = 0; z < letterAmount; z++) {
    	   System.out.printf(s7.getItemAt(z) + "");                                                      //show the information of all the letter after encrypting or decrypting
       
       }
       }
       }
}

catch(ErroException e) {
	System.out.println(e.getMessage());
}
    	}
    	catch(Exception e) {
    		System.out.println("Wrong deck size");
    	}
    }
       
       
    
       public static void runKey(int a,LinkedList s,LinkedList s5,String mode,LinkedList s6,LinkedList s7,LinkedList s8){ //this method generate the key  

      	 LinkedList s1 = new LinkedList();  
      	 LinkedList s2 = new LinkedList();
      	 LinkedList s3 = new LinkedList();
      	 LinkedList s4 = new LinkedList(); 
      	try {
      		if(s.getCount() < 28 || s.getCount() > 28) {
				 throw new ErroException();
			 }
    	   for(int i = 1; i <= 4; i++){ 
    		  
	     int record = 0;                                                                                  //in order to make the 27 just can come outs once
		   for(int listNumber = 0; listNumber < 28; listNumber++ ) {
			
			   if(i == 1 && (Integer)s.getItemAt(listNumber) == 27) {                                     //for s1 of each round
				
			  if(listNumber == 27) {                                                                      //just one special case 
			    
				 if(record == 1){
				 continue;}

			           int current = (Integer)s.getItemAt(0);
					   s.removeFromTail();
					   s.removeFromHead();
					   s.addToHead(27);                                                                   //the situation that 27 stay in the head
				       s.addToTail(current);
					    record ++;
				   }
				   else{
					   
				 if(record == 1){
				       continue;}
					   s.removeItemAt(listNumber); 
			         s.addItemAt(27, (listNumber + 1)%28);	     
					 record ++;
				   } 
				   }

		
			   if(i == 2 && (Integer)s.getItemAt(listNumber) == 28) {                                     //for s2 of each round
			
			        if(listNumber == 27){                                                                 //special case for 28
			  
			        if(record == 1){
				    continue;}
					
                    int current1 = (Integer)s.getItemAt(0);
					int current2 = (Integer)s.getItemAt(1);
					s.removeFromHead();                                                                   //remove the data for head of linked list
					s.removeFromHead();                                                                   //remove the data for head of linked list
					s.removeFromTail();                                                                   //remove the data for tail of linked list
					s.addToHead(28);                                                                      //add the number 28 to the second site of linked list
					s.addToHead(current2);                                                                //add the number variable current2 to the first site of linked list
					s.addToTail(current1);                                                                //add the number variable current1 to the tail of linked list   
					
					record ++;
				 }

                   else if(listNumber == 26){                                                              //special case for 28
				   if(record == 1){
				   continue;}
				  s.removeItemAt(listNumber);                                                              //reomve the last data first
				  s.addToTail(s.removeFromHead());                                                         //add the data which is removved from the head of linked lint into the tail of linked lint
				  s.addToHead(28);                                                                         //then ,add the number 28 into the head of linked lint
				   record ++;
				   
				   }
				   
				   else{
                if(record == 1){                                                                          //the variable record is used to prevent to move the site of 28 again if 28 has been move within one round. The original value of record is 0, record will be 1 if the site of 28 has been modify within each round
				 continue;}
					 s.removeItemAt(listNumber); 
			         s.addItemAt(28, (listNumber + 2)%28);	     
					 record ++;                                                                           // if the site of 28 has been modify within each round, record will be ++ to increase the value itself 
				   }
		   }
		   
		   
		   
	   }                                                                     
	   if(i == 2){                                                                                         //for this step,we need to prepare the group of number for combination in step s3
			   int amount = 1;
		   for(int listNumber = 0; listNumber < 28; listNumber++ ) {
			 
			  
				    
		   if(amount == 1 ){
		            if((Integer)s.getItemAt(listNumber) == 27 || (Integer)s.getItemAt(listNumber) == 28){
						 s2.addToTail((Integer)s.getItemAt(listNumber));                                   //s2 will start to save the data if we meet 27 or 28
						 amount++;
						
						continue;                                                                          //when the data is 27 or 28, it will stop to run the body of "if(amount == 1)"
					}
		       else{
				  
				   s1.addToTail((Integer)s.getItemAt(listNumber));  
				    }
					}
		   
	   if(amount == 2 ){                                                                                  //s2 will keep to saving the data untile meet the number 27 or 28
		   if((Integer)s.getItemAt(listNumber) == 27 || (Integer)s.getItemAt(listNumber) == 28){
						 s2.addToTail((Integer)s.getItemAt(listNumber));
                         					
						amount++;
		                 continue;                                                                        //if we satisfy the condition of the above "if", then s2 will stop to save the data	
						 }
			else{
				
				s2.addToTail((Integer)s.getItemAt(listNumber));                                           //when linked list s2 does not meet the number 27 or 28 yet, s2 we  keep to save the coming number
			}
				}
		   
		   if(amount == 3){
			  
			   s3.addToTail((Integer)s.getItemAt(listNumber));                                         	  // the remaining data of Linked list s will be saved into Linked list s3	 
		   }
		   }
		   
		   if(mode.equals("keygen")) {                
			System.out.println("S" + i + ": " + s); }                                                     //show the step 3 data
	   
			    String threeSClass = s3.toString3() + s2.toString2()  + s1.toString1();                   //combine the number which is saved in s1,s2,s3 to the string variable threeSClass
    
		 for(int deleData = 0; deleData < 28; deleData ++) {                                              //delete the original data of s LinkedList
			 s.removeFromHead();
		 }

		 String savingNumber = "";                                                                        //used to convert the data of string variable threeSClass into s Linkedlist 
	 
		                                                                                                  //the following for loop is for  convert the data of string variable threeSClass into s Linkedlist
		 for(int savingNewData = 0; savingNewData < threeSClass.length(); savingNewData++) {              //Reenter the value for s
			 char c = threeSClass.charAt(savingNewData);                                                  // get the data from string variable threeSClass by char
				
				if (Character.isWhitespace(c)) {                                                          //if there are/is space inside the string variable threeSClass, the data of string variable threeSClass will be convert to integer 
					
                    int convertToNumber = Integer.valueOf(savingNumber);
                    s.addToTail(convertToNumber);
                    savingNumber = "";                                                                    //reset savingNumber to ""
				}
				if(Character.isDigit(c)) {
					savingNumber +="" + c;                                                                //if there are/is not space behind the number of string variable threeSClass, string savingNumber will save the char for a while untile the space comes out
					
				}			
				
		 }
		 
		
		 
	   }
		 
		 if(i == 1){     
			 if(mode.equals("keygen")) {
					System.out.println("S" + i + ": " + s); }                                             //show the step 1 data
		 } 
	
		 if(i == 3){                                                                                      //this is for step 4
		                               
			 if(mode.equals("keygen")) {                                                                  //show the data of Linked list s3
					System.out.println("S" + i + ": " + s); }
		
		int lastNumber = (Integer)s.getItemAt(27);                                                        //find the value of last number of Linked list s
		
		for(int p = 0; p < lastNumber; p++) {                                                             //this is for step 4  
			int numFromS = (Integer)s.removeFromHead();                                                   //numFromS mean the data which is from Linked list s

			s4.addToTail(numFromS);                                                                       // save the number from Linked list s into Linked list s4
		}
	
		s4.addToTail(lastNumber);
		
	 if(lastNumber == 27 || lastNumber == 28) {                                                          //It is the special case if the lastNumber is 27 or 28 for step 3
		 
		 if(lastNumber == 27) {                                                                          //if the lastNumber is 27, we need to delete the lastNumber
			 s.removeFromTail();
			 continue;
			 
		 }
		 else {                                                                                          //if the lastNumber is 28, we do not need to do anything
			 
		 continue;
		 }
		 }
	
	
		s.removeFromTail();
		
		for(int k = 0 ; k < 28 - lastNumber - 1; k++) {                                                 //Delete all the data of s. Meanwhile, we move the the deleted data of s to the s4
			
			int numFromS = (Integer)(s.removeFromTail());
		    s4.addToHead(numFromS);
		}

		 }

		if(i == 4){                                                                                    //prepare this for step 4 too   
		        
		 for(int q = 0; q < 28; q++){                                                                  //Delete all the data of s4. Meanwhile, we move the the deleted data of s to the s
			 int numFromS4 = (Integer)(s4.removeFromHead());
		     s.addToTail(numFromS4);
		 }
		 if(mode.equals("keygen")) {  
				System.out.println("S" + i + ": " + s); }                                              //show the data of s4
	 
		 }
		     
		for(int e = 0; e < 28; e++) {                                                                  //Delete all the data for s1
		    if(s1.isEmpty()) {
			break;		
				}
				s1.removeFromHead(); 
			}
			
			
			for(int e = 0; e < 28; e++) {                                                              //Delete all the data for s2

				if(s2.isEmpty()) {
					break;		
						}
				s2.removeFromHead(); 
			}
			
			for(int e = 0; e < 28; e++) {                                                              //Delete all the data for s3
				if(s3.isEmpty()) {
					break;		
						}
				s3.removeFromHead(); 
			}
    }////
      	}
    	   catch(ErroException e) {
    		   System.out.println(e.getMessage());
    	   }
      
      	
	int key = (Integer)(s.getItemAt(0));                                                              //find the key by the value of the first number of linked list on step 4
	
	if(key == 28){                                                                                    //special case : if the first number of step 4 is 28, the key will be the last one of the linked list of step 4
		key = (Integer)s.getItemAt(key-1);
	}
	else{    
	key = (Integer)s.getItemAt(key);}                                                                 //all the key was found by the normal situation except the spacial case that the first number of step 4 is 28
	
		if(key == 28 || key == 27) {                                                                  //if the  key is 27 or 28, the key will be invalid
			 if(mode.equals("keygen")) {
			System.out.println("Joker : Key skipped");
			 }
			runKey(a,s,s5,mode,s6,s7,s8);                                                             //since the key is invalid if the  key is 27 or 28. Therefor we need to run again to generate the key
		}
		else{
			 if(mode.equals("keygen")) {  
			System.out.println("Key " + a +  ":" + key);                                              //show the value of key
			 }
			s5.addToTail(key);                                                                        //linked list s5 will save all the key which is generated for each round
		}
	
	
		
	

    }

    
	}


class LinkedList {
	private ListNode head;
	private ListNode tail;
	private int count;

	public LinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	public boolean isEmpty() {
		return (head==null);
	}

	public int getCount() {
		return count;
	}

	public void addToHead(Object item) {
		count++;
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			head = new ListNode(item, head);
		}
	}

	public void addToTail(Object item) {
		count++;
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			tail.next = new ListNode(item);
			tail =  tail.next;
		}
	}

	public Object removeFromHead() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		count--;
		Object item = head.data;
		if (head == tail) // there's only one single node
			head = tail = null;
		else
			head = head.next;
		return item;
	}

	public Object removeFromTail() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		count--;
		Object item = tail.data;
		if (head == tail) {   // there is only one node
			head = tail = null;
			return item;
		}
		// search for the second last node
		ListNode current = head;
		while (current.next != tail)
			current = current.next;
		// set second last node as new tail
		tail = current;
		tail.next = null;
		return item;
	}

	public Object getItemAt(int n) {
		if (n < 0 || n >= count)
			throw new IndexOutOfBoundsException();
		int currentPos=0;
		ListNode current=head;
		while (currentPos < n) {
			current=current.next;
			currentPos++;
		}
		return current.data;
	}

	public Object removeItemAt(int n) {
		if (n < 0 || n >= count)
			throw new IndexOutOfBoundsException();
		if (n==0) {
			return (removeFromHead());
		}

		int currentPos=0;
		ListNode current=head;
		while (currentPos < (n-1)) { // locate the node before the one to be removed
			current=current.next;
			currentPos++;
		}
		Object item = current.next.data;
		current.next = current.next.next;
		count--;
		return item;
	}


	public void addItemAt(Object item, int n) {
		if (isEmpty() || n==0) {
			addToHead(item);
			return;
		}
		if (n >= count) {
			addToTail(item);
			return;
		}

		int currentPos=0;
		ListNode current=head;
		while (currentPos < (n-1)) {  // locate the node before the insertion point
			current=current.next;
			currentPos++;
		}
		ListNode newNode = new ListNode(item);
		newNode.next = current.next;
		current.next = newNode;
		count++;
	}



	public String toString() {
		String s = "[ ";
		ListNode current = head;
		while (current != null) {
			s += current.data + " ";
			current = current.next;
		}
		return s + " ]";
	}

    public String toString1() {
		String s1 = "";
		ListNode current = head;
		while (current != null) {
			s1 += current.data + " ";
			current = current.next;
		}
		return s1 + "";
	}
	
	public String toString2() {
		String s2 = "";
		ListNode current = head;
		while (current != null) {
			s2 += current.data + " ";
			current = current.next;
		}
		return s2 + "";
	}

	public String toString3() {
		String s3 = "";
		ListNode current = head;
		while (current != null) {
			s3 += current.data + " ";
			current = current.next;
		}
		return s3 + "";
	}
	

}






class ListNode {
	public Object data;   // set to public for implementation convenience
	public ListNode next;

	public ListNode(Object data) {
	       this.data = data;
	       this.next = null;
	}

	public ListNode(Object data, ListNode next) {
		this.data = data;
		this.next = next;
	}
}


class EmptyListException extends RuntimeException {
	public EmptyListException() {
		super("List is empty.");
	}
}
	
class ErroException extends Exception{
	public ErroException() {
		super("Wrong deck size");
	}
}

