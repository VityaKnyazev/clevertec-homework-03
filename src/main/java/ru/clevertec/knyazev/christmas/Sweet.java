package ru.clevertec.knyazev.christmas;

public class Sweet {
	private String name;
	private Color color;
	private int count;
	private double price;
		
	public Sweet(String name, Color color, int count, double price) {
		this.name = name;
		this.color = color;
		this.count = count;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public int getCount() {
		return count;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static enum Color{
		Зеленый, Красный, Синий, Желтый
	}

	@Override
	public String toString() {
		return "Sweet [name=" + name + ", color=" + color + ", count=" + count + ", price=" + price + "]";
	}	
}