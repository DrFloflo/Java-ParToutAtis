package tests;

import exceptions.*;
import opinion.ISocialNetwork;
import opinion.Member;
import opinion.Review;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>addMember()</i> method.
 *
 * @author B. Prou, E. Cousin, GO
 * @version V2.0 - April 2018
 */

public class TestKarmaMember {

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
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @param errorMessage
     *            - the error message that will be displayed if no exception is
     *            thrown when adding this member
     * @return 0 if the test is OK, 1 if not
     */
    private static int KarmaBadEntryTest(ISocialNetwork sn, String login, String testId, String errorMessage) {

        int nbMembers = sn.nbMembers(); // Number of members when starting to
        // run this method
        try {
            Member membre;
            membre = sn.getMember(login);
            System.out.println(membre.getKarma());
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
            if (sn.nbMembers() != nbMembers) { // The number of members has
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
            System.out.println("Err " + testId + " : oops ! unexpected exception. "
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
    private static int addMemberOK(ISocialNetwork sn, String login,
                                       String pwd, String profile, String testId) {
        int nbMembers = sn.nbMembers(); // Number of members when starting to
        // process this method
        try {
            sn.addMember(login, pwd, profile); // Try to add this member
            // No exception was thrown. That's a good start !
            if (sn.nbMembers() != nbMembers + 1) { // But the number of members
                // hasn't changed
                // accordingly
                System.out.println("Err " + testId
                        + " : the number of members (" + nbMembers
                        + ") was not incremented"); // Error message displayed
                return 1; // return error code
            } else
                return 0; // return success code : everything is OK, nothing to
            // display
        } catch (BadEntryException e) {
            System.out
                    .println("Err " + testId + " : BadEntryException exception " + e);
            e.printStackTrace();
            return 1;
        } catch (Exception e) {
            System.out
                    .println("Err " + testId + " : ouch ! unexpected exception " + e);
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * Check that this new film (login, password, title, kind, director, scenarist, duration) can be (and <i>is</i>)
     * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
     * : the new film was added.</br> If not OK, an error message is displayed
     * and 1 is returned ; the new film was not correctly added.
     *
     * @param sn
     *            - the <i>ISocialNetwork</i>
     * @param login
     *            - Member's login
     * @param password
     *            - Member's password
     * @param title
     *            - Titre du film
     * @param kind
     *            - Genre du Film
     * @param director
     *            - Directeur du film
     * @param scenarist
     *            - Scénariste du film
     * @param duration
     *            - Durée du film
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int addNewItemFilmOK(ISocialNetwork sn, String login, String password,
                                            String title, String kind, String director,
                                            String scenarist, int duration, String testId) {
        int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.addItemFilm(login, password, title, kind, director, scenarist, duration); // Try to add this film
            // No exception was thrown. That's a good start !
            if (sn.nbFilms() != nbFilms + 1) { // But the number of films
                // hasn't changed
                // accordingly
                System.out.println("Err " + testId + " : the number of films (" + nbFilms + ") was not incremented"); // Error message displayed
                return 1; // return error code
            } else
                return 0; // return success code : everything is OK, nothing to
            // display
        } catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out
                    .println("Err " + testId + " : atchoom ! unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
    }

    /**
     * Add in the <i>SocialNetwork</i> a new review for a film on behalf of a
     * specific member.</br> If this member has already given a review for this
     * same film before, the new review replaces the previous one.
     *
     * @param login
     *            login of the member adding the review
     * @param password
     *            password of the member adding the review
     * @param title
     *            the reviewed film's title
     * @param mark
     *            the mark given by the member for this film
     * @param comment
     *            the comment given by the member for this film
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
     *             if title is not registered as a film's title in the
     *             <i>SocialNetwork</i>
     *
     * @return mean of the marks for this film
     */
    private static int reviewItemFilmOK(ISocialNetwork sn, String login, String password,
                                            String title, float mark, String comment, String testId) {
        // int nbFilms = sn.nbFilms(); // Number of films when starting to
        // process this method
        try {
            sn.reviewItemFilm(login, password, title, mark, comment); // Try to add this film

        } catch (NotItemException e) { // BadEntry exception was thrown by
            System.out.println("Err " + testId + " : NotItemException exception "); // Error
            // addFilm() : this is a good start!
            // Let's now check if 'sn' was not
            // impacted
            /*if (sn.nbFilms() != nbFilms) { // The number of films has
                System.out.println("Err "+ testId+ " : BadEntry was thrown but the number of films was changed"); // Display
                return 1; // return "error" value
            } else
                // The number of reviews hasn't changed, which is considered a
                // good indicator that 'sn' was not modified
                return 0; // return success value : everything seems OK, nothing*/
            // to display
        }catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out.println("Err " + testId + " : berk ! unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
        return 0;
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
     * @param testId
     *            - the test ID that will prefix any error message displayed by
     *            this method
     * @return 0 if the test is OK, 1 if not
     */
    private static int KarmaOKTest(ISocialNetwork sn, String login, String testId) {
        int nbMembers = sn.nbMembers(); // Number of members when starting to
        // process this method
        try {
            Member membre;
            membre = sn.getMember(login);
            System.out.println(membre.getKarma());
            // No exception was thrown. That's a good start !
        } catch (Exception e) {// An exception was thrown by addMember() : this
            // is an error case
            System.out
                    .println("Err " + testId + " : glglelgezgl ! unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
        return 0;
    }

    private static int addMemberBadEntryTest(ISocialNetwork sn, String login,
                                             String pwd, String profile, String testId, String errorMessage) {

        int nbMembers = sn.nbMembers(); // Number of members when starting to
        // run this method
        try {
            sn.addMember(login, pwd, profile); // Try to add this member
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
            if (sn.nbMembers() != nbMembers) { // The number of members has
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
            System.out.println("Err " + testId + " : arg ! unexpected exception. "
                    + e); // Display a specific error message
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error value
        }
    }
    private static int addMemberOKTest(ISocialNetwork sn, String login,
                                       String pwd, String profile, String testId) {
        int nbMembers = sn.nbMembers(); // Number of members when starting to
        // process this method
        try {
            sn.addMember(login, pwd, profile); // Try to add this member
            // No exception was thrown. That's a good start !
            if (sn.nbMembers() != nbMembers + 1) { // But the number of members
                // hasn't changed
                // accordingly
                System.out.println("Err " + testId
                        + " : the number of members (" + nbMembers
                        + ") was not incremented"); // Error message displayed
                return 1; // return error code
            } else
                return 0; // return success code : everything is OK, nothing to
            // display
        } catch (Exception e) {// An exception was thrown by addMember() : this
            // is an error case
            System.out
                    .println("Err " + testId + " : damn ! unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
    }

    private static int reviewItemReviewOKTest(ISocialNetwork sn, String login, String password,
                                              String title, Review laReview,float mark, String comment, String testId,
                                              String errorMessage) {
        int nbReview = sn.nbReview(); // Number of review
        try {
            sn.reviewItemReview(login, password, title, laReview, mark, comment); // Try to add this film
        } catch (NotItemException e) {
            if (sn.nbReview() != nbReview) {
                System.out.println("Err "+ testId+ " : NotItemException was thrown, but the number of REview was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
        }catch (BadEntryException e) {
            if (sn.nbReview() != nbReview) {
                System.out.println("Err "+ testId+ " : BadEntryException was thrown, but the number of Review was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
        }catch (NotMemberException e) {
            if (sn.nbReview() != nbReview) {
                System.out.println("Err "+ testId+ " : NotMemberException was thrown, but the number of Review was changed"); // Display
                return 1;// and return the "error" value
            } else
                return 0; // return success value : everything is OK, nothing to
        }catch (Exception e) {// An exception was thrown by addFilm() : this
            // is an error case
            System.out.println("Err " + testId + " : ar ! unexpected exception " + e); // Error
            // message
            // displayed
            e.printStackTrace(); // Display contextual info about what happened
            return 1; // return error code
        }
        return 0;
    }

    /**
     * <i>TestKarma()</i> main test :
     * <ul>
     * <li>check if Karma can be calculated</li>
     * <li>check if incorrect parameters cause getKarma() to throw BadEntry
     * exception</li>
     * </ul>
     *
     * @return a summary of the performed tests
     */
    public static TestReport test() {


        int nbTests = 0; // total number of performed tests
        int nbErrors = 0; // total number of failed tests
        ISocialNetwork sn = new SocialNetwork();

        System.out.println("Testing addKarma()");

        int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
        // here)
        int nbFilms = sn.nbFilms(); // number of films in 'sn' (should be 0
        // here)


        nbErrors += addMemberOK(sn, "Paul", "paul", "Nouveau", "1.1 Ajout membre");
        nbTests++;
        nbErrors += addMemberOK(sn, "Marc", "marc", "Nouveau", "1.2 Ajout membre");
        nbTests++;
        nbErrors += addMemberOK(sn, "Flo", "floo", "Nouveau", "1.3 Ajout membre");
        nbTests++;
        nbErrors += addNewItemFilmOK(sn, "Paul", "paul", "The big Lebowski", "Comédie", "Ethan Coen, Joel Coen", "Ethan Coen, Joel Coen",120, "2.1 Add a film");
        nbTests++;
        nbErrors += addNewItemFilmOK(sn, "Paul", "paul", "Gran Torino", "Drame/Thriller", "Clint Eastwood", "Nick Schenk",119, "2.2 Add a film");
        nbTests++;
        nbErrors += reviewItemFilmOK(sn, "Paul", "paul", "Gran Torino", 7.5f, "Film d'une grande qualitée", "2.3 Add a film review");
        nbTests++;

        try {

            nbErrors += reviewItemReviewOKTest(sn, "Marc", "marc", "Idem", sn.getReview("Gran Torino", "Paul"), 9f, "Tout à fait d'accord", "2.4", "Add a review of a review");
            nbTests++;
            nbErrors += reviewItemReviewOKTest(sn, "Flo", "floo", "Pareil", sn.getReview("Gran Torino", "Paul"), 7.5f, "I agree", "2.5", "Add a review of a review");
            nbTests++;

        }
        catch (BadEntryException e) {
            System.out.println("error in getReview");
        }
        catch (Exception e) {
            System.out.println("ARRRRRRRRR ! someting went WRRRRRONG !!!");
        }
        nbErrors += KarmaOKTest(sn,"Paul","3.1");
        nbTests++;


        // try to add already registered members

        // Display final state of 'sn'
        System.out.println("Final state of the social network : " + sn);

        // Print a summary of the tests and return test results
        try{
            TestReport tr = new TestReport(nbTests, nbErrors);
            System.out.println("TestKarmaMember : " + tr);
            return tr;
        }
        catch (NotTestReportException e){ //This shouldn't happen
            System.out.println("Unexpected error in TestKarmaMember test code - Can't return valuable test results");
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
