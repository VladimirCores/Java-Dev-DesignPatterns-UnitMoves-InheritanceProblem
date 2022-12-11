package app.composition.entries.terrain;

import app.composition.entries.UnitComposed;
import app.inheritance.entities.Unit;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;
import java.util.Arrays;

public class Medik extends UnitComposed {
  static public final String GUI_NAME = "Medik Special Mode:";

  public Medik(PApplet canvas) {
    super(canvas);
  }

  public Medik(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getGUIName() {
    return Medik.GUI_NAME;
  }

  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _originalColor = H.CYAN;
    _strokeColor = H.BLUE;
    _strokeSize = 5;
    setRadius(20f);
  }
}
