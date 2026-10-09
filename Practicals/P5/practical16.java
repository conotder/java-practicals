class Library {
  private String libraryName;
  private int totalBook = 0;

  public Library(String name) {
    this.libraryName = name;
  }

  class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
      this.title = title;
      this.author = author;
      totalBook++;
    }

    public void displayBookDetails() {
      System.out.println("Book: '" + title + "' by " + author + " | Available at: " + libraryName);
    }
  }

  public void displayLibraryInfo() {
    System.out.println("Welcome to " + libraryName + ". Total books registered: " + totalBook);
  }
}

class practical16 {
  public static void main(String[] args) {
    Library vsitrLib = new Library("VSITR Library");

    Library.Book book1 = vsitrLib.new Book("Java Programming", "James Goslin");
    Library.Book book2 = vsitrLib.new Book("Clean Code", "Robert C. Martin");

    vsitrLib.displayLibraryInfo();
    System.out.println("\n --- Registered Books ---");
    book1.displayBookDetails();
    book2.displayBookDetails();
  }
}
