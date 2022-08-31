

import java.io.*;
import java.util.ArrayList;

import java.util.ListIterator;

import java.util.*;
class BookShop implements Serializable{
    //variable initialize to set
 String name;
     int ID;
     double price;

public BookShop(String name, int ID, double price) {
    this.name=name ;
            this.ID=ID;
            this.price=price;
}


            

    @Override
public String toString() {
    return "    Book Name      : " +name+    "     \t Book ID :         "   +ID+ "     \tPrice:  TK "+price;
}

}
class Search{

            




/**
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception {

    Scanner input = new Scanner(System.in);

    String username;
    String password;

    System.out.println("Log in:");
    System.out.println("Insert username: ");
    username = input.nextLine();

    System.out.println("Insert password: ");
    password = input.nextLine();

    Registration check = new Registration(username, password);

    if(check.auth()) 
        System.out.println("You are logged in");






    
    Scanner s = new Scanner(System.in);
    Scanner s1 =new Scanner (System.in);
    String name ;
            int ID;
            double price;
            boolean run = true;
            //making file
             File  file=new File ("BookShop.txt");
             /*ArrayList class is use instead of taking an array so that the function can be done easily  
             not need to create extra objects for doing different function*/
        ArrayList<BookShop> a1= new ArrayList<BookShop>();
        //using oos to make object  taking input and write  and read files
                    ObjectOutputStream oos = null;
                    ObjectInputStream ois= null;
                    //ListIterator is used to iterate the information
                    ListIterator li= null;
                    //checking file exist or not if exist then read
                 if (file.isFile()){
                     ois = new ObjectInputStream(new FileInputStream(file));
                     a1=(ArrayList<BookShop>)ois.readObject();
                        ois.close();}
                 
    
    
    while(run) {
        System.out.println("                  Welcome                        ");
        System.out.println("------------------NSU BOOK SHOP------------------");
        System.out.println("Hello sir:  ");
        System.out.println("You Can Choose");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("3. Search");
        System.out.println("4. View");
        System.out.println("5. Edit");
        System.out.println("6. SORT BY ID ");
        System.out.println("7.Print Invoice");
        System.out.println("8. Exit");
        System.out.println("Enter Your choice==>");
        
        int c = s.nextInt();
        switch(c) {
        case 1:
                        System.out.println("How many book you want to store : ");
                        int n =s.nextInt();
                        for (int i=0;i<n;i++)
                        {
            System.out.print("Enter Book name :");
            name = s1.nextLine();
                                System.out.print("Enter Book ID :");
                            ID=s.nextInt();
                            System.out.print("Enter Book Price :");
                            price =s.nextDouble();
                            //creating object of BookShop and adding new books
            BookShop p = new BookShop(name, ID,price);
            a1.add(new BookShop(name , ID ,price));
                            
                        }
                        //writes in file
                         oos =new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(a1);
                            oos.close();
                        
                           
                            break;
        case 2:
                                     
                 if (file.isFile()){
                     ois = new ObjectInputStream(new FileInputStream(file));
                     a1=(ArrayList<BookShop>)ois.readObject();
                     ois.close();
                 
    
                        boolean found =false;
                        System.out.println("Enter Book ID to Delete:   ");
                      int id =s.nextInt();

                    System.out.println("-------------------------------------");
                        li=a1.listIterator();
                        while (li.hasNext()){
                            //removing book
                        BookShop p= (BookShop)li.next();
                        if (p.ID == id){
                          li.remove();
                            found =true;
                        }}
                        if (found )
                        //write in file 
                            oos=new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(a1);
                            oos.close();
                            
                    
                            }
                        
                        else {
                                System.out.println("File doesnt exists");
                                }
                        
                     break;
            
        case 3:
                              
                 if (file.isFile()){
                     ois = new ObjectInputStream(new FileInputStream(file));
                     a1=(ArrayList<BookShop>)ois.readObject();
                     ois.close();
                 
    
                        boolean found =false;
                        System.out.println("Enter Book ID to Search :   ");
                   
                      int id =s.nextInt();
                    System.out.println("-------------------------------------");
                        li=a1.listIterator();
                        while (li.hasNext()){
                        BookShop p= (BookShop)li.next();
                        if (p.ID == id){
                            System.out.println(p);
                            found =true;
                        }}
                        if (!found)
                        
                            System.out.println("Record Not Found ");
                              System.out.println("-------------------------------------");
                 }else 
                 {
                     System.out.println("File not Exists");
                 }
                 break;
                        
                       
            
        case 4:
                          if (file.isFile()){
                     ois = new ObjectInputStream(new FileInputStream(file));
                     a1=(ArrayList<BookShop>)ois.readObject();
                     ois.close();
                 
                        System.out.println("-------------------------------------");
                        li=a1.listIterator();
                        
                        while(li.hasNext())
                            System.out.println(li.next());
            System.out.println("-------------------------------------");
                          } 
                           else 
                        {
                            System.out.print("FIle NOT FOUND");
                        } 
                           

                        break;

                            case 5:
                            if (file.isFile()){
                                ois = new ObjectInputStream(new FileInputStream(file));
                                a1=(ArrayList<BookShop>)ois.readObject();
                                ois.close();
                            
               
                                   boolean found =false;
                                   System.out.println("Enter Book ID to Update:   ");
                                  int id1 =s.nextInt();
                               System.out.println("-------------------------------------");
                                   li=a1.listIterator();
                                   while (li.hasNext()){
                                   BookShop p= (BookShop)li.next();
                                   if (p.ID == id1 ){
                                 System.out.print("Enter New BookName: ");
                                 String Name  =s1.nextLine();
                                 System.out.print("Enter New BookID: ");
                               int id =s.nextInt();
                               System.out.print("Enter New BookPrice: ");
                               Double Price =s.nextDouble();
                               li.set(new BookShop(Name ,id ,Price));
                                       found =true;
                                   }}
                                   if (found )
                                       oos=new ObjectOutputStream(new FileOutputStream(file));
                                       oos.writeObject(a1);
                                       oos.close();
                                       
                               
                                       }
                                   
                                   else {
                                           System.out.println("File doesnt exists");
                                           }


                                           break;
                                           case 6:
                                           if (file.isFile()){
                                            ois = new ObjectInputStream(new FileInputStream(file));
                                            a1=(ArrayList<BookShop>)ois.readObject();
                                            ois.close();
                                        Collections.sort(a1, new Comparator<BookShop>()
                                        {
                                        public int compare(BookShop p1,BookShop p2)
                                        {
                                          return p1.ID-p2.ID;
                                        }});
                                        oos=new ObjectOutputStream(new FileOutputStream(file));
                                        oos.writeObject(a1);
                                        oos.close();
                                               System.out.println("-------------------------------------");
                                               li=a1.listIterator();
                                               
                                               while(li.hasNext())
                                                   System.out.println(li.next());
                                   System.out.println("-------------------------------------");
                                                 } 
                                                  else 
                                               {
                                                   System.out.print("FIle NOT FOUND");
                                               } 
                                               break;
                                                  case 7: 
                                                  if (file.isFile()){
                                                    ois = new ObjectInputStream(new FileInputStream(file));
                                                    a1=(ArrayList<BookShop>)ois.readObject();
                                                    ois.close();
                                                
                                   
                                                       boolean found =false;
                                                       System.out.println("Enter Book ID Print the Invoice :   ");
                                                  
                                                     int id =s.nextInt();
                                                   System.out.println("-------------------------------------");
                                                       li=a1.listIterator();
                                                       while (li.hasNext()){
                                                       BookShop p= (BookShop)li.next();
                                                       if (p.ID == id){
                                                           System.out.println(p);
                                                           found =true;
                                                       }}
                                                       if (!found)
                                                       
                                                           System.out.println("Record Not Found ");
                                                             System.out.println("-------------------------------------");
                                                }else 
                                                {
                                                    System.out.println("File not Exists");
                                                }
                                                break;

                       
                       
        default:
            System.out.println("Thanks");
            run = false;
        }
   }
}}


