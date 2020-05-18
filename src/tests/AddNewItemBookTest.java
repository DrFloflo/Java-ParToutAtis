package tests;

import exceptions.ItemBookAlreadyExistsException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;


import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.NotTestReportException;

/**
 * Tests for the SocialNetwork.<i>addBook()</i> method.
 *
 * @author B. Prou, E. Cousin, GO
 * @version V2.0 - April 2018
 */

public class AddNewItemBookTest {

    /**
     * Check that this new Book (login, password, title, kind, director, scenarist, nbPages) can be (and <i>is</i>)
     * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
     * : the new Book was added.</br> If not OK, an error message is displayed
     * and 1 is returned ; the new Book was not correctly added.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - Member's login
     * @param password
     *            - Member's password
     * @param title
     *            - Titre du livre
     * @param kind
     *            - Genre du livre
     * @param author
     *            - Auteur du livre
     * @param nbPages
     *            - Nombre de pages
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemBookBadEntryTest(ISocialNetwork sn, String login, String password, String title, String kind, String author, int nbPages, String testId, String errorMessage) {

        int nbBooks = sn.nbBooks(); // Number of Books when starting to
        // run this method
        try {
            sn.addItemBook(login, password, title, kind, author, nbPages); // Try to add this Book
            // Reaching this point means that no exception was thrown by
            // addBook()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) { // BadEntry exception was thrown by
            // addBook() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            if (sn.nbBooks() != nbBooks) { // The number of Books has
                // changed : this is an error
                // case.
                System.out.println("Err " + testId + " : BadEntry was thrown but the number of Books was changed"); // Display
                // a
                // specific
                // error
                // message
                return 1; // return "error" value
            } else
                // The number of Books hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing
            // to display
        } catch (Exception e) { // An exception was thrown by addBook(), but
            // it was not the expected exception BadEntry
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }

    /**
     * Check that this new Book (login, password, title, kind, director, scenarist, nbPages) can be (and <i>is</i>)
     * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
     * : the new Book was added.</br> If not OK, an error message is displayed
     * and 1 is returned ; the new Book was not correctly added.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - Member's login
     * @param password
     *            - Member's password
     * @param title
     *            - Titre du livre
     * @param kind
     *            - Genre du livre
     * @param author
     *            - Auteur du livre
     * @param nbPages
     *            - Nombre de pages
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemBookAlreadyExistsTest(ISocialNetwork sn,
                                                       String login, String password, String title,
                                                       String kind, String author, int nbPages, String testId, String errorMessage) {
        int nbBooks = sn.nbBooks(); // Number of Books when starting to
        // process this method
        try {
            sn.addItemBook(login, password, title, kind, author, nbPages); // Try to add this Book
            // Reaching this point means that no exception was thrown by
            // addBook()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (ItemBookAlreadyExistsException e) {// AlreadyExists exception was
            // thrown by addBook() :
            // this is a good start!
            // Let's now check if 'sn'
            // was not impacted
            if (sn.nbBooks() != nbBooks) {
                System.out
                        .println("Err "
                                + testId
                                + " : BookAlreadyExists was thrown, but the number of Books was changed"); // Display
                // a
                // specific
                // error
                // message
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
            // display
        } catch (Exception e) { // An exception was thrown by addBook(), but
            // it was not the expected exception
            // AlreadyExists
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }

    /**
     * Check that this new Book (login, password, title, kind, director, scenarist, nbPages) can be (and <i>is</i>)
     * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
     * : the new Book was added.</br> If not OK, an error message is displayed
     * and 1 is returned ; the new Book was not correctly added.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - Member's login
     * @param password
     *            - Member's password
     * @param title
     *            - Titre du livre
     * @param kind
     *            - Genre du livre
     * @param author
     *            - Auteur du livre
     * @param nbPages
     *            - Nombre de pages
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemBookOKTest(ISocialNetwork sn, String login, String password,
                                            String title, String kind, String author, int nbPages, String testId) {
        int nbBooks = sn.nbBooks(); // Number of Books when starting to
        // process this method
        try {
            sn.addItemBook(login, password, title, kind, author, nbPages); // Try to add this Book
            // No exception was thrown. That's a good start !
            if (sn.nbBooks() != nbBooks + 1) { // But the number of Books
                // hasn't changed
                // accordingly
                System.out.println("Err " + testId + " : the number of Books (" + nbBooks + ") was not incremented"); // Error message displayed
                return 1; // return error code
            } else
                return 0; // return success code : everything is OK, nothing to
            // display
        } catch (Exception e) {// An exception was thrown by addBook() : this
            // is an error case
            System.out
                    .println("Err " + testId + " : unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
    }

    /**
     * <i>addBook()</i> main test :
     * <ul>
     * <li>check if Books can be added</li>
     * <li>check if incorrect parameters cause addBook() to throw BadEntry
     * exception</li>
     * <li>check if adding already registered Books cause addBook() to throw
     * AlreadyExists exception</li>
     * </ul>
     *
     * @return a summary of the performed tests
     */
    public static TestReport test(){

        ISocialNetwork sn = new SocialNetwork();

        int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
        // here)
        int nbFilms = sn.nbFilms();
        int nbMembers = sn.nbMembers(); // number of members in 'sn' (should be 0
        // here)

        int nbTests = 0; // total number of performed tests
        int nbErrors = 0; // total number of failed tests

        System.out.println("Testing addBook()");

        // <=> test n°1

        // check if incorrect parameters cause addBook() to throw BadEntry
        // exception

        nbTests++;
        nbErrors += addNewItemBookBadEntryTest(sn, null, "paul",
                "aaaa", "aaa", "aaaa", 100,
                "1.1","addBook doit rejeter les logins null");
        nbErrors += addNewItemBookBadEntryTest(sn, "Paul", null,
                "aaaa", "aaa", "aaaa",
                100000000, "1.2","addBook doit rejeter les passwords null");
        nbErrors += addNewItemBookBadEntryTest(sn, "Paul", "paul",
                null, "aaa", "aaaa",
                100000000, "1.3","addBook doit rejeter les variables title null");
        nbErrors += addNewItemBookBadEntryTest(sn, "Paul", "paul",
                "aaaa", null, "aaaaa",
                100000000, "1.4","addBook doit rejeter les variable kind null");
        nbErrors += addNewItemBookBadEntryTest(sn, "Paul", "paul",
                "aaaa", "aaa", null,
                100000000, "1.5","addBook doit rejeter les variables author null");
        nbErrors += addNewItemBookBadEntryTest(sn, "Paul", "paul",
                "aaaa", "aaa", "aaaa",
                -1000, "1.7","addBook doit rejeter les variables nbPages négatives");

        // <=> test n°2

        // populate 'sn' with 3 Books

        nbTests++;
        nbErrors += addNewItemBookOKTest(sn, "Paul", "paul",
                "L'art de la guerre", "Traité, Non-fiction", "Sun Tzu",
                338,"2.1a");
        nbTests++;
        nbErrors += addNewItemBookOKTest(sn, "Paul", "paul",
                "Chants de la Terre lointaine", "Roman/Science-fiction", "Arthur C. Clark",
                311,"2.2a");
        nbTests++;
        nbErrors += addNewItemBookOKTest(sn, "Paul", "paul",
                "Je voulais juste vivre", "Biographie, Autobiographie", "Yeonmi Park, Maryanne Vollers",
                301,"2.3a");

        // try to add already registered Books
        nbTests++;
        nbErrors += addNewItemBookAlreadyExistsTest(sn, "Paul", "paul",
                "Je voulais juste vivre", "Biographie, Autobiographie", "Yeonmi Park, Maryanne Vollers",
                301,"2.1", "Le livre est déjà enregistré");
        nbTests++;
        nbErrors += addNewItemBookAlreadyExistsTest(sn, "Paul", "paul",
                "Chants de la Terre lointaine", "Roman/Science-fiction", "Arthur C. Clark",
                311,"2.2", "Le livre est déjà enregistré");
        nbTests++;
        nbErrors += addNewItemBookAlreadyExistsTest(sn, "Paul", "paul",
                " L'Art De La Guerre", "Traité, Non-fiction", "Sun Tzu",
                338,"2.3", "Le Book est déjà enregistré avec des majuscules différentes");
        nbTests++;
        nbErrors += addNewItemBookAlreadyExistsTest(sn, "Paul", "paul",
                " L'Art De La Guerre ", "Traité, Non-fiction", "Sun Tzu",
                338,"2.4", "Le Book est déjà enregistré mais sans espaces autour");
        nbTests++;
        nbErrors += addNewItemBookAlreadyExistsTest(sn, "Paul", "paul",
                "L'art"+"de"+"la"+"guerre", "Traité, Non-fiction", "Sun Tzu",
                338,"2.5", "A String concatenation building an already registered Book was accepted as Book for a new item");
        // check that 'sn' was not modified
        if (nbMembers != sn.nbMembers()) {
            System.out
                    .println("Error : the number of members was unexepectedly changed by addBook()");
            nbErrors++;
        }
        nbTests++;
        if (nbFilms != sn.nbFilms()) {
            System.out
                    .println("Error : the number of films was unexepectedly changed by addBook()");
            nbErrors++;
        }

        // Display final state of 'sn'
        System.out.println("Final state of the social network : " + sn);

        // Print a summary of the tests and return test results
        try{
            TestReport tr = new TestReport(nbTests, nbErrors);
            System.out.println("AddBookTest : " + tr);
            return tr;
        }
        catch (NotTestReportException e){ //This shouldn't happen
            System.out.println("Unexpected error in AddBookTest test code - Can't return valuable test results");
            return null;
        }
    }



    /**
     * Launches test()
     * @param args not used
     */
    public static void main(String[] args) {
        test();
    }
}
