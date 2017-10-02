package app.entities;

import java.awt.Point;
import java.util.Arrays;

import app.interfaces.unit.IUnit;
import controlP5.ControlP5;
import controlP5.Controller;
import controlP5.DropdownList;
import de.looksgood.ani.Ani;
import hype.H;
import processing.core.PApplet;

public class Unit implements IUnit
{	
	public final static float DEFAULT_SIZE = 25f;

	static public final String GUI_NAME = "Unit Modes";
	
	public enum UNIT_TYPE {
		UNIT,
		MARINE,
		MEDIK,
		TANK
	}
	
	protected PApplet _canvas;
	protected DropdownList _gui;
	protected int _originalColor;
	protected int _speed;
	protected int _strokeSize;
	protected int _strokeColor = -1;
	protected String _unitType;
	
	private int 	_color;
	private float 	_radius;
	
	public float x, y;
	
	public Unit(PApplet canvas) 
	{
		_canvas = canvas;
		SetupUnit();
	}
	
	public Unit(PApplet canvas, Point position) 
	{
		this(canvas);
		this.x = position.x;
		this.y = position.y;
	}	
	
	public void init() {
		setColor( _originalColor );
		int offsetX = (int)(_canvas.width * 0.3);
		int offsetY = (int)(_canvas.height * 0.3);
		x = offsetX + (float)((_canvas.width - offsetX * 2) * Math.random());
		y = offsetY + (float)((_canvas.height - offsetY * 2) * Math.random());
	}	
	
	protected void SetupUnit() {
		_unitType = UNIT_TYPE.UNIT.name();
		_originalColor = H.WHITE;
		_strokeColor = _canvas.color(200, 0, 200);
		_strokeSize = 2;
		_radius = DEFAULT_SIZE;
		_speed = 200;
	}
	
	public void draw() 
	{
		if(_radius > 0) {
			if(_strokeSize > 0) {
				_canvas.stroke(_strokeColor);
				_canvas.strokeWeight(_strokeSize);
			}
			_canvas.fill(_color);
			_canvas.ellipse(x, y, _radius, _radius);
		}
	}
	
	public void update(int deltaTime) {}
	
	public Point getPosition() { return new Point((int)this.x, (int)this.y); }
	
	private void setColor(int color) { _color = color; }
	
	public void selectUnit(int selectionColor) {
		setColor(selectionColor);
	}
	
	public void resetSelection() {
		setColor(_originalColor);
	}
	
	public void move(int toX, int toY) 
	{
		float distance = (float)Math.abs(Point.distance(this.x, this.y, toX, toY));
		float time = distance / _speed;

		if(time < 0.1) time = 0.1f;
	
		Ani.to(this, time, "y", toY, Ani.LINEAR);
		Ani.to(this, time, "x", toX, Ani.LINEAR);
	}
	
	public String getUnitType() {
		return _unitType;
	}
	
	public float getRadius() {
		return _radius;
	}
	
	protected void setRadius(float radius) {
		_radius = radius;
	}		
	
	public void changeSpeed(int value) {
		_speed = value;
	}
	
	public void removeGUI() {
		if(_gui != null) {
			_gui.removeCallback();
			
			_gui.remove();
			_gui = null;
		}
	}
	
	public Controller<?> getGUI() {
		_gui = new ControlP5(_canvas).addDropdownList(GUI_NAME);
		Arrays.asList(UNIT_TYPE.values()).forEach(e->_gui.addItem(e.name(), e.ordinal()));
		return _gui;
	}

	public void distroy() {
		if(_gui != null) removeGUI();
		_canvas = null;
	}
}
