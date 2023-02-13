package ru.clevertec.knyazev.christmas;

import java.util.List;

public class PresentBox {
	String name;
	List<Sweet> sweets;

	public PresentBox(String name, List<Sweet> sweets) {
		this.name = name;
		this.sweets = sweets;
	}

	public String getName() {
		return name;
	}

	public List<Sweet> getSweets() {
		return sweets;
	}
	
	
}