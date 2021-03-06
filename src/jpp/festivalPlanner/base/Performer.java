package jpp.festivalPlanner.base;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class Performer {
	String name;
	Kind kind;
	LocalDateTime start;
	LocalDateTime end;
	Stage stage;
	double priority = 1.0;

	public Performer(String name, Kind kind, LocalDateTime start, LocalDateTime end, Stage stage)
			throws NullPointerException, IllegalArgumentException {
		if (name == null || kind == null || start == null || end == null || stage == null) {
			throw new NullPointerException();
		}
		if (start.isAfter(end) == true || start.equals(end)) {
			throw new IllegalArgumentException();

		}
		this.name = name;
		this.kind = kind;
		this.start = start;
		this.end = end;
		this.stage = stage;

	}

	public Kind getKind() {
		return kind;
	}

	public String getName() {
		return name;

	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public Stage getStage() {
		return stage;
	}

	public double getPriority() {
		if (priority < 1.0) {
			return 1.0;
		} else
			return priority;
	}

	public void setPriority(double p) throws IllegalArgumentException {
		if (p < 1.0) {
			throw new IllegalArgumentException();
		}
		this.priority = p;

	}

	public String toString() {
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("EEE, dd.MM. HH:mm");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("HH:mm");
		String s1 = start.format(f1);
		String e1 = end.format(f2);
		String e2 = end.format(f1);

		if (start.getDayOfWeek().equals(end.getDayOfWeek())) {
			return name + " (" + kind + ") " + ": " + stage + " " + s1 + " - " + e1;
		} else
			return name + " (" + kind + ") " + ": " + stage + " " + s1 + " - " + e2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priority);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((stage == null) ? 0 : stage.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Performer other = (Performer) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (kind != other.kind)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(priority) != Double.doubleToLongBits(other.priority))
			return false;
		if (stage != other.stage)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

}
