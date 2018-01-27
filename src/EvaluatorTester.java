public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();
    String[] test = {"2+3+(9*5)^4" , "2*2/1-2+5^2" , "((7+1)+2)^3" , "2+3*(5^6*7+4)" , "((9+1)+2*1-2^2)^4"};

    for ( String arg : test ) {
      System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
      //System.out.println( arg + " = " + evaluator.eval( arg ) );
    }
  }
}
