import java.util.*;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  
  //had to add "(" and ")" to the delimeters to handle parenthesis
  private static final String DELIMITERS = "+-*^/#!()";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval( String expression ) {
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    // TODO Operator is abstract - this will need to be fixed:
    // operatorStack.push( new Operator( "#" ));
    
    
    //pushing as a marker for beginning of expression (i.e. the end of operatorStack)
    operatorStack.push(new EndOp());
    
    // When is it a good time to add the "!" operator?
    //---> I use the ExclamationOp to know when to execute the contents 
    //---> of the parenthesis (it is essentially ")"), I never push it.

    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } else {
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            System.exit( 1 );
          }
          // TODO Operator is abstract - these two lines will need to be fixed:
          // The Operator class should contain an instance of a HashMap,
          // and values will be instances of the Operators.  See Operator class
          // skeleton for an example.
          
          //this is how I get around not being able to instantiate an abstract class
          Operator newOperator = Operator.findOp(token);
          
          //this is used to take note of the case when newOperator is a ")"
          //I do not want to push the ExclamationOp
          int isExOp = 0;
          
          //made slight adjustments to the conditions of the while so that
          //it also enters newOperator is a closed parenthesis (i.e. the exclam op)
          while (operatorStack.peek().priority() >= newOperator.priority() || isExOp == 0 && newOperator.priority() == 1) {
            // note that when we eval the expression 1 - 2 we will
            // push the 1 then the 2 and then do the subtraction operation
            // This means that the first number to be popped is the
            // second operand, not the first operand - see the following code

            //if newOperator is an ExOp ")" 
            if(newOperator.priority() == 1){
                
                //i will execute until i see the open parenthesis (i.e. the pound op)
                while(operatorStack.peek().priority() != 0){
                    Operator prevOp = operatorStack.pop();
                    Operand op2 = operandStack.pop();
                    Operand op1 = operandStack.pop();
                    operandStack.push(prevOp.execute(op1, op2));   
                }
                
                //want to pop the open parenthesis so that it is not on the stack for lastEval
                operatorStack.pop();
                
                //denote newOp is an open parenthsis (dont want to push)
                isExOp = 1;
                break;
            }else if(newOperator.priority() == 0){
                
                //if newOp is an open parenthesis we will push it (but do NOT want to execute, so we break)
                break;
            }else{
            
                //souzas code
                Operator oldOpr = operatorStack.pop();
                Operand op2 = operandStack.pop();
                Operand op1 = operandStack.pop();
                operandStack.push( oldOpr.execute( op1, op2 ));  
            }
            
          }//end while2
          
          
          //push the newOp unless its a closed prenthesis (will cause issues in lastEval)
          if(newOperator.priority() != 1  && isExOp == 0){
              operatorStack.push( newOperator );
          }
          
          
        }//end else
      }
    }//end while1

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop; also, move the stacks out of the main
    // method
    
    return lastEval();
  }
  
  
  //used to completed the final evaluation(s)
  //will execute until it sees the EndOp
  public int lastEval(){
      
      while((!operatorStack.isEmpty()) && operatorStack.peek().priority() != -1){
         
        //get the next op off stack, grab two operands and execute (souzas code)    
        Operator opr = operatorStack.pop();
        Operand op2 = operandStack.pop();
        Operand op1 = operandStack.pop();
        operandStack.push(opr.execute(op1,op2));
        }
      
      //the last value on the operandStack is the result
      return operandStack.pop().getValue();
}
  
}