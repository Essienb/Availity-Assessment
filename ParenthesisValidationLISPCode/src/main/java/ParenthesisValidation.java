

public class ParenthesisValidation {


    public static boolean validate(String exp){
        int result = 0; // Counter

        for(int i = 0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            //if open or close Brackets
            if(ch == '(' || ch ==')'){
                if(ch == '(')  //if open
                    result++;   //increment
                else
                    result--;    //otherwise decrement
            }

        }
        return result == 0;
    }

    public static void main(String[] args) {
        String test = "(defun area-circle(rad)" +
                "(terpri)"
                +"(format t \"Radius: ~5f\" rad)"
                +"(format t \"~%Area: ~10f\" (* 3.141592 rad rad)))"
                +"(area-circle 10)";

        //Test Case: 1
        System.out.println(validate(test));

        //Test Case: 2
        System.out.println(validate(test.substring(0, test.length() - 1)));
    }

}

