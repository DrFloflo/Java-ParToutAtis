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
		// TODO Auto-generated method stub
		return this.nbMembers;
	}

	@Override
	public int nbFilms() {
		// TODO Auto-generated method stub
		return this.nbFilm;
	}

	@Override
	public int nbBooks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addMember(String login, String password, String profile)
			throws BadEntryException, MemberAlreadyExistsException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new BadEntryException("Erreur le login est null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new BadEntryException("Erreur le password est null");}
		if(password!=null && password.replaceAll(" ", "").length()<4) { throw new BadEntryException("Erreur le password est compose de moins de 4 char");}
		if(profile==null) { throw new BadEntryException("Erreur le login est null");}
		else if(profile.replaceAll(" ", "") == "") { }//throw new BadEntryException("Erreur le profile est null");}



		for (Member eachMember : listeMember) { //For member in listMemeber
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
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new BadEntryException("Erreur le login est null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new BadEntryException("Erreur le password est null");}
		if(title==null) { throw new BadEntryException("Erreur le titre est null");}
		if(kind==null) { throw new BadEntryException("Erreur la variable genre est null");}
		if(director==null) { throw new BadEntryException("Erreur la variable directeur est null");}
		if(scriptwriter==null) { throw new BadEntryException("Erreur la variable scénariste est null");}
		if(duration<1) { throw new BadEntryException("Erreur la durée est trop courte");}

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
		// TODO Auto-generated method stub

	}

	@Override
	public float reviewItemFilm(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new NotMemberException("Erreur le login est null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new NotMemberException("Erreur le password est null");}
		if(title==null) { throw new BadEntryException("Erreur le titre est null");}
		if(comment==null) { throw new BadEntryException("Erreur le commentaire est null");}
		if(mark<0 || mark > 20) { throw new BadEntryException("Erreur la note est invalide");}

		Film filmTrouve = null;
		for (Film eachFilm : listeFilm) {			//Verify if the film exists
			if (eachFilm.getTitle() == title) {
				filmTrouve=eachFilm;
			}
		}
		if (filmTrouve==null){
			throw new NotItemException("Erreur le film n'éxiste pas");
		}

		for (Review eachReview : filmTrouve.listeReview) {
			if (eachReview.getComment() == comment && eachReview.getMember() == login) {
				throw new NotItemException("Erreur la review existe déja pour ce membre");
			}
		}

		Review newReview = new Review(title, 110520, login, mark, comment); //(String title, int date, String member, int note, String comment)
		filmTrouve.listeReview.add(newReview);
		return 0;
	}

	@Override
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new NotMemberException("Erreur le login est null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new NotMemberException("Erreur le password est null");}
		if(title==null) { throw new BadEntryException("Erreur le titre est null");}
		if(comment==null) { throw new BadEntryException("Erreur le commentaire est null");}
		if(mark<0 || mark > 20) { throw new BadEntryException("Erreur la note est invalide");}

		Book bookTrouve = null;
		for (Book eachBook : listeBook) {		//on verifie que le book vise existe vraiment
			if (eachBook.getTitle() == title) {
				bookTrouve=eachBook;
			}
		}
		if (bookTrouve==null){
			throw new NotItemException("Erreur le book n'éxiste pas");
		}
		for (Review eachReview : bookTrouve.listeReview) {
			if (eachReview.getComment() == comment && eachReview.getMember() == login) {
				throw new NotItemException("Erreur la review existe déja pour ce membre");
			}
		}


		Review newReview = new Review(title, 110520, login, mark, comment); //(String title, int date, String member, int note, String comment)
		bookTrouve.listeReview.add(newReview);
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
