package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModal;
import renderEngine.Renderer;
import shaders.StaticShader;

/**
 * Created by Sneeuwpopsneeuw on 28-Sep-17.
 */
public class MainGameLoop {

    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, 0.5f, 0,     // VO
                -0.5f, -0.5f, 0,    // V1
                0.5f, -0.5f, 0,     // V2
                0.5f, 0.5f, 0f      // V3
        };

        int[] indices = {
                0,1,3,  // Top left triangle (V0, V1, V3)
                3,1,2   // Bottom right triangle (V3, V1, V2)
        };

        RawModal modal = loader.loadToVAO(vertices, indices);


        while (!Display.isCloseRequested()) {  // main Game loop
            renderer.prepare();

            shader.start();
                renderer.render(modal);
            shader.stop();

            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
