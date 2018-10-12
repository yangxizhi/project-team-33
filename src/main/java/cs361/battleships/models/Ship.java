package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;

public class Ship {
	public Ship() {
		occupiedSquares = new ArrayList<>();
	}

	private int length; // length of ship
	private String type; // type of ship
	private int hits; // num of hits

	@JsonProperty private List<Square> occupiedSquares;

	public Ship(String kind) {
		//Set the occupied squares of the ship based on its type.
		if(kind.equals("MINESWEEPER")){
			occupiedSquares = new ArrayList<>(2);
			setLength(2);
		}else if(kind.equals("DESTROYER")){
			occupiedSquares = new ArrayList<>(3);
			setLength(3);
		}else if(kind.equals("BATTLESHIP")){
			occupiedSquares = new ArrayList<>(4);
			setLength(4);
		}
		setType(kind);
		setHits(0);
	}

	public int getLength(){
		return this.length;
	}
	public void setLength(int aLength){
		this.length = aLength;
	}
	public String getType(){
		return this.type;
	}
	public void setType(String aString){
		this.type = aString;
	}

	public int getHits(){
		return this.hits;
	}
	public void setHits(int aHits){
		this.hits = aHits;
	}

	public List<Square> getOccupiedSquares() {
		//return the occupied squares of the ship.
		return occupiedSquares;
	}
	public void setOccupiedSquares(List<Square> occupiedSquares){
		 this.occupiedSquares = occupiedSquares;
	}
}
