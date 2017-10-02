package app.entities.terran.marine;

import java.awt.Point;

import app.entities.terran.Marine;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

public class JumpingMarine extends Marine {

	private Boolean _jumping = false;
	private Point _jumpDestinationPosition;
	private float _originalRadius;
	
	static public final String GUI_NAME = "JumpingMarin Types:";
	
	public enum UNIT_TYPES {
		_BACK_TO_MARINE
	}
	
	public JumpingMarine(PApplet canvas) {
		super(canvas);
	}
	
	public JumpingMarine(PApplet canvas, Point position) {
		super(canvas, position);
	}
	
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
		_gui = new ControlP5(_canvas).addDropdownList(JumpingMarine.GUI_NAME);
		_gui.addItem(JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.name(), JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal());
		return _gui;
	}
}
