package app.controllers.analyzers.unitmenu;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.Unit;
import app.entities.terran.Medik;
import app.entities.terran.medik.JumpingMedik;
import app.entities.terran.medik.RunningMedik;
import app.entities.terran.medik.TrenchMedik;

public final class MedikMenuAnalyzer extends EntityMenuAnalyzer
{
	public MedikMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, Medik.GUI_NAME)) 
		{
			if (menuIndex == Medik.UNIT_TYPES._BACK.ordinal()) {
				System.out.println("> DEGRADE MEDIK -> UNIT");
				return Unit.class;
			}
			else if (menuIndex == Medik.UNIT_TYPES.JUMPING.ordinal()) {
				System.out.println("> UPGRADE MEDIK -> JUMPING MEDIK");
				return JumpingMedik.class;
			}
			else if (menuIndex == Medik.UNIT_TYPES.RUNNING.ordinal()) {
				System.out.println("> UPGRADE MEDIK -> RUNNING MEDIK");
				return RunningMedik.class;
			}
			else if (menuIndex == Medik.UNIT_TYPES.TRENCH.ordinal()) {
				System.out.println("> UPGRADE MEDIK -> JUMPING MEDIK");
				return TrenchMedik.class;
			}
		} 
		return null;
	}
}
