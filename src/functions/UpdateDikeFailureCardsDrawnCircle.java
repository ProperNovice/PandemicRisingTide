package functions;

import cards.CardDikeFailure;
import enums.ERegion;
import utils.ArrayList;

public enum UpdateDikeFailureCardsDrawnCircle {

	INSTANCE;

	private ArrayList<CardDikeFailure> list = new ArrayList<>();

	public void execute(CardDikeFailure cardDikeFailure) {

		if (this.list.contains(cardDikeFailure))
			return;

		this.list.addLast(cardDikeFailure);

		ERegion eRegion = cardDikeFailure.getERegion();
		int totalCards = 0;

		for (CardDikeFailure cardDikeFailureTemp : this.list)
			if (eRegion.equals(cardDikeFailureTemp.getERegion()))
				totalCards++;

		eRegion.getRegion().setCircle(totalCards);

	}

	public void reset() {

		for (ERegion eRegion : ERegion.values())
			eRegion.getRegion().clearCircle();

	}

}
