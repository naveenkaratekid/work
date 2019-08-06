
from flask import Flask
from MathCalc import MathCalc

app = Flask(__name__)

# Simple
@app.route('/')
def hello():
    greeting = "<p style=\"font-family:Arial, sans-serif; \">Welcome to the Python Calculator and String Manipulator App!<br><br>Here are the functions available to use in this application:</p><br>"
    
    instructionsGreeting = "<br>Greeting you by name<br>" + "<b>PATH: CURRENT URL PATH + /name/</b><br><pre>    1. The page should return the text \"Hello There! *YOUR NAME*.</pre>" + "<pre>         <i><b>Example: name = \"Marcus\". Result on the page would show: Hello there Marcus!</i></b></pre>"
 
    instructionsFeeling = "<br>Greeting you by name and describing how you are currently feeling<br>" + "<b>PATH: CURRENT URL PATH + /name/feeling</b><br><pre>    1. The page should return the text \"Hello There! *YOUR NAME*. You're feeling *YOUR FEELING*\"</pre>" + "<pre>         <i><b>Example: name = \"Marcus\", feeling = \"grrrreat\". Result on the page would show: Hello there Marcus! You're feeling grrrreat!</i></b></pre>"
    
    instructionsMath = "<br><br>Online Calculator<br>" + "<b>PATH: CURRENT URL PATH + /calculator/a/b/op</b><br><pre>    1. Enter the first number (a), second number (b), and desired math operation:<b><i>(NOTE: If you are performing a square root, simply set b to 0.5)</i></b> <p style = \"text-indent: 150px; font-size: 20px;\"><b>(+, -, *, div, pow, %, hex, bin)</b></p>\t" + "and the page should return both numbers with the operation between them, and the actual result of the operation</pre>" + "<pre>         <i><b>Example: a = 2, b = 4, op = +. Result on the page would show: 2 + 4 = 6</b></i></pre>"
    
    instructionsStrReverse = "<br><br>Reverse a String<br>" + "<b>PATH: CURRENT URL PATH + /name/reverse</b><br><pre>    1. Returns the original text with in reverse: *REVERSED TEXT* </pre>" + "<pre>         <b><i>Example: name = \"Moby\". Result on the web page would show: Moby in reverse is yobM</i></b></pre>"

    instructionsStrPal = "<br><br>Determine if a string is a palindrome or not (Takes lowercase letters into account by converting all letters to lowercase)<br>" + "<b>PATH: CURRENT URL PATH + /name/palindrome</b><br><pre>    1. The page should return the result:         <p style =\"text-indent: 75px; font-size: 15px;\"><b>\"Is *name* a palindrome?\"</b></p></pre>" + "<pre><p style=\"text-indent: 75px; font-size: 15px;\"><b>The answer is (true / false)</p></b></pre>" + "<pre>         <b><i>Example: \"madam\". Result on the page would show:<pre>          Is madam a palindrome?</pre>" + "<pre>           The answer is True</i></b></pre>"

    combined = greeting + instructionsGreeting + instructionsFeeling + instructionsMath + instructionsStrReverse + instructionsStrPal
    
    return combined

@app.route('/<name>')
def helloThere(name):
    return "<font size = \"16\">Hello there " + name + "!</font>\n"

@app.route('/<name>/<feeling>')
def helloThereFeeling(name, feeling):
    return "<font size = \"16\">Hello there " + name + "!<br>"+ "You're feeling " + feeling + "!</font><br>"

# Tad more complex
@app.route('/calculator/<a>/<b>/<op>')
def math(a, b, op):
    calc = MathCalc(a,b,op) 
    return "<font size = \"16\">" + calc.calculate(a,b,op) + "</font>"


# Simple
@app.route('/<name>/reverse')
def reverse(name):
    return "<font size = \"16\">" + name + " reversed is: " + name [::-1] + "</font>"

# Simple
@app.route('/<name1>/palindrome')
def palindrome(name1):
    name1 = name1.lower()
    return "<font size = \"16\">Is " + name1 + " a palindrome?<br> The answer is " + str(name1 == name1[::-1]) + "</font>"


if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True)

