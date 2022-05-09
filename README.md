# aktive
Design and implement a simple computer algebra system (CAS)
This CAS should be able to represent and manipulate basic mathematical expressions, but it does not need to be able to parse a string into an expression.

The client wants to be able to represent expressions of the following types:

1. single character symbols, e.g. x or a, where the name of the symbol is any uppercase or lowercase letter.

2. unsigned integers, e.g. 0, 23 or 4327, representing any unbounded, non-negative integer.

3. additive expressions, e.g. x + 1 or 2 - y + 3x, where an arbitrary number of operands are interleaved with the addition (+) and subtraction (-) operators. The operands can be any valid expressions.

4. multiplicative expressions, e.g. 5  a  b or 3  (x + 1) , where an arbitrary number of operands are interleaved with the multiplication () and division () operators. The operands can be any valid expressions. Note that the parentheses in the example above show that the second multiplicand is a nested additive expression. The CAS does not have to explicitly represent parentheses, just the sub-expression nestings that they imply.

Designed data structures which need to represent these expressions in your CAS. Implementation of this design in a language JAVA and have method for allowing the terms in an additive expression to be commuted.

Implementation can be used to represent the expression 2(x - 1) + 5y+z and then convert it to z +2(x - 1) + 5y. Method also convert the original expression to 2(x - 1) + z+ 5y.
