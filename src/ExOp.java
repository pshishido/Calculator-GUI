/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pshishido
 */
public class ExOp extends Operator{
    public int priority(){
        return 1;
    }
    
    //execute should never be invoke by an exOp
    public Operand execute(Operand op1, Operand op2){
        return null;
    }
}
