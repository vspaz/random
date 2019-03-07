package class_3;

import java.util.LinkedList;


public class InfixCalculator {

    boolean isDouble(String part) {
        try {
            Double.parseDouble(part);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean isOp(String part) {
        switch (part) {
            case "+":
            case "-":
            case "*":
            case "**":
            case "/":
                return true;
            default:
                return false;
        }
    }

    public String getRet(String expression) {
        String[] mathExpression = expression.split(" ");
        LinkedList<String> stack = new LinkedList<>();
        LinkedList<String> ops = new LinkedList<>();

        String num1, num2;
        for (int i = 0; i < mathExpression.length; i++) {
            if (isDouble(mathExpression[i]))
                stack.push(mathExpression[i]);
            else if (isOp(mathExpression[i]))
                ops.push(mathExpression[i]);
            else if (mathExpression[i].equals(")")) {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ops.pop()) {
                    case "+":
                        stack.push(Double.toString(Double.parseDouble(num1) + Double.parseDouble(num2)));
                        break;
                    case "-":
                        stack.push(Double.toString(Double.parseDouble(num1) - Double.parseDouble(num2)));
                        break;
                    case "*":
                        stack.push(Double.toString(Double.parseDouble(num1) * Double.parseDouble(num2)));
                        break;
                    case "/":
                        stack.push(Double.toString(Double.parseDouble(num1) / Double.parseDouble(num2)));
                        break;
                    case "**":
                        stack.push(Double.toString(Math.pow(Double.parseDouble(num1), Double.parseDouble(num2))));
                        break;
                }
            }

        }
        return stack.pop();
    }
}
