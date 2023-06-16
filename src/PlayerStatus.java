
public class PlayerStatus {

	private String nickname;
	private int score;
	private int lives;
	private int health;
	private String weaponInHand;
	private double positionX;
	private double positionY;
	private static String gameName;
	
	// 1.3 metode de initializare, cu diverse seturi de parametri:
	public void initPlayer (String nickname) {
		this.nickname = nickname;
	}
	
	public void initPlayer (String nickname, int lives) {
		this.nickname = nickname;
		this.lives = lives;
	}
	
	public void initPlayer(String nickname, int lives, int score) {
		this.nickname = nickname;
		this.lives = lives;
		this.score = score;
	}
	
	// Afisare:
	public void afisare() {
		System.out.println("\tScor: " + this.score);
		System.out.println("\tProcent Viata: " + this.health + "%");
		System.out.println("\tVieti: " + this.lives);
		System.out.println("\tArma: " + this.weaponInHand);
		System.out.println("\tPozitie: x:" + this.positionX + ", y:" + this.positionY);
	}
	
	public void afisareCoordonate() {
		System.out.println("x:" + this.positionX + ", y:" + this.positionY);
	}
	
	// Health:
	public void setHealth (int health) {
		this.health = health;
		if (health > 100) {
			this.health = 100;
		}
	}
		
	public void verifyHealth() {
		if (this.health > 100) {
			this.health = 100;
		}
		if (this.health <= 0) {
			this.lives -= 1;
			this.health = 100;
		}
		if (this.lives < 1) {
			System.out.println("\n\t\t\tGAME OVER");
		}
	}
	
	
	//Reguli artefact:
	public boolean isPerfect(int n) {
		int s = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				s += i;
			}
		}
		if (s == n) {
			return true;
		} 
		return false;
	}
	
	public boolean isPrime(int n) {
	    if (n < 2) {
	      return false;
	    }
	 
	    for (int i = 2; i <= n / 2; i++) {
	      if (n % i == 0) {
	        return false;
	      }
	    }
	    return true;
	}
	
	public boolean isEven (int n) {
		if (n % 2 != 0) {
			return false;
		}
		int sum = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			sum += lastDigit;
			n /= 10;
		}
		if (sum % 3 != 0) {
			return false;
		}
		return true;
	}
	
	public void findArtifact(int artifactCode) {
		if (isPerfect(artifactCode)) {
			this.score += 5000;
			this.lives += 1;
			this.health = 100;
		} else if (isPrime(artifactCode)) {
			this.score += 1000;
			this.lives +=2;
			this.health += 25;
		} else if (isEven(artifactCode)) {
			this.score -= 3000;
			this.health -= 25;
		} else {
			this.score += artifactCode;
		}
		this.verifyHealth();
	}
	
	// Schimbarea armei:
	
	public boolean setWeaponInHand(String weapon) {
 		int knifeCost = 1000;
 		int sniperCost = 10_000;
 		int kalashnikovCost = 20_000;
 		boolean succes = false;
		
		if (weapon.equals("sniper") && sniperCost <= this.score) {
			this.score -= sniperCost;
			this.weaponInHand = weapon;
			succes = true;
		} else if (weapon.equals("knife") && knifeCost <= this.score) {
			this.score -= knifeCost;
			this.weaponInHand = weapon;
			succes = true;
		} else if (weapon.equals("kalashnikov") && kalashnikovCost <= this.score) {
			this.score -= kalashnikovCost;
			this.weaponInHand = weapon;	
			succes = true;
		}
		return succes;
	}
	
	public String getWeaponInHand () {
		return this.weaponInHand;
	}
	
	//5.transforma campurile positionX si positionY in proprietati ale obiectelor clasei PlayerStatus
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
	public double getPositionX() {
		return this.positionX;
	}
	
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	
	public double getPositionY() {
		return this.positionY;
	}
		
	//6. implementeaza metodele necesare pentru ca atributul gameName sa devina o proprietate
	public static String getGameName() {
		return gameName;
	}
	protected static void setGameName (String name) {
		gameName = name;
	}
	
	//7.Metoda de mutare jucator:
	public void movePlayerTo(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	//8.transforma campul nickname intr-o proprietate read-only
	public String getNickName() {
		return this.nickname;
	}
	
	//Duelul:
	public double distanceBetweenPlayers(PlayerStatus opponent) {
		double distance = Math.sqrt(Math.pow(this.positionX - opponent.positionX, 2) 
									+ Math.pow(this.positionY - opponent.positionY, 2));
		return distance;
	}
	
	public boolean shouldAttackOpponent (PlayerStatus opponent) {
		boolean answer = false;
		double probabilityP1 = 0;
		double probabilityP2 = 0;
		
		if (this.weaponInHand.equals(opponent.weaponInHand)) {
			probabilityP1 = (3 * this.health + this.score / 1000) / 4;
			probabilityP2 = (3* opponent.health + opponent.score / 1000) / 4;
			if (probabilityP1 > probabilityP2) {
				answer = true;
			}
		} else {
			if (this.distanceBetweenPlayers(opponent) > 1000) {
				if (this.weaponInHand.equals("sniper") && (opponent.weaponInHand.equals("kalashnikov") || opponent.weaponInHand.equals("knife"))) {
					answer = true;
				} else if (this.weaponInHand.equals("kalashnikov") && opponent.weaponInHand.equals("knife")) {
					answer = true;
				}
			} else {
				if (this.weaponInHand.equals("kalashnikov") && (opponent.weaponInHand.equals("sniper") || opponent.weaponInHand.equals("knife"))) {
					answer = true;
				} else if (this.weaponInHand.equals("sniper") && opponent.weaponInHand.equals("knife")) {
					answer = true;
				}
			}
		}
		return answer;
	}
	
	public void duel (PlayerStatus opponent) {
		if (this.shouldAttackOpponent(opponent)) {
			if (this.weaponInHand.equals("knife")) {
				opponent.health -= 45;
			}else if (this.weaponInHand.equals("sniper")) {
				opponent.health -= 90;
			}else if (this.weaponInHand.equals("kalashnikov")) {
				opponent.health -= 65;
			}
			opponent.verifyHealth();
		} else {
			if (opponent.weaponInHand.equals("knife")) {
				this.health -= 45;
			} else if (opponent.weaponInHand.equals("sniper")) {
				this.health -= 90;
			} else if (opponent.weaponInHand.equals("kalashnikov")) {
				this.health -= 65;
			}
			this.verifyHealth();
		}
	}
}
