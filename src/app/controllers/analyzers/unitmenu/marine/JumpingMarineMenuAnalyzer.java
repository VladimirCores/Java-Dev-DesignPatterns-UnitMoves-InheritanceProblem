package app.controllers.analyzers.unitmenu.marine;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.terran.Marine;
import app.entities.terran.marine.JumpingMarine;

public final class JumpingMarineMenuAnalyzer extends EntityMenuAnalyzer
{
	public JumpingMarineMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, JumpingMarine.GUI_NAME)) 
		{
			if (menuIndex == JumpingMarine.UNIT_TYPES._BACK_TO_MARINE.ordinal()) {
				System.out.println("> DEGRADE JUMPING MARINE -> MARINE");
				return Marine.class;
			}
		}
		return null;
	}
}
