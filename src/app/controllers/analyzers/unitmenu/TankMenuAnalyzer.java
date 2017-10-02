package app.controllers.analyzers.unitmenu;

import app.controllers.analyzers.EntityMenuAnalyzer;
import app.entities.Unit;
import app.entities.terran.Tank;
import app.entities.terran.tank.TurellTank;

public final class TankMenuAnalyzer extends EntityMenuAnalyzer
{
	public TankMenuAnalyzer() { }

	@Override
	public Class<?> check(String menuName, int menuIndex) 
	{
		if(isSelectedMenuUnitType(menuName, Tank.GUI_NAME)) 
		{
			if (menuIndex == Tank.UNIT_TYPES._BACK.ordinal()) {
				System.out.println("> DEGRADE TANK -> UNIT");
				return Unit.class;
			}
			else if (menuIndex == Tank.UNIT_TYPES.TURELL.ordinal()) {
				System.out.println("> UPGRADE TANK -> TURELL TANK");
				return TurellTank.class;
			}
		} 
		return null;
	}
}
