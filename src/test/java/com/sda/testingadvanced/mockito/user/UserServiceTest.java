package com.sda.testingadvanced.mockito.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
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
}