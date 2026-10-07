package com.hitms.lms;

public class LibraryService {

    /** Returns the copy count after adding newCopies of a title. */
    public static int addBook(int availableCopies, int newCopies) {
        return availableCopies + newCopies;
    }

    /** Returns the copy count after issuing one copy of title. */
     public static int issueBook(int availableCopies, String title) throws BookUnavailableException {
        // Issues one copy of the given title; throws BookUnavailableException
        // if no copies are left in the catalogue.
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be empty.");
        }
        if (availableCopies <= 0) {
            throw new BookUnavailableException("'" + title + "' has no copies available.");
        }
        return availableCopies - 1;
    }

    /** Returns the copy count after one copy is returned. */
    public static int returnBook(int availableCopies) {
        return availableCopies + 1;
    }

    /** Returns true if the given member id exists in the list of members. */
    public static boolean findMemberById(int[] memberIds, int id) {
        for (int memberId : memberIds) {
            if (memberId == id) {
                return true;
            }
        }
        return false;
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