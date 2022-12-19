package app.inheritance.entities.terran.marine;

import app.inheritance.entities.terran.Marine;
import consts.Defaults;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;

public class RunningMarine extends Marine {
  static public final String GUI_NAME = "Running Marin Mode:";

  public RunningMarine(PApplet canvas) {
    super(canvas);
  }

  public RunningMarine(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getUnitType() {
    return Marine.UNIT_TYPES.RUNNING.name();
  }

  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _speed = Defaults.SPEED_RUN;
    _strokeColor = H.CYAN;
    _strokeSize = 2;
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(RunningMarine.GUI_NAME);
    _gui.addItem(RunningMarine.UNIT_TYPES._BACK_TO_MARINE.name(), RunningMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal());
    return _gui;
  }

  public enum UNIT_TYPES {
    _BACK_TO_MARINE
  }
}
