package app.composition.entries.terrain;

import app.composition.entries.UnitComposed;
import app.inheritance.entities.Unit;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;
import java.util.Arrays;

public class Marine extends UnitComposed {
  static public final String GUI_NAME = "Marin Special Mode:";

  public Marine(PApplet canvas) {
    super(canvas);
  }

  public Marine(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getUnitType() {
    return UNIT_TYPE.MARINE.name();
  }

  @Override
  public String getGUIName() {
    return Marine.GUI_NAME;
  }

  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _originalColor = H.BLUE;
    _strokeColor = H.WHITE;
    _strokeSize = 3;
    setRadius(30f);
  }
}
