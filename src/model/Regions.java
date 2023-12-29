package model;

import business.Region;
import enums.EColor;
import enums.ERegion;
import utils.ArrayList;
import utils.CameraView;

public enum Regions {

	INSTANCE;

	private ArrayList<Region> list = new ArrayList<>();

	private Regions() {

		// purple

		this.list.addLast(new Region(ERegion.NOORDERZIJLVEST, 1596, 178, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.FRYSLAN, 1274, 330, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.NOORDOOSTPOLDER, 1278, 659, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.FLEVOLAND, 1156, 902, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.MARKERWAARD, 1010, 804, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.WIERINGERMEER, 894, 567, EColor.PURPLE));
		this.list.addLast(new Region(ERegion.KENNEMERLAND, 817, 734, EColor.PURPLE));

		// orange

		this.list.addLast(new Region(ERegion.DELFLAND, 743, 1052, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.VOORNE_PUTTEN, 479, 1372, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.GOERRE_OVERFLAKKEE, 428, 1459, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.SCHOUWEN_DUIVELAND, 329, 1518, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.WALCHEREN, 175, 1641, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.ZUID_BEVELAND, 320, 1676, EColor.ORANGE));
		this.list.addLast(new Region(ERegion.ZEEUWS_VLAANDEREN, 322, 1839, EColor.ORANGE));

		// green

		this.list.addLast(new Region(ERegion.WEST_BRABANT, 669, 1602, EColor.GREEN));
		this.list.addLast(new Region(ERegion.HOEKSE_WAARD, 638, 1413, EColor.GREEN));
		this.list.addLast(new Region(ERegion.LAND_VAN_ALTENA, 820, 1445, EColor.GREEN));
		this.list.addLast(new Region(ERegion.LAND_VAN_HEUSDEN, 1069, 1512, EColor.GREEN));
		this.list.addLast(new Region(ERegion.LAND_VAN_MAAS_EN_WAAL, 1320, 1422, EColor.GREEN));
		this.list.addLast(new Region(ERegion.PEEL_EN_MAASVALLEI, 1492, 1719, EColor.GREEN));
		this.list.addLast(new Region(ERegion.ROER_EN_OVERMAAS, 1351, 2141, EColor.GREEN));

		// yellow

		this.list.getLast().setSelected();
		this.list.getLast().print();

		CameraView.INSTANCE.setCameraViewingSpot(2);

	}

}
