public class Team {

	private String teamName; // Name of the team
	private int wins; // Wins the team has
	private int losses; // Losses the team has
	private float offensiveRating; // The team's offensive rating
	private float defensiveRating; // The team's defensive rating
	private float strength; // The team's calculated strength

	public Team(String name, int wins, int losses, float offensiveRating, float defensiveRating, float strength) {
		this.teamName = name;
		this.wins = wins;
		this.losses = losses;
		this.offensiveRating = offensiveRating;
		this.defensiveRating = defensiveRating;
		this.strength = strength;
	}
	
	public String getName() {
		return teamName;
	}
	
	public void setName(String name) {
		this.teamName = name;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public float getOffensiveRating() {
		return offensiveRating;
	}
	
	public void setOffensiveRating(float offRate) {
		this.offensiveRating = offRate;
	}
	
	public float getDefensiveRating() {
		return defensiveRating;
	}
	
	public void setDefensiveRating(float defRate) {
		this.defensiveRating = defRate;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (obj.getClass() == this.getClass()) {
			Team other = (Team) obj;
			if (other.getName().equals(this.teamName)) {
				return true;
			}
		}
		return false;
	}
	
}