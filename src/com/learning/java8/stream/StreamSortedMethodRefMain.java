package com.learning.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamSortedMethodRefMain {

	public static void main(String[] args) {
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player("Martial", "Manchester Utd", "Striker"));
		playerList.add(new Player("Aubameyang", "Arsenal", "Winger"));
		playerList.add(new Player("Lacazette", "Arsenal", "Striker"));
		playerList.add(new Player("Cavani", "Manchester Utd", "Striker"));

		// Filter striker only
		playerList.stream().filter(FilterManager::isStriker).forEach(p -> System.out.println("Name=" + p.getName()));
		System.out.println();

		// Sort by player name
		playerList.stream().sorted(Comparator.comparing(Player::getName))
				.forEach(p -> System.out.println("Name=" + p.getName()));
		System.out.println();

		// Sort by position then by player name
		playerList.stream().sorted(Comparator.comparing(Player::getClub).thenComparing(Player::getName))
				.forEach(p -> System.out.println("Name=" + p.getName()));
		System.out.println();

		/**
		 * Result :
		 * 
		 * Name=Martial 
		 * Name=Lacazette 
		 * Name=Cavani
		 * 
		 * Name=Aubameyang 
		 * Name=Cavani 
		 * Name=Lacazette 
		 * Name=Martial
		 * 
		 * Name=Aubameyang 
		 * Name=Lacazette 
		 * Name=Cavani 
		 * Name=Martial
		 */
	}
}

class FilterManager {
	static boolean isStriker(Player player) {
		if ("striker".equalsIgnoreCase(player.getPosition())) {
			return true;
		}
		return false;
	}
}

class Player {
	String name;
	String club;
	String position;

	public Player(String name, String club, String position) {
		super();
		this.name = name;
		this.club = club;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
