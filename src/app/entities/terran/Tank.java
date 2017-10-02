package app.entities.terran;

import java.awt.Point;
import java.util.Arrays;

import app.entities.Unit;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class Tank extends Unit 
{
	static public final String GUI_NAME = "Tank Modes:";
	
	public enum UNIT_TYPES {
		TURELL,
		_BACK
	}
	
	public Tank(PApplet canvas, Point position) 
	{
		super(canvas, position);
	}
	
	protected void SetupUnit() {
		super.SetupUnit();
		setRadius(50f);
		_originalColor = H.RED;
		_speed = 100;
		_strokeSize = 5;
	}
	
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(Tank.GUI_NAME);
		Arrays.asList(Tank.UNIT_TYPES.values()).forEach(e->_gui.addItem(e.name(), e.ordinal()));
		return _gui;
	}
}
