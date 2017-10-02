package app.entities.terran.marine;

import java.awt.Point;

import app.entities.terran.Marine;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class TrenchMarine extends Marine 
{
	static public final String GUI_NAME = "TrenchMarin Mode:";
		
	public enum UNIT_TYPES {
		_BACK_TO_MARINE
	}
	
	public TrenchMarine(PApplet canvas) { super(canvas); }
	public TrenchMarine(PApplet canvas, Point position) { super(canvas, position); }
	
	@Override
	protected void SetupUnit() {
		super.SetupUnit();
		_speed = 0;
		_strokeColor = H.BLUE;
		_strokeSize = 1;
		setRadius(20);
	}
	
	@Override
	public void move(int toX, int toY) { System.out.println("> TrenchMarine: Can't move.");}
	
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(TrenchMarine.GUI_NAME);
		_gui.addItem(TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.name(), TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal());
		return _gui;
	}
}
