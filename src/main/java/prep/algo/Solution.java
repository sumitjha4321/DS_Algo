package prep.algo;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by sumit.jha on 14/10/18.
 */
public class Solution {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[100009]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static class Node implements Comparable<Node> {
        Integer x, y;

        public Node(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node node) {
            int temp = this.x.compareTo(node.x);
            if (temp != 0) {
                return temp;

            }
            return this.y.compareTo(node.y);
        }
    }

    static int getMaxIdx(List<Integer> list) {
        int ans = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > ans) {
                ans = list.get(i);
                idx = i;
            }
        }
        return idx;
    }

    static int getMinIdx(List<Integer> list) {
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < ans) {
                ans = list.get(i);
                idx = i;
            }
        }
        return idx;
    }

    static int countSpecialElements(List<List<Integer>> matrix) {

        int row = matrix.size();
        int col = matrix.get(0).size();

        Set<Node> set = new TreeSet<>();

        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(matrix.get(i).get(j));
            }
            set.add(new Node(i, getMinIdx(list)));
            set.add(new Node(i, getMaxIdx(list)));
        }

        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(matrix.get(j).get(i));
            }
            set.add(new Node(getMinIdx(list), i));
            set.add(new Node(getMaxIdx(list), i));
        }

        return set.size();


    }

    public static void main(String[] args) {

        System.out.println(countSpecialElements(Arrays.asList(
                Arrays.asList(1, 3, 4),
                Arrays.asList(5, 2, 9), Arrays.asList(8, 7, 6))));

    }

}
