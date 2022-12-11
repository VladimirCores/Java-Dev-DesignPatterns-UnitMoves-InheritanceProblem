package interfaces.unit;

import controlP5.Controller;

public interface IUnit {
  void move(int x, int y);
  Controller<?> getGUI();
  void removeGUI();
  float getRadius();
  String getUnitType();
  void resetSelection();
  void selectUnit(int selectionColor);
  void draw();
  void update(int deltaTime);
}
