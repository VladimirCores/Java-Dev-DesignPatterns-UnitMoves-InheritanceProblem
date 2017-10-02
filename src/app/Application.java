package app;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import app.controllers.UnitsController;
import app.entities.Unit;
import app.interfaces.unit.IUnitProcessor;
import controlP5.Controller;
import de.looksgood.ani.Ani;
import hype.H;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class Application extends PApplet implements IUnitProcessor
{
	static private final int SIZE = 800;
	
	static private final int COLOR_SELECTED = H.YELLOW;
	
	Unit _selectedUnit;
	
	private boolean 
		_isSelectedUnitMovePossible,
		_isNewUnitCreated = false;
	
	private int 	
		_closestClickToUnitDistance;
	
	private UnitsController _unitsController;
	private ArrayList<Unit> _units = new ArrayList<>();
	private Controller<?> _unitGUI;
	
	public void settings() { size(SIZE,SIZE); }

	public void setup() 
	{
		Ani.init(this);
		Ani.autostart();
		ellipseMode(RADIUS);
		
		_unitsController = new UnitsController((IUnitProcessor)this); 
		
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.add(new Unit(this));
		_units.forEach(u->u.init());
	}

	public void mouseReleased(MouseEvent event) 
	{
		if(_unitGUI != null && _unitGUI.isMouseOver()) return;
		if(_isNewUnitCreated) { _isNewUnitCreated = false; return; }
		
		int clickX = event.getX();
		int clickY = event.getY();
		
		_closestClickToUnitDistance = SIZE;
		_isSelectedUnitMovePossible = true;
		_units.forEach(u -> {
			int hypot = (int)Math.hypot(clickX - u.x, clickY - u.y);
			if(hypot < u.getRadius() && hypot < _closestClickToUnitDistance) 
			{
				if(_selectedUnit != null && _selectedUnit == u) return;
				SelectUnit(u);
				_closestClickToUnitDistance = hypot;
			}
		});
		
		if(_isSelectedUnitMovePossible && _selectedUnit != null) 
		{
			_selectedUnit.move(clickX, clickY);
		}
	}
	
	private void SelectUnit(Unit u) 
	{
		if(_selectedUnit != null) {
			_selectedUnit.resetSelection();
			_selectedUnit.removeGUI();
		} 
		
		u.selectUnit(COLOR_SELECTED);
		_selectedUnit = u;
		_unitGUI = _selectedUnit.getGUI();
		if(_unitGUI != null) {
			_unitGUI.bringToFront();
			_unitGUI.addCallback(_unitsController);
		}
		
		_isSelectedUnitMovePossible = false;
		
		System.out.println("Unit Selected: radius = " + _selectedUnit.getUnitType() + "; closesDistance = " + _closestClickToUnitDistance + "; position: " + _selectedUnit.getPosition().toString());
	}

	int milliseconds = 0;
	int deltaTime = 0;
	int lastTime = 0;
	public void draw() 
	{
		this.clear();
		this.background(color(10,10,10));
		milliseconds = millis(); 
		deltaTime = milliseconds - lastTime;
		_units.forEach(u -> {
			u.update(deltaTime);
			u.draw();
		});
		lastTime = milliseconds;
	}
	
	public void replaceSelectedUnitWithNew(Class<?> unitClass) {
		try {
			Constructor<?> constuctor = unitClass.getConstructor(PApplet.class, Point.class);
			replaceUnitWithNew(_selectedUnit, (Unit)constuctor.newInstance(this, _selectedUnit.getPosition()));
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void replaceUnitWithNew(Unit originalUnit, Unit newUnit) 
	{
		SelectUnit(newUnit);
		_units.add(_selectedUnit);
		_units.remove(originalUnit);
		originalUnit.distroy();
		_isNewUnitCreated = true;
	}
}
