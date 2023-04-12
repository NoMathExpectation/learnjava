package nme.cs209a.lab8;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SpaceInvaderGame extends Application {

  private final Pane root = new Pane();

  Random random = new Random();

  private final Sprite player = new Sprite(300, 750, 40, 40, "player", Color.BLUE);

  public static void main(String[] args) {
    launch(args);
  }

  private Parent createContent() {
    root.setPrefSize(600, 800);

    root.getChildren().add(player);

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        update();
      }
    };

    timer.start();

    createEnemies();

    return root;
  }

  private void createEnemies() {
    for (int i = 0; i < 5; i++) {
      Sprite s = new Sprite(90 + i * 100, 150, 30, 30, "enemy", Color.RED);

      root.getChildren().add(s);
    }
  }

  private List<Sprite> sprites() {
    return root.getChildren().stream().map(n -> (Sprite) n).collect(Collectors.toList());
  }

  private void update() {

    sprites().forEach(s -> {
      switch (s.type) {

        case "enemybullet":
          // enemy's bullet moves down
          s.moveDown();

          // enemy's bullet hits the player
          if (s.getBoundsInParent().intersects(player.getBoundsInParent())) {
            player.dead = true; // player is dead
            s.dead = true; // bullet is dead
          }

          break;

        case "playerbullet":

          s.moveUp();

          break;

        case "enemy":
          if (sprites().stream().filter(s1 -> s1.type.equals("playerbullet")).anyMatch(s1 -> s1.getBoundsInParent().intersects(s.getBoundsInParent()))) {
            s.dead = true;
          }

          if (random.nextInt(25) == 0) {
            shoot(s);
          }
          break;
      }
    });

    // remove dead sprites from the screen
    root.getChildren().removeIf(n -> {
      Sprite s = (Sprite) n;
      return s.dead;
    });

  }

  private void shoot(Sprite who) {
    if (who.dead) {
      return;
    }
    // a rectangle with width 5, which looks like a bullet
    Sprite s = new Sprite((int) who.getTranslateX() + 20, (int) who.getTranslateY(), 5, 20, who.type + "bullet", Color.BLACK);

    root.getChildren().add(s);
  }

  @Override
  public void start(Stage stage) {
    Scene scene = new Scene(createContent());

    scene.setOnKeyPressed(e -> {
      switch (e.getCode()) {
        case LEFT:
          player.moveLeft();
          break;
        case RIGHT:
          player.moveRight();
          break;
        case UP:
          player.moveUp();
          break;
        case DOWN:
          player.moveDown();
          break;
        case SPACE:
          shoot(player);
          break;
      }
    });

    stage.setScene(scene);
    stage.show();
  }

  private static class Sprite extends Rectangle {
    final String type;
    boolean dead = false;

    Sprite(int x, int y, int w, int h, String type, Color color) {
      super(w, h, color);

      this.type = type;
      setTranslateX(x);
      setTranslateY(y);
    }

    void moveLeft() {
      setTranslateX(getTranslateX() - 5);
    }

    void moveRight() {
      setTranslateX(getTranslateX() + 5);
    }

    void moveUp() {
      setTranslateY(getTranslateY() - 5);
    }

    void moveDown() {
      setTranslateY(getTranslateY() + 5);
    }
  }
}