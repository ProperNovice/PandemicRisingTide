package model;

import business.Region;
import enums.EColor;
import enums.ERegion;
import utils.ArrayList;

public enum Regions {

	INSTANCE;

	private ArrayList<Region> list = new ArrayList<>();

	private Regions() {

		// purple

		this.list.addLast(new Region(ERegion.NOORDERZIJLVEST, 1596, 164, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.FRYSLAN, 1288, 344, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.NOORDOOSTPOLDER, 1292, 673, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.FLEVOLAND, 1165, 916, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.MARKERWAARD, 1024, 818, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.WIERINGERMEER, 908, 581, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.KENNEMERLAND, 831, 748, EColor.PURPLE));

		// orange

		this.list.addLast(new Region(ERegion.DELFLAND, 757, 1064, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.VOORNE_PUTTEN, 479, 1372, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.GOERRE_OVERFLAKKEE, 442, 1473, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.SCHOUWEN_DUIVELAND, 308, 1512, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.WALCHEREN, 189, 1655, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.ZUID_BEVELAND, 334, 1690, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.ZEEUWS_VLAANDEREN, 341, 1853, EColor.ORANGE));

		// green

		this.list.addLast(new Region(ERegion.ZEEUWS_VLAANDEREN, 341, 1853, EColor.GREEN));

		this.list.getLast().setSelected();
		this.list.getLast().print();

	}

}
