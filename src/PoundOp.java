/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pshishido
 */
public class PoundOp extends Operator{
    public int priority(){
        return 0;
    }
    
    //execute should never be invoked by poundOp
    public Operand execute(Operand op1, Operand op2){
        return null;
    }
}
