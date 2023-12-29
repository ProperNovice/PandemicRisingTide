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
		x -= 250;
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
