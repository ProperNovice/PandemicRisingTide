package model;

import business.Player;
import controller.Credentials;
import utils.ArrayList;

public enum Players {

	INSTANCE;

	private ArrayList<Player> list = new ArrayList<>();
	

	private Players() {
		createList();
	}

	public ArrayList<Player> getList() {
		return this.list;
	}

	public Player getActivePlayer() {
		return this.list.getFirst();
	}

	public Player getPassivePlayer() {
		return this.list.getLast();
	}

	public void changePlayerOrder() {
		this.list.addLast(this.list.removeFirst());
	}

	private void createList() {

		this.list.addLast(new Player(Credentials.INSTANCE.cPlayerTop));
		this.list.addLast(new Player(Credentials.INSTANCE.cPlayerBottom));

		this.list.saveOriginal();

	}

}
