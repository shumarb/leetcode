// Question: https://leetcode.com/problems/simplify-path/description/

class SimplifyPath {
    public String simplifyPath(String path) {
        boolean isTest = false;
        Stack<String> stack = new Stack<>();
        String[] pathComponents = path.split("/");

        if (isTest) {
            System.out.println("path: " + path + "\npathComponents: " + Arrays.toString(pathComponents));
        }

        for (String component: pathComponents) {
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