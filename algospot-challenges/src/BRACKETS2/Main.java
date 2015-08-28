package BRACKETS2;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jhbang on 2015. 8. 26..
 */
public class Main {
    public static String isWellMatched(StringBuilder bracket) {

        String result = "YES";
        Stack<Character> bracketStack = new Stack<Character>();

        for (int i = 0; i < bracket.length(); i++) {
            char inputChar = bracket.charAt(i);
            if(inputChar=='('||inputChar=='{'||inputChar=='['){
                bracketStack.push(matchBracket(inputChar));
            }else{
                if(bracketStack.empty()){
                    result = "NO";
                    break;
                }else{
                    if(inputChar != bracketStack.peek()){
                        result = "NO";
                        break;
                    }
                    else{
                        bracketStack.pop();
                    }

                }
            }
        }

        if(!bracketStack.empty())
            result="NO";

        return result;
    }

    public static char matchBracket(char bracket){
        char result=' ';
        switch (bracket){
            case '(':
                result = ')';
                break;
            case '{':
                result = '}';
                break;
            case '[':
                result = ']';
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        StringBuilder bracket;
        while (cases-- > 0) {
            bracket = new StringBuilder(sc.nextLine());
            System.out.println(isWellMatched(bracket));
        }
    }
}
