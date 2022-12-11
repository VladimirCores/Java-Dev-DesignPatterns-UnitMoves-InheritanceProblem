package app.composition.algorithm;

import consts.Defaults;
import de.looksgood.ani.Ani;
import interfaces.algorithm.IMoveAlgorithm;
import interfaces.unit.IUnit;

import java.awt.*;

public class RunMoveAlgorithm extends WalkMoveAlgorithm {
  public RunMoveAlgorithm() {
    _speed = Defaults.SPEED_RUN;
  }
}
