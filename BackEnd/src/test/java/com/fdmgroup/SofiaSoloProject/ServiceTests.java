package com.fdmgroup.SofiaSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fdmgroup.SofiaSoloProject.dal.AssignedBookRepository;
import com.fdmgroup.SofiaSoloProject.dal.AuthorRepository;
import com.fdmgroup.SofiaSoloProject.dal.BookGroupRepository;
import com.fdmgroup.SofiaSoloProject.dal.BookRepository;
import com.fdmgroup.SofiaSoloProject.dal.LocationRepository;
import com.fdmgroup.SofiaSoloProject.dal.MeetingRepository;
import com.fdmgroup.SofiaSoloProject.dal.MessageRepository;
import com.fdmgroup.SofiaSoloProject.dal.UserRepository;
import com.fdmgroup.SofiaSoloProject.dal.GenreRepository;
import com.fdmgroup.SofiaSoloProject.exceptions.NotAllowedException;
import com.fdmgroup.SofiaSoloProject.exceptions.NotFoundException;
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
public class ServiceTests {
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                             AssignmentService                             //
	///////////////////////////////////////////////////////////////////////////////
	
	AssignmentService assignmentService;
	
	@Mock
	AssignedBookRepository assignedBookRepoMock;
	
	
	// findAll()
	
	@Test
	void test_assignment_find_all_returns_null_if_empty() {
		
		assignmentService = new AssignmentService(assignedBookRepoMock);
		
		assertNotNull(assignedBookRepoMock);
		
		when(assignedBookRepoMock.findAll()).thenReturn(null);
		
		List<AssignedBook> assignment = assignmentService.findAll();
		
		assertNull(assignment);
		
		verify(assignedBookRepoMock, times(1)).findAll();
		
	}
	
	@Test
	void test_assignment_find_all_returns_list_if_not_empty() {
		
		assignmentService = new AssignmentService(assignedBookRepoMock);
		
		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		
		when(assignedBookRepoMock.findAll()).thenReturn(assignments);
		
		assertEquals(assignments, assignmentService.findAll());
		
		verify(assignedBookRepoMock, times(1)).findAll();
		
	}

	
	//findByBookGroupId
	
	@Test
	void test_assignment_findByBookGroupId_calls_repo_once_and_return_array() {
		
		assignmentService = new AssignmentService(assignedBookRepoMock);

		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		
		when(assignedBookRepoMock.findBybookGroupId(1)).thenReturn(assignments);
		
		assertEquals(assignments, assignmentService.findBybookGroupId(1));
		
		verify(assignedBookRepoMock, times(1)).findBybookGroupId(1);
		
	}
	
	
	//findCurrent
	
	@Test
	void test_assignment_findCurrent_calls_repo_once_and_returns_single_assignment() {
		
		assignmentService = new AssignmentService(assignedBookRepoMock);

		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		
		when(assignedBookRepoMock.findCurrent(1)).thenReturn((List<AssignedBook>) assignments.get(2));
		
		assertEquals(assignments.get(2), assignmentService.findCurrent(1));
		
		verify(assignedBookRepoMock, times(1)).findCurrent(1);
		
	}
	
	
	//findById

	@Test
	void test_assignment_findById_throws_exception_id_not_found() throws Exception {
		
		assignmentService = new AssignmentService(assignedBookRepoMock);

		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		
		Exception exception = null;
		
		try {
			
			assignmentService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_assignment_findById_calls_repo_once_and_returns_single_assignment() {
		
		assignmentService = new AssignmentService(assignedBookRepoMock);
		Optional<AssignedBook> as1 = Optional.of(new AssignedBook());
		
		doReturn(as1).when(assignedBookRepoMock).findById(1);
		
		assertEquals(as1, assignmentService.findById(1));
		
		verify(assignedBookRepoMock, times(1)).findById(1);
		
	}
	

	//saveAssignment
	@Test
	void test_assignment_save_calls_repo_once() {
		
		assignmentService = new AssignmentService(assignedBookRepoMock);

		AssignedBook as1 = new AssignedBook();

		assignmentService.saveAssignment(as1);
		
		verify(assignedBookRepoMock, times(1)).save(as1);
		
	}
	
	//updateAssignment
	@Test
	void test_assignment_update_throws_exception(){
		
		assignmentService = new AssignmentService(assignedBookRepoMock);
		
		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		
		Exception exception = null;
		
		try {
			
			assignmentService.updateAssignment(assignments.get(0));
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	//deleteAssignment
	@Test
	void test_assignment_delete_throws_exception(){
		
		
		assignmentService = new AssignmentService(assignedBookRepoMock);

		List<AssignedBook> assignments = new ArrayList<>();
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		assignments.add(new AssignedBook());
		
		Exception exception = null;
		
		try {
			
			assignmentService.deleteById(1);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                               AuthorService                               //
	///////////////////////////////////////////////////////////////////////////////
	
	AuthorService authorService;
	
	@Mock
	AuthorRepository authorRepositoryMock;
	
	
	// findAll()
	
	@Test
	void test_author_find_all_returns_null_if_empty() {
		
		authorService = new AuthorService(authorRepositoryMock);
		
		assertNotNull(authorRepositoryMock);
		
		when(authorRepositoryMock.findAll()).thenReturn(null);
		
		List<Author> authors = authorService.findAll();
		
		assertNull(authors);
		
		verify(authorRepositoryMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_author_find_all_returns_list_if_not_empty() {
		
		authorService = new AuthorService(authorRepositoryMock);
		
		List<Author> authors = new ArrayList<>();
		authors.add(new Author());
		authors.add(new Author());
		authors.add(new Author());
		
		when(authorRepositoryMock.findAll()).thenReturn(authors);
		
		assertEquals(authors, authorService.findAll());
		
		verify(authorRepositoryMock, times(1)).findAll();
		
	}
	
	//findById
	
	@Test
	void test_author_find_by_id_throws_exception() {
		
		authorService = new AuthorService(authorRepositoryMock);

		List<Author> authors = new ArrayList<>();
		authors.add(new Author());
		authors.add(new Author());
		authors.add(new Author());
		
		Exception exception = null;
		
		try {
			
			authorService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_author_find_by_id_returns_author() {
		
		authorService = new AuthorService(authorRepositoryMock);

		Optional<Author> author = Optional.of(new Author(1, "Mary", "Shelly"));
		
		when(authorRepositoryMock.findById(1)).thenReturn(author);
		
		authorService.findById(1);
		
		verify(authorRepositoryMock, times(1)).findById(1);
	}
	
	
	//saveAuthor
	@Test
	void test_author_save_calls_repo_once() {
		
		authorService = new AuthorService(authorRepositoryMock);
		
		Author author = new Author(1, "Mary", "Shelly");

		authorService.saveAuthor(author);
		
		verify(authorRepositoryMock, times(1)).save(author);
		
	}
	
	//updateAuthor
	@Test
	void test_author_update_throws_exception() {
		
		authorService = new AuthorService(authorRepositoryMock);

		Author author = new Author(1, "Mary", "Shelly");
		
		Exception exception = null;
		
		try {
			
			authorService.updateAuthor(author);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	//deleteAuthor
	@Test
	void test_author_delete_calls_repository_once() {
		
		authorService = new AuthorService(authorRepositoryMock);

		authorService.deleteById(1);
		
		verify(authorRepositoryMock, times(1)).deleteById(1);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                            BookGroupService                               //
	///////////////////////////////////////////////////////////////////////////////
	
	BookGroupService bookGroupService;
	Genre genre;
	Location location;
	
	@Mock
	BookGroupRepository bookGroupRepositoryMock;
	
	// findAll()
	@Test
	void test_bookGroup_find_all_returns_null_if_empty() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		assertNotNull(bookGroupRepositoryMock);
		
		when(bookGroupRepositoryMock.findAll()).thenReturn(null);
		
		List<BookGroup> bookGroups = bookGroupService.findAll();
		
		assertNull(bookGroups);
		
		verify(bookGroupRepositoryMock, times(1)).findAll();
		
	}
	
	
	@Test
	void test_bookGroup_find_all_returns_list_if_not_empty() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());

		
		when(bookGroupRepositoryMock.findAll()).thenReturn(bookGroups);
		
		assertEquals(bookGroups, bookGroupService.findAll());
		
		verify(bookGroupRepositoryMock, times(1)).findAll();
		
	}
	
	
	//findById
	@Test
	void test_bookGroup_find_by_id_throws_exception() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);

		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());
		bookGroups.add(new BookGroup());
		
		Exception exception = null;
		
		try {
			
			bookGroupService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_bookGroup_find_by_id_returns_bookGroup() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);

		BookGroup bookGroup = new BookGroup(5);
		
		when(bookGroupRepositoryMock.existsById(1)).thenReturn(true);
		when(bookGroupRepositoryMock.findById(1)).thenReturn(bookGroup);
		
		assertEquals(bookGroup, bookGroupService.findById(1));
		
		verify(bookGroupRepositoryMock, times(1)).findById(1);
	}
	
	
	 //findGenreAvailable
	@Test
	void test_bookGroup_findGenreAvailable_called_once() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		Genre genre = new Genre("Sci-fi");
		genre.setId(1);
		
		BookGroup bookGroup = new BookGroup(5);
		
		bookGroup.setGenre(genre);
		
		bookGroupService.findGenreAvailable(1);
		
		verify(bookGroupRepositoryMock, times(1)).findGenreAvailable(1);
		
	}
	

	 //findSpecificAvailable
	@Test
	void test_bookGroup_findSpecificAvailable_called_once() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		Genre genre = new Genre("Sci-fi");
		genre.setId(1);
		
		Location location = new Location("North");
		location.setId(1);
		
		BookGroup bookGroup = new BookGroup(5);
		bookGroup.setLocation(location);
		bookGroup.setGenre(genre);
		
		bookGroupService.findSpecificAvailable(1,1);
		
		verify(bookGroupRepositoryMock, times(1)).findSpecificAvailable(1,1);
		
	}
	
	
	//chooseGroup
	@Test
	void test_bookGroup_specific_exists_returns_specific() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		BookGroup bookGroup = new BookGroup(5);
		BookGroup bookGroup2 = new BookGroup(3);
		
		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(bookGroup);
		bookGroups.add(bookGroup2);
		
		when(bookGroupRepositoryMock.findSpecificAvailable(1, 1)).thenReturn(bookGroups);
		
		assertEquals(bookGroups, bookGroupService.chooseGroup(1, 1));
		
		verify(bookGroupRepositoryMock, times(1)).findSpecificAvailable(1,1);
		
	}
	
	@Test
	void test_bookGroup_goes_to_genre() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		BookGroup bookGroup = new BookGroup(5);
		BookGroup bookGroup2 = new BookGroup(3);
		
		List<BookGroup> bookGroupsEmpty = new ArrayList<>();
		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(bookGroup);
		bookGroups.add(bookGroup2);
		
		when(bookGroupRepositoryMock.findSpecificAvailable(1, 1)).thenReturn(bookGroupsEmpty);
		when(bookGroupRepositoryMock.findGenreAvailable(1)).thenReturn(bookGroups);
		
		assertEquals(bookGroups, bookGroupService.chooseGroup(1, 1));
		
		verify(bookGroupRepositoryMock, times(1)).findSpecificAvailable(1,1);
		verify(bookGroupRepositoryMock, times(1)).findGenreAvailable(1);
		
	}
	
	@Test
	void test_bookGroup_goes_to_any() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		BookGroup bookGroup = new BookGroup(5);
		BookGroup bookGroup2 = new BookGroup(3);
		
		List<BookGroup> bookGroupsEmpty = new ArrayList<>();
		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(bookGroup);
		bookGroups.add(bookGroup2);
		
		when(bookGroupRepositoryMock.findSpecificAvailable(1, 1)).thenReturn(bookGroupsEmpty);
		when(bookGroupRepositoryMock.findGenreAvailable(1)).thenReturn(bookGroupsEmpty);
		when(bookGroupRepositoryMock.findAny()).thenReturn(bookGroups);
		
		assertEquals(bookGroups, bookGroupService.chooseGroup(1, 1));
		
		verify(bookGroupRepositoryMock, times(1)).findSpecificAvailable(1,1);
		verify(bookGroupRepositoryMock, times(1)).findGenreAvailable(1);
		verify(bookGroupRepositoryMock, times(1)).findAny();
		
	}
	
	@Test
	void test_bookGroup_goes_to_message() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		BookGroup bookGroup = new BookGroup(5);
		BookGroup bookGroup2 = new BookGroup(3);
		
		List<BookGroup> bookGroupsEmpty = new ArrayList<>();
		List<BookGroup> bookGroups = new ArrayList<>();
		bookGroups.add(bookGroup);
		bookGroups.add(bookGroup2);
		
		when(bookGroupRepositoryMock.findSpecificAvailable(1, 1)).thenReturn(bookGroupsEmpty);
		when(bookGroupRepositoryMock.findGenreAvailable(1)).thenReturn(bookGroupsEmpty);
		when(bookGroupRepositoryMock.findAny()).thenReturn(bookGroupsEmpty);
		
		assertEquals(bookGroupsEmpty, bookGroupService.chooseGroup(1, 1));
		
		verify(bookGroupRepositoryMock, times(1)).findSpecificAvailable(1,1);
		verify(bookGroupRepositoryMock, times(1)).findGenreAvailable(1);
		verify(bookGroupRepositoryMock, times(1)).findAny();
		
	}
	
	//saveBookGroup
	@Test
	void test_bookGroup_save_calls_repo_once() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		BookGroup bookGroup = new BookGroup(5);

		bookGroupService.saveBookGroup(bookGroup);
		
		verify(bookGroupRepositoryMock, times(1)).save(bookGroup);
		
	}
	
	//updateBookGroup
	@Test
	void test_bookGroup_update_calls_save() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);

		BookGroup bookGroup = new BookGroup(5);
		
		when(bookGroupRepositoryMock.existsById(0)).thenReturn(true);
		
		bookGroupService.updateBookGroup(bookGroup);
		
		verify(bookGroupRepositoryMock, times(1)).save(bookGroup);
		
	}
	
	@Test
	void test_bookGroup_update_throws_error() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);

		BookGroup bookGroup2 = new BookGroup(3); //will not count because no id
		
		Exception exception = null;
		
		try {
			
			bookGroupService.updateBookGroup(bookGroup2);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	
	//deleteById
	@Test
	void test_bookGroup_delete_calls_repository_once() {
		
		bookGroupService = new BookGroupService(bookGroupRepositoryMock);
		
		BookGroup bookGroup = new BookGroup(5);
		bookGroup.setId(1);

		bookGroupService.deleteById(1);
		
		verify(bookGroupRepositoryMock, times(1)).deleteById(1);
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                               GenreService                                //
	///////////////////////////////////////////////////////////////////////////////
	
	GenreService genreService;
	
	@Mock
	GenreRepository genreRepositoryMock;
	
	// findAll()
	@Test
	void test_genre_find_all_returns_null_if_empty() {
		
		genreService = new GenreService(genreRepositoryMock);
		
		assertNotNull(genreRepositoryMock);
		
		when(genreRepositoryMock.findAll()).thenReturn(null);
		
		List<Genre> genres = genreService.findAll();
		
		assertNull(genres);
		
		verify(genreRepositoryMock, times(1)).findAll();
		
	}
	
	@Test
	void test_genre_find_all_returns_list_if_not_empty() {
		
		genreService = new GenreService(genreRepositoryMock);
		
		List<Genre> genres = new ArrayList<>();
		genres.add(new Genre());
		genres.add(new Genre());
		genres.add(new Genre());
		
		when(genreRepositoryMock.findAll()).thenReturn(genres);
		
		assertEquals(genres, genreService.findAll());
		
		verify(genreRepositoryMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_genre_find_by_id_throws_exception() {
		
		genreService = new GenreService(genreRepositoryMock);

		List<Genre> genres = new ArrayList<>();
		genres.add(new Genre());
		genres.add(new Genre());
		genres.add(new Genre());
		
		Exception exception = null;
		
		try {
			
			genreService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_genre_find_by_id_returns_genre() {
		
		genreService = new GenreService(genreRepositoryMock);
		
		Genre genre = new Genre();
		
		when(genreRepositoryMock.existsById(1)).thenReturn(true);
		when(genreRepositoryMock.findById(1)).thenReturn(genre);
		
		genreService.findById(1);
		
		verify(genreRepositoryMock, times(1)).findById(1);
	}
	
	
	//saveBookGroup
	@Test
	void test_genre_save_calls_repo_once() {
		
		genreService = new GenreService(genreRepositoryMock);
		
		Genre genre = new Genre();

		genreService.saveGenre(genre);
		
		verify(genreRepositoryMock, times(1)).save(genre);
		
	}
	
	
	//updateGenre
	@Test
	void test_genre_update_throws_exception() {
		
		genreService = new GenreService(genreRepositoryMock);

		Genre genre = new Genre();
		
		Exception exception = null;
		
		try {
			
			genreService.updateGenre(genre);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_genre_update_returns_genre() {
		
		genreService = new GenreService(genreRepositoryMock);
		
		Genre genre = new Genre();

		genre.setId(1);
		
		when(genreRepositoryMock.existsById(1)).thenReturn(true);
		
		genreService.updateGenre(genre);
		
		verify(genreRepositoryMock, times(1)).save(genre);
	}
	
	
	//deleteById
	@Test
	void test_genre_delete_calls_repository_once() {
		
		genreService = new GenreService(genreRepositoryMock);
		
		Genre genre = new Genre();

		genre.setId(1);

		genreService.deleteById(1);
		
		verify(genreRepositoryMock, times(1)).deleteById(1);
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                             LocationService                               //
	///////////////////////////////////////////////////////////////////////////////
	
	LocationService locationService;
	
	@Mock
	LocationRepository locationRepositoryMock;
	
	// findAll()
	@Test
	void test_location_find_all_returns_null_if_empty() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		assertNotNull(locationRepositoryMock);
		
		when(locationRepositoryMock.findAll()).thenReturn(null);
		
		List<Location> locations = locationService.findAll();
		
		assertNull(locations);
		
		verify(locationRepositoryMock, times(1)).findAll();
		
	}
	
	@Test
	void test_location_find_all_returns_list_if_not_empty() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		List<Location> locations = new ArrayList<>();
		locations.add(new Location());
		locations.add(new Location());
		locations.add(new Location());
		
		when(locationRepositoryMock.findAll()).thenReturn(locations);
		
		assertEquals(locations, locationService.findAll());
		
		verify(locationRepositoryMock, times(1)).findAll();
		
	}
	
	//findById
	@Test
	void test_location_find_by_id_throws_exception() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		List<Location> locations = new ArrayList<>();
		locations.add(new Location());
		locations.add(new Location());
		locations.add(new Location());
		
		Exception exception = null;
		
		try {
			
			locationService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_location_find_by_id_returns_location() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		Location location = new Location();
		
		when(locationRepositoryMock.existsById(1)).thenReturn(true);
		when(locationRepositoryMock.findById(1)).thenReturn(location);
		
		locationService.findById(1);
		
		verify(locationRepositoryMock, times(1)).findById(1);
	}
	
	
	//saveLocation
	@Test
	void test_location_save_calls_repo_once() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		Location location = new Location();

		locationService.saveLocation(location);
		
		verify(locationRepositoryMock, times(1)).save(location);
		
	}
	
	//updateLocation
	@Test
	void test_location_update_throws_exception() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		Location location = new Location();
		
		Exception exception = null;
		
		try {
			
			locationService.updateLocation(location);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_location_update_returns_genre() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		Location location = new Location();

		location.setId(1);
		
		when(locationRepositoryMock.existsById(1)).thenReturn(true);
		
		locationService.updateLocation(location);
		
		verify(locationRepositoryMock, times(1)).save(location);
	}
	
	//deleteById
	@Test
	void test_location_delete_calls_repository_once() {
		
		locationService = new LocationService(locationRepositoryMock);
		
		Location location = new Location();
		
		location.setId(1);
		
		Exception exception = null;
		
		try {
			
			locationService.deleteById(1);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                              MeetingService                               //
	///////////////////////////////////////////////////////////////////////////////
	
	
	MeetingService meetingService;
	
	@Mock
	MeetingRepository meetingRepositoryMock; 
	
	
	// findAll()
	@Test
	void test_meeting_find_all_returns_null_if_empty() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		assertNotNull(meetingRepositoryMock);
		
		when(meetingRepositoryMock.findAll()).thenReturn(null);
		
		List<Meeting> meetings = meetingService.findAll();
		
		assertNull(meetings);
		
		verify(meetingRepositoryMock, times(1)).findAll();
		
	}
	
	@Test
	void test_meeting_find_all_returns_list_if_not_empty() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		List<Meeting> meetings = new ArrayList<>();
		
		meetings.add(new Meeting());
		
		when(meetingRepositoryMock.findAll()).thenReturn(meetings);
		
		assertEquals(meetings, meetingService.findAll());
		
		verify(meetingRepositoryMock, times(1)).findAll();
		
	}
	
	
	//findByBookGroup
	@Test
	void test_meeting_findByBookGroup_calls_repo_once() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Meeting meeting = new Meeting();
		BookGroup bookgroup = new BookGroup();
		bookgroup.setId(1);
		
		meeting.setBookGroup(bookgroup);
		
		List<Meeting> meetings = new ArrayList<>();
		
		meetings.add(meeting);
		
		when(meetingRepositoryMock.findByBookGroupId(1)).thenReturn(meetings);
		
		assertEquals(meetings, meetingService.findByBookGroup(1));
		
		verify(meetingRepositoryMock, times(1)).findByBookGroupId(1);
		
	}
	
	
	//findNext
	@Test
	void test_meeting_findNext_calls_repo_once() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Meeting meeting = new Meeting();
		BookGroup bookgroup = new BookGroup();
		bookgroup.setId(1);
		
		meeting.setBookGroup(bookgroup);
		
		when(meetingRepositoryMock.findUpComing(1)).thenReturn(meeting);
		
		assertEquals(meeting, meetingService.findNext(1));
		
		verify(meetingRepositoryMock, times(1)).findUpComing(1);
		
	}
	
	
	//findById
	@Test
	void test_meeting_findById_throws_exception() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		List<Meeting> meetings = new ArrayList<>();
		meetings.add(new Meeting());
		meetings.add(new Meeting());
		meetings.add(new Meeting());

		Exception exception = null;
		
		try {
			
			meetingService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_meeting_find_by_id_returns_meeting() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Optional<Meeting> meeting = Optional.of(new Meeting(Timestamp.valueOf("2023-06-03 15:00:00")));
		
		when(meetingRepositoryMock.findById(1)).thenReturn(meeting);

		meetingService.findById(1);
		
		verify(meetingRepositoryMock, times(1)).findById(1);
		
	}
	
	//saveMeeting
	@Test
	void test_meeting_save_calls_repo_once() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Meeting meeting = new Meeting();

		meetingService.saveMeeting(meeting);
		
		verify(meetingRepositoryMock, times(1)).save(meeting);
		
	}
	
	
	//updateMeeting
	@Test
	void test_meeting_update_throws_NotFoundException() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Meeting meeting = new Meeting();
		
		Exception exception = null;
		
		try {
			
			meetingService.updateMeeting(meeting);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_meeting_throws_notAllowed_exception_for_past_meeting() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Meeting meeting = new Meeting(Timestamp.valueOf("2023-06-03 15:00:00"));
		
		when(meetingRepositoryMock.existsById(1)).thenReturn(true);
		
		Exception exception = null;
		
		try {
			
			meetingService.updateMeeting(meeting);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_meeting_update_calls_repo_once_for_valid_meeting() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Meeting meeting = new Meeting(Timestamp.valueOf("2024-06-03 15:00:00"));

		when(meetingRepositoryMock.existsById(1)).thenReturn(true);
		
		meetingService.updateMeeting(meeting);
		
		verify(meetingRepositoryMock, times(1)).save(meeting);
		
	}
	
	//deleteById
	@Test
	void test_meeting_delete_throws_notAllowedException_for_past_meeting() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Optional<Meeting> meeting = Optional.of(new Meeting(Timestamp.valueOf("2023-06-03 15:00:00")));
				
		when(meetingRepositoryMock.findById(1)).thenReturn(meeting);
		
		Exception exception = null;
		
		try {
			
			meetingService.deleteById(1);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
	}
	
	@Test
	void test_meeting_delete_calls_repo_twice_for_valid_meeting() {
		
		meetingService = new MeetingService(meetingRepositoryMock);
		
		Optional<Meeting> meeting = Optional.of(new Meeting(Timestamp.valueOf("2024-06-03 15:00:00")));
		
		when(meetingRepositoryMock.findById(1)).thenReturn(meeting);
		
		meetingService.deleteById(1);
		
		verify(meetingRepositoryMock, times(1)).deleteById(1);

	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                              MessageService                               //
	///////////////////////////////////////////////////////////////////////////////
	
	MessageService messageService;
	
	@Mock
	MessageRepository messageRepositoryMock;
	
	
	// findAll()
	@Test
	void test_message_find_all_returns_null_if_empty() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		assertNotNull(messageRepositoryMock);
		
		when(messageRepositoryMock.findAll()).thenReturn(null);
		
		List<Message> messages = messageService.findAll();
		
		assertNull(messages);
		
		verify(messageRepositoryMock, times(1)).findAll();
		
	}
	
	@Test
	void test_message_find_all_returns_list_if_not_empty() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		List<Message> messages = new ArrayList<>();
		
		messages.add(new Message());
		
		when(messageRepositoryMock.findAll()).thenReturn(messages);
		
		assertEquals(messages, messageService.findAll());
		
		verify(messageRepositoryMock, times(1)).findAll();
		
	}
	
	
	//findByBookGroup
	@Test
	void test_message_findByBookGroup_returns_empty_array_prints_to_console() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		List<Message> messages = new ArrayList<>();
		
		when(messageRepositoryMock.findBybookGroupId(1)).thenReturn(messages);
		
		assertEquals(messages, messageService.findByBookGroup(1));
		
		verify(messageRepositoryMock, times(2)).findBybookGroupId(1);
		
	}
	
	@Test
	void test_message_findByBookGroup_returns_array() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		List<Message> messages = new ArrayList<>();
		messages.add(new Message());
		messages.add(new Message());
		messages.add(new Message());
		
		when(messageRepositoryMock.findBybookGroupId(1)).thenReturn(messages);
		
		assertEquals(messages, messageService.findByBookGroup(1));
		
		verify(messageRepositoryMock, times(2)).findBybookGroupId(1);
		
	}
	
	//findById
	@Test
	void test_message_findById_throws_exception() {
		
		messageService = new MessageService(messageRepositoryMock);
				
		Exception exception = null;
		
		try {
			
			messageService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_message_find_by_id_returns_message() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		Optional<Message> message = Optional.of(new Message());
		
		when(messageRepositoryMock.findById(1)).thenReturn(message);

		messageService.findById(1);
		
		verify(messageRepositoryMock, times(1)).findById(1);
		
	}
	
	//saveMessage
	@Test
	void test_message_save_calls_repo_once() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		Message message = new Message();

		messageService.saveMessage(message);
		
		verify(messageRepositoryMock, times(1)).save(message);
		
	}
	
	
	//updateMessage
	@Test
	void test_message_update_throws_notAllowedException() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		Message message = new Message("This book is fantastic!", Timestamp.valueOf("2023-11-14 20:54:39"));
		
		message.setId(1);
		
		Exception exception = null;
		
		when(messageRepositoryMock.existsById(1)).thenReturn(true);
		
		try {
			
			messageService.updateMessage(message);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_message_update_throws_notFoundException() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		Message message = new Message("This book is fantastic!", Timestamp.valueOf("2023-11-14 20:54:39"));
		
		Exception exception = null;
		
		try {
			
			messageService.updateMessage(message);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	
	//deleteById
	@Test
	void test_messages_delete_throws_notAllowedException() {
		
		messageService = new MessageService(messageRepositoryMock);
		
		Message message = new Message();
		message.setId(1);
		
		Exception exception = null;
		
		
		try {
			
			messageService.deleteById(1);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                                UserService                                //
	///////////////////////////////////////////////////////////////////////////////
	
	UserService userService;
	
	@Mock
	UserRepository userRepositoryMock;
	
	@Mock
	PasswordEncoder passwordEncoderMock;
	
	// findAll()
	@Test
	void test_user_find_all_returns_null_if_empty() {
		
		userService = new UserService(userRepositoryMock, null, null);
		
		assertNotNull(userRepositoryMock);
		
		when(userRepositoryMock.findAll()).thenReturn(null);
		
		List<User> users = userService.findAll();
		
		assertNull(users);
		
		verify(userRepositoryMock, times(1)).findAll();
		
	}
	
	@Test
	void test_user_find_all_returns_list_if_not_empty() {
		
		userService = new UserService(userRepositoryMock, null, null);
		
		List<User> users = new ArrayList<>();
		
		users.add(new User());
		
		when(userRepositoryMock.findAll()).thenReturn(users);
		
		assertEquals(users, userService.findAll());
		
		verify(userRepositoryMock, times(1)).findAll();
		
	}
	
	//findByBookGroup
	@Test
	void test_user_findByBookGroup_calls_repo_once() {
		
		userService = new UserService(userRepositoryMock, null, null);
		
		List<String> users = new ArrayList<>();
		users.add("username");
		users.add("username");
		users.add("username");
		
		when(userRepositoryMock.findBybookGroup(1)).thenReturn(users);
		
		assertEquals(users, userService.findByBookGroup(1));
		
		verify(userRepositoryMock, times(1)).findBybookGroup(1);
		
	}
	
	//findCompatible
	@Test
	void test_user_findCompatible_throws_notFoundException_from_genre() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, null);
		
		Exception exception = null;
		
		try {
			
			userService.findCompatible(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_user_fidCompatible_calls_user_repo_once_for_valid_genre() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, null);
		
		List<User> users = new ArrayList<>();
		
		users.add(new User());
		
		when(genreRepositoryMock.existsById(1)).thenReturn(true);
		
		when(userRepositoryMock.findCompatible(1)).thenReturn(users);
		
		assertEquals(users, userService.findCompatible(1));
		
		verify(userRepositoryMock, times(1)).findCompatible(1);
		
	}
	
	//findByUsername
	@Test
	void test_user_findByUsername_calls_repo_once() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, null);

		User user = new User();
		user.setUsername("username");
		
		when(userRepositoryMock.findByUsername("username")).thenReturn(user);
		
		assertEquals(user, userService.findByUsername("username"));
		
		verify(userRepositoryMock, times(1)).findByUsername("username");
		
	}
	
	
	//findById
	@Test
	void test_user_findById_throws_exception() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, null);
		
		Exception exception = null;
		
		try {
			
			userService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_user_find_by_id_returns_user() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, null);
		
		Optional<User> user = Optional.of(new User());
		
		when(userRepositoryMock.findById(1)).thenReturn(user);

		userService.findById(1);
		
		verify(userRepositoryMock, times(1)).findById(1);
		
	}
	
	
	//saveUser
	@Test
	void test_user_save_calls_repo_once() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, null);
		
		User user = new User();

		userService.saveUser(user);
		
		verify(userRepositoryMock, times(1)).save(user);
		
	}
	
	
	//register
	@Test
	void test_user_register_calls_repo_once() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, passwordEncoderMock);
		
		User user = new User();

		userService.register(user);
		
		verify(userRepositoryMock, times(1)).save(user);
		
	}
	
	//updateUser
	@Test
	void test_user_update_throws_notFoundException() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, passwordEncoderMock);
		
		User user = new User();
		user.setId(1);
		
		when(userRepositoryMock.existsById(1)).thenReturn(false);
		
		Exception exception = null;
		
		try {
			
			userService.updateUser(user);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_user_calls_repo_once_for_existing_user() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, passwordEncoderMock);
		
		User user = new User();
		
		when(userRepositoryMock.existsById(0)).thenReturn(true);
		
		userService.updateUser(user);
		
		verify(userRepositoryMock, times(1)).save(user);
	}
	
	
	//deleteById
	@Test
	void test_user_delete_calls_repo_once() {
		
		userService = new UserService(userRepositoryMock, genreRepositoryMock, passwordEncoderMock);
		
		User user = new User();
		user.setId(1);
		
		userService.deleteById(1);
		
		verify(userRepositoryMock, times(1)).deleteById(1);
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//                                 BookService                               //
	///////////////////////////////////////////////////////////////////////////////
	
	
	BookService bookService;
	
	@Mock
	BookRepository bookRepositoryMock;
	
	// findAll()
	@Test
	void test_book_find_all_returns_null_if_empty() {
		
		bookService = new BookService(bookRepositoryMock);
		
		assertNotNull(bookRepositoryMock);
		
		when(bookRepositoryMock.findAll()).thenReturn(null);
		
		List<Book> books = bookService.findAll();
		
		assertNull(books);
		
		verify(bookRepositoryMock, times(1)).findAll();
		
	}
	
	@Test
	void test_book_find_all_returns_list_if_not_empty() {
		
		bookService = new BookService(bookRepositoryMock);
		
		List<Book> books = new ArrayList<>();		
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		
		when(bookRepositoryMock.findAll()).thenReturn(books);
		
		assertEquals(books, bookService.findAll());
		
		verify(bookRepositoryMock, times(1)).findAll();
		
	}
	
	//findAllAuthor
	@Test
	void test_book_throws_NotFoundException() {
		
		bookService = new BookService(bookRepositoryMock);
		
		Exception exception = null;
		
		try {
			
			bookService.findAllAuthor("Pullman");
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_book_findAllAuthor_calls_repo_twice_for_valid_author() {
		
		bookService = new BookService(bookRepositoryMock);
		
		List<Book> books = new ArrayList<>();		
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		
		when(bookRepositoryMock.findByauthorName("Pullman")).thenReturn(books);
		
		assertEquals(books, bookService.findAllAuthor("Pullman"));
		
		verify(bookRepositoryMock, times(2)).findByauthorName("Pullman");
		
	}
	
	//findByTitle
	@Test
	void test_book_findByTitle_throws_NotFoundException() {
		
		bookService = new BookService(bookRepositoryMock);
		
		Exception exception = null;
		
		try {
			
			bookService.findBytitle("The Overstory");
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_book_findByTitle_calls_repo_twice_for_valid_author() {
		
		bookService = new BookService(bookRepositoryMock);
		
		List<Book> books = new ArrayList<>();		
		books.add(new Book());
		books.add(new Book());
		
		when(bookRepositoryMock.findPartialMatch("The Overstory")).thenReturn(books);
		
		assertEquals(books, bookService.findBytitle("The Overstory"));
		
		verify(bookRepositoryMock, times(2)).findPartialMatch("The Overstory");
		
	}
	
	
	//findById
	@Test
	void test_book_findById_throws_exception() {
		
		bookService = new BookService(bookRepositoryMock);
		
		Exception exception = null;
		
		try {
			
			bookService.findById(1);
		
		}catch(NotFoundException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	@Test
	void test_book_find_by_id_returns_book() {
		
		bookService = new BookService(bookRepositoryMock);
		
		Optional<Book> book = Optional.of(new Book());
		
		when(bookRepositoryMock.findById(1)).thenReturn(book);

		bookService.findById(1);
		
		verify(bookRepositoryMock, times(1)).findById(1);
		
	}
	
	//saveBook
	@Test
	void test_book_save_calls_repo_once() {
		
		bookService = new BookService(bookRepositoryMock);
		
		Book book = new Book();

		bookService.saveBook(book);
		
		verify(bookRepositoryMock, times(1)).save(book);
		
	}
	
	//updateBook
	@Test
	void test_book_update_throws_exception() {
		
		bookService = new BookService(bookRepositoryMock);
		
		Book book = new Book();
		
		Exception exception = null;
		
		try {
			
			bookService.updateBook(book);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
	}
	
	//deleteById
	@Test
	void test_book_delete_throws_exception() {
		
		bookService = new BookService(bookRepositoryMock);
		
		Book book = new Book();
		book.setId(1);
		
		Exception exception = null;
		
		try {
			
			bookService.deleteById(1);
		
		}catch(NotAllowedException e) {
			
			exception = e;
		
		}

		assertNotNull(exception);
		
		
	}
	
	
}
