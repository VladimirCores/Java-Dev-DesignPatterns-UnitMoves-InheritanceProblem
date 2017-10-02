package app.entities.terran.medik;

import java.awt.Point;

import app.entities.terran.Medik;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class RunningMedik extends Medik 
{
	static public final String GUI_NAME = "RunningMedik Mode:";
		
	public enum UNIT_TYPES {
		_BACK_TO_MEDIK
	}
	
	public RunningMedik(PApplet canvas) { super(canvas); }
	public RunningMedik(PApplet canvas, Point position) { super(canvas, position); }
	
	@Override
	protected void SetupUnit() {
		super.SetupUnit();
		_unitType = Medik.UNIT_TYPES.RUNNING.name();
		_speed = 600;
		_strokeColor = H.MAGENTA;
		_strokeSize = 2;
	}
	
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(RunningMedik.GUI_NAME);
		_gui.addItem(RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.name(), RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal());
		return _gui;
	}
}
