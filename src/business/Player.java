package business;

import cards.CardPlayer;
import cards.CardRole;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.Vector2;

public class Player {

	private ListImageViewAbles<CardRole> cardRole = new ListImageViewAbles<>();
	private ListImageViewAbles<CardPlayer> cardsPlayer = new ListImageViewAbles<>();

	public Player(Vector2 coordinates) {
		createLists(coordinates);
	}

	public ListImageViewAbles<CardRole> getCardRole() {
		return this.cardRole;
	}

	public ListImageViewAbles<CardPlayer> getCardsPlayer() {
		return this.cardsPlayer;
	}

	private void createLists(Vector2 coordinates) {

		ListCredentials listCredentials = null;

		// card role

		listCredentials = this.cardRole.getListCredentials();
		listCredentials.coordinatesList = coordinates.clone();

		// cards player

		listCredentials = this.cardsPlayer.getListCredentials();
		listCredentials.coordinatesList = coordinates.clone();
		listCredentials.coordinatesList.y += Credentials.INSTANCE.dCard.y / 2;
		listCredentials.gapBetweenComponents.y = Credentials.INSTANCE.dCard.y / 2;
		listCredentials.layerZListEnum = LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW;
		listCredentials.objectsPerRow = 4;
		this.cardsPlayer.getArrayList().setCapacity(7);

	}

}
