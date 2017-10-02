package app.controllers.analyzers.unitmenu.marine;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.terran.Marine;
import app.entities.terran.marine.RunningMarine;

public final class RunningMarineMenuAnalyzer extends EntityMenuAnalyzer
{
	public RunningMarineMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, RunningMarine.GUI_NAME)) 
		{
			if (menuIndex == RunningMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
				System.out.println("> DEGRADE JUMPING MARINE -> MARINE");
				return Marine.class;
			}
		}
		return null;
	}
}
