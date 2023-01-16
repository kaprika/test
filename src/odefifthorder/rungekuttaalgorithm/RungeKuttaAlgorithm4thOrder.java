package odefifthorder.rungekuttaalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import odefifthorder.data.SystemOfOrdinaryDifferentialEquations5order;

public class RungeKuttaAlgorithm4thOrder {
	private List<double[]> k;
	private double h;
	private double xStart;
	private double xEnd;

	public Map<Double, Double> getSolutionTable(SystemOfOrdinaryDifferentialEquations5order system) {
		SortedMap<Double, Double> solution = new TreeMap<Double, Double>();
		solution.put(xStart, system.getListCauchyProblem().get(0));
		double x = xStart + h;
		for (int i = 0; x <= xEnd; i++, x += h) {
			setK0(h, system, i);
			setK1(h, system, i);
			setK2(h, system, i);
			setK3(h, system, i);
			setY(system, i);
			solution.put(x, system.getY().get(0).get(i + 1));
		}
		return solution;
	}

	private void setK0(double h, SystemOfOrdinaryDifferentialEquations5order system, int index) {
		k.get(0)[0] = h * system.getY().get(1).get(index);
		k.get(1)[0] = h * system.getY().get(2).get(index);
		k.get(2)[0] = h * system.getY().get(3).get(index);
		k.get(3)[0] = h * system.getY().get(4).get(index);
		k.get(4)[0] = h * (-15 * system.getY().get(4).get(index) - 90 * system.getY().get(3).get(index)
				- 270 * system.getY().get(2).get(index) - 405 * system.getY().get(1).get(index)
				- 243 * system.getY().get(0).get(index));
	}

	private void setK1(double h, SystemOfOrdinaryDifferentialEquations5order system, int index) {
		k.get(0)[1] = h * (system.getY().get(1).get(index) + 0.5 * k.get(1)[0]);
		k.get(1)[1] = h * (system.getY().get(2).get(index) + 0.5 * k.get(2)[0]);
		k.get(2)[1] = h * (system.getY().get(3).get(index) + 0.5 * k.get(3)[0]);
		k.get(3)[1] = h * (system.getY().get(4).get(index) + 0.5 * k.get(4)[0]);
		k.get(4)[1] = h * (-15 * (system.getY().get(4).get(index) + 0.5 * k.get(4)[0])
				- 90 * (system.getY().get(3).get(index) + 0.5 * k.get(3)[0])
				- 270 * (system.getY().get(2).get(index) + 0.5 * k.get(2)[0])
				- 405 * (system.getY().get(1).get(index) + 0.5 * k.get(1)[0])
				- 243 * (system.getY().get(0).get(index) + 0.5 * k.get(0)[0]));
	}

	private void setK2(double h, SystemOfOrdinaryDifferentialEquations5order system, int index) {
		k.get(0)[2] = h * (system.getY().get(1).get(index) + 0.5 * k.get(1)[1]);
		k.get(1)[2] = h * (system.getY().get(2).get(index) + 0.5 * k.get(2)[1]);
		k.get(2)[2] = h * (system.getY().get(3).get(index) + 0.5 * k.get(3)[1]);
		k.get(3)[2] = h * (system.getY().get(4).get(index) + 0.5 * k.get(4)[1]);
		k.get(4)[2] = h * (-15 * (system.getY().get(4).get(index) + 0.5 * k.get(4)[1])
				- 90 * (system.getY().get(3).get(index) + 0.5 * k.get(3)[1])
				- 270 * (system.getY().get(2).get(index) + 0.5 * k.get(2)[1])
				- 405 * (system.getY().get(1).get(index) + 0.5 * k.get(1)[1])
				- 243 * (system.getY().get(0).get(index) + 0.5 * k.get(0)[1]));
	}

	private void setK3(double h, SystemOfOrdinaryDifferentialEquations5order system, int index) {
		k.get(0)[3] = h * (system.getY().get(1).get(index) + k.get(1)[2]);
		k.get(1)[3] = h * (system.getY().get(2).get(index) + k.get(2)[2]);
		k.get(2)[3] = h * (system.getY().get(3).get(index) + k.get(3)[2]);
		k.get(3)[3] = h * (system.getY().get(4).get(index) + k.get(4)[2]);
		k.get(4)[3] = h * (-15 * (system.getY().get(4).get(index) + k.get(4)[2])
				- 90 * (system.getY().get(3).get(index) + k.get(3)[2])
				- 270 * (system.getY().get(2).get(index) + k.get(2)[2])
				- 405 * (system.getY().get(1).get(index) + k.get(1)[2])
				- 243 * (system.getY().get(0).get(index) + k.get(0)[2]));
	}

	private void setY(SystemOfOrdinaryDifferentialEquations5order system, int index) {
		for (int i = 0; i < 5; i++) {
			system.getY().get(i).add(index + 1, system.getY().get(i).get(index)
					+ 1.0 / 6 * (k.get(i)[0] + 2 * k.get(i)[1] + 2 * k.get(i)[2] + k.get(i)[3]));
		}
	}

	public RungeKuttaAlgorithm4thOrder(double xStart, double xEnd, double h) {
		super();
		this.h = h;
		this.xStart = xStart;
		this.xEnd = xEnd;
		k = new ArrayList<double[]>();
		for (int i = 0; i < 5; i++) {
			k.add(new double[4]);
		}
	}
}
