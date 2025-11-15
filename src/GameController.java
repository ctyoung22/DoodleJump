public class GameController {
    GameModel model;
    GameView view;
    
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        setQuitAction();
        setupDoodle();
    }

    public void setQuitAction() {
        view.getQuitBtn().setOnAction(e -> {
            System.exit(0);
        });
    }

    public void setupDoodle() {
        view.updateView(model.getDoodX(), model.getDoodY());
    }
}
