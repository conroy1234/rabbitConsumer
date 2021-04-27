package org.rabbit.consumer.rabbitConsumer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.rabbit.consumer.rabbitConsumer.model.Employee;
import org.rabbit.consumer.rabbitConsumer.service.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitConsumerApplication implements CommandLineRunner {

	@Autowired
	EmployeeProducer employeeProducer;

	private static List<String> SOURCE = List.of("HR", "MANAGEMENT");
	private static List<String> GRADE = List.of("MANAGER", "DIRECTOR", "CEO", "EMPLOYEE");
	private static List<String> ADDRESSES = List.of("LONDON", "INDIA", "CANADA", "USA");
	private static List<String> NUMBERS = List.of("7930341651", "789656412336", "98745632145", "01236547896");

	public static void main(String[] args) {
		SpringApplication.run(RabbitConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//Employee(String name, String address, String number, long id, String grade)
		for (int i = 0; i < 10; i++) {

			var employee = new Employee("Employee: " + GRADE.get(i),
					ADDRESSES.get(ThreadLocalRandom.current().nextInt(i)),
					NUMBERS.get(ThreadLocalRandom.current().nextInt(i)), i, GRADE.get(i));
			
			employeeProducer.sendMessage(location, exchangeKey, employee);

		}

	}

}
