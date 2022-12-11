package base;

import app.inheritance.entities.Unit;
import controlP5.CallbackListener;
import controlP5.Controller;
import de.looksgood.ani.Ani;
import hype.H;
import processing.core.PApplet;
import processing.event.MouseEvent;

import java.awt.*;
import java.util.ArrayList;

public class BaseApplication extends PApplet {
  static private final int SIZE = 800;

  static private final int COLOR_SELECTED = H.YELLOW;

  protected Unit _selectedUnit;
  int milliseconds = 0;
  int deltaTime = 0;
  int lastTime = 0;
  protected final ArrayList<BaseUnit> _units = new ArrayList<>();
  private Controller<?> _unitGUI;
  protected CallbackListener _guiController;

  public void settings() {
    size(SIZE, SIZE);
  }

  public void setup() {
    Ani.init(this);
    Ani.autostart();
    ellipseMode(RADIUS);
  }

  public boolean canMoveUnit() { return true; }

  @Override
  public void mouseReleased(MouseEvent event) {
    boolean isMouseOverMenu = _unitGUI != null && _unitGUI.isMouseOver();
    if (isMouseOverMenu) return;
    if (!canMoveUnit()) return;

    int clickX = event.getX();
    int clickY = event.getY();

    Unit unit = (Unit) FindClosesUnitAtPosition(clickX, clickY, SIZE);
    boolean isUnitFound = unit != null;

    if (isUnitFound) SelectUnit(unit);
    else if (_selectedUnit != null) {
      _selectedUnit.move(clickX, clickY);
    }
  }

  private BaseUnit FindClosesUnitAtPosition(int clickX, int clickY, int closestDistance) {
    BaseUnit foundUnit = null;
    for (BaseUnit unit : _units) {
      Point position = unit.getPosition();
      int hypo = (int) Math.hypot(clickX - position.x, clickY - position.y);
      boolean isClickedOnUnit = hypo < unit.getRadius();
      boolean isClickedCloser = hypo < closestDistance;
      if (isClickedOnUnit && isClickedCloser) {
        if (_selectedUnit == unit) continue;
        else foundUnit = unit;
        closestDistance = hypo;
      }
    }
    return foundUnit;
  }

  protected void SelectUnit(Unit unit) {
    if (_selectedUnit != null) {
      _selectedUnit.resetSelection();
      _selectedUnit.removeGUI();
    }

    unit.selectUnit(COLOR_SELECTED);
    _selectedUnit = unit;
    _unitGUI = _selectedUnit.getGUI();

    if (_unitGUI != null) {
      _unitGUI.bringToFront();
      _unitGUI.addCallback(_guiController);
    }

    System.out.println("Unit Selected: radius = " + _selectedUnit.getUnitType() + "; position: " + _selectedUnit.getPosition().toString());
  }

  public void draw() {
    this.clear();
    this.background(color(10, 10, 10));

    milliseconds = millis();
    deltaTime = milliseconds - lastTime;

    _units.forEach(u -> {
      u.update(deltaTime);
      u.draw();
    });

    lastTime = milliseconds;
  }
}
