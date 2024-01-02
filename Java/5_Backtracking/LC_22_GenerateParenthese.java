/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //回溯遍历
        generateParenthesisHelp(result, n, n, "");
        
        return result;
    }

    private void generateParenthesisHelp(List<String> result, int left, int right, String parentheses){
        //当左右值都为0时，说明已经生成最后的结果
        if(left == 0 && right == 0){
            result.add(parentheses);
            return;
        }

        if(left == right){//左右相等是需要生成左括号
            generateParenthesisHelp(result, left-1, right, parentheses+"(");
        }else if(left < right){//左右不相等，需要生成右括号或者左括号还有可以继续生成
            generateParenthesisHelp(result, left, right-1, parentheses+")");
            if(left > 0){
                generateParenthesisHelp(result, left-1, right, parentheses+"(");
            }
        }
        //右括号大于左括号时已经非法，不处理此种情况
    }
}