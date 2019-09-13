import math

class MathCalc:
    
    def __init__(self, a, b, op):
        self.a = a
        self.b = b
        self.op = op

    def calculate(self, a, b, op):
        inta = float(self.a)
        intb = float(self.b)
        if op == 'div':
            if(intb == 0 or b == '0'):
                return "Cannot divide by zero. Try again"
            else:
                return str(inta) + " / " + str(intb) + " = " + str((inta / intb))

        elif op == '*':
            return str(inta) + " * " + str(intb) + " = " + str(inta * intb)
    
        elif op == '+':
            return str(inta) + " + " + str(intb) + " = " + str(inta + intb)
    
        elif op == '-':
            return str(inta) + " - " + str(intb) + " = " + str(inta - intb)
    
        elif op == '%':
            return str(inta) + " % " + str(intb) + " = " + str(inta % intb) 

        elif op == 'pow':
            powa = float(self.a)
            powb = float(self.b)
            print(powb)
            print(powa)
            return str(inta) + " ^ " + str(intb) + " = " + str(pow(inta, intb))
    
        elif op == 'hex':
            return str(inta) + " in hex is " + str(hex(inta)) + " | " + str(intb) + " in hex is " + hex(intb)

        elif op == 'bin':
            return str(inta) + " in binary is: " + str(bin(inta)) + " | " + str(intb) + " in binary is: " + str(bin(intb))
        