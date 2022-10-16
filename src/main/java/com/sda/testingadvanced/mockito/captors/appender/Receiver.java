package com.sda.testingadvanced.mockito.captors.appender;

import java.util.function.Consumer;

public interface Receiver extends Consumer<String> {
	void a(int a);

	String b(int a);
}
