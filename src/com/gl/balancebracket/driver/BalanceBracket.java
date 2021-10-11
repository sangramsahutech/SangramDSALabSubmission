package com.gl.balancebracket.driver;
import java.util.*;

public class BalanceBracket {
	    static boolean chkBracketsBalanced(String x1){
	        Deque<Character> stack
	            = new ArrayDeque<Character>();

	        for (int i = 0; i < x1.length(); i++)
	        {
	            char ch = x1.charAt(i);
	 
	            if (ch == '(' || ch == '[' || ch == '{')
	            {
	                stack.push(ch);
	                continue;
	            }

	            if (stack.isEmpty())
	                return false;
	            char check;
	            switch (ch) {
	            case ')':
	                check = stack.pop();
	                if (check == '{' || check == '[')
	                    return false;
	                break;
	 
	            case '}':
	                check = stack.pop();
	                if (check == '(' || check == '[')
	                    return false;
	                break;
	 
	            case ']':
	                check = stack.pop();
	                if (check == '(' || check == '{')
	                    return false;
	                break;
	            }
	        }
	        return (stack.isEmpty());
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	    	System.out.println("Please enter a string: ");
	    	Scanner sc = new Scanner(System.in);
	        String expr = sc.next();
	        if (chkBracketsBalanced(expr))
	            System.out.println("The entered String has Balanced Brackets ");
	        else
	            System.out.println("The entered Strings do not contain Balanced Brackets");
	    }
	}
