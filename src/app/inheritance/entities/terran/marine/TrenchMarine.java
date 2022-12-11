package app.inheritance.entities.terran.marine;

import app.inheritance.entities.terran.Marine;
import app.inheritance.entities.terran.Medik;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;

public class TrenchMarine extends Marine {
  static public final String GUI_NAME = "TrenchMarin Mode:";

  public TrenchMarine(PApplet canvas) {
    super(canvas);
  }

  public TrenchMarine(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getUnitType() {
    return Marine.UNIT_TYPES.TRENCH.name();
  }

  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _speed = 0;
    _strokeColor = H.BLUE;
    _strokeSize = 1;
    setRadius(20);
  }

  @Override
  public void move(int toX, int toY) {
    System.out.println("> TrenchMarine: Can't move.");
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(TrenchMarine.GUI_NAME);
    _gui.addItem(TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.name(), TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal());
    return _gui;
  }

  public enum UNIT_TYPES {
    _BACK_TO_MARINE
  }
}
