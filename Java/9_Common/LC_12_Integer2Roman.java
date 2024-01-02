/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 *  I             1
 *  V             5
 *  X             10
 *  L             50
 *  C             100
 *  D             500
 *  M             1000
*/

/**
 * 解题思路：
 * 1、定义罗马数字的数组和对应的字符数组
 * 2、循环遍历罗马数字数组，当num/当前数字的数值不为0时，将对应的字符添加到sb中，num减去当前数字
*/

class Solution {
    public String intToRoman(int num) {
        int[] romanNum = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSign = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<romanNum.length; i++){
            int signV = romanNum[i];
            String signK = romanSign[i];

            while(num/signV != 0){
                sb.append(signK);
                num -= signV;
            } 
        }

        return sb.toString();
    }
}