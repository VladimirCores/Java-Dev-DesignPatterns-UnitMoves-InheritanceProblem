package app.composition;

import app.composition.controllers.CompositionGUIController;
import app.inheritance.entities.Unit;
import base.BaseApplication;
import interfaces.unit.IUnitProcessor;
import processing.core.PApplet;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CompositionApplication extends BaseApplication implements IUnitProcessor {
  private boolean _isNewUnitCreated = false;
  @Override
  public void setup() {
    super.setup();

    _guiController = new CompositionGUIController(this);

    _units.add(new Unit(this));
    _units.forEach(Unit::init);
  }

  @Override
  public boolean canMoveUnit() {
    boolean result = !_isNewUnitCreated;
    _isNewUnitCreated = false;
    return result;
  }

  public void replaceSelectedUnitWithNew(Class<?> unitClass) {
    try {
      Constructor<?> constuctor = unitClass.getConstructor(PApplet.class, Point.class);
      replaceUnitWithNew(_selectedUnit, (Unit) constuctor.newInstance(this, _selectedUnit.getPosition()));
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException |
             IllegalArgumentException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  public void replaceUnitWithNew(Unit originalUnit, Unit newUnit) {
    SelectUnit(newUnit);
    _units.add(_selectedUnit);
    _units.remove(originalUnit);
    originalUnit.distroy();
    _isNewUnitCreated = true;
  }
}
