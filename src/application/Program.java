package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		sc.nextLine();
		Date checkIn = sdf.parse(sc.nextLine());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.nextLine());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out must be after check-in!");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.nextLine());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates!");
			} else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out must be after check-in!");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}
}
