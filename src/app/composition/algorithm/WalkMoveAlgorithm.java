package app.composition.algorithm;

import de.looksgood.ani.Ani;
import interfaces.algorithm.IMoveAlgorithm;
import consts.Defaults;
import interfaces.unit.IUnit;

import java.awt.*;

public class WalkMoveAlgorithm implements IMoveAlgorithm {
  protected int _speed;
  public WalkMoveAlgorithm() {
    _speed = Defaults.SPEED_WALK;
  }
  @Override
  public void move(IUnit unit, int x, int y) {
    Point position = unit.getPosition();
    float distance = (float) Math.abs(Point.distance(position.x, position.y, x, y));
    float time = distance / _speed;

    if (time < 0.1) time = 0.1f;

    Ani.to(position, time, "x", x, Ani.LINEAR);
    Ani.to(position, time, "y", y, Ani.LINEAR);
  }
}
