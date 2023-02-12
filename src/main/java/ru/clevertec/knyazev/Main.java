package ru.clevertec.knyazev;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		// сгрупировать по 7 в одном стриме???
		System.out.println("1. Director of Zoo № 3 keep 7 animals: ");
		animals.stream().filter(animal -> ((animal.getAge() >= 10) && (animal.getAge() <= 20)))
				.sorted((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge())).skip(14).limit(7)
				.forEach(System.out::println);
	}

	private static void task2() throws IOException {
		List<Animal> animals = Util.getAnimals();
		String filteredAnimalsBreads = animals.stream().filter(animal -> animal.getOrigin().equals("Japanese"))
				.peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
				.filter(animal -> animal.getGender().equals("Female")).map(animal -> animal.getBread())
				.reduce("", (prevG, nextG) -> prevG + "[" + nextG + "], ");
		System.out.println("2. Filtered Animals Breads -" + filteredAnimalsBreads);
	}

	private static void task3() throws IOException {
		List<Animal> animals = Util.getAnimals();
		System.out.println("3. Filtered animals countries:");
		animals.stream().filter(animal -> animal.getAge() > 30).map(Animal::getOrigin).distinct()
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
				.limit(100).sorted(Comparator.comparing(Animal::getAge).reversed()).findFirst().orElse(null);
		System.out.println("8. Filtered the oldest animal is " + filteredTheOldestAnimal);
	}

	private static void task9() throws IOException {
		List<Animal> animals = Util.getAnimals();
		int lengthOfShortestCharArrBreed = animals.stream().mapToInt(animal -> animal.getBread().toCharArray().length)
				.sorted().findFirst().orElse(-1);
		System.out.println("9. The shortest char array breed length is " + lengthOfShortestCharArrBreed);
	}

	private static void task10() throws IOException {
		List<Animal> animals = Util.getAnimals();
		int sumOfAnimalsAges = animals.stream().map(animal -> animal.getAge()).reduce(0,
				(prevAge, currAge) -> prevAge + currAge);
		System.out.println("10. Sum of animals ages is " + sumOfAnimalsAges);
	}

	private static void task11() throws IOException {
		List<Animal> animals = Util.getAnimals();
		double averageAgeAnimalsFromIndenesian = animals.stream()
				.filter(animal -> animal.getOrigin().equals(("Indonesian"))).mapToInt(animal -> animal.getAge())
				.average().orElse(0.0d);
		System.out.println("11. Average age animals from Indonesian is " + averageAgeAnimalsFromIndenesian);
	}

	private static void task12() throws IOException {
		List<Person> people = Util.getPersons();
		System.out.println("12. List of pure candidates in French legion:");
		// ~ 1996 - 2005 | [18 27)
		people.stream()
				.filter(human -> (human.getGender().equals("Male"))
						&& (human.getDateOfBirth().compareTo(LocalDate.now().minusYears(18)) <= 0)
						&& (human.getDateOfBirth().compareTo(LocalDate.now().minusYears(27)) > 0))
				.sorted(Comparator.comparing(Person::getRecruitmentGroup)).limit(200).collect(Collectors.toList())
				.forEach(System.out::println);
	}

	// 1 Из Hospital
	// 2 Людей в возрасте до 18 и после 58 и 63
	// 3 После всех остальных людей
	// 4 Уникальные значения и ограничение (limit) 500
	private static void task13() throws IOException {
		List<House> houses = Util.getHouses();
		/// 1
		List<Person> hospitalPersons = houses.stream().filter(house -> house.getBuildingType().equals("Hospital"))
				.flatMap(house -> house.getPersonList().stream()).collect(Collectors.toList());
		//  (18 58,63]
		List<Person> youngAndWizdomPersons = houses.stream().flatMap(house -> house.getPersonList().stream())
				.filter(person -> (person.getDateOfBirth().compareTo(LocalDate.now().minusYears(18)) > 0)
						|| ((person.getDateOfBirth().compareTo(LocalDate.now().minusYears(58)) <= 0)
								&& (person.getGender().equals("Female")))
						|| ((person.getDateOfBirth().compareTo(LocalDate.now().minusYears(63)) <= 0)
								&& person.getGender().equals("Male")))
				.collect(Collectors.toList());
		// 3 the others
		List<Person> theOtherPersons = houses.stream().flatMap(house -> house.getPersonList().stream())
				.collect(Collectors.toList());

		List<Person> evacuatedPersons = Stream.of(hospitalPersons, youngAndWizdomPersons, theOtherPersons)
				.flatMap(personsList -> personsList.stream()).distinct().limit(500).collect(Collectors.toList());
		System.out.println("13. List of evacuated Persons of a first queu:");
		evacuatedPersons.forEach(System.out::println);
	}

	private static void task14() throws IOException {
		List<Car> cars = Util.getCars();
		System.out.println("14. Transport company logistic calculation task:");
		// 1
		List<Car> turkmenistanCars = cars.stream()
				.filter(car -> car.getCarMake().equals("Jaguar") || car.getColor().equals("White")).toList();
		// 2
		// Трактовал так: Все авто с массой до 1500 кг (не включительно), а также марки
		// BMW, Lexus, Chrysler, Toyota
		List<Car> uzbekistanCars = cars.stream()
				.filter(car -> (car.getMass() < 1500) || car.getCarMake().equals("BMW")
						|| car.getCarMake().equals("Lexus") || car.getCarMake().equals("Chrysler")
						|| car.getCarMake().equals("Toyota"))
				.filter(car -> !turkmenistanCars.contains(car)).toList();
		// 3
		List<Car> kazahstanCars = cars.stream()
				.filter(car -> (car.getColor().equals("Black") && (car.getMass() > 4000))
						|| car.getCarMake().equals("GMC") || car.getCarMake().equals("Dodge"))
				.filter(car -> !turkmenistanCars.contains(car) && !uzbekistanCars.contains(car)).toList();
		// 4
		List<Car> kurgustanCars = cars.stream()
				.filter(car -> (car.getReleaseYear() < 1982) || car.getCarModel().equals("Civic")
						|| car.getCarModel().equals("Cherokee"))
				.filter(car -> !turkmenistanCars.contains(car) && !uzbekistanCars.contains(car)
						&& !kazahstanCars.contains(car))
				.toList();
		// 5
		List<Car> russianCars = cars.stream()
				.filter(car -> (!car.getColor().equals("Yellow") && !car.getColor().equals("Red")
						&& !car.getColor().equals("Green") && !car.getColor().equals("Blue")) || car.getPrice() > 40000)
				.filter(car -> !turkmenistanCars.contains(car) && !uzbekistanCars.contains(car)
						&& !kazahstanCars.contains(car) && !kurgustanCars.contains(car))
				.toList();

		// 6
		List<Car> mongolianCars = cars.stream().filter(car -> car.getVin().contains("59"))
				.filter(car -> !turkmenistanCars.contains(car) && !uzbekistanCars.contains(car)
						&& !kazahstanCars.contains(car) && !kurgustanCars.contains(car) && !russianCars.contains(car))
				.toList();

		// 7 ~Трансппортные расходы и выручка
		double turkmenistanLogisticCost = calculateLogisticCost(turkmenistanCars);
		double uzbekistanLogisticCost = calculateLogisticCost(uzbekistanCars);
		double kazahstanLogisticCost = calculateLogisticCost(kazahstanCars);
		double kurgustanLogisticCost = calculateLogisticCost(kurgustanCars);
		double russianLogisticCost = calculateLogisticCost(russianCars);
		double mongolianLogisticCost = calculateLogisticCost(mongolianCars);

		double totalLogisticCost = Stream
				.of(turkmenistanLogisticCost, uzbekistanLogisticCost, kazahstanLogisticCost, kurgustanLogisticCost,
						russianLogisticCost, mongolianLogisticCost)
				.reduce(0.0d, (prevVal, currVal) -> prevVal + currVal);

		double totalOutcome = Stream
				.of(turkmenistanCars, uzbekistanCars, kazahstanCars, kurgustanCars, russianCars, mongolianCars)
				.flatMap(carsList -> carsList.stream()).map(car -> car.getPrice())
				.reduce(0, (prevPrice, currentPrice) -> prevPrice + currentPrice) - totalLogisticCost;

		System.out.println("Total logistc cost per countries: " + System.lineSeparator() + "Turkmenistan: "
				+ String.format("%-10.2f", turkmenistanLogisticCost) + " $" + System.lineSeparator() + "Uzbekistan: "
				+ String.format("%-10.2f", uzbekistanLogisticCost) + " $" + System.lineSeparator() + "Kazahstan: "
				+ String.format("%-10.2f", kazahstanLogisticCost) + " $" + System.lineSeparator() + "Kurgustan: "
				+ String.format("%-10.2f", kurgustanLogisticCost) + " $" + System.lineSeparator() + "Russia: "
				+ String.format("%-10.2f", russianLogisticCost) + " $" + System.lineSeparator() + "Mongolia: "
				+ String.format("%-10.2f", mongolianLogisticCost) + " $" + System.lineSeparator());

		System.out.println("Logistic company total outcome: " + String.format("%-10.2f", totalOutcome) + " $");
	}

	private static void task15() throws IOException {
		List<Flower> flowers = Util.getFlowers();
		
		final int dayInFiveYears = 5 * 365;
		final double waterPricePerСub = 1.39d;
		
		double flowersCost = flowers.stream()
				.sorted(Comparator.comparing(Flower::getOrigin).reversed().thenComparing(Flower::getPrice)
						.thenComparing(Flower::getWaterConsumptionPerDay).reversed())
				.filter(flower -> flower.getCommonName().matches("^[CDEFGHIJKLMNOPQRS].{0,}"))
				.filter(flower -> flower.isShadePreferred()
						&& flower.getFlowerVaseMaterial().containsAll(List.of("Glass", "Aluminum", "Steel")))
				.mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() * dayInFiveYears * waterPricePerСub)
				.reduce(0.0d, (prevCost, currentCost) -> prevCost + currentCost);
		
		System.out.println("15. Budget cost on keeping filtered flowers is " + String.format("%10.2f", flowersCost) + " $");
	}

	private static final double calculateLogisticCost(List<Car> cars) {
		final double logisticCostPerT = 7.14;

		return cars.stream().map(car -> car.getMass()).reduce(0, (prevMass, currentMass) -> prevMass + currentMass)
				* logisticCostPerT;
	}
}