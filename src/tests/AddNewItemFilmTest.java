package tests;

import exceptions.ItemFilmAlreadyExistsException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;


import exceptions.BadEntryException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotTestReportException;

/**
 * Tests for the SocialNetwork.<i>addMember()</i> method.
 *
 * @author B. Prou, E. Cousin, GO
 * @version V2.0 - April 2018
 */

public class AddNewItemFilmTest {

    /**
     * Check that trying to add this new member (login, pwd, profile) raises a
     * BadEntry exception and does not change content of the
     * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
     * displays an error message and returns 1.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - new member's login
     * @param password
     *            - new member's password
     * @param profile
     *            - new member's profile
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @param errorMessage
     *            - the error message that will be displayed if no exception is
     *            thrown when adding this member
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemFilmBadEntryTest(ISocialNetwork sn, String login, String password,
                                                  String title, String kind, String director,
                                                  String scenarist, int duration, String testId,
                                                  String errorMessage) {

        int nbFilms = sn.nbFilms(); // Number of members when starting to
        // run this method
        try {
            sn.addItemFilm(login, password, title, kind, director, scenarist, duration); // Try to add this member
            // Reaching this point means that no exception was thrown by
            // addMember()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (BadEntryException e) { // BadEntry exception was thrown by
            // addMember() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            if (sn.nbMembers() != nbFilms) { // The number of members has
                // changed : this is an error
                // case.
                System.out
                        .println("Err "
                                + testId
                                + " : BadEntry was thrown but the number of members was changed"); // Display
                // a
                // specific
                // error
                // message
                return 1; // return "error" value
            } else
                // The number of members hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing
            // to display
        } catch (Exception e) { // An exception was thrown by addMember(), but
            // it was not the expected exception BadEntry
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }

    /**
     * Check that trying to add this new member (login, pwd, profile) raises an
     * AlreadyExists exception and does not change content of the
     * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
     * displays an error message and returns 1.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - new member's login
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @param errorMessage
     *            - the error message that will be displayed if no exception is
     *            thrown when adding this member
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemFilmAlreadyExistsTest(ISocialNetwork sn,
                                                       String login, String password, String title,
                                                       String kind, String director, String scenarist,
                                                       int duration, String testId, String errorMessage) {
        int nbFilms = sn.nbFilms(); // Number of members when starting to
        // process this method
        try {
            sn.addItemFilm(login, password, title, kind, director, scenarist, duration); // Try to add this member
            // Reaching this point means that no exception was thrown by
            // addMember()
            System.out.println("Err " + testId + " : " + errorMessage); // display
            // the
            // error
            // message
            return 1; // and return the "error" value
        } catch (ItemFilmAlreadyExistsException e) {// AlreadyExists exception was
            // thrown by addMember() :
            // this is a good start!
            // Let's now check if 'sn'
            // was not impacted
            if (sn.nbFilms() != nbFilms) {
                System.out
                        .println("Err "
                                + testId
                                + " : MemberAlreadyExists was thrown, but the number of members was changed"); // Display
                // a
                // specific
                // error
                // message
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
            // display
        } catch (Exception e) { // An exception was thrown by addMember(), but
            // it was not the expected exception
            // AlreadyExists
            System.out.println("Err " + testId + " : unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }

    /**
     * Check that this new member (login, pwd, profile) can be (and <i>is</i>)
     * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
     * : the new member was added.</br> If not OK, an error message is displayed
     * and 1 is returned ; the new member was not correctly added.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - new member's login
     * @param pwd
     *            - new member's password
     * @param profile
     *            - new member's profile
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemFilmOKTest(ISocialNetwork sn, String login, String password,
                                            String title, String kind, String director,
                                            String scenarist, int duration, String testId) {
        int nbFilms = sn.nbFilms(); // Number of members when starting to
        // process this method
        try {
            sn.addItemFilm(login, password, title, kind, director, scenarist, duration); // Try to add this member
            // No exception was thrown. That's a good start !
            if (sn.nbFilms() != nbFilms + 1) { // But the number of members
                // hasn't changed
                // accordingly
                System.out.println("Err " + testId
                        + " : the number of members (" + nbFilms
                        + ") was not incremented"); // Error message displayed
                return 1; // return error code
            } else
                return 0; // return success code : everything is OK, nothing to
            // display
        } catch (Exception e) {// An exception was thrown by addMember() : this
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
     * <i>addMember()</i> main test :
     * <ul>
     * <li>check if members can be added</li>
     * <li>check if incorrect parameters cause addMember() to throw BadEntry
     * exception</li>
     * <li>check if adding already registered members cause addMember() to throw
     * AlreadyExists exception</li>
     * </ul>
     *
     * @return a summary of the performed tests
     */
    public static TestReport test(){

        ISocialNetwork sn = new SocialNetwork();

        int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
        // here)
        int nbFilms = sn.nbFilms(); // number of films in 'sn' (should be 0
        // here)

        int nbTests = 0; // total number of performed tests
        int nbErrors = 0; // total number of failed tests

        System.out.println("Testing addFilm()");

        // <=> test n°1

        // check if incorrect parameters cause addMember() to throw BadEntry
        // exception

        nbTests++;
        nbErrors += addNewItemFilmBadEntryTest(null, null, "aaaa",
                "aaaa", "aaa", "aaaa", "aaaaa",
                100000000, "1.1","addFilm doit rejeter les logins null");
        nbErrors += addNewItemFilmBadEntryTest(null, "aaaa", null,
                "aaaa", "aaa", "aaaa", "aaaaa",
                100000000, "1.2","addFilm doit rejeter les passwords null");
        nbErrors += addNewItemFilmBadEntryTest(null, "aaaa", "aaaa",
                null, "aaa", "aaaa", "aaaaa",
                100000000, "1.3","addFilm doit rejeter les variables films null");
        nbErrors += addNewItemFilmBadEntryTest(null, "aaaa", "aaaa",
                "aaaa", null, "aaaa", "aaaaa",
                100000000, "1.4","addFilm doit rejeter les variable kind null");
        nbErrors += addNewItemFilmBadEntryTest(null, "aaaa", "aaaa",
                "aaaa", "aaa", null, "aaaaa",
                100000000, "1.5","addFilm doit rejeter les variables directors null");
        nbErrors += addNewItemFilmBadEntryTest(null, "aaaa", "aaaa",
                "aaaa", "aaa", "aaaa", null,
                100000000, "1.6","addFilm doit rejeter les variables scenarist null");
        nbErrors += addNewItemFilmBadEntryTest(null, "aaaa", "aaaa",
                "aaaa", "aaa", "aaaa", "aaaaa",
                -1000, "1.7","addFilm doit rejeter les variables durations négatives");

        // <=> test n°2

        // populate 'sn' with 3 members

        nbTests++;
        nbErrors += addNewItemFilmOKTest(sn, "Paul", "paul", "lecteur impulsif",
                "2.1a");
        nbTests++;
        nbErrors += addNewItemFilmOKTest(sn, "Antoine", "antoine",
                "grand amoureux de la littérature", "2.1b");
        nbTests++;
        nbErrors += addNewItemFilmOKTest(sn, "Alice", "alice",
                "passionnée de bande dessinée", "2.1c");

        // try to add already registered members

        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(sn, new String("Paul"),
                "abcdefghij", "", "2.2",
                "The login of the first member was accepted as login for a new member");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(sn, new String("Alice"),
                "abcdefghij", "", "2.3",
                "The login of the last member was accepted as login for a new member");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(
                sn,
                new String("anToine"),
                "abcdefghij",
                "",
                "2.4",
                "An already registered login, but with different case, was accepted as login for a new member");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(
                sn,
                new String(" Antoine "),
                "abcdefghij",
                "",
                "2.5",
                "An already registered login, surrounded by leading/trailing blanks, was accepted as login for a new member");
        nbTests++;
        nbErrors += addNewItemFilmAlreadyExistsTest(
                sn,
                "An" + "toi" + "ne",
                "abcdefghij",
                "",
                "2.6",
                "A String concatenation building an already registered login was accepted as login for a new member");

        nbTests++;
        // check that 'sn' was not modified
        if (nbFilms != sn.nbFilms()) {
            System.out
                    .println("Error : the number of films was unexepectedly changed by addMember()");
            nbErrors++;
        }
        nbTests++;
        if (nbBooks != sn.nbBooks()) {
            System.out
                    .println("Error : the number of books was unexepectedly changed by addMember()");
            nbErrors++;
        }

        // Display final state of 'sn'
        System.out.println("Final state of the social network : " + sn);

        // Print a summary of the tests and return test results
        try{
            TestReport tr = new TestReport(nbTests, nbErrors);
            System.out.println("AddMemberTest : " + tr);
            return tr;
        }
        catch (NotTestReportException e){ //This shouldn't happen
            System.out.println("Unexpected error in AddMemberTest test code - Can't return valuable test results");
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