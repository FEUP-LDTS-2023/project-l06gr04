package org.example.states;
import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.Window;
import org.example.gui.WindowInterface;
import org.example.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StateTest {

    private State<TestModel> testState;
    private TestModel testModel;
    private Viewer<TestModel> mockViewer;
    private Controller<TestModel> mockController;
    private Window mockWindow;

    @BeforeEach
    void setUp() {
        testModel = new TestModel();
        mockViewer = Mockito.mock(Viewer.class);
        mockController = Mockito.mock(Controller.class);
        mockWindow = Mockito.mock(Window.class);
        testState = new State<TestModel>(testModel, mockWindow) {
            @Override
            protected Viewer<TestModel> getViewer() {
                return mockViewer;
            }

            @Override
            protected Controller<TestModel> getController() {
                return mockController;
            }
        };
    }

    @Test
    void getModel_ShouldReturnModel() {
        assertEquals(testModel, testState.getModel());
    }

    @Test
    void draw_ShouldCallViewerDraw() throws IOException, URISyntaxException {
        testState.draw(mockWindow);
        verify(mockViewer, times(1)).draw(mockWindow);
    }

    @Test
    void step_ShouldCallControllerStepAndViewerDraw() throws Exception {
        when(mockWindow.processKey()).thenReturn(WindowInterface.KEY.UP);

        testState.step(new Game(), mockWindow, 100L);
        verify(mockController, times(1)).step(any(), any(), anyLong());
        verify(mockViewer, times(1)).draw(mockWindow);
    }

    private static class TestModel {
        // Define any necessary fields or methods for your test model
    }
}
