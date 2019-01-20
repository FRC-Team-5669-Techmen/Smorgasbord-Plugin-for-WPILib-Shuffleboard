package edu.boscotech.smorgasbord.camera;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

@Description(name = "Camera Info", dataTypes = CameraData.class)
@ParametrizedController("SimpleCameraWidget.fxml")
public final class SimpleCameraWidget extends SimpleAnnotatedWidget<CameraData> {
  @FXML
  private Pane root;
  @FXML
  private Label xLabel;
  @FXML
  private Label yLabel;

  @FXML
  private void initialize() {
    // dataOrDefault is a field in SimpleAnnotatedWidget that's a EasyBind object
    // containing either the data source's value or the default value for
    // this widget's data type, if no source is present
    // In this case, it holds a Point2D object
    xLabel.textProperty().bind(
      dataOrDefault
        .map(CameraData::getFps)
        .map(Number::toString));
    yLabel.textProperty().bind(
      dataOrDefault
        .map(CameraData::getQuality)
        .map(Number::toString));
  }

  @Override
  public Pane getView() {
    return root;
  }
}