package gameStates;

import gameStatesDefault.GameState;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Q a = new Q();
		Q b = new Q();

		double percentage = 0.25;

		b.getImageView().relocateTopLeft(0, percentage * a.getImageView().getHeight());

	}

	public class Q implements IImageViewAble {

		public Q() {

			new ImageView("q.png", this);

		}

	}

}
