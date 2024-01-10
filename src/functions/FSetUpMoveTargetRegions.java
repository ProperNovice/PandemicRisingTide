package functions;

import business.Region;
import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.ERegion;
import model.Adjacencies;
import model.Players;
import utils.ArrayList;
import utils.Logger;

public enum FSetUpMoveTargetRegions {

	INSTANCE;

	private ArrayList<ERegion> free = new ArrayList<>();
	private ArrayList<ERegion> usingCard = new ArrayList<>();
	private ERegion eRegionPlayer = null;

	public void execute() {

		setup();
		driveFerry();
		returnToPort();
		sail();
		charterBoat();

		selectRegions();
		printRegions();

	}

	private void charterBoat() {

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;
			ERegion eRegionCardPlayer = cardPlayerRegion.getERegion();

			if (!eRegionCardPlayer.equals(this.eRegionPlayer))
				continue;

			for (ERegion eRegion : ERegion.values()) {

				Region region = eRegion.getRegion();

				if (region.isSea())
					continue;

				addERegion(eRegion, this.usingCard);

			}

		}

	}

	private void sail() {

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;
			ERegion eRegion = cardPlayerRegion.getERegion();

			addERegion(eRegion, this.usingCard);

		}

	}

	private void returnToPort() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPorts().getArrayList().isEmpty())
				continue;

			addERegion(eRegion, this.free);

		}

	}

	private void driveFerry() {

		ArrayList<ERegion> list = Adjacencies.INSTANCE.getAdjacentERegions(this.eRegionPlayer);

		for (ERegion eRegion : list) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			addERegion(eRegion, this.free);

		}

	}

	private void selectRegions() {

		for (ERegion eRegion : this.free)
			eRegion.getRegion().setSelected();

		for (ERegion eRegion : this.usingCard)
			eRegion.getRegion().setSelected();

	}

	private void printRegions() {

		Logger.INSTANCE.logNewLine("printing regions to move");

		// free

		Logger.INSTANCE.log("/* free");

		for (ERegion eRegion : this.free)
			Logger.INSTANCE.log(eRegion);

		Logger.INSTANCE.logNewLine("*/");

		// using card

		Logger.INSTANCE.log("/* using card");

		for (ERegion eRegion : this.usingCard)
			Logger.INSTANCE.log(eRegion);

		Logger.INSTANCE.logNewLine("*/");

	}

	private void addERegion(ERegion eRegion, ArrayList<ERegion> list) {

		if (this.free.contains(eRegion) || this.usingCard.contains(eRegion))
			return;

		if (eRegion.equals(this.eRegionPlayer))
			return;

		list.addLast(eRegion);

	}

	private void setup() {

		// clear lists

		this.free.clear();
		this.usingCard.clear();

		// set up active player eRegion

		this.eRegionPlayer = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

	}

	public ArrayList<ERegion> getFreeERegions() {
		return this.free;
	}

	public ArrayList<ERegion> getUsingCardERegions() {
		return this.usingCard;
	}

}
