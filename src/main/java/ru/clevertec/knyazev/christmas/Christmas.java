package ru.clevertec.knyazev.christmas;

public class Christmas {

	public CristmasManager init() {
		DadMoroz dadMorozRU = new RussianDadMoroz();
		DadMoroz dadMorozBY = new BelorussianDadMoroz();

		CristmasManager cristmasManager = new CristmasManager();
		cristmasManager.addDadMoroz(dadMorozRU);
		cristmasManager.addDadMoroz(dadMorozBY);

		return cristmasManager;
	}
}
