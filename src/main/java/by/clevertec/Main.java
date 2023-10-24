package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
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
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("1. Director of Zoo № 3 keep 7 animals: ");

        //Age [10, 20]
        animals.stream()
                .filter(animal -> (animal.getAge() >= 10) && (animal.getAge() <= 20))
                .sorted(Comparator.comparingInt(Animal::getAge))
                .skip(7*2)
                .limit(7)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();

        String filteredAnimalsBreads = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
                .filter(animal -> animal.getGender().equals("Female"))
                .map(animal -> "[" + animal.getBread() + "]")
                .collect(Collectors.joining(", ", "", ""));

        System.out.println("2. Filtered Animals Breeds: " + filteredAnimalsBreads);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("3. Filtered animals countries:");

        animals.stream().filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .distinct()
                .filter(country -> country.startsWith("A"))
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();

        long animalsFemaleQuantity = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();

        System.out.println("4. Animals female quantity - " + animalsFemaleQuantity);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();

        //Age [20, 30]
        boolean isAnyAnimalFromHungarian = animals.stream()
                .filter(animal -> (animal.getAge() >= 20) && (animal.getAge() <= 30))
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));

        System.out.println("5. Is any animal from Hungarian? " + (isAnyAnimalFromHungarian ? "Yes" : "No"));
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();

        boolean isAllAnimalsMaleAndFemale = animals.stream()
                .map(animal -> animal.getGender())
                .allMatch(Predicate.isEqual("Male").or(Predicate.isEqual("Female")));

        System.out.println("6. Is all animals male and female? " + (isAllAnimalsMaleAndFemale ? "Yes" : "No"));
    }

    private static void task7() {
        List<Animal> animals = Util.getAnimals();

        boolean isNoAnimalsFromOceania = animals.stream()
                                                .allMatch(animal -> !animal.getOrigin().equals("Oceania"));

        System.out.println("7. Is no animals from Oceania? - " + (isNoAnimalsFromOceania ? "Yes" : "No"));
    }

    private static void task8() {
        List<Animal> animals = Util.getAnimals();

        Animal filteredTheOldestAnimal = animals.stream()
                                                .sorted(Comparator.comparing(Animal::getBread))
                                                .limit(100)
                                                .skip(99)
                                                .findFirst().orElse(null);

        System.out.println("8. The age of the oldest animal is " + filteredTheOldestAnimal);
    }

    private static void task9() {
        List<Animal> animals = Util.getAnimals();

        int lengthOfShortestCharArrBreed = animals.stream()
                                                  .mapToInt(animal -> animal.getBread().toCharArray().length)
                                                  .sorted()
                                                  .findFirst().orElse(-1);

        System.out.println("9. The shortest char array breed length is " + lengthOfShortestCharArrBreed);
    }

    private static void task10() {
        List<Animal> animals = Util.getAnimals();

        int sumOfAnimalsAges = animals.stream()
                                      .mapToInt(animal -> animal.getAge())
                                      .sum();

        System.out.println("10. Sum of animals ages is " + sumOfAnimalsAges);
    }

    private static void task11() {
        List<Animal> animals = Util.getAnimals();

        double averageAgeAnimalsFromIndonesian = animals.stream()
                                                        .filter(animal -> animal.getOrigin().equals(("Indonesian")))
                                                        .mapToInt(animal -> animal.getAge())
                                                        .average().orElse(0.0d);

        System.out.println("11. Average age animals from Indonesian is " + averageAgeAnimalsFromIndonesian);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();

        System.out.println("12. List of pure candidates in French legion:");

        //has age [18 27)
        persons.stream()
                .filter(human -> (human.getGender().equals("Male"))
                        && (human.getDateOfBirth().compareTo(LocalDate.now().minusYears(18)) <= 0)
                        && (human.getDateOfBirth().compareTo(LocalDate.now().minusYears(27)) > 0))
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .toList()
                .forEach(System.out::println);
    }

    private static void task13() {
        List<House> houses = Util.getHouses();

        // 1. Hospital
        List<Person> hospitalPersons = houses.stream()
                                             .filter(house -> house.getBuildingType().equals("Hospital"))
                                             .flatMap(house -> house.getPersonList().stream())
                                             .toList();

        //2. Дети age [ , 18) или Пенсионеры женщины age [58, ) или пенсионеры мужчины age [63, )
        List<Person> youngAndWizdomPersons = houses.stream()
                                                   .flatMap(house -> house.getPersonList().stream())
                .filter(person -> (person.getDateOfBirth().compareTo(LocalDate.now().minusYears(18)) > 0)
                        || ((person.getDateOfBirth().compareTo(LocalDate.now().minusYears(58)) <= 0)
                        && (person.getGender().equals("Female")))
                        || ((person.getDateOfBirth().compareTo(LocalDate.now().minusYears(63)) <= 0)
                        && person.getGender().equals("Male")))
                .toList();

        // 3 the others
        List<Person> theOtherPersons = houses.stream()
                                             .flatMap(house -> house.getPersonList().stream())
                                             .filter(person -> !hospitalPersons.contains(person))
                                             .filter(person -> !youngAndWizdomPersons.contains(person))
                                             .toList();

        List<Person> evacuatedPersons = Stream.of(hospitalPersons, youngAndWizdomPersons, theOtherPersons)
                                              .flatMap(personsList -> personsList.stream())
                                              .distinct()
                                              .limit(500)
                                              .toList();

        System.out.println("13. List of evacuated Persons of a first queue: " + evacuatedPersons);
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();

        final int dayInFiveYears = 5 * 365;
        final double waterPricePerCub = 1.39d;

        double flowersCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed())
                .filter(flower -> flower.getCommonName().matches("^[CDEFGHIJKLMNOPQRS].*"))
                .filter(flower -> flower.isShadePreferred()
                        && flower.getFlowerVaseMaterial().containsAll(List.of("Glass", "Aluminum", "Steel")))
                .mapToDouble(flower -> flower.getPrice()
                        + flower.getWaterConsumptionPerDay() * dayInFiveYears * waterPricePerCub)
                .sum();

        System.out.printf("15. Budget cost on keeping filtered flowers is %10.2f $%n", flowersCost);
    }

    public static void task16() {
        List<Student> students = Util.getStudents();

        System.out.println("16. Students list in alphabet order:");

        students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(s -> s.getSurname().toUpperCase()))
                .map(student -> "- " + student.getSurname() + ", " + student.getAge() +
                                " years old, " + student.getFaculty() + " faculty")
                .forEach(System.out::println);
    }

    public static void task17() {
        List<Student> students = Util.getStudents();

        System.out.println("17. List of student's group without repeating:");

        students.stream()
                .map(student -> "- " + student.getGroup())
                .distinct()
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();

        System.out.println("18. List of average student's age descending by \"faculty\" groups:");

        students.stream()
                .collect(Collectors.groupingBy(s -> s.getFaculty(),
                        Collectors.averagingInt(s -> s.getAge())))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(Map.Entry::getValue)))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }

    //Get student list by given group that passed 3 exams (with marks above zero) in examinations
    public static void task19() {
        String groupName = "M-1";

        List<Examination> examinations = Util.getExaminations();
        List<Student> students = Util.getStudents();

        System.out.println("19. Students list by given group: " + groupName + " that passed 3 exams in examinations");

        students.stream()
                .collect(Collectors.groupingBy(student -> student.getGroup(), Collectors.filtering(student -> {
                    Examination examination = examinations.stream()
                                                          .filter(examinationRes -> examinationRes.getStudentId() ==
                                                                                    student.getId())
                                                          .findFirst()
                                                          .orElse(null);

                    return examination != null && examination.getExam1() != 0
                            && examination.getExam2() != 0
                            && examination.getExam3() != 0;

                }, Collectors.toList())))
                                         .entrySet().stream()
                                         .filter(groupStudents -> groupStudents.getKey().equals(groupName))
                                         .map(groupStudents ->groupStudents.getValue())
                                         .forEach(s -> s.forEach(st -> System.out.println("- " + st)));
    }

    public static void task20() {
        List<Student> students = Util.getStudents();

        List<Examination> examinations = Util.getExaminations();

        Map.Entry<String, Double> maxAverageMarkFaculty =  students.stream()
                .collect(Collectors.groupingBy(student -> student.getFaculty(), Collectors.averagingInt(student -> {

                    Examination examination = examinations.stream()
                            .filter(exam -> exam.getStudentId() == student.getId())
                            .findFirst()
                            .orElse(null);
                    if (examination != null) {
                        return examination.getExam1();
                    }

                    return 0;

                })))
                .entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .orElseThrow(() -> new NoSuchElementException("Max average mark not found between faculties"));

        System.out.printf("20. Max average mark on faculty %s is %2.2f %n", maxAverageMarkFaculty.getKey(),
                                                                            maxAverageMarkFaculty.getValue());

    }

    public static void task21() {
        List<Student> students = Util.getStudents();

        System.out.println("21. Students quantity in every group:");

        students.stream()
                .collect(Collectors.groupingBy(s -> s.getGroup(), Collectors.mapping(s -> s.getId(),
                                                                  Collectors.counting())))
                .entrySet()
                .forEach(groupCountSt -> System.out.println(groupCountSt.getKey() + " - " + groupCountSt.getValue()));
    }

    public static void task22() {
        List<Student> students = Util.getStudents();

        System.out.println("22. Students min age on every faculty:");

        students.stream()
                .collect(Collectors.groupingBy(s -> s.getFaculty(),
                                               Collectors.minBy(Comparator.comparing(s -> s.getAge()))))
                .entrySet()
                .forEach(groupCountSt -> System.out.println(groupCountSt.getKey() + " - " +
                                                            groupCountSt.getValue().orElseGet(() -> new Student())
                                                                                   .getAge()));
    }
}
