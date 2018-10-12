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
					return false
				}
				
				// Sets squares to occupied
				for(int i = 0; i < ship.getLength(); i++){
					char occY = (char)(y+i);
					ship.setOccupiedSquare(new Square(x,occY);
				}
			}
			// If horizontal, check to make sure it doesn't go off the board on the y-axis and then set the squares to occupied
			else{
				// Checks to make sure it isn't off the board
				if(ship.getLength() -1 + y) > 75){
					return false;
				}
				// Sets squares to occupied
				for(int i =0; i < ship.getLength(); i++){
					char occY = (char(y+i);
					ship.setOccupiedSquare(new Square(x,occY));	
				}
			}
		}
		else{
			return false;
		}
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Result result = new Result();

		if (x > 0 && x < 10) && (y > 64 && y < 75){
			
			for(int i = 0; i < attacks.Length(); i++){
				if attack[i].getLocation().getRow() == x && attack[i].getLocation().getCol() == y){
					result.SetResult(AtackStatus.INVALID);	
				}
				else{
					int sunk = 0;
					bool isSunk;
					bool hit = false;
					for(Ship ship: ships){
						for(Square square: ship.getOccupiedSquares()){
							hit = true;
							if(ship.getHits() == ship.getLength -1){
								sunk += 1;
								isSunk = true;
							}
							if((square.getRow() == x) && (sqaure.getColumn() == y){
								if(sunk == 3){
									result.setResult(AtackStatus.SURRENDER);
								}
								if(isSunk == false){
									result.setResult(AtackStatus.HIT);
								}
								else{
									result.setResult(AtackStatus.SUNK);
								}
								
								result.setShip(ship);
							{
						}
					}
					if(hit != true){
						result.setResult(AtackStatus.Miss);
						result.SetLocation(new Square(x,y);
					}
				}
			}
		}
		else{
			result.setResult(AtackStatus.INVALID);
		}

		if(result.getResult() != AtackStatus.INVALID){
			attackList.add(result);
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
