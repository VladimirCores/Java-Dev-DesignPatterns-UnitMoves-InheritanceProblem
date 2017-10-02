package app.entities.terran.marine;

import java.awt.Point;

import app.entities.terran.Marine;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class RunningMarine extends Marine 
{
	static public final String GUI_NAME = "RunningMarin Mode:";
		
	public enum UNIT_TYPES {
		_BACK_TO_MARINE
	}
	
	public RunningMarine(PApplet canvas) { super(canvas); }
	public RunningMarine(PApplet canvas, Point position) { super(canvas, position); }
	
	@Override
	protected void SetupUnit() {
		super.SetupUnit();
		_unitType = Marine.UNIT_TYPES.RUNNING.name();
		_speed = 600;
		_strokeColor = H.CYAN;
		_strokeSize = 2;
	}
	
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(RunningMarine.GUI_NAME);
		_gui.addItem(RunningMarine.UNIT_TYPES._BACK_TO_MARINE.name(), RunningMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal());
		return _gui;
	}
}
