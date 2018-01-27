
public class Operand {
    
  int value;
  String token;
  
  public Operand( String token ) {
      this.token = token;
      value = Integer.parseInt(this.token);
      setValue(value);
  }

  //useful in each of the operator classes to quick create an operator
  public Operand( int value ) {
      this.value = value;
  }

  //getter, use this when i print out the result
  public int getValue() {
      return value;
  }
  
  //setter
  public void setValue(int val){
      this.value = val;
  }

  public static boolean check( String token ) {
    
    //if the token cant be parsed into an int, it is not a operand
    try{
        Integer.parseInt(token);
    }catch(Exception e){
        return false;
    }
    return true;

  }
}
