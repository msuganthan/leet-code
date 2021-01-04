package array;

import java.util.LinkedList;
import java.util.List;

public class OrderedStream {

    String[] stream;
    int ptr;
    OrderedStream(int n) {
        stream = new String[n + 1];
        ptr    = 1;
    }

    List<String> insert(int id, String value) {
        stream[id] = value;

        List<String> result = new LinkedList<>();
        while (ptr < stream.length && stream[ptr] != null)
            result.add(stream[ptr++]);
        return result;
    }
}
