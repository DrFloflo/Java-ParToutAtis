package opinion;

import java.util.LinkedList;

import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotItemException;
import exceptions.NotMemberException;

/**
 * Skeleton for the SocialNetwork
 * 
 */
public class SocialNetwork implements ISocialNetwork {
	private int nbMembers;
	private int nbBook;
	private int nbFilm;
	public static int lastID = 0;
	LinkedList<Book> listeBook = new LinkedList<Book>();
	LinkedList<Film> listeFilm = new LinkedList<Film>();
	LinkedList<Member> listeMember = new LinkedList<Member>();


	@Override
	public int nbMembers() {
		return this.nbMembers;
	}

	@Override
	public int nbFilms() {
		return this.nbFilm;
	}

	@Override
	public int nbBooks() {
		return this.nbBook;
	}
	@Override
	public Film getFilm(String title) throws BadEntryException {
		Film filmTrouve = null;
		for (Film eachFilm : listeFilm) {			//Verify if the film exists
			if (eachFilm.getTitle().equals(title)) {
				filmTrouve=eachFilm;
			}
		}
		if (filmTrouve == null) {
			throw new BadEntryException("Error the film doesn't exist");
		}
		else {
			return filmTrouve;
		}
	}

	//@Override
	public int nbReview() {
		int nbReview = 0;
		for (Member eachMember : listeMember) {
			for (Review eachReview : eachMember.listeReview) {
				nbReview++;
			}
		}
		return nbReview;
	}

	@Override
	public void addMember(String login, String password, String profile)
			throws BadEntryException, MemberAlreadyExistsException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new BadEntryException("Error login null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new BadEntryException("Error password null");}
		if(password!=null && password.replaceAll(" ", "").length()<4) { throw new BadEntryException("Error the password is under 4 characters");}
		if(profile==null) { throw new BadEntryException("Error login null");}
		else if(profile.replaceAll(" ", "").equals("")) { throw new BadEntryException("Error profil null");}



		for (Member eachMember : listeMember) { //For member in listMember
			if (eachMember.getLogin().toLowerCase().replaceAll(" ", "").equals(login.toLowerCase().replaceAll(" ", ""))) {
				throw new MemberAlreadyExistsException();
			}
		}
		Member newMembre = new Member(profile, "03/05/20", login, password, "");
		this.nbMembers+=1;
		listeMember.add(newMembre);
	}

	@Override
	public void addItemFilm(String login, String password, String title, String kind, String director, String scriptwriter, int duration)
			throws BadEntryException, NotMemberException, ItemFilmAlreadyExistsException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new BadEntryException("Error login null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new BadEntryException("Error password null");}
		if(title==null) { throw new BadEntryException("Errori title null");}
		if(kind==null) { throw new BadEntryException("Error Kind is null");}
		if(director==null) { throw new BadEntryException("Error the director is null");}
		if(scriptwriter==null) { throw new BadEntryException("Error the scenarist is null");}
		if(duration<1) { throw new BadEntryException("Error the duration is too short");}

		//check if logins are corrects
		Member user = null;
		for (Member eachMember : listeMember) {
			if (login.equals(eachMember.getLogin())) { user = eachMember; } //member found
			break;
		}
		if (user==null) { throw new NotMemberException("Error, incorrect login"); }
		if (!user.getPwd().equals(password)) { throw new NotMemberException("Error incorrect password"); }

		for (Film eachFilm : listeFilm) {
			if (eachFilm.getTitle().toLowerCase().replaceAll(" ","").equals(title.toLowerCase().replaceAll(" ","")) &&
					eachFilm.getDirector().toLowerCase().replaceAll(" ","").equals(director.toLowerCase().replaceAll(" ",""))) {
				throw new ItemFilmAlreadyExistsException();
			}
		}

		Film newFilm = new Film(director, kind, title, scriptwriter, duration);
		this.nbFilm+=1;
		listeFilm.add(newFilm);

	}

	@Override
	public void addItemBook(String login, String password, String title,
			String kind, String author, int nbPages) throws BadEntryException,
			NotMemberException, ItemBookAlreadyExistsException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new BadEntryException("Error login null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new BadEntryException("Erreur le password est null");}
		if(title==null) { throw new BadEntryException("Error title null");}
		if(kind==null) { throw new BadEntryException("Error the kind null");}
		if(author==null) { throw new BadEntryException("Error author null");}
		if(nbPages<1) { throw new BadEntryException("Error the number of page is too short");}

		//check if logins are corrects
		Member user = null;
		for (Member eachMember : listeMember) {
			if (login.equals(eachMember.getLogin())) { user = eachMember; } //member found
			break;
		}
		if (user==null) { throw new BadEntryException("Error, incorrect login"); }
		if (!user.getPwd().equals(password)) { throw new BadEntryException("Error, incorrect password"); }

		for (Book eachBook : listeBook) {
			if (eachBook.getTitle().toLowerCase().replaceAll(" ","").equals(title.toLowerCase().replaceAll(" ","")) &&
					eachBook.getAuthor().toLowerCase().replaceAll(" ","").equals(author.toLowerCase().replaceAll(" ",""))) {
				throw new ItemBookAlreadyExistsException();
			}
		}

		Book newBook = new Book(kind, title, author, nbPages);
		this.nbBook+=1;
		listeBook.add(newBook);

	}

	@Override
	public float reviewItemFilm(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		if(login == null) { throw new NotMemberException("Error login null");}
		else if (login.replaceAll(" ", "").length() == 0) { throw new NotMemberException("Error login null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new NotMemberException("Error password null");}
		if(title==null) { throw new BadEntryException("Error title null");}
		if(comment==null) { throw new BadEntryException("Error comment null");}
		if(mark<0 || mark > 10) { throw new BadEntryException("Error the mark is invalid");}

		Film filmTrouve = null;
		for (Film eachFilm : listeFilm) {			//Verify if the film exists
			if (eachFilm.getTitle() == title) {
				filmTrouve=eachFilm;
			}
		}
		if (filmTrouve==null){
			throw new NotItemException("Error the film doesn't exist");
		}


		Member memberTrouve = null;
		for (Member eachMember : listeMember) {			//Verify if the member credential are correct
			if (eachMember.getLogin() == login && eachMember.getPwd() == password) {
				memberTrouve=eachMember;
			}
		}
		if (memberTrouve==null){						// if not found, throw error
			throw new NotItemException("Error, incorrect identification");
		}


		for (Review eachReview : filmTrouve.listeReview) {			//Check if the review already exists
			if (eachReview.getMember() == login) {
				throw new NotItemException("Error, the member has already a review on this object");
			}
		}
		//If everything is correct after the tests, add review
		Review newReview = new Review(title, 110520, login, mark, comment); //(String title, int date, String member, int note, String comment)
		filmTrouve.listeReview.add(newReview);
		memberTrouve.listeReview.add(newReview);
		return 0;
	}

	@Override
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new NotMemberException("Error login null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new NotMemberException("Error password null");}
		if(title==null) { throw new BadEntryException("Error title null");}
		if(comment==null) { throw new BadEntryException("Error comment null");}
		if(mark<0 || mark > 10) { throw new BadEntryException("Error the mark is invalid");}

		Book bookTrouve = null;
		for (Book eachBook : listeBook) {		//Check if the book really exist
			if (eachBook.getTitle() == title) {
				bookTrouve=eachBook;
			}
		}
		if (bookTrouve==null){
			throw new NotItemException("Error the book doesn't exist");
		}

		Member memberTrouve = null;
		for (Member eachMember : listeMember) {			//Verify if the member credential are correct
			if (eachMember.getLogin() == login && eachMember.getPwd() == password) {
				memberTrouve=eachMember;
			}
		}
		if (memberTrouve==null){
			throw new NotItemException("Error, incorrect identification");
		}


		for (Review eachReview : bookTrouve.listeReview) {
			if (eachReview.getMember() == login) {
				throw new NotItemException("Error, the member has already a review on this object");
			}
		}


		Review newReview = new Review(title, 110520, login, mark, comment); //(String title, int date, String member, int note, String comment)
		bookTrouve.listeReview.add(newReview);
		memberTrouve.listeReview.add(newReview);
		return 0;
	}

	//@Override
	public float reviewItemReview(String login, String password, String title, Review laReview,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new NotMemberException("Error login null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new NotMemberException("Error password null");}
		if(laReview==null) { throw new BadEntryException("Error review null");}
		if(comment==null) { throw new BadEntryException("Error comment null");}
		if(mark<0 || mark > 10) { throw new BadEntryException("Error the mark is invalid");}

		Review reviewTrouve = laReview;
		for (Review eachReview : reviewTrouve.listeReview) {
			if (eachReview.getMember() == login) {
				throw new NotItemException("Error, the member has already a review on this object");
			}
		}

		Member memberTrouve = null;
		for (Member eachMember : listeMember) {			//Verify if the member credential are correct
			if (eachMember.getLogin() == login && eachMember.getPwd() == password) {
				memberTrouve=eachMember;
			}
		}
		if (memberTrouve==null){
			throw new NotItemException("Error, incorrect identification");
		}


		Review newReview = new Review(title, 110520, login, mark, comment); //(String title, int date, String member, int note, String comment)
		reviewTrouve.listeReview.add(newReview);
		memberTrouve.listeReview.add(newReview);
		return 0;
	}

	@Override
	public LinkedList<String> consultItems(String title)
			throws BadEntryException {
		return new LinkedList<String>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
