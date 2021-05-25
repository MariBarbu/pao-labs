package com.company;

import com.company.Exceptions.FileWritingException;
import com.company.repository.BookRepository;
import com.company.repository.LibrarianRepository;
import com.company.repository.LibraryRepository;
import com.company.repository.SectionRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class Services{

    static LibraryRepository libraryRepository = new LibraryRepository();
    static SectionRepository sectionRepository = new SectionRepository();
    static BookRepository bookRepository = new BookRepository();
    static LibrarianRepository librarianRepository = new LibrarianRepository();

    Scanner scanner = new Scanner(System.in);
    static private TreeSet<Employee> employees = new TreeSet<Employee>(Comparator.comparing(Employee::getHours));
    static private List<Library> libraries = libraryRepository.getAll();
    static private List<Lending>lendings = new ArrayList<Lending>();
    static private List<Subscription> subscriptions = new ArrayList<Subscription>();

    public static TreeSet<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(TreeSet<Employee> employees) {
        Services.employees = employees;
    }

    public static List<Library> getLibraries() {
        return libraries;
    }

    public static void setLibraries(List<Library> libraries) {
        Services.libraries = libraries;
    }

    public static List<Lending> getLendings() {
        return lendings;
    }

    public static void setLendings(List<Lending> lendings) {
        Services.lendings = lendings;
    }

    public static List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public static void setSubscriptions(List<Subscription> subscriptions) {
        Services.subscriptions = subscriptions;
    }


    //LIBRARIE





    public void createTables(){
        librarianRepository.createTable();
        libraryRepository.createTable();
        sectionRepository.createTable();
        bookRepository.createTable();
    }

    //adauga librarie

    public void addLibrary() throws FileWritingException {
        System.out.println("Name of the library: ");
        String lName = scanner.nextLine();
        System.out.println("Adress of the library: ");
        String address = scanner.nextLine();

        libraryRepository.insertLibrary(lName, address);
        libraries = libraryRepository.getAll();
        System.out.println("Library added");
        Services.audit("newlibrary");


    }

    //afiseaza librarii

    public void showLibraries() throws FileWritingException {
        int i = 1;
        for(Library library : libraries){
            System.out.println(i + ". " + library);
            i ++;
        }
        Services.audit("showlibraries");
    }

    // modifica librarie

    public void updateLibrary() throws FileWritingException{
        System.out.println("Choose library: \n");
        int i = 1;
        for (Library library:libraries) {
            System.out.println(i + ". " + library);
            i ++;
        }
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name: \n");
        String newName = scanner.nextLine();
        System.out.println(libraries.get(lIndex-1).getId());
        libraryRepository.updateLibraryName(newName, libraries.get(lIndex-1).getId());
        libraries = libraryRepository.getAll();
        Services.audit("updatelibraries");
    }

    // sterge librarie

    public void deleteLibrary() throws FileWritingException{
        System.out.println("Choose library: \n");
        int i = 1;
        for (Library library:libraries) {
            System.out.println(i + ". " + library);
            i ++;
        }
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        libraryRepository.deleteLibrary(libraries.get(lIndex-1).getId());
        System.out.println("Library deleted! \n");
        libraries = libraryRepository.getAll();
        Services.audit("deletelibraries");
    }

    //SECTIE

    //adauga sectie intr-o librarie

    public void addSection() throws FileWritingException {
        showLibraries();
        System.out.println("\nIndex of the library: ");
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        Library library = libraries.get(lIndex - 1);
        System.out.println("Name of the section: ");
        String sName = scanner.nextLine();
        System.out.println("Floor of the section: ");
        int floor = scanner.nextInt();
        scanner.nextLine();
        List<Book> books = new ArrayList<Book>();
        sectionRepository.insertSection(sName, floor, library.getId());
        System.out.println("Successful insertion!\n");
        Services.audit("newSection");
    }



    //sterge sectie

    public void removeSection() throws FileWritingException {
        Library library = showSections();
        System.out.println("Index of the section you want to remove: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        List<Section> sections = sectionRepository.getAll(library.getId());
        sectionRepository.deleteSection(sections.get(sIndex-1).getId());
        System.out.println("Section removed!");
        Services.audit("removeSection");
    }

    //afiseaza sectii pentru o librarie

    public Library showSections() throws FileWritingException {
        showLibraries();
        System.out.println("\nIndex of the library: ");
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        Library library = libraries.get(lIndex - 1);
        System.out.println(library.getId());
        int j = 1;
        System.out.println("Sections: ");
        for (Section section : sectionRepository.getAll(library.getId())) {
            System.out.println(j + ". " + section);
            j++;
        }
        Services.audit("showSections");
        return library;

    }

    // modifica sectie

    public void updateSection() throws FileWritingException {
        Library library = showSections();
        System.out.println("\nIndex of the section: ");
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        Section section = sectionRepository.getAll(library.getId()).get(lIndex - 1);
        System.out.println("New name: ");
        String sName = scanner.nextLine();
        sectionRepository.updateSectionName(sName, section.getId());
        System.out.println(library.getId());
        System.out.println(section.getId());
        System.out.println("Successful changes!\n");
        Services.audit("newSection");
    }



    //CARTE

    //adauga carte

    public void addBook() throws FileWritingException {
        System.out.println("Choose the index of the library: \n");
        Library library = showSections();
        System.out.println("Index of the section you want to add a book in: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        Section section = sectionRepository.getAll(library.getId()).get(sIndex-1);

        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Author: ");
        String author = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        bookRepository.insertBook(title, author, description, year, section.getId());
        System.out.println("Book added!");
        Services.audit("newBook");
    }

    //sterge carte

    public void removeBook() throws FileWritingException {
        Library library = showSections();
        System.out.println("Index of the section you want to remove the book from: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        Section section = sectionRepository.getAll(library.getId()).get(sIndex-1);
        List<Book> books = bookRepository.getAll(section.getId());
        int i = 1;
        for (Book book : books){
            System.out.println(i + ". " + book);
            i ++;
        }
        System.out.println("Index of the book you want to remove: ");
        int bIndex = scanner.nextInt();
        scanner.nextLine();
        bookRepository.deleteBook(books.get(bIndex - 1).getId());
        System.out.println("Book removed!");
        Services.audit("removeBook");
    }

    //afiseaza carti pentru o sectie dintr-o librarie

    public Section showBooks() throws FileWritingException {
        Library library = showSections();
        System.out.println("Choose the index of a section: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Books: \n");
        ArrayList<Book> books = bookRepository.getAll(sectionRepository.getAll(library.getId()).get(sIndex-1).getId());
        int i = 1;
        for (Book book :books){
            System.out.println(i + ". " + book);
        }
        Services.audit("showBooks");
        return sectionRepository.getAll(library.getId()).get(sIndex-1);

    }

    //editeaza carte

    public void updateBook() throws FileWritingException {
        Section section = showBooks();
        System.out.println("Index of the book you want to update: ");
        int bIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("New title: ");
        String title = scanner.nextLine();

        bookRepository.updateBookTitle(title, bookRepository.getAll(section.getId()).get(bIndex-1).getId());
        System.out.println("Book updated!");
        Services.audit("newBook");
    }


    //ANGAJATI

    //adauga angajat

    public void Hire() throws FileWritingException {
        System.out.println("Name:");
        String eName = scanner.nextLine();
        System.out.println("Hours per day:");
        int hours = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Birthday:");
        String birthday = scanner.next();
        int i = 1;
        for( Library library : libraries){
            System.out.println(i + ". " + library);
            i ++;
        }
        System.out.println("Choose the index of a library:");
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Choose specialization: \n 1. Librarian \n 2. Warder");
        int spc = scanner.nextInt();
        scanner.nextLine();
        Employee emp;
        if (spc == 1){
            System.out.println("Choose the section: ");
            List <Section> sections = sectionRepository.getAll(libraries.get(lIndex-1).getId());
            int j = 1;
            for( Section section : sections){
                System.out.println(j + ". " + section);
                j ++;
            }

            int sIndex = scanner.nextInt();
            scanner.nextLine();
            librarianRepository.insertLibrarian(eName, hours, birthday, libraries.get(lIndex - 1).getId(), sections.get(sIndex - 1).getId());
            System.out.println("Successful employment!");
            Services.audit("HireEmployee");

        }

        else if (spc == 2 ){
            emp = new Warder(0, eName, hours, birthday, libraries.get(lIndex - 1).getId());
            employees.add(emp);
            System.out.println("Successful employment!");
            Services.audit("HireEmployee");
        }

        else{
            System.out.println("Not a valid option!");
        }

    }

    //sterge angajat

    public void Fire() throws FileWritingException {
        System.out.println("Choose an employee: ");
        ArrayList<Librarian> librarians = librarianRepository.getAll();
        int i = 1;
        for(Librarian l : librarians){
            System.out.println(i + ". " + l);
            i ++;
        }
        int eIndex = scanner.nextInt();
        scanner.nextLine();
        librarianRepository.deleteLibrarian(librarians.get(eIndex-1).getId());
        System.out.println("Successful dismissal!");
        Services.audit("FireEmployee");

    }



    //afiseaza bibliotecari

    public void showEmployees() throws FileWritingException {
        int i = 1;
        for (Employee employee: librarianRepository.getAll()){
            System.out.println(i + ". " + employee);
            i ++;
        }
        Services.audit("showEmployees");
    }

    // editeaza bibliotecar

    public void updateEmployee() throws FileWritingException{
        System.out.println("Choose the employee to edit:\n");
        showEmployees();
        int eIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name:\n");
        String name = scanner.nextLine();
        librarianRepository.updateLibrarianName(name, librarianRepository.getAll().get(eIndex-1).getId());
        System.out.println("Employee updated!");
        Services.audit("updateEmployee");
    }

    //IMPRUMUT

    //adauga imprumut

    public void newLending() throws FileWritingException {
        System.out.println("The name of the reader: ");
        String rName = scanner.nextLine();
        Subscription subscription = new Subscription();
        for (Subscription subscription1 : subscriptions) {
            if (subscription1.getReader().getName().equals(rName)) {
                subscription = subscription1;
                break;
            }
        }
        System.out.println("The name of the librarian: ");
        String lName = scanner.nextLine();
        Librarian librarian = new Librarian();
        for (Employee employee : employees) {
            if (employee.getName().equals(lName)) {
                librarian = (Librarian) employee ;
                break;
            }
        }

        System.out.println("The title of the book: ");
        String title = scanner.nextLine();
        Book book = new Book();
        for (Section section : sectionRepository.getAll(subscription.getLibrary().getId())) {
            for (Book book1 : bookRepository.getAll(section.getId())) {
                if (book1.getTitle().equals(title)) {
                    {
                        book = book1;
                        break;
                    }

                }
            }
            break;
        }
        System.out.println("Return Date: ");
        String returnDate = scanner.nextLine();
        Lending lending = new Lending(subscription, librarian, book, returnDate);

        lendings.add(lending);
        int numberBooks = subscription.getNumberBooks();
        numberBooks ++;
        subscription.setNumberBooks(numberBooks);
        List<Book> books = subscription.getBooks();
        books.add(book);
        subscription.setBooks(books);
        System.out.println("Successful lending!");
        Services.audit("newLending");
    }

    //afiseaza imprumuturi

    public void showLendings() throws FileWritingException {
        for(Lending lending: lendings){
            System.out.println(lending);
        }
        Services.audit("showLendings");
    }

    //ABONAMENT

    //creeaza abonament

    public void newSubscription() throws Exception {

        System.out.println("Choose the library: ");
        showLibraries();
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        Library library = libraries.get(lIndex - 1);
        System.out.println("The name of the reader: ");
        String rName = scanner.nextLine();
        System.out.println("The address of the reader: ");
        String address = scanner.nextLine();
        Reader reader = new Reader(rName, address);
        System.out.println("Year: ");
        try {
            int year = scanner.nextInt();
            List<Book> books = new ArrayList<Book>();
            Subscription subscription = new Subscription(library, reader, year, books);
            subscriptions.add(subscription);

            System.out.println("Subscription created! ");
            Services.audit("newSubscription");
        }
        catch (InputMismatchException e){
            System.out.println("The input must be a number");
        }
        scanner.nextLine();

//        private int numberBooks = 0; //creste la fiecare imprumut

    }

    //afiseaza abonamente

    public void showSubscription() throws FileWritingException {
        for (Subscription subscription : subscriptions){
            System.out.println(subscription);
        }
        Services.audit("showSubscription");
    }

    public static void audit(String action) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/com/company/Files/auditIn.txt", true))) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String text = action + ", " + timestamp + '\n';
            buffer.write(text);
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }

}
