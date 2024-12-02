import java.util.ArrayList;
import java.util.List;

public class PuzzlePiece {

    private String start = "";
    private String middle = "";
    private String end = "";

    private List<PuzzlePiece> possibleConnections = new ArrayList<>();
    private boolean visited = false;

    public PuzzlePiece() {} 
    public PuzzlePiece(String line) {
        this.start = line.substring(0, 2);
        this.middle = line.substring(2, 4);
        this.end = line.substring(4, 6);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addPossibleConnection(PuzzlePiece piece) {
        possibleConnections.add(piece);
    }

    public List<PuzzlePiece> getPossibleConnections() {
        return possibleConnections;
    }

    public boolean canBeConnected(PuzzlePiece piece) {
        return this.end.equals(piece.start);
    }

    public String toString() {
        return start + middle + end;
    }

    public String getStart() {
        return start;
    }

    public String getMiddle() {
        return middle;
    }

    public String getEnd() {
        return end;
    }
}