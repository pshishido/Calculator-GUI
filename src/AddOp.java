/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pshishido
 */
public class AddOp extends Operator{
    
    public int priority() {
        return 2;
    }
    //adding value of op1 and op2, creating an operator with that new value. same idea for each operator
    public Operand execute(Operand op1, Operand op2) {

        int res;
        res = op1.value + op2.value;
        Operand newOp = new Operand(res);
        return newOp;
    
    }
}
