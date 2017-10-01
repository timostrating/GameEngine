package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModal;
import renderEngine.Renderer;

/**
 * Created by Sneeuwpopsneeuw on 28-Sep-17.
 */
public class MainGameLoop {

    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        float[] vertices = {
                0f,     0.5f,   0f,
                -0.5f,  -0.5f,  0f,
                0.5f,   -0.5f,  0f,
        };

        RawModal modal = loader.loadToVAO(vertices);


        while (!Display.isCloseRequested()) {  // main Game loop
            //prepare
            renderer.prepare();

            // render
            renderer.render(modal);

            DisplayManager.updateDisplay();
        }

        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
