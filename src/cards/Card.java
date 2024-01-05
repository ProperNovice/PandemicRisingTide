package cards;

import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Card implements IImageViewAble {

	public Card() {

	}

	protected final void createCard(String fileName) {

		new ImageView(fileName, eLayerZ(), this);
		getImageView().setBack(getStringBack());
		getImageView().setVisible(false);
		getImageView().setSelectImageViewAbleRatioPosition(0.5, 0.35);
		getImageView().setSelectImageViewAbleRatioDimensions(0.35);

	}

	protected String getFolder() {
		return "cards/";
	}

	protected abstract String getStringBack();

	protected ELayerZ eLayerZ() {
		return ELayerZ.CARDS;
	}

}
