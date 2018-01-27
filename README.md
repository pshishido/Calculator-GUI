# Evaluator Expression and GUI

A user-friendly Calculator that handles binary operations utilizing stack data structure. A GUI was implemented as well.

# Introduction:

This first project of CSC 413 Software Development required us to take the existing framework of a partially
completed evaluator expression, and make the necessary changes to create a fully functioning and interactive
expression evaluator; a calculator. In order to properly execute a given expression it is necessary to implement
a hierarchy of order of operations. At a basic level, this idea stems from having one abstract Operator class
that could be extended into the necessary number of sub-classes (-, +, *, /, ^, #,  !). I ended up creating one
extra extension of the Operator class in order to have and EndOfExpressionOperator beyond having the ‘#’ and ‘!’
to use as markers in the operator stack.

# Assumptions:

The main assumptions that I made for this project, in terms of user input, is that all expressions that are
provided by the user are binary; meaning that for each operator there are precisely two operands. Beyond this,
there are no notable assumptions besides assuming balanced parenthesis.

# Implementation Discussion: 

One of my goals with this project was to change as little as possible with the existing framework. I did,
however, make one small change by adding one more extension of the Operator class called “EndOp”. The purpose of
this bogus operator was to simply function as a marker for the bottom of the operatorStack. Initially I see that
you intended for the pound operator to be this marker, but I actually ended up using the pound operator to
denote an open parenthesis, and the exclamation operator to denote a closed parenthesis (essentially I changed
the key for pound operator to ‘(‘ and the key for exclamation operator to ‘)’ in the hash map of operators). I
assigned “EndOp” a priority of -1 which is lower than every other operator so that I never accidently attempt to
operate with a bogus operator, and so I can determine where the operatorStack ends simply by checking priority. 
Another reason for distinguishing between my “PoundOp” and “EndOp” is to accurately know when to stop evaluating
an expression within a set of parenthesis. Initially I was using “PoundOp” for both the end of expression
operator AND the open parenthesis, however I began to run into issues on nested parenthesis (program thinking
it’s the end of expression). After trying to get around this problem for a while I decided it was a better
solution for me to make a new operator to specifically denote the bottom of the operatorStack. After having a
separate operator to denote an open parenthesis it became much simpler to execute the contents of a set of
parenthesis until I see the “PoundOp” (which represents an open parenthesis). I would say handling parenthesis
was definitely the “chunk” of the work needed to get this program functioning correctly.



# Results and Conclusions:

I would say the biggest takeaway I have got from this project is a much better and more concrete understanding
of Abstract classes in Java. Before this project Polymorphism and Inheritance were concepts that I was familiar
with, but definitely struggled with in terms of proper implementation. Working on this project helped me get
over this obstacle, and now I feel much more confident implementing these abstract concepts in real
applications. 

