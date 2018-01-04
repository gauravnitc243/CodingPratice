package com.interviewbit.arrayandmath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class HotelBooking {
	public static void main(String[] args) {
		HotelBooking hb = new HotelBooking();
		ArrayList<Integer> arrival = new ArrayList<>();
		arrival.addAll(Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48,49, 12, 7, 8));
		ArrayList<Integer> depart = new ArrayList<>();
		depart.addAll(Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60,90, 67, 22, 51, 53));
		System.out.println(hb.hotel(arrival, depart, 23));
	}

	boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		return K >= numberOfRoomsNeeded(arrive, depart);
	}

	public int numberOfRoomsNeeded(ArrayList<Integer> arrivals, ArrayList<Integer> departures) {
		int n = arrivals.size() < departures.size() ? arrivals.size() : departures.size();
		Collections.sort(arrivals);
		Collections.sort(departures);
		int aIndex = 0;
		int dIndex = 0;
		int currentGuest = 0;
		int maxGuests = 0;
		while (aIndex < n && dIndex < n) {
			if (arrivals.get(aIndex) < departures.get(dIndex)) {
				++aIndex;
				++currentGuest;
				maxGuests = Math.max(maxGuests, currentGuest);
			} else {
				++dIndex;
				--currentGuest;
			}
		}
		return maxGuests;
	}
}