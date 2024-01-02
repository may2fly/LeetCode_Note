/**
 * 71. 简化路径
 * 
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 1、始终以斜杠 '/' 开头。
 * 2、两个目录名之间必须只有一个斜杠 '/' 。
 * 3、最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 4、此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
*/

/**
 * 解题思路（了解）：
 * 1、将字符串按'/'进行切分，得到一个字符串数组
 * 2、遍历数组，判断是否为'.'或'..'，如果是，则删除该元素
 * 3、将数组重新拼接成字符串，并返回
*/
class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");

        //使用双向队列，涉及到入栈和出栈操作，以及先进先出操作
        Deque<String> stack = new LinkedList<>();
        for(String name : names){
            if("..".equals(name)){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if(name.length() > 0 && !".".equals(name)){
                stack.offerLast(name);
            }
        }

        StringBuffer sb = new StringBuffer();
        if(stack.isEmpty()){
            sb.append("/");
        }else{
            while(!stack.isEmpty()){
                sb.append("/");
                sb.append(stack.pollFirst());
            }
        }

        return sb.toString();
    }
}