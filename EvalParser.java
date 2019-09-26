import java.util.ArrayList;

public class EvalParser {
  Scanner scan;
  ArrayList<Scanner.Token> tokenList;   // List of Tokens extracted from the scanner
  Scanner.TokenType lookahead;          // TokenType (NUM, DIV...) of current lookahead token
  int lookpos = 0;                      // Position of lookahead token in tokenList<>

  int tempID = 0;
  String threeAddressResult = "";

  /***************** Three Address Translator ***********************/
  // TODO #2 Continued: Write the functions for E/E', T/T', and F. Return the temporary ID associated with each subexpression and
  //                    build the threeAddressResult string with your three address translation

  /****************************************/

  /**
   * Parses all the productions of E.
   */
  private int E() {
    int out = 0;

    System.out.println("  E()...");

    out += T();
    while(true) {
      if (lookahead.equals(Scanner.TokenType.PLUS)) {
        System.out.println("  E(): Reached terminal: " + tokenList.get(lookpos).toString());
        match();

        // Perform addition
        out += T();
        continue;
      }
      else if (lookahead.equals(Scanner.TokenType.MINUS)) {
        System.out.println("  E(): Reached terminal: " + tokenList.get(lookpos).toString());
        match();

        // Perform subtraction
        out -= T();
        continue;
      }
      break;
    }

    return out;
  }

  /**
   * Parses all the productions of T.
   */
  private int T() {
    int out = 0;

    System.out.println("  T()...");

    out += F();
    while(true) {
      if (lookahead.equals(Scanner.TokenType.MUL)) {
        System.out.println("  T(): Reached terminal: " + tokenList.get(lookpos).toString());
        match();

        // Perform multiplication on everything
        out = out * F();
        continue;
      } else if (lookahead.equals(Scanner.TokenType.DIV)) {
        System.out.println("  T(): Reached terminal: " + tokenList.get(lookpos).toString());
        match();

        // Perform division on everything
        out = out / F();
        continue;
      }
      break;
    }

    return out;
  }

  /**
   * Parses all the productions of F.
   */
  private int F() {
    int out = 0;

    // Handle '( E )'
    if (lookahead.equals(Scanner.TokenType.LP)) {
      System.out.println("  F(): Reached terminal: " + tokenList.get(lookpos).toString());
      match();

      // Return all calculation that happened within the parentheses
      out += E();

      System.out.println("  F(): Reached terminal: " + tokenList.get(lookpos).toString());
      match();
    }
    // Handle 'num'
    else if (lookahead.equals(Scanner.TokenType.NUM)) {
      // For now, just print out the value of the terminal.
      System.out.println("  F(): Reached terminal: " + tokenList.get(lookpos).toString());

      // Return value of this number terminal
      out += Integer.parseInt(tokenList.get(lookpos).tokenVal);
      match();
    }

    return out;
  }

  /**
   * ???
   * Increments the current lookahead token. This may or may not be what it is supposed to do, but
   * things work this way.
   */
  private void match() {
    if (lookpos < tokenList.size() - 1) {
      lookpos++;
      lookahead = tokenList.get(lookpos).tokenType;
    }
  }

  /***************** Simple Expression Evaluator ***********************/
  // TODO #1 Continued: Write the functions for E/E', T/T', and F. Return the expression's value

  /****************************************/

  /* TODO #1: Write a parser that can evaluate expressions */
  public int evaluateExpression(String eval) {
    // Get scanner to extract tokens.
    try {
    scan = new Scanner();
    tokenList = scan.extractTokenList(eval);
    }
    // Handle illegal tokens
    catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }

    // Print tokens
    System.out.print("\nReceived tokens: ");
    for (int x = 0; x < tokenList.size(); x++) {
      System.out.print(tokenList.get(x).toString());
    }
    System.out.print("\n");
    System.out.println("\nParse through the expression:");

    // Parse through the tree that made all the tokens
    lookpos = 0;
    lookahead = tokenList.get(0).tokenType;
    int evaluation = E();

    // After parsing through tree, print the result
    System.out.print("\n");
    System.out.println("Final result: " + evaluation);

    // Return result that was calculated while parsing the tree
    return evaluation;
  }

  /* TODO #2: Now add three address translation to your parser*/
  public String getThreeAddr(String eval) {
    this.threeAddressResult = "";
    return this.threeAddressResult;
  }

}
