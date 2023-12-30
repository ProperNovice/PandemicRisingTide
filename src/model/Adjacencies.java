package model;

import business.Adjacency;
import enums.ERegion;
import utils.ArrayList;

public enum Adjacencies {

	INSTANCE;

	private ArrayList<Adjacency> list = new ArrayList<>();

	private Adjacencies() {
		create();
	}

	public ArrayList<ERegion> getAdjacentERegionsForMovement(ERegion eRegion) {

		ArrayList<ERegion> regions = new ArrayList<>();

		for (Adjacency adjacency : this.list)
			if (adjacency.getERegions().contains(eRegion))
				regions.addAllLast(adjacency.getERegions());

		while (regions.contains(eRegion))
			regions.remove(eRegion);

		return regions;

	}

	private void create() {

		this.list.addLast(new Adjacency(ERegion.NOORDZEE, ERegion.NOORDERZIJLVEST, 1555, 79));
		this.list.addLast(new Adjacency(ERegion.FRYSLAN, ERegion.NOORDERZIJLVEST, 1490, 285));
		this.list.addLast(new Adjacency(ERegion.FRYSLAN, ERegion.NOORDZEE, 1121, 268));
		this.list.addLast(new Adjacency(ERegion.FRYSLAN, ERegion.VOLLENHOVE, 1411, 542));
		this.list.addLast(new Adjacency(ERegion.FRYSLAN, ERegion.NOORDOOSTPOLDER, 1289, 559));
		this.list.addLast(new Adjacency(ERegion.FRYSLAN, ERegion.ZUIDERZEE, 1164, 547));
		this.list.addLast(new Adjacency(ERegion.NOORDOOSTPOLDER, ERegion.VOLLENHOVE, 1356, 642));
		this.list.addLast(new Adjacency(ERegion.NOORDOOSTPOLDER, ERegion.ZUIDERZEE, 1204, 658));
		this.list.addLast(new Adjacency(ERegion.NOORDOOSTPOLDER, ERegion.IJSSELDELTA, 1353, 737));
		this.list.addLast(new Adjacency(ERegion.NOORDOOSTPOLDER, ERegion.FLEVOLAND, 1270, 767));
		this.list.addLast(new Adjacency(ERegion.IJSSELDELTA, ERegion.FLEVOLAND, 1340, 834));
		this.list.addLast(new Adjacency(ERegion.GELDERSE_VALLEI, ERegion.FLEVOLAND, 1116, 1052));
		this.list.addLast(new Adjacency(ERegion.KROMME_RIJN, ERegion.FLEVOLAND, 966, 993));
		this.list.addLast(new Adjacency(ERegion.ZUIDERZEE, ERegion.FLEVOLAND, 1167, 779));
		this.list.addLast(new Adjacency(ERegion.MARKERWAARD, ERegion.FLEVOLAND, 1040, 891));
		this.list.addLast(new Adjacency(ERegion.MARKERWAARD, ERegion.ZUIDERZEE, 1083, 738));
		this.list.addLast(new Adjacency(ERegion.MARKERWAARD, ERegion.KENNEMERLAND, 921, 780));
		this.list.addLast(new Adjacency(ERegion.MARKERWAARD, ERegion.DELFLAND, 919, 929));
		this.list.addLast(new Adjacency(ERegion.ZUIDERZEE, ERegion.KENNEMERLAND, 1043, 648));
		this.list.addLast(new Adjacency(ERegion.NOORDZEE, ERegion.KENNEMERLAND, 715, 683));
		this.list.addLast(new Adjacency(ERegion.DELFLAND, ERegion.KENNEMERLAND, 817, 858));
		this.list.addLast(new Adjacency(ERegion.WIERINGERMEER, ERegion.KENNEMERLAND, 891, 657));
		this.list.addLast(new Adjacency(ERegion.WIERINGERMEER, ERegion.ZUIDERZEE, 959, 572));
		this.list.addLast(new Adjacency(ERegion.WIERINGERMEER, ERegion.NOORDZEE, 877, 489));
		this.list.addLast(new Adjacency(ERegion.DELFLAND, ERegion.NOORDZEE, 626, 1015));
		this.list.addLast(new Adjacency(ERegion.DELFLAND, ERegion.KROMME_RIJN, 881, 1078));
		this.list.addLast(new Adjacency(ERegion.DELFLAND, ERegion.VIJFHERELANDEN, 756, 1237));
		this.list.addLast(new Adjacency(ERegion.DELFLAND, ERegion.HOEKSE_WAARD, 609, 1325));
		this.list.addLast(new Adjacency(ERegion.DELFLAND, ERegion.VOORNE_PUTTEN, 480, 1300));
		this.list.addLast(new Adjacency(ERegion.HOEKSE_WAARD, ERegion.VOORNE_PUTTEN, 547, 1400));
		this.list.addLast(new Adjacency(ERegion.NOORDZEE, ERegion.VOORNE_PUTTEN, 381, 1295));
		this.list.addLast(
				new Adjacency(ERegion.GOERRE_OVERFLAKKEE, ERegion.VOORNE_PUTTEN, 432, 1405));
		this.list.addLast(
				new Adjacency(ERegion.GOERRE_OVERFLAKKEE, ERegion.HOEKSE_WAARD, 536, 1471));
		this.list.addLast(
				new Adjacency(ERegion.GOERRE_OVERFLAKKEE, ERegion.WEST_BRABANT, 536, 1541));
		this.list.addLast(new Adjacency(ERegion.GOERRE_OVERFLAKKEE, ERegion.NOORDZEE, 323, 1381));
		this.list.addLast(
				new Adjacency(ERegion.GOERRE_OVERFLAKKEE, ERegion.SCHOUWEN_DUIVELAND, 375, 1474));
		this.list.addLast(new Adjacency(ERegion.NOORDZEE, ERegion.SCHOUWEN_DUIVELAND, 229, 1450));
		this.list.addLast(
				new Adjacency(ERegion.WEST_BRABANT, ERegion.SCHOUWEN_DUIVELAND, 483, 1592));
		this.list.addLast(
				new Adjacency(ERegion.ZUID_BEVELAND, ERegion.SCHOUWEN_DUIVELAND, 381, 1637));
		this.list.addLast(new Adjacency(ERegion.WALCHEREN, ERegion.SCHOUWEN_DUIVELAND, 247, 1553));
		this.list.addLast(new Adjacency(ERegion.WALCHEREN, ERegion.NOORDZEE, 136, 1580));
		this.list.addLast(new Adjacency(ERegion.WALCHEREN, ERegion.ZUID_BEVELAND, 243, 1680));
		this.list.addLast(new Adjacency(ERegion.WALCHEREN, ERegion.ZEEUWS_VLAANDEREN, 191, 1745));
		this.list.addLast(new Adjacency(ERegion.NOORDZEE, ERegion.ZEEUWS_VLAANDEREN, 92, 1728));
		this.list.addLast(
				new Adjacency(ERegion.ZEEUWS_VLAANDEREN, ERegion.ZUID_BEVELAND, 399, 1749));
		this.list.addLast(new Adjacency(ERegion.WEST_BRABANT, ERegion.HOEKSE_WAARD, 649, 1520));
		this.list.addLast(new Adjacency(ERegion.WEST_BRABANT, ERegion.LAND_VAN_ALTENA, 760, 1491));
		this.list.addLast(new Adjacency(ERegion.WEST_BRABANT, ERegion.LAND_VAN_HEUSDEN, 819, 1548));
		this.list.addLast(new Adjacency(ERegion.HOEKSE_WAARD, ERegion.VIJFHERELANDEN, 718, 1354));
		this.list.addLast(new Adjacency(ERegion.HOEKSE_WAARD, ERegion.LAND_VAN_ALTENA, 702, 1444));
		this.list
				.addLast(new Adjacency(ERegion.VIJFHERELANDEN, ERegion.LAND_VAN_ALTENA, 815, 1398));
		this.list.addLast(new Adjacency(ERegion.BETUWE, ERegion.LAND_VAN_ALTENA, 934, 1413));
		this.list.addLast(
				new Adjacency(ERegion.LAND_VAN_HEUSDEN, ERegion.LAND_VAN_ALTENA, 904, 1492));
		this.list.addLast(new Adjacency(ERegion.LAND_VAN_HEUSDEN, ERegion.BETUWE, 1042, 1460));
		this.list.addLast(
				new Adjacency(ERegion.LAND_VAN_HEUSDEN, ERegion.LAND_VAN_MAAS_EN_WAAL, 1226, 1429));
		this.list.addLast(new Adjacency(ERegion.BETUWE, ERegion.LAND_VAN_MAAS_EN_WAAL, 1248, 1333));
		this.list.addLast(new Adjacency(ERegion.PEEL_EN_MAASVALLEI, ERegion.LAND_VAN_MAAS_EN_WAAL,
				1387, 1526));
		this.list.addLast(
				new Adjacency(ERegion.PEEL_EN_MAASVALLEI, ERegion.ROER_EN_OVERMAAS, 1429, 1864));
		this.list.addLast(new Adjacency(ERegion.KROMME_RIJN, ERegion.VIJFHERELANDEN, 926, 1228));
		this.list.addLast(new Adjacency(ERegion.KROMME_RIJN, ERegion.BETUWE, 1045, 1278));
		this.list.addLast(new Adjacency(ERegion.VIJFHERELANDEN, ERegion.BETUWE, 949, 1322));
		this.list.addLast(new Adjacency(ERegion.GELDERSE_VALLEI, ERegion.BETUWE, 1195, 1281));
		this.list.addLast(new Adjacency(ERegion.RIJN_EN_IJSSEL, ERegion.BETUWE, 1385, 1323));
		this.list.addLast(new Adjacency(ERegion.RIJN_EN_IJSSEL, ERegion.IJSSELDELTA, 1466, 1181));
		this.list.addLast(new Adjacency(ERegion.RIJN_EN_IJSSEL, ERegion.VOLLENHOVE, 1515, 1057));
		this.list.addLast(new Adjacency(ERegion.IJSSELDELTA, ERegion.VOLLENHOVE, 1465, 877));

		this.list.addLast(new Adjacency(ERegion.DRENTHE, ERegion.NOORDERZIJLVEST));
		this.list.addLast(new Adjacency(ERegion.DRENTHE, ERegion.FRYSLAN));
		this.list.addLast(new Adjacency(ERegion.DRENTHE, ERegion.VOLLENHOVE));
		this.list.addLast(new Adjacency(ERegion.DRENTHE, ERegion.TWENTE));
		this.list.addLast(new Adjacency(ERegion.VOLLENHOVE, ERegion.TWENTE));
		this.list.addLast(new Adjacency(ERegion.RIJN_EN_IJSSEL, ERegion.TWENTE));
		this.list.addLast(new Adjacency(ERegion.VELUWE, ERegion.FLEVOLAND));
		this.list.addLast(new Adjacency(ERegion.VELUWE, ERegion.IJSSELDELTA));
		this.list.addLast(new Adjacency(ERegion.VELUWE, ERegion.RIJN_EN_IJSSEL));
		this.list.addLast(new Adjacency(ERegion.VELUWE, ERegion.BETUWE));
		this.list.addLast(new Adjacency(ERegion.VELUWE, ERegion.GELDERSE_VALLEI));
		this.list.addLast(new Adjacency(ERegion.UTRECHTSE_HEUVELRUG, ERegion.GELDERSE_VALLEI));
		this.list.addLast(new Adjacency(ERegion.UTRECHTSE_HEUVELRUG, ERegion.KROMME_RIJN));
		this.list.addLast(new Adjacency(ERegion.UTRECHTSE_HEUVELRUG, ERegion.FLEVOLAND));
		this.list.addLast(new Adjacency(ERegion.DE_ZOOM, ERegion.ZUID_BEVELAND));
		this.list.addLast(new Adjacency(ERegion.DE_ZOOM, ERegion.SCHOUWEN_DUIVELAND));
		this.list.addLast(new Adjacency(ERegion.DE_ZOOM, ERegion.WEST_BRABANT));
		this.list.addLast(new Adjacency(ERegion.OOST_BRABANT, ERegion.WEST_BRABANT));
		this.list.addLast(new Adjacency(ERegion.OOST_BRABANT, ERegion.LAND_VAN_HEUSDEN));
		this.list.addLast(new Adjacency(ERegion.OOST_BRABANT, ERegion.LAND_VAN_MAAS_EN_WAAL));
		this.list.addLast(new Adjacency(ERegion.OOST_BRABANT, ERegion.PEEL_EN_MAASVALLEI));
		this.list.addLast(new Adjacency(ERegion.OOST_BRABANT, ERegion.ROER_EN_OVERMAAS));

	}

}
