package com.sda.testingadvanced.mockito.captors.appender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppenderTest {

	@Mock
	private Receiver receiver;

	@Captor
	private ArgumentCaptor<String> captor;

	@Test
	void shouldAppendAsSuffix() {
		doNothing().when(receiver).accept(captor.capture());

		String suffix = "---";
		String toAppend = "abc";
		new Appender(receiver, suffix).append(toAppend);

		assertEquals(toAppend + suffix, captor.getValue());
	}
}