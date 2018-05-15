package model;

/**
 * @author Gombos Kriszta
 * This class Polynom implements the operations performed on polynomial
 */
import java.util.*;

public class Polynom {

	private ArrayList<Monom> polinom = new ArrayList<Monom>();

	public Polynom(ArrayList<Monom> listaMonoame) {
		this.polinom = listaMonoame;
	}

	// addition
	public Polynom add(Polynom p) {
		Polynom result;
		for (int i = 0; i < polinom.size(); i++) {
			for (int j = 0; j < p.polinom.size(); j++) {
				if (polinom.get(i).getGrad() == p.polinom.get(j).getGrad()) {

					polinom.get(i).setCoefficient(
							(int) (polinom.get(i).getCoefficient() + p.polinom.get(j).getCoefficient()));
					p.polinom.remove(j);
				}

			}
		}
		polinom.addAll(p.polinom);
		sort(polinom);
		result = new Polynom(polinom);

		return result;
	}

	// subtraction
	public Polynom subtract(Polynom p) {
		Polynom result;
		for (int i = 0; i < p.polinom.size(); i++) {
			p.polinom.get(i).setCoefficient((int) (-p.polinom.get(i).getCoefficient()));
		}

		result = new Polynom((this.add(p)).polinom);
		return result;
	}

	// multiplication
	public Polynom multiply(Polynom p) {

		ArrayList<Monom> result = new ArrayList<Monom>();
		int coefficient, grad;
		int i, j, k, ok;
		for (i = 0; i < polinom.size(); i++) {
			for (j = 0; j < p.polinom.size(); j++) {
				coefficient = (int) (polinom.get(i).getCoefficient() * p.polinom.get(j).getCoefficient());
				grad = polinom.get(i).getGrad() + p.polinom.get(j).getGrad();
				ok = 0;
				for (k = 0; k < result.size(); k++)
					if (result.get(k).getGrad() == grad) {
						((MonomInt) result.get(k)).setCoefficient((int) (result.get(k).getCoefficient() + coefficient));
						ok = 1;
					}
				if (ok == 0) {
					result.add(new MonomInt(coefficient, grad));
				}
			}
		}
		sort(result);

		Polynom res = new Polynom(result);

		return res;
	}

	//divide return an array of polynomials from which the first one is the result and the second one the rest
	public ArrayList<Polynom> divide(Polynom p) {

		Polynom polinomCat, polinomRest;
		ArrayList<Polynom> grup = new ArrayList<Polynom>();
		ArrayList<Monom> cat = new ArrayList<Monom>();
		ArrayList<Monom> aux = new ArrayList<Monom>();
		ArrayList<Monom> aux2 = new ArrayList<Monom>();
		double coeficient;
		int grad, gradImpartitor, gradRest;

		//each polynomial consists of a monom
		if (polinom.size() == 1 && p.polinom.size() == 1) {
			cat.add(new MonomReal(polinom.get(0).getCoefficient() / p.polinom.get(0).getCoefficient(),
					(polinom.get(0).getGrad() -p.polinom.get(0).getGrad())));
			aux.add(new MonomInt(0, 0));
			polinomRest = new Polynom(aux);
			polinomCat = new Polynom(cat);
			grup.add(polinomCat);
			grup.add(polinomRest);
			return grup;
		}

		// the case in which the grad of the first polynomial is smaller than the second ones
		if (polinom.get(0).getGrad() < p.polinom.get(0).getGrad()) {
			cat.add(new MonomInt(0, 0));
			polinomRest = new Polynom(polinom);
			polinomCat = new Polynom(cat);
			grup.add(polinomCat);
			grup.add(polinomRest);
			return grup;
		} else {
			gradRest = polinom.get(0).getGrad();
			gradImpartitor = p.polinom.get(0).getGrad();
			while (gradRest >= gradImpartitor) {
				coeficient = polinom.get(0).getCoefficient() / p.polinom.get(0).getCoefficient();
				grad = polinom.get(0).getGrad() - p.polinom.get(0).getGrad();
				cat.add(new MonomReal(coeficient, grad));
				for (int i = 0; i < p.polinom.size(); i++) {
					aux.add(new MonomReal((-coeficient) * p.polinom.get(i).getCoefficient(),
							grad + p.polinom.get(i).getGrad()));
				}
				scadereImpartire(polinom, aux, aux2);
				polinom.clear();
				polinom.addAll(aux2);
				aux2.clear();
				aux.clear();
				polinom.remove(0);
				gradRest = polinom.get(0).getGrad();
				gradImpartitor = p.polinom.get(0).getGrad();
			}
		}
		polinomRest = new Polynom(polinom);
		polinomCat = new Polynom(cat);
		grup.add(polinomCat);
		grup.add(polinomRest);

		return grup;
	}

	// derivate
	public Polynom derivate() {
		ArrayList<Monom> rezultat = new ArrayList<Monom>();
		int coefficient, grad;
		int i;
		for (i = 0; i < polinom.size(); i++) {
			coefficient = (int) polinom.get(i).getCoefficient();
			grad = polinom.get(i).getGrad();
			if (grad >= 0)
				rezultat.add(new MonomInt(coefficient * grad, grad - 1));
		}
		Polynom polinom1 = new Polynom(rezultat);
		return polinom1;
	}

	//integrate

	public Polynom integrate() {
		ArrayList<Monom> result = new ArrayList<Monom>();
		double coefficient;
		int grad;
		int i;
		for (i = 0; i < polinom.size(); i++) {
			coefficient = (int) (polinom.get(i)).getCoefficient();
			grad = (polinom.get(i)).getGrad();
			result.add(new MonomReal(coefficient / (grad + 1), grad + 1));
		}
		Polynom res = new Polynom(result);
		return res;
	}

	public String toString() {
		String sir = "";
		int i;
		if (polinom.size() == 0) {
			sir += "0";
		}
		for (i = 0; i < polinom.size(); i++) {

			if (i != 0) {
				if (polinom.get(i).toString().charAt(0) != '-' && polinom.get(i).getCoefficient() != 0 && i - 1 != 0 && polinom.get(i - 1).getCoefficient() == 0) {
					sir += "+";
				}
				if (polinom.get(i).getCoefficient() != 0) {
					if (polinom.get(i).toString().charAt(0) == '-')
						sir += polinom.get(i).toString();
					else {
						sir += "+" + polinom.get(i).toString();
					}
				}
			} else {
				if (polinom.get(i).getCoefficient() != 0) {
					sir += polinom.get(i).toString();
				}
			}
		}

		if (sir.equals("")) {
			return "0";
		}
		return sir;
	}

	public void scadereImpartire(ArrayList<Monom> polinom1, ArrayList<Monom> polinom2, ArrayList<Monom> rezultat) {
		int grad;
		double coeficient;
		int i = 0;
		polinom1.addAll(polinom2);
		sort(polinom1);

		while (i < polinom1.size()) {
			if ((i + 1) < polinom1.size() && polinom1.get(i).getGrad() == polinom1.get(i + 1).getGrad()) {
				grad = polinom1.get(i).getGrad();
				coeficient = (polinom1.get(i).getCoefficient() + polinom1.get(i + 1).getCoefficient());
				rezultat.add(new MonomReal(coeficient, grad));
				i++;
			} else {
				grad = polinom1.get(i).getGrad();
				coeficient = (polinom1.get(i).getCoefficient());
				rezultat.add(new MonomReal(coeficient, grad));
			}
			i++;
		}
	}

	public void sort(ArrayList<Monom> polinom) {
		Monom x;
		for (int i = polinom.size() - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (polinom.get(j).getGrad() < polinom.get(j + 1).getGrad()) {
					x = polinom.get(j);
					polinom.set(j, polinom.get(j + 1));
					polinom.set(j + 1, x);
				}
			}
		}
	}

}