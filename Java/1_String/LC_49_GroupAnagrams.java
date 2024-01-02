/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
*/

/**
 * 解题思路：
 * 对字符串排序，转换为Key值，保存对应key值的字符串数组
 * 
*/

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String str : strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);

            String key = new String(chArr);

            List<String> list = map.getOrDefault(key, new ArrayList<>());

            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}