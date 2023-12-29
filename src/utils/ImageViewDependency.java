package utils;

import utils.Interfaces.IImageViewAble;

public enum ImageViewDependency {

	INSTANCE;

	private HashMap<IImageViewAble, ArrayList<IImageViewAble>> map = new HashMap<>();

	private ImageViewDependency() {

	}

	public void addDependency(IImageViewAble parent, IImageViewAble child) {

		if (!this.map.containsKey(parent))
			this.map.put(parent, new ArrayList<>());

		this.map.getValue(parent).addLast(child);

	}

	public boolean hasDependency(IImageViewAble imageViewAble) {
		return this.map.containsKey(imageViewAble);
	}

	public ArrayList<IImageViewAble> getDependency(IImageViewAble imageViewAble) {
		return this.map.getValue(imageViewAble);
	}

	public void removeDependency(IImageViewAble parent, IImageViewAble child) {

		this.map.getValue(parent).remove(child);

		if (this.map.getValue(parent).isEmpty())
			this.map.removeKey(parent);

	}

	public void removeAllDependenciesFromParent(IImageViewAble parent) {
		this.map.removeKey(parent);
	}

	public void removeAllDependenciesAsChild(IImageViewAble child) {

		for (IImageViewAble parent : this.map)
			if (this.map.getValue(parent).contains(child))
				this.map.getValue(parent).remove(child);

		clearEmptyParents();

	}

	private void clearEmptyParents() {

		for (IImageViewAble parent : this.map.clone())
			if (this.map.getValue(parent).isEmpty())
				this.map.removeKey(parent);

	}

	public void clearDependencies() {
		this.map.clear();
	}

}
