import java.util.*;
class Book {

    String title;
    boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
        title = bookTitle;
    }
   
    // Marks the book as rented
    public void borrowed() {
        borrowed = true;
    }
   
    // Marks the book as not rented
    public void returned() {
        borrowed = false;
    }
   
    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        return borrowed;
    }
   
    // Returns the title of the book
    public String getTitle() {
        return title;
    }
}

class Library{
    String address;
    List<Book> book=new ArrayList<Book>();     // Creating a list to store Book objects
    
    Library(String s){
        address = s;    
    }
    
    public void addBook(Book a){
        book.add(a);                          // Storing the object
    }
    
    public void printAddress(){
        System.out.println(address);
    }
    
    public void borrowBook(String b){
        int flag=0;                                // to check if the book is present in our catalog or not
        for(Book str:book){                       // for loop to check if it is equal to the title
            if(str.getTitle().equals(b)){
                flag = 1;
                if(!str.isBorrowed()){            // checking if we the book is borrowed or not
                    str.borrowed();
                    System.out.println("You successfully borrowed "+str.getTitle());
                }
                else
                    System.out.println("Sorry, this book is already borrowed.");
            }
        }
        if(flag==0)
            System.out.println("Sorry, this book is not in our catalog.");
    }
    
    public void printAvailableBooks(){
        int flag = 0;
        for(Book b:book){
            if(!b.isBorrowed()){
                flag = 1;
                System.out.println(b.getTitle());
            }
        }
        if(flag == 0){
            System.out.println("No book in catalog");
        }
    }
    
    public void returnBook(String s){
        for(Book str:book){
            if(str.getTitle().equals(s)){
                str.returned();
                System.out.println("You successfully returned "+str.getTitle());
            }
        }
    }
    
}

public class JohnLibrary{
    
    public static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }
    
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}