package app.entities.terran.tank;

import java.awt.Point;

import app.entities.terran.Tank;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class TurellTank extends Tank 
{
	static public final String GUI_NAME = "TurellTank Modes:";
	
	public enum UNIT_TYPES {
		_BACK_TO_TANK
	}
	
	public TurellTank(PApplet canvas, Point position) 
	{
		super(canvas, position);
	}
	
	protected void SetupUnit() {
		super.SetupUnit();
		_strokeColor = H.GREEN;
	}
	
	@Override
	public void move(int toX, int toY) { System.out.println("> TurellTank: Can't move.");}
	
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(TurellTank.GUI_NAME);
		_gui.addItem(TurellTank.UNIT_TYPES._BACK_TO_TANK.name(), TurellTank.UNIT_TYPES._BACK_TO_TANK.ordinal());
		return _gui;
	}
}
