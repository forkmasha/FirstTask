import java.util.ArrayList;
import java.util.List;

public class PuzzleResolver {

    private List<PuzzlePiece> puzzlePieces;
    private PuzzlePiece rootPiece = new PuzzlePiece();
    private List<PuzzlePiece> longestPath = new ArrayList<>();

    public PuzzleResolver(List<String> data) {
        puzzlePieces = new ArrayList<>();
        for (var line : data) {
            puzzlePieces.add(new PuzzlePiece(line));
        }
    }

    public String resolvePuzzle() {
        findPossibleConnections();
        findLongestPath(rootPiece, new ArrayList<>());
        return formatLongestPath();
    }

    private void findPossibleConnections() {  
        for (PuzzlePiece currPiece : puzzlePieces) {
            for (PuzzlePiece possiblePiece : puzzlePieces) {
                if (currPiece != possiblePiece && currPiece.canBeConnected(possiblePiece)) {
                    currPiece.addPossibleConnection(possiblePiece);
                }
            }
            rootPiece.addPossibleConnection(currPiece);
        }
    }

    private void findLongestPath(PuzzlePiece currentPiece, List<PuzzlePiece> currentPath) {
        currentPiece.setVisited(true);
        currentPath.add(currentPiece);

        boolean allConnectionsExplored = true;
        for (PuzzlePiece nextPiece : currentPiece.getPossibleConnections()) {
            if(nextPiece.isVisited()) {
                continue;
            }
            allConnectionsExplored = false;
            findLongestPath(nextPiece, currentPath);
        }

        if (allConnectionsExplored && currentPath.size() > longestPath.size()) {
            longestPath = new ArrayList<>(currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
        currentPiece.setVisited(false);
    }

    private String formatLongestPath() {
        StringBuilder resultString = new StringBuilder();
        PuzzlePiece firstPiece = longestPath.get(1);
        resultString.append(firstPiece.getStart())
                    .append(firstPiece.getEnd());

        for (int i = 2; i < longestPath.size(); i++) {
            PuzzlePiece currentPiece = longestPath.get(i);
            resultString.append(currentPiece.getMiddle())
                        .append(currentPiece.getEnd());
        }

        return resultString.toString();
    }
}