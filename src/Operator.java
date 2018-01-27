import java.util.*;

public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );
    
    
  //initialize the hashmap. key is a string and values are of type operator
  private static HashMap <String, Operator> hmap = new HashMap<>();
  
  //helps pair an operator in the form of a string to the appropriate operator in the hashmap
  public static Operator findOp(String token){
      Operator newOp = hmap.get(token);
      return newOp;
  }
  
  //the static initializer that souza hinted to us in class 
  static { 
    hmap.put("(", new PoundOp());
    hmap.put(")", new ExOp());     
    hmap.put("+", new AddOp());
    hmap.put("-", new SubOp());
    hmap.put("*", new MultOp());
    hmap.put("/", new DivOp());
    hmap.put("^", new PowOp());
    hmap.put("&", new EndOp());//chose '&'for no particular reason, this is a bogus op
    
}

  public abstract int priority();
  
  public abstract Operand execute( Operand op1, Operand op2 );
  
  //if the token is any of the operators ret. true
  public static boolean check( String token ) {
    
      boolean check = token.matches("[-()*/^+]");
      return check;
  }
}
