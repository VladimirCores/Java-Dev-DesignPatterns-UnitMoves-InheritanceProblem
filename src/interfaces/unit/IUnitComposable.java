package interfaces.unit;

import interfaces.algorithm.IMoveAlgorithm;

public interface IUnitComposable {
  void setMoveAlgorithm(IMoveAlgorithm algorithm);
  String getGUIName();
}
