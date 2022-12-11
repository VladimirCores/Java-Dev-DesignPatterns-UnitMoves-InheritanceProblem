package app.inheritance.entities.terran;

import app.inheritance.entities.Unit;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;
import java.util.Arrays;

public class Marine extends Unit {
  static public final String GUI_NAME = "Marin Special Mode:";

  public Marine(PApplet canvas) {
    super(canvas);
  }

  public Marine(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getUnitType() {
    return Unit.UNIT_TYPE.MARINE.name();
  }

  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _originalColor = H.BLUE;
    _strokeColor = H.WHITE;
    _strokeSize = 3;
    setRadius(30f);
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(Marine.GUI_NAME);
    Arrays.asList(Marine.UNIT_TYPES.values()).forEach(e -> _gui.addItem(e.name(), e.ordinal()));
    return _gui;
  }

  public enum UNIT_TYPES {
    TRENCH,
    RUNNING,
    JUMPING,
    _BACK
  }
}
