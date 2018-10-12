package cs361.battleships.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Ship> ships;
	private List<Result> attacks;
	private int rows;
	private int cols;

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Board() {
		ships = new ArrayList<>();
		attacks = new ArrayList<>();
		rows = 10;
		cols = 10;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		// Checks if x and y are in bounds
		if((x > 0 && x < 10) && (y > 64 && y < 75)){
			if(isVertical){ // If Vertical, check to make sure it doesn't go off the board on the x-axis and then set the squares to occupied
				// Checks to make sure it doesn't go off the board
				if((ship.getLength() - 1 + x) > 10){
					return false;
				}
				
				// Sets squares to occupied
				for(int i = 0; i < ship.getLength(); i++){
					char occY = (char)(y+i);
					List<Square> currSquares = new ArrayList();
					currSquares = ship.getOccupiedSquares();
					currSquares.add(new Square(x,occY);
					ship.setOccupiedSquares(currSquares);
				}
			}
			// If horizontal, check to make sure it doesn't go off the board on the y-axis and then set the squares to occupied
			else{
				// Checks to make sure it isn't off the board
				if((ship.getLength() -1 + y) > 75){
					return false;
				}
				// Sets squares to occupied
				for(int i =0; i < ship.getLength(); i++){
					char occY = (char)(y+i);
					List<Square> currSquares = new ArrayList();
					currSquares = ship.getOccupiedSquares();
					currSquares.add(new Square(x,occY);
					ship.getOccupiedSquares(currSquares);
				}
			}
		}
		else{
			return false;
		}
		ships.add(ship);
		return true;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Result result = new Result();
		// Checks to make sure it's in bounds
		if ((x > 0 && x < 10) && (y > 64 && y < 75)){
			// Loops through all attacks
			for(Result attack: attacks){
				// Checks if attack has already been done, if so then you can't shoot the same spot twice
				if (attack.getLocation().getRow() == x && attack.getLocation().getColumn() == y){
					result.setResult(AtackStatus.INVALID);
				}
				else{
					int sunk = 0;
					boolean isSunk = false;
					boolean hit = false;
					// Loops through all ships
					for(Ship ship: ships){
						// Loops through all occupied squares of each ship
						for(Square square: ship.getOccupiedSquares()){
							hit = true;
							// If it has been sunk add one to the counter so we know when to surrender
							if(ship.getHits() == ship.getLength() -1){
								sunk += 1;
								isSunk = true;
							}
							// If hit
							if((square.getRow() == x) && (square.getColumn() == y)){
								// If this is the final ship sunk, surrender
								if (sunk == 3) {
									result.setResult(AtackStatus.SURRENDER);
								}
								// If not sunk then it's just a plain hit
								if (isSunk == false) {
									result.setResult(AtackStatus.HIT);
								} 
								// Otherwise it's sunk
								else {
									
									result.setResult(AtackStatus.SUNK);
								}

								result.setShip(ship);
							}
						}
					}
					// If not hit,mark miss
					if(hit != true){
						result.setResult(AtackStatus.MISS);
						result.setLocation(new Square(x,y));
					}
				}
			}
		}
		
		// If out of bounds
		else{
			result.setResult(AtackStatus.INVALID);
		}
		// If it was an invalid shot, then don't add it. If valid, add it to attacks.
		if(result.getResult() != AtackStatus.INVALID){
			attacks.add(result);
		}
		return result;
	}

	public List<Ship> getShips() {
		return this.ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public List<Result> getAttacks() {
		return this.attacks;
	}

	public void setAttacks(List<Result> attacks) {
		this.attacks = attacks;
	}
}
