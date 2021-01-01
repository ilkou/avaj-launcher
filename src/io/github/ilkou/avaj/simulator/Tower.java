package io.github.ilkou.avaj.simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) throws IOException {
		if (!observers.contains(flyable)) {
			if (flyable instanceof Baloon)
				Simulator.file.write("Tower says: Baloon#" + ((Baloon)flyable).name + "(" + ((Baloon)flyable).id + ") registered to weather tower.\n");
			else if (flyable instanceof JetPlane)
				Simulator.file.write("Tower says: JetPlane#" + ((JetPlane)flyable).name + "(" + ((JetPlane)flyable).id + ") registered to weather tower.\n");
			else if (flyable instanceof Helicopter)
				Simulator.file.write("Tower says: Helicopter#" + ((Helicopter)flyable).name + "(" + ((Helicopter)flyable).id + ") registered to weather tower.\n");
			observers.add(flyable);
		}
	}

	public void unregister(Flyable flyable) throws IOException {
		if (flyable instanceof Baloon)
			Simulator.file.write("Tower says: Baloon#" + ((Baloon)flyable).name + "(" + ((Baloon)flyable).id + ") unregistered from weather tower.\n");
		else if (flyable instanceof JetPlane)
			Simulator.file.write("Tower says: JetPlane#" + ((JetPlane)flyable).name + "(" + ((JetPlane)flyable).id + ") unregistered from weather tower.\n");
		else if (flyable instanceof Helicopter)
			Simulator.file.write("Tower says: Helicopter#" + ((Helicopter)flyable).name + "(" + ((Helicopter)flyable).id + ") unregistered from weather tower.\n");
		observers.remove(flyable);
	}

	protected void conditionsChanged() throws IOException {
		int old_length = observers.size();
		int new_length;
		int i = 0;
		while (i < observers.size()) {
			observers.get(i).updateConditions();
			new_length = observers.size();
			i++;
			if (old_length != new_length) {
				old_length = new_length;
				i--;
			}
		}
	}
}
