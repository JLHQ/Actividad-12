package Actividad12;

import java.util.*;
/**
 *
 * @author Luis_
 */
public class Main {
    public static void main(String[] args){
        AddressBook addBook = new AddressBook();
        Scanner scan = new Scanner(System.in);
        String contactName = "";
        String phoneNumber = "";
        int menu = 0;
        do{
            System.out.println("Phonebook");
            System.out.println("Choose an option");
            System.out.println("1. Display contacts");
            System.out.println("2. Create a contact");
            System.out.println("3. Delete a contact");
            System.out.println("0. Exit");
            menu = scan.nextInt();
        switch(menu){
            case 1:
                addBook.load();
                addBook.list();
                break;
            case 2:
                System.out.println("Type the contact's name");
                contactName = scan.nextLine();
                System.out.println("Type the contact's phone number");
                phoneNumber = scan.nextLine();
                addBook.create(contactName, phoneNumber);
                break;
            case 3:
                System.out.println("Type the name of the contact to be deleted");
                contactName = scan.nextLine();
                addBook.delete(contactName);
            case 0:
                addBook.save(contactName, phoneNumber);
                break;
            default:
                System.out.println("Invalid option, please try again");
            }
        }while(menu != 0);
    }
}
