/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
*/

/**
 * 解题思路：
 * 1、定义罗马数字与阿拉伯数字映射关系，使用HashMap存储。
 * 2、遍历字符串，将每个字符与下一个字符比较，如果当前字符比下一个字符大，则减去当前字符的值；否则加上当前字符的值。
*/
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int ans = 0;
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(i<s.length()-1 && map.get(ch) < map.get(s.charAt(i+1))){
                ans -= map.get(ch);
            }else{
                ans += map.get(ch);
            }
        }

        return ans;
    }
}