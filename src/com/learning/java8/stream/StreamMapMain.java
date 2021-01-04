package com.learning.java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamMapMain {

	public static void main(String[] args) {
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player("Martial", "Manchester Utd", "Striker"));
		playerList.add(new Player("Aubameyang", "Arsenal", "Winger"));
		playerList.add(new Player("Lacazette", "Arsenal", "Striker"));
		playerList.add(new Player("Cavani", "Manchester Utd", "Striker"));

		Map<String, List<Player>> playerMap = new HashMap<>();
		playerList.stream().forEach(p -> MapManager.setPlayer(p, playerMap));

		for (String key : playerMap.keySet()) {
			List<Player> player = playerMap.get(key);
			System.out.println(key + ":");
			player.stream().forEach(p -> System.out.println(p.getName()));
			System.out.println();
		}
	}

	/**
	 * Result :
	 * 
	 * winger: 
	 * Aubameyang
	 * 
	 * striker: 
	 * Martial 
	 * Lacazette 
	 * Cavani
	 */
}

class MapManager {
	static void setPlayer(Player player, Map<String, List<Player>> map) {
		if ("striker".equalsIgnoreCase(player.getPosition())) {
			List<Player> playerList = null;
			if (map.containsKey("striker")) {
				playerList = map.get("striker");
			} else {
				playerList = new ArrayList<>();
			}
			playerList.add(player);
			map.put("striker", playerList);
		} else {
			List<Player> playerList = null;
			if (map.containsKey("winger")) {
				playerList = map.get("winger");
			} else {
				playerList = new ArrayList<>();
			}
			playerList.add(player);
			map.put("winger", playerList);
		}
	}
}