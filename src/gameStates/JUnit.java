package gameStates;

import controller.Credentials;
import gameStatesDefault.GameState;
import gui.InstancesGui;
import javafx.scene.input.KeyCode;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class JUnit extends GameState {

	@Override
	public void execute() {

		double x, y;

		x = Credentials.INSTANCE.dFrame.x;
		x -= Credentials.INSTANCE.gapBetweenBorders;
		x -= 4 * Credentials.INSTANCE.dCard.x;
		x -= 3 * Credentials.INSTANCE.dGapBetweenComponents.x;
		y = Credentials.INSTANCE.gapBetweenBorders;
		new Q(x, y);

		x += Credentials.INSTANCE.dCard.x + Credentials.INSTANCE.dGapBetweenComponents.x;
		new Q(x, y);

		x += Credentials.INSTANCE.dCard.x + Credentials.INSTANCE.dGapBetweenComponents.x;
		new Q(x, y);

		x = Credentials.INSTANCE.dFrame.x;
		x -= Credentials.INSTANCE.gapBetweenBorders;
		x -= Credentials.INSTANCE.dCard.x;
		y = Credentials.INSTANCE.gapBetweenBorders;
		new Q(x, y);

		y += Credentials.INSTANCE.dCard.y;
		y += Credentials.INSTANCE.dGapBetweenComponents.y;
		new Q(x, y);

		y += Credentials.INSTANCE.dCard.y;
		y += Credentials.INSTANCE.dGapBetweenComponents.y;
		new Q(x, y);

		y += 0.25 * Credentials.INSTANCE.dCard.y;
		new Q(x, y);

		y += 0.25 * Credentials.INSTANCE.dCard.y;
		new Q(x, y);

		y += Credentials.INSTANCE.dCard.y;
		y += Credentials.INSTANCE.dGapBetweenComponents.y;
		new Q(x, y);

		y += 0.25 * Credentials.INSTANCE.dCard.y;
		new Q(x, y);

		y += 0.25 * Credentials.INSTANCE.dCard.y;
		new Q(x, y);

//		handleKeyPressed(KeyCode.M);

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

		if (!keyCode.equals(KeyCode.M))
			return;

		InstancesGui.INSTANCE.getStage().setFullScreen(false);
		InstancesGui.INSTANCE.getStage().setY(0);
		InstancesGui.INSTANCE.getStage().setX(-510);

	}

	public class Q implements IImageViewAble {

		public Q(double x, double y) {

			new ImageView("q.png", this);
			getImageView().setDimensions(Credentials.INSTANCE.dCard);
			getImageView().relocateTopLeft(x, y);

		}

	}

}
