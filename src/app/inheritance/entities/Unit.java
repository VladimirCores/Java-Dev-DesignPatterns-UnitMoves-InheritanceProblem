package app.inheritance.entities;

import base.BaseUnit;
import interfaces.unit.IUnit;
import controlP5.ControlP5;
import controlP5.Controller;
import controlP5.DropdownList;
import de.looksgood.ani.Ani;
import hype.H;
import processing.core.PApplet;

import java.awt.*;
import java.util.Arrays;

public class Unit extends BaseUnit {
  protected int _speed;

  @Override
  public String getUnitType() {
    return UNIT_TYPE.UNIT.name();
  }

  public Unit(PApplet canvas) {
    super(canvas);
    SetupUnit();
  }
  @Override
  protected void SetupUnit() {
    _originalColor = H.WHITE;
    _strokeColor = _canvas.color(200, 0, 200);
    _strokeSize = 2;
    _speed = 200;
    setRadius(DEFAULT_SIZE);
  }

  public Unit(PApplet canvas, Point position) {
    this(canvas);
    this.x = position.x;
    this.y = position.y;
  }

  public void init() {
    setColor(_originalColor);
    int offsetX = (int) (_canvas.width * 0.3);
    int offsetY = (int) (_canvas.height * 0.3);
    x = offsetX + (float) ((_canvas.width - offsetX * 2) * Math.random());
    y = offsetY + (float) ((_canvas.height - offsetY * 2) * Math.random());
  }

  public Point getPosition() {
    return new Point((int) this.x, (int) this.y);
  }

  public void move(int toX, int toY) {
    float distance = (float) Math.abs(Point.distance(this.x, this.y, toX, toY));
    float time = distance / _speed;

    if (time < 0.1) time = 0.1f;

    Ani.to(this, time, "y", toY, Ani.LINEAR);
    Ani.to(this, time, "x", toX, Ani.LINEAR);
  }

  public void changeSpeed(int value) {
    _speed = value;
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(GUI_NAME);
    Arrays.asList(UNIT_TYPE.values()).forEach(e -> _gui.addItem(e.name(), e.ordinal()));
    return _gui;
  }

  public enum UNIT_TYPE {
    UNIT,
    MARINE,
    MEDIK,
    TANK
  }
}
