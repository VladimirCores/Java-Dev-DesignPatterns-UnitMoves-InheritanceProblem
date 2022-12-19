package base;

import controlP5.Controller;
import controlP5.DropdownList;
import interfaces.unit.IUnit;
import processing.core.PApplet;

import java.awt.*;

public class BaseUnit implements IUnit {
  public final static float DEFAULT_SIZE = 25f;

  static public final String GUI_NAME = "Unit Modes:";
  public Point position = new Point(0, 0);
  protected PApplet _canvas;
  protected DropdownList _gui;
  protected int _originalColor;
  protected int _strokeSize;
  protected int _strokeColor = -1;

  private int _color;
  private float _radius;

  public boolean getHasGUI() { return _gui != null; }

  public BaseUnit(PApplet canvas) {
    _canvas = canvas;
  }

  public BaseUnit(PApplet canvas, Point position) {
    this(canvas);
    this.position = position;
  }

  public void init() {}

  protected void SetupUnit() { }

  public void draw() {
    if (_radius > 0) {
      if (_strokeSize > 0) {
        _canvas.stroke(_strokeColor);
        _canvas.strokeWeight(_strokeSize);
      }
      _canvas.fill(_color);
      _canvas.ellipse(position.x, position.y, _radius, _radius);
    }
  }

  public void update(int deltaTime) {}

  public Point getPosition() {
    return position;
  }

  protected void setColor(int color) {
    _color = color;
  }

  public void selectUnit(int selectionColor) {
    setColor(selectionColor);
  }

  public void resetSelection() {
    setColor(_originalColor);
  }

  public void move(int toX, int toY) {}

  public String getUnitType() {
    return "";
  }

  public float getRadius() {
    return _radius;
  }

  public void setRadius(float radius) {
    _radius = radius;
  }

  public void removeGUI() {
    if (getHasGUI()) {
      _gui.removeCallback();
      _gui.remove();
      _gui = null;
      System.out.println("> BaseUnit: removeGUI");
    }
  }

  public Controller<?> getGUI() {
    return null;
  }

  public void distroy() {
    System.out.println("> BaseUnit: distroy, hasGui = " + getHasGUI());
    if (getHasGUI()) removeGUI();
    _canvas = null;
  }
}
