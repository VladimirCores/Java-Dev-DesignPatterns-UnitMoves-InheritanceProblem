package app.controllers.analyzers;

public abstract class EntityMenuAnalyzer 
{
	public Class<?> check(String menuName, int menuIndex) {
		return null;
	}
	
	protected boolean isSelectedMenuUnitType(String selectedName, String unitMenuName){
		int guiNameLength = selectedName.length() - 1;
		return guiNameLength == unitMenuName.length() && selectedName.indexOf(unitMenuName) > 0;
	}
}
