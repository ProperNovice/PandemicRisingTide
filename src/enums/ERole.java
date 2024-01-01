package enums;

public enum ERole {

	PUMP_OPERATOR("blue"), HYDRAULIC_ENGINEER("brown"), CARPENTER("orange"), DIRECTOR("green"),
	WEREHOUSE_MANAGER("pink"), SANITATION_ENGINEER("white"), PORT_MASTER("black");

	private String pawnFileName = null;

	private ERole(String pawnFileName) {
		this.pawnFileName = pawnFileName;
	}

	public String getPawnFileName() {
		return this.pawnFileName;
	}

}
