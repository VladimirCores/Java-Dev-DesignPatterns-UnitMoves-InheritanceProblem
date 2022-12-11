package app.composition;

import app.composition.controllers.CompositionGUIController;
import app.composition.entries.UnitComposed;
import app.inheritance.entities.Unit;
import base.BaseApplication;
import base.BaseUnit;
import interfaces.algorithm.IMoveAlgorithm;
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

    _units.add(new UnitComposed(this));
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

  @Override
  public void changeUnitMoveAlgorithm(IMoveAlgorithm algorithm) {
    System.out.println("> CompositionApplication: " + algorithm);
    if (_selectedUnit != null) {
      UnitComposed unitComposed = (UnitComposed) _selectedUnit;
      unitComposed.setMoveAlgorithm(algorithm);
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
