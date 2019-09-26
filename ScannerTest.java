/**
 * Eric Najork, Laan Rose
 * CSC 453
 * Programming Assignment 2
 */
public class ScannerTest {

  /* Quick test of token extraction*/
  public static void testTokenExtraction() {
    System.out.println("*******************************************");
    System.out.println("Testing Token Extraction");
    Scanner test = new Scanner();

        /*String result = test.extractTokens("123 (");
        String expected = "|NUM: 123||LP: (|";
        System.out.println(result);
        assert(result.equals(expected));*/

        /*result = test.extractTokens("+ 3 3");
        expected = "|PLUS: +||NUM: 3||NUM: 3|";
        //System.out.println(expected);
        assert(result.equals(expected));

        result = test.extractTokens("+ - * / < >");
        expected = "|PLUS: +||MINUS: -||MUL: *||DIV: /||LT: <||GT: >|";
        //System.out.println(expected);
        assert(result.equals(expected));

        result = test.extractTokens("<= - >=");
        expected = "|LTE: <=||MINUS: -||GTE: >=|";
        //System.out.println(expected);
        assert(result.equals(expected));

        //Extra test cases I made- not official cases from the TA
        // No whitespace
        result = test.extractTokens("<=->=");
        expected = "|LTE: <=||MINUS: -||GTE: >=|";
        //System.out.println(expected);
        assert(result.equals(expected));

        // Lots of whitespace
        result = test.extractTokens("     ( )   <=-  >=");
        expected = "|LTE: <=||MINUS: -||GTE: >=|";
        System.out.println(expected);
        //assert(result.equals(expected));*/

    System.out.println("Congrats: preliminary token extraction tests passed! Now make your own test cases " +
      "(this is only a subset of what we will test your code on)");
    System.out.println("*******************************************");
    System.out.println();
  }

    /*public static void main(String[] args){
        testTokenExtraction();
    }*/

}