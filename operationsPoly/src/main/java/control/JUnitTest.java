package control;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

import model.Monom;
import model.MonomInt;
import model.Polynom;
public class JUnitTest {

	@Test
	public void test() {
		Polynom p1, p2;
		ArrayList<Monom> pol1 = new ArrayList<Monom>();
		ArrayList<Monom> pol2 = new ArrayList<Monom>();
		pol1.add(new MonomInt(2, 2));
		
		pol2.add(new MonomInt(3, 1));
		
		p1 = new Polynom(pol1);
		p2 = new Polynom(pol2);
		
		assertEquals("2x^2+3x^1", p1.add(p2).toString()) ;
		
	}

	@Test
	public void test1() {
		Polynom p1, p2;
		ArrayList<Monom> pol1 = new ArrayList<Monom>();
		ArrayList<Monom> pol2 = new ArrayList<Monom>();
		pol1.add(new MonomInt(2, 2));
		
		pol2.add(new MonomInt(3, 1));
		
		p1 = new Polynom(pol1);
		p2 = new Polynom(pol2);
		
		assertEquals("2x^2-3x^1", p1.subtract(p2).toString()) ;
		
	}
	
	@Test
	public void test2() {
		Polynom p1, p2;
		ArrayList<Monom> pol1 = new ArrayList<Monom>();
		ArrayList<Monom> pol2 = new ArrayList<Monom>();
		pol1.add(new MonomInt(2, 2));
		
		pol2.add(new MonomInt(3, 1));
		
		p1 = new Polynom(pol1);
		p2 = new Polynom(pol2);
		
		assertEquals("6x^3", p1.multiply(p2).toString()) ;
		
	}
	
	@Test
	public void test3() {
		Polynom p1, p2;
		ArrayList<Monom> pol1 = new ArrayList<Monom>();
		ArrayList<Monom> pol2 = new ArrayList<Monom>();
		pol1.add(new MonomInt(2, 1));
		
		pol2.add(new MonomInt(2, 1));
		
		p1 = new Polynom(pol1);
		p2 = new Polynom(pol2);
		
		assertEquals("1.00", p1.divide(p2).get(0).toString()+p1.divide(p2).get(1).toString()) ;
		
	}
	
	@Test
	public void test4() {
		Polynom p1;
		ArrayList<Monom> pol1 = new ArrayList<Monom>();
		pol1.add(new MonomInt(2, 2));
		
		p1 = new Polynom(pol1);
		
		assertEquals("4x^1", p1.derivate().toString()) ;
		
	}
	
	@Test
	public void test5() {
		Polynom p1;
		ArrayList<Monom> pol1 = new ArrayList<Monom>();
		pol1.add(new MonomInt(3, 2));
		
		p1 = new Polynom(pol1);
		
		assertEquals("1.0x^3", p1.integrate().toString()) ;
		
	}
}
