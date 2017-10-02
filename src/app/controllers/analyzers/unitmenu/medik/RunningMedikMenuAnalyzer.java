package app.controllers.analyzers.unitmenu.medik;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.terran.Medik;
import app.entities.terran.medik.RunningMedik;

public final class RunningMedikMenuAnalyzer extends EntityMenuAnalyzer
{
	public RunningMedikMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, RunningMedik.GUI_NAME)) 
		{
			if (menuIndex == RunningMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
				System.out.println("> DEGRADE JUMPING MEDIK -> MEDIK");
				return Medik.class;
			}
		}
		return null;
	}
}
