package odefifthorder.data;

import java.util.ArrayList;
import java.util.List;

public class SystemOfOrdinaryDifferentialEquations5order {
	private List<ArrayList<Double>> y;
	private List<Double> listCauchyProblem;

	public SystemOfOrdinaryDifferentialEquations5order() {
		this.y = new ArrayList<ArrayList<Double>>();
		this.listCauchyProblem = new ArrayList<Double>();
	}

	public List<ArrayList<Double>> getY() {
		return y;
	}

	public List<Double> getListCauchyProblem() {
		return listCauchyProblem;
	}

	public void setListCauchyProblem(double... value) {
		for (int i = 0; i < value.length; i++) {
			listCauchyProblem.add(value[i]);
			y.add(i, new ArrayList<Double>());
			y.get(i).add(0, value[i]);
		}
	}
}
