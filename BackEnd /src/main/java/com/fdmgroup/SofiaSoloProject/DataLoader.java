package com.fdmgroup.SofiaSoloProject;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.fdmgroup.SofiaSoloProject.dal.AssignedBookRepository;
import com.fdmgroup.SofiaSoloProject.dal.AuthorRepository;
import com.fdmgroup.SofiaSoloProject.dal.BookGroupRepository;
import com.fdmgroup.SofiaSoloProject.dal.BookRepository;
import com.fdmgroup.SofiaSoloProject.dal.LocationRepository;
import com.fdmgroup.SofiaSoloProject.dal.MeetingRepository;
import com.fdmgroup.SofiaSoloProject.dal.MessageRepository;
import com.fdmgroup.SofiaSoloProject.dal.GenreRepository;
import com.fdmgroup.SofiaSoloProject.model.AssignedBook;
import com.fdmgroup.SofiaSoloProject.model.Author;
import com.fdmgroup.SofiaSoloProject.model.Book;
import com.fdmgroup.SofiaSoloProject.model.BookGroup;
import com.fdmgroup.SofiaSoloProject.model.Genre;
import com.fdmgroup.SofiaSoloProject.model.Location;
import com.fdmgroup.SofiaSoloProject.model.Meeting;
import com.fdmgroup.SofiaSoloProject.model.Message;
import com.fdmgroup.SofiaSoloProject.model.User;
import com.fdmgroup.SofiaSoloProject.service.UserService;

@Service
public class DataLoader implements ApplicationRunner{
	
	
	private UserService userService;
	private MessageRepository messageRepo;
	private MeetingRepository meetingRepo;
	private LocationRepository locationRepo;
	private GenreRepository genreRepo;
	private BookGroupRepository bookGroupRepo;
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	private AssignedBookRepository assignedBookRepo;
	
	@Autowired
	public DataLoader(UserService userService, MessageRepository messageRepo, MeetingRepository meetingRepo,
			LocationRepository locationRepo, GenreRepository genreRepo, BookGroupRepository bookGroupRepo,
			BookRepository bookRepo, AuthorRepository authorRepo, AssignedBookRepository assignedBookRepo) {
		super();
		this.userService = userService;
		this.messageRepo = messageRepo;
		this.meetingRepo = meetingRepo;
		this.locationRepo = locationRepo;
		this.genreRepo = genreRepo;
		this.bookGroupRepo = bookGroupRepo;
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
		this.assignedBookRepo = assignedBookRepo;
	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		
		//////////////////////////////////////////
		/////////          DATA          /////////
		//////////////////////////////////////////
		
		User user1 = new User("BigReader", "reading123", "Ella");
		User user2 = new User("Bond", "008", "James");
		User user3 = new User("Rosebud", "reading", "Rosie");
		User user4 = new User("Agent86", "getsmart", "Maxwell");
		User user5 = new User("Agent99", "getsmarter", "Susan");
		User user6 = new User("SupremeReader", "xtremereading", "Paula");
		User user7 = new User("Skywalker", "darthvader", "Anakin");
		User user8 = new User("TheOneWhoLived", "chosenone", "Harry");
		User user9 = new User("Lizzie", "prejudice", "Elizabeth");
		User user10 = new User("MrDarcy", "pride", "Fitzgerald");
		User user11 = new User("MissBennet", "obliging", "Jane");
		User user12 = new User("MrBingley", "goodbook", "Charles");
		User user13 = new User("Silvertongue", "alethieometer", "Lyra");
		User user14 = new User("KnifeBearer", "subtleknife", "Will");
		User user15 = new User("RubySlippers", "twister", "Dorothy");
		User user16 = new User("BrightestWitch", "granger", "Hermione");
		User user17 = new User("TheMockingjay", "primrose", "Katniss");
		User user18 = new User("FirstStep", "tothemoon", "Neil");
		User user19 = new User("SnowLeopard", "republicofheaven", "Asriel");
		User user20 = new User("GoldenMonkey", "lyra", "Marissa");
		User user21 = new User("Librarian", "aristotle", "Nora");
		User user22 = new User("Scholar", "canoe", "Malcom");
		User user23 = new User("Astrophysicist", "darkmatter", "Malone");
		User user24 = new User("ArmouredBear", "silvertongue", "Iorek");
		User user25 = new User("Aeronaut", "heather", "Scoresby");
		User user26 = new User("Astronaut", "secretkey", "George");
		User user27 = new User("Witch", "pinebranch", "Serafina");
		User user28 = new User("Snoopy", "peanuts", "Charlie");
		User user29 = new User("BookWorm", "1234", "Eura");
		User user30 = new User("TheFlash", "fastestalive", "Barry");
		User user31 = new User("GreenArrow", "thehood", "Oliver");
		User user32 = new User("Supergirl", "krypton", "Kara");
		User user33 = new User("Superman", "kryptonite", "Clark");
		User user34 = new User("Swiftie", "thirteen", "Taylor");
		User user35 = new User("Hozier", "wasteland", "Andrew");
		User user36 = new User("VidaLoca", "cantando", "Ricky");
		User user37 = new User("MissWoodhouse", "knightley", "Emma");
		User user38 = new User("TheGoodWitch", "wendy", "Maisie");
		User user39 = new User("FrimFram", "nopotatoes", "Diana");
		User user40 = new User("GirlintheGables", "withane", "Anne");
		User user41 = new User("TheThief", "thehobbit", "Bilbo");
		User user42 = new User("TheBearer", "baggins", "Frodo");
		User user43 = new User("Pippin", "took", "Peregrin");
		User user44 = new User("Merry", "brandybuck", "Meriadoc");
		User user45 = new User("Archer", "mirkwood", "Legolas");
		User user46 = new User("Strider", "theking", "Aragorn");
		User user47 = new User("Sam", "gamgee", "Samwise");
		User user48 = new User("HouseofDurin", "sonofgloin", "Gimli");
		User user49 = new User("Regent", "faramir", "Boromir");
		User user50 = new User("TheGrey", "wizard", "Gandalf");
		
		BookGroup bookGroup1 = new BookGroup(5);
		BookGroup bookGroup2 = new BookGroup(7);
		BookGroup bookGroup3 = new BookGroup(8);
		BookGroup bookGroup4 = new BookGroup(10);
		BookGroup bookGroup5 = new BookGroup(4);
		BookGroup bookGroup6 = new BookGroup(6);
		BookGroup bookGroup7 = new BookGroup(5);
		BookGroup bookGroup8 = new BookGroup(3);
		
		Book b1 = new Book("His Dark Materials: Northern Lights");
		Book b2 = new Book("His Dark Materials: The Subtle Knife");
		Book b3 = new Book("His Dark Materials: The Amber Spyglass");
		Book b4 = new Book("The Book of Dust: La Belle Sauvage");
		Book b5 = new Book("The Book of Dust: The Secret Commonwealth");
		Book b6 = new Book("Pride and Prejudice");
		Book b7 = new Book("Emma");
		Book b8 = new Book("Persuassion");
		Book b9 = new Book("Sense and Sensibility");
		Book b10 = new Book("Northanger Abbey");
		Book b11 = new Book("Lady Susan");
		Book b12 = new Book("The Hobbit");
		Book b13 = new Book("The Lord of the Rings Part 1: The Fellowship of the Ring");
		Book b14 = new Book("The Lord of the Rings Part 2: The Two Towers");
		Book b15 = new Book("The Lord of the Rings Part 3: The Return of the King");
		Book b16 = new Book("The Silmarillion");
		Book b17 = new Book("The Overstory");
		Book b18 = new Book("Bewilderment");
		Book b19 = new Book("A Brief History of Time");
		Book b20 = new Book("The Invention of Nature");
		Book b21 = new Book("The Beginning of Infinity");
		Book b22 = new Book("Small is Beautiful: A Study of Economics as if People Mattered");
		Book b23 = new Book("Contact");
		Book b24 = new Book("Treasure Island");
		Book b25 = new Book("Journey to the Centre of the Earth");
		Book b26 = new Book("Daddy Long Legs");
		Book b27 = new Book("The Midnight Library");
		Book b28 = new Book("The Humans");
		Book b29 = new Book("How to Stop Time");
		Book b30 = new Book("Anna Karenina");
		Book b31 = new Book("The Picture of Dorian Grey");
		Book b32 = new Book("The Hunger Games");
		Book b33 = new Book("The Hunger Games: Catching Fire");
		Book b34 = new Book("The Hunger Games: Mockingjay");
		Book b35 = new Book("Do Androids Dream of Electric Sheep");
		Book b36 = new Book("Cloud Atlas");
		Book b37 = new Book("Moby Dick");
		Book b38 = new Book("The Thursday Murder Club");
		Book b39 = new Book("The Man Who Died Twice: A Thursday Murder Club Mystery");
		Book b40 = new Book("The Bullet that Missed: A Thursday Murder Club Mystery");
		Book b41 = new Book("The Last Devil to Die: A Thursday Murder Club Mystery");
		Book b42 = new Book("Lessons in Chemistry");
		Book b43 = new Book("The Secret");
		Book b44 = new Book("Tomorrow, and Tomorrow, and Tomorrow");
		Book b45 = new Book("Someone Else's Shoes");
		Book b46 = new Book("Jane Eyre");
		Book b47 = new Book("Wuthering Heights");
		Book b48 = new Book("A Little History of Philosophy");
		Book b49 = new Book("Frankenstein");
		Book b50 = new Book("Heart of Darkness");
		Book b51 = new Book("What is to be Done: Political Engagement and Saving the Planet");
		Book b52 = new Book("Reasons to Stay Alive");
		Book b53 = new Book("Brief Answers to the Big Questions");
		Book b54 = new Book("Magnificent Rebels: The First Romantics and the Invention of the Self");
		Book b55 = new Book("Red Rising");
		Book b56 = new Book("Red Rising: Golden Son");
		Book b57 = new Book("Red Rising: Morning Star");
		Book b58 = new Book("Iron Gold");
		Book b59 = new Book("Iron Gold: Dark Age");
		Book b60 = new Book("Iron Gold: Light Bringer");
		
		Author a1 = new Author("Philip", "Pullman");
		Author a2 = new Author("Jane", "Austen");
		Author a3 = new Author("John Ronald Reuel", "Tolkien");
		Author a4 = new Author("Richard", "Powers");
		Author a5 = new Author("Stephen", "Hawking");
		Author a6 = new Author("Andrea", "Wulf");
		Author a7 = new Author("David", "Deutsch");
		Author a8 = new Author("Ernst Friedrich", "Schumacher");
		Author a9 = new Author("Carl", "Sagan");
		Author a10 = new Author("Robert Louis", "Stevenson");
		Author a11 = new Author("Jules", "Verne");
		Author a12 = new Author("Jean", "Webster");
		Author a13 = new Author("Leo", "Tolstoy");
		Author a14 = new Author("Oscar", "Wilde");
		Author a15 = new Author("Suzanne", "Collins");
		Author a16 = new Author("Philip Kindred", "Dick");
		Author a17 = new Author("David", "Mitchell");
		Author a18 = new Author("Herman", "Melville");
		Author a19 = new Author("Richard", "Osman");
		Author a20 = new Author("Bonnie", "Garmus");
		Author a21 = new Author("Lee", "Child");
		Author a22 = new Author("Gabrielle", "Zevin");
		Author a23 = new Author("Jojo", "Moyes");
		Author a24 = new Author("Charlotte", "Bronte");
		Author a25 = new Author("Emily", "Bronte");
		Author a26 = new Author("Nigel", "Warburton");
		Author a27 = new Author("Mary", "Shelly");
		Author a28 = new Author("Joseph", "Conrad");
		Author a29 = new Author("Barry", "Jones");
		Author a30 = new Author("Pierce", "Brown");
		Author a31 = new Author("Matt", "Haig");
		
		Message ms1 = new Message("Can't wait to read Emma!", Timestamp.valueOf("2023-07-03 10:05:03"));
		Message ms2 = new Message("I'm halfway through already and I can't put it down!", Timestamp.valueOf("2023-06-20 13:10:00"));
		Message ms3 = new Message("Struggling to get through Verne, this is not at all like the movie", Timestamp.valueOf("2023-09-03 00:15:00"));
		Message ms4 = new Message("Me too, I keep on waiting for the action sequences that never come", Timestamp.valueOf("2023-09-05 14:53:00"));
		Message ms5 = new Message("Just finished the book, and I have so much to say", Timestamp.valueOf("2023-12-18 19:23:10"));
		Message ms6 = new Message("So, to reiterate what we decided in teh meeting, let's try to finish LOTR by the end of this year:)", Timestamp.valueOf("2023-10-04 12:36:12"));
		Message ms7 = new Message("I'm loving the Ents, now I want to go out and talk to the trees", Timestamp.valueOf("2023-11-25 18:13:04"));
		Message ms8 = new Message("This section is a bit slow for me, they talk too much", Timestamp.valueOf("2023-11-25 21:45:44"));
		Message ms9 = new Message("We made it! Finishing off LOTR spilling only slightly into the new year!", Timestamp.valueOf("2023-12-28 23:18:32"));
		Message ms10 = new Message("The perspective of the trees between sections is haunting", Timestamp.valueOf("2023-07-30 08:44:05"));
		Message ms11 = new Message("I've just ordered the book. It has fantastic reviews, let's see if it lives up to the hype...", Timestamp.valueOf("2023-09-22 09:02:32"));
		Message ms12 = new Message("I trust the reviews, this is going to be great", Timestamp.valueOf("2023-07-30 18:51:46"));
		Message ms13 = new Message("I thought I wouldn't be able to follow this book, but it turns out not to be too bad", Timestamp.valueOf("2024-01-22 19:32:14"));
		Message ms14 = new Message("I'm going to need someone to explain this to me. I get the feeling it's going over my head.", Timestamp.valueOf("2023-06-21 20:11:10"));
		Message ms15 = new Message("I can't believe this was written 40 years ago", Timestamp.valueOf("2023-07-30 19:44:53"));
		Message ms16 = new Message("This is nothing like Blade Runner, but it does give me the same eerie feeling", Timestamp.valueOf("2023-11-24 21:51:03"));
		Message ms17 = new Message("Once again, I am going to need someone to explain how this all comes together", Timestamp.valueOf("2024-01-22 19:22:23"));
		Message ms18 = new Message("This time I am equally lost", Timestamp.valueOf("2024-01-23 18:17:00"));
		Message ms19 = new Message("Who is the real monster???", Timestamp.valueOf("2023-12-20 20:23:11"));
		Message ms20 = new Message("I've been findingthis a little slow to get into, but now it's hard to put down", Timestamp.valueOf("2023-12-05 22:14:34"));
		Message ms21 = new Message("Hey team, I'm going to have to miss the next meeting. I'll get reading and see you next time :)", Timestamp.valueOf("2024-01-20 7:12:22"));
		Message ms22 = new Message("This book is fantastic!", Timestamp.valueOf("2023-11-14 20:54:39"));
		Message ms23 = new Message("It makes me want to learn about so many different things", Timestamp.valueOf("2023-11-23 10:32:55"));
	
		Meeting m1 = new Meeting(Timestamp.valueOf("2023-06-03 15:00:00"));
		Meeting m2 = new Meeting(Timestamp.valueOf("2023-06-10 19:30:00"));
		Meeting m3 = new Meeting(Timestamp.valueOf("2024-01-10 12:00:00"));
		Meeting m4 = new Meeting(Timestamp.valueOf("2023-05-15 16:15:00"));
		Meeting m5 = new Meeting(Timestamp.valueOf("2023-08-09 10:00:00"));
		Meeting m6 = new Meeting(Timestamp.valueOf("2023-10-03 11:00:00"));
		Meeting m7 = new Meeting(Timestamp.valueOf("2023-12-20 18:30:00"));
		Meeting m8 = new Meeting(Timestamp.valueOf("2023-11-10 20:00:00"));
		Meeting m9 = new Meeting(Timestamp.valueOf("2023-12-04 19:30:00"));
		Meeting m10 = new Meeting(Timestamp.valueOf("2024-01-25 18:30:00"));
		Meeting m11 = new Meeting(Timestamp.valueOf("2023-09-20 11:45:00"));
//		Meeting m12 = new Meeting(Timestamp.valueOf("2024-04-01 10:00:00"));
		Meeting m13 = new Meeting(Timestamp.valueOf("2023-05-25 18:15:00"));
		Meeting m14 = new Meeting(Timestamp.valueOf("2023-07-10 18:15:00"));
		Meeting m15 = new Meeting(Timestamp.valueOf("2023-10-02 18:15:00"));
		Meeting m16 = new Meeting(Timestamp.valueOf("2024-01-05 18:30:00"));
		Meeting m17 = new Meeting(Timestamp.valueOf("2024-03-15 18:15:00"));
		Meeting m18 = new Meeting(Timestamp.valueOf("2023-12-01 20:30:00"));
		Meeting m19 = new Meeting(Timestamp.valueOf("2024-02-10 20:30:00"));
		Meeting m20 = new Meeting(Timestamp.valueOf("2023-11-13 18:45:00"));
		Meeting m21 = new Meeting(Timestamp.valueOf("2024-01-27 18:45:00"));
		Meeting m22 = new Meeting(Timestamp.valueOf("2024-03-25 18:45:00"));
		Meeting m23 = new Meeting(Timestamp.valueOf("2023-10-17 18:00:00"));
		Meeting m24 = new Meeting(Timestamp.valueOf("2024-01-27 18:00:00"));
		Meeting m25 = new Meeting(Timestamp.valueOf("2024-03-25 18:00:00"));
		Meeting m26 = new Meeting(Timestamp.valueOf("2024-02-12 18:30:00"));
		Meeting m27 = new Meeting(Timestamp.valueOf("2024-03-12 15:30:00"));
		
		Location l1 = new Location("Inner City");
		Location l2 = new Location("East");
		Location l3 = new Location("West");
		Location l4 = new Location("North");
		Location l5 = new Location("South East");
		
		Genre g1 = new Genre("Science fiction");
		Genre g2 = new Genre("Horror/Thriller");
		Genre g3 = new Genre("Classics");
		Genre g4 = new Genre("Romance");
		Genre g5 = new Genre("Non-fiction");
		Genre g6 = new Genre("Fantasy");
		Genre g7 = new Genre("All - fiction");
		Genre g8 = new Genre("All");
		Genre g9 = new Genre("Best Sellers");
		
		AssignedBook as1 = new AssignedBook(Date.valueOf("2023-06-03"), b7, bookGroup1);
		AssignedBook as2 = new AssignedBook(Date.valueOf("2023-06-10"), b17, bookGroup3);
		AssignedBook as3 = new AssignedBook(Date.valueOf("2024-01-10"), b19, bookGroup3);
		AssignedBook as4 = new AssignedBook(Date.valueOf("2023-05-15"), b12, bookGroup2);
		AssignedBook as5 = new AssignedBook(Date.valueOf("2023-08-09"), b25, bookGroup1);
		AssignedBook as6 = new AssignedBook(Date.valueOf("2023-10-03"), b13, bookGroup2);
		AssignedBook as7 = new AssignedBook(Date.valueOf("2023-12-20"), b26, bookGroup1);
		AssignedBook as8 = new AssignedBook(Date.valueOf("2023-11-10"), b14, bookGroup2);
		AssignedBook as9 = new AssignedBook(Date.valueOf("2023-12-04"), b15, bookGroup2);
		AssignedBook as10 = new AssignedBook(Date.valueOf("2023-09-20"), b44, bookGroup3);
		AssignedBook as11 = new AssignedBook(Date.valueOf("2023-05-25"), b49, bookGroup4);
		AssignedBook as12 = new AssignedBook(Date.valueOf("2023-07-10"), b23, bookGroup4);
		AssignedBook as13 = new AssignedBook(Date.valueOf("2023-10-02"), b35, bookGroup4);
		AssignedBook as14 = new AssignedBook(Date.valueOf("2024-01-24"), b36, bookGroup4);
		AssignedBook as15 = new AssignedBook(Date.valueOf("2023-12-01"), b49, bookGroup5);
		AssignedBook as16 = new AssignedBook(Date.valueOf("2023-11-13"), b1, bookGroup6);
		AssignedBook as17 = new AssignedBook(Date.valueOf("2024-01-27"), b2, bookGroup6);
		AssignedBook as18 = new AssignedBook(Date.valueOf("2023-10-07"), b20, bookGroup7);
		AssignedBook as19 = new AssignedBook(Date.valueOf("2024-01-10"), b22, bookGroup7);
		AssignedBook as20  = new AssignedBook(Date.valueOf("2024-01-03"), b6, bookGroup8);
		AssignedBook as21  = new AssignedBook(Date.valueOf("2023-04-20"), b50, bookGroup1);
		AssignedBook as22  = new AssignedBook(Date.valueOf("2023-03-15"), b27, bookGroup2);
		AssignedBook as23  = new AssignedBook(Date.valueOf("2023-03-22"), b45, bookGroup3);
		AssignedBook as24  = new AssignedBook(Date.valueOf("2023-02-17"), b28, bookGroup4);
		AssignedBook as25  = new AssignedBook(Date.valueOf("2023-10-05"), b31, bookGroup5);
		AssignedBook as26  = new AssignedBook(Date.valueOf("2023-07-12"), b29, bookGroup6);
		AssignedBook as27 = new AssignedBook(Date.valueOf("2023-08-07"), b21, bookGroup7);
		
		
		/////////////////////////////////////////
		/////////      COLLECTIONS      /////////
		/////////////////////////////////////////
		
		List<User> users = new ArrayList<User>();
		List<Book> books = new ArrayList<Book>();
		List<Message> messages = new ArrayList<Message>();
		List<Meeting> meetings = new ArrayList<Meeting>();
		List<Location> locations = new ArrayList<Location>();
		List<Genre> genres = new ArrayList<Genre>();
		List<BookGroup> bookGroups = new ArrayList<BookGroup>();
		List<AssignedBook> assignments = new ArrayList<AssignedBook>();
		List<Author> authors = new ArrayList<Author>();
		
		authors.add(a31);
		authors.add(a30);
		authors.add(a29);
		authors.add(a28);
		authors.add(a27);
		authors.add(a26);
		authors.add(a25);
		authors.add(a24);
		authors.add(a23);
		authors.add(a22);
		authors.add(a21);
		authors.add(a20);
		authors.add(a19);
		authors.add(a18);
		authors.add(a17);
		authors.add(a16);
		authors.add(a15);
		authors.add(a14);
		authors.add(a13);
		authors.add(a12);
		authors.add(a11);
		authors.add(a10);
		authors.add(a9);
		authors.add(a8);
		authors.add(a7);
		authors.add(a6);
		authors.add(a5);
		authors.add(a4);
		authors.add(a3);
		authors.add(a2);
		authors.add(a1);
		
		bookGroups.add(bookGroup1);
		bookGroups.add(bookGroup2);
		bookGroups.add(bookGroup3);
		bookGroups.add(bookGroup4);
		bookGroups.add(bookGroup5);
		bookGroups.add(bookGroup6);
		bookGroups.add(bookGroup7);
		bookGroups.add(bookGroup8);
		
		users.add(user20);
		users.add(user19);
		users.add(user18);
		users.add(user17);
		users.add(user16);
		users.add(user15);
		users.add(user14);
		users.add(user13);
		users.add(user12);
		users.add(user11);
		users.add(user10);
		users.add(user9);
		users.add(user8);
		users.add(user7);
		users.add(user6);
		users.add(user5);
		users.add(user4);
		users.add(user3);
		users.add(user2);
		users.add(user1);
		users.add(user36);
		users.add(user35);
		users.add(user34);
		users.add(user33);
		users.add(user32);
		users.add(user31);
		users.add(user30);
		users.add(user29);
		users.add(user28);
		users.add(user27);
		users.add(user26);
		users.add(user25);
		users.add(user24);
		users.add(user23);
		users.add(user22);
		users.add(user21);
		users.add(user37);
		users.add(user38);
		users.add(user39);
		users.add(user40);
		users.add(user41);
		users.add(user42);
		users.add(user43);
		users.add(user44);
		users.add(user45);
		users.add(user46);
		users.add(user47);
		users.add(user48);
		users.add(user49);
		users.add(user50);
		
		books.add(b30);
		books.add(b29);
		books.add(b28);
		books.add(b27);
		books.add(b26);
		books.add(b25);
		books.add(b24);
		books.add(b23);
		books.add(b22);
		books.add(b21);
		books.add(b20);
		books.add(b19);
		books.add(b18);
		books.add(b17);
		books.add(b16);
		books.add(b15);
		books.add(b14);
		books.add(b13);
		books.add(b12);
		books.add(b11);
		books.add(b10);
		books.add(b9);
		books.add(b8);
		books.add(b7);
		books.add(b6);
		books.add(b5);
		books.add(b4);
		books.add(b3);
		books.add(b2);
		books.add(b1);
		books.add(b50);
		books.add(b49);
		books.add(b48);
		books.add(b47);
		books.add(b46);
		books.add(b45);
		books.add(b44);
		books.add(b43);
		books.add(b42);
		books.add(b41);
		books.add(b40);
		books.add(b39);
		books.add(b38);
		books.add(b37);
		books.add(b36);
		books.add(b35);
		books.add(b34);
		books.add(b33);
		books.add(b32);
		books.add(b31);
		books.add(b51);
		books.add(b52);
		books.add(b53);
		books.add(b54);
		books.add(b55);
		books.add(b56);
		books.add(b57);
		books.add(b58);
		books.add(b59);
		books.add(b60);
		
		messages.add(ms5);
		messages.add(ms1);
		messages.add(ms2);
		messages.add(ms3);
		messages.add(ms4);
		messages.add(ms6);
		messages.add(ms7);
		messages.add(ms8);
		messages.add(ms9);
		messages.add(ms10);
		messages.add(ms11);
		messages.add(ms12);
		messages.add(ms13);
		messages.add(ms14);
		messages.add(ms15);
		messages.add(ms16);
		messages.add(ms17);
		messages.add(ms18);
		messages.add(ms19);
		messages.add(ms20);
		messages.add(ms21);
		messages.add(ms22);
		messages.add(ms23);
		
		meetings.add(m7);
		meetings.add(m6);
		meetings.add(m5);
		meetings.add(m4);
		meetings.add(m3);
		meetings.add(m2);
		meetings.add(m1);
		meetings.add(m10);
		meetings.add(m9);
		meetings.add(m8);
		meetings.add(m11);
//		meetings.add(m12);
		meetings.add(m13);
		meetings.add(m14);
		meetings.add(m15);
		meetings.add(m16);
		meetings.add(m17);
		meetings.add(m18);
		meetings.add(m19);
		meetings.add(m20);
		meetings.add(m21);
		meetings.add(m22);
		meetings.add(m23);
		meetings.add(m24);
		meetings.add(m25);
		meetings.add(m26);
		meetings.add(m27);
		
		locations.add(l5);
		locations.add(l4);
		locations.add(l3);
		locations.add(l2);
		locations.add(l1);
		
		genres.add(g9);
		genres.add(g8);
		genres.add(g7);
		genres.add(g6);
		genres.add(g5);
		genres.add(g4);
		genres.add(g3);
		genres.add(g2);
		genres.add(g1);
		
		assignments.add(as7);
		assignments.add(as6);
		assignments.add(as5);
		assignments.add(as4);
		assignments.add(as3);
		assignments.add(as2);
		assignments.add(as1);
		assignments.add(as8);
		assignments.add(as9);
		assignments.add(as10);
		assignments.add(as11);
		assignments.add(as12);
		assignments.add(as13);
		assignments.add(as14);
		assignments.add(as15);
		assignments.add(as16);
		assignments.add(as17);
		assignments.add(as18);
		assignments.add(as19);
		assignments.add(as20);
		assignments.add(as21);
		assignments.add(as22);
		assignments.add(as23);
		assignments.add(as24);
		assignments.add(as25);
		assignments.add(as26);
		assignments.add(as27);
		
		
		//////////////////////////////////////////
		/////////    SET RELATIONSHIPS   /////////
		//////////////////////////////////////////
	
		user1.setBookGroup(bookGroup3);
		user2.setBookGroup(bookGroup3);
		user3.setBookGroup(bookGroup3);
		user4.setBookGroup(bookGroup3);
		user5.setBookGroup(bookGroup3);
		user6.setBookGroup(bookGroup3);
		user7.setBookGroup(bookGroup3);
		user8.setBookGroup(bookGroup3);
		user9.setBookGroup(bookGroup2);
		user10.setBookGroup(bookGroup2);
		user11.setBookGroup(bookGroup2);
		user12.setBookGroup(bookGroup2);
		user13.setBookGroup(bookGroup2);
		user14.setBookGroup(bookGroup2);
		user15.setBookGroup(bookGroup2);
		user16.setBookGroup(bookGroup1);
		user17.setBookGroup(bookGroup1);
		user18.setBookGroup(bookGroup1);
		user19.setBookGroup(bookGroup1);
		user20.setBookGroup(bookGroup1);
		user21.setBookGroup(bookGroup4);
		user22.setBookGroup(bookGroup4);
		user23.setBookGroup(bookGroup4);
		user24.setBookGroup(bookGroup4);
		user25.setBookGroup(bookGroup4);
		user26.setBookGroup(bookGroup4);
		user27.setBookGroup(bookGroup4);
		user28.setBookGroup(bookGroup4);
		user29.setBookGroup(bookGroup4);
		user30.setBookGroup(bookGroup4);
		user31.setBookGroup(bookGroup5);
		user32.setBookGroup(bookGroup5);
		user33.setBookGroup(bookGroup5);
		user34.setBookGroup(bookGroup5);
		user35.setBookGroup(bookGroup6);
		user36.setBookGroup(bookGroup6);
		user37.setBookGroup(bookGroup6);
		user38.setBookGroup(bookGroup6);
		user39.setBookGroup(bookGroup6);
		user40.setBookGroup(bookGroup6);
		user41.setBookGroup(bookGroup7);
		user42.setBookGroup(bookGroup7);
		user43.setBookGroup(bookGroup7);
		user44.setBookGroup(bookGroup7);
		user45.setBookGroup(bookGroup7);
		user46.setBookGroup(bookGroup8);
		user47.setBookGroup(bookGroup8);
		user48.setBookGroup(bookGroup8);

		user1.setLocation(l5);
		user2.setLocation(l5);
		user3.setLocation(l5);
		user4.setLocation(l5);
		user5.setLocation(l5);
		user6.setLocation(l5);
		user7.setLocation(l5);
		user8.setLocation(l5);
		user9.setLocation(l1);
		user10.setLocation(l1);
		user11.setLocation(l1);
		user12.setLocation(l1);
		user13.setLocation(l1);
		user14.setLocation(l1);
		user15.setLocation(l1);
		user16.setLocation(l4);
		user17.setLocation(l4);
		user18.setLocation(l4);
		user19.setLocation(l4);
		user20.setLocation(l4);
		user21.setLocation(l2);
		user22.setLocation(l2);
		user23.setLocation(l2);
		user24.setLocation(l2);
		user25.setLocation(l2);
		user26.setLocation(l2);
		user27.setLocation(l2);
		user28.setLocation(l2);
		user29.setLocation(l2);
		user30.setLocation(l2);
		user31.setLocation(l3);
		user32.setLocation(l3);
		user33.setLocation(l3);
		user34.setLocation(l3);
		user35.setLocation(l1);
		user36.setLocation(l1);
		user37.setLocation(l1);
		user38.setLocation(l1);
		user39.setLocation(l1);
		user40.setLocation(l1);
		user41.setLocation(l3);
		user42.setLocation(l3);
		user43.setLocation(l3);
		user44.setLocation(l3);
		user45.setLocation(l3);
		user46.setLocation(l2);
		user47.setLocation(l2);
		user48.setLocation(l2);
		user49.setLocation(l3);
		user50.setLocation(l4);
		
		user1.setGenre(g9);
		user2.setGenre(g9);
		user3.setGenre(g9);
		user4.setGenre(g9);
		user5.setGenre(g9);
		user6.setGenre(g9);
		user7.setGenre(g9);
		user8.setGenre(g9);
		user9.setGenre(g6);
		user10.setGenre(g6);
		user11.setGenre(g6);
		user12.setGenre(g6);
		user13.setGenre(g6);
		user14.setGenre(g6);
		user15.setGenre(g6);
		user16.setGenre(g3);
		user17.setGenre(g3);
		user18.setGenre(g3);
		user19.setGenre(g3);
		user20.setGenre(g3);
		user21.setGenre(g1);
		user22.setGenre(g1);
		user23.setGenre(g1);
		user24.setGenre(g1);
		user25.setGenre(g1);
		user26.setGenre(g1);
		user27.setGenre(g1);
		user28.setGenre(g1);
		user29.setGenre(g1);
		user30.setGenre(g1);
		user31.setGenre(g2);
		user32.setGenre(g2);
		user33.setGenre(g2);
		user34.setGenre(g2);
		user35.setGenre(g8);
		user36.setGenre(g8);
		user37.setGenre(g8);
		user38.setGenre(g8);
		user39.setGenre(g8);
		user40.setGenre(g8);
		user41.setGenre(g5);
		user42.setGenre(g5);
		user43.setGenre(g5);
		user44.setGenre(g5);
		user45.setGenre(g5);
		user46.setGenre(g4);
		user47.setGenre(g4);
		user48.setGenre(g4);
		user49.setGenre(g3);
		user50.setGenre(g5);
		
		bookGroup1.setGenre(g3);
		bookGroup2.setGenre(g6);
		bookGroup3.setGenre(g9);
		bookGroup4.setGenre(g1);
		bookGroup5.setGenre(g2);
		bookGroup6.setGenre(g8);
		bookGroup7.setGenre(g5);
		bookGroup8.setGenre(g4);
		
		bookGroup1.setLocation(l4);
		bookGroup2.setLocation(l1);
		bookGroup3.setLocation(l5);
		bookGroup4.setLocation(l2);
		bookGroup5.setLocation(l3);
		bookGroup6.setLocation(l1);
		bookGroup7.setLocation(l3);
		bookGroup8.setLocation(l2);
		
		m1.setBookGroup(bookGroup1);
		m2.setBookGroup(bookGroup3);
		m3.setBookGroup(bookGroup3);
		m4.setBookGroup(bookGroup2);
		m5.setBookGroup(bookGroup1);
		m6.setBookGroup(bookGroup2);
		m7.setBookGroup(bookGroup1);
		m8.setBookGroup(bookGroup2);
		m9.setBookGroup(bookGroup2);
		m10.setBookGroup(bookGroup2);
		m11.setBookGroup(bookGroup3);
//		m12.setBookGroup(bookGroup3);
		m13.setBookGroup(bookGroup4);
		m14.setBookGroup(bookGroup4);
		m15.setBookGroup(bookGroup4);
		m16.setBookGroup(bookGroup4);
		m17.setBookGroup(bookGroup4);
		m18.setBookGroup(bookGroup5);
		m19.setBookGroup(bookGroup5);
		m20.setBookGroup(bookGroup6);
		m21.setBookGroup(bookGroup6);
		m22.setBookGroup(bookGroup6);
		m23.setBookGroup(bookGroup7);
		m24.setBookGroup(bookGroup7);
		m25.setBookGroup(bookGroup7);
		m26.setBookGroup(bookGroup8);
		m27.setBookGroup(bookGroup1);
		
		ms1.setBookGroup(bookGroup1);
		ms1.setUser(user20);
		
		ms2.setBookGroup(bookGroup1);
		ms2.setUser(user19);
		
		ms3.setBookGroup(bookGroup1);
		ms3.setUser(user17);
		
		ms4.setBookGroup(bookGroup1);
		ms4.setUser(user20);
		
		ms5.setBookGroup(bookGroup1);
		ms5.setUser(user16);
		
		ms6.setBookGroup(bookGroup2);
		ms6.setUser(user9);
		
		ms7.setBookGroup(bookGroup2);
		ms7.setUser(user12);
		
		ms8.setBookGroup(bookGroup2);
		ms8.setUser(user10);
		
		ms9.setBookGroup(bookGroup2);
		ms9.setUser(user9);
		
		ms10.setBookGroup(bookGroup3);
		ms10.setUser(user3);
		
		ms11.setBookGroup(bookGroup3);
		ms11.setUser(user5);
		
		ms12.setBookGroup(bookGroup3);
		ms12.setUser(user2);
		
		ms13.setBookGroup(bookGroup3);
		ms13.setUser(user8);
		
		ms14.setBookGroup(bookGroup4);
		ms14.setUser(user21);
		
		ms15.setBookGroup(bookGroup4);
		ms15.setUser(user28);
		
		ms16.setBookGroup(bookGroup4);
		ms16.setUser(user26);
		
		ms17.setBookGroup(bookGroup4);
		ms17.setUser(user21);
		
		ms18.setBookGroup(bookGroup4);
		ms18.setUser(user22);
		
		ms19.setBookGroup(bookGroup5);
		ms19.setUser(user32);
		
		ms20.setBookGroup(bookGroup6);
		ms20.setUser(user37);
		
		ms21.setBookGroup(bookGroup6);
		ms21.setUser(user40);
		
		ms22.setBookGroup(bookGroup7);
		ms22.setUser(user43);
		
		ms23.setBookGroup(bookGroup7);
		ms23.setUser(user42);
		
		b1.setAuthor(a1);
		b2.setAuthor(a1);
		b3.setAuthor(a1);
		b4.setAuthor(a1);
		b5.setAuthor(a1);
		b6.setAuthor(a2);
		b7.setAuthor(a2);
		b8.setAuthor(a2);
		b9.setAuthor(a2);
		b10.setAuthor(a2);
		b11.setAuthor(a2);
		b12.setAuthor(a3);
		b13.setAuthor(a3);
		b14.setAuthor(a3);
		b15.setAuthor(a3);
		b16.setAuthor(a3);
		b17.setAuthor(a4);
		b18.setAuthor(a4);
		b19.setAuthor(a5);
		b20.setAuthor(a6);
		b21.setAuthor(a7);
		b22.setAuthor(a8);
		b23.setAuthor(a9);
		b24.setAuthor(a10);
		b25.setAuthor(a11);
		b26.setAuthor(a12);
		b27.setAuthor(a31);
		b28.setAuthor(a31);
		b29.setAuthor(a31);
		b30.setAuthor(a13);
		b31.setAuthor(a14);
		b32.setAuthor(a15);
		b33.setAuthor(a15);
		b34.setAuthor(a15);
		b35.setAuthor(a16);
		b36.setAuthor(a17);
		b37.setAuthor(a18);
		b38.setAuthor(a19);
		b39.setAuthor(a19);
		b40.setAuthor(a19);
		b41.setAuthor(a19);
		b42.setAuthor(a20);
		b43.setAuthor(a21);
		b44.setAuthor(a22);
		b45.setAuthor(a23);
		b46.setAuthor(a24);
		b47.setAuthor(a25);
		b48.setAuthor(a26);
		b49.setAuthor(a27);
		b50.setAuthor(a28);
		b51.setAuthor(a29);
		b52.setAuthor(a13);
		b53.setAuthor(a5);
		b54.setAuthor(a6);
		b55.setAuthor(a30);
		b56.setAuthor(a30);
		b57.setAuthor(a30);
		b58.setAuthor(a30);
		b59.setAuthor(a30);
		b60.setAuthor(a30);
		
		b1.setGenre(Arrays.asList(g1,g6,g7,g8));
		b2.setGenre(Arrays.asList(g1,g6,g7,g8));
		b3.setGenre(Arrays.asList(g1,g6,g7,g8));
		b4.setGenre(Arrays.asList(g1,g6,g9,g7,g8));
		b5.setGenre(Arrays.asList(g1,g6,g9,g7,g8));
		b6.setGenre(Arrays.asList(g3,g4,g7,g8));
		b7.setGenre(Arrays.asList(g3,g4,g7,g8));
		b8.setGenre(Arrays.asList(g3,g4,g7,g8));
		b9.setGenre(Arrays.asList(g3,g4,g7,g8));
		b10.setGenre(Arrays.asList(g3,g4,g7,g8));
		b11.setGenre(Arrays.asList(g3,g4,g7,g8));
		b12.setGenre(Arrays.asList(g3,g6,g7,g8));
		b13.setGenre(Arrays.asList(g3,g6,g7,g8));
		b14.setGenre(Arrays.asList(g3,g6,g7,g8));
		b15.setGenre(Arrays.asList(g3,g6,g7,g8));
		b16.setGenre(Arrays.asList(g3,g6,g7,g8));
		b17.setGenre(Arrays.asList(g7,g8,g9));
		b18.setGenre(Arrays.asList(g7,g8));
		b19.setGenre(Arrays.asList(g5,g8,g9));
		b20.setGenre(Arrays.asList(g5,g8));
		b21.setGenre(Arrays.asList(g5,g7,g8,g9));
		b22.setGenre(Arrays.asList(g5,g7,g8));
		b23.setGenre(Arrays.asList(g1,g7,g8));
		b24.setGenre(Arrays.asList(g3,g6,g7,g8));
		b25.setGenre(Arrays.asList(g1,g3,g7,g8));
		b26.setGenre(Arrays.asList(g3,g4,g7,g8));
		b27.setGenre(Arrays.asList(g1,g6,g7,g8,g9));
		b28.setGenre(Arrays.asList(g1,g7,g8));
		b29.setGenre(Arrays.asList(g1,g4,g6,g7,g8,g9));
		b30.setGenre(Arrays.asList(g3,g4,g7,g8));
		b31.setGenre(Arrays.asList(g2,g3,g6,g7,g8));
		b32.setGenre(Arrays.asList(g1,g7,g8,g9));
		b33.setGenre(Arrays.asList(g1,g7,g8,g9));
		b34.setGenre(Arrays.asList(g1,g7,g8,g9));
		b35.setGenre(Arrays.asList(g1,g3,g7,g8));
		b36.setGenre(Arrays.asList(g1,g7,g8));
		b37.setGenre(Arrays.asList(g3,g7,g8));
		b38.setGenre(Arrays.asList(g7,g8,g9));
		b39.setGenre(Arrays.asList(g7,g8,g9));
		b40.setGenre(Arrays.asList(g7,g8,g9));
		b41.setGenre(Arrays.asList(g7,g8,g9));
		b42.setGenre(Arrays.asList(g4,g7,g8,g9));
		b43.setGenre(Arrays.asList(g2,g7,g8,g9));
		b44.setGenre(Arrays.asList(g4,g7,g8,g9));
		b45.setGenre(Arrays.asList(g4,g7,g8,g9));
		b46.setGenre(Arrays.asList(g3,g4,g7,g8));
		b47.setGenre(Arrays.asList(g3,g4,g7,g8));
		b48.setGenre(Arrays.asList(g5,g8));
		b49.setGenre(Arrays.asList(g1,g2,g3,g7,g8));
		b50.setGenre(Arrays.asList(g2,g3,g7,g8));
		b51.setGenre(Arrays.asList(g5,g8));
		b52.setGenre(Arrays.asList(g5,g8,g9));
		b53.setGenre(Arrays.asList(g5,g8,g9));
		b54.setGenre(Arrays.asList(g5,g8));
		b55.setGenre(Arrays.asList(g1,g7,g8,g9));
		b56.setGenre(Arrays.asList(g1,g7,g8,g9));
		b57.setGenre(Arrays.asList(g1,g7,g8,g9));
		b58.setGenre(Arrays.asList(g1,g7,g8,g9));
		b59.setGenre(Arrays.asList(g1,g7,g8,g9));
		b60.setGenre(Arrays.asList(g1,g7,g8,g9));
		
		
		//////////////////////////////////////////
		/////////        SAVE DATA       /////////
		//////////////////////////////////////////
		
		
		for (Genre genre : genres) {
			genreRepo.save(genre);
		}
		
		for (Location location : locations) {
			locationRepo.save(location);
		}
		
		for (Author author : authors) {
			authorRepo.save(author);
		}
		
		for (Book book : books) {
			bookRepo.save(book);
		}
		
		for (BookGroup bookGroup : bookGroups) {
			bookGroupRepo.save(bookGroup);
		}
		
		for (AssignedBook assignedBook : assignments) {
			assignedBookRepo.save(assignedBook);
		}
		
		for (Meeting meeting : meetings) {
			meetingRepo.save(meeting);
		}

		for (User user : users) {
			userService.register(user);
		}
		
		for (Message message : messages) {
			messageRepo.save(message);
		}
	
	}
	

}
