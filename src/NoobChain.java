import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {
    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
    
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        // loop through blockchain to check hashes
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            // compare registered hash and calculated hash
            if (!currentBlock.hash.equals(currentBlock.calculatehash())) {
                System.err.println("Current hashes not equal");
                return false;
            }
            // compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.err.println("Previious Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
