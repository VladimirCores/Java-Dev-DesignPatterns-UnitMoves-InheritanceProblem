package interfaces.unit;

import interfaces.algorithm.IMoveAlgorithm;

public interface IUnitProcessor {
  void replaceSelectedUnitWithNew(Class<?> newUnitClassName);
  void changeUnitMoveAlgorithm(IMoveAlgorithm algorithm);
}
