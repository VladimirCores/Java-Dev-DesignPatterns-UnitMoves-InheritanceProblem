package app.inheritance.controllers;

import app.inheritance.entities.Unit;
import app.inheritance.entities.terran.Marine;
import app.inheritance.entities.terran.Medik;
import app.inheritance.entities.terran.Tank;
import app.inheritance.entities.terran.marine.JumpingMarine;
import app.inheritance.entities.terran.marine.RunningMarine;
import app.inheritance.entities.terran.marine.TrenchMarine;
import app.inheritance.entities.terran.medik.JumpingMedik;
import app.inheritance.entities.terran.medik.RunningMedik;
import app.inheritance.entities.terran.medik.TrenchMedik;
import app.inheritance.entities.terran.tank.TurellTank;
import interfaces.unit.IUnitProcessor;
import controlP5.CallbackEvent;
import controlP5.CallbackListener;
import controlP5.Controller;

import java.util.HashMap;
import java.util.Map;

public class InheritanceGUIController implements CallbackListener {

  private int _lastEventHash = 0;
  private final IUnitProcessor _unitProcessor;

  Map<String, Map<Integer, Class>> guiToFunctions = new HashMap() {{
    put(Unit.GUI_NAME, new HashMap() {{
      put(Unit.UNIT_TYPE.UNIT.ordinal(), Unit.class);
      put(Unit.UNIT_TYPE.MARINE.ordinal(), Marine.class);
      put(Unit.UNIT_TYPE.MEDIK.ordinal(), Medik.class);
      put(Unit.UNIT_TYPE.TANK.ordinal(), Tank.class);
    }});
    put(Marine.GUI_NAME, new HashMap() {{
      put(Marine.UNIT_TYPES._BACK.ordinal(), Unit.class);
      put(Marine.UNIT_TYPES.JUMPING.ordinal(), JumpingMarine.class);
      put(Marine.UNIT_TYPES.RUNNING.ordinal(), RunningMarine.class);
      put(Marine.UNIT_TYPES.TRENCH.ordinal(), TrenchMarine.class);
    }});
    put(JumpingMarine.GUI_NAME, new HashMap() {{
      put(JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal(), Marine.class);
    }});
    put(TrenchMarine.GUI_NAME, new HashMap() {{
      put(TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal(), Marine.class);
    }});
    put(RunningMarine.GUI_NAME, new HashMap() {{
      put(RunningMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal(), Marine.class);
    }});
    put(Medik.GUI_NAME, new HashMap() {{
      put(Medik.UNIT_TYPES._BACK.ordinal(), Unit.class);
      put(Medik.UNIT_TYPES.JUMPING.ordinal(), JumpingMedik.class);
      put(Medik.UNIT_TYPES.RUNNING.ordinal(), RunningMedik.class);
      put(Medik.UNIT_TYPES.TRENCH.ordinal(), TrenchMedik.class);
    }});
    put(RunningMedik.GUI_NAME, new HashMap() {{
      put(RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal(), Medik.class);
    }});
    put(JumpingMedik.GUI_NAME, new HashMap() {{
      put(JumpingMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal(), Medik.class);
    }});
    put(TrenchMedik.GUI_NAME, new HashMap() {{
      put(TrenchMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal(), Medik.class);
    }});
    put(Tank.GUI_NAME, new HashMap() {{
      put(Tank.UNIT_TYPES._BACK.ordinal(), Unit.class);
      put(Tank.UNIT_TYPES.TURELL.ordinal(), TurellTank.class);
    }});
    put(TurellTank.GUI_NAME, new HashMap() {{
      put(TurellTank.UNIT_TYPES._BACK_TO_TANK.ordinal(), Tank.class);
    }});
  }};

  public InheritanceGUIController(IUnitProcessor unitProcessor) {
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
        _unitProcessor.replaceSelectedUnitWithNew(menuFunction.get(selectedMenu));
      }
    }
    _lastEventHash = evt.hashCode();
  }

  private String getUnitMenuNameFromSelected(String selectedMenuName) {
    return selectedMenuName.substring(1);
  }
}
