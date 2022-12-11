package app.inheritance;

import app.inheritance.controllers.InheritanceGUIController;
import app.inheritance.entities.Unit;
import base.BaseApplication;
import base.BaseUnit;
import interfaces.algorithm.IMoveAlgorithm;
import interfaces.unit.IUnitProcessor;
import processing.core.PApplet;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InheritanceApplication extends BaseApplication implements IUnitProcessor {
  private boolean _isNewUnitCreated = false;
  @Override
  public void setup() {
    super.setup();

    _guiController = new InheritanceGUIController(this);

    _units.add(new Unit(this));
    _units.add(new Unit(this));
    _units.add(new Unit(this));
    _units.add(new Unit(this));
    _units.add(new Unit(this));
    _units.add(new Unit(this));
    _units.add(new Unit(this));
    _units.forEach(BaseUnit::init);
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

  @Override
  public void changeUnitMoveAlgorithm(IMoveAlgorithm algorithm) {

  }
}
