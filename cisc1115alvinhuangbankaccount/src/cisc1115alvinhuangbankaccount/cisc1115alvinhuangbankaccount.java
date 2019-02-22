package cisc1115alvinhuangbankaccount;
import java.util.Scanner;
import java.io.*;

public class cisc1115alvinhuangbankaccount {

	public static void main(String[] args) throws IOException {
	
		final int MAX_NUM_accounts = 100;
		 
		 PrintWriter out1= new PrintWriter("/Users/alvinhuang/Documents/outputbankaccount1.txt");
		   
		 
		 File infile= new File("system.in");
		   // File infile= new File("/Users/alvinhuang/Documents/inputbankaccount2.txt");
		    Scanner in1= new Scanner(infile);
		 
		    
		    int [] acctnum_array =  new int [MAX_NUM_accounts];
		    double [] balance_array=new double [MAX_NUM_accounts];
		    int num_accts=0;
		    int max_accts=MAX_NUM_accounts;
		    
		    

		    char choice;
		    
		    
		    out1.print("Alvin Huang cisc1115 bank account \n\n");
		    
		    menu(out1);
		    
		    acctnum_array[num_accts]=in1.nextInt();
			   
		    while( acctnum_array[num_accts]>=0  && num_accts<max_accts ){
		        
		        
		       balance_array[num_accts]=in1.nextInt();
		    System.out.println(acctnum_array[num_accts]+"    "+ balance_array[num_accts]);
		        
		     
		        num_accts++;
		          acctnum_array[num_accts]=in1.nextInt();
		        }
		   // num_accts=read_accts(acctnum_array, balance_array, max_accts, in1);
		    /*
		    do{
		        
		        choice=in1.next().charAt(0);
		        
		        
		        switch(choice){
		                
		            case('W'):
		                withdrawal( acctnum_array, balance_array, num_accts,out1,in1);
		                break;
		                
		                
		            case('D'):
		                deposit( acctnum_array, balance_array, num_accts,out1,in1);
		                break;
		                
		                
		            case('N'):
		                num_accts=new_acct( acctnum_array,  balance_array,MAX_NUM_accounts, num_accts,out1,in1);
		                
		                break;
		                
		                
		            case('B'):
		                balance( acctnum_array,  balance_array,  num_accts,in1,out1);
		                break;
		                
		                
		            case('X'):
		               num_accts= delete_acct( acctnum_array, balance_array, num_accts,out1,in1);
		                break;
		                
		                
		            case('Q'):
		                
		                break;
		                
		                
		                
		                
		            default:
		            	out1.print(choice+" is invalid\n\n\n\n");
		                break;
		                
		                
		                
		                
		                
		        }//closing switch
		        
		        
		    }while(choice!='Q');
		    
		    
		    print_accts( acctnum_array, balance_array, num_accts, out1);
		    */
		    out1.close();
		    
		    in1.close();
		  
		}



		/*
		 input:
		 acctnum_array[]- account numbers
		 balance_array[]- amount of money
		 max_accts-maximum of accounts
		 
		 in1- reference to input file
		 
		 process:
		 taking in account numbers and balance
		 output:
		 sending account numbers and balance
		 
		 */
		public static int read_accts(int []acctnum_array, double []balance_array, int max_accts,Scanner in1)
		{
		     //actual number of accts
		    int num_accts=0;
		   
		    acctnum_array[num_accts]=in1.nextInt();
		   
		    while( acctnum_array[num_accts]>=0  && num_accts<max_accts ){
		        
		        
		       balance_array[num_accts]=in1.nextInt();
		    System.out.println(acctnum_array[num_accts]+"    "+ balance_array[num_accts]);
		        
		     
		        num_accts++;
		          acctnum_array[num_accts]=in1.nextInt();
		        }
		    
		    return num_accts;
		}



		/*input:
		 out1-a reference to the output file
		 
		 process:
		 printing menu
		 
		 output:
		 print menu
		 */
		public static void menu(PrintWriter out1){
			out1.print("W - Withdrawal\n"
		    +"D - Deposit\n"
		    +"N - New account\n"
		    +"B - Balance\n"
		    +"Q – Quit\n"
		    +"X – Delete Account\n\n\n");
		    
		    

		}

		/*
		 input:
		 acctnum_array[]- account number
		 num_accts- number of accounts
		 account- input account number

		 
		 process:
		 checking if account is valid or not
		 
		 output:
		 print if account is valid or not
		 
		 */
		public static int findacct(int []acctnum_array, int num_accts, int account)
		{
		    int found=-1; //assume not found
		    
		    for(int i=0; i<num_accts;i++)
		        if( acctnum_array[i]==account) //search found
		            found= i;
		    
		    
		    return found;
		}






		/*
		 input:
		 acctnum_array[]- account number
		 num_accts- number of accounts
		 account- input account number
		 in1- a reference to the input file
		 out1-a reference to the output file
		 
		 process:
		 withdrawing money
		 
		 output:
		 print money withdraw
		 
		 */
		public static void withdrawal(int []acctnum_array, double []balance_array, int num_accts, PrintWriter out1, Scanner in1)
		{
		    int account,found, withdraw;;
		    
		    account=in1.nextInt();
		    
		    found=findacct(acctnum_array, num_accts, account);
		    
		    if(found==-1)
		        
		    {
		    	out1.print(account+" is an invalid account\n\n\n");
		    }
		    else
		    {
		    	out1.print(account+" is a valid account\n");
		        withdraw=in1.nextInt();
		        
		        if  (withdraw> balance_array[found]){
		        	out1.print("error: insufficient funds"+"\n\n\n");
		        }
		        else
		        {
		        	out1.print("You have withdrawn: "+withdraw+" from balance of "+acctnum_array[found]
		            +" Old balance: "+balance_array[found]+"\n");
		        
		       balance_array[found] =balance_array[found] - withdraw;
		        
		       out1.print("The new balance is " +balance_array[found] +"\n\n\n");
		        
		        }
		    }
		    
		    
		    
		    
		    
		    
		    
		}





		/*
		 input:
		 acctnum_array[]- account number
		 num_accts- number of accounts
		 account- input account number
		 in1- a reference to the input file
		 out1-a reference to the output file
		 
		 process:
		 depositing money
		 
		 output:
		 print money deposit
		 
		 */
		public static void deposit(int []acctnum_array, double []balance_array, int num_accts, PrintWriter out1, Scanner in1)
		{
		    int account,found, deposit;
		    
		    account=in1.nextInt();
		    
		    found=findacct(acctnum_array, num_accts, account);
		    
		    if(found==-1)
		        
		    {
		    	out1.print(account+" is an invalid account\n\n\n");
		    }
		    else
		    {
		    	out1.print(account+" is a valid account\n");
		        deposit=in1.nextInt();
		        
		        
		        out1.print("You have deposited : "+deposit+" from balance of "+acctnum_array[found]
		            +" Old balance: "+balance_array[found]+"\n");
		        
		        balance_array[found]=balance_array[found] + deposit;
		        
		        out1.print(" The new balance is " +balance_array[found] +"\n\n\n");
		        
		        
		    }
		    
		    
		    
		    
		    
		    
		 
		}

		/*
		 input:
		 acctnum_array[]- account number
		 num_accts- number of accounts
		 account- input account number
		 in1- a reference to the input file
		 out1-a reference to the output file
		 
		 process:
		 create new account
		 
		 output:
		 print new account
		 
		 */
		public static int new_acct(int []acctnum_array, double []balance_array, int num_accts,int MAX_NUM_accounts, PrintWriter out1, Scanner in1)
		{
		    int account,found;
		    
		    account=in1.nextInt();
		    
		    found=findacct(acctnum_array, num_accts, account);
		    
		    if(found==-1)
		        
		    {
		        
		        //add thing
		        if(num_accts<MAX_NUM_accounts)
		        {
		            acctnum_array[num_accts]=account;
		            balance_array[num_accts]=0;
		            num_accts++;
		            out1.print(account + " is now a new account\n");
		        }
		        else
		        {
		        	out1.print("this account can't hold any more accounts\n");
		        }
		           }
		    else
		    {
		    	out1.print(account+" is  invalid because it exists\n\n\n");
		        
		    }
		    return num_accts;
		}



		/*
		 input:
		 acctnum_array[]- account number
		 num_accts- number of accounts
		 account- input account number
		 in1- a reference to the input file
		 out1-a reference to the output file
		 
		 process:
		 show balance
		 
		 output:
		 print balance
		 
		 */
		public static void balance(int []acctnum_array, double []balance_array, int num_accts,Scanner in1, PrintWriter out1)
		{
		    int account,found;
		    
		    account=in1.nextInt();
		    
		    found=findacct(acctnum_array, num_accts, account);
		    
		    if(found==-1)
		        
		    {
		    	out1.print(account+" is an invalid account\n\n\n");
		    }
		    else
		    {
		    	out1.print(account+" is a valid account\n");
		    	out1.print("The account number is "+acctnum_array[found]+ " and the balance is "+balance_array[found]+".\n\n\n");
		        
		        
		        
		        
		    }
		    
		    
		    
		    
		    
		    
		  
		}



		/*
		 input:
		 acctnum_array[]- account number
		 num_accts- number of accounts
		 account- input account number
		 in1- a reference to the input file
		 out1-a reference to the output file
		 
		 process:
		 delete old account
		 
		 output:
		 print deleted old account
		 
		 */
		public static int delete_acct(int []acctnum_array, double []balance_array, int num_accts, PrintWriter out1, Scanner in1)
		{
		    int account,found;
		    
		    account=in1.nextInt();
		    
		    found=findacct(acctnum_array, num_accts, account);
		    
		    if(found==-1)
		        
		    {
		    	out1.print(account+" doesn't exist\n\n\n");
		        
		        
		    }
		    
		    else
		    {
		      int i,a=0;
		        for (i = 0; i < num_accts; i++)
		        {
		            if(acctnum_array[i] == account ){
		                a=i;
		            }
		        }
		        
		        
		        while(a<num_accts)
		            {
		                acctnum_array [a] = acctnum_array[a+1];
		                acctnum_array [num_accts] = acctnum_array[num_accts+1];
		                
		                balance_array [a] = balance_array[a+1];
		                balance_array [num_accts] = balance_array[num_accts+1];
		            
		                a++;
		            
		            }
		         num_accts=num_accts-1;
		         out1.print(account+" is  deleted\n\n\n");
		    
		        
		        
		    }
		    return num_accts;
		}


		/*
		 input:
		 acctnum_array[]- account number
		 num_accts- number of accounts
		 account- input account number
		out1-a reference to the output file
		 
		 process:
		 show account and balance
		 
		 output:
		 print account and balance
		 
		 */
		public static void print_accts(int []acctnum_array, double []balance_array, int num_accts, PrintWriter out1)
		{
		    int i;
		    for(i=0; i<num_accts;i++)
		    	out1.println(acctnum_array[i]+"    "+balance_array[i]);
		   
		}





}
