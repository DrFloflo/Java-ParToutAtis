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
		return 0;
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


		Member newMembre = new Member(profile, "03/05/20", login, password, "");
		this.nbMembers+=1;
		listeMember.add(newMembre);

		// TODO Auto-generated method stub
	}

	@Override
	public void addItemFilm(String login, String password, String title,
			String kind, String director, String scriptwriter, int duration)
			throws BadEntryException, NotMemberException,
			ItemFilmAlreadyExistsException {
		if(login==null || login.replaceAll(" ", "").length()==0) { throw new BadEntryException("Erreur le login est null");}
		if(password==null || password.replaceAll(" ", "").length()==0) { throw new BadEntryException("Erreur le password est null");}
		if(title==null) { throw new BadEntryException("Erreur le titre est null");}
		if(kind==null) { throw new BadEntryException("Erreur la variable genre est null");}
		if(director==null) { throw new BadEntryException("Erreur la variable directeur est null");}
		if(scriptwriter==null) { throw new BadEntryException("Erreur la variable scénariste est null");}
		if(duration<1) { throw new BadEntryException("Erreur la durée est trop courte");}


		Film newFilm = new Film(title, kind, director, scriptwriter, duration);
		this.nbFilm+=1;
		listeFilm.add(newFilm);


		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		// TODO Auto-generated method stub
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
