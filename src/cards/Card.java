package cards;

import enums.ELayerZ;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Card implements IImageViewAble {

	public Card() {

	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handleCardPressed(this);
	}

	@Override
	public void handleMouseEntered() {
		Flow.INSTANCE.getGameStateCurrent().handleCardEntered(this);
	}

	@Override
	public void handleMouseExited() {
		Flow.INSTANCE.getGameStateCurrent().handleCardExited(this);
	}

	protected final void createCard(String fileName) {

		new ImageView(fileName, ELayerZ.CARDS, this);
		getImageView().setVisible(false);
		getImageView().setSelectImageViewAbleRatioPosition(0.5, 0.35);
		getImageView().setSelectImageViewAbleRatioDimensions(0.35);

	}

	protected String getFolder() {
		return "cards/";
	}

}
