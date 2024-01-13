package functions;

import cards.CardPlayer;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.SelectImageViewManager;

public enum GetCardsSelectedActivePlayer {

	INSTANCE;

	public ArrayList<CardPlayer> execute() {

		ArrayList<IImageViewAble> list = SelectImageViewManager.INSTANCE
				.getSelectedImageViewAbles();

		ArrayList<CardPlayer> listCardPlayer = new ArrayList<>();

		for (IImageViewAble imageViewAble : list)
			if (imageViewAble instanceof CardPlayer)
				listCardPlayer.addLast((CardPlayer) imageViewAble);

		return listCardPlayer;

	}

}
