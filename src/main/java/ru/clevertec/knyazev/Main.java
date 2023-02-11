package ru.clevertec.knyazev;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ru.clevertec.knyazev.model.Animal;
import ru.clevertec.knyazev.model.Car;
import ru.clevertec.knyazev.model.Flower;
import ru.clevertec.knyazev.model.House;
import ru.clevertec.knyazev.model.Person;
import ru.clevertec.knyazev.util.Util;

public class Main {
	public static void main(String[] args) throws IOException {
		task1();
		task2();
		task3();
		task4();
		task5();
		task6();
		task7();
		task8();
		task9();
		task10();
		task11();
		task12();
		task13();
		task14();
		task15();
	}

	private static void task1() throws IOException {
		List<Animal> animals = Util.getAnimals();
		// TODO сгрупировать по 7 ???
		animals.stream().filter(animal -> ((animal.getAge() >= 20) && (animal.getAge() <= 30)))
				.sorted((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge())).skip(14).limit(7)
				.forEach(System.out::println);
	}

	// Отфильтровали животных по происхождению из Японии (Japanese), преобразовали
	// символы в происхождении каждого животного в верхний регистр
	// и там, где пол животного женский (Female) выбираем строки происхождения и
	// сводим к одной строке
	private static void task2() throws IOException {
		List<Animal> animals = Util.getAnimals();
		String filteredAnimalsBreads = animals.stream().filter(animal -> animal.getOrigin().equals("Japanese"))
				.peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
				.filter(animal -> animal.getGender().equals("Female")).map(animal -> animal.getBread())
				.reduce("", (prevG, nextG) -> prevG + "[" + nextG + "], ");
		System.out.println("2. Filtered Animals Breads -" + filteredAnimalsBreads);
	}

	// Отфильтровали животных по возрасту старше 30 лет (включительно), выбрали
	// строки с происхождением из каждого
	// животного оставляя только уникальные значения, отфильтровали эти значения
	// происхождения, оставив только те, которые
	// начинаются на "A" и вывели их в консоли.
	private static void task3() throws IOException {
		List<Animal> animals = Util.getAnimals();
		animals.stream().filter(animal -> animal.getAge() >= 30).map(Animal::getOrigin).distinct()
				.filter(country -> country.startsWith("A")).forEach(System.out::println);
	}

	private static void task4() throws IOException {
		List<Animal> animals = Util.getAnimals();
		long animalsFemaleQuantity = animals.stream().filter(animal -> animal.getGender().equals("Female")).count();
		System.out.println("4. Animals female quantity - " + animalsFemaleQuantity);
	}

	private static void task5() throws IOException {
		List<Animal> animals = Util.getAnimals();
		boolean isAnyAnimalFromHungarian = animals.stream()
				.filter(animal -> (animal.getAge() >= 20) && (animal.getAge() <= 30))
				.anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
		System.out.println("5. Is any animal from Hungarian? - " + isAnyAnimalFromHungarian);
	}

	private static void task6() throws IOException {
		List<Animal> animals = Util.getAnimals();
		boolean isAllAnimalsMaleAndFemale = animals.stream()
				.allMatch(animal -> (animal.getGender().equals("Male")) || (animal.getGender().equals("Female")));
		System.out.println("6. Is all animals male and female? - " + isAllAnimalsMaleAndFemale);
	}

	private static void task7() throws IOException {
		List<Animal> animals = Util.getAnimals();
		boolean isNoAnimalsFromOceania = animals.stream().allMatch(animal -> !animal.getOrigin().equals("Oceania"));
		System.out.println("7. Is no animals from Oceania? - " + isNoAnimalsFromOceania);
	}

	private static void task8() throws IOException {
		List<Animal> animals = Util.getAnimals();
		Animal filteredTheOldestAnimal = animals.stream().sorted((a1, a2) -> a1.getBread().compareTo(a2.getBread()))
				.limit(100).sorted(Comparator.comparing(Animal::getAge).reversed()).findFirst().orElse(new Animal());
		System.out.println("8. Filtered the oldest animal is " + filteredTheOldestAnimal);
	}

	private static void task9() throws IOException {
		List<Animal> animals = Util.getAnimals();
		int lengthOfShortestCharArrBreed = animals.stream().mapToInt(animal -> animal.getBread().toCharArray().length).sorted().findFirst().orElse(-1);
		System.out.println("9. The shortest char array breed length is " + lengthOfShortestCharArrBreed);
	}

	private static void task10() throws IOException {
		List<Animal> animals = Util.getAnimals();
		int sumOfAnimalsAges = animals.stream().map(animal -> animal.getAge()).reduce(0, (prevAge, currAge) -> prevAge + currAge);
		System.out.println("10. Sum of animals ages is " + sumOfAnimalsAges);
	}

	private static void task11() throws IOException {
		List<Animal> animals = Util.getAnimals();
		// animals.stream() Продолжить ...
	}

	private static void task12() throws IOException {
		List<Person> people = Util.getPersons();
//        Продолжить...
	}

	private static void task13() throws IOException {
		List<House> houses = Util.getHouses();
		// Продолжить...
	}

	private static void task14() throws IOException {
		List<Car> cars = Util.getCars();
		// Продолжить...
	}

	private static void task15() throws IOException {
		List<Flower> flowers = Util.getFlowers();
		// Продолжить...
	}
}