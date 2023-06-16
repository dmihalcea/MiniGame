import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PlayerStatus player1 = new PlayerStatus();
		PlayerStatus player2 = new PlayerStatus();
		
		PlayerStatus.setGameName("Tom & Jerry");
		
		player1.initPlayer("Tom", 9, 35000);
		player2.initPlayer("Jerry", 1, 17050);
		
		player1.setHealth(100);
		player2.setHealth(200);
		player1.setWeaponInHand("knife");
		player2.setWeaponInHand("knife");
		player1.setPositionX(1);
		player1.setPositionY(1);
		player2.setPositionX(2);
		player2.setPositionY(5);
//		player1.movePlayerTo(1, 1);
//		player2.movePlayerTo(2, 5);
		
		System.out.println("Apasa ENTER pentru a incepe jocul!");
		String start = sc.nextLine();
		if (start.equals(" ")) {
			System.out.println("\t\tBine ati venit la jocul " + "\"" + PlayerStatus.getGameName() + "\"");
			System.out.println("\nLupta va incepe in curand!");
			System.out.println("Cine vreti sa fie jucatorii?");
			String bababa=sc.nextLine();
			System.out.println("siii?");
			String bababa1=sc.nextLine();
			System.out.println("\nLuptatorii nostri sunt, cum va asteptati: " + bababa
								+ " si " + bababa1);
			System.out.println(player1.getNickName() + " incepe lupta astfel: ");
			player1.afisare();
			System.out.println(player2.getNickName() + " incepe lupta astfel: ");
			player2.afisare();
			System.out.println("\n\t\t3......2......1......START!");
			System.out.println("");
			
			player2.movePlayerTo(6, 102);
			System.out.print(player2.getNickName() + " incepe lupta fugind in pozitia ");
			player2.afisareCoordonate();
			player2.findArtifact(6);
			player2.setWeaponInHand("kalashnikov");
			System.out.println("Acolo gaseste un artefact care ii aduce puncte in plus cu "
								+ "ajutorul carora isi cumpara un " + player2.getWeaponInHand());
			player1.movePlayerTo(1000, 500);
			player1.findArtifact(18);
			System.out.print(player1.getNickName() + " fuge speriat si ajunte in pozitia ");
			player1.afisareCoordonate();
			System.out.println("Ajuns acolo, cade in capcana si pierde puncte si viata");
			player1.setWeaponInHand("sniper");
			System.out.println("Cu toate acestea, el are destule puncte pentru a cumpara un " + player1.getWeaponInHand());
			System.out.println(player1.getNickName() + " are acum: ");
			player1.afisare();
			System.out.println(player2.getNickName() + " are acum: ");
			player2.afisare();
			System.out.println("Acum distanta dintre cei doi este " + player1.distanceBetweenPlayers(player2));
			player2.duel(player1);
			System.out.println(player1.getNickName() + " trage si il nimereste pe " + player2.getNickName());
			player2.movePlayerTo(98, 85);
			System.out.print("Desi este grav ranit, " + player2.getNickName() + " reuseste sa fuga si ajunge in pozitia ");
			player2.afisareCoordonate();
			System.out.println("Datorita distantei mici, " + player2.getNickName() 
								+ " reuseste sa il nimereasca pe " + player1.getNickName());
			player2.duel(player1);
			System.out.println(player1.getNickName() + " are acum: ");
			player1.afisare();
			System.out.println(player2.getNickName() + " are acum: ");
			player2.afisare();
			System.out.println("Printr-o metoda banala de distragere a atentiei, " 
								+ player1.getNickName() + " ii fura arma lui " + player2.getNickName());
			player1.setWeaponInHand("kalashnikov");
			
			player2.setWeaponInHand("knife");
			
			System.out.println("Acum " + player1.getNickName() + " are " + player1.getWeaponInHand() 
								+ ", iar " + player2.getNickName() + " a ramas cu " + player2.getWeaponInHand());
			player1.duel(player2);
			player2.movePlayerTo(99.5, 88.5);
			System.out.println("Dupa un glont bine plasat, " + player1.getNickName() 
								+ " il omoara pe " + player2.getNickName());
			System.out.println(player2.getNickName() + " are acum: ");
			player2.afisare();
			
			System.out.println("Dupa un respawn nefericit in apropierea oponentului, " + player2.getNickName()	
								+ " mai primeste doua gloante din partea lui " + player1.getNickName() 
								+ " si este infrant");
			player1.duel(player2);
			System.out.println("\n\t" + player1.getNickName() + " castiga lupta!");
			player1.duel(player2);			
		} 
		
	
			sc.close();
	}

}
