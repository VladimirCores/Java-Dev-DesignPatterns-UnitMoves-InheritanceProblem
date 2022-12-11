package app.composition.entries;

import app.composition.algorithm.JumpMoveAlgorithm;
import app.composition.algorithm.WalkMoveAlgorithm;
import app.inheritance.entities.Unit;
import app.inheritance.entities.terran.Marine;
import controlP5.ControlP5;
import controlP5.Controller;
import interfaces.algorithm.IMoveAlgorithm;
import interfaces.unit.IUnitComposable;
import processing.core.PApplet;

import java.awt.*;
import java.util.Arrays;

public class UnitComposed extends Unit implements IUnitComposable {
  private IMoveAlgorithm _moveAlgorithm;

  public UnitComposed(PApplet canvas) {
    this(canvas, new Point(0, 0));
  }

  public UnitComposed(PApplet canvas, Point position) {
    super(canvas, position);
    setMoveAlgorithm(new WalkMoveAlgorithm());
  }

  @Override
  public String getGUIName() {
    return GUI_NAME;
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(getGUIName());
    if (this.getClass().equals(UnitComposed.class)) {
      Arrays.asList(Unit.UNIT_TYPE.values()).forEach(e -> _gui.addItem(e.name(), e.ordinal()));
    } else {
      Arrays.asList(UNIT_MOVE_TYPE.values()).forEach(e -> _gui.addItem(e.name(), e.ordinal()));
    }
    return _gui;
  }

  @Override
  public void move(int toX, int toY) {
    System.out.println("UnitComposed -> move: position = " + getPosition().toString());
    if (_moveAlgorithm != null) {
      _moveAlgorithm.move(this, toX, toY);
    }
  }

  public void setMoveAlgorithm(IMoveAlgorithm algorithm) {
    _moveAlgorithm = algorithm;
  }

  public enum UNIT_MOVE_TYPE {
    TRENCH,
    RUNNING,
    JUMPING,
    WALK,
    _BACK
  }
}
