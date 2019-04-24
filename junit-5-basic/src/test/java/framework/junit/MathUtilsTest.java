package framework.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(Lifecycle.PER_CLASS)
class MathUtilsTest {
	@BeforeAll
	void beforAllInit() {
		System.out.println("before all init called....");
	}
    
	@AfterAll
	void afterAllCleanup() {
		System.out.println("after all init clean up called....");
	}
	@BeforeEach
	void init() {
		System.out.println("before each method");
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("after each method");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	void testAdd() {
		int expected=1;
		MathUtils mathUtil= new MathUtils();
		int actual=mathUtil.add(0, 1);
		assertEquals(expected, actual);
		
	}
	@Test
	void testDivide() {
		MathUtils mathUtil= new MathUtils();
		assertThrows(ArithmeticException.class, ()->mathUtil.divide(5, 0),"divide by zero should throw exception");
		
	}
	@Test
	void testComputeCircleRadius() {
		MathUtils mathUtil= new MathUtils();
		assertEquals(314.1592653589793, mathUtil.computeCircle(10));
		
	}
}
