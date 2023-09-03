package linkedlist;

/**
 * 1472. Design Browser History
 *
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
 *
 * Implement the BrowserHistory class:
 *
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 */
public class BrowserHistory {

    ListNode head;
    ListNode current;

    public BrowserHistory(String homepage) {
        this.head = new ListNode(homepage);
        current = head;
    }

    public void visit(String url) {
        ListNode node = new ListNode(url);
        current.forward = node;
        current.forward.backward = current;
        current = current.forward;
    }

    public String back(int steps) {
        while (steps > 0 && current.backward != null) {
            current = current.backward;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.forward != null) {
            current = current.forward;
            steps--;
        }
        return current.url;
    }

    static class ListNode {
        String url;
        ListNode forward;
        ListNode backward;
        public ListNode(String url) {
            this.url = url;
        }
    }
}
