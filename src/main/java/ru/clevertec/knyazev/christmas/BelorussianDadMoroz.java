package ru.clevertec.knyazev.christmas;

import java.util.ArrayList;
import java.util.List;

public class BelorussianDadMoroz extends DadMoroz {
	private static final String PRESENT_BOX_NAME = "Belarussian Present Box";
	
	BelorussianDadMoroz() {
		super(PRESENT_BOX_NAME);
	}

	List<Sweet> packageSweets() {
		List<Sweet> sweets = new ArrayList<>();
		
		sweets.add(new Sweet("Маечка", Sweet.Color.Зеленый, 8, 1.45));
		sweets.add(new Sweet("Мовочка", Sweet.Color.Красный, 9, 1.25));
		sweets.add(new Sweet("Санечка", Sweet.Color.Синий, 10, 0.76));
		sweets.add(new Sweet("Ванечка", Sweet.Color.Зеленый, 12, 1.5));
		sweets.add(new Sweet("Стервочка", Sweet.Color.Желтый, 14, 0.38));
		sweets.add(new Sweet("Мария Антуанета", Sweet.Color.Зеленый, 15, 0.44));
		sweets.add(new Sweet("Матрона", Sweet.Color.Красный, 6, 0.51));
		sweets.add(new Sweet("Данина", Sweet.Color.Красный, 7, 0.61));
		sweets.add(new Sweet("Баб Вань", Sweet.Color.Синий, 8, 0.68));
		sweets.add(new Sweet("Мамина помада", Sweet.Color.Желтый, 9, 0.54));
		sweets.add(new Sweet("Свята", Sweet.Color.Желтый, 10, 0.22));
		sweets.add(new Sweet("Вяселка", Sweet.Color.Зеленый, 11, 0.48));
		sweets.add(new Sweet("Гульба", Sweet.Color.Синий, 12, 0.75));
		sweets.add(new Sweet("Свет", Sweet.Color.Зеленый, 9, 0.81));
		
		return sweets;		
	}
	
}
