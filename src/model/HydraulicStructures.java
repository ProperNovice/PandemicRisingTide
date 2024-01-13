package model;

import business.HydraulicStructure;
import controller.Credentials;
import enums.EColor;
import utils.Enums.RelocateTypeEnum;
import utils.HashMap;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.Vector2;

public enum HydraulicStructures {

	INSTANCE;

	private HashMap<EColor, ListImageViewAbles<HydraulicStructure>> hashMap = new HashMap<>();

	private HydraulicStructures() {
		createHydraulicStructureLocations();
	}

	public void buildHydraulicStructureMap(EColor eColor) {
		this.hashMap.getValue(eColor).getArrayList().getFirst().getImageView().setVisible(true);
	}

	public boolean isBuilt(EColor eColor) {
		return this.hashMap.getValue(eColor).getArrayList().getFirst().getImageView().isVisible();
	}

	public void reset() {

		for (EColor eColor : EColor.values())
			this.hashMap.getValue(eColor).getArrayList().getFirst().getImageView()
					.setVisible(false);

	}

	private void createHydraulicStructureLocations() {

		createHydraulicStructureLocation(EColor.GREEN,
				Credentials.INSTANCE.cHydraulicStructureMapGreen);

		createHydraulicStructureLocation(EColor.ORANGE,
				Credentials.INSTANCE.cHydraulicStructureMapOrange);

		createHydraulicStructureLocation(EColor.PURPLE,
				Credentials.INSTANCE.cHydraulicStructureMapPurple);

		createHydraulicStructureLocation(EColor.YELLOW,
				Credentials.INSTANCE.cHydraulicStructureMapYellow);

	}

	private void createHydraulicStructureLocation(EColor eColor, Vector2 vector2) {

		ListImageViewAbles<HydraulicStructure> listImageViewAbles = new ListImageViewAbles<>();
		listImageViewAbles.getArrayList().addLast(new HydraulicStructure());
		listImageViewAbles.getArrayList().getFirst().getImageView().setVisible(false);
		listImageViewAbles.getArrayList().saveOriginal();

		this.hashMap.put(eColor, listImageViewAbles);

		ListCredentials listCredentials = listImageViewAbles.getListCredentials();

		listCredentials.coordinatesList = vector2;
		listCredentials.coordinatesList.x += Credentials.INSTANCE.gapBetweenBorders;
		listCredentials.coordinatesList.y += Credentials.INSTANCE.gapBetweenBorders;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;

		listImageViewAbles.relocateImageViews();

	}

}
