package jpp.festivalPlanner.comparators;

import java.util.Comparator;

import jpp.festivalPlanner.base.Performer;

public class TimeComparator implements Comparator<Performer> {

	public int compare(Performer o1, Performer o2) {

		if ((o1.getEnd().equals(o2.getEnd()))) {
			if (o1.getStart().equals(o2.getStart())) {
				if (o1.getName().equals(o2.getName())) {
					if (o1.getKind().equals(o2.getKind())) {
						if (o1.getStage().equals(o2.getStage())) {
							if (o1.getPriority() == o2.getPriority()) {
								return 0;

							} else {
								if (o1.getPriority() < o2.getPriority()) {
									return -1;

								} else {
									return 1;
								}
							}
						}

						else {
							if (o1.getStage().compareTo(o2.getStage()) < 0) {
								return -1;
							} else {
								return 1;

							}
						}
					} else {
						if (o1.getKind().compareTo(o2.getKind()) < 0) {
							return -1;
						} else {
							return 1;
						}

					}

				} else {
					if (o1.getName().compareTo(o2.getName()) < 0) {
						return -1;
					} else {
						return 1;
					}

				}

			} else {
				if (o1.getStart().compareTo(o2.getStart()) < 0) {
					return -1;
				} else {
					return 1;
				}
			}
		} else {
			if (o1.getEnd().compareTo(o2.getEnd()) < 0) {
				return -1;
			} else {
				return 1;

			}
		}

	}
}
