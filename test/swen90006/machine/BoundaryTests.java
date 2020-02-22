package swen90006.machine;

import java.util.List;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;

import org.junit.*;
import static org.junit.Assert.*;

public class BoundaryTests
{
	
	
	  //Any method annotated with "@Before" will be executed before each test,
	  //allowing the tester to set up some shared resources.
	  @Before public void setUp()
	  {
	  }

	  //Any method annotated with "@After" will be executed after each test,
	  //allowing the tester to release any shared resources used in the setup.
	  @After public void tearDown()
	  {
	  }

	  // Test a valid input of add instruction.
	  // Test the boundary R0 of ret instruction
	  @Test public void retInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test an invalid input of add instruction.
	  // Test the boundary R0 of ret instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void retInstructionInvalidRegisterTest_low()
	  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("ret R-1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of add instruction.
	  // Test the boundary R31 of ret instruction
	  @Test public void retInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("ret R31;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test an invalid input of add instruction.
	  // Test the boundary R31 of ret instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void retInstructionInvalidRegisterTest_high()
	  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("ret R32;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of add instruction.
	  // Test the boundary R0 of mov instruction
	  @Test public void movInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	 
	  // Test an invalid input of add instruction.
	  // Test the boundary R0 of mov instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void movInstructionInvalidRegisterTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R-1 0;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of add instruction.
	  // Test the boundary R31 of mov instruction
	  @Test public void movInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("ret R31;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	 
	  // Test an invalid input of add instruction.
	  // Test the boundary R31 of mov instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void movInstructionInvalidRegisterTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R32 0;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of add instruction.
	  // Test the boundary 65535 of mov instruction
	 @Test public void movInstructionvValidValueTest_high()
			  throws Throwable
	 {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 65535;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 65535);
	 }
	  
	  // Test an invalid input of add instruction.
	  // Test the boundary 65535 of mov instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void movInstructionInvalidValueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 65536;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  

	  // Test a valid input of add instruction.
	  // Test the boundary -65535 of mov instruction
	 @Test public void movInstructionvValidValueTest_low()
	 {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 -65535;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), -65535);
	 }
	  
	  // Test an invalid input of add instruction.
	  // Test the boundary -65535 of mov instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void movInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 -65536;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of add instruction.
	  // Test the boundary R0 of add instruction
	  @Test public void addInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("add R0 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 3);
	  }
	  
	  // Test a invalid input of add instruction.
	  // Test the boundary R0 of add instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void addInstructionInValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("add R-1 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 3);
	  }
	  
	  // Test a valid input of add instruction.
	  // Test the boundary R31 of add instruction
	  @Test public void addInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("add R31 R1 R2;");
		  list.add("ret R31;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 3);
	  }
	  
	  // Test a invalid input of add instruction.
	  // Test the boundary R31 of add instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void addInstructionInValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("add R32 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of sub instruction.
	  // Test the boundary R0 of sub instruction
	  @Test public void subInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("sub R0 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), -1);
	  }
	  
	  // Test a invalid input of sub instruction.
	  // Test the boundary R0 of sub instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void subInstructionInValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("sub R-1 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of sub instruction.
	  // Test the boundary R31 of sub instruction
	  @Test public void subInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("sub R31 R1 R2;");
		  list.add("ret R31;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), -1);
	  }
	  
	  // Test a invalid input of sub instruction.
	  // Test the boundary R31 of sub instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void subInstructionInValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("sub R32 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of mul instruction.
	  // Test the boundary R0 of mul instruction
	  @Test public void mulInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mul R0 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // Test a invalid input of mul instruction.
	  // Test the boundary R0 of mul instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void mulInstructionInValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("add R-1 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of mul instruction.
	  // Test the boundary R31 of mul instruction
	  @Test public void mulInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mul R31 R1 R2;");
		  list.add("ret R31;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // Test a invalid input of mul instruction.
	  // Test the boundary R31 of mul instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void mulInstructionInValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mul R32 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of div instruction.
	  // Test the boundary R0 of div instruction
	  @Test public void divInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("div R0 R2 R1;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // Test a invalid input of div instruction.
	  // Test the boundary R0 of div instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void divInstructionInValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("div R-1 R2 R1;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of div instruction.
	  // Test the boundary R31 of div instruction
	  @Test public void divInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("div R31 R2 R1;");
		  list.add("ret R31;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // Test a invalid input of div instruction.
	  // Test the boundary R31 of div instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void divInstructionInValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("div R32 R2 R1;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of div instruction.
	  // Test the boundary Rc not = 0 of div instruction has been covered before
	  
	  
	  // Test a valid input of div instruction.
	  // Test the boundary Rc = 0 of div instruction
	  @Test public void divInstructionValidTest_div0()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 2;");
		  list.add("mov R2 0;");
		  list.add("div R0 R1 R2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	 

	  
	  // Test a valid input of ldr instruction.
	  // Test the boundary R0 of ldr instruction
	  @Test public void ldrInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R1 R0 0;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test an invalid input of ldr instruction.
	  // Test the boundary R0 of ldr instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void ldrInstructionInvalidRegisterTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R-1 R0 0;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	 

	  // Test a valid input of ldr instruction.
	  // Test the boundary R31 of ldr instruction
	  @Test public void ldrInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R31 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R31 R0 0;");
		  list.add("ret R31;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test an invalid input of ldr instruction.
	  // Test the boundary R31 of ldr instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void ldrInstructionInvalidRegisterTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R32 R0 0;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  
	  // Test a valid input of ldr instruction.
	  // Test the boundary 65535 of ldr instruction
	  @Test public void ldrInstructionValidValueTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("str R0 65535 R2;");
		  list.add("ldr R1 R0 65535;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  

	  // Test an invalid input of ldr instruction.
	  // Test the boundary 65535 of ldr instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void ldrInstructionInvalidValueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R1 R0 65536;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  
	  // Test a valid input of ldr instruction.
	  // Test the boundary -65535 of ldr instruction
	  @Test public void ldrInstructionValidValueTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("str R0 -65535 R2;");
		  list.add("ldr R1 R0 -65535;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list),1);
	  }
	  

	  // Test an invalid input of ldr instruction.
	  // Test the boundary -65535 of ldr instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void ldrInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R1 R0 -65536;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  
	  // Test a valid input of ldr instruction.
	  //  Test the boundary R+v = 0 of ldr instruction
	  @Test 
	  public void ldrInstructionValidAddressTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("ldr R1 R3 0;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }

	  // Test a valid input of ldr instruction.
	  //  Test the boundary R+v >= 0 of ldr instruction
	  @Test 
	  public void ldrInstructionInvalidAddressTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R4 -1;");
		  list.add("ldr R1 R4 0;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 1);
	  }
	  
	  // Test a valid input of ldr instruction.
	  //  Test the boundary R+v = 65535 of ldr instruction
	  @Test 
	  public void ldrInstructionValidAddressTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R3 1;");
		  list.add("mov R1 0;");
		  list.add("mov R2 2;");
		  list.add("ldr R3 R1 65535;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test a valid input of ldr instruction.
	  //  Test the boundary R+v = 65535 of ldr instruction
	  @Test 
	  public void ldrInstructionInvalidAddressTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R3 1;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R3 R1 65535;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 1);
	  }
	  
	  // Test a valid input of str instruction.
	  //  Test the boundary R0 of str instruction
	  @Test public void strInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 0 R2;");
		  list.add("ldr R3 R0 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	 
	  // Test an invalid input of str instruction.
	  //  Test the boundary R0 of str instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void strInstructionInvalidRegisterTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 0 R-1;");
		  list.add("ldr R3 R0 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of str instruction.
	  //  Test the boundary R31 of str instruction
	  @Test public void strInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R31 0 R2;");
		  list.add("ldr R3 R31 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	 
	  // Test an invalid input of str instruction.
	  //  Test the boundary R32 of str instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void strInstructionInvalidRegisterTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R32 0 R-1;");
		  list.add("ldr R3 R31 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test a valid input of str instruction.
	  //  Test the boundary 65535 of str instruction
	  @Test public void strInstructionValidValueTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 65535 R2;");
		  list.add("ldr R3 R0 65535;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  
	  // Test an invalid input of str instruction.
	  //  Test the boundary 65535 of str instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void strInstructionInvalidValueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 65536 R2;");
		  list.add("ldr R3 R0 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  
	  // Test a valid input of str instruction.
	  //  Test the boundary -65535 of str instruction
	  @Test public void strInstructionValidValueTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 -65535 R2;");
		  list.add("ldr R3 R0 -65535;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  
	  // Test an invalid input of str instruction.
	  //  Test the boundary -65535 of str instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void strInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 -65536 R2;");
		  list.add("ldr R3 R0 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  

	  
	  //  Test a valid input of str instruction.
	  //  Test the boundary R + v = 0 of str instruction
	  @Test public void strInstructionValidAddress_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 3;");
		  list.add("mov R4 0;");
		  list.add("str R4 0 R2;");
		  list.add("ldr R3 R4 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  //  Test a valid input of str instruction.
	  //  Test the boundary R + v = 0 of str instruction
	  @Test public void strInstructionInvalidAddress_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 3;");
		  list.add("mov R4 -1;");
		  list.add("str R4 0 R2;");
		  list.add("ldr R3 R4 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 3);
	  }
	  
	  //  Test a valid input of str instruction.
	  //  Test the boundary R + v = 0 of str instruction
	  @Test public void strInstructionValidAddress_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 3;");
		  list.add("str R1 65534 R2;");
		  list.add("ldr R3 R1 65534;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  //  Test a valid input of str instruction.
	  //  Test the boundary R + v = 65535 of str instruction
	  @Test public void strInstructionInvalidAddress_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 3;");
		  list.add("str R1 65535 R2;");
		  list.add("ldr R3 R1 65535;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 3);
	  }
	  
	  //  Test an invalid input of jmp instruction.
	  //  Test the boundary v = 65535 of jmp instruction
	  @Test (expected = NoReturnValueException.class) 
	  public void jmpInstructionValidTest_high() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 65535;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	 
	  //  Test an invalid input of jmp instruction.
	  //  Test the boundary v = 65535 of jmp instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void jmpInstructionInvalidValueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 65536;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  //  Test an invalid input of jmp instruction.
	  //  Test the boundary v = -65535 of jmp instruction
	  @Test (expected = NoReturnValueException.class) 
	  public void jmpInstructionValidTest_low() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp -65535;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	 
	  //  Test an invalid input of jmp instruction.
	  //  Test the boundary v = -65535 of jmp instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void jmpInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp -65536;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test an invalid input of jmp instruction.
	  // Partitioning class is { jmp v; | v + pc < 0 }
	  @Test (expected = NoReturnValueException.class) 
	  public void jmpInstructionInvalidPositionTest_low() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp -1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // Test an invalid input of jmp instruction.
	  // Partitioning class is { jmp v; | v + pc = 0 }
	  // Can't test because of infinite loop
	  
	  // Test an invalid input of jmp instruction.
	  // Partitioning class is { jmp v; | v + pc = progLength}
	  @Test 
	  public void jmpInstructionValidPositionTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 1;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test an invalid input of jmp instruction.
	  // Partitioning class is { jmp v; | v + pc > progLength }
	  @Test (expected = NoReturnValueException.class) 
	  public void jmpInstructionInvalidPositionTest_high() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }

	  
	  //  Test a valid input of jz instruction.
	  //  Test the boundary R31 of jz instruction
	  @Test public void jzInstructionValidRegisterTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R31 0");
		  list.add("jz R31 3;");
		  list.add("mov R0 1;");
		  list.add("ret R0;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  //  Test an invalid input of jz instruction.
	  //  Test the boundary R31 of jz instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void jzInstructionInvalidRegisterTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R32 2;");
		  list.add("mov R0 1;");
		  list.add("ret R0;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  //  Test a valid input of jz instruction.
	  //  Test the boundary R0 of jz instruction
	  @Test public void jzInstructionValidRegisterTest_low()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R0 3;");
		  list.add("mov R0 1;");
		  list.add("ret R0;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  //  Test an invalid input of jz instruction.
	  //  Test the boundary R0 of jz instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void jzInstructionInvalidRegisterTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R32 2;");
		  list.add("mov R0 1;");
		  list.add("ret R0;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  

	  //  Test a valid input of jz instruction.
	  //  Test the boundary 65535 of jz instruction
	  @Test (expected = NoReturnValueException.class) 
	  public void jzInstructionInvalidValueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R0 65535;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  //  Test an invalid input of jz instruction.
	  //  Test the boundary 65535 of jz instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void jzInstructionInvalidInvalueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R0 65536;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  //  Test a valid input of jz instruction.
	  //  Test the boundary -65535 of jz instruction
	  @Test (expected = NoReturnValueException.class) 
	  public void jzInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R0 -65535;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  //  Test an invalid input of jz instruction.
	  //  Test the boundary -65535 of jz instruction
	  @Test (expected = InvalidInstructionException.class) 
	  public void jzInstructionInvalidInvalueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R0 -65536;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | v + pc < 0 }
	  @Test (expected = NoReturnValueException.class) 
	  public void jzInstructionInvalidPositionTest_low() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jz R0 -1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | v + pc = 0 }
	  // Can't test because of infinite loop
	  
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | v + pc = progLength}
	  @Test 
	  public void jzInstructionValidPositionTest_high()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jz R0 1;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | v + pc > progLength }
	  @Test (expected = NoReturnValueException.class) 
	  public void jzInstructionInvalidPositionTest_high() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jz R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | R > 0 }
	  @Test public void jzInstructionRegisterHigherZeroTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("jz R1 2;");
		  list.add("ret R0;");
		  list.add("ret R2");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | R < 0 }
	  @Test public void jzInstructionRegisterLowerZeroTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R4 -1;");
		  list.add("jz R4 2;");
		  list.add("ret R0;");
		  list.add("ret R2");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }

	  // Test a invalid input, valid covered above
	  @Test (expected = InvalidInstructionException.class) 
	  public void unrecognisedInstructionInvalidValueTest()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("move R0 0;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  

	  // Test an empty input, valid covered above
	  @Test public void emptyInstructionInvalidValueTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("         ");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  

	  // Test a no return input, valid covered above
	  @Test  (expected = NoReturnValueException.class) 
	  public void noReturnTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
}
