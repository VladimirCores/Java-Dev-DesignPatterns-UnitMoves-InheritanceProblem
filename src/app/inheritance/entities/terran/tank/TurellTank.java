package app.inheritance.entities.terran.tank;

import app.inheritance.entities.Unit;
import app.inheritance.entities.terran.Tank;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;

public class TurellTank extends Tank {
  static public final String GUI_NAME = "TurellTank Modes:";

  public TurellTank(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getUnitType() {
    return Tank.UNIT_TYPES.TURELL.name();
  }
  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _strokeColor = H.GREEN;
  }

  @Override
  public void move(int toX, int toY) {
    System.out.println("> TurellTank: Can't move.");
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(TurellTank.GUI_NAME);
    _gui.addItem(TurellTank.UNIT_TYPES._BACK_TO_TANK.name(), TurellTank.UNIT_TYPES._BACK_TO_TANK.ordinal());
    return _gui;
  }

  public enum UNIT_TYPES {
    _BACK_TO_TANK
  }
}
