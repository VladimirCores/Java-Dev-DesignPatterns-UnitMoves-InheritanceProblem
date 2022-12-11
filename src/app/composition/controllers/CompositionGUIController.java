package app.composition.controllers;

import app.composition.algorithm.JumpMoveAlgorithm;
import app.composition.algorithm.RunMoveAlgorithm;
import app.composition.algorithm.TrenchMoveAlgorithm;
import app.composition.algorithm.WalkMoveAlgorithm;
import app.composition.entries.UnitComposed;
import app.composition.entries.terrain.Marine;
import app.composition.entries.terrain.Medik;
import app.composition.entries.terrain.Tank;
import app.inheritance.entities.Unit;
import app.inheritance.entities.terran.tank.TurellTank;
import controlP5.CallbackEvent;
import controlP5.CallbackListener;
import controlP5.Controller;
import interfaces.algorithm.IMoveAlgorithm;
import interfaces.unit.IUnitProcessor;

import java.util.HashMap;
import java.util.Map;

public class CompositionGUIController implements CallbackListener {

  private int _lastEventHash = 0;
  private final IUnitProcessor _unitProcessor;

  HashMap unitMoveTypes = new HashMap() {{
    put(UnitComposed.UNIT_MOVE_TYPE._BACK.ordinal(), UnitComposed.class);
    put(UnitComposed.UNIT_MOVE_TYPE.WALK.ordinal(), new WalkMoveAlgorithm());
    put(UnitComposed.UNIT_MOVE_TYPE.RUNNING.ordinal(), new RunMoveAlgorithm());
    put(UnitComposed.UNIT_MOVE_TYPE.JUMPING.ordinal(), new JumpMoveAlgorithm());
    put(UnitComposed.UNIT_MOVE_TYPE.TRENCH.ordinal(), new TrenchMoveAlgorithm());
  }};

  Map<String, Map<Integer, Object>> guiToFunctions = new HashMap() {{
    put(Unit.GUI_NAME, new HashMap() {{
      put(Unit.UNIT_TYPE.UNIT.ordinal(), Unit.class);
      put(Unit.UNIT_TYPE.MARINE.ordinal(), Marine.class);
      put(Unit.UNIT_TYPE.MEDIK.ordinal(), Medik.class);
      put(Unit.UNIT_TYPE.TANK.ordinal(), Tank.class);
    }});
    put(Marine.GUI_NAME, unitMoveTypes);
    put(Medik.GUI_NAME, unitMoveTypes);
    put(Tank.GUI_NAME, new HashMap() {{
      put(Tank.UNIT_TYPES._BACK.ordinal(), UnitComposed.class);
      put(Tank.UNIT_TYPES.WALK.ordinal(), new WalkMoveAlgorithm());
      put(Tank.UNIT_TYPES.TURELL.ordinal(), new TrenchMoveAlgorithm());
    }});
  }};

  public CompositionGUIController(IUnitProcessor unitProcessor) {
    _unitProcessor = unitProcessor;
  }

  @Override
  public void controlEvent(CallbackEvent evt) {
    if (_lastEventHash == evt.hashCode()) return;

    if (evt.getAction() == 100) {
      Controller<?> guiController = evt.getController();
      String guiName = evt.getController().getAddress();
      int selectedMenu = (int) guiController.getValue();

      System.out.println("> GUI SELECTED: " + guiName + " | " + selectedMenu);

      var menuFunction = guiToFunctions.get(getUnitMenuNameFromSelected(guiName));
      if (menuFunction != null) {
        Object func = menuFunction.get(selectedMenu);
        if (func instanceof Class) {
          _unitProcessor.replaceSelectedUnitWithNew((Class) menuFunction.get(selectedMenu));
        } else {
          _unitProcessor.changeUnitMoveAlgorithm((IMoveAlgorithm) func);
        }
      }
    }
    _lastEventHash = evt.hashCode();
  }

  private String getUnitMenuNameFromSelected(String selectedMenuName) {
    return selectedMenuName.substring(1);
  }
}
