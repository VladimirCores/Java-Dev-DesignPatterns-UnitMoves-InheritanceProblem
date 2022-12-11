package app.composition.algorithm;

import de.looksgood.ani.Ani;
import interfaces.algorithm.IMoveAlgorithm;
import interfaces.unit.IUnit;

import java.awt.*;

public class JumpMoveAlgorithm implements IMoveAlgorithm {
  public float radius;
  public float _originalRadius;
  private boolean _isJumping = false;
  private Point _destinationPosition;
  private IUnit _unit;
  Ani _ani;

  public JumpMoveAlgorithm() {
    _ani = new Ani(
        this,
        0.3f,
        "radius",
        0,
        Ani.LINEAR,
        "onUpdate:onAnimUpdate, onEnd:onAnimEnded"
    );
    _ani.pause();
  }

  @Override
  public void move(IUnit unit, int x, int y) {
    if (_isJumping) return;

    _isJumping = true;
    _destinationPosition = new Point(x, y);
    _originalRadius = unit.getRadius();
    _unit = unit;

    _ani.setBegin(unit.getRadius());
    _ani.start();
  }

  void onAnimUpdate() {
    System.out.println("onAnimUpdate = " + radius);
    if (_unit != null) _unit.setRadius(radius);
  }

  void onAnimEnded(Ani theAni) {
    System.out.println("onAnimEnded");
    if (_destinationPosition == null) {
      _unit.setRadius(_originalRadius);
      _isJumping = false;
      _unit = null;
      _ani.reverse();
    } else {
      _unit.getPosition().setLocation(_destinationPosition);
      _destinationPosition = null;
      _ani.reverse();
      _ani.start();
    }
  }
}
