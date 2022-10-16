package com.sda.testingadvanced.mockito.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	@Mock
	private UserValidator userValidator;

	@InjectMocks
	private UserService userService;

	@Test
	void shouldFindUserById() {
		//given
		long userId = 10L;
		User user = new User(userId, "Tomasz", "Wozniak");
		when(userRepository.findById(eq(userId))).thenReturn(Optional.of(user));

		//when
		User retrievedUser = userService.getUserById(userId);

		//then
		assertEquals(user, retrievedUser);
	}

	@Test
	void shouldThrowNoSuchElementExceptionWhenUserDoesNotExists() {
		assertThrows(NoSuchElementException.class, () -> userService.getUserById(-1L));
	}

	@Test
	void shouldAddValidUser() {
		//given
		final User user = new User(7L, "MockedName", "MockedLastName");
		when(userValidator.isUserValid(user)).thenReturn(true);
		when(userRepository.addUser(user)).thenReturn(user);

		//when
		final User addedUser = userService.addUser(user);

		//then
		assertNotNull(addedUser);
		assertEquals(user, addedUser);
	}

	@Test
	void shouldThrowsExceptionForInvalidUser() {
		//given
		final long id = 7L;
		final User user = new User(id, "MockedName", "MockedLastName");
		when(userValidator.isUserValid(user)).thenReturn(false);

		//when, then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> userService.addUser(user))
				.withMessageContaining(String.valueOf(id));

		Mockito.verifyNoInteractions(userRepository);
	}
}