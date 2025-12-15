// Question: https://leetcode.com/problems/design-browser-history/description/

class BrowserHistory {
    private Stack<String> browser;
    private Stack<String> history;
    private boolean isTest;

    private void display(String s) {
        System.out.println(s);
        System.out.println(" * browser: " + browser + "\n * history: " + history);
    }

    public BrowserHistory(String homepage) {
        browser = new Stack<>();
        history = new Stack<>();
        isTest = false;

        if (isTest) {
            display("homepage | homepage: " + homepage + "\n - before:");
        }
        browser.push(homepage);
        if (isTest) {
            display("\n - after:");
            System.out.println("-----------------------------------");
        }
    }

    public void visit(String url) {
        if (isTest) {
            display("visit | url: " + url + "\n - before:");
        }
        history.clear();
        browser.push(url);
        if (isTest) {
            display("\n - after:");
            System.out.println("-----------------------------------");
        }
    }

    public String back(int steps) {
        if (isTest) {
            display("back | steps: " + steps + "\n - before:");
        }
        while (steps-- > 0 && browser.size() > 1) {
            history.push(browser.pop());
        }
        if (isTest) {
            display("\n - after:");
            System.out.println("\n result: " + browser.peek());
            System.out.println("-----------------------------------");
        }

        return browser.peek();
    }

    public String forward(int steps) {
        if (isTest) {
            display("forward | steps: " + steps + "\n - before:");
        }
        while (steps-- > 0 && !history.isEmpty()) {
            browser.push(history.pop());
        }
        if (isTest) {
            display("\n - after:");
            System.out.println("\n result: " + browser.peek());
            System.out.println("-----------------------------------");
        }

        return browser.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */