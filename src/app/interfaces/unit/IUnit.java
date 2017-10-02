package app.interfaces.unit;

import controlP5.Controller;

public interface IUnit 
{
	void move(int x, int y);
	public Controller<?> getGUI();
	public void removeGUI();
	public float getRadius();
	public String getUnitType();
	public void resetSelection();
	public void selectUnit(int selectionColor);
	public void draw();
	public void update(int deltaTime);
}
