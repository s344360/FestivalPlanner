package jpp.festivalPlanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import jpp.festivalPlanner.base.Kind;
import jpp.festivalPlanner.base.Performer;
import jpp.festivalPlanner.base.Stage;
import jpp.festivalPlanner.comparators.PriorityComparator;
import jpp.festivalPlanner.comparators.TimeComparator;
import jpp.festivalPlanner.util.Selector;

public class FestivalPlanner {

	public static void main(String[] args) {

		List<Performer> bandList = new ArrayList<>();
		Performer performer;

		System.out.println("Insert year of the festival:");
		Scanner sc = new Scanner(System.in);
		String year = sc.nextLine();
		int jahrtest;
		try {
			jahrtest = Integer.parseInt(year);
		} catch (IllegalArgumentException e) {
			return;
		}
		int jahr = Integer.parseInt(year);

		while (true) {
			System.out.println();
			String x = sc.nextLine();
			switch (x) {
			case "add": {

				System.out.println("Name:");

				String bandName = sc.nextLine();

				if (bandName.isEmpty()) {
					System.out.println("Invalid input!");
					break;
				}

				System.out.println("Kind:");
				String kind = sc.nextLine();
				try {

					Kind.valueOf(kind);
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid input!");
					break;

				}

				System.out.println("Stage:");
				String stage = sc.nextLine();
				try {

					Stage.valueOf(stage);
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid input!");
					break;

				}

				DateTimeFormatter t1 = DateTimeFormatter.ofPattern("dd.MM. HH:mm");
				System.out.println("Start:");
				String start = sc.nextLine();
				TemporalAccessor temp;
				LocalDateTime timestart = null;

				try {
					temp = t1.parse(start);
					timestart = LocalDateTime.of(jahr, temp.get(ChronoField.MONTH_OF_YEAR),
							temp.get(ChronoField.DAY_OF_MONTH), temp.get(ChronoField.HOUR_OF_DAY),
							temp.get(ChronoField.MINUTE_OF_HOUR));

				} catch (DateTimeParseException e) {
					System.out.println("Invalid input!");
					break;

				}

				System.out.println("End:");
				String end = sc.nextLine();
				LocalDateTime timeend = null;

				try {
					temp = t1.parse(end);
					timeend = LocalDateTime.of(jahr, temp.get(ChronoField.MONTH_OF_YEAR),
							temp.get(ChronoField.DAY_OF_MONTH), temp.get(ChronoField.HOUR_OF_DAY),
							temp.get(ChronoField.MINUTE_OF_HOUR));

				} catch (DateTimeParseException e) {
					System.out.println("Invalid input!");
					break;

				}
				if (timeend.isBefore(timestart)) {
					System.out.println("Invalid input!");
					break;
				}

				performer = new Performer(bandName, Kind.valueOf(kind), timestart, timeend, Stage.valueOf(stage));
				bandList.add(performer);

				break;
			}

			case "list": {

				if (bandList.isEmpty()) {
					System.out.println("- empty -");
					break;
				}

				for (int i = 0; i < bandList.size(); i++) {
					System.out.println("[" + i + "] " + bandList.get(i));

				}
				break;
			}

			case "remove": {
				if (bandList.isEmpty()) {
					System.out.println("- empty -");
					break;
				}
				System.out.println("ID:");
				String index = sc.nextLine();
				int indexI = Integer.parseInt(index);

				if (indexI > bandList.size() - 1 || indexI < 0) {
					System.out.println("Invalid input!");

				} else {

					bandList.remove(indexI);
				}
				break;
			}

			case "showPriority": {
				if (bandList.isEmpty()) {
					System.out.println("- empty -");
					break;
				}
				System.out.println("ID:");
				String index = sc.nextLine();
				int indexI = Integer.parseInt(index);

				if (indexI > bandList.size() - 1 || indexI < 0) {
					System.out.println("Invalid input!");
				} else {

					System.out.println(bandList.get(indexI));
					System.out.println("priority " + bandList.get(indexI).getPriority());
				}
				break;

			}

			case "setPriority": {
				if (bandList.isEmpty()) {
					System.out.println("- empty -");
					break;
				}
				System.out.println("ID:");
				String index = sc.nextLine();
				int indexI = Integer.parseInt(index);
				if (indexI > bandList.size() - 1 || indexI < 0) {
					System.out.println("Invalid input!");
					break;
				}
				System.out.println("Priority:");
				String priority = sc.nextLine();
				double priorityD = Double.parseDouble(priority);
				if (priorityD < 1.0) {
					System.out.println("Invalid input!");
				} else {
					bandList.get(indexI).setPriority(priorityD);

				}
				break;
			}

			case "selection": {
				List<Performer> bandList2 = new ArrayList<>();

				if (bandList.isEmpty()) {
					System.out.println("- empty -");
					break;
				}
				System.out.println("Enter IDs:");

				String index;
				while (!(index = sc.nextLine()).isEmpty()) {

					int indexI = Integer.parseInt(index);
					if (indexI > bandList.size() - 1 || indexI < 0) {
						System.out.println("Invalid input!");
					} else {
						bandList2.add(bandList.get(indexI));

					}

				}
				if (bandList2.isEmpty()) {
					System.out.println("- empty -");
					break;

				}

				List<Performer> bandList3 = new ArrayList<>();
				System.out.println("Selection mode (normal|priority):");
				String normalPriority = sc.nextLine();
				if (!normalPriority.equals("normal") && !normalPriority.equals("priority")) {
					System.out.println("Invalid input!");
					break;
				} else {
					if (normalPriority.equals("normal")) {

						bandList3 = Selector.selectNonOverlapping(new TimeComparator(), bandList2);
						for (int i = 0; i < bandList3.size(); i++) {
							System.out.println(bandList3.get(i));

						}
					} else {

						bandList3 = Selector.selectNonOverlapping(new PriorityComparator().reversed(), bandList2);

						for (int i = 0; i < bandList3.size(); i++) {
							System.out.println(bandList3.get(i));

						}
					}

				}

				break;
			}

			case "exit": {
				return;
			}

			default: {
				System.out.println("Invalid input!");
			}

			}

		}
	}
}
