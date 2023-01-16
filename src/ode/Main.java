package ode;

import java.util.Map;

import odefifthorder.data.SystemOfOrdinaryDifferentialEquations5order;
import odefifthorder.rungekuttaalgorithm.RungeKuttaAlgorithm4thOrder;

public class Main {

	public static void main(String[] args) {
		SystemOfOrdinaryDifferentialEquations5order system = new SystemOfOrdinaryDifferentialEquations5order();
		system.setListCauchyProblem(0, 3, -9, -8, 0);
		RungeKuttaAlgorithm4thOrder algorithm = new RungeKuttaAlgorithm4thOrder(0, 5, 0.1);
		Map<Double, Double> solution = algorithm.getSolutionTable(system);
		System.out.println("x\t\ty");
		for (Double key : solution.keySet()) {
			System.out.println(String.format("%-10.5f\t%.8f", key, solution.get(key)));
		}
	}
}
