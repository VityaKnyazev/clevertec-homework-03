package ru.clevertec.knyazev.christmas;

import java.time.LocalDateTime;
import java.util.List;

public class CristmasBox {
	private String name;
	private LocalDateTime term;
	private List<PresentBox> presentBoxes;
	
	public CristmasBox(String name, LocalDateTime term, List<PresentBox> presentBoxes) {
		this.name = name;
		this.term = term;
		this.presentBoxes = presentBoxes;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getTerm() {
		return term;
	}

	public List<PresentBox> getPresentBoxes() {
		return presentBoxes;
	}	
	
}