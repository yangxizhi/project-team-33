package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;

public class Ship {
	public Ship() {
		occupiedSquares = new ArrayList<>();
	}

	@JsonProperty private List<Square> occupiedSquares;
	
	public Ship(String kind) {
		//Set the occupied squares of the ship based on its type
		if(kind.equals("Minesweeper")){
			occupiedSquares = new ArrayList<>(2);
		}else if(kind.equals("Destroyer")){
			occupiedSquares = new ArrayList<>(3);
		}else if(kind.equals("Battleship")){
			occupiedSquares = new ArrayList<>(4);
		}

	}

	public List<Square> getOccupiedSquares() {
		//return the occupied squares of the ship
		return occupiedSquares;
	}
}
