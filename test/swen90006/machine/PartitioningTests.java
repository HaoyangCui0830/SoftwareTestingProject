package swen90006.machine;

import java.util.List;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;

import org.junit.*;
import static org.junit.Assert.*;

public class PartitioningTests
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

	  // EC10
	  // Test a valid input of add instruction.
	  // Partitioning class is { ret Ra; | Ra （ REGISTER }
	  @Test public void retInstructionValidTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // EC11
	  // Test a invalid input of add instruction.
	  // Partitioning class is { ret Ra; | Ra not （ REGISTER }
	  @Test (expected = InvalidInstructionException.class) 
	  public void retInstructionInvalidTest()
	  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("ret R-1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC12
	  // Test a valid input of add instruction.
	  // Partitioning class is { mov Ra V; | Ra （ REGISTER V （ VALUE }
	  @Test public void movInstructionValidTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	 
	  // EC13
	  // Test a invalid input of add instruction.
	  // Partitioning class is { mov Ra V; | Ra not （ REGISTER }
	  @Test (expected = InvalidInstructionException.class) 
	  public void movInstructionInvalidRegisterTest()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("ret R-1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC14
	  // Test a invalid input of add instruction.
	  // Partitioning class is { mov Ra V; | V>65535 }
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
	  
	  // EC15
	  // Test a invalid input of add instruction.
	  // Partitioning class is { mov Ra V; | V <-65536 }
	  @Test (expected = InvalidInstructionException.class) 
	  public void movInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 -65537;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC1
	  // Test a valid input of add instruction.
	  // Partitioning class is { add Ra Rb Rc; | Ra Rb Rc （ REGISTER }
	  @Test public void addInstructionValidTest()
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
	  
	  // EC2
	  // Test a invalid input of add instruction.
	  // Partitioning class is { add Ra Rb Rc; | Ra or Rb or Rc not （ REGISTER}
	  @Test (expected = InvalidInstructionException.class) 
	  public void addInstructionInvalidRegisterTest()
			  throws Throwable
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
	  
	  // EC3
	  // Test a valid input of sub instruction.
	  // Partitioning class is { sub Ra Rb Rc; | Ra Rb Rc （ REGISTER }
	  @Test public void subInstructionValidTest()
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
	 
	  // EC4
	  // Test a invalid input of sub instruction.
	  // Partitioning class is { sub Ra Rb Rc; | Ra or Rb or Rc not （ REGISTER}
	  @Test (expected = InvalidInstructionException.class) 
	  public void subInstructionInvalidRegisterTest()
			  throws Throwable
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
	  
	  // EC5
	  // Test a valid input of mul instruction.
	  // Partitioning class is { mul Ra Rb Rc; | Ra Rb Rc （ REGISTER }
	  @Test public void mulInstructionValidTest()
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
	 
	  // EC6
	  // Test a invalid input of mul instruction.
	  // Partitioning class is { mul Ra Rb Rc; | Ra or Rb or Rc not （ REGISTER}
	  @Test (expected = InvalidInstructionException.class) 
	  public void mulInstructionInvalidRegisterTest()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mul R32 R1 R2;");
		  list.add("ret R32;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC7
	  // Test a valid input of div instruction.
	  // Partitioning class is { div Ra Rb Rc; | Ra Rb Rc （ REGISTER and Rc is not equal to 0}
	  @Test public void divInstructionValidTest()
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
	  
	  // EC8
	  //Test a invalid input of div instruction.
	  // Partitioning class is { div Ra Rb Rc; | Ra Rb Rc （ REGISTER and Rc is equal to 0}
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
	 
	  // EC9
	  // Test a valid input of div instruction.
	  // Partitioning class is { div Ra Rb Rc; | Ra or Rb or Rc not （ REGISTER}
	  @Test (expected = InvalidInstructionException.class) 
	  public void divInstructionInvalidRegisterTest()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("div R-1 R1 R2;");
		  list.add("ret R-1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC16
	  //Test a valid input of ldr instruction.
	  // Partitioning class is { ldr Ra Rb v; | Ra Rb （ REGISTER and V （ VALUE Rb + V （(0, 65535) }
	  @Test public void ldrInstructionValidTest()
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
	 
	  //EC17
	  // Test a invalid input of ldr instruction.
	  // Partitioning class is { ldr Ra Rb v; | Ra or Rb not （ REGISTER}
	  @Test (expected = InvalidInstructionException.class) 
	  public void ldrInstructionInvalidRegisterTest()
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
	  
	  // EC18
	  // Test a invalid input of ldr instruction.
	  // Partitioning class is { ldr Ra Rb v; | v >65335  }
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
	  
	  // EC19
	  // Test a invalid input of ldr instruction.
	  // Partitioning class is { ldr Ra Rb v; | v <-65336  }
	  @Test (expected = InvalidInstructionException.class) 
	  public void ldrInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("ldr R1 R0 -65537;");
		  list.add("ret R1;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC20
	  // Test a valid input of ldr instruction.
	  // Partitioning class is { ldr Ra Rb v; | R + v <0 }
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
	  
	  // EC21
	  // Test a valid input of ldr instruction.
	  // Partitioning class is { ldr Ra Rb v; | R + v >65335  }
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
	  
	  // EC22
	  // Test a valid input of str instruction.
	  // Partitioning class is { str Rb v Ra ; | Ra Rb （ REGISTER and V （ VALUE Rb + V （(0, 65535) }
	  @Test public void strInstructionValidTest()
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
	 
	  // EC23
	  // Test a invalid input of str instruction.
	  // Partitioning class is { str Ra v Rb ; | Ra or Rb not （ REGISTER}
	  @Test (expected = InvalidInstructionException.class) 
	  public void strInstructionInvalidRegisterTest()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 0 R32;");
		  list.add("ldr R3 R0 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC24
	  // Test a invalid input of str instruction.
	  // Partitioning class is { str Ra v Rb ; | v > 65535}
	  @Test (expected = InvalidInstructionException.class) 
	  public void strInstructionInvalidValueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 65536 R32;");
		  list.add("ldr R3 R0 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC25
	  // Test a invalid input of str instruction.
	  // Partitioning class is { str Ra v Rb ; | v < -65535}
	  @Test (expected = InvalidInstructionException.class) 
	  public void strInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("mov R1 1;");
		  list.add("mov R2 2;");
		  list.add("mov R3 0;");
		  list.add("str R0 -65537 R32;");
		  list.add("ldr R3 R0 0;");
		  list.add("ret R3;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC26
	  // Test a valid input of str instruction.
	  // Partitioning class is { str Rb v Ra ; | Ra Rb （ REGISTER and V （ VALUE Rb + V < 0 }
	  @Test public void strInstructionValidAddress_low()
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
	  
	  // EC27
	  // Test a valid input of str instruction.
	  // Partitioning class is { str Rb v Ra ; | Ra Rb （ REGISTER and V （ VALUE Rb + V > 65535 }
	  @Test public void strInstructionValidAddress_high()
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
	  
	  // EC28
	  // Test a valid input of jmp instruction.
	  // Partitioning class is { jmp v; | v （ VALUE }
	  @Test public void jmpInstructionValidTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 2;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	 
	  // EC29
	  // Test a invalid input of jmp instruction.
	  // Partitioning class is { jmp v ; | v > 65535}
	  @Test (expected = InvalidInstructionException.class) 
	  public void jmpInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 65536;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC30
	  // Test a invalid input of jmp instruction.
	  // Partitioning class is { jmp v ; | v < -65536}
	  @Test (expected = InvalidInstructionException.class) 
	  public void jmpInstructionInvalidValueTest_high()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 65536;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC31
	  // Test an invalid input of jmp instruction.
	  // Partitioning class is { jmp v; | v < 0 }
	  @Test (expected = NoReturnValueException.class) 
	  public void jmpInstructionInvalidPositionTest_low() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp -1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // EC32
	  // Test an invalid input of jmp instruction.
	  // Partitioning class is { jmp v; | v > progLength }
	  @Test (expected = NoReturnValueException.class) 
	  public void jmpInstructionInvalidPositionTest_high() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jmp 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC33
	  // Test a valid input of jz instruction.
	  // Partitioning class is { jz Ra v; | Ra （ REGISTER and v （ VALUE }
	  @Test public void jzInstructionValidTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R0 2;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // EC34
	  // Test a invalid input of jz instruction.
	  // Partitioning class is { jz Ra v; | Ra not （ REGISTER and v （ VALUE }
	  @Test (expected = InvalidInstructionException.class) 
	  public void jzInstructionInvalidRegisterTest()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R32 2;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC35
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz Ra v; | Ra （ REGISTER and v  > 65535 }
	  @Test (expected = InvalidInstructionException.class) 
	  public void jzInstructionInvalidValueTest_high()
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
	  
	  // EC36
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz Ra v; | Ra （ REGISTER and v  > 65535 }
	  @Test (expected = InvalidInstructionException.class) 
	  public void jzInstructionInvalidValueTest_low()
			  throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0");
		  list.add("jz R0 -65537;");
		  list.add("mov R0 1;");
		  list.add("mov R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC37
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
	  
	  // EC38
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
	  
	  // EC39
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | v < 0 }
	  @Test (expected = NoReturnValueException.class) 
	  public void jzInstructionInvalidPositionTest_low() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jz R0 -1;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 2);
	  }
	  
	  // EC40
	  // Test an invalid input of jz instruction.
	  // Partitioning class is { jz R v; | v > progLength }
	  @Test (expected = NoReturnValueException.class) 
	  public void jzInstructionInvalidPositionTest_high() throws Throwable
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("jz R0 2;");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  // EC41
	  // Test a invalid input
	  // Partitioning class is { s | s is a string which is not equal to any style above } 
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
	  
	  // EC42
	  // Test an empty input
	  // Partitioning class is { s | s is a string which only contain ＾ ￣ }
	  @Test public void emptyInstructionInvalidValueTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  list.add("         ");
		  list.add("ret R0;");
		  Machine m = new Machine();
		  assertEquals(m.execute(list), 0);
	  }
	  
	  // EC43
	  // Test a no return input
	  // Partitioning class is No return class
	  @Test  (expected = NoReturnValueException.class) 
	  public void noReturnTest()
	  {
		  List<String> list = new ArrayList<String>();
		  list.add("mov R0 0;");
		  Machine m = new Machine();
		  m.execute(list);
	  }
	  
	  
	  


	  private List<String> readInstructions(String file)
	  {
	    Charset charset = Charset.forName("UTF-8");
	    List<String> lines = null;
	    try {
	      lines = Files.readAllLines(FileSystems.getDefault().getPath(file), charset);
	    }
	    catch (Exception e){
	      System.err.println("Invalid input file! (stacktrace follows)");
	      e.printStackTrace(System.err);
	      System.exit(1);
	    }
	    return lines;
	  }
}
