package app.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.controllers.analyzers.unitmenu.MarineMenuAnalyzer;
import app.controllers.analyzers.unitmenu.MedikMenuAnalyzer;
import app.controllers.analyzers.unitmenu.TankMenuAnalyzer;
import app.controllers.analyzers.unitmenu.UnitMenuAnalyzer;
import app.controllers.analyzers.unitmenu.marine.JumpingMarineMenuAnalyzer;
import app.controllers.analyzers.unitmenu.marine.RunningMarineMenuAnalyzer;
import app.controllers.analyzers.unitmenu.marine.TrenchMarineMenuAnalyzer;
import app.controllers.analyzers.unitmenu.medik.JumpingMedikMenuAnalyzer;
import app.controllers.analyzers.unitmenu.medik.RunningMedikMenuAnalyzer;
import app.controllers.analyzers.unitmenu.medik.TrenchMedikMenuAnalyzer;
import app.controllers.analyzers.unitmenu.tank.TurellTankMenuAnalyzer;
import app.entities.Unit;
import app.entities.terran.Marine;
import app.entities.terran.Medik;
import app.entities.terran.Tank;
import app.entities.terran.marine.JumpingMarine;
import app.entities.terran.marine.RunningMarine;
import app.entities.terran.marine.TrenchMarine;
import app.entities.terran.medik.JumpingMedik;
import app.entities.terran.medik.RunningMedik;
import app.entities.terran.medik.TrenchMedik;
import app.entities.terran.tank.TurellTank;
import app.interfaces.unit.IUnitProcessor;
import controlP5.CallbackEvent;
import controlP5.CallbackListener;
import controlP5.Controller;

public class UnitsController implements CallbackListener {

	private int _lastEventHash = 0;
	private IUnitProcessor _unitProcessor;
	
	public UnitsController(IUnitProcessor unitProcessor) {
		_unitProcessor = unitProcessor;
	}
/**/
	@Override
	public void controlEvent(CallbackEvent evt) 
	{
		if(_lastEventHash == evt.hashCode()) return;
		
		if(evt.getAction() == 100)
		{
			Controller<?> guiController = evt.getController();
			String guiName = evt.getController().getAddress();
			int selectedMenu = (int)guiController.getValue();
			
			
			System.out.println("> GUI SELECTED: " + guiName + " | " + selectedMenu);
			
			if(isSelectedMenuUnitType(guiName, Unit.GUI_NAME)) 
			{
				if (selectedMenu == Unit.UNIT_TYPE.MARINE.ordinal()){
					System.out.println("> UPGRADE UNIT -> MARINE");
					_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				}
				else if(selectedMenu == Unit.UNIT_TYPE.MEDIK.ordinal()) {
					System.out.println("> UPGRADE UNIT -> MEDIK");
					_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				}
				else if(selectedMenu == Unit.UNIT_TYPE.TANK.ordinal()) {
					System.out.println("> UPGRADE UNIT -> TANK");
					_unitProcessor.replaceSelectedUnitWithNew(Tank.class);
				}
			} 
			else if(isSelectedMenuUnitType(guiName, Marine.GUI_NAME)) 
			{
				if (selectedMenu == Marine.UNIT_TYPES._BACK.ordinal()) {
					System.out.println("> DEGRADE MARINE -> UNIT");
					_unitProcessor.replaceSelectedUnitWithNew(Unit.class);
				}
				else if (selectedMenu == Marine.UNIT_TYPES.JUMPING.ordinal()) {
					System.out.println("> UPGRADE MARINE -> JUMPING");
					_unitProcessor.replaceSelectedUnitWithNew(JumpingMarine.class);
				}
				else if (selectedMenu == Marine.UNIT_TYPES.RUNNING.ordinal()) {
					System.out.println("> UPGRADE MARINE -> RUNNING");
					_unitProcessor.replaceSelectedUnitWithNew(RunningMarine.class);
				}
				else if (selectedMenu == Marine.UNIT_TYPES.TRENCH.ordinal()) {
					System.out.println("> UPGRADE MARINE -> TRENCH");
					_unitProcessor.replaceSelectedUnitWithNew(TrenchMarine.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, JumpingMarine.GUI_NAME)) 
			{
				if (selectedMenu == JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
					System.out.println("> DEGRADE JUMPING MARINE -> MARINE");
					_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, TrenchMarine.GUI_NAME)) 
			{
				if (selectedMenu == TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
					System.out.println("> DEGRADE RUNNING MARINE -> MARINE");
					_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, RunningMarine.GUI_NAME)) 
			{
				if (selectedMenu == RunningMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
					System.out.println("> DEGRADE RUNNING MARINE -> MARINE");
					_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, Medik.GUI_NAME)) 
			{
				if (selectedMenu == Medik.UNIT_TYPES._BACK.ordinal()) {
					System.out.println("> DEGRADE MEDIK -> UNIT");
					_unitProcessor.replaceSelectedUnitWithNew(Unit.class);
				}
				else if (selectedMenu == Medik.UNIT_TYPES.JUMPING.ordinal()) {
					System.out.println("> UPGRADE MEDIK -> JUMPING MEDIK");
					_unitProcessor.replaceSelectedUnitWithNew(JumpingMedik.class);
				}
				else if (selectedMenu == Medik.UNIT_TYPES.RUNNING.ordinal()) {
					System.out.println("> UPGRADE MEDIK -> RUNNING MEDIK");
					_unitProcessor.replaceSelectedUnitWithNew(RunningMedik.class);
				}
				else if (selectedMenu == Medik.UNIT_TYPES.TRENCH.ordinal()) {
					System.out.println("> UPGRADE MEDIK -> TRENCH MEDIK");
					_unitProcessor.replaceSelectedUnitWithNew(TrenchMedik.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, JumpingMedik.GUI_NAME)) 
			{
				if (selectedMenu == JumpingMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
					System.out.println("> DEGRADE JUMPING MEDIK -> MEDIK");
					_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, TrenchMedik.GUI_NAME)) 
			{
				if (selectedMenu == TrenchMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
					System.out.println("> DEGRADE RUNNING MDEIK -> MEDIK");
					_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, RunningMedik.GUI_NAME)) 
			{
				if (selectedMenu == RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
					System.out.println("> DEGRADE RUNNING MEDIK -> MEDIK");
					_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, Tank.GUI_NAME)) 
			{
				if (selectedMenu == Tank.UNIT_TYPES._BACK.ordinal()) {
					System.out.println("> DEGRADE TANK -> UNIT");
					_unitProcessor.replaceSelectedUnitWithNew(Unit.class);
				}
				else if (selectedMenu == Tank.UNIT_TYPES.TURELL.ordinal()) {
					System.out.println("> UPGRADE TANK -> TURELL TANK");
					_unitProcessor.replaceSelectedUnitWithNew(TurellTank.class);
				}
			}
			else if(isSelectedMenuUnitType(guiName, TurellTank.GUI_NAME)) 
			{	
				if (selectedMenu == TurellTank.UNIT_TYPES._BACK_TO_TANK.ordinal()) {
					System.out.println("> DEGRADE TURELL TANK -> TANK");
					_unitProcessor.replaceSelectedUnitWithNew(Tank.class);
				}
			}
		}
		_lastEventHash = evt.hashCode();
	}
/**/
/*
	@Override
	public void controlEvent(CallbackEvent evt) 
	{
		if(_lastEventHash  == evt.hashCode()) return;
		_lastEventHash = evt.hashCode();
		
		if(evt.getAction() == 100)
		{
			Controller<?> guiController = evt.getController();
			String guiName = evt.getController().getAddress();
			int selectedMenu = (int)guiController.getValue();
			
			System.out.println("> GUI SELECTED: " + guiName + " | " + selectedMenu);
			
			if(isUnitMenu(guiName, selectedMenu)) return; 
				if(isMarineMenu(guiName, selectedMenu)) return;
					if(isJumpingMarineMenu(guiName, selectedMenu)) return; 
					if(isRunningMarineMenu(guiName, selectedMenu)) return; 
					if(isTrenchMarineMenu(guiName, selectedMenu)) return; 
				if(isMedikMenu(guiName, selectedMenu)) return;
					if(isJumpingMedikMenu(guiName, selectedMenu)) return; 
					if(isRunningMedikMenu(guiName, selectedMenu)) return; 
					if(isTrenchMedikMenu(guiName, selectedMenu)) return; 
				if(isTankMenu(guiName, selectedMenu)) return; 
						
			else if(isSelectedMenuUnitType(guiName, TurellTank.GUI_NAME)) 
			{	
				if (selectedMenu == TurellTank.UNIT_TYPES._BACK_TO_TANK.ordinal()) {
					System.out.println("> DEGRADE TURELL TANK -> TANK");
					_unitProcessor.replaceSelectedUnitWithNew(Tank.class);
				}
			}
		}
	}
*/	
	private boolean isUnitMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, Unit.GUI_NAME)) 
		{
			if (menuIndex == Unit.UNIT_TYPE.MARINE.ordinal()){
				System.out.println("> UPGRADE UNIT -> MARINE");
				_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				result = true;
			}
			else if(menuIndex == Unit.UNIT_TYPE.TANK.ordinal()) {
				System.out.println("> UPGRADE UNIT -> TANK");
				_unitProcessor.replaceSelectedUnitWithNew(Tank.class);
				result = true;
			}
			else if(menuIndex == Unit.UNIT_TYPE.MEDIK.ordinal()) {
				System.out.println("> UPGRADE UNIT -> MEDIK");
				_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				result = true;
			}
		} 
		return result;
	}
	
	private boolean isMarineMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, Marine.GUI_NAME)) 
		{
			if (menuIndex == Marine.UNIT_TYPES._BACK.ordinal()) {
				System.out.println("> DEGRADE MARINE -> UNIT");
				_unitProcessor.replaceSelectedUnitWithNew(Unit.class);
				result = true;
			}
			else if (menuIndex == Marine.UNIT_TYPES.JUMPING.ordinal()) {
				System.out.println("> UPGRADE MARINE -> JUMPING");
				_unitProcessor.replaceSelectedUnitWithNew(JumpingMarine.class);
				result = true;
			}
			else if (menuIndex == Marine.UNIT_TYPES.RUNNING.ordinal()) {
				System.out.println("> UPGRADE MARINE -> RUNNING");
				_unitProcessor.replaceSelectedUnitWithNew(RunningMarine.class);
				result = true;
			}
			else if (menuIndex == Marine.UNIT_TYPES.TRENCH.ordinal()) {
				System.out.println("> UPGRADE MARINE -> JUMPING");
				_unitProcessor.replaceSelectedUnitWithNew(TrenchMarine.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isTrenchMarineMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, TrenchMarine.GUI_NAME)) 
		{
			if (menuIndex == TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
				System.out.println("> DEGRADE TRENCH MARINE -> MARINE");
				_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isJumpingMarineMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, JumpingMarine.GUI_NAME)) 
		{
			if (menuIndex == JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
				System.out.println("> DEGRADE JUMPING MARINE -> MARINE");
				_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isRunningMarineMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, RunningMarine.GUI_NAME)) 
		{
			if (menuIndex == RunningMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
				System.out.println("> DEGRADE RUNNING MARINE -> MARINE");
				_unitProcessor.replaceSelectedUnitWithNew(Marine.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isMedikMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, Medik.GUI_NAME)) 
		{
			if (menuIndex == Medik.UNIT_TYPES._BACK.ordinal()) {
				System.out.println("> DEGRADE MEDIK -> UNIT");
				_unitProcessor.replaceSelectedUnitWithNew(Unit.class);
				result = true;
			}
			else if (menuIndex == Medik.UNIT_TYPES.JUMPING.ordinal()) {
				System.out.println("> UPGRADE MEDIK -> JUMPING MEDIK");
				_unitProcessor.replaceSelectedUnitWithNew(JumpingMedik.class);
				result = true;
			}
			else if (menuIndex == Medik.UNIT_TYPES.RUNNING.ordinal()) {
				System.out.println("> UPGRADE MEDIK -> RUNNING MEDIK");
				_unitProcessor.replaceSelectedUnitWithNew(RunningMedik.class);
				result = true;
			}
			else if (menuIndex == Medik.UNIT_TYPES.TRENCH.ordinal()) {
				System.out.println("> UPGRADE MEDIK -> TRENCH MEDIK");
				_unitProcessor.replaceSelectedUnitWithNew(TrenchMedik.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isTrenchMedikMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, TrenchMedik.GUI_NAME)) 
		{
			if (menuIndex == TrenchMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
				System.out.println("> DEGRADE TRENCH MEDIK -> MEDIK");
				_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isJumpingMedikMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, JumpingMedik.GUI_NAME)) 
		{
			if (menuIndex == JumpingMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
				System.out.println("> DEGRADE JUMPING MEDIK -> MEDIK");
				_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isRunningMedikMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, RunningMedik.GUI_NAME)) 
		{
			if (menuIndex == RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
				System.out.println("> DEGRADE RUNNING MDEIK -> MEDIK");
				_unitProcessor.replaceSelectedUnitWithNew(Medik.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isTankMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, Tank.GUI_NAME)) 
		{
			if (menuIndex == Tank.UNIT_TYPES._BACK.ordinal()) {
				System.out.println("> DEGRADE TANK -> UNIT");
				_unitProcessor.replaceSelectedUnitWithNew(Unit.class);
				result = true;
			}
			else if (menuIndex == Tank.UNIT_TYPES.TURELL.ordinal()) {
				System.out.println("> UPGRADE TANK -> TURELL TANK");
				_unitProcessor.replaceSelectedUnitWithNew(TurellTank.class);
				result = true;
			}
		}
		return result;
	}
	
	private boolean isTurellTankMenu(String menuName, int menuIndex) 
	{
		boolean result = false;
		if(isSelectedMenuUnitType(menuName, TurellTank.GUI_NAME)) 
		{	
			if (menuIndex == TurellTank.UNIT_TYPES._BACK_TO_TANK.ordinal()) {
				System.out.println("> DEGRADE TURELL TANK -> TANK");
				_unitProcessor.replaceSelectedUnitWithNew(Tank.class);
				result = true;
			}
		}
		return result;
	}
	
//	@Override
//	public void controlEvent(CallbackEvent evt) 
//	{
//		if(_lastEventHash  == evt.hashCode()) return;
//		_lastEventHash = evt.hashCode();
//		
//		if(evt.getAction() == 100)
//		{
//			Controller<?> guiController = evt.getController();
//			String guiName = evt.getController().getAddress();
//			int selectedMenu = (int)guiController.getValue();
//			
//			System.out.println("> GUI SELECTED: " + guiName + " | " + selectedMenu);
//			
//			ArrayList<EntityMenuAnalyzer> analyzers = new ArrayList<EntityMenuAnalyzer>(Arrays.asList(
//				new UnitMenuAnalyzer(), 
//					new MarineMenuAnalyzer(), 
//						new JumpingMarineMenuAnalyzer(),
//						new TrenchMarineMenuAnalyzer(),
//						new RunningMarineMenuAnalyzer(),
//					new MedikMenuAnalyzer(), 
//						new JumpingMedikMenuAnalyzer(),
//						new TrenchMedikMenuAnalyzer(),
//						new RunningMedikMenuAnalyzer(),
//					new TankMenuAnalyzer(), 
//						new TurellTankMenuAnalyzer()
//			));
//			
//			for(EntityMenuAnalyzer e : analyzers) {
//				Class<?> unitToReplace = e.check(guiName, selectedMenu);
//				if(unitToReplace != null) {
//					_unitProcessor.replaceSelectedUnitWithNew(unitToReplace);
//					break;
//				}
//			}
//		}
//	}
	
	private boolean isSelectedMenuUnitType(String selectedName, String unitMenuName){
		int guiNameLength = selectedName.length() - 1;
		return guiNameLength == unitMenuName.length() && selectedName.indexOf(unitMenuName) > 0;
	}
}
