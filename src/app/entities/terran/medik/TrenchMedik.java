package app.entities.terran.medik;

import java.awt.Point;

import app.entities.terran.Medik;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class TrenchMedik extends Medik 
{
	static public final String GUI_NAME = "TrenchMedik Mode:";
		
	public enum UNIT_TYPES {
		_BACK_TO_MEDIK
	}
	
	public TrenchMedik(PApplet canvas) { super(canvas); }
	public TrenchMedik(PApplet canvas, Point position) { super(canvas, position); }
	
	@Override
	protected void SetupUnit() {
		super.SetupUnit();
		_speed = 0;
		_strokeColor = H.WHITE;
		_strokeSize = 4;
		setRadius(20);
	}
	
	@Override
	public void move(int toX, int toY) { System.out.println("> TrenchMedik: Can't move.");}
	
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(TrenchMedik.GUI_NAME);
		_gui.addItem(TrenchMedik.UNIT_TYPES._BACK_TO_MEDIK.name(), TrenchMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal());
		return _gui;
	}
}
