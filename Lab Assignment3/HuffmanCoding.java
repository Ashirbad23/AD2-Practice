import java.util.PriorityQueue;
import java.util.HashMap;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = right = null;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class HuffmanCoding {

    public static HashMap<Character, String> generateHuffmanCodes(char[] characters, int[] frequencies) {
        HashMap<Character, String> hC = new HashMap<>();

        PriorityQueue<HuffmanNode> pQ = new PriorityQueue<>();
        for (int i = 0; i < characters.length; i++) {
            pQ.offer(new HuffmanNode(characters[i], frequencies[i]));
        }

        while (pQ.size() > 1) {
            HuffmanNode left = pQ.poll();
            HuffmanNode right = pQ.poll();

            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;

            pQ.offer(newNode);
        }

        generateCodes(pQ.peek(), "", hC);

        return hC;
    }

    private static void generateCodes(HuffmanNode root, String code, HashMap<Character, String> hC) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            hC.put(root.data, code);
            return;
        }

        generateCodes(root.left, code + "0", hC);
        generateCodes(root.right, code + "1", hC);
    }

    public static void main(String[] args) {
        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] frequencies = {5, 9, 12, 13, 16, 45};

        HashMap<Character, String> hC = generateHuffmanCodes(characters, frequencies);

        System.out.println("Huffman Codes:");
        for (char c : hC.keySet()) {
            System.out.println(c + ": " + hC.get(c));
        }
    }
}
