package app.controllers.analyzers.unitmenu;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.Unit;
import app.entities.terran.Marine;
import app.entities.terran.marine.JumpingMarine;
import app.entities.terran.marine.RunningMarine;
import app.entities.terran.marine.TrenchMarine;

public final class MarineMenuAnalyzer extends EntityMenuAnalyzer
{
	public MarineMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, Marine.GUI_NAME)) 
		{
			if (menuIndex == Marine.UNIT_TYPES._BACK.ordinal()) {
				System.out.println("> DEGRADE MARINE -> UNIT");
				return Unit.class;
			}
			else if (menuIndex == Marine.UNIT_TYPES.JUMPING.ordinal()) {
				System.out.println("> UPGRADE MARINE -> JUMPING MARINE");
				return JumpingMarine.class;
			}
			else if (menuIndex == Marine.UNIT_TYPES.RUNNING.ordinal()) {
				System.out.println("> UPGRADE MARINE -> RUNNING MARINE");
				return RunningMarine.class;
			}
			else if (menuIndex == Marine.UNIT_TYPES.TRENCH.ordinal()) {
				System.out.println("> UPGRADE MARINE -> JUMPING MARINE");
				return TrenchMarine.class;
			}
		} 
		return null;
	}
}
