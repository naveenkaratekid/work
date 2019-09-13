Welcome to the Python Calculator and String Manipulator App! Here are the functions available to use in this application:
    
  1.   Greeting you by name
        PATH: CURRENT URL PATH + /name/
            1. The page should return the text \"Hello There! *YOUR NAME*      
                Example: name = "Marcus". 
                    Result on the page would show: "Hello there Marcus!
 
  2.  Greeting you by name and describing how you are currently feeling
        PATH: CURRENT URL PATH + /name/feeling
            1. The page should return the text "Hello There! *YOUR NAME*. You're feeling *YOUR FEELING*"
                Example: name = "Marcus", feeling = "grrrreat". 
                    Result on the page would show: "Hello there Marcus! You're feeling grrrreat!"
    
  3.  Online Calculator 
        PATH: CURRENT URL PATH + /calculator/a/b/op
            1. Enter the first number (a), second number (b), and desired math operation:
            (NOTE: If you are performing a square root, simply set b to 0.5)
            (+, -, *, div, pow, %, hex, bin) and the page should return both numbers with the operation between them, and the actual result of the operation
                Example: a = 2, b = 4, op = +
                    Result on the page would show: 2.0 + 4.0 = 6.0
    
  4.  Reverse a String
        PATH: CURRENT URL PATH + /name/reverse
            1. Returns the original text with in reverse: *REVERSED TEXT* 
                Example: name = "Moby" 
                    Result on the web page would show: "Moby in reverse is yobM"

  5.  Determine if a string is a palindrome or not (Takes lowercase letters into account by converting all letters to lowercase
        PATH: CURRENT URL PATH + /name/palindrome
            1. The page should return the result: "Is *name* a palindrome?" + 
               The answer is (true / false)
                Example: "madam".
                    Result on the page would show: "Is madam a palindrome?" + "The answer is True"

