package app.controllers.analyzers.unitmenu;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.Unit;
import app.entities.terran.Marine;
import app.entities.terran.Medik;
import app.entities.terran.Tank;

public final class UnitMenuAnalyzer extends EntityMenuAnalyzer
{
	public UnitMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, Unit.GUI_NAME)) 
		{
			if (menuIndex == Unit.UNIT_TYPE.MARINE.ordinal()){
				System.out.println("> UPGRADE UNIT -> MARINE");
				return Marine.class;
			}
			else if(menuIndex == Unit.UNIT_TYPE.MEDIK.ordinal()) {
				System.out.println("> UPGRADE UNIT -> MEDIK");
				return Medik.class;
			}
			else if(menuIndex == Unit.UNIT_TYPE.TANK.ordinal()) {
				System.out.println("> UPGRADE UNIT -> TANK");
				return Tank.class;
			}
		} 
		return null;
	}
}
