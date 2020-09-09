package tn.pfe.entity;

public class StageParCategory {

	private int nbstage;
	private String category;
	
	public StageParCategory(int nbstage, String category) {
		this.nbstage = nbstage;
		this.category = category;
	}

	public int getNbstage() {
		return nbstage;
	}

	public void setNbstage(int nbstage) {
		this.nbstage = nbstage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
