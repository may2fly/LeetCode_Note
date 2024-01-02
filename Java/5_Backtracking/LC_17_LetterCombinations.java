/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
*/

/**
 * 解题思路：回溯法，先遍历数字，获取对应数组的对应字符，遍历字符串，将字符串添加到结果中
*/

class Solution {
    String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) return result;

        backTracking(result, digits, 0, new StringBuffer());

        return result;
    }

    public void backTracking(List<String> res, String digits, int startIndex, StringBuffer sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        for(int i=startIndex; i<digits.length(); i++){
            String str = letters[digits.charAt(i) - '0'];
            
            for(int j=0; j<str.length(); j++){
                sb.append(str.charAt(j));
                backTracking(res, digits, i+1, sb);//这里遍历开始位置从digit的下一个开始
                sb.deleteCharAt(sb.length()-1); //StringBuilder的删除函数deleteCharAt
            }
        }
    }
}