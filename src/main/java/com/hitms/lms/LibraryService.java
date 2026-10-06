package com.hitms.lms;

public class LibraryService {

    public static int addBook(int availableCopies, int newCopies) {
        return availableCopies + newCopies;
    }

    public static int issueBook(int availableCopies, String title) throws BookUnavailableException {
        // Issues one copy of the given title from the catalogue (main branch)
        if (availableCopies <= 0) {
            throw new BookUnavailableException("'" + title + "' has no copies available.");
        }
        return availableCopies - 1;
    }

    public static int returnBook(int availableCopies) {
        return availableCopies + 1;
    }

    public static void main(String[] args) throws BookUnavailableException {
        int copies = 2;
        copies = addBook(copies, 3);
        System.out.println("After adding 3 copies: " + copies);
        copies = issueBook(copies, "Clean Code");
        System.out.println("After issuing one copy: " + copies);
        copies = returnBook(copies);
        System.out.println("After returning one copy: " + copies);
    }
}