package com.fdmgroup.SofiaSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroup.SofiaSoloProject.controller.AssignmentController;
import com.fdmgroup.SofiaSoloProject.controller.AuthorController;
import com.fdmgroup.SofiaSoloProject.controller.BookController;
import com.fdmgroup.SofiaSoloProject.controller.BookGroupController;
import com.fdmgroup.SofiaSoloProject.controller.GenreController;
import com.fdmgroup.SofiaSoloProject.controller.LocationController;
import com.fdmgroup.SofiaSoloProject.controller.MeetingController;
import com.fdmgroup.SofiaSoloProject.controller.MessageController;
import com.fdmgroup.SofiaSoloProject.controller.UserController;
import com.fdmgroup.SofiaSoloProject.model.AssignedBook;
import com.fdmgroup.SofiaSoloProject.model.Author;
import com.fdmgroup.SofiaSoloProject.model.Book;
import com.fdmgroup.SofiaSoloProject.model.BookGroup;
import com.fdmgroup.SofiaSoloProject.model.Genre;
import com.fdmgroup.SofiaSoloProject.model.Location;
import com.fdmgroup.SofiaSoloProject.model.Meeting;
import com.fdmgroup.SofiaSoloProject.model.Message;
import com.fdmgroup.SofiaSoloProject.model.User;
import com.fdmgroup.SofiaSoloProject.service.AssignmentService;
import com.fdmgroup.SofiaSoloProject.service.AuthorService;
import com.fdmgroup.SofiaSoloProject.service.BookGroupService;
import com.fdmgroup.SofiaSoloProject.service.BookService;
import com.fdmgroup.SofiaSoloProject.service.GenreService;
import com.fdmgroup.SofiaSoloProject.service.LocationService;
import com.fdmgroup.SofiaSoloProject.service.MeetingService;
import com.fdmgroup.SofiaSoloProject.service.MessageService;
import com.fdmgroup.SofiaSoloProject.service.UserService;

@ExtendWith(MockitoExtension.class)
public class ControllerTests {

	
	///////////////////////////////////////////////////////////////////////////////
	//                          AssignmentController                             //
	///////////////////////////////////////////////////////////////////////////////
	
	AssignmentController assignmentController;
	
	@Mock
	AssignmentService assignmentServiceMock;
	
	//firstEndPoint
	@Test
	void test_assignment_firstEndPoint_calls_service_once_produces_empty_array() {
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);
	
		assertNotNull(assignmentServiceMock);
		
		when(assignmentServiceMock.findAll()).thenReturn(null);
		
		List<AssignedBook> assignment = assignmentController.firstEndPoint();
		
		assertNull(assignment);
		
		verify(assignmentServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_assignment_firstEndPoint_returns_array(){
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);

		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());

		when(assignmentServiceMock.findAll()).thenReturn(assignments);
		
		assertEquals(assignments, assignmentController.firstEndPoint());
		
		verify(assignmentServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_assignment_findById_calls_repo_service_returns_assignment() {
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);

		Optional<AssignedBook> assignment =Optional.of(new AssignedBook());
		
		when(assignmentServiceMock.findById(1)).thenReturn(assignment);
		
		assertEquals(assignment, assignmentController.findById(1));
		
		verify(assignmentServiceMock, times(1)).findById(1);
		
	}
	
	//findById(bookGroup)
	@Test
	void test_assignment_findByIdBookGroup_calls_service_returns_list() {
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);

		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		
		when(assignmentServiceMock.findBybookGroupId(1)).thenReturn(assignments);
		
		assertEquals(assignments, assignmentController.findByBookGroup(1));
		
		verify(assignmentServiceMock, times(1)).findBybookGroupId(1);
		
	}
	
	
	//findCurrent
	@Test
	void test_assignment_findCurrent_calls_service_once_returns_assignment() {
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);

		AssignedBook assignment = new AssignedBook();
		
		when(assignmentServiceMock.findCurrent(1)).thenReturn(assignment);
		
		assertEquals(assignment, assignmentController.findCurrent(1));
		
		verify(assignmentServiceMock, times(1)).findCurrent(1);
	}
	
	
	//createNewAssignment
	@Test
	void test_assignment_createNew_calls_service_once() {
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);

		AssignedBook assignment = new AssignedBook();
		
		assignmentController.createNewAssignment(assignment);
		
		verify(assignmentServiceMock, times(1)).saveAssignment(assignment);
	}
	
	
	//updateAssignment
	@Test
	void test_assignment_update_calls_service_once() {
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);

		AssignedBook assignment = new AssignedBook();
		
		assignmentController.updateAssignment(assignment);
		
		verify(assignmentServiceMock, times(1)).updateAssignment(assignment);
	}
	
	
	//deleteById
	@Test
	void test_assingment_deleteById_calls_service_once() {
		
		AssignmentController assignmentController = new AssignmentController(assignmentServiceMock);
		
		assignmentController.deleteById(1);
		
		verify(assignmentServiceMock, times(1)).deleteById(1);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                              AuthorController                             //
	///////////////////////////////////////////////////////////////////////////////
	
	AuthorController authorController;
	
	@Mock
	AuthorService authorServiceMock;
	
	//firstEndPoint
	@Test
	void test_author_firstEndPoint_calls_service_once_produces_empty_array() {
		
		AuthorController authorController = new AuthorController(authorServiceMock);
	
		assertNotNull(authorServiceMock);
		
		when(authorServiceMock.findAll()).thenReturn(null);
		
		List<Author> author = authorController.firstEndPoint();
		
		assertNull(author);
		
		verify(authorServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_author_firstEndPoint_returns_array(){
		
		AuthorController authorController = new AuthorController(authorServiceMock);
		
		List<Author> authors = new ArrayList<>();
		authors.add(new Author());
		authors.add(new Author());
		authors.add(new Author());

		when(authorServiceMock.findAll()).thenReturn(authors);
		
		assertEquals(authors, authorController.firstEndPoint());
		
		verify(authorServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_author_findById_calls_repo_service_returns_author() {
		
		AuthorController authorController = new AuthorController(authorServiceMock);
		
		Author author = new Author();
		
		when(authorServiceMock.findById(1)).thenReturn(author);
		
		assertEquals(author, authorController.findById(1));
		
		verify(authorServiceMock, times(1)).findById(1);
		
	}
	
	//createNewAuthor
	@Test
	void test_author_createNew_calls_service_once() {
		
		AuthorController authorController = new AuthorController(authorServiceMock);
		
		Author author = new Author();
		
		authorController.createNewAuthor(author);
		
		verify(authorServiceMock, times(1)).saveAuthor(author);
	}
	
	
	//deleteById
	@Test
	void test_author_deleteById_calls_service_once() {
		
		AuthorController authorController = new AuthorController(authorServiceMock);
		
		authorController.deleteById(1);
		
		verify(authorServiceMock, times(1)).deleteById(1);
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                                BookController                             //
	///////////////////////////////////////////////////////////////////////////////
	
	BookController bookController;
	
	@Mock
	BookService bookServiceMock;
	
	//firstEndPoint
	@Test
	void test_book_firstEndPoint_calls_service_once_produces_empty_array() {
		
		BookController bookController = new BookController(bookServiceMock);
	
		assertNotNull(bookServiceMock);
		
		when(bookServiceMock.findAll()).thenReturn(null);
		
		List<Book> book = bookController.firstEndPoint();
		
		assertNull(book);
		
		verify(bookServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_book_firstEndPoint_returns_array(){
		
		BookController bookController = new BookController(bookServiceMock);
		
		List<Book> books = new ArrayList<>();
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());

		when(bookServiceMock.findAll()).thenReturn(books);
		
		assertEquals(books, bookController.firstEndPoint());
		
		verify(bookServiceMock, times(1)).findAll();
		
	}
	
	
	//findById
	@Test
	void test_book_findById_calls_repo_service_returns_book() {
		
		BookController bookController = new BookController(bookServiceMock);
		
		Book book = new Book();
		
		when(bookServiceMock.findById(1)).thenReturn(book);
		
		assertEquals(book, bookController.findById(1));
		
		verify(bookServiceMock, times(1)).findById(1);
		
	}
	
	
	//bookByAuthor
	@Test
	void test_book_bookByAuthor_calls_service_once() {
		
		BookController bookController = new BookController(bookServiceMock);
		
		List<Book> books = new ArrayList<>();
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		
		when(bookServiceMock.findAllAuthor("Pullman")).thenReturn(books);
		
		assertEquals(books, bookController.bookByAuthor("Pullman"));
		
		verify(bookServiceMock, times(1)).findAllAuthor("Pullman");
	}
	
	
	//createNewBook
	@Test
	void test_book_createNew_calls_service_once() {
		
		BookController bookController = new BookController(bookServiceMock);
		
		Book book = new Book();
		
		bookController.createNewBook(book);
		
		verify(bookServiceMock, times(1)).saveBook(book);
		
	}
	
	
	//updateBook
	@Test
	void test_book_update_calls_service_once() {
		
		BookController bookController = new BookController(bookServiceMock);
		
		Book book = new Book();
		
		bookController.updateBook(book);
		
		verify(bookServiceMock, times(1)).updateBook(book);
		
	}
	
	
	//deleteBook
	@Test
	void test_book_delete_calls_service_once() {
		
		BookController bookController = new BookController(bookServiceMock);
		
		bookController.deleteBook(1);
		
		verify(bookServiceMock, times(1)).deleteById(1);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                            BookGroupController                            //
	///////////////////////////////////////////////////////////////////////////////

	
	BookGroupController bookgroupController;
	
	@Mock
	BookGroupService bookGroupServiceMock;
	
	
	//firstEndPoint
	@Test
	void test_bookGroup_firstEndPoint_calls_service_once_produces_empty_array() {
		
		BookGroupController bookGroupController = new BookGroupController(bookGroupServiceMock);
	
		assertNotNull(bookGroupServiceMock);
		
		when(bookGroupServiceMock.findAll()).thenReturn(null);
		
		List<BookGroup> bookGroup = bookGroupController.firstEndPoint();
		
		assertNull(bookGroup);
		
		verify(bookGroupServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_bookGroup_firstEndPoint_returns_array(){
		
		BookGroupController bookGroupController = new BookGroupController(bookGroupServiceMock);
		
		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());

		when(bookGroupServiceMock.findAll()).thenReturn(bookGroups);
		
		assertEquals(bookGroups, bookGroupController.firstEndPoint());
		
		verify(bookGroupServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_bookGroup_findById_calls_service_once() {
		
		BookGroupController bookGroupController = new BookGroupController(bookGroupServiceMock);

		BookGroup bookgroup = new BookGroup();
		
		when(bookGroupServiceMock.findById(1)).thenReturn(bookgroup);
		
		assertEquals(bookgroup, bookGroupController.findById(1));

		verify(bookGroupServiceMock, times(1)).findById(1);

	}
	
	//findGroup
	@Test
	void test_bookGroup_findGroup_calls_service_once() {
		
		BookGroupController bookGroupController = new BookGroupController(bookGroupServiceMock);
		
		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());
		
		when(bookGroupServiceMock.chooseGroup(1,1)).thenReturn(bookGroups);
		
		assertEquals(bookGroups, bookGroupController.findGroup(1,1));

		verify(bookGroupServiceMock, times(1)).chooseGroup(1,1);
		
	}
	
	
	//createNewBookGroup
	@Test
	void test_bookGroup_createNew_calls_service_once() {
		
		BookGroupController bookGroupController = new BookGroupController(bookGroupServiceMock);

		BookGroup bookgroup = new BookGroup();
		
		bookGroupController.createNewBookGroup(bookgroup);
		
		verify(bookGroupServiceMock, times(1)).saveBookGroup(bookgroup);
		
	}
	
	//updateBookGroup
	@Test
	void test_bookGroup_update_calls_service_once() {
		
		BookGroupController bookGroupController = new BookGroupController(bookGroupServiceMock);

		BookGroup bookgroup = new BookGroup();
		
		bookGroupController.updateBookGroup(bookgroup);
		
		verify(bookGroupServiceMock, times(1)).updateBookGroup(bookgroup);
		
	}
	
	
	//deleteBookGroup
	@Test
	void test_bookGroup_delete_calls_service_once() {
		
		BookGroupController bookGroupController = new BookGroupController(bookGroupServiceMock);
		
		bookGroupController.deleteBookGroup(1);
		
		verify(bookGroupServiceMock, times(1)).deleteById(1);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                                GenreController                            //
	///////////////////////////////////////////////////////////////////////////////
	
	GenreController genreController;
	
	@Mock
	GenreService genreServiceMock;
	
	
	//firstEndPoint
	@Test
	void test_genre_firstEndPoint_calls_service_once_produces_empty_array() {
		
		GenreController genreController = new GenreController(genreServiceMock);
	
		assertNotNull(genreServiceMock);
		
		when(genreServiceMock.findAll()).thenReturn(null);
		
		List<Genre> genres = genreController.firstEndPoint();
		
		assertNull(genres);
		
		verify(genreServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_genre_firstEndPoint_returns_array(){
		
		GenreController genreController = new GenreController(genreServiceMock);
		
		List<Genre> genres = new ArrayList<>();
		genres.add(new Genre());
		genres.add(new Genre());
		genres.add(new Genre());

		when(genreServiceMock.findAll()).thenReturn(genres);
		
		assertEquals(genres, genreController.firstEndPoint());
		
		verify(genreServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_genre_findById_calls_service_once() {
		
		GenreController genreController = new GenreController(genreServiceMock);

		Genre genre = new Genre();
		
		when(genreServiceMock.findById(1)).thenReturn(genre);
		
		assertEquals(genre, genreController.findById(1));

		verify(genreServiceMock, times(1)).findById(1);

	}
	
	//createNewGenre
	@Test
	void test_genre_create_calls_service_once() {
		
		GenreController genreController = new GenreController(genreServiceMock);

		Genre genre = new Genre();
		
		genreController.createNewGenre(genre);
		
		verify(genreServiceMock, times(1)).saveGenre(genre);
	}
	
	//updateGenre
	@Test
	void test_genre_update_calls_service_once() {
		
		GenreController genreController = new GenreController(genreServiceMock);

		Genre genre = new Genre();
		
		genreController.updateGenre(genre);
		
		verify(genreServiceMock, times(1)).updateGenre(genre);
	}
	
	
	//deleteGenre
	@Test
	void test_genre_delete_calls_service_once() {
		
		GenreController genreController = new GenreController(genreServiceMock);
		
		genreController.deleteGenre(1);
		
		verify(genreServiceMock, times(1)).deleteById(1);
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                              LocationController                           //
	///////////////////////////////////////////////////////////////////////////////
	
	LocationController locationController;
	
	@Mock
	LocationService locationServiceMock;
	
	
	//firstEndPoint
	@Test
	void test_location_firstEndPoint_calls_service_once_produces_empty_array() {
		
		LocationController locationController = new LocationController(locationServiceMock);
	
		assertNotNull(locationServiceMock);
		
		when(locationServiceMock.findAll()).thenReturn(null);
		
		List<Location> locations = locationController.firstEndPoint();
		
		assertNull(locations);
		
		verify(locationServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_location_firstEndPoint_returns_array(){
		
		LocationController locationController = new LocationController(locationServiceMock);
		
		List<Location> locations = new ArrayList<>();
		locations.add(new Location());
		locations.add(new Location());
		locations.add(new Location());
		
		when(locationServiceMock.findAll()).thenReturn(locations);
		
		assertEquals(locations, locationController.firstEndPoint());
		
		verify(locationServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_location_findById_calls_service_once() {
		
		LocationController locationController = new LocationController(locationServiceMock);

		Location location = new Location();
		
		when(locationServiceMock.findById(1)).thenReturn(location);
		
		assertEquals(location, locationController.locationById(1));

		verify(locationServiceMock, times(1)).findById(1);

	}
	
	
	//createNewLocation
	@Test
	void test_location_createNew_calls_service_once() {
		
		LocationController locationController = new LocationController(locationServiceMock);

		Location location = new Location();
		
		locationController.createNewLocation(location);
		
		verify(locationServiceMock, times(1)).saveLocation(location);
	}
	
	//updateLocation
	@Test
	void test_location_update_calls_service_once() {
		
		LocationController locationController = new LocationController(locationServiceMock);

		Location location = new Location();
		
		locationController.updateLocation(location);
		
		verify(locationServiceMock, times(1)).updateLocation(location);
	}
	
	//deleteLocation
	@Test
	void test_location_delete_calls_service_once() {
		
		LocationController locationController = new LocationController(locationServiceMock);
		
		locationController.deleteLocation(1);
		
		verify(locationServiceMock, times(1)).deleteById(1);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                               MeetingController                           //
	///////////////////////////////////////////////////////////////////////////////

	MeetingController meetingController;
	
	@Mock
	MeetingService meetingServiceMock;
	
	//firstEndPoint
	@Test
	void test_meeting_firstEndPoint_calls_service_once_produces_empty_array() {
		
		MeetingController meetingController = new MeetingController(meetingServiceMock);
	
		assertNotNull(meetingServiceMock);
		
		when(meetingServiceMock.findAll()).thenReturn(null);
		
		List<Meeting> meetings = meetingController.firstEndPoint();
		
		assertNull(meetings);
		
		verify(meetingServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_meeting_firstEndPoint_returns_array(){
	
		MeetingController meetingController = new MeetingController(meetingServiceMock);
		
		List<Meeting> meetings = new ArrayList<>();
		
		when(meetingServiceMock.findAll()).thenReturn(meetings);
		
		assertEquals(meetings, meetingController.firstEndPoint());
		
		verify(meetingServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_meeting_findById_calls_service_once() {
		
		MeetingController meetingController = new MeetingController(meetingServiceMock);

		Meeting meeting = new Meeting();
		
		when(meetingServiceMock.findById(1)).thenReturn(meeting);
		
		assertEquals(meeting, meetingController.findById(1));

		verify(meetingServiceMock, times(1)).findById(1);

	}
	
	
	//findNext
	@Test
	void test_meeting_findNext_calls_service_once_returns_meeting() {
		
		MeetingController meetingController = new MeetingController(meetingServiceMock);

		Meeting meeting = new Meeting();
		
		when(meetingServiceMock.findNext(1)).thenReturn(meeting);
		
		assertEquals(meeting, meetingController.findNext(1));

		verify(meetingServiceMock, times(1)).findNext(1);
		
	}
	
	//findByBookGroup
	@Test
	void test_meeting_findByBookGroup_calls_service_once_returns_meeting_array() {
		
		MeetingController meetingController = new MeetingController(meetingServiceMock);

		List<Meeting> meetings = new ArrayList<>();
		meetings.add(new Meeting());
		meetings.add(new Meeting());
		meetings.add(new Meeting());
				
		when(meetingServiceMock.findByBookGroup(1)).thenReturn(meetings);
		
		assertEquals(meetings, meetingController.findByBookGroup(1));

		verify(meetingServiceMock, times(1)).findByBookGroup(1);
		
	}
	
	//createNewMeeting
	@Test
	void test_meeting_create_calls_service_once() {
		
		MeetingController meetingController = new MeetingController(meetingServiceMock);

		Meeting meeting = new Meeting();

		meetingController.createNewMeeting(meeting);

		verify(meetingServiceMock, times(1)).saveMeeting(meeting);
		
	}
	
	
	//updateMeeting
	@Test
	void test_meeting_update_calls_service_once() {
		
		MeetingController meetingController = new MeetingController(meetingServiceMock);

		Meeting meeting = new Meeting();

		meetingController.updateMeeting(meeting);

		verify(meetingServiceMock, times(1)).updateMeeting(meeting);
		
	}
	
	
	//deleteMeeting
	@Test
	void test_meeting_delete_calls_service_once() {
		
		MeetingController meetingController = new MeetingController(meetingServiceMock);

		meetingController.deleteMeeting(1);

		verify(meetingServiceMock, times(1)).deleteById(1);
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                               MessageController                           //
	///////////////////////////////////////////////////////////////////////////////
	
	MessageController messageController;
	
	@Mock
	MessageService messageServiceMock;
	
	
	//firstEndPoint
	@Test
	void test_message_firstEndPoint_calls_service_once_produces_empty_array() {
		
		MessageController messageController = new MessageController(messageServiceMock);
		
		assertNotNull(messageServiceMock);
		
		when(messageServiceMock.findAll()).thenReturn(null);
		
		List<Message> messages = messageController.firstEndPoint();
		
		assertNull(messages);
		
		verify(messageServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_message_firstEndPoint_returns_array(){
	
		MessageController messageController = new MessageController(messageServiceMock);
		
		List<Message> messages = new ArrayList<>();
		
		when(messageServiceMock.findAll()).thenReturn(messages);
		
		assertEquals(messages, messageController.firstEndPoint());
		
		verify(messageServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_message_findById_calls_service_once() {
		
		MessageController messageController = new MessageController(messageServiceMock);

		Message message = new Message();
		
		when(messageServiceMock.findById(1)).thenReturn(message);
		
		assertEquals(message, messageController.findById(1));

		verify(messageServiceMock, times(1)).findById(1);

	}
	
	
	//findByBookGroup
	@Test
	void test_message_findByBookGroup_calls_service_once_returns_message_array() {
		
		MessageController messageController = new MessageController(messageServiceMock);

		List<Message> messages = new ArrayList<>();
		messages.add(new Message());
		messages.add(new Message());
		messages.add(new Message());
				
		when(messageServiceMock.findByBookGroup(1)).thenReturn(messages);
		
		assertEquals(messages, messageController.findByBookGroup(1));

		verify(messageServiceMock, times(1)).findByBookGroup(1);
		
	}
	
	
	//createNewMessage
	@Test
	void test_message_create_calls_service_once() {
		
		MessageController messageController = new MessageController(messageServiceMock);

		Message message = new Message();
		
		messageController.createNewMessage(message);
		
		verify(messageServiceMock, times(1)).saveMessage(message);
		
	}
	
	//updateMessage
	@Test
	void test_message_update_calls_service_once() {
		
		MessageController messageController = new MessageController(messageServiceMock);

		Message message = new Message();
		
		messageController.updateMessage(message);
		
		verify(messageServiceMock, times(1)).updateMessage(message);
		
	}
	
	
	//deleteMessage
	@Test
	void test_message_delete_calls_service_once() {
		
		MessageController messageController = new MessageController(messageServiceMock);
		
		messageController.deleteMessage(1);
		
		verify(messageServiceMock, times(1)).deleteById(1);
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                                UserController                             //
	///////////////////////////////////////////////////////////////////////////////
	
	UserController userController;
	
	@Mock
	UserService userServiceMock;
	
	//firstEndPoint
	@Test
	void test_user_firstEndPoint_calls_service_once_produces_empty_array() {
		
		UserController userController = new UserController(userServiceMock);
		
		assertNotNull(userServiceMock);
		
		when(userServiceMock.findAll()).thenReturn(null);
		
		List<User> users = userController.firstEndPoint();
		
		assertNull(users);
		
		verify(userServiceMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_user_firstEndPoint_returns_array(){
	
		UserController userController = new UserController(userServiceMock);
		
		List<User> users = new ArrayList<>();
		
		when(userServiceMock.findAll()).thenReturn(users);
		
		assertEquals(users, userController.firstEndPoint());
		
		verify(userServiceMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_user_findById_calls_service_once() {
		
		UserController userController = new UserController(userServiceMock);

		User user = new User();
		
		when(userServiceMock.findById(1)).thenReturn(user);
		
		assertEquals(user, userController.findById(1));

		verify(userServiceMock, times(1)).findById(1);

	}
	
	//findByBookGroup
	@Test
	void test_user_findByBookGroup_calls_service_once_returns_string_array() {
		
		UserController userController = new UserController(userServiceMock);

		List<String> users = new ArrayList<>();

				
		when(userServiceMock.findByBookGroup(1)).thenReturn(users);
		
		assertEquals(users, userController.findByBookGroup(1));

		verify(userServiceMock, times(1)).findByBookGroup(1);
		
	}
	
	//findByUsername
	@Test
	void test_user_findByUser_calls_service_once_returns_user() {
		
		UserController userController = new UserController(userServiceMock);

		User user = new User();

		when(userServiceMock.findByUsername("username")).thenReturn(user);
		
		assertEquals(user, userController.findByUsername("username"));

		verify(userServiceMock, times(1)).findByUsername("username");
		
	}
	
	//findUserBookGroup
	@Test
	void test_user_findUserBookGroup_calls_service_once_return_bookGroup() {
		
		UserController userController = new UserController(userServiceMock);
		
		BookGroup bookGroup = new BookGroup();
		
		when(userServiceMock.findUserBookGroup(1)).thenReturn(bookGroup);
		
		assertEquals(bookGroup, userController.findUserBookGroup(1));
		
		verify(userServiceMock, times(1)).findUserBookGroup(1);
		
		
	}
	
	//checkUniqueUsername
	@Test
	void test_user_checkUniqueUsername_calls_service_once() {
		
		UserController userController = new UserController(userServiceMock);
				
		userController.checkUniqueUsername("username");
		
		verify(userServiceMock, times(1)).checkUnique("username");
		
	}	
	
	//createNewUser
	@Test
	void test_user_create_calls_service_once() {
		
		UserController userController = new UserController(userServiceMock);

		User user = new User();
		
		userController.createNewUser(user);
		
		verify(userServiceMock, times(1)).register(user);
		
	}

	//updateUser
	@Test
	void test_user_update_calls_service_once() {
		
		UserController userController = new UserController(userServiceMock);

		User user = new User();
		
		userController.updateUser(user);
		
		verify(userServiceMock, times(1)).updateUser(user);
		
	}
	
	
	//deleteUser
	@Test
	void test_user_delete_calls_service_once() {
		
		UserController userController = new UserController(userServiceMock);
		
		userController.deleteUser(1);
		
		verify(userServiceMock, times(1)).deleteById(1);
		
	}

	
	
}
	
	
