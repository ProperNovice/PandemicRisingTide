package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class HydraulicStructure implements IImageViewAble {

	public HydraulicStructure() {

		String fileName = "hydraulic structure.png";
		new ImageView(fileName, ELayerZ.MAP_BUILDINGS, this);
		getImageView().setHeight(Credentials.INSTANCE.hHydraulicStructure);

	}

}
