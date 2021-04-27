package com.company.FileService;

import com.company.*;
import com.company.Exceptions.FileWritingException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileService{

    // scrierea unei librarii in fisier
    public static void writeLibrary(List<Library> libraries) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/com/company/Files/libraryIn.txt"))) {
            for(Library library : libraries) {
                String text = library.getName() + "," + library.getAddress() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeLibrary method", e);
        }
    }

    // scrierea unei sectii in fisier
    public static void writeSection(List<Section> sections) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/com/company/Files/sectionIn.txt"))) {
            for(Section section : sections) {
                String text = section.getName() + "," + section.getFloor() + ',' + section.getLibrary().getName() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeSection method", e);
        }
    }

    // scrierea cartilor  in fisier
    public static void writeBook(List<Book> books) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/com/company/Files/bookIn.txt"))) {
            for(Book book : books) {
                String text = book.getTitle() + "," + book.getAuthor() + ',' + book.getDescription() + ',' + book.getYear() + ',' +
                        book.getSection().getName() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeBook method", e);
        }
    }

    //scrierea bibliotecarilor in fisier
    public static void writeLibrarian(List<Librarian> librarians) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/com/company/Files/librarianIn.txt"))) {
            for(Librarian librarian : librarians) {
                String text = librarian.getName() + ',' + librarian.getHours() + ',' + librarian.getBirthDate() + ','
                        + librarian.getLibrary().getName() + ',' + librarian.getSection().getName() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeLibrarian method", e);
        }
    }

}
