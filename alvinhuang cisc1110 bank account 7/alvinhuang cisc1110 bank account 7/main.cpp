#include <iostream>
#include <fstream>
using namespace std;



const int MAX_NUM_accounts = 100;  //declaring functions
int read_accts(int acctnum_array[], double balance_array[], int max_accts, ifstream &);
void menu(ofstream &);
int findacct(int acctnum_array[], int num_accts, int account);
void withdrawal(int acctnum_array[], double balance_array[], int num_accts, ofstream &,ifstream &);
void deposit(int acctnum_array[], double balance_array[], int num_accts, ofstream &,ifstream &);
int new_acct(int acctnum_array[], double balance_array[], int num_accts, ofstream &,ifstream &);
void balance(int acctnum_array[], double balance_array[], int num_accts, ifstream &,ofstream &);
int delete_acct(int acctnum_array[], double balance_array[], int num_accts, ofstream &,ifstream &);
void print_accts(int acctnum_array[], double balance_array[], int num_accts, ofstream &);




int main() {
    
    ofstream out1("/Users/alvinhuang/Desktop/alvinhuang cisc1110 bank account 7/alvinhuang cisc1110 bank account 7/outputbankaccount.txt");
    //ofstream out1 ("/dev/stdout");
    ifstream in1("/Users/alvinhuang/Documents/inputbankaccount.txt");
    
    
    int acctnum_array[MAX_NUM_accounts]={};
    double balance_array[MAX_NUM_accounts]={};
    int num_accts;
    int max_accts=MAX_NUM_accounts;
    
    
    
    
    
    
    char choice;
    
    
    out1<<"Alvin Huang cisc1110 bank account \n\n";
    
    menu(out1);
    
    
    num_accts=read_accts(acctnum_array, balance_array, max_accts, in1);
    
    do{
        
        in1>>choice;
        
        
        switch(choice){
                
            case('W'):
                withdrawal( acctnum_array, balance_array, num_accts,out1,in1);
                break;
                
                
            case('D'):
                deposit( acctnum_array, balance_array, num_accts,out1,in1);
                break;
                
                
            case('N'):
                num_accts=new_acct( acctnum_array,  balance_array, num_accts,out1,in1);
                
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
                out1<<choice<<" is invalid\n\n\n"<<endl;
                break;
                
                
                
                
                
        }//clsoing switch
        
        
    }while(choice!='Q');
    
    
    print_accts( acctnum_array, balance_array, num_accts, out1);
    
    out1.close();
    
    in1.close();
    return 0;
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
int read_accts(int acctnum_array[], double balance_array[], int max_accts,ifstream &in1)
{
     //actual number of accts
    int num_accts=0;
   
    in1>>acctnum_array[num_accts];
   
    while( acctnum_array[num_accts]>=0  && num_accts<max_accts ){
        
        
        in1>>balance_array[num_accts];
        cout<<acctnum_array[num_accts]<<"    "<<balance_array[num_accts]<<endl;
        
     
        num_accts++;
          in1>>acctnum_array[num_accts];
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
void menu(ofstream &out1){
    out1<<"W - Withdrawal\n"
    <<"D - Deposit\n"
    <<"N - New account\n"
    <<"B - Balance\n"
    <<"Q – Quit\n"
    <<"X – Delete Account\n\n\n";
    
    

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
int findacct(int acctnum_array[], int num_accts, int account)
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
void withdrawal(int acctnum_array[], double balance_array[], int num_accts, ofstream &out1, ifstream &in1)
{
    int account,found, withdraw;;
    
    in1>>account;
    
    found=findacct(acctnum_array, num_accts, account);
    
    if(found==-1)
        
    {
        out1<<account<<" is an invalid account\n\n\n";
    }
    else
    {
        out1<<account<<" is a valid account\n";
        in1>>withdraw;
        
        if  (withdraw> balance_array[found]){
            out1<<"error: insufficient funds"<<"\n\n\n";
        }
        else
        {
            out1<<"You have withdrawn: "<<withdraw<<" from balance of "<<acctnum_array[found]
            <<" Old balance: "<<balance_array[found]<<"\n";
        
       balance_array[found] =balance_array[found] - withdraw;
        
        out1<<"The new balance is " <<balance_array[found] <<"\n\n\n";
        
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
void deposit(int acctnum_array[], double balance_array[], int num_accts, ofstream &out1, ifstream &in1)
{
    int account,found, deposit;
    
    in1>>account;
    
    found=findacct(acctnum_array, num_accts, account);
    
    if(found==-1)
        
    {
        out1<<account<<" is an invalid account\n\n\n";
    }
    else
    {
        out1<<account<<" is a valid account\n";
        in1>>deposit;
        
        
            out1<<"You have deposited : "<<deposit<<" from balance of "<<acctnum_array[found]
            <<" Old balance: "<<balance_array[found]<<"\n";
        
        balance_array[found]=balance_array[found] + deposit;
        
        out1<<" The new balance is " <<balance_array[found] <<"\n\n\n";
        
        
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
int new_acct(int acctnum_array[], double balance_array[], int num_accts, ofstream &out1, ifstream &in1)
{
    int account,found;
    
    in1>>account;
    
    found=findacct(acctnum_array, num_accts, account);
    
    if(found==-1)
        
    {
        
        //add thing
        if(num_accts<MAX_NUM_accounts)
        {
            acctnum_array[num_accts]=account;
            balance_array[num_accts]=0;
            num_accts++;
            out1<<account<<" is now a new account\n";
        }
        else
        {
        out1<<"this account can't hold any more accounts\n";
        }
           }
    else
    {
        out1<<account<<" is  invalid because it exists\n\n\n";
        
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
void balance(int acctnum_array[], double balance_array[], int num_accts,ifstream &in1, ofstream &out1)
{
    int account,found;
    
    in1>>account;
    
    found=findacct(acctnum_array, num_accts, account);
    
    if(found==-1)
        
    {
        out1<<account<<" is an invalid account\n\n\n";
    }
    else
    {
        out1<<account<<" is a valid account\n";
        out1<<"The account number is "<<acctnum_array[found]<< " and the balance is "<<balance_array[found]<<".\n\n\n";
        
        
        
        
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
int delete_acct(int acctnum_array[], double balance_array[], int num_accts, ofstream &out1, ifstream &in1)
{
    int account,found;
    
    in1>>account;
    
    found=findacct(acctnum_array, num_accts, account);
    
    if(found==-1)
        
    {
        out1<<account<<" doesn't exist\n\n\n";
        
        
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
        out1<<account<<" is  deleted\n\n\n";
    
        
        
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
void print_accts(int acctnum_array[], double balance_array[], int num_accts, ofstream &out1)
{
    int i;
    for(i=0; i<num_accts;i++)
        out1<<acctnum_array[i]<<"    "<<balance_array[i]<<endl;
   
}



