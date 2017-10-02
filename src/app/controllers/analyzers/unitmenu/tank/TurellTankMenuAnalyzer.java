package app.controllers.analyzers.unitmenu.tank;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.terran.Tank;
import app.entities.terran.tank.TurellTank;

public final class TurellTankMenuAnalyzer extends EntityMenuAnalyzer
{
	public TurellTankMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, TurellTank.GUI_NAME)) 
		{	
			if (menuIndex == TurellTank.UNIT_TYPES._BACK_TO_TANK.ordinal()) {
				System.out.println("> DEGRADE TURELL TANK -> TANK");
				return Tank.class;
			}
		}
		return null;
	}
}
