package app.entities.terran;

import java.awt.Point;
import java.util.Arrays;

import app.entities.Unit;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class Marine extends Unit 
{
	static public final String GUI_NAME = "Marin Special Mode:";
	
	public enum UNIT_TYPES {
		TRENCH,
		RUNNING,
		JUMPING,
		_BACK
	}
	
	public Marine(PApplet canvas) { super(canvas); }
	public Marine(PApplet canvas, Point position) { super(canvas, position); }
	
	@Override
	protected void SetupUnit() {
		super.SetupUnit();
		_unitType = Unit.UNIT_TYPE.MARINE.name();
		_originalColor = H.BLUE;
		_strokeColor = H.WHITE;
		_strokeSize = 3;
		setRadius(30f);
	}
		
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(Marine.GUI_NAME);
		Arrays.asList(Marine.UNIT_TYPES.values()).forEach(e->_gui.addItem(e.name(), e.ordinal()));
		return _gui;
	}
}
