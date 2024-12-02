import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var data = getAllLines("data.txt");
        PuzzleResolver puzzleResolver = new PuzzleResolver(data);
        var resultCombination = puzzleResolver.resolvePuzzle();
        System.err.println(resultCombination);
    }

    private static List<String> getAllLines(String inputFile) {
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(Paths.get(inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}