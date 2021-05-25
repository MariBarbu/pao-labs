//package com.company.FileService;
//
//import com.company.*;
//import com.company.Exceptions.FileReadingException;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReadFromFileService {
//
//
//    // de implementat cu id in loc de nume pentru formarea legaturilor
//
//
//    // metoda pentru citirea librariilor din fisier
//    // fisierul e de forma: nume,adresa
//    public static List<Library> readLibrary() throws FileReadingException {
//        List<Library> libraries = new ArrayList<>();
//        try (BufferedReader bufferLibrary = new BufferedReader(new FileReader("src/com/company/Files/libraryIn.txt"))) {
//            String lineLibrary = bufferLibrary.readLine();
//            while (lineLibrary != null) {
//                Library library = new Library();
//                String[] infoLibrary = lineLibrary.split(",");
//                library.setName(infoLibrary[0]);
//                library.setAddress(infoLibrary[1]);
//
//                libraries.add(library);
//                lineLibrary = bufferLibrary.readLine();
//            }
//
//            return libraries;
//        } catch (
//                IOException e) {
//            throw new FileReadingException("Something went wrong in readLibrary method", e);
//
//        }
//
//    }
//
//    //Cand citesc sectiile atribui fiecarei librarii sectiiunile corespunzatoare
//    // Fisierul cu sectii contine: nume,etaj,nume_librarie
//    // metoda pentru citirea sectiilor din fisier
//    public static List<Section> readSection(List<Library> libraries) throws FileReadingException {
//        List<Section> sections = new ArrayList<>();
//        try (BufferedReader bufferSection = new BufferedReader(new FileReader("src/com/company/Files/sectionIn.txt"))) {
//            String lineSection = bufferSection.readLine();
//            while (lineSection != null) {
//                Section section = new Section();
//                String[] infoSection = lineSection.split(",");
//                section.setName(infoSection[0]);
//                section.setFloor(Integer.parseInt(infoSection[1]));
//
//                for (Library library : libraries) {
//                    if (library.getName().equals(infoSection[2])) {
//                        section.setLibrary_id(library.getId());
//                        List<Section> librarySections = sections;
//                        librarySections.add(section);
//                        library.setSections(librarySections);
//                    }
//                }
//                sections.add(section);
//                lineSection = bufferSection.readLine();
//            }
//            return sections;
//        } catch (IOException e) {
//            throw new FileReadingException("Something went wrong in readSection method", e);
//
//        }
//    }
//
//    // metoda pentru citirea cartilor dintr-un fisier
//    public static List<Book> readBook(List<Section> sections) throws FileReadingException {
//        List<Book> books = new ArrayList<Book>();
//        try (BufferedReader bufferBook = new BufferedReader(new FileReader("src/com/company/Files/bookIn.txt"))) {
//            String lineBook = bufferBook.readLine();
//            while (lineBook != null) {
//                Book book = new Book();
//                String[] infoBooks = lineBook.split(",");
//                book.setTitle(infoBooks[0]);
//                book.setAuthor(infoBooks[1]);
//                book.setDescription(infoBooks[2]);
//                book.setYear(Integer.parseInt(infoBooks[3]));
//                for(Section section : sections){
//                    if (section.getName().equals(infoBooks[4])){
//                        System.out.println(section.getName() + "  " + infoBooks[4]);
//                        book.setSection_id(section.getId());
//                        List<Book> sectionBooks = section.getBooks();
//                        if (!sectionBooks.contains(book)) {
//                            sectionBooks.add(book);
//                            section.setBooks(books);
//                        }
//                        break;
//                    }
//                }
//                books.add(book);
//
//                lineBook = bufferBook.readLine();
//            }
//            return books;
//        } catch (IOException e) {
//            throw new FileReadingException("Something went wrong in readBook method", e);
//
//        }
//
//
//    }
//
//    public static List<Librarian> readLibrarian(List<Library> libraries) throws FileReadingException {
//        List<Librarian> librarians = new ArrayList<Librarian>();
//        try (BufferedReader bufferLibrarian = new BufferedReader(new FileReader("src/com/company/Files/librarianIn.txt"))) {
//            String lineLibrarian = bufferLibrarian.readLine();
//            while (lineLibrarian != null) {
//                Librarian librarian = new Librarian();
//                String[] infoLibrarian = lineLibrarian.split(",");
//                librarian.setName(infoLibrarian[0]);
//                librarian.setHours(Integer.parseInt(infoLibrarian[1]));
//                librarian.setBirthDate(infoLibrarian[2]);
//
//                for (Library library : libraries){
//                    if (library.getName().equals(infoLibrarian[3])){
//                        librarian.setLibrary_id(library.getId());
//                        List<Section> sections = library.getSections();
//                        for (Section section : sections){
//                            if (section.getName().equals(infoLibrarian[4])){
//                                librarian.setSection_id(section.getId());
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                }
//
//                librarians.add(librarian);
//                lineLibrarian = bufferLibrarian.readLine();
//            }
//            return librarians;
//        } catch (IOException e) {
//            throw new FileReadingException("Something went wrong in readLibrarian method", e);
//
//        }
//    }
//
//
//
//}
