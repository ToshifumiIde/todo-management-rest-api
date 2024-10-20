package net.ti.todo;

import org.springframework.boot.SpringApplication;

public class TestTodoManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(TodoManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
