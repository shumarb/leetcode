// Question: https://leetcode.com/problems/simplify-path/description/

class SimplifyPath {
    public String simplifyPath(String path) {
        boolean isTest = false;
        Stack<String> stack = new Stack<>();

        for (String component: path.split("/")) {
            // 1. Remove current directory if component == ".." and stack is non-empty
            if (component.equals("..") && !stack.isEmpty()) {
                stack.pop();

                // 2. Add valid path components
            } else if (!component.equals("") && !component.equals("..") && !component.equals(".")) {
                stack.push(component);
            }
        }
        if (isTest) {
            System.out.println("stack: " + stack);
        }

        return "/" + String.join("/", stack);
    }
}