package cards;

import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Card implements IImageViewAble {

	public Card() {

	}

	protected final void createCard(String fileName) {

		new ImageView(fileName, ELayerZ.CARDS, this);
		getImageView().setBack(getStringBack());
//		getImageView().setVisible(false);

	}

	protected String getFolder() {
		return "cards/";
	}

	protected abstract String getStringBack();

}
