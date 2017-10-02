package app.entities.terran;

import java.awt.Point;
import java.util.Arrays;

import app.entities.Unit;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class Medik extends Unit 
{
	static public final String GUI_NAME = "Medik Special Mode:";
	
	public enum UNIT_TYPES {
		TRENCH,
		RUNNING,
		JUMPING,
		_BACK
	}
	
	public Medik(PApplet canvas) { super(canvas); }
	public Medik(PApplet canvas, Point position) { super(canvas, position); }
	
	@Override
	protected void SetupUnit() {
		super.SetupUnit();
		_unitType = Unit.UNIT_TYPE.MEDIK.name();
		_originalColor = H.CYAN;
		_strokeColor = H.BLUE;
		_strokeSize = 5;
		setRadius(20f);
	}
		
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(Medik.GUI_NAME);
		Arrays.asList(Medik.UNIT_TYPES.values()).forEach(e->_gui.addItem(e.name(), e.ordinal()));
		return _gui;
	}
}
