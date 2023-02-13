package ru.clevertec.knyazev.christmas;

import java.util.ArrayList;
import java.util.List;

public class RussianDadMoroz extends DadMoroz {
	private static final String PRESENT_BOX_NAME = "Russian Present Box";
	
	RussianDadMoroz() {
		super(PRESENT_BOX_NAME);
	}

	List<Sweet> packageSweets() {
		List<Sweet> sweets = new ArrayList<>();
		
		sweets.add(new Sweet("Шапочка", Sweet.Color.Красный, 12, 1.25));
		sweets.add(new Sweet("Дюймовочка", Sweet.Color.Синий, 6, 2.12));
		sweets.add(new Sweet("Валерочка", Sweet.Color.Красный, 8, 2.59));
		sweets.add(new Sweet("Танечка", Sweet.Color.Зеленый, 10, 1.21));
		sweets.add(new Sweet("Машечка", Sweet.Color.Желтый, 11, 0.11));
		sweets.add(new Sweet("Марина Желтая", Sweet.Color.Желтый, 9, 0.88));
		sweets.add(new Sweet("Мальвина", Sweet.Color.Синий, 5, 1.11));
		sweets.add(new Sweet("Антония", Sweet.Color.Зеленый, 10, 1.32));
		sweets.add(new Sweet("Баба Коля", Sweet.Color.Синий, 4, 1.25));
		sweets.add(new Sweet("Машины мтихи", Sweet.Color.Желтый, 8, 1.34));
		sweets.add(new Sweet("Свадьба", Sweet.Color.Красный, 7, 1.16));
		sweets.add(new Sweet("Веселье", Sweet.Color.Красный, 3, 0.98));
		sweets.add(new Sweet("Праздник", Sweet.Color.Зеленый, 5, 0.97));
		sweets.add(new Sweet("Солнцевские", Sweet.Color.Желтый, 7, 0.65));
		
		return sweets;		
	}
	
}
