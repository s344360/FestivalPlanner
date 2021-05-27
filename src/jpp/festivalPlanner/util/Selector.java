package jpp.festivalPlanner.util;

import java.util.*;
import jpp.festivalPlanner.base.Performer;
import jpp.festivalPlanner.comparators.TimeComparator;

public class Selector {

	public static List<Performer> selectNonOverlapping(Comparator<Performer> comp, Collection<Performer> col) {
		List<Performer> bandList = new ArrayList<Performer>(col);
		List<Performer> resultList = new ArrayList<Performer>();
		while (!bandList.isEmpty()) {
			Collections.sort(bandList, comp);
			Performer p = bandList.get(0);
			bandList.remove(0);
			boolean test = true;
			for (Performer item : resultList) {
				if (item.getEnd().isEqual(p.getStart()) || item.getStart().isEqual(p.getEnd())
						|| item.getStart().isAfter(p.getEnd()) || item.getEnd().isBefore(p.getStart())) {
					test = test && true;
				} else {
					test = test && false;
				}
			}
			if (test == true) {
				resultList.add(p);
			}

		}

		Collections.sort(resultList, new TimeComparator());
		return resultList;
	}
}
