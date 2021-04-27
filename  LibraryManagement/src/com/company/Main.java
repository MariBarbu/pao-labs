package com.company;


import com.company.FileService.ReadFromFileService;
import com.company.FileService.WriteToFileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Services services = new Services();

    public static void main(String[] args) throws Exception {
        List<Library> libraries = ReadFromFileService.readLibrary();
        List<Section> sections = ReadFromFileService.readSection(libraries);
        List<Book> books = ReadFromFileService.readBook(sections);
        List<Librarian> librarians = ReadFromFileService.readLibrarian(libraries);
        Services.setLibraries(libraries);
        TreeSet<Employee> employees = Services.getEmployees();
        employees.addAll(librarians);
        Services.setEmployees(employees);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Employees\n2. Library\n3. Sections\n4. Books\n5. Subscription\n6. Lending\n0. Exit");
            System.out.println("Please, choose a number:");
            int nr = scanner.nextInt();
            switch (nr) {
                case 0:
                    exit = true;
                    System.out.println("See you next time!");
                    break;
                case 1:
                    System.out.println("1. Hire someone new\n2. Fire someone:(\n3. Show employees");
                    int nr1 = scanner.nextInt();
                    switch (nr1) {
                        case 1:
                            services.Hire();
                            break;
                        case 2:
                            services.Fire();
                            break;
                        case 3:
                            services.showEmployees();
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. New library\n2. Show libraries");
                    int nr2 = scanner.nextInt();
                    switch (nr2) {
                        case 1:
                            services.addLibrary();
                            break;
                        case 2:
                            services.showLibraries();
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. New section\n2. Remove section\n3. Show sections");
                    int nr3 = scanner.nextInt();
                    switch (nr3) {
                        case 1:
                            services.addSection();
                            break;
                        case 2:
                            services.removeSection();
                            break;
                        case 3:
                            services.showSections();
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }

                    break;
                case 4:

                    System.out.println("1. New book\n2. Remove book\n3. Show books");
                    int nr4 = scanner.nextInt();
                    switch (nr4) {
                        case 1:
                            services.addBook();
                            break;
                        case 2:
                            services.removeBook();
                            break;
                        case 3:
                            services.showBooks();
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }

                    break;
                case 5:
                    System.out.println("1. New subscription\n2. Show subscriptions");
                    int nr5 = scanner.nextInt();
                    switch (nr5) {
                        case 1:
                            services.newSubscription();
                            break;
                        case 2:
                            services.showSubscription();
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("1. New lending\n2. Show lendings");
                    int nr6 = scanner.nextInt();
                    switch (nr6) {
                        case 1:
                            services.newLending();
                            break;
                        case 2:
                            services.showLendings();
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }

                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }

        WriteToFileService.writeLibrary(Services.getLibraries());
        List<Section> sectionsToWrite = new ArrayList<>();
        for(Library library : Services.getLibraries() ){
            sectionsToWrite.addAll(library.getSections());
        }
        WriteToFileService.writeSection(sectionsToWrite);
        List<Book> booksToWrite = new ArrayList<>();
        for (Section section : sectionsToWrite){
            for (Book book : section.getBooks()){
                if (!booksToWrite.contains(book)){
                    booksToWrite.add(book);
                }
            }
        }
        WriteToFileService.writeBook(booksToWrite);
        List<Librarian> librariansToWrite = new ArrayList<>();
        for(Employee employee : Services.getEmployees()){
            if (employee instanceof Librarian){
                librariansToWrite.add((Librarian)employee);
            }
        }
        WriteToFileService.writeLibrarian(librariansToWrite);
    }
}
