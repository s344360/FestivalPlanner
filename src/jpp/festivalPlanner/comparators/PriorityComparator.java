package jpp.festivalPlanner.comparators;

import java.time.Duration;
import java.util.Comparator;

import jpp.festivalPlanner.base.Performer;

public class PriorityComparator implements Comparator<Performer> {

	@Override
	public int compare(Performer o1, Performer o2) {
		double res1 = Duration.between(o1.getStart(), o1.getEnd()).toMillis();
		double res2 = Duration.between(o2.getStart(), o2.getEnd()).toMillis();
		double res3 = o1.getPriority() * res1;
		double res4 = o2.getPriority() * res2;

		if (res3 == res4) {
			if (o1.getPriority() == o2.getPriority()) {
				if ((o1.getEnd().equals(o2.getEnd()))) {
					if (o1.getName().equals(o2.getName())) {
						if (o1.getKind().equals(o2.getKind())) {
							if (o1.getStage().equals(o2.getStage())) {
								return 0;

							} else {
								if (o1.getStage().compareTo(o2.getStage()) < 0) {
									return -1;
								} else {
									return 1;

								}
							}
						}

						else {
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
					if (o1.getEnd().compareTo(o2.getEnd()) < 0) {
						return -1;
					} else {
						return 1;

					}
				}

			} else {
				if (o1.getPriority() < o2.getPriority()) {
					return -1;

				} else {
					return 1;
				}
			}
		} else {
			if (res3 < res4) {
				return -1;

			} else {
				return 1;
			}
		}

	};
}
