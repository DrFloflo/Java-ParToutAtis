package tests;

import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>addBook()</i> method.
 *
 * @author B. Prou, E. Cousin, GO
 * @version V2.0 - April 2018
 */

public class reviewItemBookTest {

    /**
     * Add in the <i>SocialNetwork</i> a new review for a book.
     * If this member has already given a review for this
     * same book before, the new review is refused.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed book's title
     * @param mark
     *            the mark given by the member for this book
     * @param comment
     *            the comment given by the member for this book
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @param errorMessage
     *            - the error message that will be displayed if no exception is
     *            thrown when adding this member
     * @throws BadEntryException
     *             <ul>
     *             <li>if login is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if password is not instantiated or contains less than
     *             four characters (not taking into account leading or trailing
     *             blanks)</li>
     *             <li>if title is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if mark is not greater or equals to 0.0 and lesser or
     *             equals to 5.0.</li>
     *             <li>if comment is not instantiated</li>
     *             </ul>
     * <br>
     * @throws NotMemberException
     *             if login does not match with the login of a registered member
     *             in <i>SocialNetwork</i> or if password does not correspond to
     *             his registered password.
     * @throws NotItemException
     *             if title is not registered as a book's title in the
     *             <i>SocialNetwork</i>
     *
     * @return 0 if the test is OK, 1 if not
     */
    private static int reviewItemBookBadEntryTest(ISocialNetwork sn, String login, String password,
                                                  String title, float mark, String comment, String testId,
                                                  String errorMessage) {

       // int nbReviews = sn.nbReviews(); // Number of books when starting to
        // run this method
        try {
            sn.reviewItemBook(login, password, title, mark, comment); // Try to add this book
            // Reaching this point means that no exception was thrown by
            // addReviews()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) { // BadEntry exception was thrown by
            // addBook() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            /*if (sn.nbBooks() != nbBooks) { // The number of books has
                System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of books was changed"); // Display
                return 1; // return "error" value
            } else
                // The number of reviews hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing*/
            // to display
        }catch (NotMemberException e) { // BadEntry exception was thrown by
            // addBook() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            /*if (sn.nbBooks() != nbBooks) { // The number of books has
                System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of books was changed"); // Display
                return 1; // return "error" value
            } else
                // The number of reviews hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing*/
            // to display
        }catch (NotItemException e) { // BadEntry exception was thrown by
            // addBook() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            /*if (sn.nbBooks() != nbBooks) { // The number of books has
                System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of books was changed"); // Display
                return 1; // return "error" value
            } else
                // The number of reviews hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing*/
            // to display
        } catch (Exception e) { // An exception was thrown by addReview(), but
            // it was not the expected exception BadEntry
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
        return 0;
    }

    /**
     * Add in the <i>SocialNetwork</i> a new review for a book.
     * If this member has already given a review for this
     * same book before, the new review is refused.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed book's title
     * @param mark
     *            the mark given by the member for this book
     * @param comment
     *            the comment given by the member for this book
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @param errorMessage
     *            - the error message that will be displayed if no exception is
     *            thrown when adding this member
     *
     * @throws BadEntryException
     *             <ul>
     *             <li>if login is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if password is not instantiated or contains less than
     *             four characters (not taking into account leading or trailing
     *             blanks)</li>
     *             <li>if title is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if mark is not greater or equals to 0.0 and lesser or
     *             equals to 5.0.</li>
     *             <li>if comment is not instantiated</li>
     *             </ul>
     * <br>
     * @throws NotMemberException
     *             if login does not match with the login of a registered member
     *             in <i>SocialNetwork</i> or if password does not correspond to
     *             his registered password.
     * @throws NotItemException
     *             if title is not registered as a book's title in the
     *             <i>SocialNetwork</i>
     *
     * @return mean of the marks for this book
     */
    private static int reviewItemBookAlreadyExistsTest(ISocialNetwork sn, String login, String password,
                                                       String title, float mark, String comment, String testId,
                                                       String errorMessage) {
        int nbBooks = sn.nbBooks(); // Number of books when starting to
        // process this method
        try {
            sn.reviewItemBook(login, password, title, mark, comment); // Try to add this book
            // Reaching this point means that no exception was thrown by
            // addBook()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) {// AlreadyExists exception was
            if (sn.nbBooks() != nbBooks) {
                System.out
                        .println("Err "+ testId+ " : BookAlreadyExists was thrown, but the number of Books was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
            // display
        }  catch (NotItemException e) {// AlreadyExists exception was
            if (sn.nbBooks() != nbBooks) {
                System.out
                        .println("Err "+ testId+ " : BookAlreadyExists was thrown, but the number of Books was changed"); // Display
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
     * Add in the <i>SocialNetwork</i> a new review for a book.
     * If this member has already given a review for this
     * same book before, the new review is refused.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed book's title
     * @param mark
     *            the mark given by the member for this book
     * @param comment
     *            the comment given by the member for this book
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     *
     * @throws BadEntryException
     *             <ul>
     *             <li>if login is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if password is not instantiated or contains less than
     *             four characters (not taking into account leading or trailing
     *             blanks)</li>
     *             <li>if title is not instantiated or contains less than one
     *             non-space character</li>
     *             <li>if mark is not greater or equals to 0.0 and lesser or
     *             equals to 5.0.</li>
     *             <li>if comment is not instantiated</li>
     *             </ul>
     * <br>
     * @throws NotMemberException
     *             if login does not match with the login of a registered member
     *             in <i>SocialNetwork</i> or if password does not correspond to
     *             his registered password.
     * @throws NotItemException
     *             if title is not registered as a book's title in the
     *             <i>SocialNetwork</i>
     *
     * @return mean of the marks for this book
     */
    private static int reviewItemBookOKTest(ISocialNetwork sn, String login, String password,
                                            String title, float mark, String comment, String testId) {
       // int nbBooks = sn.nbBooks(); // Number of books when starting to
        // process this method
        try {
            sn.reviewItemBook(login, password, title, mark, comment); // Try to add this book
            System.out.println("Err " + testId + " : unexpected exception "); // Error
        } catch (NotItemException e) { // BadEntry exception was thrown by
            // addBook() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            /*if (sn.nbBooks() != nbBooks) { // The number of books has
                System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of books was changed"); // Display
                return 1; // return "error" value
            } else
                // The number of reviews hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing*/
            // to display
        }catch (Exception e) {// An exception was thrown by addBook() : this
            // is an error case
            System.out.println("Err " + testId + " : unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
        return 0;
    }

    /**
     * <i>addReviewItemBook()</i> main test :
     * <ul>
     * <li>check if reviews can be added</li>
     * <li>check if incorrect parameters cause addReviewItemBook() to throw BadEntry
     * exception</li>
     * <li>check if adding already registered reviews cause addReviewItemBook to throw
     * AlreadyExists exception</li>
     * </ul>
     *
     * @return a summary of the performed tests
     */
    public static TestReport test(){

        ISocialNetwork sn = new SocialNetwork();

        //int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
        // here)
        //int nbMembers = sn.nbMembers(); // number of members in 'sn' (should be 0
        // here)

        int nbTests = 0; // total number of performed tests
        int nbErrors = 0; // total number of failed tests

        System.out.println("Testing addReviewBook()");

        // <=> test n°1

        // check if incorrect parameters cause addBook() to throw BadEntry
        // exception

        nbTests++;
        nbErrors += reviewItemBookBadEntryTest(sn, null, "aaaa",
                "aaaa", 2.5f, "aaaa", "1.1","addBook doit rejeter les logins null");
        nbTests++;
        nbErrors += reviewItemBookBadEntryTest(sn, "aaaa", null,
                "aaaa", 2.5f, "aaaa", "1.2","addBook doit rejeter les passwords null");
        nbTests++;
        nbErrors += reviewItemBookBadEntryTest(sn, "aaaa", "aaaa",
                null, 2.5f, "aaaa", "1.3","addBook doit rejeter les variables title null");
        nbTests++;
        nbErrors += reviewItemBookBadEntryTest(sn, "aaaa", "aaa",
                "aaaa", -10, "aaaa", "1.4","addBook doit rejeter les variable mark negative");
        nbTests++;
        nbErrors += reviewItemBookBadEntryTest(sn, "aaaa", "aaa",
                "aaaa", 5, null, "1.5","addBook doit rejeter les variables comment null");
        // <=> test n°2

        // populate 'sn' with 3 books

        nbTests++;
        nbErrors += reviewItemBookOKTest(sn, "Paul", "aaaa",
                "Bof", 2.5f, "Nul", "2.1a");
        nbTests++;
        nbErrors += reviewItemBookOKTest(sn, "Taylor", "aaaa",
                "Pas mal", 5f, "Jean crois pas mes yeux", "2.2a");
        nbTests++;
        nbErrors += reviewItemBookOKTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, "Incroyable", "2.3a");

        // try to add already registered books
        nbTests++;
        nbErrors += reviewItemBookAlreadyExistsTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, "Incroyable", "2.1","L'utilisateur à déjà posté cette review pour ce book");
        nbTests++;
        nbErrors += reviewItemBookAlreadyExistsTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, "InCroYable", "2.2","L'utilisateur à déjà posté cette review pour ce book avec des majuscules différentes");
        nbTests++;
        nbErrors += reviewItemBookAlreadyExistsTest(sn, "Smith", "aaaa",
                "Incroyable", 7.5f, " Incroyable ", "2.3","L'utilisateur à déjà posté cette review pour ce book avec des espaces en moins");
        // check that 'sn' was not modified
        /*if (nbMembers != sn.nbMembers()) {
            System.out
                    .println("Error : the number of members was unexepectedly changed by addBook()");
            nbErrors++;
        }
        nbTests++;
        if (nbBooks != sn.nbBooks()) {
            System.out
                    .println("Error : the number of books was unexepectedly changed by addBook()");
            nbErrors++;
        }*/

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
