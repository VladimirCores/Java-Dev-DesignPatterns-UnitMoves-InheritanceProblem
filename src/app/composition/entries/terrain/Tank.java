package app.composition.entries.terrain;

import app.composition.entries.UnitComposed;
import app.inheritance.entities.Unit;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;
import java.util.Arrays;

public class Tank extends UnitComposed {
  static public final String GUI_NAME = "Tank Modes:";

  public Tank(PApplet canvas, Point position) {
    super(canvas, position);
  }

  public String getGUIName() {
    return Tank.GUI_NAME;
  }

  protected void SetupUnit() {
    super.SetupUnit();
    _originalColor = H.RED;
    _strokeSize = 5;
    _speed = 100;
    setRadius(50f);
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(Tank.GUI_NAME);
    Arrays.asList(UNIT_TYPES.values()).forEach(e -> _gui.addItem(e.name(), e.ordinal()));
    return _gui;
  }

  public enum UNIT_TYPES {
    WALK,
    TURELL,
    _BACK
  }
}
