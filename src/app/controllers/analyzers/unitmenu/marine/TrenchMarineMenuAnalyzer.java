package app.controllers.analyzers.unitmenu.marine;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.terran.Marine;
import app.entities.terran.marine.TrenchMarine;

public final class TrenchMarineMenuAnalyzer extends EntityMenuAnalyzer
{
	public TrenchMarineMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, TrenchMarine.GUI_NAME)) 
		{
			if (menuIndex == TrenchMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
				System.out.println("> DEGRADE TRENCH MARINE -> MARINE");
				return Marine.class;
			}
		}
		return null;
	}
}
