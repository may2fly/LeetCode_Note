/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);

            if(ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');
            }else{
                //栈是非空的，要先判断栈是否是空的，空栈也是false
                if(!stack.isEmpty() && stack.peek() == ch){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}