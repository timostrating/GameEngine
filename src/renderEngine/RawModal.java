package renderEngine;

/**
 * Created by Sneeuwpopsneeuw on 29-Sep-17.
 */
public class RawModal {

    private int vaoID;          // Vertex Array Object ID
    private int vertexCount;    // The amount of vertexes the model has

    public RawModal(int vaoID, int vertexCount) {
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;
    }

    public int getVaoID() {
        return vaoID;
    }

    public int getVertexCount() {
        return vertexCount;
    }
}
