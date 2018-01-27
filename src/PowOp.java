/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pshishido
 */
public class PowOp extends Operator{
    public int priority(){
        return 4;
    }
    
    //because who needs math.pow when you have for loops...
    public Operand execute(Operand op1, Operand op2){
        int res = 1;
        for(int i = 1; i <= op2.value; i++){
            res *= op1.value;
        }
        Operand newOp = new Operand(res);
        return newOp;
    }

}
