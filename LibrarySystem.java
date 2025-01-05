package ajcom.nt;




//Book Class: Manages book details
class Book {
private String title;
private String author;
private String isbn;
private boolean isAvailable;

public Book(String title, String author, String isbn) {
   this.title = title;
   this.author = author;
   this.isbn = isbn;
   this.isAvailable = true; // Initially available
}

// Getters and Setters for book attributes
public String getTitle() {
   return title;
}

public String getAuthor() {
   return author;
}

public String getIsbn() {
   return isbn;
}

public boolean isAvailable() {
   return isAvailable;
}

// Mark a book as borrowed (not available)
public void borrowBook() {
   if (isAvailable) {
       isAvailable = false;
       System.out.println("Book borrowed successfully.");
   } else {
       System.out.println("Book is currently unavailable."+isAvailable);
   }
}

// Mark a book as returned (available)
public void returnBook() {
   if (!isAvailable) {
       isAvailable = true;
       System.out.println("Book returned successfully.");
   } else {
       System.out.println("This book was not borrowed.");
   }
}
}

//Member Class: Manages member details and borrowing logic
class Member {
private String name;
private String membershipId;
private int borrowedBooksCount;
private double fines;

public Member(String name, String membershipId) {
   this.name = name;
   this.membershipId = membershipId;
   this.borrowedBooksCount = 0;
   this.fines = 5;
}

// Getters and Setters for member details
public String getName() {
   return name;
}

public String getMembershipId() {
   return membershipId;
}

public int getBorrowedBooksCount() {
   return borrowedBooksCount;
}

public double getFines() {
   return fines;
}

// Add fine to the member
public void addFine(double fineAmount) {
   fines += fineAmount;
}

// Borrow a book (only if not exceeding limit and no fines)
public void borrowBook(Book book) {
	System.out.println(book.toString());
   if (fines > 0) {
       System.out.println("Cannot borrow books due to outstanding fines.");
   } else if (borrowedBooksCount < 5) {
       book.borrowBook();
       borrowedBooksCount++;
   } else {
       System.out.println("Cannot borrow more than 5 books.");
   }
}

// Return a book
public void returnBook(Book book) {
   book.returnBook();
   borrowedBooksCount--;
}
}

//Staff Class: Manages staff actions (add/remove books, handle fines)
class Staff {
private String name;
private String staffId;
private String role;

public Staff(String name, String staffId, String role) {
   this.name = name;
   this.staffId = staffId;
   this.role = role;
}

// Getters for staff details
public String getName() {
   return name;
}

public String getStaffId() {
   return staffId;
}

public String getRole() {
   return role;
}

// Staff actions: Add new boo ks to the system
public void addBook(Book book) {
   System.out.println("New book added: " + book.getTitle());
   System.out.println(book.toString());
}

// Staff actions: Remove a book from the system
public void removeBook(Book book) {
   System.out.println("Book removed: " + book.getTitle());
}

// Staff actions: Handle fines for members
public void imposeFine(Member member, double fineAmount) {
   member.addFine(fineAmount);
   System.out.println("Fine of $" + fineAmount + " imposed on member " + member.getName());
}
}

//Main Library Management System
class LibrarySystem {
public static void main(String[] args) {
   // Creating books
   Book book1 = new Book("Java Programming", "John Doe", "123-456-789");
   Book book2 = new Book("Data Structures", "Jane Smith", "987-654-321");
  

  // Creating staff and member
  Staff staff = new Staff("Sarah Lee", "S123", "Librarian");
  Member member = new Member("Alice Brown", "M001");
//   // Staff adding books to library system
      staff.addBook(book1);
      staff.addBook(book2);
//
   // Member borrowing a book
   member.borrowBook(book1);
   member.borrowBook(book1);  // Exceeds borrow limit

//   member.borrowBook(book2);  // Exceeds borrow limit
//   member.addFine(10);  // Member has fines
//   member.borrowBook(book1);  // Cannot borrow due to fines
//
//   // Member returning a book
//   member.returnBook(book1);
//
//   // Staff imposing a fine
//   staff.imposeFine(member, 5);
//
//   // Member borrowing a book again
//   member.borrowBook(book2);
}
}
