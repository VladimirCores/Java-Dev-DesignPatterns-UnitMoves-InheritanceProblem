package app.entities.terran.medik;

import java.awt.Point;

import app.entities.terran.Medik;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class JumpingMedik extends Medik {

	private Boolean _jumping = false;
	private Point _jumpDestinationPosition;
	private float _originalRadius;
	
	static public final String GUI_NAME = "JumpingMedik Types:";
	
	public enum UNIT_TYPES {
		_BACK_TO_MEDIK
	}
	
	public JumpingMedik(PApplet canvas) { super(canvas); }
	public JumpingMedik(PApplet canvas, Point position) { super(canvas, position); }
	
	@Override
	protected void SetupUnit() {
		super.SetupUnit();
		_strokeColor = H.RED;
	}
	
	public void update(int deltaTime) 
	{
		if(_jumping) {
			float radius = getRadius();
			float increament = _originalRadius / (deltaTime * 0.5f);
			radius = radius + (_jumpDestinationPosition != null ? -increament : increament);
			if(radius >= _originalRadius) {
				radius = _originalRadius;
				_jumping = false;
			}
			else if(radius < 0) 
			{
				this.x = _jumpDestinationPosition.x;
				this.y = _jumpDestinationPosition.y;
				_jumpDestinationPosition = null;
				radius = 0;
			}
			setRadius(radius);	
		}
	}

	public void move(int toX, int toY) 
	{
		if(_jumping) return;
		
		_jumping = true;
		_jumpDestinationPosition = new Point(toX, toY);
		_originalRadius = getRadius();
	}
	
	@Override
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(JumpingMedik.GUI_NAME);
		_gui.addItem(JumpingMedik.UNIT_TYPES._BACK_TO_MEDIK.name(), JumpingMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal());
		return _gui;
	}
}
