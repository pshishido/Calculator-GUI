/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pshishido
 */
public class EndOp extends Operator{
    public int priority(){
        //priority of -1 to denote bottom of stack by peeking the priority
        return -1;
    }
    
    //execute should never be invoked by endOp
    public Operand execute(Operand op1, Operand op2){
        return null;
    }
}
