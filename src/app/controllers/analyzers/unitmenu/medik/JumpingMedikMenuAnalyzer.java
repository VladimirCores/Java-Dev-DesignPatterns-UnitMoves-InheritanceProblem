package app.controllers.analyzers.unitmenu.medik;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.terran.Medik;
import app.entities.terran.medik.JumpingMedik;

public final class JumpingMedikMenuAnalyzer extends EntityMenuAnalyzer
{
	public JumpingMedikMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, JumpingMedik.GUI_NAME)) 
		{
			if (menuIndex == JumpingMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
				System.out.println("> DEGRADE JUMPING MEDIK -> MEDIK");
				return Medik.class;
			}
		}
		return null;
	}
}
