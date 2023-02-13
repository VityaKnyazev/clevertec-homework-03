package ru.clevertec.knyazev.christmas;

import java.util.List;
import java.util.Objects;

public abstract class DadMoroz {
	String presentBoxName;
	
	DadMoroz(String presentBoxName) {
		this.presentBoxName = presentBoxName;
	}
	
	public PresentBox getPresentBox() {
		return new PresentBox(presentBoxName, packageSweets());
	}
	
	abstract List<Sweet> packageSweets();

	@Override
	public int hashCode() {
		return Objects.hash(presentBoxName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadMoroz other = (DadMoroz) obj;
		return Objects.equals(presentBoxName, other.presentBoxName);
	}	
	
}
