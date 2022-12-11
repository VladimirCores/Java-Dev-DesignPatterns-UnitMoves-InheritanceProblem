package app.inheritance.entities.terran.medik;

import app.inheritance.entities.terran.Medik;
import consts.Defaults;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;

public class RunningMedik extends Medik {
  static public final String GUI_NAME = "RunningMedik Mode:";

  public RunningMedik(PApplet canvas) {
    super(canvas);
  }

  public RunningMedik(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getUnitType() {
    return Medik.UNIT_TYPES.RUNNING.name();
  }

  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _speed = Defaults.SPEED_RUN;
    _strokeColor = H.MAGENTA;
    _strokeSize = 2;
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(RunningMedik.GUI_NAME);
    _gui.addItem(RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.name(), RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal());
    return _gui;
  }

  public enum UNIT_TYPES {
    _BACK_TO_MEDIK
  }
}
