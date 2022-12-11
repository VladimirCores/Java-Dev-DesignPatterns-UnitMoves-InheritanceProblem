package interfaces.unit;

import interfaces.algorithm.IMoveAlgorithm;

public interface IUnitComposed extends IUnit, IMoveAlgorithm {
  void setMoveAlgorithm(IMoveAlgorithm algorithm);
}
