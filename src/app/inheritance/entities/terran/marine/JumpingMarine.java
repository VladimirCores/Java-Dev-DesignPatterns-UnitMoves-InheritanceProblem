package app.inheritance.entities.terran.marine;

import app.inheritance.entities.terran.Marine;
import controlP5.ControlP5;
import controlP5.Controller;
import hype.H;
import processing.core.PApplet;

import java.awt.*;

public class JumpingMarine extends Marine {

  static public final String GUI_NAME = "Jumping Marin Types:";
  private Boolean _jumping = false;
  private Point _jumpDestinationPosition;
  private float _originalRadius;

  public JumpingMarine(PApplet canvas) {
    super(canvas);
  }

  public JumpingMarine(PApplet canvas, Point position) {
    super(canvas, position);
  }

  @Override
  public String getUnitType() {
    return Marine.UNIT_TYPES.JUMPING.name();
  }

  @Override
  protected void SetupUnit() {
    super.SetupUnit();
    _strokeColor = H.RED;
  }

  public void update(int deltaTime) {
    if (_jumping) {
      float radius = getRadius();
      float increament = _originalRadius / (deltaTime * 0.5f);
      radius = radius + (_jumpDestinationPosition != null ? -increament : increament);
      if (radius >= _originalRadius) {
        radius = _originalRadius;
        _jumping = false;
      } else if (radius < 0) {
        this.position.setLocation(_jumpDestinationPosition);
        _jumpDestinationPosition = null;
        radius = 0;
      }
      setRadius(radius);
    }
  }

  public void move(int toX, int toY) {
    if (_jumping) return;

    _jumping = true;
    _jumpDestinationPosition = new Point(toX, toY);
    _originalRadius = getRadius();
  }

  @Override
  public Controller<?> getGUI() {
    _gui = new ControlP5(_canvas).addDropdownList(JumpingMarine.GUI_NAME);
    _gui.addItem(JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.name(), JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal());
    return _gui;
  }

  public enum UNIT_TYPES {
    _BACK_TO_MARINE
  }
}
