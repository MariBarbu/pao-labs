package com.company;

import java.util.*;

public class Services{

    Scanner scanner = new Scanner(System.in);
    static private TreeSet<Employee> employees = new TreeSet<Employee>(Comparator.comparing(Employee::getHours));
    static private List<Library> libraries = new ArrayList<Library>();
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



    //adauga librarie

    public void addLibrary(){
        System.out.println("Name of the library: ");
        String lName = scanner.nextLine();
        System.out.println("Adress of the library: ");
        String address = scanner.nextLine();
        Library library = new Library(lName, address, new ArrayList<Section>());
        libraries.add(library);
        System.out.println("Library added");


    }

    //afiseaza librarii

    public void showLibraries(){
        int i = 1;
        for(Library library : libraries){
            System.out.println(i + ". " + library);
            i ++;
        }
    }

    //SECTIE



    //adauga sectie intr-o librarie

    public void addSection(){
        showLibraries();
        System.out.println("\nIndex of the library: ");
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        Library library = libraries.get(lIndex - 1);
        List<Section> sections = library.getSections();
        System.out.println("Name of the section: ");
        String sName = scanner.nextLine();
        System.out.println("Floor of the section: ");
        int floor = scanner.nextInt();
        scanner.nextLine();
        List<Book> books = new ArrayList<Book>();
        sections.add(new Section(sName, floor, library, books));
        library.setSections(sections);
        System.out.println("Successful insertion!\n");
    }



    //sterge sectie

    public void removeSection(){
        Library library = showSections();
        System.out.println("Index of the section you want to remove: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        List<Section> sections = library.getSections();
        sections.remove(sections.get(sIndex - 1));
        library.setSections(sections);
        System.out.println("Section removed!");
    }

    //afiseaza sectii pentru o librarie

    public Library showSections(){
        showLibraries();
        System.out.println("\nIndex of the library: ");
        int lIndex = scanner.nextInt();
        scanner.nextLine();
        Library library = libraries.get(lIndex - 1);
        int j = 1;
        System.out.println("Sections: ");
        for (Section section : library.getSections()) {
            System.out.println(j + ". " + section);
            j++;
        }
        return library;

    }

    //CARTE

    //adauga carte

    public void addBook(){
        Library library = showSections();
        System.out.println("Index of the section you want to add a book in: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        Section section = library.getSections().get(sIndex - 1);
        List<Book> books = section.getBooks();
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Author: ");
        String author = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, author, description, year, section);
        books.add(book);
        section.setBooks(books);
        System.out.println("Book added!");
    }

    //sterge carte

    public void removeBook(){
        Library library = showSections();
        System.out.println("Index of the section you want to remove the book from: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        Section section = library.getSections().get(sIndex - 1);
        List<Book> books = section.getBooks();
        int i = 1;
        for (Book book : books){
            System.out.println(i + ". " + book);
            i ++;
        }
        System.out.println("Index of the book you want to remove: ");
        int bIndex = scanner.nextInt();
        scanner.nextLine();
        books.remove(books.get(bIndex- 1));
        section.setBooks(books);
        System.out.println("Book removed!");
    }

    //afiseaza carti pentru o sectie dintr-o librarie

    public void showBooks(){
        Library library = showSections();
        System.out.println("Choose the index of a section: ");
        int sIndex = scanner.nextInt();
        scanner.nextLine();
        for (Book book : library.getSections().get(sIndex - 1).getBooks()){
            System.out.println(book);
        }


    }


    //ANGAJATI

    //adauga angajat

    public void Hire(){
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
            List <Section> sections = libraries.get(lIndex - 1).getSections();
            int j = 1;
            for( Section section : sections){
                System.out.println(j + ". " + section);
                j ++;
            }

            int sIndex = scanner.nextInt();
            scanner.nextLine();
            emp = new Librarian(eName, hours, birthday, libraries.get(lIndex - 1), sections.get(sIndex - 1));
            employees.add(emp);
            System.out.println("Successful employment!");

        }

        else if (spc == 2 ){
            emp = new Warder(eName, hours, birthday, libraries.get(lIndex - 1));
            employees.add(emp);
            System.out.println("Successful employment!");
        }

        else{
            System.out.println("Not a valid option!");
        }

    }

    //sterge angajat

    public void Fire(){
        System.out.println("Employee name: ");
        String eName = scanner.nextLine();
        for (Employee emp : employees){
            if (emp.getName().equals(eName)){
                employees.remove(emp);
                System.out.println("Successful dismissal!");
                break;
            }
        else{
                System.out.println("This employee doesn't exist!");
            }

        }
    }


    //afiseaza angajati

    public void showEmployees(){
        int i = 1;
        for (Employee employee: employees){
            System.out.println(i + ". " + employee);
            i ++;
        }
    }

    //IMPRUMUT

    //adauga imprumut

    public void newLending() {
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
        for (Section section : subscription.getLibrary().getSections()) {
            for (Book book1 : section.getBooks()) {
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
    }

    //afiseaza imprumuturi

    public void showLendings(){
        for(Lending lending: lendings){
            System.out.println(lending);
        }
    }

    //ABONAMENT

    //creeaza abonament

    public void newSubscription(){

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
        int year = scanner.nextInt();
        scanner.nextLine();

//        private int numberBooks = 0; //creste la fiecare imprumut
        List<Book> books = new ArrayList<Book>();
        Subscription subscription = new Subscription(library, reader, year, books);
        subscriptions.add(subscription);

        System.out.println("Subscription created! ");
    }

    //afiseaza abonamente

    public void showSubscription(){
        for (Subscription subscription : subscriptions){
            System.out.println(subscription);
        }
    }
}
