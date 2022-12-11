package interfaces.unit;

import controlP5.Controller;

import java.awt.*;

public interface IUnit {
  void move(int x, int y);
  Controller<?> getGUI();
  void removeGUI();
  Point getPosition();
  float getRadius();
  void setRadius(float value);
  String getUnitType();
  void resetSelection();
  void selectUnit(int selectionColor);
  void draw();
  void update(int deltaTime);
}
