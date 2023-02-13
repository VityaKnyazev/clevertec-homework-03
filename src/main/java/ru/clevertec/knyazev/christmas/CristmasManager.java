package ru.clevertec.knyazev.christmas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CristmasManager {
	private Set<DadMoroz> dadMorozes = new HashSet<>();
	
	public void addDadMoroz(DadMoroz dadMoroz) {
		dadMorozes.add(dadMoroz);
	}
	
	public CristmasBox createCristmasBox() {
		List<PresentBox> presetntBoxes = new ArrayList<>();
		
		if (!dadMorozes.isEmpty()) {
			dadMorozes.stream().forEach(dad -> presetntBoxes.add(dad.getPresentBox()));
		}
		
		CristmasBox cristmasBox = new CristmasBox("Main Box present container", LocalDateTime.now(), presetntBoxes);
		return cristmasBox;
	}
}
