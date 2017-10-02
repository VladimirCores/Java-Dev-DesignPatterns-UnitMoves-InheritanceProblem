package app.controllers.analyzers.unitmenu.medik;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.terran.Medik;
import app.entities.terran.medik.TrenchMedik;

public final class TrenchMedikMenuAnalyzer extends EntityMenuAnalyzer
{
	public TrenchMedikMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, TrenchMedik.GUI_NAME)) 
		{
			if (menuIndex == TrenchMedik.UNIT_TYPES._BACK_TO_MEDIK.ordinal()) {
				System.out.println("> DEGRADE TRENCH MEDIK -> MEDIK");
				return Medik.class;
			}
		}
		return null;
	}
}
